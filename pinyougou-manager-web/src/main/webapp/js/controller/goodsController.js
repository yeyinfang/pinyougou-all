app.controller('goodsController',function ($scope,$controller,$location,goodsService,itemCatService) {
    //继承
    $controller('baseController',{$scope:$scope});

    //条件查询
    $scope.searchEntity={};
    $scope.findByCondition=function (page,rows) {
        goodsService.findByCondition(page,rows,$scope.searchEntity).success(function (response) {
            //更新数据列表
            $scope.paginationConf.totalItems=response.total;//总记录数
            $scope.list=response.rows;//给列表变量赋值
        });
    }

    //设置状态
    //也就是状态的值
    $scope.status=['未审核','已审核','审核未通过','关闭'];

    //商品分类
    $scope.itemCatList=[];
    $scope.findItemList=function () {
        itemCatService.findAll().success(function (response) {
            for(var i=0;i<response.length;i++){
                $scope.itemCatList[response[i].id ]=response[i].name;
            }
        });
    };
    //定义出实体中有的东西的存在然后根据这个去进行查找
   // $scope.entity = {typeTemplate:{brandIds:[]},goods: {}, goodsDesc: {itemImages: [], specificationItems: [],customAttributeItems:[]}};

    //也就是数据回显的操作
    $scope.findOne=function () {
        //获取到当前的id
        var id = $location.search()['id'];
        //判断id是不是为null
        if(id==null){
            return;
        }
        goodsService.findOne(id).success(function (response) {
           $scope.entity=response;
           //读取文本框
           editor.html($scope.entity.goodsDesc.introduction);
            //显示扩展属性
            $scope.entity.goodsDesc.customAttributeItems=  JSON.parse($scope.entity.goodsDesc.customAttributeItems);
            //读取规格属性
            $scope.entity.goodsDesc.specificationItems=JSON.parse($scope.entity.goodsDesc.specificationItems);
        });
    };

    //根据规格名称和选项名称返回是否被勾选
    $scope.checkAttributeValue=function(specName,optionName){
        var items= $scope.entity.goodsDesc.specificationItems;
        var object= $scope.searchObjectByKey(items,'attributeName',specName);
        if(object==null){
            return false;
        }else{
            if(object.attributeValue.indexOf(optionName)>=0){
                return true;
            }else{
                return false;
            }
        }
    };



    /*
    * 读取一级分类的操作
    * */
    $scope.selectItemCat1List=function () {
        itemCatService.findByParentId(0).success(function (response) {
            $scope.itemCat1List=response;
        })
    };

    /*
    * $watch监测看分类1的id是否有改变
    * */
    $scope.$watch('entity.goods.category1Id',function (newValue,oldValue) {
        itemCatService.findByParentId(newValue).success(function (response) {
            $scope.itemCat2List=response;
        })
    });

    /*
    * 检测看分类2的id是否有改变
    * */
    $scope.$watch('entity.goods.category2Id',function (newValue,oldValue) {
        itemCatService.findByParentId(newValue).success(function (response) {
            $scope.itemCat3List=response;
        })
    });

    /*
    * 监测，然后读到模板的id去进行使用
    * */
    $scope.$watch('entity.goods.category3Id',function (newValue,oldValue) {
        itemCatService.findOne(newValue).success(function (response) {
            $scope.entity.goods.typeTemplateId = response.typeId;
            alert($scope.entity.goods.typeTemplateId)
        })
    });

    //批量进行审核或者是驳回的操作
    $scope.updateStatus=function (status) {
        goodsService.updateStatus($scope.selectedIds,status).success(function (response) {
            if (response.status==0){//成功
                alert(response.message);
                $scope.reloadList();//刷新列表
                $scope.selectedIds=[];//清空ID集合
            }else{
                alert(response.message);
            }
        })
    };



    /* ------以下是会出错的代码-------  */
    /*
    * 在模板id进行选择完之后，获取到模板中的东西
    * */
    //$scope.entity.typeTemplate={brandIds:[]};
    /*$scope.$watch('entity.goods.typeTemplateId',function (newValue,oldValue) {

        /!*根据模板去进行寻找的*!/
        typeTemplateService.findOne(newValue).success(function (response) {
            //获取到类型的模板
            $scope.typeTemplate=response;
            //将获取到的品牌的那些参数,并且转成字符串的类型，为了方便接下来去进行使用
            $scope.typeTemplate.brandIds = JSON.parse($scope.typeTemplate.brandIds);

            //先进行判断是不是存在了id，不存在的话在去获取扩展属性
            //如果没有ID，则加载模板中的扩展数据
            if ($location.search()['id']==null){
                //将获取到扩展属性，转成字符串的类型
                $scope.entity.goodsDesc.customAttributeItems=JSON.parse( $scope.typeTemplate.customAttributeItems);//扩展属性
            }

            //这边是获取到的规格属性
            //$scope.entity.goodsDesc.specificationItems=JSON.parse($scope.typeTemplate.)
        });
        /!*根据规格属性进行找到的，然后赋值过来*!/
        typeTemplateService.findSpecList(newValue).success(function (response) {
            $scope.specList=response;
        })

    });*/
    /*

        /!*
        * 修改规格选项的操作，也就是自己选择或者不选择的问题了
        * *!/
        $scope.updateSpecAttribute=function ($event,name,value) {
            //也就是查询到key的键值
            var object= $scope.searchObjectByKey($scope.entity.goodsDesc.specificationItems ,'attributeName', name);
            //也就是如果这个列表不为空的话，那就进行操作
            if(object!=null){
                //当这个方框被选中的时候，那就添加进去，没有被选中就是代表我这个商品没有这个规格的选择项
                if($event.target.checked){
                    object.attributeValue.push(value);
                }else{//这个情况是我没有选中的情况，也就是商品没有这个属性的
                    object.attributeValue.splice( object.attributeValue.indexOf(value ) ,1);//移除选项
                    //如果没有勾选到这个的话，那就应该将这个记录给删除掉，这样子才不会被保存到数据库中去
                    if(object.attributeValue.length==0){
                        //将这个选项在系统中移除掉
                        $scope.entity.goodsDesc.specificationItems.splice($scope.entity.goodsDesc.specificationItems.indexOf(object),1);
                    }

                }
            }else{//这个是列表是空的情况
                $scope.entity.goodsDesc.specificationItems.push({"attributeName":name,"attributeValue":[value]});
            }
        };

        //创建sku的列表
        $scope.createItemList=function () {
            //这是初始的值，也就是这个列表的参数
            $scope.entity.itemList=[{spec:{},price:0,num:99999,status:'0',isDefault:'0' }];
            //开始进行定义的操作   也就是将规格的选项列表进行复制
            //用户选择的集合
            var items=$scope.entity.goodsDesc.specificationItems;

            //循环遍历
            for (var i=0;i<items.length;i++){
                //不断使用传进去的去尽心个使用   其实就像是一个驴打滚的意思
                $scope.entity.itemList = addColumn($scope.entity.itemList,items[i].attributeName,items[i].attributeValue);
            }
        };
        //增加行数的操作   list:原有的集合   columnName这个是行的名字  columnValue是属性
        addColumn=function (list,columnName,columnValues) {
            //新的集合列表
            var newList=[];
            //首先就是先循环list的长度，拿到原本的集合
            for (var i=0;i<list.length;i++){
                var oldRow=list[i];
                //循环遍历的是属性
                for(var j=0;j<columnValues.length;j++){
                    var newRow=JSON.parse(JSON.stringify(oldRow));//深克隆的操作
                    //将克隆的这个给传递到下面的行去
                    newRow.spec[columnName] = columnValues[j];
                    //加入到新集合
                    newList.push(newRow);
                }
            }
            return newList;
        };
    */



})
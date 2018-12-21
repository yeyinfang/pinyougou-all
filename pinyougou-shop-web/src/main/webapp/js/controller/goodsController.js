//这是商品管理的控制层的
app.controller('goodsController',function ($scope,$controller,goodsService,itemCatService,typeTemplateService,uploadService) {
    //继承
    $controller('baseController',{$scope:$scope});
    /*
    * 增加的操作
    * */
    $scope.addGoods=function () {
        $scope.entity.goodsDesc.introduction=editor.html();
        goodsService.addGoods($scope.entity).success(function (response) {
            if(response.status==0){
                alert(response.message);
                $scope.entity={};//这是清空实体
                editor.html('');//清空编辑器里面的东西
            }else{
                alert(response.message);
            }
        })
    };

    //定义出实体中有的东西的存在然后根据这个去进行查找
    $scope.entity = {typeTemplate:{brandIds:[]},goods: {}, goodsDesc: {itemImages: [], specificationItems: [],customAttributeItems:[]}};
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
        })
    });

    /*
    * 在模板id进行选择完之后，获取到模板中的东西
    * */
    //$scope.entity.typeTemplate={brandIds:[]};
    $scope.$watch('entity.goods.typeTemplateId',function (newValue,oldValue) {
        /*根据模板去进行寻找的*/
        typeTemplateService.findOne(newValue).success(function (response) {
            //获取到类型的模板
            $scope.typeTemplate=response;
            //将获取到的品牌的那些参数,并且转成字符串的类型，为了方便接下来去进行使用
            $scope.typeTemplate.brandIds = JSON.parse($scope.typeTemplate.brandIds);
            //将获取到扩展属性，转成字符串的类型
            $scope.entity.goodsDesc.customAttributeItems=JSON.parse( $scope.typeTemplate.customAttributeItems);//扩展属性
            //这边是获取到的规格属性
            //$scope.entity.goodsDesc.specificationItems=JSON.parse($scope.typeTemplate.)
        });
        /*根据规格属性进行找到的，然后赋值过来*/
        typeTemplateService.findSpecList(newValue).success(function (response) {
            $scope.specList=response;
        })

    });


    /*
    * 修改规格选项的操作，也就是自己选择或者不选择的问题了
    * */
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

    //上传文件的操作

    $scope.image_entity = {color : '',url : ''}
    $scope.uploadFile = function () {
        uploadService.uploadFile().success(function (response) {
            if(response.status==0){//上传成功的操作
                $scope.image_entity.url=response.message;//设置文件地址
            }else{//上传失败的结果
                alert(response.message);
            }
        })
    };

    //添加图片的操作
    $scope.add_image_entity=function () {
        $scope.entity.goodsDesc.itemImages.push($scope.image_entity);
    }
    
    //移除图片的操作
    $scope.remove_image_entity=function (index) {
        $scope.entity.goodsDesc.itemImages.splice(index,1);
    }


})
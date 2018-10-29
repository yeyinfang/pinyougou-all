//这是商品管理的控制层的
app.controller('goodsController',function ($scope,$controller,goodsService,itemCatService,typeTemplateService) {
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
    }


})
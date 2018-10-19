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
    $scope.$watch('entity.goods.typeTemplateId',function (newValue,oldValue) {

        typeTemplateService.findOne(newValue).success(function (response) {
            //获取到类型的模板
            $scope.typeTemplate=response;
            //将获取到的品牌的那些参数,并且转成字符串的类型，为了方便接下来去进行使用
            $scope.typeTemplate.brandIds = JSON.parse($scope.typeTemplate.brandIds);

        })
    })
})
app.controller('goodsController',function ($scope,$controller,goodsService,itemCatService) {
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

    

})
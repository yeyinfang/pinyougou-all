app.controller('sellerController',function ($scope,$controller,sellerService) {
    //这就相当于继承了父类的操作
    $controller('baseController',{$scope:$scope});//继承

    //查找到所有的
    $scope.findAll=function () {
        sellerService.findAll().success(function (response) {
            $scope.list=response;
        })
    };

    //条件查询
    $scope.searchEntity={};
    $scope.findByCondition=function (page,rows) {
        sellerService.findByCondition(page,rows,$scope.searchEntity).success(function (response) {
            //更新数据列表
            $scope.paginationConf.totalItems=response.total;//总记录数
            $scope.list=response.rows;//给列表变量赋值
        })
    }
})
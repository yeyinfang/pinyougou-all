//服务层
app.controller('specificationController',function ($scope,$controller,specificationService) {
    $controller('baseController',{$scope:$scope});

    //查找所有
    $scope.findAll=function () {
        specificationService.findAll().success(function (response) {
            $scope.list = response;
        })
    };

    //条件查询
    $scope.searchEntity={};
    $scope.findByCondition=function (page,rows) {
        specificationService.findByCondition(page,rows,$scope.searchEntity).success(function (response) {
            //更新数据列表
            $scope.paginationConf.totalItems=response.total;//总记录数
            $scope.list=response.rows;//给列表变量赋值
        })
    }

})
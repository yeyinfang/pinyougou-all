//这是控制层
app.controller('itemCatController',function ($scope,$controller,itemCatService) {
    //继承
    $controller('baseController',{$scope:$scope});

    //分页显示
    $scope.findByCondition=function (page,rows) {
        itemCatService.findByCondition(page,rows).success(function (response) {
            //更新数据列表
            $scope.paginationConf.totalItems=response.total;//总记录数
            $scope.list=response.rows;//给列表变量赋值
        })
    };


})
app.controller('contentController',function ($scope,$controller,contentService,uploadService) {
    //控制器继承
    $controller('baseController',{$scope:$scope});

    //分页查询
    //定义出集合也就是搜索对象
    $scope.searchEntity={};
    $scope.findByCondition=function (page,rows) {
        contentService.findByCondition(page,rows,$scope.searchEntity).success(function (response) {
            //更新数据列表
            $scope.paginationConf.totalItems=response.total;//总记录数
            $scope.list=response.rows;//给列表变量赋值
        });
    };

    //根据id去进行查询
    $scope.findOne=function (id) {
        contentService.findOne(id).success(function (response) {
            $scope.entity=response;
        });
    };

    $scope.uploadFile=function () {
        uploadService.uploadFile().success(function (response) {
            if(response.status==0){
                $scope.entity.pic=response.message;
            }else{
                alert(response.message);
            }
        });
    };

})
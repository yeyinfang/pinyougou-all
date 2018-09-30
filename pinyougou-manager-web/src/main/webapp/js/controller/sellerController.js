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
    };

    //根据id去进行查找
    $scope.findById=function (sellerId) {
        sellerService.findById(sellerId).success(function (response) {
            $scope.entity=response;
        })
    };

    //修改状态
    $scope.updateStatus=function (sellerId,status) {
        sellerService.updateStatus(sellerId,status).success(function (response) {
            if (response.status==0){//修改成功
                //刷新列表
                $scope.reloadList();
            }else{
                //失败那就弹窗说明
                alert(response.message);
            }
        })
    };


})
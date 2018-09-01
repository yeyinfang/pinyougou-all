/*这是品牌控制器*/
app.controller('brandController',function ($scope,$controller,brandService) {
    //控制器继承
    $controller('baseController',{$scope:$scope});//继承

    /*
    * 查找到所有的
    * */
    $scope.findAll=function () {
        brandService.findAll().success(function (response) {
            $scope.list = response;
        })
    };
    /*
    * 根据条件查询，也是分页的情况
    * */
    //定义出集合也就是搜索对象
    $scope.searchEntity={};
    $scope.findByCondition=function (page,rows) {
        brandService.findByCondition(page,rows,$scope.searchEntity).success(function (response) {
            //更新数据列表
            $scope.paginationConf.totalItems=response.total;//总记录数
            $scope.list=response.rows;//给列表变量赋值
        })
    };
    /*
    * 根据id查询到品牌信息
    * */
    $scope.findById = function (id) {
        brandService.findById(id).success(function (response) {
            $scope.entity = response;
        })
    };

    /*
    * 增加或者是修改
    * */
    $scope.addBrand = function () {
        brandService.addBrand($scope.entity).success(function (response) {
            if (response.status==0){
                //重新加载，因为添加成功了
                alert(response.message);
                $scope.reloadList();
            }else{
                alert(response.message)
            }
        })
    };

    /*
    * 进行删除的操作
    * */
    $scope.dele=function () {
        brandService.dele($scope.selectedIds).success(function (response) {
            if (response.status==0){
                //刷新列表
                $scope.reloadList();
            }
        })
    };

})
    


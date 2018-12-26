app.controller('contentController',function ($scope,$controller,contentService,uploadService,contentCategoryService) {
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

    //加载广告分类列表
    $scope.findContentCategory=function () {
        contentCategoryService.findAll().success(function (response) {

            $scope.contentCategoryList=response;
        })
    };

    //定义状态
    $scope.status=['无效','有效'];

    //添加或者修改的操作
    $scope.addContent=function () {

        contentService.addContent($scope.entity).success(function (response) {
           if(response.status==0){//成功

               $scope.reloadList();
           }else {//失败
               alert(response.message);
           }
        });
    };

    //删除的操作
    $scope.dele=function () {
        if($scope.selectedIds.length==0){
            alert("请先选择要删除的数据!");
        }else{
            contentService.deleteContent($scope.selectedIds).success(function (response) {
                if(response.status==0){//删除成功
                    alert(response.message);
                    $scope.reloadList();
                }else {//删除失败
                    alert(response.message);
                }
            });
        }

    }
    

})
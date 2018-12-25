app.controller('contentController',function($scope,contentService){

    $scope.contentList=[];//广告集合

	//查询分类
    $scope.findByCategoryId=function (id) {
        contentService.findByCategoryId(id).success(function (response) {
            $scope.contentList[id]=response;
        });
    };

	
});
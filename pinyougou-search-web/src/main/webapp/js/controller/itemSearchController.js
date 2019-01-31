app.controller('itemSearchController',function ($scope,itemSearchService) {
    $scope.search=function(){
        itemSearchService.findItemSearch( $scope.searchMap ).success(
            function(response){
                $scope.resultMap=response;//搜索返回的结果
            }
        );
    }

})
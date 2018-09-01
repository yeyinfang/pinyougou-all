app.controller('baseController',function ($scope) {

    //分页控件的配置
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function(){
            $scope.reloadList();//重新加载
        }
    };

    //重新加载列表 数据
    $scope.reloadList=function(){
        //切换页码
        $scope.findByCondition( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    };

    //复选的操作
    $scope.selectedIds=[];//选中集合的id
    //更新操作
    $scope.updateSelection=function ($event,id) {
        //选中的话就进行添加
        if ($event.target.checked){
            $scope.selectedIds.push(id);
        }else{
            var idx = $scope.selectedIds.indexOf(id) ;
            //进行删除操作
            $scope.selectedIds.splice(idx,1);
        }
    };
})
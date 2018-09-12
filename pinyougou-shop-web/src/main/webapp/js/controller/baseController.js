app.controller('baseController',function ($scope) {
    //重新加载列表 数据
    $scope.reloadList=function(){
        //切换页码
        $scope.findByCondition( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    };

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

    //跟据需求输出json串
    //jsonString要转换的json串,key要读取的值
    $scope.jsonToString = function (jsonString, key) {
        var json = JSON.parse(jsonString);
        var result = "";
        for (var i = 0; i < json.length; i++) {
            if (i > 0) {
                result += ",";
            }
            result += json[i][key];
        }
        return result;
    }
})
//这是商品管理的控制层的
app.controller('goodsController',function ($scope,$controller,goodsService) {
    //继承
    $controller('baseController',{$scope:$scope});
    /*
    * 增加的操作
    * */
    $scope.addGoods=function () {
        $scope.entity.goodsDesc.introduction=editor.html();
        goodsService.addGoods($scope.entity).success(function (response) {
            if(response.status==0){
                alert(response.message);
                $scope.entity={};//这是清空实体
                editor.html('');//清空编辑器里面的东西
            }else{
                alert(response.message);
            }
        })
    }
})
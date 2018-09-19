//这个是商家相关的一个类，也就是申请入住等
app.controller('sellerController',function ($scope,$controller,sellerService) {

   $controller('baseController',{$scope:$scope});//继承

    //添加的操作
    $scope.add=function () {

        sellerService.add($scope.entity).success(function (response) {
            if (response.status==0){
                //这是添加成功
                location.href='shoplogin.html';
            }else{
                //弹出错误信息
                alert(response.message);
            }
        })
    };
})
//这个是商家相关的一个类，也就是申请入住等
app.controller('sellerController',function ($scope,$controller,sellerService,loginService) {

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

    //查找用户名的操作
    $scope.showLoginName=function () {
        loginService.loginName().success(function (response) {
            $scope.loginName = response.loginName;
        })
    };

    //查找的操作
    $scope.findOne=function () {
        sellerService.findOne().success(function (response) {
            $scope.entity=response;
        })
    };

    //修改商家的操作
    $scope.updateSeller=function () {
        //console.log($scope.entity);
        sellerService.update($scope.entity).success(function (response) {
            if (response.status==0){
                //修改成功
                alert(response.message);
                $scope.entity = response.data;
            }else{
                //修改失败
                alert(response.message);
            }
        })
    };

    //修改密码的操作
    $scope.updatePassword=function () {
        //alert(1);
        sellerService.updatePassword($scope.ybpassword,$scope.xgpassword).success(function (response) {
            if(response.status==0){//修改成功
                alert(response.message);
            }else{//修改失败
                alert(response.message);
            }
        })
    };


})
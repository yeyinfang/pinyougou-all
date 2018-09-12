//这是登陆的控制层
app.controller('indexController',function ($scope,$controller,loginService) {

    //显示用户名的操作
    $scope.showLoginName=function () {
        loginService.loginName().success(function (response) {
            $scope.loginName=response.loginName;
        })
    }
})
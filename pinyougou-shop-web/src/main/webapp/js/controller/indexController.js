//这个是对首页的一个初始化显示用户的前段控制层
app.controller('indexController',function ($scope,loginService) {
    //获取到用户名
    $scope.showLoginName=function () {
        loginService.loginName().success(function (response) {
            $scope.loginName=response.loginName;
        })
    };
})
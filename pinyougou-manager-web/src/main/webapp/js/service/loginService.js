//这是登陆的服务的
app.service('loginService',function ($http) {
    //获取到用户名的规则管理
    this.loginName=function () {
        return $http.get("../login/name.do");
    }
})
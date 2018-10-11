//这是登陆的服务层的存在
app.service('loginService',function ($http) {
    this.loginName=function () {
        return $http.get("../login/name.do");
    }
})
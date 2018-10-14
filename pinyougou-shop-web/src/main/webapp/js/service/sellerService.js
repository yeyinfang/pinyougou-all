//这是服务层的
app.service('sellerService',function ($http) {
    //进行添加也就是其实是注册的操作
    this.add=function (entity) {
        return $http.post("../seller/add.do",entity);
    };

    //根据用户的姓名去查找到整个商家的信息
    this.findOne=function (loginName) {
        return $http.get("../seller/findOne.do?loginName="+loginName);
    };

    //修改商家信息的操作
    this.update=function (entity) {
        return $http.post("../seller/update.do",entity);
    };

    //修改密码的操作
    this.updatePassword=function (ybpassword,xgpassword) {
        return $http.get("../seller/updatePassword.do?password="+ybpassword+"&updatepassword="+xgpassword);
    }
})
//这是服务层的
app.service('sellerService',function ($http) {
    //进行添加也就是其实是注册的操作
    this.add=function (entity) {
        return $http.post("../seller/add.do",entity);
    }
})
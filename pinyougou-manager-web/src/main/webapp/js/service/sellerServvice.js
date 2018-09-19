//服务层
app.service('sellerService',function ($http) {
    this.findAll=function () {
        return $http.get("../seller/findAll.do");
    }
})
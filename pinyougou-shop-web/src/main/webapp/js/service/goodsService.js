//这个是商品的前端服务层
app.service('goodsService',function ($http) {
    //增加商品的操作
    this.addGoods=function (entity) {
        return $http.post("../goods/add.do",entity);
    }
})
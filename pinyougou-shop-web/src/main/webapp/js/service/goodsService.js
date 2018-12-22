//这个是商品的前端服务层
app.service('goodsService',function ($http) {
    //增加商品的操作
    this.addGoods=function (entity) {
        return $http.post("../goods/add.do",entity);
    };

    //条件查询的操作
    this.findByCondition=function (page,rows,entity) {
        return $http.post("../goods/findByCondition.do?page="+page+"&rows="+rows,entity);
    };
})
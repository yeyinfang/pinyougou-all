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

    //根据id去进行查询
    this.findOne=function (id) {
        return $http.get("../goods/findOne.do?id="+id);
    };
    
    //更新的操作
    this.update=function (entity) {
        return $http.post("../goods/update.do",entity);
    }
})
app.service('goodsService',function ($http) {
    //条件查询
    this.findByCondition=function (page,rows,entity) {
        return $http.post("../goods/findAll.do?page="+page+"&rows="+rows,entity);
    };
})
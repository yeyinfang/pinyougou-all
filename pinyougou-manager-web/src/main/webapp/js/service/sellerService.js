app.service('sellerService',function ($http) {
    //查找所有
    this.findAll=function () {
        return $http.get("../seller/findAll.do");
    };

    //条件查询
    this.findByCondition=function (page,rows,entity) {
        return $http.post("../seller/findByCondition.do?page="+page+"&rows="+rows,entity);
    };
})
app.service('sellerService',function ($http) {
    //查找所有
    this.findAll=function () {
        return $http.get("../seller/findAll.do");
    };

    //条件查询
    this.findByCondition=function (page,rows,entity) {
        return $http.post("../seller/findByCondition.do?page="+page+"&rows="+rows,entity);
    };

    //查找到商家   根据id去进行查找
    this.findById=function (sellerId) {
        return $http.get("../seller/findOne.do?sellerId="+sellerId);
    };

    //修改状态
    this.updateStatus=function (sellerId,status) {
        return $http.get("../seller/updateStatus.do?sellerId="+sellerId+"&status="+status);
    }
})
app.service('goodsService',function ($http) {
    //条件查询
    this.findByCondition=function (page,rows,entity) {
        return $http.post("../goods/findAll.do?page="+page+"&rows="+rows,entity);
    };

    //数据的回显，也就是详情页面的显示
    this.findOne=function (id) {
        return $http.get("../goods/findOne.do?id="+id);
    };

    //修改状态
    this.updateStatus=function (ids,status) {
        return $http.get("../goods/updateStatus.do?ids="+ids+"&status="+status);
    };

    //逻辑删除的操作
    this.deleteGoods=function (ids) {
        return $http.get("../goods/delete.do?ids="+ids);
    };


})
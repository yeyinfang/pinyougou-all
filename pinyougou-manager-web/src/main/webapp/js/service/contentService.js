app.service('contentService',function ($http) {
    //条件查询
    this.findByCondition=function (page,rows,entity) {
        return $http.post("../content/findByCondition.do?page="+page+"&rows="+rows,entity);
    };

    //查找内容的操作
    this.findOne=function (id) {
        return $http.get("../content/findOne.do?id="+id);
    };
})
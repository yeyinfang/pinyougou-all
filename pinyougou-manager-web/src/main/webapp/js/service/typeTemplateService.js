//这是服务层
app.service('typeTemplateService',function ($http) {
    //查找所有
    this.findAll=function () {
        return $http.get("../typeTemplate/findAll.do");
    }

    //条件查询的操作
    this.findByCondition=function (page,rows,entity) {
        return $http.post("../typeTemplate/findByCondition.do?page="+page+"&rows="+rows,entity);
    }

    //增加的操作
    this.add=function (entity) {
        return $http.post("../typeTemplate/add.do",entity);
    }

})
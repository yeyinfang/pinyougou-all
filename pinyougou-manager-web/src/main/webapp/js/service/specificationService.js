//服务层
app.service('specificationService',function ($http) {
    this.findAll=function () {
        return $http.get("../specification/findAll.do");
    }
    /*条件查询*/
    this.findByCondition=function (page,rows,entity) {
        return $http.post("../specification/findByCondition.do?page="+page+"&rows="+rows,entity)
    }

    /*增加规格*/
    this.addSpecification=function (entity) {
        return $http.post("../specification/add.do",entity);
        
    }
})
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
        var methodName = "add";
        if(entity.specification.id!=null){
            //这个时候应该进行的是修改操作
            methodName = "update";
        }
        return $http.post("../specification/"+methodName+".do",entity);
    }
    /*查询*/
    this.findOne=function (id) {
        return $http.get("../specification/findOne.do?id="+id);
    }

    /*删除的操作*/
    this.dele=function (ids) {
        return $http.get("../specification/delete.do?ids="+ids);
    }

    /*供应给模板的下拉列表的操作*/
    this.selectOptionSpec=function () {
        return $http.get("../specification/selectOptionSpec.do");
    }

    /*增加的操作*/
    this.add=function (entity) {
        return $http.post("../specification/add.do",entity);
    }

})
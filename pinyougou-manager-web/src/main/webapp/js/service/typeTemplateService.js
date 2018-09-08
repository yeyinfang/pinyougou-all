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
        var methodName="add";
        if(entity.id!=null){
            methodName="update";
        }
        return $http.post("../typeTemplate/"+methodName+".do",entity);
    }

    //根据id去找到模板的操作
    this.findOne=function (id) {
        return $http.get("../typeTemplate/findByOne.do?id="+id);
    }

    //删除模板的操作
    this.dele=function (ids) {
        return $http.get("../typeTemplate/delete.do?ids="+ids);
    }

    //下拉列表框的操作，也就是找到名字和id
    this.findTypeList=function () {
        return $http.get("../typeTemplate/findTypeList.do");
    }
})
//这是分类的服务层
app.service('itemCatService',function ($http) {
    //查找到所有的最顶端的分类
    this.findByCondition=function (page,rows) {
        return $http.get("../itemCat/findByCondition.do?page="+page+"&rows="+rows);
    }

    //查找到所有的父类的id
    this.findByParentId=function (parentId) {
        return $http.get("../itemCat/findByParentId.do?parentId="+parentId);
    }

    //增加分类的操作
    this.add=function (entity) {
        entity.typeId = entity.typeId.id;
        var methodName="add";
        if(entity.id!=null){//修改
            methodName="update";
        }
        return $http.post("../itemCat/"+methodName+".do",entity);
    }

    //根据id去进行查询
    this.findById=function (id) {
        return $http.get("../itemCat/findById.do?id="+id);
    }
})
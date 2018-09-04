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
})
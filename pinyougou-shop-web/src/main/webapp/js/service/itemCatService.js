//这是分类的列表
app.service('itemCatService',function ($http) {
    //根据父类id去找到全部分类
    this.findByParentId=function (parentId) {
        return $http.get("../itemCat/findByParentId.do?parentId="+parentId);
    };

    //根据id去进行查找到这个分类中所对应的模板
    this.findOne=function (parentId) {
        return $http.get("../itemCat/findOne.do?parentId="+parentId);
    };

    //查询到所有的
    this.findAll=function () {
        return $http.get("../itemCat/findAll.do");
    }
})
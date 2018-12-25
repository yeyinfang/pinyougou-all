app.service('contentCategoryService',function ($http) {
    //查询全部
    this.findAll=function () {
        return $http.get("../contentCategory/findAll.do");
    };
})
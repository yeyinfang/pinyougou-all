//这是模板的服务层
app.service('typeTemplateService',function ($http) {
    /*
    * 根据模版id去进行查询
    * */
    this.findOne=function (typeId) {
        return $http.get("../typeTemplate/findOne.do?id="+typeId);
    };
})
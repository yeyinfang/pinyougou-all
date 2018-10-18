//这是品牌的服务层
app.service('brandService',function ($http) {
    /*
    * 获取到品牌列表的信息
    * */
    this.findById=function (typeId) {
        return $http.get("../brand/findById.do?typeId="+typeId);
    };
})
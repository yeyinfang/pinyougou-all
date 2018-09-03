//这是品牌的服务层
app.service('brandService',function ($http) {
    /*
    * 查找所有，也就是不进行分页也不进行条件查询
    * */
    this.findAll=function () {
        return $http.get("../brand/findAll.do");
    }
    /*
    * 条件查询，其实也就是分页的情况
    * */
    this.findByCondition=function (page,rows,entity) {
        return  $http.post("../brand/findByCondition.do?page="+page+"&rows="+rows,entity);
    }
    /*
    * 增加品牌的信息
    * 若是存在了id的情况，那就改成修改的作用
    * */
    this.addBrand=function (entity) {
        var method = 'add';
        if (entity.id!=null){
            method = 'update';
        }
        return $http.post("../brand/"+method+".do",entity);
    }
    /*
    * 根据id查找到信息，也就是修改前的回显
    * */
    this.findById = function (id) {
        return $http.get("../brand/findOne.do?id="+id);
    }
    /*
    * 删除品牌
    * */
    this.dele=function (ids) {
        return $http.get("../brand/delete.do?ids="+ids);
    }

    /*
    * 模板上所需要的查询
    * */
    this.selectOptionList=function () {
        return $http.get("../brand/selectOptionList.do");
    }


})
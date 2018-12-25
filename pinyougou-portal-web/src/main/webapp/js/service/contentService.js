app.service('contentService' ,function($http){
    
    //分类查询
    this.findByCategoryId=function (id) {
        return $http.get("../content/findByCategoryId.do?id="+id);
    };
	
});
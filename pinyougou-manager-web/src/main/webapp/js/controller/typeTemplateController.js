//这是控制层
app.controller('typeTemplateController',function ($scope,$controller,typeTemplateService) {
    //继承的关系
    $controller('baseController',{$scope:$scope});

    //查找到所有的模板
    $scope.findAll=function () {
        typeTemplateService.findAll().success(function (response) {
            $scope.list=response;
        })
    };

    //条件查询
    $scope.searchEntity={};
    $scope.findByCondition=function (page,rows) {
        typeTemplateService.findByCondition(page,rows,$scope.searchEntity).success(function (response) {
            //更新数据列表
            $scope.paginationConf.totalItems=response.total;//总记录数
            $scope.list=response.rows;//给列表变量赋值
        })
    };

    //增加的操作
    $scope.add=function () {
        typeTemplateService.add($scope.entity).success(function (response) {
            if (response.status==0){
                //添加成功
                $scope.reloadList();
            }else{
                //添加失败
                alert(response.message);
            }
        })
    };

    //测试时候所用的select的类
    $scope.brandList={data:[{id:1,text:'联想'},{id:2,text:'华为'},{id:3,text:'小米'}]};//品牌列表

})
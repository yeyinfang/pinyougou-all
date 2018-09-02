//服务层
app.controller('specificationController',function ($scope,$controller,specificationService) {
    $controller('baseController',{$scope:$scope});

    //查找所有
    $scope.findAll=function () {
        specificationService.findAll().success(function (response) {
            $scope.list = response;
        })
    };

    //条件查询
    $scope.searchEntity={};
    $scope.findByCondition=function (page,rows) {
        specificationService.findByCondition(page,rows,$scope.searchEntity).success(function (response) {
            //更新数据列表
            $scope.paginationConf.totalItems=response.total;//总记录数
            $scope.list=response.rows;//给列表变量赋值
        })
    };

    //新增一行
    $scope.entity = {specificationOptionList:[]};
    //新增行的实现  也就是增加规格的行列
    $scope.addTableRow=function(){
        $scope.entity.specificationOptionList.push({});
    };

    //批量选项删除
    $scope.deleTablenRow=function(index){
        $scope.entity.specificationOptionList.splice(index,1);//删除
    };

    //增加
    $scope.addSpecification=function () {
        specificationService.addSpecification($scope.entity).success(function (response) {
            if (response.status==0){
                $scope.reloadList();
            }else{
                alert(response.message)
            }
        })
    };

    //根据id去进行到获取的值
    $scope.findOne=function (id) {
        specificationService.findOne(id).success(function (response) {
            //alert(id);
            $scope.entity = response;
            
        })
        
    }

})
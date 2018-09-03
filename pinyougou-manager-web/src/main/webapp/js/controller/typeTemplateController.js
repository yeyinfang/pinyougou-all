//这是控制层
app.controller('typeTemplateController',function ($scope,$controller,typeTemplateService,brandService,specificationService) {
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
    //$scope.brandList={data:[{id:1,text:'联想'},{id:2,text:'华为'},{id:3,text:'小米'}]};//品牌列表

    //也就是品牌列表最开始是为空的
    $scope.brandList={data:[]};//品牌列表
    $scope.findBrandList=function () {
        brandService.selectOptionList().success(function (response) {
            $scope.brandList={data:response};
        })
    };

    //规格列表
    $scope.specList={data:[]};//最开始是为空的
    $scope.findSpecList=function () {
        specificationService.selectOptionSpec().success(function (response) {
            $scope.specList={data:response};
        })
    };

    //添加扩展属性行的操作
    //先获取到现有的属性
    $scope.entity={customAttributeItems:[]};
    $scope.addTableRow=function () {
        //进行添加的操作，也就是将获取到的这个加进去
        $scope.entity.customAttributeItems.push({});
    };

    //移除行的操作
    $scope.deleteTableRow=function (index) {
        $scope.entity.customAttributeItems.splice(index,1);
    };


    //增加的操作
    $scope.add=function () {
        typeTemplateService.add($scope.entity).success(function (response) {
            if (response.status==0){
                //增加成功
                $scope.reloadList();
            }else{
                alert(response.message);
            }
        })
    }

    //根据id进行查找的操作
    $scope.findOne=function (id) {
        typeTemplateService.findOne(id).success(function (response) {
            $scope.entity=response;
            $scope.entity.brandIds=JSON.parse($scope.entity.brandIds);//转换品牌列表
            $scope.entity.specIds=JSON.parse($scope.entity.specIds);//转换规格列表
            $scope.entity.customAttributeItems=JSON.parse($scope.entity.customAttributeItems);//转换扩展属性
        })
    };


    //根据id进行删除的操作
    $scope.dele=function () {
        typeTemplateService.dele($scope.selectedIds).success(function (response) {
            if (response.status==0){
                //刷新列表
                $scope.reloadList();
            }else{
                alert(response.message);
            }
        })
    };

})
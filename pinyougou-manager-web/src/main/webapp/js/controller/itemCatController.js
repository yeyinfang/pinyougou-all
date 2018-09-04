//这是控制层
app.controller('itemCatController',function ($scope,$controller,itemCatService) {
    //继承
    //$controller('baseController',{$scope:$scope});

    //分页显示
   /* $scope.findByCondition=function (page,rows) {
        itemCatService.findByCondition(page,rows).success(function (response) {
            //更新数据列表
            $scope.paginationConf.totalItems=response.total;//总记录数
            $scope.list=response.rows;//给列表变量赋值
        })
    };*/

    //根据父类id去进行查询
    $scope.findByParentId=function (parentId) {
        itemCatService.findByParentId(parentId).success(function (response) {
            $scope.list=response;
        })
    };

    //设置等级
    $scope.grade=1;//也就是目前是1级的情况
    //也就是改变了值的话这边也跟着改变
    $scope.SetGrade=function (value) {
        $scope.grade=value;
    }
    //查询目录级别
    $scope.selectList=function (p_entity) {
        //级别在一的时候
        if ($scope.grade==1){//也就是一级目录
            $scope.entity_1=null;
            $scope.entity_2=null;
        }

        //级别在二的时候
        if ($scope.grade==2){//也就是一级目录
            $scope.entity_1=p_entity;
            $scope.entity_2=null;
        }

        //级别在三的时候
        if ($scope.grade==3){//也就是一级目录
            $scope.entity_2=p_entity;
        }

        $scope.findByParentId(p_entity.id);
    }


})
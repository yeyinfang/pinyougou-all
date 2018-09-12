//这是控制层
app.controller('itemCatController',function ($scope,$controller,itemCatService,typeTemplateService) {
    //继承
    $controller('baseController',{$scope:$scope});

    //分页显示
   /* $scope.findByCondition=function (page,rows) {
        itemCatService.findByCondition(page,rows).success(function (response) {
            //更新数据列表
            $scope.paginationConf.totalItems=response.total;//总记录数
            $scope.list=response.rows;//给列表变量赋值
        })
    };*/

    //记录父类的id
    $scope.parentId=0;//上级ID
    //根据父类id去进行查询
    $scope.findByParentId=function (parentId) {
        //当我进行对应的操作，父类的id就应该要跟着改变
        $scope.parentId=parentId;//进行赋值的操作
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
    };

    //将类型模板下拉初始化
    $scope.typeList={data:[]};//最开始的时候是为空的操作的
    $scope.findTypeList=function () {
        typeTemplateService.findTypeList().success(function (response) {
            $scope.typeList={data:response};
        })
    };

    //增加的操作
    $scope.add=function () {
        //将父类的值进行修改，在进行到增加的操作
        $scope.entity.parentId=$scope.parentId;
        itemCatService.add($scope.entity).success(function (response) {
            if (response.status==0){
                //增加成功的操作,于是应该重新加载一下这个分类下的东西
                $scope.findByParentId($scope.parentId);
            }else{
                //增加失败
                alert(response.message);
            }
        })
    };


    //根据id去进行查找
    $scope.findById=function (id) {
        itemCatService.findById(id).success(function (response) {
            $scope.entity=response;
            //进行下拉列表的回显操作
            for ( var i = 0; i <$scope.typeList.data.length; i++){
                if( $scope.typeList.data[i].id == $scope.entity.typeId){
                    $scope.entity.typeId  = $scope.typeList.data[i];
                }
            }
        });
    };

    //批量删除
    $scope.dele=function () {
        itemCatService.dele($scope.selectedIds).success(function (response) {
            if (response.status==0){//删除成功
                $scope.findByParentId($scope.parentId);
            }else{
                //删除失败
                alert(response.message);
            }
        })
    };

    //刷新的操作
    $scope.reloadList=function () {
        $scope.findByParentId($scope.parentId);
    };

})
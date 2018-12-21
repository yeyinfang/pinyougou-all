//这是下载的service
app.service('uploadService',function ($http) {
    //这是上传文件的操作
    this.uploadFile=function () {
        var formData = new FormData();
        //file 文件上传框的name
        formData.append("file",file.files[0]);
        return $http({
            url:'../upload.do',
            //采取的是什么方法
            method:'post',
            //对应的一个文件的封装
            data:formData,
            //就是头信息
            //上传的是文件的时候必须这么指定，不指定的时候默认是json格式的
            headers: {'Content-Type':undefined},
            //对表单进行二进制进行序列化
            transformRequest: angular.identity
        });
    }
})
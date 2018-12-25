package com.pinyougou.manager.controller;

import com.pingyougou.util.FastDFSClient;
import com.pinyougou.entity.ResponseResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: pinyougou-all
 * @description: 上传图片的操作
 * @author: YF
 * @create: 2018-12-24 20:23
 **/
@RestController
public class UploadController {
    //获取到文件上传服务器的地址
    @Value("${FILE_SERVER_URL}")
    private  String FILE_SERVER_URL;

    @RequestMapping("/upload")
    public ResponseResult upload(MultipartFile file){
        //1.获取到文件的后缀名
        String originalFilename = file.getOriginalFilename();
        String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        try {
            //2.创建出fastdfs的客户端
            FastDFSClient client = new FastDFSClient("classpath:config/fdfs_client.conf");
            //3.执行上传的操作
            String path = client.uploadFile(file.getBytes(), extName);
            //4.获取到url路径，其实也就是我要访问的那个路径的对象
            String url = FILE_SERVER_URL + path;
            return ResponseResult.success(url);
        }catch (Exception e ){
            e.printStackTrace();
            return ResponseResult.error("图片上传失败");
        }

    }





}

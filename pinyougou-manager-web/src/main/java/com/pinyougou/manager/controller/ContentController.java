package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.content.service.ContentService;
import com.pinyougou.entity.ResponseResult;
import com.pinyougou.pojo.TbContent;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @program: pinyougou-all
 * @description:广告内容
 * @author: YF
 * @create: 2018-12-24 17:21
 **/
@RestController
@RequestMapping("/content")
public class ContentController {
    @Reference
    private ContentService contentService;

    /** 
    * @Description: 条件查询，也就是查询所有的信息
    * @Param: [content, page, rows] 
    * @return: java.util.Map<java.lang.String,java.lang.Object> 
    * @Author: Yin 
    * @Date: 2018/12/24 
    */ 
    @RequestMapping("/findByCondition")
    @ResponseBody
    public Map<String,Object> findByCondition(@RequestBody TbContent content,int page,int rows){
        return contentService.findByCondition(content,page,rows);
    }

    /** 
    * @Description: 根据id去进行查询 
    * @Param: [id] 
    * @return: com.pinyougou.pojo.TbContent 
    * @Author: Yin 
    * @Date: 2018/12/25 
    */ 
    @RequestMapping("/findOne")
    @ResponseBody
    public TbContent findOne(Long id){
        return contentService.findOne(id);

    }

    /** 
    * @Description: 修改的操作
    * @Param: [content] 
    * @return: com.pinyougou.entity.ResponseResult<com.pinyougou.pojo.TbContent> 
    * @Author: Yin 
    * @Date: 2018/12/25 
    */ 
    @RequestMapping("/update")
    public ResponseResult<TbContent> updateContent(@RequestBody TbContent content){
        try {
            contentService.updateContent(content);
            return ResponseResult.success("修改成功啦");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.error("修改失败啦，请重试");
        }
    }

    /** 
    * @Description: 添加商品的操作
    * @Param: [content] 
    * @return: com.pinyougou.entity.ResponseResult<com.pinyougou.pojo.TbContent> 
    * @Author: Yin 
    * @Date: 2018/12/25 
    */ 
    @RequestMapping("/add")
    public ResponseResult<TbContent> addContent(@RequestBody TbContent content){
        try {
            contentService.addContent(content);
            return ResponseResult.success("添加成功啦");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.error("添加失败");
        }
    }

    /** 
    * @Description: 批量删除
    * @Param: [ids] 
    * @return: com.pinyougou.entity.ResponseResult<com.pinyougou.pojo.TbContent> 
    * @Author: Yin 
    * @Date: 2018/12/26 
    */ 
    @RequestMapping("/delete")
    public ResponseResult<TbContent> deleteContent(String ids){
        try {
            String[] str = ids.split(",");
            long[] id = new long[str.length];
            for (int i = 0; i < str.length; i++) {
                id[i]=Long.parseLong(str[i]);
            }
            contentService.deleteContent(id);
            return ResponseResult.success("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.error("删除出错");
        }
    }
    
    
}

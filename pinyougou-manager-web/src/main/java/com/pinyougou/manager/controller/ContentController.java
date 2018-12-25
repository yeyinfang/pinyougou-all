package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.content.service.ContentService;
import com.pinyougou.pojo.TbContent;
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

    @RequestMapping("/findOne")
    @ResponseBody
    public TbContent findOne(Long id){
        return contentService.findOne(id);

    }
}

package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbContentCategory;
import com.pinyougou.content.service.ContentCategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: pinyougou-all
 * @description:
 * @author: YF
 * @create: 2018-12-25 11:08
 **/
@RestController
@RequestMapping("contentCategory")
public class ContentCategoryController {

    @Reference
    private ContentCategoryService contentCategoryService;

    /** 
    * @Description: 查询所有的广告分类
    * @Param: [] 
    * @return: java.util.List<com.pinyougou.pojo.TbContentCategory> 
    * @Author: Yin 
    * @Date: 2018/12/25 
    */ 
    @RequestMapping("/findAll")
    public List<TbContentCategory> findAll(){
        return contentCategoryService.findAll();
    }
}

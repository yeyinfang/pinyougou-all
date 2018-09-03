package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.sellergoods.service.TypeTemplateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: pinyougou-all
 * @description: 模板管理的控制层类
 * @author: YF
 * @create: 2018-09-03 09:46
 **/
@RestController
@RequestMapping("/typeTemplate")
public class TypeTemplateController {
    //引入服务层
    @Reference
    private TypeTemplateService typeTemplateService;

    /** 
    * @Description: 查找到所有的信息
    * @Param: [] 
    * @return: java.util.List<com.pinyougou.pojo.TbTypeTemplate> 
    * @Author: Yin 
    * @Date: 2018/9/3 
    */ 
    @RequestMapping("/findAll")
    public List<TbTypeTemplate> findAll(){
        return typeTemplateService.findAll();
    }

}

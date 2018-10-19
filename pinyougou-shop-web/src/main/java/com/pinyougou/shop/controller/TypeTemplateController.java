package com.pinyougou.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.sellergoods.service.TypeTemplateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: pinyougou-all
 * @description:
 * @author: YF
 * @create: 2018-10-18 20:29
 **/
@RestController
@RequestMapping("/typeTemplate")
public class TypeTemplateController {
    @Reference
    private TypeTemplateService typeTemplateService;

    
    /** 
    * @Description: 根据id查找到模板的操作
    * @Param: [id] 
    * @return: com.pinyougou.pojo.TbTypeTemplate 
    * @Author: Yin 
    * @Date: 2018/10/18 
    */ 
    @RequestMapping("/findOne")
    public TbTypeTemplate findOne(Long id){
        return typeTemplateService.findById(id);
    }
}

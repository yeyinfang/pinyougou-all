package com.pinyougou.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.sellergoods.service.TypeTemplateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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
    @ResponseBody
    public TbTypeTemplate findOne(Long id){
        return typeTemplateService.findById(id);
    }

    /** 
    * @Description: 获取到扩展属性的东西，根绝type的id  
    * @Param: [id] 
    * @return: java.util.List<java.util.Map> 
    * @Author: Yin 
    * @Date: 2018/10/25 
    */ 
    @RequestMapping("/findSpecList")
    public List<Map> findSpecList(Long id){
        return typeTemplateService.findSpecList(id);
    }
}


package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.entity.ResponseResult;
import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.sellergoods.service.TypeTemplateService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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

    /** 
    * @Description: 条件查询，也就是分页信息的处理
    * @Param: [page, rows, typeTemplate] 
    * @return: java.util.Map<java.lang.String,java.lang.Object> 
    * @Author: Yin 
    * @Date: 2018/9/3 
    */ 
    @RequestMapping("/findByCondition")
    public Map<String,Object> findByCondition(int page, int rows, @RequestBody TbTypeTemplate typeTemplate){
        return typeTemplateService.findByCondition(page,rows,typeTemplate);
    }

    /** 
    * @Description: 添加模板
    * @Param: [typeTemplate] 
    * @return: com.pinyougou.entity.ResponseResult<com.pinyougou.pojo.TbTypeTemplate> 
    * @Author: Yin 
    * @Date: 2018/9/3 
    */ 
    @RequestMapping("/add")
    public ResponseResult<TbTypeTemplate> addTypeTemplate(TbTypeTemplate typeTemplate){
        try {
            typeTemplateService.addTypeTemplate(typeTemplate);
            return ResponseResult.success("增加成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.error("增加失败");
        }
    }

}

package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbTypeTemplate;

import java.util.List;
import java.util.Map;

public interface TypeTemplateService {
    /** 
    * @Description: 查找到所有的模板信息
    * @Param: [] 
    * @return: java.util.List<com.pinyougou.pojo.TbTypeTemplate> 
    * @Author: Yin 
    * @Date: 2018/9/3 
    */ 
    List<TbTypeTemplate> findAll();

    /** 
    * @Description: 分页查询也就是条件查询 
    * @Param: [page, rows, typeTemplate] 
    * @return: java.util.Map<java.lang.String,java.lang.Object> 
    * @Author: Yin 
    * @Date: 2018/9/3 
    */ 
    Map<String,Object> findByCondition(int page, int rows, TbTypeTemplate typeTemplate);

    /** 
    * @Description: 增加模板的操作 
    * @Param: [typeTemplate] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/9/3 
    */ 
    void addTypeTemplate(TbTypeTemplate typeTemplate);
}

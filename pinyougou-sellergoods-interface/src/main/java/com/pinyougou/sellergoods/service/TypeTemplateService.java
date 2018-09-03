package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbTypeTemplate;

import java.util.List;

public interface TypeTemplateService {
    /** 
    * @Description: 查找到所有的模板信息
    * @Param: [] 
    * @return: java.util.List<com.pinyougou.pojo.TbTypeTemplate> 
    * @Author: Yin 
    * @Date: 2018/9/3 
    */ 
    List<TbTypeTemplate> findAll();
}

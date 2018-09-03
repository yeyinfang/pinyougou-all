package com.pinyougou.mapper;

import com.github.abel533.mapper.Mapper;
import com.pinyougou.pojo.TbTypeTemplate;

import java.util.List;

public interface TbTypeTemplateMapper extends Mapper<TbTypeTemplate> {
    /** 
    * @Description: 查询到所有的模板信息
    * @Param: [] 
    * @return: java.util.List<com.pinyougou.pojo.TbTypeTemplate> 
    * @Author: Yin 
    * @Date: 2018/9/3 
    */ 
    List<TbTypeTemplate> findAll();
}
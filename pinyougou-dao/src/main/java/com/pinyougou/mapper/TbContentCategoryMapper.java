package com.pinyougou.mapper;

import com.github.abel533.mapper.Mapper;
import com.pinyougou.pojo.TbContentCategory;

import java.util.List;

public interface TbContentCategoryMapper extends Mapper<TbContentCategory> {
    /** 
    * @Description: 查询所有的
    * @Param: [] 
    * @return: java.util.List<com.pinyougou.pojo.TbContentCategory> 
    * @Author: Yin 
    * @Date: 2018/12/25 
    */ 
    List<TbContentCategory> findAll();
}
package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbContentCategory;

import java.util.List;

public interface ContentCategoryService {
    /** 
    * @Description: 查询所有的 
    * @Param: [] 
    * @return: java.util.List<com.pinyougou.pojo.TbContentCategory> 
    * @Author: Yin 
    * @Date: 2018/12/25 
    */ 
    List<TbContentCategory> findAll();
}

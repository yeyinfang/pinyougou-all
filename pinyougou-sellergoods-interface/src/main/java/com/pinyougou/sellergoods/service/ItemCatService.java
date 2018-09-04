package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbItemCat;

import java.util.List;
import java.util.Map;

public interface ItemCatService {
    /** 
    * @Description: 显示所有的分类 
    * @Param: [] 
    * @return: java.util.List<com.pinyougou.pojo.TbItemCat> 
    * @Author: Yin 
    * @Date: 2018/9/4 
    */ 
    List<TbItemCat> findAll();

    /** 
    * @Description: 分页查找到，也包括了条件查询
    * @Param: [page, rows, itemCat] 
    * @return: java.util.Map<java.lang.String,java.lang.Object> 
    * @Author: Yin 
    * @Date: 2018/9/4 
    */ 
    Map<String,Object> findByCondition(int page, int rows);
}

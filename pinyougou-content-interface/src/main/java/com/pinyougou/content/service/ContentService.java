package com.pinyougou.content.service;

import com.pinyougou.pojo.TbContent;

import java.util.Map;

public interface ContentService {
    /** 
    * @Description: 条件查询 
    * @Param: [content, page, rows] 
    * @return: java.util.Map<java.lang.String,java.lang.Object> 
    * @Author: Yin 
    * @Date: 2018/12/24 
    */ 
    Map<String,Object> findByCondition(TbContent content, int page, int rows);


    /** 
    * @Description: 根据id去进行查询的操作
    * @Param: [id] 
    * @return: com.pinyougou.pojo.TbContent 
    * @Author: Yin 
    * @Date: 2018/12/24 
    */ 
    TbContent findOne(Long id);
}

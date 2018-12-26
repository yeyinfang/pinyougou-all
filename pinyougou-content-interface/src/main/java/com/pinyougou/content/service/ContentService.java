package com.pinyougou.content.service;

import com.pinyougou.pojo.TbContent;

import java.util.List;
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

    /** 
    * @Description:修改广告的信息
    * @Param: [content] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/12/25 
    */ 
    void updateContent(TbContent content);

    /** 
    * @Description: 添加广告的操作
    * @Param: [content] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/12/25 
    */ 
    void addContent(TbContent content);

    /** 
    * @Description: 查询广告的分类显示
    * @Param: [id] 
    * @return: java.util.List<com.pinyougou.pojo.TbContent> 
    * @Author: Yin 
    * @Date: 2018/12/25 
    */ 
    List<TbContent> findByCategoryId(Long id);

    /** 
    * @Description: 批量删除 
    * @Param: [ids] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/12/26 
    */ 
    void deleteContent(long[] ids);
}

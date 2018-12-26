package com.pinyougou.mapper;

import com.github.abel533.mapper.Mapper;
import com.pinyougou.pojo.TbContent;

import java.util.List;

public interface TbContentMapper extends Mapper<TbContent> {
    /** 
    * @Description: 根据分类id去进行查询
    * @Param: [id] 
    * @return: java.util.List<com.pinyougou.pojo.TbContent> 
    * @Author: Yin 
    * @Date: 2018/12/25
     * @param content
    */ 
    List<TbContent> findByCategoryId(TbContent content);
}
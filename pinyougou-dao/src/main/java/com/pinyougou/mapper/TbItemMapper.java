package com.pinyougou.mapper;

import com.github.abel533.mapper.Mapper;
import com.pinyougou.pojo.TbItem;

public interface TbItemMapper extends Mapper<TbItem> {
    /** 
    * @Description: 添加item的操作
    * @Param: [item] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/11/5 
    */ 
    void addItem(TbItem item);
}
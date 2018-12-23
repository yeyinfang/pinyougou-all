package com.pinyougou.mapper;

import com.github.abel533.mapper.Mapper;
import com.pinyougou.pojo.TbItem;

import java.util.List;

public interface TbItemMapper extends Mapper<TbItem> {
    /** 
    * @Description: 添加item的操作
    * @Param: [item] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/11/5 
    */ 
    void addItem(TbItem item);

    /** 
    * @Description: 根据商品id查询到这个分类
    * @Param: [id] 
    * @return: com.pinyougou.pojo.TbItem 
    * @Author: Yin 
    * @Date: 2018/12/22 
    */
    List<TbItem> findById(Long id);

    /** 
    * @Description: 删除原本的sku列表
    * @Param: [id] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/12/23 
    */ 
    void deleteSku(Long id);
}
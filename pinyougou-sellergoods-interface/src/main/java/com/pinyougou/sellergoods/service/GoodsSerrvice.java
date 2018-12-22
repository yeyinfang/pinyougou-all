package com.pinyougou.sellergoods.service;

import com.pinyougou.entity.Goods;
import com.pinyougou.pojo.TbGoods;

import java.util.Map;

public interface GoodsSerrvice {
    /** 
    * @Description: 添加商品的操作
    * @Param: [goods] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/10/15
     * @param goods
    */ 
    void addGoods(Goods goods);

    /** 
    * @Description: 条件查询，也就是查询所有的商品的操作 
    * @Param: [goods, page, rows] 
    * @return: java.util.Map<java.lang.String,java.lang.Object> 
    * @Author: Yin 
    * @Date: 2018/12/21 
    */ 
    Map<String,Object> findByCondition(TbGoods goods, int page, int rows);
}

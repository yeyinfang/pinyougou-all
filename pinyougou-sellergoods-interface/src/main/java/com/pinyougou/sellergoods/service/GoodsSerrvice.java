package com.pinyougou.sellergoods.service;

import com.pinyougou.entity.Goods;
import com.pinyougou.entity.ResponseResult;
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

    /** 
    * @Description: 根据id去进行回显的操作
    * @Param: [id] 
    * @return: Goods
    * @Author: Yin 
    * @Date: 2018/12/22 
    */
    Goods findOne(Long id);

    /** 
    * @Description: 修改商品的操作 
    * @Param: [goods] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/12/22 
    */ 
    void updateGoods(Goods goods);

    /** 
    * @Description: 查询所有的商品的意思
    * @Param: [goods, page, rows] 
    * @return: java.util.Map<java.lang.String,java.lang.Object> 
    * @Author: Yin 
    * @Date: 2018/12/23 
    */ 
    Map<String,Object> findAll(TbGoods goods, int page, int rows);
}

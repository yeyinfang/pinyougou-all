package com.pinyougou.mapper;

import com.github.abel533.mapper.Mapper;
import com.pinyougou.pojo.TbGoods;

import java.util.List;

public interface TbGoodsMapper extends Mapper<TbGoods> {
    /** 
    * @Description: 添加商品
    * @Param: [goods] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/10/15 
    */ 
    void addGoods(TbGoods goods);

    /** 
    * @Description: 条件查询商品，也就是显示商品的操作 
    * @Param: [goods] 
    * @return: java.util.List<com.pinyougou.pojo.TbGoods> 
    * @Author: Yin 
    * @Date: 2018/12/21 
    */ 
    List<TbGoods> findByCondition(TbGoods goods);

    /** 
    * @Description: 根据id去进行查找
    * @Param: [id] 
    * @return: com.pinyougou.pojo.TbGoods 
    * @Author: Yin 
    * @Date: 2018/12/22 
    */ 
    TbGoods findById(Long id);

    /** 
    * @Description: 修改商品
    * @Param: [goods] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/12/23 
    */ 
    void updateGoods(TbGoods goods);
}
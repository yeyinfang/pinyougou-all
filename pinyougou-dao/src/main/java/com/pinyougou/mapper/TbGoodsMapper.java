package com.pinyougou.mapper;

import com.github.abel533.mapper.Mapper;
import com.pinyougou.pojo.TbGoods;

public interface TbGoodsMapper extends Mapper<TbGoods> {
    /** 
    * @Description: 添加商品
    * @Param: [goods] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/10/15 
    */ 
    void addGoods(TbGoods goods);
}
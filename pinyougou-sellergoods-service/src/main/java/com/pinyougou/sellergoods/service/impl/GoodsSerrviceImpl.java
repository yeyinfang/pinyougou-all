package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.entity.Goods;
import com.pinyougou.mapper.TbGoodsDescMapper;
import com.pinyougou.mapper.TbGoodsMapper;
import com.pinyougou.sellergoods.service.GoodsSerrvice;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: pinyougou-all
 * @description: 这是商品的实现类
 * @author: YF
 * @create: 2018-10-15 09:20
 **/
@Service
public class GoodsSerrviceImpl implements GoodsSerrvice {
    @Autowired
    private TbGoodsMapper goodsMapper;
    @Autowired
    private TbGoodsDescMapper goodsDescMapper;


    //添加商品的操作
    @Override
    public void addGoods(Goods goods) {
        //设置商品的状态  0代表商品未审核   1审核中  2审核通过
        goods.getGoods().setAuditStatus("0");
        goodsMapper.addGoods(goods.getGoods());
        //在数据库中的语句中，我将这个数据的id给获取出来了
        goods.getGoodsDesc().setGoodsId(goods.getGoods().getId());
        goodsDescMapper.addGoodsDesc(goods.getGoodsDesc());
    }
}

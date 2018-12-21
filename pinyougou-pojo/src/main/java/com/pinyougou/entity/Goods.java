package com.pinyougou.entity;

import com.pinyougou.pojo.TbGoods;
import com.pinyougou.pojo.TbGoodsDesc;
import com.pinyougou.pojo.TbItem;

import java.io.Serializable;
import java.util.List;

/**
 * @program: pinyougou-all
 * @description: 对于商品的一个集合管理
 * @author: YF
 * @create: 2018-10-17 15:10
 **/
public class Goods implements Serializable {
    private TbGoods goods;//商品的spu，也就是最开始的主体
    private TbGoodsDesc goodsDesc;//商品的扩展属性
    private List<TbItem> itemList;//商品的sku列表 也就是sku

    public TbGoods getGoods() {
        return goods;
    }

    public void setGoods(TbGoods goods) {
        this.goods = goods;
    }

    public TbGoodsDesc getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(TbGoodsDesc goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public List<TbItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<TbItem> itemList) {
        this.itemList = itemList;
    }
}

package com.pinyougou.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.entity.Goods;
import com.pinyougou.entity.ResponseResult;
import com.pinyougou.pojo.TbGoods;
import com.pinyougou.sellergoods.service.GoodsSerrvice;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: pinyougou-all
 * @description: 就是商家商品的一些操作，但其实牵涉到不仅仅只有这一个类
 * @author: YF
 * @create: 2018-09-11 20:01
 **/
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Reference
    private GoodsSerrvice goodsSerrvice;

    
    /** 
    * @Description: 增加商品的处理
    * @Param: [goods] 
    * @return: com.pinyougou.entity.ResponseResult<com.pinyougou.pojo.TbGoods> 
    * @Author: Yin 
    * @Date: 2018/10/15 
    */ 
    @RequestMapping("/add")
    public ResponseResult<Goods> addGoods(@RequestBody Goods goods){
        try {
            /*//设置商品的id，用时间戳的形式来做
            goods.setId(System.currentTimeMillis());*/
            //将用户名设置进去，也就是商家的id
            String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
            //设置spu的那一列
            goods.getGoods().setSellerId(sellerId);
            goodsSerrvice.addGoods(goods);
            return ResponseResult.success("商品添加成功啦！");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.error("商品添加失败！");
        }
    }
}

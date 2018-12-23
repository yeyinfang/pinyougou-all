package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.entity.Goods;
import com.pinyougou.pojo.TbGoods;
import com.pinyougou.sellergoods.service.GoodsSerrvice;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @program: pinyougou-all
 * @description: 商品的控制层
 * @author: YF
 * @create: 2018-12-23 10:52
 **/
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Reference
    private GoodsSerrvice goodsSerrvice;

    /** 
    * @Description: 条件查询 
    * @Param: [goods, page, rows] 
    * @return: java.util.Map<java.lang.String,java.lang.Object> 
    * @Author: Yin 
    * @Date: 2018/12/23 
    */ 
    @RequestMapping("/findAll")
    @ResponseBody
    public Map<String,Object> findAll(@RequestBody TbGoods goods, int page, int rows){
        return goodsSerrvice.findAll(goods,page,rows);
    }

    /** 
    * @Description: 根据id去进行查询的操作 
    * @Param: [id] 
    * @return: com.pinyougou.entity.Goods 
    * @Author: Yin 
    * @Date: 2018/12/23 
    */ 
    @RequestMapping("/findOne")
    @ResponseBody
    public Goods findOne(Long id){
        return goodsSerrvice.findOne(id);
    }
}

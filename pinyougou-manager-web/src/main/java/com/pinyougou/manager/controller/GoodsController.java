package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.entity.Goods;
import com.pinyougou.entity.ResponseResult;
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

    /** 
    * @Description: 更新商品的状态，看是已经审核还是驳回操作
    * @Param: [ids, status] 
    * @return: com.pinyougou.entity.ResponseResult 
    * @Author: Yin 
    * @Date: 2018/12/23 
    */
    @RequestMapping("/updateStatus")
    public ResponseResult<TbGoods> updateStatus(String ids,String status){
        try {
            String[] id = ids.split(",");
            Long[] longs = new Long[id.length];
            for (int i = 0; i < id.length; i++) {
                longs[i]=Long.parseLong(id[i]);
            }
            goodsSerrvice.updateStatus(longs,status);
            return ResponseResult.success("审核操作已经完成啦！");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.error("审核操作出现问题啦");
        }
    }



    @RequestMapping("/delete")
    public ResponseResult<TbGoods> deleteGoods(String ids){
        try {
            //先将id进行切割
            String[] str = ids.split(",");
            Long[] id = new Long[str.length];
            for (int i = 0; i < str.length; i++) {
                id[i]=Long.parseLong(str[i]);
            }
            goodsSerrvice.deleteGoods(id);
            return ResponseResult.success("删除成功啦！！！");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.error("删除失败啦！！！");
        }
    }
}

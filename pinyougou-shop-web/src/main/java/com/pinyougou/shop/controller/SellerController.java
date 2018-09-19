package com.pinyougou.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.entity.ResponseResult;
import com.pinyougou.pojo.TbSeller;
import com.pinyougou.sellergoods.service.SellerService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @program: pinyougou-all
 * @description: 这个是商家相关的类，也就是商家入驻等待被审核的操作
 * @author: YF
 * @create: 2018-09-11 20:14
 **/
@RestController
@RequestMapping("/seller")
public class SellerController {
    //创建服务层对象
    @Reference
    private SellerService sellerService;

    /** 
    * @Description: 增加商家，但是就是刚开始要进行审核的 
    * @Param: [seller] 
    * @return: com.pinyougou.entity.ResponseResult<com.pinyougou.pojo.TbSeller> 
    * @Author: Yin 
    * @Date: 2018/9/17 
    */ 
    @RequestMapping("/add")
    public ResponseResult<TbSeller> addSeller(@RequestBody TbSeller seller){
        try {
            //设置审核的状态  0：未审核   1：已审核   2：审核未通过   3：关闭
            seller.setStatus("0");
            //设置创建申请的时间
            seller.setCreateTime(new Date());
            sellerService.addSeller(seller);
            return ResponseResult.success("申请成功，请等待审核结果");
        }catch (Exception e){
            return ResponseResult.error("申请失败，请重新申请");
        }
    }


}

package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbSeller;
import com.pinyougou.sellergoods.service.SellerService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @program: pinyougou-all
 * @description: 商家审核的
 * @author: YF
 * @create: 2018-09-29 23:42
 **/
@RestController
@RequestMapping("/seller")
public class SellerController {
    @Reference
    private SellerService sellerService;

    /** 
    * @Description: 查找所有的
    * @Param: [] 
    * @return: java.util.List<com.pinyougou.pojo.TbSeller> 
    * @Author: Yin 
    * @Date: 2018/9/30 
    */ 
    @RequestMapping("/findAll")
    public List<TbSeller> findAll(){
        return sellerService.findAll();
    }

    @RequestMapping("/findByCondition")
    public Map<String,Object> findByCondition(@RequestParam(required = false,defaultValue = "1") int page,
                                              @RequestParam(required = false,defaultValue = "1") int rows,
                                              @RequestBody TbSeller seller){
        return sellerService.findByCondition(page,rows,seller);
    }
    
    
}

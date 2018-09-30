package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.entity.ResponseResult;
import com.pinyougou.pojo.TbSeller;
import com.pinyougou.sellergoods.service.SellerService;
import org.springframework.web.bind.annotation.*;

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

    
    /** 
    * @Description: 商家的审核的查看的条件分页显示
    * @Param: [page, rows, seller] 
    * @return: java.util.Map<java.lang.String,java.lang.Object> 
    * @Author: Yin 
    * @Date: 2018/9/30 
    */ 
    @RequestMapping("/findByCondition")
    public Map<String,Object> findByCondition(@RequestParam(required = false,defaultValue = "1") int page,
                                              @RequestParam(required = false,defaultValue = "1") int rows,
                                              @RequestBody TbSeller seller){
        return sellerService.findByCondition(page,rows,seller);
    }


    /** 
    * @Description: 根据id去进行查找到整个商家的详情，也就是为了进行修改所做的操作
    * @Param: [sellerId] 
    * @return: com.pinyougou.pojo.TbSeller 
    * @Author: Yin 
    * @Date: 2018/9/30 
    */ 
    @RequestMapping("/findOne")
    @ResponseBody
    public TbSeller findOne(String sellerId){
        return sellerService.findOne(sellerId);
    }

    /** 
    * @Description: 修改商家的审核状态
    * @Param: [sellerId, status]
    * @return: com.pinyougou.entity.ResponseResult<com.pinyougou.pojo.TbSeller> 
    * @Author: Yin 
    * @Date: 2018/9/30 
    */ 
    @RequestMapping("/updateStatus")
    public ResponseResult<TbSeller> updateStutas(String sellerId,String status){
        try {
            sellerService.updateStutas(sellerId,status);
            return ResponseResult.success("审核成功，请审核下一个");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.error("审核错误，请重新审核");
        }
    }
    
    
    
    
}

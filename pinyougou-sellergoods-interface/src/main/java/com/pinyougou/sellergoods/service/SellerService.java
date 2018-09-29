package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbSeller;

import java.util.List;
import java.util.Map;

public interface SellerService {
    /** 
    * @Description: 增加商家 
    * @Param: [seller] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/9/17 
    */ 
    void addSeller(TbSeller seller);

    /** 
    * @Description: 查找所有的 
    * @Param: [] 
    * @return: java.util.List<com.pinyougou.pojo.TbSeller> 
    * @Author: Yin 
    * @Date: 2018/9/29 
    */ 
    List<TbSeller> findAll();

    /** 
    * @Description: 分页显示跟上条件查询 
    * @Param: [page, rows, seller] 
    * @return: java.util.Map<java.lang.String,java.lang.Object> 
    * @Author: Yin 
    * @Date: 2018/9/30 
    */ 
    Map<String,Object> findByCondition(int page, int rows, TbSeller seller);
}

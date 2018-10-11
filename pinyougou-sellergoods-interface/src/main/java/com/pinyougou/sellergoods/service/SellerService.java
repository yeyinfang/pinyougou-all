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

    
    /** 
    * @Description: 根据id去进行查找到整个商家的详情，也就是为了进行修改所做的操作  
    * @Param: [sellerId] 
    * @return: com.pinyougou.pojo.TbSeller 
    * @Author: Yin 
    * @Date: 2018/9/30 
    */ 
    TbSeller findOne(String sellerId);

    /** 
    * @Description: 修改商家的状态 
    * @Param: [sellerId, status] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/9/30 
    */ 
    void updateStutas(String sellerId, String status);

    /** 
    * @Description: 根据名字去找到用户，看是否存在用户 
    * @Param: [username] 
    * @return: com.pinyougou.pojo.TbSeller 
    * @Author: Yin 
    * @Date: 2018/10/10 
    */ 
    TbSeller findByName(String username);
}

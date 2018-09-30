package com.pinyougou.mapper;

import com.github.abel533.mapper.Mapper;
import com.pinyougou.pojo.TbSeller;

import java.util.List;

public interface TbSellerMapper extends Mapper<TbSeller> {
    /** 
    * @Description:
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
    * @Description: 条件查询
    * @Param: [seller] 
    * @return: java.util.List<com.pinyougou.pojo.TbSeller> 
    * @Author: Yin 
    * @Date: 2018/9/30 
    */ 
    List<TbSeller> findByCondition(TbSeller seller);

    /** 
    * @Description: 根据id去进行查找到整个商家的详情，也就是为了进行修改所做的操作
    * @Param: [sellerId] 
    * @return: com.pinyougou.pojo.TbSeller 
    * @Author: Yin 
    * @Date: 2018/9/30 
    */ 
    TbSeller findOne(String sellerId);

    /** 
    * @Description: 对商家进行修改的操作
    * @Param: [seller] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/9/30 
    */ 
    void update(TbSeller seller);
}
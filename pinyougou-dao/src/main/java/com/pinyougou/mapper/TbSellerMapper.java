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
}
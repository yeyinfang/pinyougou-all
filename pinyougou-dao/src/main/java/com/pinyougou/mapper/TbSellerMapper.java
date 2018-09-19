package com.pinyougou.mapper;

import com.github.abel533.mapper.Mapper;
import com.pinyougou.pojo.TbSeller;

public interface TbSellerMapper extends Mapper<TbSeller> {
    /** 
    * @Description:
    * @Param: [seller] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/9/17 
    */ 
    void addSeller(TbSeller seller);
}
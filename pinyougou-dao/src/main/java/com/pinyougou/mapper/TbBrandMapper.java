package com.pinyougou.mapper;

import com.github.abel533.mapper.Mapper;
import com.pinyougou.pojo.TbBrand;

import java.util.List;

public interface TbBrandMapper extends Mapper<TbBrand> {

    /** 
    * @Description: 查找到所有的品牌
    * @Param: [] 
    * @return: java.util.List<com.pinyougou.pojo.TbBrand> 
    * @Author: Yin 
    * @Date: 2018/8/29 
    */ 
    List<TbBrand> findAll();

    /** 
    * @Description: 添加品牌的信息
    * @Param: [brand] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/8/29 
    */ 
    void addBrand(TbBrand brand);

    /** 
    * @Description: 修改品牌的信息 
    * @Param: [brand] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/8/29 
    */ 
    void updateBrand(TbBrand brand);

    /** 
    * @Description: 根据id查找到品牌信息
    * @Param: [id] 
    * @return: com.pinyougou.pojo.TbBrand 
    * @Author: Yin 
    * @Date: 2018/8/29 
    */ 
    TbBrand findById(Integer id);
}
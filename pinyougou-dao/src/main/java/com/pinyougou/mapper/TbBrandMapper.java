package com.pinyougou.mapper;

import com.github.abel533.mapper.Mapper;
import com.pinyougou.pojo.TbBrand;
import org.apache.ibatis.annotations.Param;

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

    /** 
    * @Description: 批量删除品牌信息
    * @Param: [ids] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/8/30 
    */ 
    void deleteBrands( String[] ids);

    /** 
    * @Description: 条件查询，也可以称为是搜索
    * @Param: [brand] 
    * @return: java.util.List<com.pinyougou.pojo.TbBrand> 
    * @Author: Yin 
    * @Date: 2018/8/30 
    */ 
    List<TbBrand> findByCondition(TbBrand brand);
}
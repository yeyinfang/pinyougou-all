package com.pinyougou.sellergoods.service;

import com.pinyougou.entity.ResponseResult;
import com.pinyougou.pojo.TbBrand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BrandService {
    /** 
    * @Description: 查找到所有的品牌消息
    * @Param: [] 
    * @return: java.util.List<com.pinyougou.pojo.TbBrand> 
    * @Author: Yin 
    * @Date: 2018/8/29 
    */ 
    List<TbBrand> findAll();

    /** 
    * @Description: 分页查询所有的 
    * @Param: [page, size] 
    * @return: java.util.List<com.pinyougou.pojo.TbBrand> 
    * @Author: Yin 
    * @Date: 2018/8/29 
    */
    Map<String, Object> findByPage(Integer page, Integer size);

    /** 
    * @Description: 添加品牌
    * @Param: [brand] 
    * @return: com.pinyougou.entity.ResponseResult<com.pinyougou.pojo.TbBrand> 
    * @Author: Yin 
    * @Date: 2018/8/29 
    */ 
    ResponseResult<TbBrand> addBrand(TbBrand brand);

    /** 
    * @Description: 对品牌进行修改
    * @Param: [brand] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/8/29 
    */ 
    void updateBrand(TbBrand brand);

    /** 
    * @Description: 根据id去寻找对应的品牌
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
    void deleteBrand(String ids);

    /** 
    * @Description: 条件查询品牌的信息 
    * @Param: [brand, page, rows] 
    * @return: java.util.List<com.pinyougou.pojo.TbBrand> 
    * @Author: Yin 
    * @Date: 2018/8/30 
    */ 
    Map<String, Object> findByCondiction(TbBrand brand, Integer page, Integer rows);
}

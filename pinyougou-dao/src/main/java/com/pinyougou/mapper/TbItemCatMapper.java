package com.pinyougou.mapper;

import com.github.abel533.mapper.Mapper;
import com.pinyougou.pojo.TbItemCat;

import java.util.List;

public interface TbItemCatMapper extends Mapper<TbItemCat> {
    /** 
    * @Description: 根据id获取到分类的值
    * @Param: [parentId] 
    * @return: java.util.List<com.pinyougou.pojo.TbItemCat> 
    * @Author: Yin 
    * @Date: 2018/7/13 
    */ 
    List<TbItemCat> findByParentId(Long parentId);

    /** 
    * @Description: 查询到所有的分类
    * @Param: [] 
    * @return: java.util.List<com.pinyougou.pojo.TbItemCat> 
    * @Author: Yin 
    * @Date: 2018/9/4 
    */
    List<TbItemCat> findAll();

    /** 
    * @Description: 添加分类的操作
    * @Param: [itemCat] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/9/7 
    */ 
    void addItemCat(TbItemCat itemCat);
}
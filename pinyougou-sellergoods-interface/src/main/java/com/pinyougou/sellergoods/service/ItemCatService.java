package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbItemCat;

import java.util.List;
import java.util.Map;

public interface ItemCatService {
    /** 
    * @Description: 显示所有的分类 
    * @Param: [] 
    * @return: java.util.List<com.pinyougou.pojo.TbItemCat> 
    * @Author: Yin 
    * @Date: 2018/9/4 
    */ 
    List<TbItemCat> findAll();

    /** 
    * @Description: 分页查找到，也包括了条件查询
    * @Param: [page, rows, itemCat] 
    * @return: java.util.Map<java.lang.String,java.lang.Object> 
    * @Author: Yin 
    * @Date: 2018/9/4 
    */ 
    Map<String,Object> findByCondition(int page, int rows);

    /** 
    * @Description: 根据父类的id查到所属的分类
    * @Param: [parentId] 
    * @return: java.util.List<com.pinyougou.pojo.TbItemCat> 
    * @Author: Yin 
    * @Date: 2018/9/4 
    */ 
    List<TbItemCat> findByParentId(Long parentId);

    /** 
    * @Description: 添加分类的操作
    * @Param: [itemCat] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/9/7 
    */ 
    void addItemCat(TbItemCat itemCat);
}

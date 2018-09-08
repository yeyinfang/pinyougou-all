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

    /** 
    * @Description: 修改分类的操作
    * @Param: [itemCat] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/9/8 
    */ 
    void updateItemCat(TbItemCat itemCat);

    /** 
    * @Description: 根据id去进行查找
    * @Param: [id] 
    * @return: com.pinyougou.pojo.TbItemCat 
    * @Author: Yin 
    * @Date: 2018/9/8 
    */ 
    TbItemCat findById(Long id);

    /** 
    * @Description: 根据id去进行查找，看是否这个id是有下级的
    * @Param: [id] 
    * @return: int 
    * @Author: Yin 
    * @Date: 2018/9/8 
    */ 
    int CountByParentId(Long id);

    /** 
    * @Description: 根据id进行删除
    * @Param: [id] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/9/8 
    */ 
    void deleteItemCat(Long id);
}
package com.pinyougou.mapper;

import com.github.abel533.mapper.Mapper;
import com.pinyougou.pojo.TbSpecification;

import java.util.List;

public interface TbSpecificationMapper /*extends Mapper<TbSpecification>*/ {
    /**
    * @Description:查找到所有的规格的信息
    * @Param: []
    * @return: java.util.List<com.pinyougou.pojo.TbSpecification>
    * @Author: Yin
    * @Date: 2018/9/1
    */
    List<TbSpecification> findAll();


    /** 
    * @Description: 条件查询
    * @Param: [specification] 
    * @return: java.util.List<com.pinyougou.pojo.TbSpecification> 
    * @Author: Yin 
    * @Date: 2018/9/1 
    */ 
   List<TbSpecification> findByCondition(TbSpecification specification);

   /** 
   * @Description: 添加规格的管理
   * @Param: [specification] 
   * @return: void 
   * @Author: Yin 
   * @Date: 2018/9/2 
   */ 
    void addSpecification(TbSpecification specification);
}
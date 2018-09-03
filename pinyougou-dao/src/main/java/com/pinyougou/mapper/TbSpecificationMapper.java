package com.pinyougou.mapper;

import com.github.abel533.mapper.Mapper;
import com.pinyougou.pojo.TbSpecification;

import java.util.List;
import java.util.Map;

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

    /** 
    * @Description: 修改规格的管理
    * @Param: [specification] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/9/2 
    */ 
    void updateSpecification(TbSpecification specification);

    /** 
    * @Description: 根据id获取到规格的这一条记录 
    * @Param: [id] 
    * @return: com.pinyougou.pojo.TbSpecification 
    * @Author: Yin 
    * @Date: 2018/9/2 
    */ 
    TbSpecification findByOne(Long id);

    /** 
    * @Description: 根据id去进行删除
    * @Param: [l] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/9/3 
    */ 
    void deleteSpecification(long id);

    /** 
    * @Description: 为了给模板的下拉列表进行显示的
    * @Param: [] 
    * @return: java.util.List<java.util.Map> 
    * @Author: Yin 
    * @Date: 2018/9/3 
    */ 
    List<Map> selectOptionSpec();
}
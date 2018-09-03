package com.pinyougou.sellergoods.service;

import com.pinyougou.entity.Specification;
import com.pinyougou.pojo.TbSpecification;

import java.util.List;
import java.util.Map;

public interface SpecificationService {
    /** 
    * @Description: 查找所有 
    * @Param: [] 
    * @return: java.util.List<com.pinyougou.pojo.TbSpecification> 
    * @Author: Yin 
    * @Date: 2018/9/2 
    */ 
    List<TbSpecification> findAll();

    /** 
    * @Description: 根据条件查询 
    * @Param: [page, rows, specification] 
    * @return: java.util.Map<java.lang.String,java.lang.Object> 
    * @Author: Yin 
    * @Date: 2018/9/2 
    */ 
    Map<String,Object> findByCondition(int page, int rows, TbSpecification specification);

    /** 
    * @Description: 添加规格
    * @Param: [specification] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/9/2
     * @param specification
    */ 
    void addSpecification(Specification specification);

    /** 
    * @Description: 修改实体的信息
    * @Param: [specification] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/9/2 
    */ 
    void updateSpecification(Specification specification);

    /** 
    * @Description: 根据id去寻找规格的信息 
    * @Param: [id] 
    * @return: com.pinyougou.entity.Specification 
    * @Author: Yin 
    * @Date: 2018/9/2 
    */ 
    Specification findByOne(Long id);

    /** 
    * @Description: 批量删除 
    * @Param: [ids] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/9/2
     * @param ids
    */ 
    void deleteSpecification(Long[] ids);
}

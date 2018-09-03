package com.pinyougou.mapper;

import com.github.abel533.mapper.Mapper;
import com.pinyougou.pojo.TbSpecificationOption;

import java.util.List;

public interface TbSpecificationOptionMapper extends Mapper<TbSpecificationOption> {
    /** 
    * @Description: 添加规格的操作 
    * @Param: [option] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/9/2 
    */ 
    void addOption(TbSpecificationOption option);

    /** 
    * @Description: 根据规格的id去找到所有对应的规格 
    * @Param: [id] 
    * @return: java.util.List<com.pinyougou.pojo.TbSpecificationOption> 
    * @Author: Yin 
    * @Date: 2018/9/2 
    */ 
    List<TbSpecificationOption> findBySpecId(Long specId);

    /** 
    * @Description: 删除选中规格的id，将是这个类的都进行删除，在进行添加
    * @Param: [specId] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/9/2 
    */ 
    void deleteOption(Long specId);
}
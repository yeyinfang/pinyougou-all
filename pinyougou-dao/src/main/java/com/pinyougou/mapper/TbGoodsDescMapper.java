package com.pinyougou.mapper;

import com.github.abel533.mapper.Mapper;
import com.pinyougou.pojo.TbGoodsDesc;

public interface TbGoodsDescMapper extends Mapper<TbGoodsDesc> {
    /** 
    * @Description: 添加的信息 
    * @Param: [goodsDesc] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/12/22 
    */ 
    void addGoodsDesc(TbGoodsDesc goodsDesc);

    /** 
    * @Description: 根据id去进行查询
    * @Param: [id] 
    * @return: com.pinyougou.pojo.TbGoodsDesc 
    * @Author: Yin 
    * @Date: 2018/12/22 
    */ 
    TbGoodsDesc findById(Long id);
}
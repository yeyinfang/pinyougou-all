package com.pinyougou.mapper;

import com.github.abel533.mapper.Mapper;
import com.pinyougou.pojo.TbSpecificationOption;

public interface TbSpecificationOptionMapper extends Mapper<TbSpecificationOption> {
    //添加规格的操作
    void addOption(TbSpecificationOption option);
}
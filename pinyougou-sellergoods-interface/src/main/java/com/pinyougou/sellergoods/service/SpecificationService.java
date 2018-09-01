package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbSpecification;

import java.util.List;
import java.util.Map;

public interface SpecificationService {

    List<TbSpecification> findAll();

    Map<String,Object> findByCondition(int page, int rows, TbSpecification specification);
}

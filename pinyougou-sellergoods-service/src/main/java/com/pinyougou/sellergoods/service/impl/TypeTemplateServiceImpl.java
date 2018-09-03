package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.mapper.TbTypeTemplateMapper;
import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.sellergoods.service.TypeTemplateService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: pinyougou-all
 * @description: 模板的实现类
 * @author: YF
 * @create: 2018-09-03 09:50
 **/
@Service
public class TypeTemplateServiceImpl implements TypeTemplateService {
    @Autowired
    private TbTypeTemplateMapper typeTemplateMapper;

    @Override
    public List<TbTypeTemplate> findAll() {
        return typeTemplateMapper.findAll();
    }
}

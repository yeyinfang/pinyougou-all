package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.mapper.TbContentCategoryMapper;
import com.pinyougou.pojo.TbContentCategory;
import com.pinyougou.sellergoods.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: pinyougou-all
 * @description:
 * @author: YF
 * @create: 2018-12-25 11:10
 **/
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
    @Autowired
    private TbContentCategoryMapper contentCategoryMapper;

    @Override
    public List<TbContentCategory> findAll() {
        return contentCategoryMapper.findAll();
    }
}

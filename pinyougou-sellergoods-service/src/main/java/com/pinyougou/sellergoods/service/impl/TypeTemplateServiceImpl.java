package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.mapper.TbTypeTemplateMapper;
import com.pinyougou.pojo.TbItemCat;
import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.sellergoods.service.TypeTemplateService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //查询所有
    @Override
    public List<TbTypeTemplate> findAll() {
        return typeTemplateMapper.findAll();
    }


    //条件查询
    @Override
    public Map<String, Object> findByCondition(int page, int rows, TbTypeTemplate typeTemplate) {
        //设置分页的信息
        PageHelper.startPage(page,rows);
        List<TbTypeTemplate> list = typeTemplateMapper.findByCondition(typeTemplate);
        //将list转进去
        PageInfo<TbTypeTemplate> info = new PageInfo<>(list);
        Map<String, Object> map = new HashMap<>();
        map.put("total",info.getTotal());
        map.put("rows",info.getList());
        return map;
    }

    //增加模板
    @Override
    public void addTypeTemplate(TbTypeTemplate typeTemplate) {
        typeTemplateMapper.addTypeTemplate(typeTemplate);
    }

    //修改模板
    @Override
    public void updateTypeTemplate(TbTypeTemplate typeTemplate) {
        typeTemplateMapper.updateTypeTemplate(typeTemplate);
    }

    //根据id去找到对应的模板
    @Override
    public TbTypeTemplate findById(Long id) {
        return typeTemplateMapper.findById(id);
    }

    @Override
    public void deleteTypeTemplate(Long[] ids) {
        for (Long id : ids) {
            typeTemplateMapper.deleteTypeTemplate(id);
        }   
    }

    @Override
    public List<Map> findTypeList() {
        return typeTemplateMapper.findTypeList();
    }
}

package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.mapper.TbSpecificationOptionMapper;
import com.pinyougou.mapper.TbTypeTemplateMapper;
import com.pinyougou.pojo.TbItemCat;
import com.pinyougou.pojo.TbSpecificationOption;
import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.sellergoods.service.TypeTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
    //引入模板的数据库查询的
    @Autowired
    private TbTypeTemplateMapper typeTemplateMapper;
    //引入规格选项的数据库的查询
    @Autowired
    private TbSpecificationOptionMapper specificationOptionMapper;
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

    //删除
    @Override
    public void deleteTypeTemplate(Long[] ids) {
        for (Long id : ids) {
            typeTemplateMapper.deleteTypeTemplate(id);
        }   
    }

    //查找到模板列表
    @Override
    public List<Map> findTypeList() {
        return typeTemplateMapper.findTypeList();
    }

    //查模板
    @Override
    public TbTypeTemplate findTypeTemplate(Long id) {
        return typeTemplateMapper.findTypeTemplate(id);
    }

    //查规格属性
    @Override
    public List<Map> findSpecList(Long id) {
        //根据模板的id去找到整个模板，然后就可以获取到了规格选项的路径
        TbTypeTemplate typeTemplate = typeTemplateMapper.findById(id);
        //这就将规格选项的那个id给变成一个json的集合往里面去进行存储
        List<Map> list = JSON.parseArray(typeTemplate.getSpecIds(), Map.class);
        //找到选项的id，然后在去进行查找
        for (Map map : list) {
            List<TbSpecificationOption> specList = specificationOptionMapper.findBySpecId(new Long((Integer)map.get("id")));
            map.put("options",specList);
        }
        return list;
    }


}

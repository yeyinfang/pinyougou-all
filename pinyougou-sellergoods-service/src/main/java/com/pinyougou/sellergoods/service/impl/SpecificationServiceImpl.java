package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.entity.Specification;
import com.pinyougou.mapper.TbSpecificationMapper;
import com.pinyougou.mapper.TbSpecificationOptionMapper;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationOption;
import com.pinyougou.sellergoods.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: pinyougou-all
 * @description:
 * @author: YF
 * @create: 2018-09-01 10:53
 **/
@Service
public class SpecificationServiceImpl implements SpecificationService {
    @Autowired
    private TbSpecificationMapper specificationMapper;
    @Autowired
    private TbSpecificationOptionMapper specificationOptionMapper;

    @Override
    public List<TbSpecification> findAll() {
        return specificationMapper.findAll();
    }

    @Override
    public Map<String, Object> findByCondition(int page, int rows, TbSpecification specification) {
        PageHelper.startPage(page,rows);
        List<TbSpecification> list=specificationMapper.findByCondition(specification);
        PageInfo<TbSpecification> info = new PageInfo<>(list);
        Map<String, Object> map = new HashMap<>();
        map.put("total",info.getTotal());
        map.put("rows",info.getList());
        return map;
    }

    @Override
    public void addSpecification(Specification specification) {
        //首先就是先进行增加规格的选项，然后获取到id的值
        specificationMapper.addSpecification(specification.getSpecification());
        Long id = specification.getSpecification().getId();
        System.out.println(id);
        //进行规格选项的添加
        for (TbSpecificationOption option : specification.getSpecificationOptionList()) {
            //设置编号
            option.setSpecId(specification.getSpecification().getId());
            //进行保存
            specificationOptionMapper.addOption(option);
        }
    }

    @Override
    public void updateSpecification(Specification specification) {
        //首先就是对规格进行修改，这个时候修改的话其实就只是修改规格的名字罢了
        specificationMapper.updateSpecification(specification.getSpecification());
        //根据id查出所有的这个类的,然后进行删除，再重新添加
        List<TbSpecificationOption> options = specificationOptionMapper.findBySpecId(specification.getSpecification().getId());
        System.out.println(options);
        specificationOptionMapper.deleteOption(specification.getSpecification().getId());
        //删除结束进行添加
        for (TbSpecificationOption option : specification.getSpecificationOptionList()) {
            specificationOptionMapper.addOption(option);
        }

    }

    @Override
    public Specification findByOne(Long id) {
        //首先就是根据获取到的id，去拿到规格的id的值
        TbSpecification specification = specificationMapper.findByOne(id);
        //规格选项就是根据规格的id然后去进行查询，获取到的是集合的，因为就是规格可能有多个选项
        List<TbSpecificationOption> list = specificationOptionMapper.findBySpecId(id);
        //将值设置回去
        Specification spec = new Specification();
        spec.setSpecification(specification);
        spec.setSpecificationOptionList(list);

        return spec;
    }

    @Override
    public void deleteSpecification(Long[] ids) {
        //首先就是根据传进来的id进行切割
        System.out.println(ids);
        for (Long id : ids) {
            //删除规格的选项
            specificationMapper.deleteSpecification(id);
            //根据规格的id去删除所对应的选项
            specificationOptionMapper.deleteOption(id);
        }
    }

    @Override
    public List<Map> selectOptionSpec() {
        return specificationMapper.selectOptionSpec();
    }
}

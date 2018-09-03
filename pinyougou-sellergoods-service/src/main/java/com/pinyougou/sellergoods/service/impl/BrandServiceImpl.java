package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.entity.ResponseResult;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: pinyougou-all
 * @description: 品牌管理实现类
 * @author: YF
 * @create: 2018-08-29 14:06
 **/
@Service //使用的是阿里的服务，因为我们使用的是dubbo进行模块与模块之间的通信
public class BrandServiceImpl implements BrandService {
    //将数据库的那层给注入进来
    @Autowired
    private TbBrandMapper brandMapper;

    //查找到所有的品牌管理的消息
    @Override
    public List<TbBrand> findAll() {
        return brandMapper.findAll();
    }

    //分页查找
    @Override
    public Map<String, Object> findByPage(Integer page, Integer size) {
        //设置分页的起始页数和大小
        PageHelper.startPage(page,size);
        List<TbBrand> brandList = brandMapper.findAll();
        //获取到分页的对象，将查询出来的所有参数添加进去
        PageInfo<TbBrand> info = new PageInfo<>(brandList);
        //获取到表中添加进来的数据的值
        List<TbBrand> list = info.getList();
        //获取到总条数
        long total = info.getTotal();
        //将值传递出去，也就是告诉浏览器这对应了什么
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",list);
        return map;
    }


    //添加
    @Override
    public ResponseResult<TbBrand> addBrand(TbBrand brand) {
        try {
            brandMapper.addBrand(brand);
            return ResponseResult.success("增加成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.error("增加失败");
        }
    }


    //修改
    @Override
    public void updateBrand(TbBrand brand) {
        brandMapper.updateBrand(brand);
    }

    //根据id查找到品牌信息
    @Override
    public TbBrand findById(Integer id) {
        return brandMapper.findById(id);
    }

    //批量删除品牌的信息
    @Override
    public void deleteBrand(String id) {
        //应该是以，进行切割，然后转为integer类型的id去进行删除
        String[] ids= id.split(",");
        //方法1:就是将整个数组传过去
        brandMapper.deleteBrands(ids);
    }

    //条件查询
    @Override
    public Map<String, Object> findByCondiction(TbBrand brand, Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        //查询出来的信息
        List<TbBrand> list = brandMapper.findByCondition(brand);
        //将数据存储进去
        PageInfo<TbBrand> info = new PageInfo<>(list);
        List<TbBrand> brandList = info.getList();
        long total = info.getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",brandList);
        return map;
    }

    @Override
    public List<Map> selectOptionList() {
        return brandMapper.selectOptionList();
    }
}

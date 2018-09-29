package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.mapper.TbSellerMapper;
import com.pinyougou.pojo.TbSeller;
import com.pinyougou.sellergoods.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: pinyougou-all
 * @description: 商家的实现
 * @author: YF
 * @create: 2018-09-14 20:00
 **/
@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private TbSellerMapper sellerMapper;

    //增加用户的信息
    @Override
    public void addSeller(TbSeller seller) {
        sellerMapper.addSeller(seller);
    }

    @Override
    public List<TbSeller> findAll() {
        return sellerMapper.findAll();
    }

    @Override
    public Map<String, Object> findByCondition(int page, int rows, TbSeller seller) {
        PageHelper.startPage(page,rows);
        //找到条件
        List<TbSeller> list = sellerMapper.findByCondition(seller);
        PageInfo<TbSeller> info = new PageInfo<>(list);
        Map<String, Object> map = new HashMap<>();
        map.put("total",info.getTotal());
        map.put("rows",info.getList());
        return map;
    }
}

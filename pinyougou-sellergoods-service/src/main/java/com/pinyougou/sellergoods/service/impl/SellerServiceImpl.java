package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.mapper.TbSellerMapper;
import com.pinyougou.pojo.TbSeller;
import com.pinyougou.sellergoods.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;

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
}

package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.entity.ResponseResult;
import com.pinyougou.mapper.TbItemCatMapper;
import com.pinyougou.pojo.TbItemCat;
import com.pinyougou.sellergoods.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: pinyougou-all
 * @description:分类的实现类
 * @author: YF
 * @create: 2018-09-04 09:28
 **/
@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Override
    public List<TbItemCat> findAll() {
        return itemCatMapper.findAll();
    }

    @Override
    public Map<String, Object> findByCondition(int page, int rows) {
        PageHelper.startPage(page,rows);
        //这边就是进行条件查询的情况的
        List<TbItemCat> list = itemCatMapper.findAll();
        //转换成列表和总条数返回出来
        PageInfo<TbItemCat> info = new PageInfo<>(list);
        Map<String, Object> map = new HashMap<>();
        map.put("total",info.getTotal());
        map.put("rows",info.getList());
        return map;
    }

    @Override
    public List<TbItemCat> findByParentId(Long parentId) {
        return itemCatMapper.findByParentId(parentId);
    }

    @Override
    public void addItemCat(TbItemCat itemCat) {
        itemCatMapper.addItemCat(itemCat);
    }

    @Override
    public void updateItemCat(TbItemCat itemCat) {
        itemCatMapper.updateItemCat(itemCat);
    }

    @Override
    public TbItemCat findById(Long id) {
        return itemCatMapper.findById(id);
    }

    @Override
    public List<Integer> deleteItemCat(Long[] ids) {

        //这是是来装有id的对象
        List<Integer> idLong=new ArrayList<>();
        for (Long id : ids) {
            //先根据id查看是否有下级，有的话就是不可以进行删除，没有的话就可以进行删除操作
            int count = itemCatMapper.CountByParentId(id);
            if (count==0){
                //证明这个是没有下级的，可以进行删除
                itemCatMapper.deleteItemCat(id);
            }else{
                idLong.add(id.intValue());
            }
        }
        return idLong;
    }
}

package com.pinyougou.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbItemCat;
import com.pinyougou.sellergoods.service.ItemCatService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: pinyougou-all
 * @description:
 * @author: YF
 * @create: 2018-10-17 16:12
 **/
@RestController
@RequestMapping("/itemCat")
public class ItemCatController {
    @Reference
    private ItemCatService itemCatService;


    /** 
    * @Description: 根据父类去进行查询
    * @Param: [parentId] 
    * @return: java.util.List<com.pinyougou.pojo.TbItemCat> 
    * @Author: Yin 
    * @Date: 2018/10/17 
    */ 
    @RequestMapping("/findByParentId")
    public List<TbItemCat> findByParentId(Long parentId){
        return itemCatService.findByParentId(parentId);
    }

    
    /** 
    * @Description: 根据父类的id去查找到这个分类的对象
    * @Param: [parentId] 
    * @return: com.pinyougou.pojo.TbItemCat 
    * @Author: Yin 
    * @Date: 2018/10/18 
    */ 
    @RequestMapping("/findOne")
    public TbItemCat findOne(Long parentId){
        return itemCatService.findById(parentId);
    }

    /** 
    * @Description: 查询到所有的分类的信息
    * @Param: [] 
    * @return: java.util.List<com.pinyougou.pojo.TbItemCat> 
    * @Author: Yin 
    * @Date: 2018/12/22 
    */ 
    @RequestMapping("/findAll")
    public List<TbItemCat> findAll(){
        return itemCatService.findAll();
    }
}

package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbItemCat;
import com.pinyougou.sellergoods.service.ItemCatService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @program: pinyougou-all
 * @description: 分类的控制层
 * @author: YF
 * @create: 2018-09-04 09:26
 **/
@RestController
@RequestMapping("/itemCat")
public class ItemCatController {
    @Reference
    private ItemCatService itemCatService;

    /** 
    * @Description: 查找到所有的分类
    * @Param: [] 
    * @return: java.util.List<com.pinyougou.pojo.TbItemCat> 
    * @Author: Yin 
    * @Date: 2018/9/4 
    */ 
    @RequestMapping("/findAll")
    public List<TbItemCat> findAll(){
        return itemCatService.findAll();
    }

    @RequestMapping("findByCondition")
    public Map<String,Object> findByCondition(int page, int rows){
        return itemCatService.findByCondition(page,rows);
    }

}

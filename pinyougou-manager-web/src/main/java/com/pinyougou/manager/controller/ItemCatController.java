package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.entity.ResponseResult;
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

    /** 
    * @Description: 分页的操作，找到所有的父类的   就parent_id为0
    * @Param: [page, rows] 
    * @return: java.util.Map<java.lang.String,java.lang.Object> 
    * @Author: Yin 
    * @Date: 2018/9/4 
    */ 
    @RequestMapping("findByCondition")
    public Map<String,Object> findByCondition(int page, int rows){
        return itemCatService.findByCondition(page,rows);
    }

    /** 
    * @Description: 根据父类的id去进行查找
    * @Param: [parentId] 
    * @return: java.util.List<com.pinyougou.pojo.TbItemCat> 
    * @Author: Yin 
    * @Date: 2018/9/4 
    */ 
    @RequestMapping("findByParentId")
    public List<TbItemCat> findByParentId(Long parentId){
        return itemCatService.findByParentId(parentId);
    }

    
    /** 
    * @Description: 添加分类的操作
    * @Param: [itemCat] 
    * @return: com.pinyougou.entity.ResponseResult<com.pinyougou.pojo.TbItemCat> 
    * @Author: Yin 
    * @Date: 2018/9/7 
    */ 
    @RequestMapping("/add")
    public ResponseResult<TbItemCat> addItemCat(@RequestBody TbItemCat  itemCat){
        try {
            System.out.println(itemCat.getTypeId());
            itemCatService.addItemCat(itemCat);
            return ResponseResult.success("添加成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.error("添加失败");
        }
    }

}

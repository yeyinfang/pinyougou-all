package com.pinyougou.manager.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.entity.ResponseResult;
import com.pinyougou.entity.Specification;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.sellergoods.service.SpecificationService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @program: pinyougou-all
 * @description: 规格管理的控制层
 * @author: YF
 * @create: 2018-09-01 10:50
 **/
@RestController
@RequestMapping("/specification")
public class SpecificationController {
    @Reference
    private SpecificationService specificationService;

    /** 
    * @Description: 查找所有的 
    * @Param: [] 
    * @return: java.util.List<com.pinyougou.pojo.TbSpecification> 
    * @Author: Yin 
    * @Date: 2018/9/2 
    */ 
    @RequestMapping("/findAll")
    public List<TbSpecification> findAll(){
        return specificationService.findAll();
    }

    /** 
    * @Description: 分页查找
    * @Param: [page, rows, specification] 
    * @return: java.util.Map<java.lang.String,java.lang.Object> 
    * @Author: Yin 
    * @Date: 2018/9/2 
    */ 
    @RequestMapping("/findByCondition")
    public Map<String,Object> findByCondition(int page,int rows,@RequestBody TbSpecification specification){
        return specificationService.findByCondition(page,rows,specification);
    }

    /** 
    * @Description: 添加规格的管理
    * @Param: [specification] 
    * @return: com.pinyougou.entity.ResponseResult<com.pinyougou.pojo.TbSpecification> 
    * @Author: Yin 
    * @Date: 2018/9/2 
    */ 
    @RequestMapping("/add")
    public ResponseResult<TbSpecification> addSpecification(@RequestBody Specification specification){
        try {
            specificationService.addSpecification(specification);
            return ResponseResult.success("添加成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.error("添加失败");
        }
    }

    @RequestMapping("/findOne")
    public Specification findById(Long id){
        return specificationService.findByOne(id);
    }

    /** 
    * @Description: 对于规格的修改的时候，要同时可以对规格选项进行修改
    * @Param: [specification] 
    * @return: com.pinyougou.entity.ResponseResult<com.pinyougou.pojo.TbSpecification> 
    * @Author: Yin 
    * @Date: 2018/9/2 
    */ 
    @RequestMapping("/update")
    public ResponseResult<Specification> updateSpecification(@RequestBody Specification specification){
        try {
            specificationService.updateSpecification(specification);
            return ResponseResult.success("修改成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.error("修改失败");
        }
    }

    @RequestMapping("/delete")
    public ResponseResult<Specification> deleteSpecification(Long[] ids){
        try {
            specificationService.deleteSpecification(ids);
            return ResponseResult.success("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.error("删除失败");
        }

    }

}

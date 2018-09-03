package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.entity.ResponseResult;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.sellergoods.service.BrandService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @program: pinyougou-all
 * @description: 品牌的控制层管理
 * @author: YF
 * @create: 2018-08-29 14:18
 **/
@RestController
@RequestMapping("/brand")
public class BrandController {
    @Reference
    private BrandService brandService;
    /** 
    * @Description: 获取到全部的品牌消息
    * @Param: [] 
    * @return: java.util.List<com.pinyougou.pojo.TbBrand> 
    * @Author: Yin 
    * @Date: 2018/8/29 
    */
    @RequestMapping("/findAll")
    public List<TbBrand> findAll(){
        return brandService.findAll();
    }

    /** 
    * @Description: 分页查询所有的数据 
    * @Param: [page, size] 
    * @return: java.util.List<com.pinyougou.pojo.TbBrand> 
    * @Author: Yin 
    * @Date: 2018/8/29 
    */ 
    @RequestMapping(value = "findByPage",method = RequestMethod.GET)
    //@ResponseBody
    public Map<String, Object> findByPage(@RequestParam(required = false,defaultValue = "1") Integer page,
                          @RequestParam(required = false,defaultValue = "10") Integer rows){
        return brandService.findByPage(page,rows);
    }
    
    /** 
    * @Description: 添加品牌信息
    * @Param: [brand] 
    * @return: com.pinyougou.entity.ResponseResult<com.pinyougou.pojo.TbBrand> 
    * @Author: Yin 
    * @Date: 2018/8/29 
    */ 
    @RequestMapping("/add")
    public ResponseResult<TbBrand> addBrand(@RequestBody TbBrand brand){

        return brandService.addBrand(brand);
    }

    /** 
    * @Description: 修改品牌信息，在这之前要先回显数据
    * @Param: [brand] 
    * @return: com.pinyougou.entity.ResponseResult<com.pinyougou.pojo.TbBrand> 
    * @Author: Yin 
    * @Date: 2018/8/29 
    */ 
    @RequestMapping("/update")
    public ResponseResult<TbBrand> updateBrand(@RequestBody TbBrand brand){
        try {
            brandService.updateBrand(brand);
            return ResponseResult.success("修改成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.error("修改失败");
        }
    }

    /** 
    * @Description: 根据id去找到对应的品牌消息，进行会显，然后修改
    * @Param: [id] 
    * @return: com.pinyougou.pojo.TbBrand 
    * @Author: Yin 
    * @Date: 2018/8/29 
    */ 
    @RequestMapping("/findOne")
    public TbBrand findById(Integer id){
        return brandService.findById(id);
    }

    /** 
    * @Description: 批量进行删除
    * @Param: [ids] 
    * @return: com.pinyougou.entity.ResponseResult<com.pinyougou.pojo.TbBrand> 
    * @Author: Yin 
    * @Date: 2018/8/30 
    */ 
    @RequestMapping("/delete")
    public ResponseResult<TbBrand> deleteBrand(String ids){
        try {
            brandService.deleteBrand(ids);
            return ResponseResult.success("删除成功！！");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.error("删除失败！！");
        }
    }

    /** 
    * @Description: 条件查询 
    * @Param: [brand, page, rows] 
    * @return: java.util.List<com.pinyougou.pojo.TbBrand> 
    * @Author: Yin 
    * @Date: 2018/8/30 
    */ 
    @RequestMapping("/findByCondition")
    public Map<String, Object> findByCondition(@RequestBody TbBrand brand,@RequestParam(required = false,defaultValue = "1") Integer page,
                                         @RequestParam(required = false,defaultValue = "10") Integer rows){
        return brandService.findByCondiction(brand,page,rows);
    }

    
    /** 
    * @Description: 模板上要使用的查询
    * @Param: [] 
    * @return: java.util.List<com.pinyougou.pojo.TbTypeTemplate> 
    * @Author: Yin 
    * @Date: 2018/9/3 
    */ 
    @RequestMapping("/selectOptionList")
    public List<Map> selectOptionList(){
        return brandService.selectOptionList();
    }
}


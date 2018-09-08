package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.entity.ResponseResult;
import com.pinyougou.pojo.TbItemCat;
import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.sellergoods.service.TypeTemplateService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @program: pinyougou-all
 * @description: 模板管理的控制层类
 * @author: YF
 * @create: 2018-09-03 09:46
 **/
@RestController
@RequestMapping("/typeTemplate")
public class TypeTemplateController {
    //引入服务层
    @Reference
    private TypeTemplateService typeTemplateService;

    /** 
    * @Description: 查找到所有的信息
    * @Param: [] 
    * @return: java.util.List<com.pinyougou.pojo.TbTypeTemplate> 
    * @Author: Yin 
    * @Date: 2018/9/3 
    */ 
    @RequestMapping("/findAll")
    public List<TbTypeTemplate> findAll(){
        return typeTemplateService.findAll();
    }

    /** 
    * @Description: 条件查询，也就是分页信息的处理
    * @Param: [page, rows, typeTemplate] 
    * @return: java.util.Map<java.lang.String,java.lang.Object> 
    * @Author: Yin 
    * @Date: 2018/9/3 
    */ 
    @RequestMapping("/findByCondition")
    public Map<String,Object> findByCondition(int page, int rows, @RequestBody TbTypeTemplate typeTemplate){
        return typeTemplateService.findByCondition(page,rows,typeTemplate);
    }

    /** 
    * @Description: 添加模板
    * @Param: [typeTemplate] 
    * @return: com.pinyougou.entity.ResponseResult<com.pinyougou.pojo.TbTypeTemplate> 
    * @Author: Yin 
    * @Date: 2018/9/3 
    */ 
    @RequestMapping("/add")
    public ResponseResult<TbTypeTemplate> addTypeTemplate(@RequestBody TbTypeTemplate typeTemplate){
        try {
            typeTemplateService.addTypeTemplate(typeTemplate);
            return ResponseResult.success("增加成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.error("增加失败");
        }
    }

    /** 
    * @Description: 修改模板
    * @Param: [typeTemplate] 
    * @return: com.pinyougou.entity.ResponseResult<com.pinyougou.pojo.TbTypeTemplate> 
    * @Author: Yin 
    * @Date: 2018/9/3 
    */ 
    @RequestMapping("/update")
    public ResponseResult<TbTypeTemplate> updateTypeTemplate(@RequestBody TbTypeTemplate typeTemplate){
        try {
            typeTemplateService.updateTypeTemplate(typeTemplate);
            return ResponseResult.success("修改成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.error("修改失败");
        }
    }

    /** 
    * @Description:  根据id找到对应的模板信息
    * @Param: [id] 
    * @return: com.pinyougou.pojo.TbTypeTemplate 
    * @Author: Yin 
    * @Date: 2018/9/3 
    */ 
    @RequestMapping("/findByOne")
    @ResponseBody
    public TbTypeTemplate findById(Long id){
        return typeTemplateService.findById(id);
    }

    
    /** 
    * @Description: 批量去删除这个模板的信息
    * @Param: [ids] 
    * @return: com.pinyougou.entity.ResponseResult<com.pinyougou.pojo.TbTypeTemplate> 
    * @Author: Yin 
    * @Date: 2018/9/3 
    */ 
    @RequestMapping("/delete")
    public ResponseResult<TbTypeTemplate> deleteTypeTemplate(Long[] ids){
        try {
            typeTemplateService.deleteTypeTemplate(ids);
            return ResponseResult.success("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.error("删除失败");
        }
    }

    /** 
    * @Description: 为了下拉列表做准备的，也就是进行显示的效果操作
    * @Param: [] 
    * @return: java.util.List<com.pinyougou.pojo.TbItemCat> 
    * @Author: Yin 
    * @Date: 2018/9/7 
    */ 
    @RequestMapping("/findTypeList")
    public List<Map> findTypeList(){
        return typeTemplateService.findTypeList();
    }

    
    /**
    * @Description:根据id查找到id和名字
    * @Param:  
    * @return:  
    * @Author: Yin 
    * @Date: 2018/9/8 
    */ 
    @RequestMapping("/findTypeTemplate")
    public TbTypeTemplate findTypeTemplate(Long id){
        return typeTemplateService.findTypeTemplate(id);
    }
}

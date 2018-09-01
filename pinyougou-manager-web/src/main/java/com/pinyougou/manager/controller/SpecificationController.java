package com.pinyougou.manager.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.sellergoods.service.SpecificationService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("/findAll")
    public List<TbSpecification> findAll(){
        return specificationService.findAll();
    }

    @RequestMapping("/findByCondition")
    public Map<String,Object> findByCondition(int page,int rows,@RequestBody TbSpecification specification){
        return specificationService.findByCondition(page,rows,specification);
    }

}

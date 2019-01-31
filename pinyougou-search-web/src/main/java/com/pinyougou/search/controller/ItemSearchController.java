package com.pinyougou.search.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.search.service.ItemSearchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @program: pinyougou-all
 * @description:
 * @author: YF
 * @create: 2019-01-31 22:10
 **/
@Controller
@RequestMapping("/itemsearch")
public class ItemSearchController {
    @Reference
    private ItemSearchService itemSearchService;

    /** 
    * @Description: solr的条件查询
    * @Param: [searchMap] 
    * @return: java.util.Map<java.lang.String,java.lang.Object> 
    * @Author: Yin 
    * @Date: 2019/1/31 
    */ 
    @RequestMapping("/search")
    public Map<String, Object> search(@RequestBody Map searchMap ){
        return  itemSearchService.search(searchMap);
    }

}

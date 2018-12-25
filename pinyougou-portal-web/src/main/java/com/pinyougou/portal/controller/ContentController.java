package com.pinyougou.portal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.content.service.ContentService;
import com.pinyougou.pojo.TbContent;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: pinyougou-all
 * @description: 广告管理的控制层
 * @author: YF
 * @create: 2018-12-25 17:31
 **/
@RestController
@RequestMapping("/content")
public class ContentController {
    @Reference
    private ContentService contentService;

    /** 
    * @Description: 根绝分类id去进行看是要进行那个图片的显示
    * @Param: [id] 
    * @return: java.util.List<com.pinyougou.pojo.TbContent> 
    * @Author: Yin 
    * @Date: 2018/12/25 
    */
    @RequestMapping("/findByCategoryId")
    public List<TbContent> findByCategoryId(Long id){
        return contentService.findByCategoryId(id);

    }
}

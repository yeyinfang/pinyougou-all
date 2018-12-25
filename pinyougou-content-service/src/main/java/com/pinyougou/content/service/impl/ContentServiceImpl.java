package com.pinyougou.content.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.content.service.ContentService;
import com.pinyougou.mapper.TbContentMapper;
import com.pinyougou.pojo.TbContent;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: pinyougou-all
 * @description: 内容的实现类
 * @author: YF
 * @create: 2018-12-24 17:16
 **/
@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private TbContentMapper contentMapper;

    @Override
    public Map<String, Object> findByCondition(TbContent content, int page, int rows) {
        PageHelper.startPage(page,rows);
        //查找到所有的广告信息
        Example example = new Example(TbContent.class);
        Example.Criteria criteria = example.createCriteria();
        if (content!=null){
            if (StringUtils.isNotBlank(content.getTitle())){
                criteria.andLike("title",content.getTitle());
            }
        }
        List<TbContent> contentList = contentMapper.select(content);
        PageInfo<TbContent> info = new PageInfo<>(contentList);
        Map<String, Object> map = new HashMap<>();
        map.put("total",info.getTotal());
        map.put("rows",info.getList());
        return map;
    }

    @Override
    public TbContent findOne(Long id) {
        TbContent content = contentMapper.selectByPrimaryKey(id);
        return content;
    }

    @Override
    public void updateContent(TbContent content) {
        contentMapper.updateByPrimaryKey(content);
    }

    @Override
    public void addContent(TbContent content) {
        contentMapper.insert(content);
    }

    @Override
    public List<TbContent> findByCategoryId(Long id) {
        return contentMapper.findByCategoryId(id);
    }
}

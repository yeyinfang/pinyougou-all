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
import org.springframework.data.redis.core.RedisTemplate;

import javax.persistence.Id;
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
    //缓存的redis
    @Autowired
    private RedisTemplate redisTemplate;

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
        //先查询出对应的id的分类id
        Long categoryId = contentMapper.selectByPrimaryKey(content.getId()).getCategoryId();
        //删除修改前的id
        redisTemplate.boundHashOps("content").delete(categoryId);
        contentMapper.updateByPrimaryKey(content);
        //判断修改后的id是不是一样的e
        if (categoryId.longValue()!=content.getCategoryId().longValue()){
            //清除现在的分组的
            redisTemplate.boundHashOps("content").delete(content.getCategoryId());
        }


    }

    @Override
    public void addContent(TbContent content) {
        contentMapper.insert(content);
        //添加之后，清空缓存里面的东西
        redisTemplate.boundHashOps("content").delete(content.getCategoryId());
    }

    @Override
    public List<TbContent> findByCategoryId(Long id) {
        //从缓存中去拿，减缓数据库的压力
        List<TbContent> list = (List<TbContent>) redisTemplate.boundHashOps("content").get(id);
        //进行判断看是否redis中存在这些数据
        if (list==null){
            System.out.println("从数据库读取广告");
            TbContent content = new TbContent();
            content.setCategoryId(id);
            content.setStatus("1");
            list= contentMapper.findByCategoryId(content);
            //保存到缓存中去
            redisTemplate.boundHashOps("content").put(id,list);
        }else{
            System.out.println("从缓存中读取广告");
        }
        return list;
    }

    @Override
    public void deleteContent(long[] ids) {
        for (long id : ids) {
            //先查询缓存中的看是否存在，然后进行删除
            Long categoryId = contentMapper.selectByPrimaryKey(id).getCategoryId();
            redisTemplate.boundHashOps("content").delete(categoryId);

            //删除这个广告信息
            contentMapper.deleteByPrimaryKey(id);
        }
    }
}

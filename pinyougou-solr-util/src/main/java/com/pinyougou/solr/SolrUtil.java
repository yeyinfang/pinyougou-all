package com.pinyougou.solr;

import com.alibaba.fastjson.JSON;
import com.github.abel533.entity.Example;
import com.pinyougou.mapper.TbItemMapper;
import com.pinyougou.pojo.TbItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @program: pinyougou-all
 * @description:
 * @author: YF
 * @create: 2019-01-31 17:37
 **/
@Component
public class SolrUtil {
    @Autowired
    private TbItemMapper itemMapper;

    @Autowired
    private SolrTemplate solrTemplate;

    /** 
    * @Description: 导入商品的操作
    * @Param: [] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2019/1/31 
    */ 
    public void importItemData(){
        Example example = new Example(TbItem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status","1");

        List<TbItem> itemList = itemMapper.selectByExample(example);
        System.out.println("===商品列表===");
        for(TbItem item:itemList){
            Map specMap= JSON.parseObject(item.getSpec());//将spec字段中的json字符串转换为map
            item.setSpecMap(specMap);//给带注解的字段赋值
            System.out.println(item.getTitle());
        }
        solrTemplate.saveBeans(itemList);
        solrTemplate.commit();
        System.out.println("===结束===");

    }

    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath*:spring/applicationContext.xml");
        SolrUtil solrUtil=  (SolrUtil) context.getBean("solrUtil");
        solrUtil.importItemData();
    }

}

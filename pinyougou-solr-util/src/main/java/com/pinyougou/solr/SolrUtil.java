package com.pinyougou.solr;

import com.pinyougou.mapper.TbItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    /** 
    * @Description: 导入商品的操作
    * @Param: [] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2019/1/31 
    */ 
    public void importItemData(){
        
    }

}

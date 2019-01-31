package com.pinyougou.search.service;

import java.util.Map;

public interface ItemSearchService {
    /** 
    * @Description: 搜索
    * @Param: [searchMap] 
    * @return: java.util.Map<java.lang.String,java.lang.Object> 
    * @Author: Yin 
    * @Date: 2019/1/31 
    */ 
    public Map<String,Object> search(Map searchMap);
}

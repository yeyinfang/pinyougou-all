package com.pinyougou.shop.controller;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: pinyougou-all
 * @description: 显示登陆的用户名的类
 * @author: YF
 * @create: 2018-10-11 14:35
 **/
@RestController
@RequestMapping("/login")
public class LoginController {
    /** 
    * @Description: 获取到登陆的那个姓名的存在
    * @Param: [] 
    * @return: java.util.Map 
    * @Author: Yin 
    * @Date: 2018/10/11 
    */ 
    @RequestMapping("name")
    public Map name(){
        //首先就是拿到权限框架的权限，然后获取到认证管理器，在来就是获取到名字的存在
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        //接下来要做的就是将名字给传输出来
        Map<String, String> map = new HashMap<>();
        map.put("loginName",name);
        return map;
    }
}

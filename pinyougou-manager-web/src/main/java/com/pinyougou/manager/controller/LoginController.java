package com.pinyougou.manager.controller;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: pinyougou-all
 * @description: 用于登陆的名字
 * @author: YF
 * @create: 2018-09-12 15:16
 **/
@RestController
@RequestMapping("/login")
public class LoginController {

    /** 
    * @Description: 获取到登陆到权限的名字也就是登录名
    * @Param: [] 
    * @return: java.util.Map 
    * @Author: Yin 
    * @Date: 2018/9/12 
    */ 
    @RequestMapping("name")
    public Map name(){
       //获取到框架中的用户名的信息，然后在进行保存
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(username);
        HashMap<String, String> map = new HashMap<>();
        map.put("loginName",username);
        return map;
    }
}

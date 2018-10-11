package com.pinyougou.shop.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbSeller;
import com.pinyougou.sellergoods.service.SellerService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: pinyougou-all
 * @description:
 * @author: YF
 * @create: 2018-10-10 14:46
 **/
public class UserDetailsServiceImpl implements UserDetailsService {
    /*获取到service，交给spring管理*/
    @Reference
    private SellerService sellerService;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
        grantedAuths.add(new SimpleGrantedAuthority("ROLE_SELLER"));
        //这个时候可以根据名字去得到商家对象
        TbSeller seller = sellerService.findByName(username);
        //System.out.println(username);
        //首先就是判断这个对象是否为空也就是这个商家是不是存在
        if (seller!=null){
            //这个时候在进行判断看商家的状态是否被审核通过的，不是的话也是不可以通过的
            if(seller.getStatus().equals("1")){
                return new User(username,seller.getPassword(), grantedAuths);
            }else{
                return null;
            }
        }else{
            return null;
        }

    }
}
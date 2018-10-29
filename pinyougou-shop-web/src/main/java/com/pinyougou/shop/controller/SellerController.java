package com.pinyougou.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.entity.ResponseResult;
import com.pinyougou.pojo.TbSeller;
import com.pinyougou.sellergoods.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.BaseDigestPasswordEncoder;
import org.springframework.security.authentication.encoding.BasePasswordEncoder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @program: pinyougou-all
 * @description: 这个是商家相关的类，也就是商家入驻等待被审核的操作
 * @author: YF
 * @create: 2018-09-11 20:14
 **/
@RestController
@RequestMapping("/seller")
public class SellerController {
    //创建服务层对象
    @Reference
    private SellerService sellerService;
    //将加密的对象给拿过来进行使用
    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;


    /** 
    * @Description: 增加商家，但是就是刚开始要进行审核的 
    * @Param: [seller] 
    * @return: com.pinyougou.entity.ResponseResult<com.pinyougou.pojo.TbSeller> 
    * @Author: Yin 
    * @Date: 2018/9/17 
    */ 
    @RequestMapping("/add")
    public ResponseResult<TbSeller> addSeller(@RequestBody TbSeller seller){
        //密码进行加密的设置  使用的是BCrypt算法
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //将密码进行加密的操作
        String password = passwordEncoder.encode(seller.getPassword());
        //将加密后的密码进行设置，也就是保存到数据库中的是一串我们看不懂的字符
        seller.setPassword(password);
        try {
            //设置审核的状态  0：未审核   1：已审核   2：审核未通过   3：关闭
            seller.setStatus("0");
            //设置创建申请的时间
            seller.setCreateTime(new Date());
            sellerService.addSeller(seller);
            return ResponseResult.success("申请成功，请等待审核结果");
        }catch (Exception e){
            return ResponseResult.error("申请失败，请重新申请");
        }
    }

    /** 
    * @Description: 根据用户名去找到对应的商家信息，然后进行保存的操作
    * @Param: [loginName] 
    * @return: com.pinyougou.pojo.TbSeller 
    * @Author: Yin 
    * @Date: 2018/10/11 
    */ 
    @RequestMapping("/findOne")
    @ResponseBody
    public TbSeller findOne(){
        String loginName = SecurityContextHolder.getContext().getAuthentication().getName();
        return sellerService.findOne(loginName);
    }

    /** 
    * @Description: 修改商家的信息
    * @Param: [seller] 
    * @return: com.pinyougou.entity.ResponseResult<com.pinyougou.pojo.TbSeller> 
    * @Author: Yin 
    * @Date: 2018/10/12 
    */ 
    @RequestMapping("/update")
    public ResponseResult<TbSeller> updateSeller(@RequestBody TbSeller seller){
        try {
            TbSeller tbSeller = sellerService.updateSeller(seller);
            return ResponseResult.success("修改成功",tbSeller);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.error("修改失败，请重试");
        }
    }

    
    /** 
    * @Description: 修改密码的功能操作
    * @Param: [passowrd, updatepassword] 
    * @return: com.pinyougou.entity.ResponseResult<com.pinyougou.pojo.TbSeller> 
    * @Author: Yin 
    * @Date: 2018/10/13 
    */ 
    @RequestMapping("/updatePassword")
    public ResponseResult<TbSeller> updatePassword(String password,String updatepassword){
        try {

            //根据名字找到对应的对象且去判断看这个密码是否正确
            //获取到登陆的用户名的存在
            String name = SecurityContextHolder.getContext().getAuthentication().getName();
            //先将密码进行了加密，在传给数据库中过去
          //  BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            TbSeller seller = sellerService.findOne(name);
            //对比了输入的密码和我从数据库中获取到的密码是不是一样的，true就是一样的
            boolean b = bcryptEncoder.matches(password, seller.getPassword());
            System.out.println(b);
            if (!b){//这是用户原本密码不正确的时候
                return ResponseResult.error("输入的原密码是错误的，请重试");
            }else{//这是用户的密码是正确的，那就进行修改
                //这个时候将上面查询出来的给进行覆盖掉的操作
                String jiamiPassword = bcryptEncoder.encode(updatepassword);
                seller.setPassword(jiamiPassword);
                return ResponseResult.success("密码修改成功！");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.error("密码修改失败");
        }
    }


}

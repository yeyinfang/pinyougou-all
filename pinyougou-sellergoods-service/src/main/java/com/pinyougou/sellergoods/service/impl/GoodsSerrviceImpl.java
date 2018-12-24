package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.entity.Goods;
import com.pinyougou.mapper.*;
import com.pinyougou.pojo.*;

import com.pinyougou.sellergoods.service.GoodsSerrvice;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: pinyougou-all
 * @description: 这是商品的实现类
 * @author: YF
 * @create: 2018-10-15 09:20
 **/
@Service(interfaceClass = GoodsSerrvice.class)
@Transactional
public class GoodsSerrviceImpl implements GoodsSerrvice {
    @Autowired
    private TbGoodsMapper goodsMapper;
    @Autowired
    private TbGoodsDescMapper goodsDescMapper;
    @Autowired
    private TbItemMapper itemMapper;
    @Autowired
    private TbItemCatMapper itemCatMapper;
    @Autowired
    private TbBrandMapper brandMapper;
    @Autowired
    private TbSellerMapper sellerMapper;



    //添加商品的操作
    @Override
    public void addGoods(Goods goods) {
        //设置商品的状态  0代表商品未审核   1审核中  2审核通过
        goods.getGoods().setAuditStatus("0");
        goodsMapper.addGoods(goods.getGoods());
        //在数据库中的语句中，我将这个数据的id给获取出来了
        goods.getGoodsDesc().setGoodsId(goods.getGoods().getId());
        goodsDescMapper.addGoodsDesc(goods.getGoodsDesc());

        //获取到存进来的列表的值
        List<TbItem> itemList = goods.getItemList();
        //判断是否启动了规格的管理操作
        saveItemList(goods);
    }
    
    /** 
    * @Description: 抽取这个方法来进行操作，看起来比较简洁
    * @Param: [goods] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/12/23 
    */ 
    public void saveItemList(Goods goods){
        if("1".equals(goods.getGoods().getIsEnableSpec())){
//这个是要进行保存
            for (TbItem item : goods.getItemList()) {
                //标题 就是sku+spec那些的关键字 为了检索起作用  索尼(SONY) Xperia Z Ultra (XL39h) 黑色 联通3G手机
                //获取到商品的标题
                String title = goods.getGoods().getGoodsName();
                //根据spec来找这个要加上的东西
                Map<String, Object> map = JSON.parseObject(item.getSpec());
                //循环遍历
                for (String key : map.keySet()) {
                    title += map.get(key);
                }
                //添加进item
                //设置标题
                item.setTitle(title);
                //抽取成方法，表示的是列表的一些参数设置
                setItemValue(goods,item);
                //这个列表的添加
                itemMapper.addItem(item);
            }
        }else{//这个是不启动规格的管理操作
            TbItem item = new TbItem();
            //设置标题的名称
            item.setTitle(goods.getGoods().getGoodsName());
            //设置价格
            item.setPrice(goods.getGoods().getPrice());
            //设置状态
            item.setStatus("1");//状态
            item.setIsDefault("1");//是否默认
            item.setNum(99999);//库存数量
            //设置规格选项
            item.setSpec("{}");
            setItemValue(goods,item);
            itemMapper.addItem(item);
        }
    }

    @Override
    public Map<String, Object> findByCondition(TbGoods goods, int page, int rows) {
        PageHelper.startPage(page,rows);
        Map<String ,Object> map = new HashMap<>();
        //进行判断，看是否存在这个商家，以防查找出来的不是这个商家
        if (goods.getSellerId()!=null && goods.getSellerId().length()>0){
            //查找到所有的商品的操作。也有可能是条件查询

            List<TbGoods> goodsList = goodsMapper.findByCondition(goods);
            System.out.println(goodsList);
            PageInfo<TbGoods> info = new PageInfo(goodsList);
            map.put("total",info.getTotal());
            map.put("rows",info.getList());
        }

        return map;
    }

    @Override
    public Goods findOne(Long id) {
        Goods goods = new Goods();
        //根据id查询到TbGoods的商品的信息
        TbGoods tbGoods = goodsMapper.findById(id);
        //进行设置
        goods.setGoods(tbGoods);
        //查找到goodDesc的信息
        TbGoodsDesc tbGoodsDesc = goodsDescMapper.findById(id);
        //设置
        goods.setGoodsDesc(tbGoodsDesc);
        //设置sku的列表
        List<TbItem> item = itemMapper.findById(id);
        goods.setItemList(item);
        return goods;
    }

    @Override
    public void updateGoods(Goods goods) {
        //更改的商品之后的状态要改成0，也就是未审核的状态
        goods.getGoods().setAuditStatus("0");
        //都进行更新的操作
        //goodsMapper.updateByPrimaryKey(goods.getGoods());
        goodsMapper.updateGoods(goods.getGoods());
        goodsDescMapper.updateGoodsDesc(goods.getGoodsDesc());

        //删除掉之前的sku列表，在进行重新的增加
        itemMapper.deleteSku(goods.getGoods().getId());

        //重新进行添加
        saveItemList(goods);
    }

    @Override
    public Map<String, Object> findAll(TbGoods goods, int page, int rows) {
        PageHelper.startPage(page,rows);
        //根据状态进行查询
        Map<String ,Object> map = new HashMap<>();
        Example example = new Example(TbGoods.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIsNull("isDelete");//指定条件为未逻辑删除记录
        if (goods!=null){//也就是有这个对象的情况
            //判断状态的情况
            //select * from tb_goods where auditStatus=?
            if (StringUtils.isNotBlank(goods.getAuditStatus())){
                criteria.andEqualTo("auditStatus",goods.getAuditStatus());
            }
            //这是商品名
            if (StringUtils.isNotBlank(goods.getGoodsName())){
                criteria.andEqualTo("goodsName",goods.getGoodsName());
            }
        }
        //进行查询
        List<TbGoods> goodsList = goodsMapper.selectByExample(example);
        PageInfo<TbGoods> info = new PageInfo<TbGoods>(goodsList);
        map.put("total",info.getTotal());
        map.put("rows",info.getList());
        return map;
    }

    @Override
    public void updateStatus(Long[] ids, String status) {
        for (Long id : ids) {
            TbGoods tbGoods = goodsMapper.selectByPrimaryKey(id);
            tbGoods.setAuditStatus(status);
            goodsMapper.updateByPrimaryKey(tbGoods);
        }
    }

    //我们这边是逻辑删除而不是物理删除
    //1是删除，0是存在的意思
    @Override
    public void deleteGoods(Long[] ids) {
        for (Long id : ids) {
            System.out.println(id);
            TbGoods goods = new TbGoods();
            goods.setId(id);
            goods.setIsDelete("1");
            goodsMapper.updateByPrimaryKey(goods);
        }
    }

    @Override
    public void SXJia(Long[] ids, String isMarketable) {
        for (Long id : ids) {
            TbGoods goods = goodsMapper.selectByPrimaryKey(id);
            //goods.setId(id);
            //进行判断商品的状态
            if (isMarketable.equals("0")){//下架的状态
                goods.setAuditStatus("4");
            }else {//上架
                goods.setAuditStatus("1");//将商品的状态设置为审核中的状态
            }
            goods.setIsMarketable(isMarketable);
            goodsMapper.updateByPrimaryKey(goods);
        }
    }


    /** 
    * @Description: 启用规格的情况 
    * @Param: [goods, item] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/11/5 
    */ 
    public void setItemValue(Goods goods, TbItem item) {
        //设置分类的id，设置的是三级分类
        item.setCategoryid(goods.getGoods().getCategory3Id());
        //设置创建时间
        item.setCreateTime(new Date());
        //设置修改时间   第一次的创建时间就是修改的时间
        item.setUpdateTime(new Date());
        //设置商品的id
        item.setGoodsId(goods.getGoods().getId());
        //设置卖家的id
        item.setSellerId(goods.getGoods().getSellerId());
        //设置分类的对象
        //根绝id查找到分类的这个模板对象
        TbItemCat itemCat = itemCatMapper.findById(item.getCategoryid());
        item.setCategory(itemCat.getName());

        //设置品牌对象
        //先进行查询
        Long brandId = goods.getGoods().getBrandId();
        if (brandId!=null){
            TbBrand brand = brandMapper.findById(new Integer(brandId + ""));
            item.setBrand(brand.getName());
        }
        //设置商家的对象
        TbSeller seller = sellerMapper.findOne(goods.getGoods().getSellerId());
        item.setSeller(seller.getNickName());//也就是这个商店的名称所在
        //保存图片
    }
}

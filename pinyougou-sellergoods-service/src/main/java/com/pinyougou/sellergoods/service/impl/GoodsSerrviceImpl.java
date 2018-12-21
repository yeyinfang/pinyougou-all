package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.pinyougou.entity.Goods;
import com.pinyougou.mapper.*;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbItem;
import com.pinyougou.pojo.TbItemCat;
import com.pinyougou.pojo.TbSeller;
import com.pinyougou.sellergoods.service.GoodsSerrvice;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @program: pinyougou-all
 * @description: 这是商品的实现类
 * @author: YF
 * @create: 2018-10-15 09:20
 **/
@Service
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
        if("1".equals(goods.getGoods().getIsEnableSpec())){
//这个是要进行保存
            for (TbItem item : itemList) {
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
        TbBrand brand = brandMapper.findById(new Integer(brandId + ""));
        item.setBrand(brand.getName());
        //设置商家的对象
        TbSeller seller = sellerMapper.findOne(goods.getGoods().getSellerId());
        item.setSeller(seller.getNickName());//也就是这个商店的名称所在
        //保存图片
    }
}

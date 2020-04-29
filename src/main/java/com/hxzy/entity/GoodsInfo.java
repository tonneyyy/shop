package com.hxzy.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * rw_goods_info
 * @author 
 */
@Data
public class GoodsInfo implements Serializable {
    /**
     * 商品编号
     */
    private Integer id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品货号
     */
    private String goods_serial;

    /**
     * 商品图片
     */
    private String img;

    /**
     * 商品排序值
     */
    private Integer sort;

    /**
     * 一级分类编号
     */
    private Integer type_cate_one;

    private String oneName;

    /**
     * 二级分类
     */
    private Integer type_cate_two;

    private String twoName;
    /**
     * 三级分类
     */
    private Integer type_cat_three;

    private String threeName;
    /**
     * 品牌id(预留可为空)
     */
    private Integer brand_id;

    /**
     * 商品库存
     */
    private Integer storeNumber;

    /**
     * 商品限售
     */
    private Integer limit_sell;

    /**
     * 商品已售
     */
    private Integer selled_number;

    /**
     * 报警数量
     */
    private Integer warn_number;

    /**
     * 市场价
     */
    private BigDecimal market_price;

    /**
     * 商店售价
     */
    private BigDecimal shopPrice;

    /**
     * 商品兑换积分
     */
    private Integer goods_point;

    /**
     * 默认0普通商品。其他值对应各种促销
     */
    private Integer act_type;

    /**
     * 默认1上架。 0下架
     */
    private Boolean goodsEnable;

    /**
     * 默认0。0非赠品，1赠品
     */
    private Boolean isGift;

    /**
     * 优惠价
     */
    private BigDecimal discount_price;

    /**
     * 享受优惠价的最低购买数量
     */
    private Integer discount_min;

    /**
     * 促销价
     */
    private BigDecimal sales_price;

    /**
     * 促销数量
     */
    private Integer sales_max;

    /**
     * 促销剩余数量
     */
    private Integer sales_rest;

    /**
     * 促销开始时间
     */
    private Date sales_start_time;

    /**
     * 促销结束时间
     */
    private Date sales_end_time;

    /**
     * 限时价
     */
    private BigDecimal limit_price;

    /**
     * 限时数量
     */
    private Integer limit_max;

    /**
     * 限时剩余数量
     */
    private Integer limit_rest;

    /**
     * 限时开始时间
     */
    private Date limit_start_time;

    /**
     * 限时结束时间
     */
    private Date limit_end_time;

    /**
     * 浏览次数
     */
    private Integer visits;

    private Integer type_sub_id;

    /**
     * 手动设置售卖数量
     */
    private Integer selled_define;

    /**
     * 商品详情
     */
    private String summary;

    private static final long serialVersionUID = 1L;
}
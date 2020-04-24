package com.hxzy.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 后台菜单表
 * @author 
 */
@Data
public class Menu implements Serializable {
    private Integer id;

    private String title;

    /**
     * 路由路径
     */
    private String path;

    /**
     * 路由名称
     */
    private String name;

    /**
     * 组件
     */
    private String component;

    /**
     * 一组路由默认导航
     */
    private String redirect;

    /**
     * 扩展的json参数
     */
    private String meta;

    private Integer sort;

    /**
     * 0隐藏，1显示
     */
    private Integer hidden;

    /**
     * 0代表一级路由
     */
    private Integer parentId;

    /**
     * 上级节点名称
     */
    private String parentName;

    private static final long serialVersionUID = 1L;
}
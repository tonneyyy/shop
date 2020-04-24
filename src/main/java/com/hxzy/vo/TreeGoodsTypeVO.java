package com.hxzy.vo;

import com.hxzy.entity.GoodsType;
import lombok.Data;

import java.util.List;

@Data
public class TreeGoodsTypeVO extends GoodsType {

    private List<TreeGoodsTypeVO> children;

    /**
     * 等级
     */
    private int level;

}

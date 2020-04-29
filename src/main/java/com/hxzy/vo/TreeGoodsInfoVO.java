package com.hxzy.vo;

import com.hxzy.entity.GoodsInfo;
import lombok.Data;

import java.util.List;

@Data
public class TreeGoodsInfoVO extends GoodsInfo {
    private List<TreeGoodsInfoVO> children;
}

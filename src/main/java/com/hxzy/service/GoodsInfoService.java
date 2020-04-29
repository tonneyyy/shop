package com.hxzy.service;

import com.hxzy.common.vo.ResponseMessage;
import com.hxzy.entity.GoodsInfo;


public interface GoodsInfoService {
    boolean deleteByPrimaryKey(Integer id);

    boolean insert(GoodsInfo record);

    GoodsInfo selectByPrimaryKey(Integer id);

    boolean updateByPrimaryKeySelective(GoodsInfo record);

    boolean updateByPrimaryKey(GoodsInfo record);

    ResponseMessage search();
}
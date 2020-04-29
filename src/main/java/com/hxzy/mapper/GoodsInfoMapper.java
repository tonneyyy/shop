package com.hxzy.mapper;

import com.hxzy.entity.GoodsInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsInfo record);

    GoodsInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsInfo record);

    int updateByPrimaryKey(GoodsInfo record);

    List<GoodsInfo> search();
}
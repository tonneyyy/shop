package com.hxzy.mapper;

import com.hxzy.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    /**
     * 全查询
     * @return
     */
    List<Menu> search();
}
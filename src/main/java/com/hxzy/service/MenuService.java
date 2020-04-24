package com.hxzy.service;

import com.hxzy.common.vo.ResponseMessage;
import com.hxzy.entity.Menu;

import java.util.List;

public interface MenuService {

    boolean deleteByPrimaryKey(Integer id);

    boolean insert(Menu record);

    Menu selectByPrimaryKey(Integer id);

    boolean updateByPrimaryKeySelective(Menu record);

    boolean updateByPrimaryKey(Menu record);

    /**
     * 全查询
     * @return
     */
   ResponseMessage search();
}

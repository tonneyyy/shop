package com.hxzy.vo;

import com.hxzy.entity.Menu;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TreeMenuVO extends Menu {

    /**
     * 子节点
     */
    private List<TreeMenuVO> children;

}

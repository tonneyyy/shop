package com.hxzy.controller.admin;

import com.hxzy.common.vo.ResponseMessage;
import com.hxzy.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin/menu")
public class AdminMenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 自定义树型节点数据
     * @return
     */
    @GetMapping(value = "/data")
    public ResponseMessage  ajaxData(){
        return this.menuService.search();
    }
}

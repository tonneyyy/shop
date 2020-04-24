package com.hxzy.controller.admin;

import com.hxzy.common.vo.PageSearch;
import com.hxzy.common.vo.ResponseMessage;
import com.hxzy.entity.Role;
import com.hxzy.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/admin")
@RestController
public class AdminRoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/role/data")
    public ResponseMessage  ajaxData(PageSearch pageSearch){
        return this.roleService.search(pageSearch);
    }

    /**
     * 新增时候roleName判断,roleId=0,   修改时候 roleName 判断 ,roleId!=0
     * @param role
     * @return
     */
    @PostMapping(value = "/role/exists")
    public ResponseMessage existsName(Role role){
        return this.roleService.existsName(role);
    }

    //新增或修改保存
    @PostMapping(value = "/role/save")
    public ResponseMessage saveData(Role role){
        boolean result=true;
       //新增
       if(role.getRoleId()==null || role.getRoleId()==0){
            result=this.roleService.insert(role);
       }else{
           //修改
           result=this.roleService.updateByPrimaryKey(role);
       }
        ResponseMessage  rm=result? ResponseMessage.success(): ResponseMessage.failed();
       return rm;
    }

}

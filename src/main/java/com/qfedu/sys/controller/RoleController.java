package com.qfedu.sys.controller;

import com.qfedu.sys.domain.RoleVo;
import com.qfedu.sys.service.RoleService;
import com.qfedu.sys.util.DataGridView;
import com.qfedu.sys.util.resultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("role")
@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;
    @RequestMapping("loadAllRole")
    @ResponseBody
    //初始化角色表单
    public DataGridView loadAllRole(RoleVo roleVo){
        return roleService.loadAllRole(roleVo);
    }
    @RequestMapping("addRole")
    @ResponseBody
    //添加角色
    public resultObj addRole(RoleVo roleVo){

        try {
            roleService.addRole(roleVo);
            return resultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return resultObj.ADD_ERROR;
        }
    }
    @RequestMapping("deleteRole")
    @ResponseBody
    //删除角色
    public resultObj deleteRole(RoleVo roleVo){
        try {
            roleService.deleteRole(roleVo);
            return resultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return resultObj.DELETE_ERROR;
        }
    }
    @RequestMapping("updateRole")
    @ResponseBody
    //修改角色
    public resultObj updateRole(RoleVo roleVo){
        try {
            roleService.updateRole(roleVo);
            return resultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return resultObj.UPDATE_ERROR;
        }
    }
    @RequestMapping("deleteBatchRole")
    @ResponseBody
    //批量删除角色
    public resultObj deleteBatchRole(RoleVo roleVo){
        try {
            roleService.deleteBatchRole(roleVo);
            return resultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return resultObj.DISPATCH_ERROR;
        }
    }
    //分配角色菜单
    @RequestMapping("initRoleMenuTreeJson")
    @ResponseBody
    public DataGridView initRoleMenuTreeJson(Integer roleid){
       return roleService.selectMenuByRoleId(roleid);
    }
    //更改角色菜单权限
    @RequestMapping("saveRoleMenu")
    @ResponseBody
    public resultObj saveRoleMenu(RoleVo roleVo){
        try {
            this.roleService.saveRoleMenu(roleVo);
            return resultObj.DISPATCH_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return resultObj.DISPATCH_ERROR;
        }
    }
}

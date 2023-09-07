package com.qfedu.sys.controller;

import com.qfedu.sys.domain.UserVo;
import com.qfedu.sys.domain.UserVo;
import com.qfedu.sys.service.UserService;
import com.qfedu.sys.util.DataGridView;
import com.qfedu.sys.util.resultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    //加载用户
    @ResponseBody
    @RequestMapping("loadAllUser")
    public DataGridView loadAllUser(UserVo userVo){
        return userService.loadAllUser(userVo);
    }
    //添加用户
    @ResponseBody
    @RequestMapping("addUser")
    public resultObj addUser(UserVo UserVo){
        try {
            userService.addUser(UserVo);
            return resultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return resultObj.ADD_ERROR;
        }
    }
    //修改用户
    @ResponseBody
    @RequestMapping("updateUser")
    public resultObj updateUser(UserVo UserVo){
        try {
            userService.updateUser(UserVo);
            return resultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return resultObj.UPDATE_ERROR;
        }
    }
    //删除用户
    @ResponseBody
    @RequestMapping("deleteUser")
    public resultObj deleteUser(UserVo UserVo){
        try {
            userService.deleteUser(UserVo);
            return resultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return resultObj.DELETE_ERROR;
        }
    }
    // 批量删除
    @ResponseBody
    @RequestMapping("deleteBatchUser")
    public resultObj deleteBatchUser(UserVo UserVo){
        try {
            userService.deleteBatchUser(UserVo);
            return resultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return resultObj.DELETE_ERROR;
        }
    }
    //重置密码
    @ResponseBody
    @RequestMapping("resetUserPwd")
    public resultObj resetUserPwd(UserVo userVo){
        try {
            this.userService.resetUserPwd(userVo);
            return resultObj.RESET_SUCCESS;
        }catch (Exception e){
            return resultObj.RESET_ERROR;
        }
    }
    @ResponseBody
    @RequestMapping("initUserRole")
    public DataGridView initUserRole(UserVo userVo){
        return userService.initUserRole(userVo);
    }
    //保存权限
    @ResponseBody
    @RequestMapping("saveUserRole")
    public resultObj saveUserRole(UserVo userVo){
        try {
            this.userService.saveUserRole(userVo);
            return resultObj.DISPATCH_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return resultObj.DISPATCH_ERROR;
        }
    }
}

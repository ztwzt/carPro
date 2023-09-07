package com.qfedu.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("sys")
public class SysController {
    @RequestMapping("toMenuManager")
    public String toMenuManager(){
        return "system/menu/menuManager";
    }
    @RequestMapping("dTreeDemo")
    public String dTree(){
        return "system/menu/dTreeDemo";
    }
    @RequestMapping("toMenuLeft")
    public String toMenuLeft(){
        return "system/menu/MenuLeft";
    }
    @RequestMapping("toMenuRight")
    public String toMenuRight(){
        return "system/menu/MenuRight";
    }
    //../sys/toRoleManager.action
    @RequestMapping("toRoleManager")
    public String toRoleManager(){
        return "system/role/roleManager";
    }
    @RequestMapping("toUserManager")
    public String toUserManager(){
        return "system/user/userManager";
    }
    //  /carPro/sys/toLogInfoManager.action\
    @RequestMapping("toLogInfoManager")
    public String toLogInfoManager(){
        return "system/logInfo/logInfoManager";
    }
}

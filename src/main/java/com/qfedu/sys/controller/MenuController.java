package com.qfedu.sys.controller;

import com.qfedu.sys.constant.sysConstant;
import com.qfedu.sys.domain.Menu;
import com.qfedu.sys.domain.MenuVo;
import com.qfedu.sys.domain.TreeNode;
import com.qfedu.sys.domain.User;
import com.qfedu.sys.service.MenuService;
import com.qfedu.sys.util.DataGridView;
import com.qfedu.sys.util.TreeNodeBuilder;
import com.qfedu.sys.util.WebUtils;
import com.qfedu.sys.util.resultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("menu")
public class MenuController {
    @Autowired
    private MenuService menuService;
    //加载左侧菜单栏
    @ResponseBody
    @RequestMapping("loadIndexLeftMenuJson")
    public List<TreeNode> loadIndexLeftMenuJson(MenuVo menuVo)
    {
        //得到当前登录用户对象
        User user=(User) WebUtils.getHttpSession().getAttribute("user");
        menuVo.setAvailable(sysConstant.AVAILABLE_TRUE);
        List<Menu> list=null;
        if(user.getType()==sysConstant.USER_TYPE_SUPER)//如果是超级管理员，则查询所有菜单
        {
           list =menuService.queryAllMenuForList(menuVo);
        }else{
            //非管理员
            //list =menuService.queryNormalMenuForList(menuVo);

        }
        //声明List nodes对象，给对象辅赋值
        List<TreeNode> nodes=new ArrayList<>();
        for(Menu menu:list){
            Integer id = menu.getId();
            Integer pid = menu.getPid();
            String title = menu.getTitle();
            String icon = menu.getIcon();
            String href = menu.getHref();
             Boolean spread=menu.getSpread()==sysConstant.SPREAD_TRUE ?true :false;
             String target=menu.getTarget();
             nodes.add(new TreeNode(id,pid,title,icon,href,spread,target));
        }
        return TreeNodeBuilder.builder(nodes,1);
    }
    //加载菜单管理
    @ResponseBody
    @RequestMapping("loadMenuManagerLeftTreeJson")
    public DataGridView loadMenuManagerLeftTreeJson(MenuVo menuVo){
        menuVo.setAvailable(sysConstant.AVAILABLE_TRUE);
        List<Menu> list = this.menuService.queryAllMenuForList(menuVo);
        List<TreeNode> nodes = new ArrayList<>();
        for (Menu menu : list) {
            Integer id = menu.getId();
            Integer pid = menu.getPid();
            String title = menu.getTitle();
            String icon = menu.getIcon();
            String href = menu.getHref();
            Boolean spread = menu.getSpread() == sysConstant.SPREAD_TRUE ? true : false;
            String target = menu.getTarget();
            nodes.add(new TreeNode(id, pid, title, icon, href,
                    spread, target));
        }
        return new DataGridView(nodes);
    }
    //加载菜单
    @ResponseBody
    @RequestMapping("loadAllMenu")
    public DataGridView loadAllMenu(MenuVo menuVo){
      return menuService.loadAllMenu(menuVo);
    }
    //添加菜单
    @ResponseBody
    @RequestMapping("addMenu")
    public resultObj addMenu(MenuVo menuVo){
        try {
            menuService.addMenu(menuVo);
            return resultObj.ADD_SUCCESS;
        } catch (Exception e) {
           e.printStackTrace();
           return resultObj.ADD_ERROR;
        }
    }
    //修改菜单
    @ResponseBody
    @RequestMapping("updateMenu")
    public resultObj updateMenu(MenuVo menuVo){
        try {
            menuService.updateMenu(menuVo);
            return resultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return resultObj.UPDATE_ERROR;
        }
    }
    //删除菜单
    @ResponseBody
    @RequestMapping("deleteMenu")
    public resultObj deleteMenu(MenuVo menuVo){
        try {
            menuService.deleteMenu(menuVo);
            return resultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return resultObj.DELETE_ERROR;
        }
    }
    //检查是否有子节点
    @RequestMapping("checkMenuHasChildren")
    @ResponseBody
    public resultObj checkMenuHasChildren(MenuVo menuVo){
        Integer count=menuService.checkMenuHasChildren(menuVo);
        if(count>0){
            return resultObj.STATUS_TRUE;
        }else{
            return resultObj.STATUS_FALSE;
        }
    }

    // 批量删除
    @ResponseBody
    @RequestMapping("deleteBatchMenu")
    public resultObj deleteBatchMenu(MenuVo menuVo){
        try {
            menuService.deleteBatchMenu(menuVo);
            return resultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return resultObj.DELETE_ERROR;
        }
    }
}

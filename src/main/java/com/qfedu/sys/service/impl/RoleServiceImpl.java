package com.qfedu.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.sys.constant.sysConstant;
import com.qfedu.sys.domain.*;
import com.qfedu.sys.mapper.MenuMapper;
import com.qfedu.sys.mapper.RoleMapper;
import com.qfedu.sys.service.RoleService;
import com.qfedu.sys.util.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public void addRole(RoleVo roleVo) {
        roleMapper.addRole(roleVo);
    }

    //更改角色菜单权限
    @Override
    public void saveRoleMenu(RoleVo roleVo) {
        roleMapper.deleteRoleAndMenu(roleVo);
        roleMapper.InsertRoleAndMenu(roleVo);
    }

    //分配角色菜单
    @Override
    public DataGridView selectMenuByRoleId(Integer roleid) {
        MenuVo menuVo=new MenuVo();
        menuVo.setAvailable(sysConstant.AVAILABLE_TRUE);
        List<Menu> listMenu= menuMapper.getAllMenu(menuVo);
        Integer[] mids=roleMapper.getMids(roleid);
        List<TreeNode> listTree=new ArrayList<>();
        for(Menu menu:listMenu){
            Integer id = menu.getId();
            Integer pid = menu.getPid();
            String title = menu.getTitle();
            Boolean spread = menu.getSpread()==sysConstant.SPREAD_TRUE?true:false;
            String checkArr=sysConstant.CODE_ZERO+"";
            for(Integer mid:mids){
                if(id==mid)
                {
                     checkArr= sysConstant.CODE_ONE+"";
                     break;
                }
            }
            TreeNode treeNode=new TreeNode(id,pid,title,spread,checkArr);
            listTree.add(treeNode);
        }
        return new DataGridView(listTree);
    }

    @Override
    public void deleteRole(RoleVo roleVo) {
        roleMapper.deleteRole(roleVo);
    }

    @Override
    public void updateRole(RoleVo roleVo) {
        roleMapper.updateRole(roleVo);
    }

    @Override
    public void deleteBatchRole(RoleVo roleVo) {
        roleMapper.deleteBatchRole(roleVo.getIds());
    }

    //初始化角色表单
    @Override
    public DataGridView loadAllRole(RoleVo roleVo) {
        Page<Role> page= PageHelper.startPage(roleVo.getPage(), roleVo.getLimit());
        List<Role> list=roleMapper.loadAllRole(roleVo);
        return new DataGridView(page.getTotal(),list);
    }
}

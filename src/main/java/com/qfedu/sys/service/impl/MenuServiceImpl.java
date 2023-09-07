package com.qfedu.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.sys.domain.Menu;
import com.qfedu.sys.domain.MenuVo;
import com.qfedu.sys.mapper.MenuMapper;
import com.qfedu.sys.service.MenuService;
import com.qfedu.sys.util.DataGridView;
import com.qfedu.sys.util.resultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public void addMenu(MenuVo menuVo) {
        menuMapper.addMenu(menuVo);
    }

    @Override
    public void updateMenu(MenuVo menuVo) {
        menuMapper.updateMenu(menuVo);
    }

    @Override
    public void deleteMenu(MenuVo menuVo) {
         menuMapper.deleteMenu(menuVo);
    }

    @Override
    public Integer checkMenuHasChildren(MenuVo menuVo) {
        return menuMapper.checkMenuHasChildren(menuVo.getId());
    }

    @Override
    public void deleteBatchMenu(MenuVo menuVo) {
       menuMapper.deleteBatchMenu(menuVo);
    }

    //加载菜单
    @Override
    public DataGridView loadAllMenu(MenuVo menuVo) {
        Page<Menu> page=PageHelper.startPage(menuVo.getPage(), menuVo.getLimit());
        List<Menu> list=this.menuMapper.getAllMenu(menuVo);
        return new DataGridView(page.getTotal(),list);
    }

    //菜单管理
    @Override
    public List<Menu> queryAllMenuForList(MenuVo menuVo) {
        return menuMapper.getAllMenu(menuVo);
    }
}

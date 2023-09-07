package com.qfedu.sys.service;

import com.qfedu.sys.domain.Menu;
import com.qfedu.sys.domain.MenuVo;
import com.qfedu.sys.util.DataGridView;
import com.qfedu.sys.util.resultObj;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuService {
    public List<Menu> queryAllMenuForList(MenuVo menuVo);

    //加载菜单
    DataGridView loadAllMenu(MenuVo menuVo);

    void addMenu(MenuVo menuVo);

    void updateMenu(MenuVo menuVo);

    void deleteMenu(MenuVo menuVo);

    void deleteBatchMenu(MenuVo menuVo);

    Integer checkMenuHasChildren(MenuVo menuVo);
}

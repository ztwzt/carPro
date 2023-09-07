package com.qfedu.sys.mapper;

import com.qfedu.sys.domain.Menu;
import com.qfedu.sys.domain.MenuVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {

    List<Menu> getAllMenu(MenuVo menuVo);

    void addMenu(MenuVo menuVo);

    void updateMenu(MenuVo menuVo);

    void deleteMenu(MenuVo menuVo);

    void deleteBatchMenu(MenuVo menuVo);

    Integer checkMenuHasChildren(@Param("id") Integer id);



    //加载菜单

}

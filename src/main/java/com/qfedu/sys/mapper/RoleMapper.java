package com.qfedu.sys.mapper;

import com.qfedu.sys.domain.Role;
import com.qfedu.sys.domain.RoleVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    List<Role> loadAllRole(RoleVo roleVo);

    void addRole(RoleVo roleVo);

    void deleteRole(RoleVo roleVo);

    void updateRole(RoleVo roleVo);

    void deleteBatchRole(@Param("ids") Integer[] ids);
    //根据roleid 获取 mids
    Integer[] getMids(Integer roleid);

    void deleteRoleAndMenu(RoleVo roleVo);

    void InsertRoleAndMenu(RoleVo roleVo);
}

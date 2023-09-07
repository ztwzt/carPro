package com.qfedu.sys.service;

import com.qfedu.sys.domain.RoleVo;
import com.qfedu.sys.util.DataGridView;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {

    //初始化角色表单
    DataGridView loadAllRole(RoleVo roleVo);

    void addRole(RoleVo roleVo);

    void deleteRole(RoleVo roleVo);

    void updateRole(RoleVo roleVo);

    void deleteBatchRole(RoleVo roleVo);


    DataGridView selectMenuByRoleId(Integer roleid);

    void saveRoleMenu(RoleVo roleVo);
}

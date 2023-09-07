package com.qfedu.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.sys.constant.sysConstant;
import com.qfedu.sys.domain.Role;
import com.qfedu.sys.domain.RoleVo;
import com.qfedu.sys.domain.User;
import com.qfedu.sys.domain.UserVo;
import com.qfedu.sys.mapper.RoleMapper;
import com.qfedu.sys.mapper.UserMapper;
import com.qfedu.sys.service.UserService;
import com.qfedu.sys.util.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public void addUser(UserVo userVo) {
        String defaultPwd= DigestUtils.md5DigestAsHex(sysConstant.USER_DEFAULT_PWD.getBytes());
        userVo.setPwd(defaultPwd);
        userVo.setType(sysConstant.USER_TYPE_NORMAL);
        userMapper.addUser(userVo);
    }

    @Override
    public void updateUser(UserVo userVo) {
        this.userMapper.updateUser(userVo);
    }

    @Override
    public void deleteUser(UserVo userVo) {
        userMapper.deleteUser(userVo);
    }

    @Override
    public void deleteBatchUser(UserVo userVo) {
        userMapper.deleteBatchUser(userVo);
    }


    @Override
    public void saveUserRole(UserVo userVo) {
        Integer[] roleids=userVo.getIds();
        userMapper.deleteRids(roleids);
        if(roleids!=null && roleids.length>0){
            userMapper.addRidsAndUids(userVo);
        }
    }

    @Override
    public DataGridView initUserRole(UserVo userVo) {
        Integer[] rids=userMapper.getRidsByUserId(userVo.getUserid());
        RoleVo roleVo=new RoleVo();
        List<Role> roles=roleMapper.loadAllRole(roleVo);
        List<Map<String,Object>> data = new ArrayList<>();
        for(Role role:roles){
            Boolean LAY_CHECKED=false;
            for(Integer rid : rids){
                if(rid==role.getRoleid()){
                    LAY_CHECKED=true;
                }
            }
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("roleid",role.getRoleid());
            map.put("rolename",role.getRolename());
            map.put("roledesc",role.getRoledesc());
            map.put("LAY_CHECKED",LAY_CHECKED);
            data.add(map);
        }
        return new DataGridView(data);
    }

    @Override
    public void resetUserPwd(UserVo userVo) {
        String defaultPwd= DigestUtils.md5DigestAsHex(sysConstant.USER_DEFAULT_PWD.getBytes());
        userVo.setPwd(defaultPwd);
        userMapper.resetUserPwd(userVo);
    }

    @Override
    public DataGridView loadAllUser(UserVo userVo) {
        Page<User> page= PageHelper.startPage(userVo.getPage(),userVo.getLimit());
        List<User> list=userMapper.loadAllUser(userVo);
        return new DataGridView(page.getTotal(),list);
    }
}

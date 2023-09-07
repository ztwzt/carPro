package com.qfedu.sys.service.impl;

import com.qfedu.sys.domain.User;
import com.qfedu.sys.domain.UserVo;
import com.qfedu.sys.mapper.UserMapper;
import com.qfedu.sys.service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

@Service
@Transactional
public class loginServiceImpl implements loginService {

    @Autowired
    private UserMapper userMapper;
    //用户登录核心方法
    @Override
    public User login(UserVo userVo) {
        //userVo用户密码进行MD5加密操作
        String pwd=DigestUtils.md5DigestAsHex(userVo.getPwd().getBytes());
        userVo.setPwd(pwd);
        //
        return userMapper.login(userVo);
    }
}

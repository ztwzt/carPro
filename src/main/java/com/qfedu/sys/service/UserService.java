package com.qfedu.sys.service;

import com.qfedu.sys.domain.User;
import com.qfedu.sys.domain.UserVo;
import com.qfedu.sys.util.DataGridView;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

     void addUser(UserVo userVo) ;

     void updateUser(UserVo userVo);
     void deleteUser(UserVo userVo);

     void deleteBatchUser(UserVo userVo);

    DataGridView loadAllUser(UserVo userVo);

    void resetUserPwd(UserVo userVo);

    DataGridView initUserRole(UserVo userVo);

    void saveUserRole(UserVo userVo);
}

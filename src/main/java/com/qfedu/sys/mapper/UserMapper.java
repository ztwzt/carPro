package com.qfedu.sys.mapper;

import com.qfedu.sys.domain.User;
import com.qfedu.sys.domain.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //查询用户
    List<User> loadAllUser(UserVo userVo);

    User login(UserVo userVo);

    void addUser(UserVo userVo);

    void updateUser(UserVo userVo);

    void deleteBatchUser(UserVo userVo);

    void deleteUser(UserVo userVo);

    void resetUserPwd(UserVo userVo);

    Integer[] getRidsByUserId(Integer userid);

    void deleteRids(@Param("roleids") Integer[] roleids);

    void addRidsAndUids(UserVo userVo);
}

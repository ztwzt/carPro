package com.qfedu.bus.mapper;

import com.qfedu.bus.Vo.CheckVo;
import com.qfedu.bus.domain.Check;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckMapper {

    //表格初始化
    List<Object> loadAllCheck(CheckVo checkVo);
    Check queryAllload(String rentId);

    //保存表单数据
    void saveCheck(CheckVo checkVo);

    // 修改检查表
    void updateCheck(CheckVo checkVo);
    //删除检查表
    void deleteCheck(String checkid);

    //批量删除
    void deleteBatchCheck(@Param("ids") String[] ids);
}

package com.qfedu.sys.mapper;

import com.qfedu.sys.domain.LogInfo;
import com.qfedu.sys.domain.LogInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogMapper {
    List<LogInfo> loadAllLogInfo(LogInfoVo logInfoVo);

    void deleteLogInfo(Integer id);

    void deleteBatchLogInfo(@Param("ids") Integer[] ids);
}

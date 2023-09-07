package com.qfedu.sys.service;

import com.qfedu.sys.domain.LogInfoVo;
import com.qfedu.sys.util.DataGridView;
import org.springframework.stereotype.Service;

@Service
public interface LogService {
    //加载日志
    DataGridView loadAllLogInfo(LogInfoVo logInfoVo);

    void deleteLogInfo(Integer id);

    void deleteBatchLogInfo(LogInfoVo logInfoVo);
}

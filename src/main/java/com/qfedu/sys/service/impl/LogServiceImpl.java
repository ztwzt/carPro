package com.qfedu.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.sys.domain.LogInfo;
import com.qfedu.sys.domain.LogInfoVo;
import com.qfedu.sys.mapper.LogMapper;
import com.qfedu.sys.service.LogService;
import com.qfedu.sys.util.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;

    @Override
    public void deleteLogInfo(Integer id) {
        logMapper.deleteLogInfo(id);
    }

    @Override
    public void deleteBatchLogInfo(LogInfoVo logInfoVo) {
        logMapper.deleteBatchLogInfo(logInfoVo.getIds());
    }

    @Override
    public DataGridView loadAllLogInfo(LogInfoVo logInfoVo) {
        Page<LogInfo> page= PageHelper.startPage(logInfoVo.getPage(),logInfoVo.getLimit());
       List<LogInfo> data= logMapper.loadAllLogInfo(logInfoVo);
       return new DataGridView(page.getTotal(),data);
    }
}

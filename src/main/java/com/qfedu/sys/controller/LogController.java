package com.qfedu.sys.controller;

import com.qfedu.sys.domain.LogInfoVo;
import com.qfedu.sys.service.LogService;
import com.qfedu.sys.util.DataGridView;
import com.qfedu.sys.util.resultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("logInfo")
public class LogController {
    @Autowired
    private LogService logService;

    @ResponseBody
    @RequestMapping("loadAllLogInfo")
    public DataGridView loadAllLogInfo(LogInfoVo logInfoVo){
        return logService.loadAllLogInfo(logInfoVo);
    }
    @ResponseBody
    @RequestMapping("deleteLogInfo")
    public resultObj deleteLogInfo(Integer id){
        try {
            logService.deleteLogInfo(id);
            return resultObj.DELETE_SUCCESS;
        } catch (Exception e) {
           e.printStackTrace();
           return resultObj.DELETE_ERROR;
        }
    }
    @ResponseBody
    @RequestMapping("deleteBatchLogInfo")
    public resultObj deleteBatchLogInfo(LogInfoVo logInfoVo){
        try {
            logService.deleteBatchLogInfo(logInfoVo);
            return resultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return resultObj.DELETE_ERROR;
        }
    }
}

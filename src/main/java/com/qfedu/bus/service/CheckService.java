package com.qfedu.bus.service;

import com.qfedu.bus.Vo.CheckVo;
import com.qfedu.sys.util.DataGridView;

import java.util.Map;

public interface CheckService {
    //初始化表单
    public Map<String,Object> initCheckFormData(String rentid);

    void saveCheck(CheckVo checkVo);

    //表格初始化
    DataGridView loadAllCheck(CheckVo checkVo);
    //修改检查表
    void updateCheck(CheckVo checkVo);
    //删除检查表
    void deleteCheck(String checkid);
    //批量删除
    void deleteBatchCheck(String[] ids);
}

package com.qfedu.bus.controller;

import com.qfedu.bus.Vo.CheckVo;
import com.qfedu.bus.domain.Rent;
import com.qfedu.bus.service.CheckService;
import com.qfedu.bus.service.RentService;
import com.qfedu.sys.util.DataGridView;
import com.qfedu.sys.util.resultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("check")
public class CheckController {
    @Autowired
    private RentService rentService;
    @Autowired
    private CheckService checkService;
    //check单号是否存在
    @ResponseBody
    @RequestMapping("checkRentExist")
    public Rent checkRentExist(String rentid){
        try {
            Rent rent=  rentService.queryRenyById(rentid);
            return rent;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    //初始化表单
    @ResponseBody
    @RequestMapping("initCheckFormData")
    public Map<String,Object> initCheckFormData(String rentid){
        return checkService.initCheckFormData(rentid);
    }
    //保存表单
    @RequestMapping("saveCheck")
    @ResponseBody
    public resultObj saveCheck(CheckVo checkVo){
        try {
            checkService.saveCheck(checkVo);
            return resultObj.ADD_SUCCESS;
        } catch (Exception e) {
           e.printStackTrace();
           return resultObj.ADD_ERROR;
        }
    }
    //表格数据初始化
    @RequestMapping("loadAllCheck")
    @ResponseBody
    public DataGridView loadAllCheck(CheckVo checkVo){
       return checkService.loadAllCheck(checkVo);
    }
    //修改检查表
    @RequestMapping("updateCheck")
    @ResponseBody
    public resultObj updateCheck(CheckVo checkVo){
        try {
            checkService.updateCheck(checkVo);
            return resultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return resultObj.UPDATE_ERROR;
        }
    }
    //删除检查表
    @RequestMapping("deleteCheck")
    @ResponseBody
    public resultObj deleteCheck(String checkid){
        try {
            checkService.deleteCheck(checkid);
            return resultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return resultObj.DELETE_ERROR;
        }
    }
    //批量删除
    @RequestMapping("deleteBatchCheck")
    @ResponseBody
    public resultObj deleteBatchCheck(CheckVo checkVo){
        try {
            checkService.deleteBatchCheck(checkVo.getIds());
            return resultObj.DELETE_SUCCESS;
        } catch (Exception e) {
       e.printStackTrace();
          return resultObj.DELETE_ERROR;
        }
    }
}

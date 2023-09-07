package com.qfedu.bus.controller;

import com.qfedu.bus.Vo.CarVo;
import com.qfedu.bus.Vo.RentVo;
import com.qfedu.bus.domain.Customer;
import com.qfedu.bus.domain.Rent;
import com.qfedu.bus.service.CarService;
import com.qfedu.bus.service.RentService;
import com.qfedu.sys.constant.sysConstant;
import com.qfedu.sys.domain.User;
import com.qfedu.sys.util.DataGridView;
import com.qfedu.sys.util.RandomUtils;
import com.qfedu.sys.util.WebUtils;
import com.qfedu.sys.util.resultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@Controller
@RequestMapping("rent")
public class RentController {
      @Autowired
      private RentService rentService;
      @Autowired
      private CarService carService;
      //检查customer受否存在
    @PostMapping("checkCustomerExit")
    @ResponseBody
    public resultObj checkCustomerExist(RentVo rentVo){
        String idStr=rentVo.getIdentity();
        Customer customer =rentService.customerExist(idStr);
       if(customer!=null){
           return resultObj.STATUS_TRUE;
       }else{
           return resultObj.STATUS_FALSE;
       }
    }
    //初始化菜单
    @RequestMapping("initRentFrom")
    @ResponseBody
    public RentVo initRentForm(RentVo rentVo){
        rentVo.setRentid(RandomUtils.createFileNameUseTime(sysConstant.CAR_ORDER_CZ));
        rentVo.setBegindate(new Date());
        User user=(User) WebUtils.getHttpSession().getAttribute("user");
        rentVo.setOpername(user.getRealname());
        return rentVo;
    }
    //出租汽车
    @PostMapping("saveRent")
    @ResponseBody
    public resultObj saveRent(RentVo rentVo){
        try{
            rentService.saveRent(rentVo);
            return resultObj.ADD_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return resultObj.ADD_ERROR;
        }
    }
    //查询出租单信息
    @RequestMapping("loadAllRent")
    @ResponseBody
    public DataGridView loadAllRent(RentVo rentVo) {
        DataGridView dataGridView=this.rentService.loadAllRent(rentVo);
        return dataGridView;
    }
    //编辑出租单信息
    @PostMapping("updateRent")
    @ResponseBody
    public resultObj updateRent(RentVo rentVo){
        try {
            this.rentService.updateRent(rentVo);
            return resultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
         e.printStackTrace();
         return resultObj.UPDATE_ERROR;
        }
    }
    //删除出租单
    @RequestMapping("deleteRent")
    @ResponseBody
    public resultObj deleteRent(RentVo rentVo){
        try {
            this.rentService.deleteRent(rentVo);
            return resultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return resultObj.DELETE_ERROR;
        }
    }
    //

}

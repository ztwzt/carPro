package com.qfedu.bus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bus")
public class BusController {

    //跳转至客户管理
    @RequestMapping("toCustomerManager")
    public String toCustomerManager(){
        return "business/customer/customerManager";
    }
    //跳转至车辆管理
    @RequestMapping("toCarManager")
    public String toCarManager(){
        return "business/car/carManager";
    }
   //跳转至汽出租
    @RequestMapping("toRentCarManager")
    public String toRentCarManager(){
        return "business/rent/rentCarManager";
    }
    //跳转至出租单管理
    @RequestMapping("toRentManager")
    public String toRentManager(){
      return "business/rent/rentManager";
    }
    //跳转至汽车入库
    @RequestMapping("toCheckCarManager")
    public String toCheckCarManager(){
        return "business/check/checkCarManager";
    }
    /**
     * 跳转到检查单管理的⻚⾯
     */
    @RequestMapping("toCheckManager")
    public String toCheckManager(){
        return "business/check/checkManager";
    }
}

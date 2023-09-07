package com.qfedu.bus.controller;

import com.qfedu.bus.Vo.CustomerVo;
import com.qfedu.bus.service.CustomerService;
import com.qfedu.sys.util.DataGridView;
import com.qfedu.sys.util.resultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


//customer/loadAllCustomer.action?page=1&limit=5
@Controller
@RestController //以json形式响应数据
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    //查询客户信息
    @RequestMapping("loadAllCustomer")
    public DataGridView loadAllCustomer(CustomerVo customerVo){
        DataGridView dataGridView =customerService.queryAllCustomer(customerVo);
        return dataGridView;
    }
    //添加客户信息
    @RequestMapping("addCustomer")
    @ResponseBody
    public resultObj addCustomer(CustomerVo customerVo){
        try {
            customerVo.setCreatetime(new Date());
            this.customerService.addCustomer(customerVo);
            return resultObj.ADD_SUCCESS;

        } catch (Exception e) {
            e.printStackTrace();
            return resultObj.ADD_ERROR;
        }
    }
    //删除客户信息
    @RequestMapping("deleteCustomer")
    @ResponseBody
    public resultObj deleteCustomer(String identity){
        try {
            customerService.deleteCustomer(identity);
            return resultObj.DELETE_SUCCESS;

        } catch (Exception e) {
            e.printStackTrace();
            return resultObj.DELETE_ERROR;
        }
    }
    //修改客户信息
    @RequestMapping("updateCustomer")
    @ResponseBody
    public resultObj updateCustomer(CustomerVo customerVo){
        try {
            customerService.updateCustomer(customerVo);
            return resultObj.UPDATE_SUCCESS;

        } catch (Exception e) {
           e.printStackTrace();
            return resultObj.UPDATE_ERROR;
        }
    }
    //批量删除客户信息
    @RequestMapping("deleteBatchCustomer")
    @ResponseBody
    public resultObj updateBatchCustomer(String[] ids){
        try {
            customerService.updateBatchCustomer(ids);
            return resultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return resultObj.DELETE_ERROR;
        }
    }

}

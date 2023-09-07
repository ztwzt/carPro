package com.qfedu.sys.controller;

import com.qfedu.sys.service.AccountService;
import com.qfedu.sys.util.resultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @RequestMapping("transfer")
    @ResponseBody
    @Transactional
    public resultObj accountTransfer(String inName,String outName,double money){
       int state= accountService.updateTransfer(inName,outName,money);
        if(state>0){
            return resultObj.STATUS_TRUE;
        }else{
            return resultObj.STATUS_FALSE;
        }
    }

}

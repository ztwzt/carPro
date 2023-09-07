package com.qfedu.sys.service.impl;

import com.qfedu.sys.mapper.AccountMapper;
import com.qfedu.sys.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

@Autowired
    private AccountMapper mapper;
    @Override
    public int updateTransfer(String inName, String outName, double money) {
        //转入
        mapper.transferIn(inName,money);
        //转出
        mapper.transferIn(outName,money);
        return 0;
    }
}

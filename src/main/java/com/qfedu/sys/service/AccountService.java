package com.qfedu.sys.service;

public interface AccountService {
    //转账
    public int updateTransfer(String inName,String outName, double money);

}

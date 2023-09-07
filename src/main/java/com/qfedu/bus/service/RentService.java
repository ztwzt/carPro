package com.qfedu.bus.service;

import com.qfedu.bus.Vo.RentVo;
import com.qfedu.bus.domain.Customer;
import com.qfedu.bus.domain.Rent;
import com.qfedu.sys.util.DataGridView;
import org.springframework.stereotype.Service;

@Service
public interface RentService {
    //根据id查询用户
    Customer customerExist(String idStr);

    void saveRent(RentVo rentVo);
    //根据id查询出租单
    Rent queryRenyById(String rentid);
    //查询出租单信息
    DataGridView loadAllRent(RentVo rentVo);

    //编辑出租单信息
    void updateRent(RentVo rentVo);

    //删除出租单
    void deleteRent(RentVo rentVo);
}

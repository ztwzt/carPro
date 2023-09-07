package com.qfedu.bus.mapper;

import com.qfedu.bus.Vo.RentVo;
import com.qfedu.bus.domain.Customer;
import com.qfedu.bus.domain.Rent;

import java.util.List;

public interface RentMapper {
    Customer customerExist(String identity);

    // 出租汽车
    void saveRent(RentVo rentVo);

    //根据id修改信息
    void updateRentById(Rent rent);
    //查询出租单信息
    List<Rent> loadAllRent(RentVo rentVo);
    //编辑出租单信息
    void updateRent(RentVo rentVo);

    //删除出租单
    void deleteRent(RentVo rentVo);

    Rent queryRenyById(String rentid);
}

package com.qfedu.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.bus.Vo.CarVo;
import com.qfedu.bus.Vo.RentVo;
import com.qfedu.bus.domain.Car;
import com.qfedu.bus.domain.Customer;
import com.qfedu.bus.domain.Rent;
import com.qfedu.bus.mapper.CarMapper;
import com.qfedu.bus.mapper.RentMapper;
import com.qfedu.bus.service.RentService;
import com.qfedu.sys.constant.sysConstant;
import com.qfedu.sys.util.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class RentServiceImpl implements RentService {
    @Autowired
    private RentMapper rentMapper;
    @Autowired
    private CarMapper carMapper;
    //删除出租单
    @Override
    public void deleteRent(RentVo rentVo) {
        this.rentMapper.deleteRent(rentVo);
    }

    //编辑出租单信息
    @Override
    public void updateRent(RentVo rentVo) {
        this.rentMapper.updateRent(rentVo);
    }

    //查询出租单信息
    @Override
    public DataGridView loadAllRent(RentVo rentVo) {
        Page<Object> page= PageHelper.startPage(rentVo.getPage(),rentVo.getLimit());
        List<Rent> data=this.rentMapper.loadAllRent(rentVo);
       return new DataGridView(page.getTotal(),data);
    }

    @Override
    public Rent queryRenyById(String rentid) {
        return this.rentMapper.queryRenyById(rentid);
    }

    //出租汽车
    @Override
    public void saveRent(RentVo rentVo) {
        CarVo carVo=new CarVo();
        carVo.setIsrenting(sysConstant.RENT_CAR_TRUE);
        carVo.setCarnumber(rentVo.getCarnumber());
        rentVo.setRentflag(sysConstant.RENT_CAR_TRUE);
        carMapper.updateCar(carVo);
        rentMapper.saveRent(rentVo);
    }
    //确认身份
    @Override
    public Customer customerExist(String idStr) {
        return rentMapper.customerExist(idStr);
    }
}

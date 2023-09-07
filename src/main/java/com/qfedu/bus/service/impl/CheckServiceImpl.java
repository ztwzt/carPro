package com.qfedu.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.bus.Vo.CarVo;
import com.qfedu.bus.Vo.CheckVo;
import com.qfedu.bus.Vo.RentVo;
import com.qfedu.bus.domain.Car;
import com.qfedu.bus.domain.Check;
import com.qfedu.bus.domain.Customer;
import com.qfedu.bus.domain.Rent;
import com.qfedu.bus.mapper.CarMapper;
import com.qfedu.bus.mapper.CheckMapper;
import com.qfedu.bus.mapper.CustomerMapper;
import com.qfedu.bus.mapper.RentMapper;
import com.qfedu.bus.service.CheckService;
import com.qfedu.sys.constant.sysConstant;
import com.qfedu.sys.domain.User;
import com.qfedu.sys.util.DataGridView;
import com.qfedu.sys.util.RandomUtils;
import com.qfedu.sys.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CheckServiceImpl implements CheckService {
    @Autowired
    private CarMapper carMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private RentMapper rentMapper;
    @Autowired
    private CheckMapper checkMapper;

    //批量删除
    @Override
    public void deleteBatchCheck(String[] ids) {
        checkMapper.deleteBatchCheck(ids);
    }

    //删除检查表
    @Override
    public void deleteCheck(String checkid) {
        checkMapper.deleteCheck(checkid);
    }

    //修改检查表
    @Override
    public void updateCheck(CheckVo checkVo) {
        checkMapper.updateCheck(checkVo);
    }

    //表格初始化
    @Override
    public DataGridView loadAllCheck(CheckVo checkVo) {
        List<Object> list=checkMapper.loadAllCheck(checkVo);
        Page<Check> page=PageHelper.startPage(checkVo.getPage(),checkVo.getLimit());
        DataGridView dataGridView=new DataGridView(list);
        return dataGridView;
    }

    //保存表单
    @Override
    public void saveCheck(CheckVo checkVo) {
        checkMapper.saveCheck(checkVo);
        Rent rent=rentMapper.queryRenyById(checkVo.getRentid());
        Car car=carMapper.queryCarByCarNumber(rent.getCarnumber());
        rent.setRentflag(sysConstant.RENT_BACK_TRUE);
        car.setIsrenting(sysConstant.RENT_CAR_FALSE);
        carMapper.updateCarByCarnumber(car);
        rentMapper.updateRentById(rent);
    }

    @Override
    public Map<String,Object> initCheckFormData(String rentid) {
        Rent rent=rentMapper.queryRenyById(rentid);
        Customer customer =customerMapper.queryCustomerById(rent.getIdentity());
        Car car=carMapper.queryCarByCarNumber(rent.getCarnumber());
        Check check=new Check();
        check.setCheckdate(new Date());
        User user= (User)WebUtils.getHttpSession().getAttribute("user");
        check.setOpername(user.getRealname());
        check.setCheckid(RandomUtils.createFileNameUseTime(sysConstant.CAR_ORDER_JC));
        check.setRentid(rentid);
        Map<String,Object> map=new HashMap<>();
        map.put("rent",rent);
        map.put("customer",customer);
        map.put("car",car);
        map.put("check",check);
        return map;
    }
}

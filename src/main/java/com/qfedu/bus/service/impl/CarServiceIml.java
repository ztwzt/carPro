package com.qfedu.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.bus.Vo.CarVo;
import com.qfedu.bus.domain.Car;
import com.qfedu.bus.domain.Customer;
import com.qfedu.bus.mapper.CarMapper;
import com.qfedu.bus.service.CarService;
import com.qfedu.sys.constant.sysConstant;
import com.qfedu.sys.util.AppFileUtils;
import com.qfedu.sys.util.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CarServiceIml implements CarService {


    @Autowired
    private CarMapper carMapper;

    //批量删除
    @Override
    public void deleteBatchCar(String[] ids) {
        for (String id:ids) {
            Car pathOfCar=carMapper.queryCarByCarNumber(id);
            AppFileUtils.removeFileByPath(pathOfCar.getCarimg());
        }
        carMapper.deleteBatchCar(ids);
    }

    //根据carnumber查询car
    @Override
    public Car queryCarByCarNumber(String carnumber) {
       return carMapper.queryCarByCarNumber(carnumber);
    }

    //修改车辆信息
    @Override
    public void updateCar(CarVo carVo) {
        try {
            carMapper.updateCar(carVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //删除车辆
    @Override
    public void deleteCar(String carNumber) {
      String path= carMapper.getCarimgByNumber(carNumber);
        try {
            carMapper.deleteCar(carNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(!path.equals(sysConstant.DEFAULT_CAR_IMG))
        {
            AppFileUtils.deleteFileUsePath(path);
        }
    }

    //添加啊车辆
    @Override
    public void addCar(CarVo carVo) {
        carMapper.addCar(carVo);
    }

    //查询所有车辆
    @Override
    public DataGridView queryAllCar(CarVo carVo) {
        Page<Object> page= PageHelper.startPage(carVo.getPage(),carVo.getLimit());
        List<Customer> data=carMapper.queryAllCar(carVo);
        return new DataGridView(page.getTotal(),data);
    }
}

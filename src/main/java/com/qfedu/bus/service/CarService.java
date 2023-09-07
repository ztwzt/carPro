package com.qfedu.bus.service;

import com.qfedu.bus.Vo.CarVo;
import com.qfedu.bus.domain.Car;
import com.qfedu.sys.util.DataGridView;

public interface CarService {
    //查询所有车辆信息
    DataGridView queryAllCar(CarVo carVo);

    void addCar(CarVo carVo);

    void deleteCar(String carNumber);

    //修改车辆信息
    void updateCar(CarVo carVo);

    //根据carnumber查询car
    Car queryCarByCarNumber(String carnumber);

    //批量删除
    void deleteBatchCar(String[] ids);
}

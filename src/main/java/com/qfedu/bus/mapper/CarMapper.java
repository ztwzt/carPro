package com.qfedu.bus.mapper;

import com.qfedu.bus.Vo.CarVo;
import com.qfedu.bus.Vo.RentVo;
import com.qfedu.bus.domain.Car;
import com.qfedu.bus.domain.Customer;
import com.qfedu.bus.domain.Rent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarMapper {
    List<Customer> queryAllCar(CarVo carVo);

    void addCar(CarVo carVo);

    void deleteCar(@Param("carnumber") String carNumber);
    //根据id查询路径
    String getCarimgByNumber(@Param("carnumber") String carNumber);

    //修改车辆信息
    void updateCar(CarVo carVo);
    //根据carnumber修改车辆信息
    void updateCarByCarnumber(Car car);
    Car queryCarByCarNumber(String carnumber);

    //批量删除
    void deleteBatchCar(@Param("ids") String[] ids);
}

package com.qfedu.bus.controller;

import com.qfedu.bus.Vo.CarVo;
import com.qfedu.bus.Vo.CustomerVo;
import com.qfedu.bus.Vo.RentVo;
import com.qfedu.bus.domain.Car;
import com.qfedu.bus.domain.Rent;
import com.qfedu.bus.service.CarService;
import com.qfedu.sys.constant.sysConstant;
import com.qfedu.sys.util.AppFileUtils;
import com.qfedu.sys.util.DataGridView;
import com.qfedu.sys.util.resultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

//车辆管理 car/loadAllCar.action
@Controller
@RequestMapping("car")
public class CarController {
    @Autowired
    private CarService carService;

    //查询车辆信息
    @RequestMapping("loadAllCar")
    @ResponseBody
    public DataGridView loadAllCar(CarVo carVo) {
        DataGridView dataGridView = carService.queryAllCar(carVo);
        return dataGridView;
    }

    //添加车辆
    @RequestMapping("addCar")
    @ResponseBody
    public resultObj addCar(CarVo carVo) {
        try {
            carVo.setCreatetime(new Date());
            //如果不是默认图⽚就去掉图⽚的_temp的后缀
            if (!carVo.getCarimg().equals(sysConstant.DEFAULT_CAR_IMG)) {
                String filePath = AppFileUtils.updateFileName(carVo.getCarimg(), sysConstant.FILE_UPLOAD_TEMP);
                carVo.setCarimg(filePath);
            }
            this.carService.addCar(carVo);
            return resultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return resultObj.ADD_ERROR;
        }
    }
    //删除车辆
    @RequestMapping("deleteCar")
    @ResponseBody
    public resultObj deleteCar(String carnumber){
        try {
            this.carService.deleteCar(carnumber);
            return resultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return resultObj.DELETE_ERROR;
        }
    }
    //更新车辆信息
    @PostMapping("updateCar")
    @ResponseBody
    public resultObj updateCar(CarVo carVo){
        try{
            String carimg = carVo.getCarimg();
            if (carimg.endsWith(sysConstant.FILE_UPLOAD_TEMP)) {
                String filePath
                        =AppFileUtils.updateFileName(carVo.getCarimg(),
                        sysConstant.FILE_UPLOAD_TEMP);
                carVo.setCarimg(filePath);
                //把原来的删除
                Car car = this.carService.queryCarByCarNumber(carVo.getCarnumber());
                AppFileUtils.removeFileByPath(car.getCarimg());
            }
            this.carService.updateCar(carVo);
            return resultObj.UPDATE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return resultObj.UPDATE_ERROR;
        }
    }
    //批量删除
    @PostMapping("deleteBatchCar")
    @ResponseBody
    public resultObj deleteBatchCar(CarVo carVo){
        String[] ids=carVo.getIds();
        try {
            carService.deleteBatchCar(ids);
            return resultObj.DELETE_SUCCESS;
        } catch (Exception e) {
           e.printStackTrace();
           return resultObj.DELETE_ERROR;
        }
    }
}

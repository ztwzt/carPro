package com.qfedu.stat.controller;

import com.qfedu.bus.domain.Customer;
import com.qfedu.bus.domain.Rent;
import com.qfedu.bus.service.CustomerService;
import com.qfedu.bus.service.RentService;
import com.qfedu.stat.domain.BaseEntity;
import com.qfedu.stat.service.StatService;
import com.qfedu.sys.util.ExportRentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("stat")
@Controller
public class StatController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private RentService rentService;
    @Autowired
    private StatService statService;

    //导出出租单
    @RequestMapping("exportRent")
    @ResponseBody
    public ResponseEntity<Object> exportRent(String rentid) {
        //根据出租单id查询出租单
        Rent rent = rentService.queryRenyById(rentid);
        //根据客户身份证号码查询客户信息
        Customer customer = customerService.queryCustomerById(rent.getIdentity());
        String fileName = customer.getCustname() + "-的出租单.xls";
        String sheetName = customer.getCustname() + "的出租单";
        //通过工具类进行导出
        ByteArrayOutputStream byteArrayOutputStream = ExportRentUtils.exportRent(rent, customer, sheetName);

        //处理文件名称乱码
        try {
            fileName = URLEncoder.encode(fileName, "UTF-8");
            //由于要进行下载，设置头信息
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            //下载文件名称
            httpHeaders.setContentDispositionFormData("attachment", fileName);
            //将数据组装返回
            return new ResponseEntity<Object>(byteArrayOutputStream.toByteArray(), httpHeaders, HttpStatus.CREATED);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
    //跳转至客户地区添统计
    @RequestMapping("toCustomerAreaStat")
    public String toCustomerAreaStat(){
        return "stat/customerAreaStat";
    }
    //跳转至公司年度业务统计
    @RequestMapping("toCompanyYearGradeStat")
    public String toCompanyYearGradeStat(){
        return "stat/companyYearGradeStat";
    }

    //跳转业务员年度业务统计
    @RequestMapping("toOpernameYearGradeStat")
    public String toOpernameYearGradeStat(){
        return "stat/opernameYearGradeStat";
    }
    @RequestMapping("loadCustomerAreaStatJson")
    @ResponseBody
    public List<BaseEntity> loadCustomerAreaStatJson(){
        return this.statService.loadCustomerAreaStatJson();
    }
    @RequestMapping("loadCompanyYearGradeStatJson")
    @ResponseBody
    public List<Double> loadCompanyYearGradeStatJson(String year){
        List<Double> entities =
                this.statService.loadCompanyYearGradeStatJson(year);
        for (int i = 0; i < entities.size(); i++) {
            if (null==entities.get(i)){
                entities.set(i,0.0);
            }
        }
        return entities;
    }
    @RequestMapping("loadOpernameYearGradeStatJson")
    @ResponseBody
    public Map<String,Object> loadOpernameYearGradeStatList(String year){
        List<BaseEntity> entities =
                this.statService.loadOpernameYearGradeStatList(year);
        Map<String,Object> map = new HashMap<String, Object>();
        List<String> names = new ArrayList<String>();
        List<Double> values = new ArrayList<Double>();
        for (BaseEntity baseEntity : entities) {
            names.add(baseEntity.getName());
            values.add(baseEntity.getValue());
        }
        map.put("name",names);
        map.put("value",values);
        return map;
    }
}

package com.qfedu.bus.mapper;

import com.qfedu.bus.Vo.CustomerVo;
import com.qfedu.bus.domain.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {
    //查询额客户
    List<Customer> queryAllCustomer(CustomerVo customerVo);
    //添加客户
    void insertSelective(CustomerVo customerVo);

    //删除客户
    void deleteCustomer(String identity);

    void updateCustomer(CustomerVo customerVo);

    void updateBatchCustomer(@Param("ids") String[] ids);

    Customer queryCustomerById(String identity);
}

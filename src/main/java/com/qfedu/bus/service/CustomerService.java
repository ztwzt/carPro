package com.qfedu.bus.service;

import com.qfedu.bus.Vo.CustomerVo;
import com.qfedu.bus.domain.Customer;
import com.qfedu.sys.util.DataGridView;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    //查询客户
    DataGridView queryAllCustomer(CustomerVo customerVo);
    //添加客户
    void addCustomer(CustomerVo customerVo);

    //删除客户
    void deleteCustomer(String identity);
    //修改客户信息
    void updateCustomer(CustomerVo customerVo);
    //批量删除客户
    void updateBatchCustomer(String[] ids);
    Customer queryCustomerById(String identity);
}

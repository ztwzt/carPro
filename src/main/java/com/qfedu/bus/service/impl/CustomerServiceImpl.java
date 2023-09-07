package com.qfedu.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.bus.Vo.CustomerVo;
import com.qfedu.bus.domain.Customer;
import com.qfedu.bus.mapper.CustomerMapper;
import com.qfedu.bus.service.CustomerService;
import com.qfedu.sys.util.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {


    //    分页查询客户信息
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Customer queryCustomerById(String identity) {
        return customerMapper.queryCustomerById(identity);
    }

    //批量删除客户信息
    @Override
    public void updateBatchCustomer(String[] ids) {
        customerMapper.updateBatchCustomer(ids);
    }

    //修改客户
    @Override
    public void updateCustomer(CustomerVo customerVo) {
        customerMapper.updateCustomer(customerVo);
    }

    //删除客户信息
    @Override
    public void deleteCustomer(String identity) {
        customerMapper.deleteCustomer(identity);
    }

    //添加客户信息
    @Override
    public void addCustomer(CustomerVo customerVo) {
        customerMapper.insertSelective(customerVo);
    }

    //查询客户信息
    @Override
    public DataGridView queryAllCustomer(CustomerVo customerVo) {
      Page<Object> page=PageHelper.startPage(customerVo.getPage(),customerVo.getLimit());
      List<Customer> data=customerMapper.queryAllCustomer(customerVo);
        return new DataGridView(page.getTotal(),data);
    }
}

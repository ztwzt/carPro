package com.qfedu.stat.service.impl;

import com.qfedu.stat.mapper.StatMapper;
import com.qfedu.stat.domain.BaseEntity;
import com.qfedu.stat.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatServiceImpl implements StatService {
    @Autowired
    private StatMapper statMapper;

    @Override
    public List<BaseEntity> loadOpernameYearGradeStatList(String year) {
        return this.statMapper.queryOpernameYearGradeStat(year);
    }

    @Override
    public List<Double> loadCompanyYearGradeStatJson(String year) {
        List<Double> list= this.statMapper.loadCompanyYearGradeStatJson(year);
        return list;
    }

    @Override
    public List<BaseEntity> loadCustomerAreaStatJson() {
        List<BaseEntity> list= this.statMapper.loadCustomerAreaStatJson();
        return list;
    }
}

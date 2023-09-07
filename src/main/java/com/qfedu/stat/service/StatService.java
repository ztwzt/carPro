package com.qfedu.stat.service;

import com.qfedu.stat.domain.BaseEntity;

import java.util.List;

public interface StatService {
    List<BaseEntity> loadCustomerAreaStatJson();

    List<Double> loadCompanyYearGradeStatJson(String year);

    List<BaseEntity> loadOpernameYearGradeStatList(String year);
}

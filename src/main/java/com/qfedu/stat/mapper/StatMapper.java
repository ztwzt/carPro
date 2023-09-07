package com.qfedu.stat.mapper;

import com.qfedu.stat.domain.BaseEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StatMapper {
    List<BaseEntity> loadCustomerAreaStatJson();

    List<Double> loadCompanyYearGradeStatJson(String year);

    List<BaseEntity> queryOpernameYearGradeStat(String year);
}

package com.qfedu.bus.Vo;

import com.qfedu.bus.domain.Customer;

public class CustomerVo extends Customer{
    /**
     * 分⻚参数
     */
    private Integer page;
    private Integer limit;
    //接受多个id
    private String [] ids;
    public Integer getPage() {
        return page;
    }
    public void setPage(Integer page) {
        this.page = page;
    }
    public Integer getLimit() {
        return limit;
    }
    public void setLimit(Integer limit) {
        this.limit = limit;
    }
    public String[] getIds() {
        return ids;
    }
    public void setIds(String[] ids) {
        this.ids = ids;
    }
}

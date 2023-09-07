package com.qfedu.sys.domain;

public class UserVo extends User{

    /**
     * 分⻚参数
     */
    private Integer page;
    private Integer limit;
    private String code;
    /**
     * 接受多个⻆⾊的id
     */
    private Integer [] ids;
    public Integer[] getIds() {
        return ids;
    }
    public void setIds(Integer[] ids) {
        this.ids = ids;
    }
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
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
}

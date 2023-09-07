package com.qfedu.sys.util;

import com.qfedu.sys.constant.sysConstant;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

//统一返回对象
@Data
public class resultObj {
    private Integer code;
    private String msg;

    public static final resultObj ADD_SUCCESS = new
            resultObj(sysConstant.CODE_SUCCESS, sysConstant.ADD_SUCCESS);

    private resultObj(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private resultObj(Integer code) {
        this.code = code;
    }
    /**
     * 添加失败
     */
    public static final resultObj ADD_ERROR = new
            resultObj(sysConstant.CODE_ERROR, sysConstant.ADD_ERROR);
    /**
     * 更新成功
     */

    public static final resultObj UPDATE_SUCCESS = new
            resultObj(sysConstant.CODE_SUCCESS, sysConstant.UPDATE_SUCCESS);
    /**
     * * 更新失败
     */

    public static final resultObj UPDATE_ERROR = new
            resultObj(sysConstant.CODE_ERROR, sysConstant.UPDATE_ERROR);
    /**
     * * 删除成功
     */

    public static final resultObj DELETE_SUCCESS = new
            resultObj(sysConstant.CODE_SUCCESS, sysConstant.DELETE_SUCCESS);
    /**
     * * 删除失败
     */

    public static final resultObj DELETE_ERROR = new
            resultObj(sysConstant.CODE_ERROR, sysConstant.DELETE_ERROR);
    /**
     * * 重置成功
     */

    public static final resultObj RESET_SUCCESS = new
            resultObj(sysConstant.CODE_SUCCESS, sysConstant.RESET_SUCCESS);
    /**
     * * 重置失败
     */

    public static final resultObj RESET_ERROR = new
            resultObj(sysConstant.CODE_ERROR, sysConstant.RESET_ERROR);
    /**
     * * 分配成功
     */

    public static final resultObj DISPATCH_SUCCESS = new
            resultObj(sysConstant.CODE_SUCCESS, sysConstant.DISPATCH_SUCCESS);
    /**
     * * 分配失败
     */
    public static final resultObj DISPATCH_ERROR = new
            resultObj(sysConstant.CODE_ERROR, sysConstant.DISPATCH_ERROR);
    /**
     * 状态码0 成功
     */
    public static final resultObj STATUS_TRUE = new
            resultObj(sysConstant.CODE_SUCCESS);
    /**
     * 状态码-1 失败
     */
    public static final resultObj STATUS_FALSE = new
            resultObj(sysConstant.CODE_ERROR);
}


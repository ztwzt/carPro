package com.qfedu.sys.constant;

/*
*
* 常量接口*/
public interface sysConstant {

    //用户登录常量
    public String USER_LOGIN_ERROR_MSG="用户密码不正确";
    public String USER_LOGIN_CODE_ERROR_MSG="验证码不正确";


    //可用状态常量
    public Integer AVAILABLE_TRUE=1;
    public Integer AVAILABLE_FALSE=0;


    //用户类型
    public Integer USER_TYPE_SUPER=1;//普通用户
    public Integer USER_TYPE_NORMAL=2;//超级用户


    //是否展开
    public Integer SPREAD_TRUE=1;
    public Integer SPREAD_FALSE=0;


    //操作状态
    public String ADD_SUCCESS="添加成功";
    public String ADD_ERROR="添加失败";
    public String UPDATE_SUCCESS="修改成功";
    public String UPDATE_ERROR="修改失败";
    public String DELETE_SUCCESS="删除成功";
    public String DELETE_ERROR="删除失败";
    public String RESET_SUCCESS="重置成功";
    public String RESET_ERROR="重置失败";
    public String DISPATCH_SUCCESS="分配成功";
    public String DISPATCH_ERROR="分配失败";


    //操作
    public Integer CODE_SUCCESS=0;
    public Integer CODE_ERROR=-1;

    //公用常量
    public Integer CODE_ZERO=0;
    public Integer CODE_ONE=1;
    public Integer CODE_TWO=2;
    public Integer CODE_THREE=3;


    //用户默认密码
    public String USER_DEFAULT_PWD="123456";


    //临时文件标记
    public String FILE_UPLOAD_TEMP="_temp";


    //默认图片地址
    public String DEFAULT_CAR_IMG="image/defaultimage.jpg";

    //单号前缀
    public String CAR_ORDER_CZ="CZ";//出租车订单号前缀
    public String CAR_ORDER_JC="JC";//检查单号前缀


    //归还状态
    public Integer RENT_BACK_FALSE=0;
    public Integer RENT_BACK_TRUE=1;


    //出租状态
    public Integer RENT_CAR_FALSE=0;
    public Integer RENT_CAR_TRUE=1;


}

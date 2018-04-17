package com.drkj.logisticswarehouse.Constant;

/**
 * Created by ganlong on 2017/10/23.
 */

public class Constant {
//    public static final String BASE_URL = "http://47.100.195.32:80/entrance/app/mode/";
    public static final String BASE_URL = "http://106.15.57.208:18080/entrance/app/mode/";
//    public static final String BASE_URL = "http://192.168.31.59:8081/app/mode/";

    /**
     * 分拣单接口
     */
    public static final String HANDLE_ASSIGN_ORDER = "driverHandleAssignOrder";


    /**
     * 获取配送单接口
     */
    public static final String GET_DELIVER_ODER_BY_CAR = "getDeliverOderByDriver";

    /**
     * 开始配送接口
     */
    public static final String BEGIN_DELIVER = "beginDeliver";

    /**
     * 结束配送
     */
    public static final String END_DELIVER = "endDeliver";

    /**
     * 登录接口
     */
    public static final String LOGIN = "loginValid";
    /**
     * 获取订单接口
     */
    public static final String GET_ORDER_DETAL = "getOrderDetailByOrderNumber";

    /**
     * 上报订单接口
     */
    public static final String  SIGN_FOR_ORDER ="signForOrder";

    /**
     * 发送验证码接口
     */
    public static final String SEND_VAILD_CODE = "sendVaildCode";

    /**
     * 获取回收物信息接口
     */
    public static final String GET_RECLAIM = "getReclaim";

}

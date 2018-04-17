package com.drkj.logisticswarehouse;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;
import com.drkj.logisticswarehouse.bean.ResultBean;
import com.drkj.logisticswarehouse.bean.ResultDeliverBean;
import com.drkj.logisticswarehouse.bean.ResultLoginBean;
import com.drkj.logisticswarehouse.bean.ResultOrderDetailBean;
import com.drkj.logisticswarehouse.db.DBController;
import com.vondear.rxtools.RxTool;

/**
 * Created by ganlong on 2017/10/16.
 */

public class BaseApplication extends Application {

    private static BaseApplication instance;

    private ResultDeliverBean deliverBean;

    private ResultLoginBean loginBean;

    private ResultOrderDetailBean orderDetailBean;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        SDKInitializer.initialize(getApplicationContext());
        DBController.getInstance().initDB();
        RxTool.init(this);
    }
    public static BaseApplication getInstance(){
        return instance;
    }

    public ResultDeliverBean getDeliverBean() {
        return deliverBean;
    }

    public void setDeliverBean(ResultDeliverBean deliverBean) {
        this.deliverBean = deliverBean;
    }

    public ResultLoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(ResultLoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public ResultOrderDetailBean getOrderDetailBean() {
        return orderDetailBean;
    }

    public void setOrderDetailBean(ResultOrderDetailBean orderDetailBean) {
        this.orderDetailBean = orderDetailBean;
    }
}

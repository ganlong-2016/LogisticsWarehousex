package com.drkj.logisticswarehouse.net;


import com.drkj.logisticswarehouse.Constant.Constant;
import com.drkj.logisticswarehouse.bean.ReclaimResultBean;
import com.drkj.logisticswarehouse.bean.Result2Bean;
import com.drkj.logisticswarehouse.bean.ResultBean;
import com.drkj.logisticswarehouse.bean.ResultDeliverBean;
import com.drkj.logisticswarehouse.bean.ResultLoginBean;
import com.drkj.logisticswarehouse.bean.ResultOrderDetailBean;
import com.drkj.logisticswarehouse.bean.ResultVaildBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by ganlong on 2017/10/23.
 */

public interface Api {

    @POST(Constant.HANDLE_ASSIGN_ORDER)
    Observable<ResultBean> handleAssignOrder(@Query("assignOrderNumber")String number, @Query("phone")String phone );

    @POST(Constant.GET_DELIVER_ODER_BY_CAR)
    Observable<ResultDeliverBean> getDeliverOderByDriver(@Query("driverId") int driverId);

    @POST(Constant.BEGIN_DELIVER)
    Observable<Result2Bean> beginDeliver(@Query("deliverOrderNumber")String deliverOrderNumber);

    @POST(Constant.END_DELIVER)
    Observable<Result2Bean> endDeliver(@Query("deliverOrderNumber")String deliverOrderNumber);

    @POST(Constant.LOGIN)
    Observable<ResultLoginBean> login(@Query("phone")String phoneNumber, @Query("code")String password);

    @GET(Constant.GET_ORDER_DETAL)
    Observable<ResultOrderDetailBean> getOrderDetailByOrderNumber(@Query("orderNumber")String orderNumber);

    @FormUrlEncoded
    @POST(Constant.SIGN_FOR_ORDER)
    Observable<ResultBean> signForOrder(@Field("orderAppVo") String bean);

    @POST(Constant.SEND_VAILD_CODE)
    Observable<ResultVaildBean> sendVaildCode(@Query("phone")String phone);


    @GET(Constant.GET_RECLAIM)
    Observable<ReclaimResultBean> getReclaim(@Query("stockistId") int stockistId, @Query("dealerId")int dealerId);

}

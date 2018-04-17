package com.drkj.logisticswarehouse.net;

import com.drkj.logisticswarehouse.Constant.Constant;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ganlong on 2017/10/24.
 */

public class NetClient {
    private static NetClient instance;

    private Retrofit retrofit;

    private NetClient(){
        Gson gson = new GsonBuilder().create();

        retrofit = new Retrofit.Builder()
                        .baseUrl(Constant.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build();
    }

    public static NetClient getInstance(){
        if (instance==null)
            instance = new NetClient();
        return instance;
    }

    public Api getApi(){
        return retrofit.create(Api.class);
    }


}


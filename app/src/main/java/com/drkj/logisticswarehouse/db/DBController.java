package com.drkj.logisticswarehouse.db;

import android.content.Context;

import com.drkj.logisticswarehouse.BaseApplication;

/**
 * Created by ganlong on 2017/11/2.
 */

public class DBController {
    private Context context;

    private static DBController instance;

    private MySQLiteOpenHelper helper;
    private DBController(){
        context = BaseApplication.getInstance();
    }

    public static DBController getInstance(){
        if (instance==null)
            instance = new DBController();
        return instance;
    }

    public void initDB(){
        helper = new MySQLiteOpenHelper(context,SQLStatement.DB_NAME,null,SQLStatement.DB_VERSION);

    }
}

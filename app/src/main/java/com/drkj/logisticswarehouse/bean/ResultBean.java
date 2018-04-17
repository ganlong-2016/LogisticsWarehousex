package com.drkj.logisticswarehouse.bean;

/**
 * Created by ganlong on 2017/11/9.
 */

public class ResultBean {

    /**
     * code : 200
     * data : -4
     * msg : 鍒嗘嫞鍛樺皾璇曟壂鐮佺粨鏉熷垎鎷�
     * success : false
     */

    private int code;
    private int data;
    private String msg;
    private boolean success;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}

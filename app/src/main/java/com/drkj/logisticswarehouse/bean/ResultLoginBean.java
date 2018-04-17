package com.drkj.logisticswarehouse.bean;

/**
 * Created by ganlong on 2017/11/10.
 */

public class ResultLoginBean {


    /**
     * code : 200
     * data : {"driver":{"createTime":"2017-11-29 16:25:56","driverName":"老司机","driverPhone":"18782966338","driverStatus":0,"driverStatusDisplay":"闲置中","id":3,"remark":""},"car":{"carNumber":"川A4545454322","carStatus":0,"carStatusDisplay":"闲置中","creatTime":"2017-11-10 15:20:03","driverName":"aaaaa","driverPhone":"13456785678","id":19,"remark":""},"userType":6}
     * msg : 手机验证通过!
     * success : true
     */

    private int code;
    private DataBean data;
    private String msg;
    private boolean success;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
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

    public static class DataBean {
        /**
         * driver : {"createTime":"2017-11-29 16:25:56","driverName":"老司机","driverPhone":"18782966338","driverStatus":0,"driverStatusDisplay":"闲置中","id":3,"remark":""}
         * car : {"carNumber":"川A4545454322","carStatus":0,"carStatusDisplay":"闲置中","creatTime":"2017-11-10 15:20:03","driverName":"aaaaa","driverPhone":"13456785678","id":19,"remark":""}
         * userType : 6
         */

        private DriverBean driver;
        private CarBean car;
        private int userType;

        public DriverBean getDriver() {
            return driver;
        }

        public void setDriver(DriverBean driver) {
            this.driver = driver;
        }

        public CarBean getCar() {
            return car;
        }

        public void setCar(CarBean car) {
            this.car = car;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public static class DriverBean {
            /**
             * createTime : 2017-11-29 16:25:56
             * driverName : 老司机
             * driverPhone : 18782966338
             * driverStatus : 0
             * driverStatusDisplay : 闲置中
             * id : 3
             * remark :
             */

            private String createTime;
            private String driverName;
            private String driverPhone;
            private int driverStatus;
            private String driverStatusDisplay;
            private int id;
            private String remark;

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getDriverName() {
                return driverName;
            }

            public void setDriverName(String driverName) {
                this.driverName = driverName;
            }

            public String getDriverPhone() {
                return driverPhone;
            }

            public void setDriverPhone(String driverPhone) {
                this.driverPhone = driverPhone;
            }

            public int getDriverStatus() {
                return driverStatus;
            }

            public void setDriverStatus(int driverStatus) {
                this.driverStatus = driverStatus;
            }

            public String getDriverStatusDisplay() {
                return driverStatusDisplay;
            }

            public void setDriverStatusDisplay(String driverStatusDisplay) {
                this.driverStatusDisplay = driverStatusDisplay;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }
        }

        public static class CarBean {
            /**
             * carNumber : 川A4545454322
             * carStatus : 0
             * carStatusDisplay : 闲置中
             * creatTime : 2017-11-10 15:20:03
             * driverName : aaaaa
             * driverPhone : 13456785678
             * id : 19
             * remark :
             */

            private String carNumber;
            private int carStatus;
            private String carStatusDisplay;
            private String creatTime;
            private String driverName;
            private String driverPhone;
            private int id;
            private String remark;

            public String getCarNumber() {
                return carNumber;
            }

            public void setCarNumber(String carNumber) {
                this.carNumber = carNumber;
            }

            public int getCarStatus() {
                return carStatus;
            }

            public void setCarStatus(int carStatus) {
                this.carStatus = carStatus;
            }

            public String getCarStatusDisplay() {
                return carStatusDisplay;
            }

            public void setCarStatusDisplay(String carStatusDisplay) {
                this.carStatusDisplay = carStatusDisplay;
            }

            public String getCreatTime() {
                return creatTime;
            }

            public void setCreatTime(String creatTime) {
                this.creatTime = creatTime;
            }

            public String getDriverName() {
                return driverName;
            }

            public void setDriverName(String driverName) {
                this.driverName = driverName;
            }

            public String getDriverPhone() {
                return driverPhone;
            }

            public void setDriverPhone(String driverPhone) {
                this.driverPhone = driverPhone;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }
        }
    }
}

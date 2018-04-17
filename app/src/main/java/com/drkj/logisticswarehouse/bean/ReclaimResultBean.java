package com.drkj.logisticswarehouse.bean;

import java.util.List;

/**
 * Created by ganlong on 2018/1/4.
 */

public class ReclaimResultBean {


    /**
     * data : [{"id":1,"name":"空瓶类","createrDate":"2017-12-21 16:20:44","reclaimPriceList":[{"id":3,"name":"500ml雪花空瓶","price":0.5,"reclaimPrice":2,"reclaimCatalogueId":1,"stockistId":8,"dealerId":7,"isCheckbox":null,"unit":"个","unitNumber":null,"subUnit":"瓶","subUnitNumber":null,"spec":10}]},{"id":3,"name":"瓶盖类","createrDate":"2017-12-21 16:27:50","reclaimPriceList":[{"id":59,"name":"雪花空盖","price":1.5,"reclaimPrice":1,"reclaimCatalogueId":3,"stockistId":8,"dealerId":7,"isCheckbox":null,"unit":"啊","unitNumber":null,"subUnit":"的","subUnitNumber":null,"spec":1},{"id":61,"name":"青岛空盖","price":0.2,"reclaimPrice":1,"reclaimCatalogueId":5,"stockistId":8,"dealerId":7,"isCheckbox":null,"unit":"阿萨德","unitNumber":null,"subUnit":"阿萨德","subUnitNumber":null,"spec":222},{"id":63,"name":"纯生空盖","price":0.4,"reclaimPrice":1,"reclaimCatalogueId":7,"stockistId":8,"dealerId":7,"isCheckbox":null,"unit":"斯蒂芬","unitNumber":null,"subUnit":"发","subUnitNumber":null,"spec":12}]},{"id":5,"name":"纸箱类","createrDate":"2017-12-28 15:29:31","reclaimPriceList":[{"id":65,"name":"普通纸箱","price":2,"reclaimPrice":1,"reclaimCatalogueId":9,"stockistId":8,"dealerId":7,"isCheckbox":null,"unit":"发","unitNumber":null,"subUnit":"额","subUnitNumber":null,"spec":11}]},{"id":7,"name":"塑箱类","createrDate":"2017-12-31 12:54:29","reclaimPriceList":[{"id":67,"name":"普通塑箱","price":1.5,"reclaimPrice":1,"reclaimCatalogueId":11,"stockistId":8,"dealerId":7,"isCheckbox":null,"unit":"阿萨德","unitNumber":null,"subUnit":"v不","subUnitNumber":null,"spec":123}]}]
     * code : 200
     * msg : null
     * success : true
     */

    private int code;
    private Object msg;
    private boolean success;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * name : 空瓶类
         * createrDate : 2017-12-21 16:20:44
         * reclaimPriceList : [{"id":3,"name":"500ml雪花空瓶","price":0.5,"reclaimPrice":2,"reclaimCatalogueId":1,"stockistId":8,"dealerId":7,"isCheckbox":null,"unit":"个","unitNumber":null,"subUnit":"瓶","subUnitNumber":null,"spec":10}]
         */

        private int id;
        private String name;
        private String createrDate;
        private List<ReclaimPriceListBean> reclaimPriceList;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCreaterDate() {
            return createrDate;
        }

        public void setCreaterDate(String createrDate) {
            this.createrDate = createrDate;
        }

        public List<ReclaimPriceListBean> getReclaimPriceList() {
            return reclaimPriceList;
        }

        public void setReclaimPriceList(List<ReclaimPriceListBean> reclaimPriceList) {
            this.reclaimPriceList = reclaimPriceList;
        }

        public static class ReclaimPriceListBean {
            /**
             * id : 3
             * name : 500ml雪花空瓶
             * price : 0.5
             * reclaimPrice : 2
             * reclaimCatalogueId : 1
             * stockistId : 8
             * dealerId : 7
             * isCheckbox : null
             * unit : 个
             * unitNumber : null
             * subUnit : 瓶
             * subUnitNumber : null
             * spec : 10
             */

            private int id;
            private String name;
            private double price;
            private double reclaimPrice;
            private int reclaimCatalogueId;
            private int stockistId;
            private int dealerId;
            private Object isCheckbox;
            private String unit;
            private Object unitNumber;
            private String subUnit;
            private Object subUnitNumber;
            private int spec;
            private String viewSpec;

            public String getViewSpec() {
                return viewSpec;
            }

            public void setViewSpec(String viewSpec) {
                this.viewSpec = viewSpec;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public double getReclaimPrice() {
                return reclaimPrice;
            }

            public void setReclaimPrice(double reclaimPrice) {
                this.reclaimPrice = reclaimPrice;
            }

            public int getReclaimCatalogueId() {
                return reclaimCatalogueId;
            }

            public void setReclaimCatalogueId(int reclaimCatalogueId) {
                this.reclaimCatalogueId = reclaimCatalogueId;
            }

            public int getStockistId() {
                return stockistId;
            }

            public void setStockistId(int stockistId) {
                this.stockistId = stockistId;
            }

            public int getDealerId() {
                return dealerId;
            }

            public void setDealerId(int dealerId) {
                this.dealerId = dealerId;
            }

            public Object getIsCheckbox() {
                return isCheckbox;
            }

            public void setIsCheckbox(Object isCheckbox) {
                this.isCheckbox = isCheckbox;
            }

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }

            public Object getUnitNumber() {
                return unitNumber;
            }

            public void setUnitNumber(Object unitNumber) {
                this.unitNumber = unitNumber;
            }

            public String getSubUnit() {
                return subUnit;
            }

            public void setSubUnit(String subUnit) {
                this.subUnit = subUnit;
            }

            public Object getSubUnitNumber() {
                return subUnitNumber;
            }

            public void setSubUnitNumber(Object subUnitNumber) {
                this.subUnitNumber = subUnitNumber;
            }

            public int getSpec() {
                return spec;
            }

            public void setSpec(int spec) {
                this.spec = spec;
            }
        }
    }
}

package com.drkj.logisticswarehouse.bean;

import java.util.List;

/**
 * Created by ganlong on 2017/11/9.
 */

public class ResultDeliverBean {


    /**
     * code : 200
     * data : {"assignOrderNumber":"FJ2017111314573150247","carId":20,"carVo":{"carNumber":"川A34343","carStatus":1,"carStatusDisplay":"配送中","creatTime":"2017-11-13 14:40:39","driverName":"艾斯德斯","driverPhone":"15376587658","id":20,"remark":""},"createTime":"2017-11-13 14:57:31","deliverOrderNumber":"PS2017111314573146480","deliverState":2,"id":23,"stockistDeliverVoList":[{"orderAppVos":[{"goodsOrderVoList":[{"applyAmount":10,"awardAmount":2,"awardCash":10,"categoryVo":{"attribute":22,"createTime":"2017-10-21 21:12:48","goodsName":"统一鲜橙多大瓶","guidePrice":56,"id":2,"isPublic":1,"storageAreaId":1,"storageId":1,"unit":"箱"},"deliverAmount":12,"goodsActualGetNums":10,"goodsActualPrice":9890,"goodsApplyPrice":9900,"goodsDifferPrice":45,"goodsReturnNums":2,"goodsReturnPrice":90,"goodsVerifyReturnNums":1,"goodsfinalPrice":9800,"id":88,"orderNumber":"B2017111314554987241","price":45,"saleGoodsId":5,"storageNums":55},{"applyAmount":14,"awardAmount":5,"awardCash":20,"categoryVo":{"attribute":22,"createTime":"2017-10-21 21:12:48","goodsName":"统一鲜橙多大瓶","guidePrice":56,"id":2,"isPublic":1,"storageAreaId":1,"storageId":1,"unit":"箱"},"deliverAmount":19,"goodsActualGetNums":16,"goodsActualPrice":10606,"goodsApplyPrice":10626,"goodsDifferPrice":0,"goodsReturnNums":3,"goodsReturnPrice":103.5,"goodsVerifyReturnNums":3,"goodsfinalPrice":10502.5,"id":89,"orderNumber":"B2017111314554987241","price":34.5,"saleGoodsId":7,"storageNums":65}],"orderQRcodePath":"http://localhost:8080/upload/psQrcode/B2017111314554987241_deliver.jpg","orderVo":{"basketDifferPrice":0,"basketPrice":30,"basketRecycleNums":6,"basketSinglePrice":5,"basketVerifyNums":6,"bottleDifferPrice":0,"bottlePrice":12,"bottleRecycleNums":4,"bottleSinglePrice":3,"bottleVerifyNums":4,"coverDifferPrice":0,"coverPrice":10,"coverRecycleNums":5,"coverSinglePrice":2,"coverVerifyNums":5,"createTime":"2017-11-13 14:55:49","dealerId":1,"dealerName":"经销商1","financialRemark":"账有问题","id":69,"isGetMoneyByCar":0,"isRecycle":0,"isRecycleDisPlay":"是","moneyByCarDispay":"是","moneyGetByCar":23,"orderActualGetNums":26,"orderActualPrice":20496,"orderApplyPrice":20526,"orderAwardPrice":30,"orderDeliverAmount":31,"orderDifferPrice":-1646.5,"orderFinalPrice":20250.5,"orderNumber":"B2017111314554987241","orderReturnNums":5,"orderReturnPrice":193.5,"orderVerifyPrice":21897,"passTime":"2017-11-13 14:56:58","priority":1,"priotyTime":"18点之前","recyclePrice":52,"refuseReason":"","state":6,"stockistId":3,"stockistVo":{"address":"金融城地铁站","contactName":"zxcsds","createTime":"2017-11-01 16:48:22","dealerNum":0,"id":3,"latPoint":"30.58869","lngPoint":"104.07059","phone":"13734541222","shopName":"地方大幅度"}},"seq":0}],"seq":0,"stationStatus":0,"stockistVo":{"address":"金融城地铁站","contactName":"zxcsds","createTime":"2017-11-01 16:48:22","dealerNum":0,"id":3,"latPoint":"30.58869","lngPoint":"104.07059","phone":"13734541222","shopName":"地方大幅度"}}]}
     * msg : 操作成功
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
         * assignOrderNumber : FJ2017111314573150247
         * carId : 20
         * carVo : {"carNumber":"川A34343","carStatus":1,"carStatusDisplay":"配送中","creatTime":"2017-11-13 14:40:39","driverName":"艾斯德斯","driverPhone":"15376587658","id":20,"remark":""}
         * createTime : 2017-11-13 14:57:31
         * deliverOrderNumber : PS2017111314573146480
         * deliverState : 2
         * id : 23
         * stockistDeliverVoList : [{"orderAppVos":[{"goodsOrderVoList":[{"applyAmount":10,"awardAmount":2,"awardCash":10,"categoryVo":{"attribute":22,"createTime":"2017-10-21 21:12:48","goodsName":"统一鲜橙多大瓶","guidePrice":56,"id":2,"isPublic":1,"storageAreaId":1,"storageId":1,"unit":"箱"},"deliverAmount":12,"goodsActualGetNums":10,"goodsActualPrice":9890,"goodsApplyPrice":9900,"goodsDifferPrice":45,"goodsReturnNums":2,"goodsReturnPrice":90,"goodsVerifyReturnNums":1,"goodsfinalPrice":9800,"id":88,"orderNumber":"B2017111314554987241","price":45,"saleGoodsId":5,"storageNums":55},{"applyAmount":14,"awardAmount":5,"awardCash":20,"categoryVo":{"attribute":22,"createTime":"2017-10-21 21:12:48","goodsName":"统一鲜橙多大瓶","guidePrice":56,"id":2,"isPublic":1,"storageAreaId":1,"storageId":1,"unit":"箱"},"deliverAmount":19,"goodsActualGetNums":16,"goodsActualPrice":10606,"goodsApplyPrice":10626,"goodsDifferPrice":0,"goodsReturnNums":3,"goodsReturnPrice":103.5,"goodsVerifyReturnNums":3,"goodsfinalPrice":10502.5,"id":89,"orderNumber":"B2017111314554987241","price":34.5,"saleGoodsId":7,"storageNums":65}],"orderQRcodePath":"http://localhost:8080/upload/psQrcode/B2017111314554987241_deliver.jpg","orderVo":{"basketDifferPrice":0,"basketPrice":30,"basketRecycleNums":6,"basketSinglePrice":5,"basketVerifyNums":6,"bottleDifferPrice":0,"bottlePrice":12,"bottleRecycleNums":4,"bottleSinglePrice":3,"bottleVerifyNums":4,"coverDifferPrice":0,"coverPrice":10,"coverRecycleNums":5,"coverSinglePrice":2,"coverVerifyNums":5,"createTime":"2017-11-13 14:55:49","dealerId":1,"dealerName":"经销商1","financialRemark":"账有问题","id":69,"isGetMoneyByCar":0,"isRecycle":0,"isRecycleDisPlay":"是","moneyByCarDispay":"是","moneyGetByCar":23,"orderActualGetNums":26,"orderActualPrice":20496,"orderApplyPrice":20526,"orderAwardPrice":30,"orderDeliverAmount":31,"orderDifferPrice":-1646.5,"orderFinalPrice":20250.5,"orderNumber":"B2017111314554987241","orderReturnNums":5,"orderReturnPrice":193.5,"orderVerifyPrice":21897,"passTime":"2017-11-13 14:56:58","priority":1,"priotyTime":"18点之前","recyclePrice":52,"refuseReason":"","state":6,"stockistId":3,"stockistVo":{"address":"金融城地铁站","contactName":"zxcsds","createTime":"2017-11-01 16:48:22","dealerNum":0,"id":3,"latPoint":"30.58869","lngPoint":"104.07059","phone":"13734541222","shopName":"地方大幅度"}},"seq":0}],"seq":0,"stationStatus":0,"stockistVo":{"address":"金融城地铁站","contactName":"zxcsds","createTime":"2017-11-01 16:48:22","dealerNum":0,"id":3,"latPoint":"30.58869","lngPoint":"104.07059","phone":"13734541222","shopName":"地方大幅度"}}]
         */

        private String assignOrderNumber;
        private int carId;
        private CarVoBean carVo;
        private String createTime;
        private String deliverOrderNumber;
        private int deliverState;
        private int id;
        private List<StockistDeliverVoListBean> stockistDeliverVoList;

        public String getAssignOrderNumber() {
            return assignOrderNumber;
        }

        public void setAssignOrderNumber(String assignOrderNumber) {
            this.assignOrderNumber = assignOrderNumber;
        }

        public int getCarId() {
            return carId;
        }

        public void setCarId(int carId) {
            this.carId = carId;
        }

        public CarVoBean getCarVo() {
            return carVo;
        }

        public void setCarVo(CarVoBean carVo) {
            this.carVo = carVo;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getDeliverOrderNumber() {
            return deliverOrderNumber;
        }

        public void setDeliverOrderNumber(String deliverOrderNumber) {
            this.deliverOrderNumber = deliverOrderNumber;
        }

        public int getDeliverState() {
            return deliverState;
        }

        public void setDeliverState(int deliverState) {
            this.deliverState = deliverState;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<StockistDeliverVoListBean> getStockistDeliverVoList() {
            return stockistDeliverVoList;
        }

        public void setStockistDeliverVoList(List<StockistDeliverVoListBean> stockistDeliverVoList) {
            this.stockistDeliverVoList = stockistDeliverVoList;
        }

        public static class CarVoBean {
            /**
             * carNumber : 川A34343
             * carStatus : 1
             * carStatusDisplay : 配送中
             * creatTime : 2017-11-13 14:40:39
             * driverName : 艾斯德斯
             * driverPhone : 15376587658
             * id : 20
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

        public static class StockistDeliverVoListBean {
            /**
             * orderAppVos : [{"goodsOrderVoList":[{"applyAmount":10,"awardAmount":2,"awardCash":10,"categoryVo":{"attribute":22,"createTime":"2017-10-21 21:12:48","goodsName":"统一鲜橙多大瓶","guidePrice":56,"id":2,"isPublic":1,"storageAreaId":1,"storageId":1,"unit":"箱"},"deliverAmount":12,"goodsActualGetNums":10,"goodsActualPrice":9890,"goodsApplyPrice":9900,"goodsDifferPrice":45,"goodsReturnNums":2,"goodsReturnPrice":90,"goodsVerifyReturnNums":1,"goodsfinalPrice":9800,"id":88,"orderNumber":"B2017111314554987241","price":45,"saleGoodsId":5,"storageNums":55},{"applyAmount":14,"awardAmount":5,"awardCash":20,"categoryVo":{"attribute":22,"createTime":"2017-10-21 21:12:48","goodsName":"统一鲜橙多大瓶","guidePrice":56,"id":2,"isPublic":1,"storageAreaId":1,"storageId":1,"unit":"箱"},"deliverAmount":19,"goodsActualGetNums":16,"goodsActualPrice":10606,"goodsApplyPrice":10626,"goodsDifferPrice":0,"goodsReturnNums":3,"goodsReturnPrice":103.5,"goodsVerifyReturnNums":3,"goodsfinalPrice":10502.5,"id":89,"orderNumber":"B2017111314554987241","price":34.5,"saleGoodsId":7,"storageNums":65}],"orderQRcodePath":"http://localhost:8080/upload/psQrcode/B2017111314554987241_deliver.jpg","orderVo":{"basketDifferPrice":0,"basketPrice":30,"basketRecycleNums":6,"basketSinglePrice":5,"basketVerifyNums":6,"bottleDifferPrice":0,"bottlePrice":12,"bottleRecycleNums":4,"bottleSinglePrice":3,"bottleVerifyNums":4,"coverDifferPrice":0,"coverPrice":10,"coverRecycleNums":5,"coverSinglePrice":2,"coverVerifyNums":5,"createTime":"2017-11-13 14:55:49","dealerId":1,"dealerName":"经销商1","financialRemark":"账有问题","id":69,"isGetMoneyByCar":0,"isRecycle":0,"isRecycleDisPlay":"是","moneyByCarDispay":"是","moneyGetByCar":23,"orderActualGetNums":26,"orderActualPrice":20496,"orderApplyPrice":20526,"orderAwardPrice":30,"orderDeliverAmount":31,"orderDifferPrice":-1646.5,"orderFinalPrice":20250.5,"orderNumber":"B2017111314554987241","orderReturnNums":5,"orderReturnPrice":193.5,"orderVerifyPrice":21897,"passTime":"2017-11-13 14:56:58","priority":1,"priotyTime":"18点之前","recyclePrice":52,"refuseReason":"","state":6,"stockistId":3,"stockistVo":{"address":"金融城地铁站","contactName":"zxcsds","createTime":"2017-11-01 16:48:22","dealerNum":0,"id":3,"latPoint":"30.58869","lngPoint":"104.07059","phone":"13734541222","shopName":"地方大幅度"}},"seq":0}]
             * seq : 0
             * stationStatus : 0
             * stockistVo : {"address":"金融城地铁站","contactName":"zxcsds","createTime":"2017-11-01 16:48:22","dealerNum":0,"id":3,"latPoint":"30.58869","lngPoint":"104.07059","phone":"13734541222","shopName":"地方大幅度"}
             */

            private int seq;
            private int stationStatus;
            private StockistVoBean stockistVo;
            private List<OrderAppVosBean> orderAppVos;

            public int getSeq() {
                return seq;
            }

            public void setSeq(int seq) {
                this.seq = seq;
            }

            public int getStationStatus() {
                return stationStatus;
            }

            public void setStationStatus(int stationStatus) {
                this.stationStatus = stationStatus;
            }

            public StockistVoBean getStockistVo() {
                return stockistVo;
            }

            public void setStockistVo(StockistVoBean stockistVo) {
                this.stockistVo = stockistVo;
            }

            public List<OrderAppVosBean> getOrderAppVos() {
                return orderAppVos;
            }

            public void setOrderAppVos(List<OrderAppVosBean> orderAppVos) {
                this.orderAppVos = orderAppVos;
            }

            public static class StockistVoBean {
                /**
                 * address : 金融城地铁站
                 * contactName : zxcsds
                 * createTime : 2017-11-01 16:48:22
                 * dealerNum : 0
                 * id : 3
                 * latPoint : 30.58869
                 * lngPoint : 104.07059
                 * phone : 13734541222
                 * shopName : 地方大幅度
                 */

                private String address;
                private String contactName;
                private String createTime;
                private int dealerNum;
                private int id;
                private String latPoint;
                private String lngPoint;
                private String phone;
                private String shopName;

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public String getContactName() {
                    return contactName;
                }

                public void setContactName(String contactName) {
                    this.contactName = contactName;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public int getDealerNum() {
                    return dealerNum;
                }

                public void setDealerNum(int dealerNum) {
                    this.dealerNum = dealerNum;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getLatPoint() {
                    return latPoint;
                }

                public void setLatPoint(String latPoint) {
                    this.latPoint = latPoint;
                }

                public String getLngPoint() {
                    return lngPoint;
                }

                public void setLngPoint(String lngPoint) {
                    this.lngPoint = lngPoint;
                }

                public String getPhone() {
                    return phone;
                }

                public void setPhone(String phone) {
                    this.phone = phone;
                }

                public String getShopName() {
                    return shopName;
                }

                public void setShopName(String shopName) {
                    this.shopName = shopName;
                }
            }

            public static class OrderAppVosBean {
                /**
                 * goodsOrderVoList : [{"applyAmount":10,"awardAmount":2,"awardCash":10,"categoryVo":{"attribute":22,"createTime":"2017-10-21 21:12:48","goodsName":"统一鲜橙多大瓶","guidePrice":56,"id":2,"isPublic":1,"storageAreaId":1,"storageId":1,"unit":"箱"},"deliverAmount":12,"goodsActualGetNums":10,"goodsActualPrice":9890,"goodsApplyPrice":9900,"goodsDifferPrice":45,"goodsReturnNums":2,"goodsReturnPrice":90,"goodsVerifyReturnNums":1,"goodsfinalPrice":9800,"id":88,"orderNumber":"B2017111314554987241","price":45,"saleGoodsId":5,"storageNums":55},{"applyAmount":14,"awardAmount":5,"awardCash":20,"categoryVo":{"attribute":22,"createTime":"2017-10-21 21:12:48","goodsName":"统一鲜橙多大瓶","guidePrice":56,"id":2,"isPublic":1,"storageAreaId":1,"storageId":1,"unit":"箱"},"deliverAmount":19,"goodsActualGetNums":16,"goodsActualPrice":10606,"goodsApplyPrice":10626,"goodsDifferPrice":0,"goodsReturnNums":3,"goodsReturnPrice":103.5,"goodsVerifyReturnNums":3,"goodsfinalPrice":10502.5,"id":89,"orderNumber":"B2017111314554987241","price":34.5,"saleGoodsId":7,"storageNums":65}]
                 * orderQRcodePath : http://localhost:8080/upload/psQrcode/B2017111314554987241_deliver.jpg
                 * orderVo : {"basketDifferPrice":0,"basketPrice":30,"basketRecycleNums":6,"basketSinglePrice":5,"basketVerifyNums":6,"bottleDifferPrice":0,"bottlePrice":12,"bottleRecycleNums":4,"bottleSinglePrice":3,"bottleVerifyNums":4,"coverDifferPrice":0,"coverPrice":10,"coverRecycleNums":5,"coverSinglePrice":2,"coverVerifyNums":5,"createTime":"2017-11-13 14:55:49","dealerId":1,"dealerName":"经销商1","financialRemark":"账有问题","id":69,"isGetMoneyByCar":0,"isRecycle":0,"isRecycleDisPlay":"是","moneyByCarDispay":"是","moneyGetByCar":23,"orderActualGetNums":26,"orderActualPrice":20496,"orderApplyPrice":20526,"orderAwardPrice":30,"orderDeliverAmount":31,"orderDifferPrice":-1646.5,"orderFinalPrice":20250.5,"orderNumber":"B2017111314554987241","orderReturnNums":5,"orderReturnPrice":193.5,"orderVerifyPrice":21897,"passTime":"2017-11-13 14:56:58","priority":1,"priotyTime":"18点之前","recyclePrice":52,"refuseReason":"","state":6,"stockistId":3,"stockistVo":{"address":"金融城地铁站","contactName":"zxcsds","createTime":"2017-11-01 16:48:22","dealerNum":0,"id":3,"latPoint":"30.58869","lngPoint":"104.07059","phone":"13734541222","shopName":"地方大幅度"}}
                 * seq : 0
                 */

                private String orderQRcodePath;
                private OrderVoBean orderVo;
                private int seq;
                private List<GoodsOrderVoListBean> goodsOrderVoList;

                public String getOrderQRcodePath() {
                    return orderQRcodePath;
                }

                public void setOrderQRcodePath(String orderQRcodePath) {
                    this.orderQRcodePath = orderQRcodePath;
                }

                public OrderVoBean getOrderVo() {
                    return orderVo;
                }

                public void setOrderVo(OrderVoBean orderVo) {
                    this.orderVo = orderVo;
                }

                public int getSeq() {
                    return seq;
                }

                public void setSeq(int seq) {
                    this.seq = seq;
                }

                public List<GoodsOrderVoListBean> getGoodsOrderVoList() {
                    return goodsOrderVoList;
                }

                public void setGoodsOrderVoList(List<GoodsOrderVoListBean> goodsOrderVoList) {
                    this.goodsOrderVoList = goodsOrderVoList;
                }

                public static class OrderVoBean {
                    /**
                     * basketDifferPrice : 0
                     * basketPrice : 30
                     * basketRecycleNums : 6
                     * basketSinglePrice : 5
                     * basketVerifyNums : 6
                     * bottleDifferPrice : 0
                     * bottlePrice : 12
                     * bottleRecycleNums : 4
                     * bottleSinglePrice : 3
                     * bottleVerifyNums : 4
                     * coverDifferPrice : 0
                     * coverPrice : 10
                     * coverRecycleNums : 5
                     * coverSinglePrice : 2
                     * coverVerifyNums : 5
                     * createTime : 2017-11-13 14:55:49
                     * dealerId : 1
                     * dealerName : 经销商1
                     * financialRemark : 账有问题
                     * id : 69
                     * isGetMoneyByCar : 0
                     * isRecycle : 0
                     * isRecycleDisPlay : 是
                     * moneyByCarDispay : 是
                     * moneyGetByCar : 23
                     * orderActualGetNums : 26
                     * orderActualPrice : 20496
                     * orderApplyPrice : 20526
                     * orderAwardPrice : 30
                     * orderDeliverAmount : 31
                     * orderDifferPrice : -1646.5
                     * orderFinalPrice : 20250.5
                     * orderNumber : B2017111314554987241
                     * orderReturnNums : 5
                     * orderReturnPrice : 193.5
                     * orderVerifyPrice : 21897
                     * passTime : 2017-11-13 14:56:58
                     * priority : 1
                     * priotyTime : 18点之前
                     * recyclePrice : 52
                     * refuseReason :
                     * state : 6
                     * stockistId : 3
                     * stockistVo : {"address":"金融城地铁站","contactName":"zxcsds","createTime":"2017-11-01 16:48:22","dealerNum":0,"id":3,"latPoint":"30.58869","lngPoint":"104.07059","phone":"13734541222","shopName":"地方大幅度"}
                     */

                    private double basketDifferPrice;
                    private double basketPrice;
                    private int basketRecycleNums;
                    private double basketSinglePrice;
                    private int basketVerifyNums;
                    private double bottleDifferPrice;
                    private double bottlePrice;
                    private int bottleRecycleNums;
                    private double bottleSinglePrice;
                    private int bottleVerifyNums;
                    private double coverDifferPrice;
                    private double coverPrice;
                    private int coverRecycleNums;
                    private double coverSinglePrice;
                    private int coverVerifyNums;
                    private String createTime;
                    private int dealerId;
                    private String dealerName;
                    private String financialRemark;
                    private int id;
                    private int isGetMoneyByCar;
                    private int isRecycle;
                    private String isRecycleDisPlay;
                    private String moneyByCarDispay;
                    private int moneyGetByCar;
                    private int orderActualGetNums;
                    private double orderActualPrice;
                    private double orderApplyPrice;
                    private double orderAwardPrice;
                    private int orderDeliverAmount;
                    private double orderDifferPrice;
                    private double orderFinalPrice;
                    private String orderNumber;
                    private int orderReturnNums;
                    private double orderReturnPrice;
                    private double orderVerifyPrice;
                    private String passTime;
                    private int priority;
                    private String priotyTime;
                    private double recyclePrice;
                    private String refuseReason;
                    private int state;
                    private int stockistId;
                    private StockistVoBeanX stockistVo;

                    public double getBasketDifferPrice() {
                        return basketDifferPrice;
                    }

                    public void setBasketDifferPrice(double basketDifferPrice) {
                        this.basketDifferPrice = basketDifferPrice;
                    }

                    public double getBasketPrice() {
                        return basketPrice;
                    }

                    public void setBasketPrice(double basketPrice) {
                        this.basketPrice = basketPrice;
                    }

                    public int getBasketRecycleNums() {
                        return basketRecycleNums;
                    }

                    public void setBasketRecycleNums(int basketRecycleNums) {
                        this.basketRecycleNums = basketRecycleNums;
                    }

                    public double getBasketSinglePrice() {
                        return basketSinglePrice;
                    }

                    public void setBasketSinglePrice(double basketSinglePrice) {
                        this.basketSinglePrice = basketSinglePrice;
                    }

                    public int getBasketVerifyNums() {
                        return basketVerifyNums;
                    }

                    public void setBasketVerifyNums(int basketVerifyNums) {
                        this.basketVerifyNums = basketVerifyNums;
                    }

                    public double getBottleDifferPrice() {
                        return bottleDifferPrice;
                    }

                    public void setBottleDifferPrice(double bottleDifferPrice) {
                        this.bottleDifferPrice = bottleDifferPrice;
                    }

                    public double getBottlePrice() {
                        return bottlePrice;
                    }

                    public void setBottlePrice(double bottlePrice) {
                        this.bottlePrice = bottlePrice;
                    }

                    public int getBottleRecycleNums() {
                        return bottleRecycleNums;
                    }

                    public void setBottleRecycleNums(int bottleRecycleNums) {
                        this.bottleRecycleNums = bottleRecycleNums;
                    }

                    public double getBottleSinglePrice() {
                        return bottleSinglePrice;
                    }

                    public void setBottleSinglePrice(double bottleSinglePrice) {
                        this.bottleSinglePrice = bottleSinglePrice;
                    }

                    public int getBottleVerifyNums() {
                        return bottleVerifyNums;
                    }

                    public void setBottleVerifyNums(int bottleVerifyNums) {
                        this.bottleVerifyNums = bottleVerifyNums;
                    }

                    public double getCoverDifferPrice() {
                        return coverDifferPrice;
                    }

                    public void setCoverDifferPrice(double coverDifferPrice) {
                        this.coverDifferPrice = coverDifferPrice;
                    }

                    public double getCoverPrice() {
                        return coverPrice;
                    }

                    public void setCoverPrice(double coverPrice) {
                        this.coverPrice = coverPrice;
                    }

                    public int getCoverRecycleNums() {
                        return coverRecycleNums;
                    }

                    public void setCoverRecycleNums(int coverRecycleNums) {
                        this.coverRecycleNums = coverRecycleNums;
                    }

                    public double getCoverSinglePrice() {
                        return coverSinglePrice;
                    }

                    public void setCoverSinglePrice(double coverSinglePrice) {
                        this.coverSinglePrice = coverSinglePrice;
                    }

                    public int getCoverVerifyNums() {
                        return coverVerifyNums;
                    }

                    public void setCoverVerifyNums(int coverVerifyNums) {
                        this.coverVerifyNums = coverVerifyNums;
                    }

                    public String getCreateTime() {
                        return createTime;
                    }

                    public void setCreateTime(String createTime) {
                        this.createTime = createTime;
                    }

                    public int getDealerId() {
                        return dealerId;
                    }

                    public void setDealerId(int dealerId) {
                        this.dealerId = dealerId;
                    }

                    public String getDealerName() {
                        return dealerName;
                    }

                    public void setDealerName(String dealerName) {
                        this.dealerName = dealerName;
                    }

                    public String getFinancialRemark() {
                        return financialRemark;
                    }

                    public void setFinancialRemark(String financialRemark) {
                        this.financialRemark = financialRemark;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public int getIsGetMoneyByCar() {
                        return isGetMoneyByCar;
                    }

                    public void setIsGetMoneyByCar(int isGetMoneyByCar) {
                        this.isGetMoneyByCar = isGetMoneyByCar;
                    }

                    public int getIsRecycle() {
                        return isRecycle;
                    }

                    public void setIsRecycle(int isRecycle) {
                        this.isRecycle = isRecycle;
                    }

                    public String getIsRecycleDisPlay() {
                        return isRecycleDisPlay;
                    }

                    public void setIsRecycleDisPlay(String isRecycleDisPlay) {
                        this.isRecycleDisPlay = isRecycleDisPlay;
                    }

                    public String getMoneyByCarDispay() {
                        return moneyByCarDispay;
                    }

                    public void setMoneyByCarDispay(String moneyByCarDispay) {
                        this.moneyByCarDispay = moneyByCarDispay;
                    }

                    public int getMoneyGetByCar() {
                        return moneyGetByCar;
                    }

                    public void setMoneyGetByCar(int moneyGetByCar) {
                        this.moneyGetByCar = moneyGetByCar;
                    }

                    public int getOrderActualGetNums() {
                        return orderActualGetNums;
                    }

                    public void setOrderActualGetNums(int orderActualGetNums) {
                        this.orderActualGetNums = orderActualGetNums;
                    }

                    public double getOrderActualPrice() {
                        return orderActualPrice;
                    }

                    public void setOrderActualPrice(double orderActualPrice) {
                        this.orderActualPrice = orderActualPrice;
                    }

                    public double getOrderApplyPrice() {
                        return orderApplyPrice;
                    }

                    public void setOrderApplyPrice(double orderApplyPrice) {
                        this.orderApplyPrice = orderApplyPrice;
                    }

                    public double getOrderAwardPrice() {
                        return orderAwardPrice;
                    }

                    public void setOrderAwardPrice(double orderAwardPrice) {
                        this.orderAwardPrice = orderAwardPrice;
                    }

                    public int getOrderDeliverAmount() {
                        return orderDeliverAmount;
                    }

                    public void setOrderDeliverAmount(int orderDeliverAmount) {
                        this.orderDeliverAmount = orderDeliverAmount;
                    }

                    public double getOrderDifferPrice() {
                        return orderDifferPrice;
                    }

                    public void setOrderDifferPrice(double orderDifferPrice) {
                        this.orderDifferPrice = orderDifferPrice;
                    }

                    public double getOrderFinalPrice() {
                        return orderFinalPrice;
                    }

                    public void setOrderFinalPrice(double orderFinalPrice) {
                        this.orderFinalPrice = orderFinalPrice;
                    }

                    public String getOrderNumber() {
                        return orderNumber;
                    }

                    public void setOrderNumber(String orderNumber) {
                        this.orderNumber = orderNumber;
                    }

                    public int getOrderReturnNums() {
                        return orderReturnNums;
                    }

                    public void setOrderReturnNums(int orderReturnNums) {
                        this.orderReturnNums = orderReturnNums;
                    }

                    public double getOrderReturnPrice() {
                        return orderReturnPrice;
                    }

                    public void setOrderReturnPrice(double orderReturnPrice) {
                        this.orderReturnPrice = orderReturnPrice;
                    }

                    public double getOrderVerifyPrice() {
                        return orderVerifyPrice;
                    }

                    public void setOrderVerifyPrice(double orderVerifyPrice) {
                        this.orderVerifyPrice = orderVerifyPrice;
                    }

                    public String getPassTime() {
                        return passTime;
                    }

                    public void setPassTime(String passTime) {
                        this.passTime = passTime;
                    }

                    public int getPriority() {
                        return priority;
                    }

                    public void setPriority(int priority) {
                        this.priority = priority;
                    }

                    public String getPriotyTime() {
                        return priotyTime;
                    }

                    public void setPriotyTime(String priotyTime) {
                        this.priotyTime = priotyTime;
                    }

                    public double getRecyclePrice() {
                        return recyclePrice;
                    }

                    public void setRecyclePrice(double recyclePrice) {
                        this.recyclePrice = recyclePrice;
                    }

                    public String getRefuseReason() {
                        return refuseReason;
                    }

                    public void setRefuseReason(String refuseReason) {
                        this.refuseReason = refuseReason;
                    }

                    public int getState() {
                        return state;
                    }

                    public void setState(int state) {
                        this.state = state;
                    }

                    public int getStockistId() {
                        return stockistId;
                    }

                    public void setStockistId(int stockistId) {
                        this.stockistId = stockistId;
                    }

                    public StockistVoBeanX getStockistVo() {
                        return stockistVo;
                    }

                    public void setStockistVo(StockistVoBeanX stockistVo) {
                        this.stockistVo = stockistVo;
                    }

                    public static class StockistVoBeanX {
                        /**
                         * address : 金融城地铁站
                         * contactName : zxcsds
                         * createTime : 2017-11-01 16:48:22
                         * dealerNum : 0
                         * id : 3
                         * latPoint : 30.58869
                         * lngPoint : 104.07059
                         * phone : 13734541222
                         * shopName : 地方大幅度
                         */

                        private String address;
                        private String contactName;
                        private String createTime;
                        private int dealerNum;
                        private int id;
                        private String latPoint;
                        private String lngPoint;
                        private String phone;
                        private String shopName;

                        public String getAddress() {
                            return address;
                        }

                        public void setAddress(String address) {
                            this.address = address;
                        }

                        public String getContactName() {
                            return contactName;
                        }

                        public void setContactName(String contactName) {
                            this.contactName = contactName;
                        }

                        public String getCreateTime() {
                            return createTime;
                        }

                        public void setCreateTime(String createTime) {
                            this.createTime = createTime;
                        }

                        public int getDealerNum() {
                            return dealerNum;
                        }

                        public void setDealerNum(int dealerNum) {
                            this.dealerNum = dealerNum;
                        }

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }

                        public String getLatPoint() {
                            return latPoint;
                        }

                        public void setLatPoint(String latPoint) {
                            this.latPoint = latPoint;
                        }

                        public String getLngPoint() {
                            return lngPoint;
                        }

                        public void setLngPoint(String lngPoint) {
                            this.lngPoint = lngPoint;
                        }

                        public String getPhone() {
                            return phone;
                        }

                        public void setPhone(String phone) {
                            this.phone = phone;
                        }

                        public String getShopName() {
                            return shopName;
                        }

                        public void setShopName(String shopName) {
                            this.shopName = shopName;
                        }
                    }
                }

                public static class GoodsOrderVoListBean {
                    /**
                     * applyAmount : 10
                     * awardAmount : 2
                     * awardCash : 10
                     * categoryVo : {"attribute":22,"createTime":"2017-10-21 21:12:48","goodsName":"统一鲜橙多大瓶","guidePrice":56,"id":2,"isPublic":1,"storageAreaId":1,"storageId":1,"unit":"箱"}
                     * deliverAmount : 12
                     * goodsActualGetNums : 10
                     * goodsActualPrice : 9890
                     * goodsApplyPrice : 9900
                     * goodsDifferPrice : 45
                     * goodsReturnNums : 2
                     * goodsReturnPrice : 90
                     * goodsVerifyReturnNums : 1
                     * goodsfinalPrice : 9800
                     * id : 88
                     * orderNumber : B2017111314554987241
                     * price : 45
                     * saleGoodsId : 5
                     * storageNums : 55
                     */

                    private double applyAmount;
                    private double awardAmount;
                    private double awardCash;
                    private CategoryVoBean categoryVo;
                    private double deliverAmount;
                    private int goodsActualGetNums;
                    private double goodsActualPrice;
                    private double goodsApplyPrice;
                    private double goodsDifferPrice;
                    private int goodsReturnNums;
                    private double goodsReturnPrice;
                    private int goodsVerifyReturnNums;
                    private double goodsfinalPrice;
                    private int id;
                    private String orderNumber;
                    private double price;
                    private int saleGoodsId;
                    private int storageNums;

                    public double getApplyAmount() {
                        return applyAmount;
                    }

                    public void setApplyAmount(double applyAmount) {
                        this.applyAmount = applyAmount;
                    }

                    public double getAwardAmount() {
                        return awardAmount;
                    }

                    public void setAwardAmount(double awardAmount) {
                        this.awardAmount = awardAmount;
                    }

                    public double getAwardCash() {
                        return awardCash;
                    }

                    public void setAwardCash(double awardCash) {
                        this.awardCash = awardCash;
                    }

                    public CategoryVoBean getCategoryVo() {
                        return categoryVo;
                    }

                    public void setCategoryVo(CategoryVoBean categoryVo) {
                        this.categoryVo = categoryVo;
                    }

                    public double getDeliverAmount() {
                        return deliverAmount;
                    }

                    public void setDeliverAmount(double deliverAmount) {
                        this.deliverAmount = deliverAmount;
                    }

                    public int getGoodsActualGetNums() {
                        return goodsActualGetNums;
                    }

                    public void setGoodsActualGetNums(int goodsActualGetNums) {
                        this.goodsActualGetNums = goodsActualGetNums;
                    }

                    public double getGoodsActualPrice() {
                        return goodsActualPrice;
                    }

                    public void setGoodsActualPrice(double goodsActualPrice) {
                        this.goodsActualPrice = goodsActualPrice;
                    }

                    public double getGoodsApplyPrice() {
                        return goodsApplyPrice;
                    }

                    public void setGoodsApplyPrice(double goodsApplyPrice) {
                        this.goodsApplyPrice = goodsApplyPrice;
                    }

                    public double getGoodsDifferPrice() {
                        return goodsDifferPrice;
                    }

                    public void setGoodsDifferPrice(double goodsDifferPrice) {
                        this.goodsDifferPrice = goodsDifferPrice;
                    }

                    public int getGoodsReturnNums() {
                        return goodsReturnNums;
                    }

                    public void setGoodsReturnNums(int goodsReturnNums) {
                        this.goodsReturnNums = goodsReturnNums;
                    }

                    public double getGoodsReturnPrice() {
                        return goodsReturnPrice;
                    }

                    public void setGoodsReturnPrice(double goodsReturnPrice) {
                        this.goodsReturnPrice = goodsReturnPrice;
                    }

                    public int getGoodsVerifyReturnNums() {
                        return goodsVerifyReturnNums;
                    }

                    public void setGoodsVerifyReturnNums(int goodsVerifyReturnNums) {
                        this.goodsVerifyReturnNums = goodsVerifyReturnNums;
                    }

                    public double getGoodsfinalPrice() {
                        return goodsfinalPrice;
                    }

                    public void setGoodsfinalPrice(double goodsfinalPrice) {
                        this.goodsfinalPrice = goodsfinalPrice;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getOrderNumber() {
                        return orderNumber;
                    }

                    public void setOrderNumber(String orderNumber) {
                        this.orderNumber = orderNumber;
                    }

                    public double getPrice() {
                        return price;
                    }

                    public void setPrice(double price) {
                        this.price = price;
                    }

                    public int getSaleGoodsId() {
                        return saleGoodsId;
                    }

                    public void setSaleGoodsId(int saleGoodsId) {
                        this.saleGoodsId = saleGoodsId;
                    }

                    public int getStorageNums() {
                        return storageNums;
                    }

                    public void setStorageNums(int storageNums) {
                        this.storageNums = storageNums;
                    }

                    public static class CategoryVoBean {
                        /**
                         * attribute : 22
                         * createTime : 2017-10-21 21:12:48
                         * goodsName : 统一鲜橙多大瓶
                         * guidePrice : 56
                         * id : 2
                         * isPublic : 1
                         * storageAreaId : 1
                         * storageId : 1
                         * unit : 箱
                         */

                        private int attribute;
                        private String createTime;
                        private String goodsName;
                        private double guidePrice;
                        private int id;
                        private int isPublic;
                        private int storageAreaId;
                        private int storageId;
                        private String unit;

                        public int getAttribute() {
                            return attribute;
                        }

                        public void setAttribute(int attribute) {
                            this.attribute = attribute;
                        }

                        public String getCreateTime() {
                            return createTime;
                        }

                        public void setCreateTime(String createTime) {
                            this.createTime = createTime;
                        }

                        public String getGoodsName() {
                            return goodsName;
                        }

                        public void setGoodsName(String goodsName) {
                            this.goodsName = goodsName;
                        }

                        public double getGuidePrice() {
                            return guidePrice;
                        }

                        public void setGuidePrice(double guidePrice) {
                            this.guidePrice = guidePrice;
                        }

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }

                        public int getIsPublic() {
                            return isPublic;
                        }

                        public void setIsPublic(int isPublic) {
                            this.isPublic = isPublic;
                        }

                        public int getStorageAreaId() {
                            return storageAreaId;
                        }

                        public void setStorageAreaId(int storageAreaId) {
                            this.storageAreaId = storageAreaId;
                        }

                        public int getStorageId() {
                            return storageId;
                        }

                        public void setStorageId(int storageId) {
                            this.storageId = storageId;
                        }

                        public String getUnit() {
                            return unit;
                        }

                        public void setUnit(String unit) {
                            this.unit = unit;
                        }
                    }
                }
            }
        }
    }
}

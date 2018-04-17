package com.drkj.logisticswarehouse.bean;

import java.util.List;

/**
 * Created by ganlong on 2017/11/13.
 */

public class ResultOrderDetailBean {

    /**
     * code : 200
     * data : {"catalogueVoList":[{"ReclaimCatalogueId":1,"price":0,"reclaimNums":3}],"goodsOrderVoList":[{"applyAmount":23,"areaName":"XCW区","attribute":100,"awardAmount":3,"awardCash":0,"categoryVo":{"areaName":"XCW区","attribute":100,"childUnit":"包","createTime":"2017-11-15 13:54:43","goodsCategoryName":"牛板筋","goodsName":"牛板筋1号","guidePrice":2,"id":29,"isPublic":1,"storageAreaId":61,"storageId":2,"storageName":"田总的新中伟业仓库","unit":"件","visualAttribute":"12X500ml"},"childApplyAmount":2,"childAwardAmount":0,"childDeliverAmount":2,"childGoodsActualGetNums":0,"childGoodsReturnNums":0,"deliverAmount":26,"goodsActualGetNums":0,"goodsActualPrice":11510,"goodsApplyPrice":11510,"goodsName":"牛板筋1号","goodsReturnNums":0,"id":647,"orderNumber":"B2017122114253596364","price":5,"saleGoodsId":41,"storageAreaId":61,"storageId":2,"storageName":"田总的新中伟业仓库","storageNums":2104},{"applyAmount":2,"areaName":"XCV区","attribute":24,"awardAmount":1,"awardCash":0,"categoryVo":{"areaName":"XCV区","attribute":24,"childUnit":"盒","createTime":"2017-11-15 13:56:09","goodsCategoryName":"伊利","goodsName":"伊利纯牛奶","guidePrice":2.31,"id":30,"isPublic":1,"nickName":"xcxcs","storageAreaId":49,"storageId":2,"storageName":"田总的新中伟业仓库","unit":"件","visualAttribute":"12X500ml"},"childApplyAmount":4,"childAwardAmount":0,"childDeliverAmount":4,"childGoodsActualGetNums":0,"childGoodsReturnNums":0,"deliverAmount":3,"goodsActualGetNums":0,"goodsActualPrice":1196,"goodsApplyPrice":1196,"goodsName":"伊利纯牛奶","goodsReturnNums":0,"id":649,"nickName":"xcxcs","orderNumber":"B2017122114253596364","price":23,"saleGoodsId":61,"storageAreaId":49,"storageId":2,"storageName":"田总的新中伟业仓库","storageNums":18}],"orderQRcodePath":"http://106.15.57.208:18080/entrance/upload/psQrcode/B2017122114253596364_deliver.jpg","orderVo":{"basketDifferPrice":0,"basketPrice":0,"basketRecycleNums":0,"basketSinglePrice":5,"basketVerifyNums":0,"bottleDifferPrice":0,"bottlePrice":0,"bottleRecycleNums":0,"bottleSinglePrice":3,"bottleVerifyNums":0,"carVo":{"carNumber":"川A0998776","carStatus":1,"carStatusDisplay":"配送中","creatTime":"2017-12-26 12:06:04","id":79,"remark":"dsds","storageId":2,"storageVo":{"address":"西航港通关路69号","areaRange":8000,"city":"成都市","contacterName":"田总","contacterPhone":"18267049870","createTime":"2017-11-15 10:59:55","dicCityId":6820,"dicDdistrictId":6831,"dicProvinceId":6819,"district":"双流区","id":2,"leftAreaRange":5000,"province":"四川省","storageName":"田总的新中伟业仓库"}},"coverDifferPrice":0,"coverPrice":0,"coverRecycleNums":0,"coverSinglePrice":2,"coverVerifyNums":0,"createTime":"2017-12-21 14:25:35","dealerId":13,"dealerName":"发的发的","driverVo":{"createTime":"2018-01-04 10:43:22","driverName":"三菱司机","driverPhone":"18782966666","driverStatus":1,"driverStatusDisplay":"配送中","id":13,"remark":"","storageId":2,"storageVo":{"address":"西航港通关路69号","areaRange":8000,"city":"成都市","contacterName":"田总","contacterPhone":"18267049870","createTime":"2017-11-15 10:59:55","dicCityId":6820,"dicDdistrictId":6831,"dicProvinceId":6819,"district":"双流区","id":2,"leftAreaRange":5000,"province":"四川省","storageName":"田总的新中伟业仓库"}},"id":335,"isFlash":0,"isInOrderFlow":1,"isRecycle":0,"isRecycleDisPlay":"是","moneyByCarDispay":"","moneyGetByCar":0,"orderActualGetNums":0,"orderActualPrice":12706,"orderApplyPrice":12706,"orderAwardPrice":0,"orderDeliverAmount":31,"orderFinalPrice":0,"orderNumber":"B2017122114253596364","orderReturnNums":0,"orderReturnPrice":0,"orderType":0,"passTime":"2017-12-21 14:25:36","priority":2,"priotyTime":"18点之后","recyclePrice":0,"refuseReason":"","remark":"","shopName":"路人甲的零售店","state":3,"stockistId":10,"stockistVo":{"address":"双流区大件路文星段6号","contactName":"路人甲","createTime":"2017-11-15 11:04:49","dealerNum":6,"displayStockistType":"签单","displayTypes":"酒吧","id":10,"latPoint":"30.32340","lngPoint":"104.34320","phone":"13111111111","shopName":"路人甲的零售店","stockistType":"38931","types":"37763"},"storageId":2,"storageName":"田总的新中伟业仓库"},"seq":0}
     * msg : 操作成功!
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
         * catalogueVoList : [{"ReclaimCatalogueId":1,"price":0,"verifyNums":3}]
         * goodsOrderVoList : [{"applyAmount":23,"areaName":"XCW区","attribute":100,"awardAmount":3,"awardCash":0,"categoryVo":{"areaName":"XCW区","attribute":100,"childUnit":"包","createTime":"2017-11-15 13:54:43","goodsCategoryName":"牛板筋","goodsName":"牛板筋1号","guidePrice":2,"id":29,"isPublic":1,"storageAreaId":61,"storageId":2,"storageName":"田总的新中伟业仓库","unit":"件","visualAttribute":"12X500ml"},"childApplyAmount":2,"childAwardAmount":0,"childDeliverAmount":2,"childGoodsActualGetNums":0,"childGoodsReturnNums":0,"deliverAmount":26,"goodsActualGetNums":0,"goodsActualPrice":11510,"goodsApplyPrice":11510,"goodsName":"牛板筋1号","goodsReturnNums":0,"id":647,"orderNumber":"B2017122114253596364","price":5,"saleGoodsId":41,"storageAreaId":61,"storageId":2,"storageName":"田总的新中伟业仓库","storageNums":2104},{"applyAmount":2,"areaName":"XCV区","attribute":24,"awardAmount":1,"awardCash":0,"categoryVo":{"areaName":"XCV区","attribute":24,"childUnit":"盒","createTime":"2017-11-15 13:56:09","goodsCategoryName":"伊利","goodsName":"伊利纯牛奶","guidePrice":2.31,"id":30,"isPublic":1,"nickName":"xcxcs","storageAreaId":49,"storageId":2,"storageName":"田总的新中伟业仓库","unit":"件","visualAttribute":"12X500ml"},"childApplyAmount":4,"childAwardAmount":0,"childDeliverAmount":4,"childGoodsActualGetNums":0,"childGoodsReturnNums":0,"deliverAmount":3,"goodsActualGetNums":0,"goodsActualPrice":1196,"goodsApplyPrice":1196,"goodsName":"伊利纯牛奶","goodsReturnNums":0,"id":649,"nickName":"xcxcs","orderNumber":"B2017122114253596364","price":23,"saleGoodsId":61,"storageAreaId":49,"storageId":2,"storageName":"田总的新中伟业仓库","storageNums":18}]
         * orderQRcodePath : http://106.15.57.208:18080/entrance/upload/psQrcode/B2017122114253596364_deliver.jpg
         * orderVo : {"basketDifferPrice":0,"basketPrice":0,"basketRecycleNums":0,"basketSinglePrice":5,"basketVerifyNums":0,"bottleDifferPrice":0,"bottlePrice":0,"bottleRecycleNums":0,"bottleSinglePrice":3,"bottleVerifyNums":0,"carVo":{"carNumber":"川A0998776","carStatus":1,"carStatusDisplay":"配送中","creatTime":"2017-12-26 12:06:04","id":79,"remark":"dsds","storageId":2,"storageVo":{"address":"西航港通关路69号","areaRange":8000,"city":"成都市","contacterName":"田总","contacterPhone":"18267049870","createTime":"2017-11-15 10:59:55","dicCityId":6820,"dicDdistrictId":6831,"dicProvinceId":6819,"district":"双流区","id":2,"leftAreaRange":5000,"province":"四川省","storageName":"田总的新中伟业仓库"}},"coverDifferPrice":0,"coverPrice":0,"coverRecycleNums":0,"coverSinglePrice":2,"coverVerifyNums":0,"createTime":"2017-12-21 14:25:35","dealerId":13,"dealerName":"发的发的","driverVo":{"createTime":"2018-01-04 10:43:22","driverName":"三菱司机","driverPhone":"18782966666","driverStatus":1,"driverStatusDisplay":"配送中","id":13,"remark":"","storageId":2,"storageVo":{"address":"西航港通关路69号","areaRange":8000,"city":"成都市","contacterName":"田总","contacterPhone":"18267049870","createTime":"2017-11-15 10:59:55","dicCityId":6820,"dicDdistrictId":6831,"dicProvinceId":6819,"district":"双流区","id":2,"leftAreaRange":5000,"province":"四川省","storageName":"田总的新中伟业仓库"}},"id":335,"isFlash":0,"isInOrderFlow":1,"isRecycle":0,"isRecycleDisPlay":"是","moneyByCarDispay":"","moneyGetByCar":0,"orderActualGetNums":0,"orderActualPrice":12706,"orderApplyPrice":12706,"orderAwardPrice":0,"orderDeliverAmount":31,"orderFinalPrice":0,"orderNumber":"B2017122114253596364","orderReturnNums":0,"orderReturnPrice":0,"orderType":0,"passTime":"2017-12-21 14:25:36","priority":2,"priotyTime":"18点之后","recyclePrice":0,"refuseReason":"","remark":"","shopName":"路人甲的零售店","state":3,"stockistId":10,"stockistVo":{"address":"双流区大件路文星段6号","contactName":"路人甲","createTime":"2017-11-15 11:04:49","dealerNum":6,"displayStockistType":"签单","displayTypes":"酒吧","id":10,"latPoint":"30.32340","lngPoint":"104.34320","phone":"13111111111","shopName":"路人甲的零售店","stockistType":"38931","types":"37763"},"storageId":2,"storageName":"田总的新中伟业仓库"}
         * seq : 0
         */

        private String orderQRcodePath;
        private OrderVoBean orderVo;
        private int seq;
        private List<CatalogueVoListBean> catalogueVoList;
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

        public List<CatalogueVoListBean> getCatalogueVoList() {
            return catalogueVoList;
        }

        public void setCatalogueVoList(List<CatalogueVoListBean> catalogueVoList) {
            this.catalogueVoList = catalogueVoList;
        }

        public List<GoodsOrderVoListBean> getGoodsOrderVoList() {
            return goodsOrderVoList;
        }

        public void setGoodsOrderVoList(List<GoodsOrderVoListBean> goodsOrderVoList) {
            this.goodsOrderVoList = goodsOrderVoList;
        }

        public static class OrderVoBean {
            /**
             * basketDifferPrice : 0.0
             * basketPrice : 0.0
             * basketRecycleNums : 0
             * basketSinglePrice : 5.0
             * basketVerifyNums : 0
             * bottleDifferPrice : 0.0
             * bottlePrice : 0.0
             * bottleRecycleNums : 0
             * bottleSinglePrice : 3.0
             * bottleVerifyNums : 0
             * carVo : {"carNumber":"川A0998776","carStatus":1,"carStatusDisplay":"配送中","creatTime":"2017-12-26 12:06:04","id":79,"remark":"dsds","storageId":2,"storageVo":{"address":"西航港通关路69号","areaRange":8000,"city":"成都市","contacterName":"田总","contacterPhone":"18267049870","createTime":"2017-11-15 10:59:55","dicCityId":6820,"dicDdistrictId":6831,"dicProvinceId":6819,"district":"双流区","id":2,"leftAreaRange":5000,"province":"四川省","storageName":"田总的新中伟业仓库"}}
             * coverDifferPrice : 0.0
             * coverPrice : 0.0
             * coverRecycleNums : 0
             * coverSinglePrice : 2.0
             * coverVerifyNums : 0
             * createTime : 2017-12-21 14:25:35
             * dealerId : 13
             * dealerName : 发的发的
             * driverVo : {"createTime":"2018-01-04 10:43:22","driverName":"三菱司机","driverPhone":"18782966666","driverStatus":1,"driverStatusDisplay":"配送中","id":13,"remark":"","storageId":2,"storageVo":{"address":"西航港通关路69号","areaRange":8000,"city":"成都市","contacterName":"田总","contacterPhone":"18267049870","createTime":"2017-11-15 10:59:55","dicCityId":6820,"dicDdistrictId":6831,"dicProvinceId":6819,"district":"双流区","id":2,"leftAreaRange":5000,"province":"四川省","storageName":"田总的新中伟业仓库"}}
             * id : 335
             * isFlash : 0
             * isInOrderFlow : 1
             * isRecycle : 0
             * isRecycleDisPlay : 是
             * moneyByCarDispay :
             * moneyGetByCar : 0
             * orderActualGetNums : 0
             * orderActualPrice : 12706.0
             * orderApplyPrice : 12706.0
             * orderAwardPrice : 0.0
             * orderDeliverAmount : 31
             * orderFinalPrice : 0.0
             * orderNumber : B2017122114253596364
             * orderReturnNums : 0
             * orderReturnPrice : 0.0
             * orderType : 0
             * passTime : 2017-12-21 14:25:36
             * priority : 2
             * priotyTime : 18点之后
             * recyclePrice : 0.0
             * refuseReason :
             * remark :
             * shopName : 路人甲的零售店
             * state : 3
             * stockistId : 10
             * stockistVo : {"address":"双流区大件路文星段6号","contactName":"路人甲","createTime":"2017-11-15 11:04:49","dealerNum":6,"displayStockistType":"签单","displayTypes":"酒吧","id":10,"latPoint":"30.32340","lngPoint":"104.34320","phone":"13111111111","shopName":"路人甲的零售店","stockistType":"38931","types":"37763"}
             * storageId : 2
             * storageName : 田总的新中伟业仓库
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
            private CarVoBean carVo;
            private double coverDifferPrice;
            private double coverPrice;
            private int coverRecycleNums;
            private double coverSinglePrice;
            private int coverVerifyNums;
            private String createTime;
            private int dealerId;
            private String dealerName;
            private DriverVoBean driverVo;
            private int id;
            private int isFlash;
            private int isInOrderFlow;
            private int isRecycle;
            private String isRecycleDisPlay;
            private String moneyByCarDispay;
            private int moneyGetByCar;
            private int orderActualGetNums;
            private double orderActualPrice;
            private double orderApplyPrice;
            private double orderAwardPrice;
            private int orderDeliverAmount;
            private double orderFinalPrice;
            private String orderNumber;
            private int orderReturnNums;
            private double orderReturnPrice;
            private int orderType;
            private String passTime;
            private int priority;
            private String priotyTime;
            private double recyclePrice;
            private String refuseReason;
            private String remark;
            private String shopName;
            private int state;
            private int stockistId;
            private StockistVoBean stockistVo;
            private int storageId;
            private String storageName;

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

            public CarVoBean getCarVo() {
                return carVo;
            }

            public void setCarVo(CarVoBean carVo) {
                this.carVo = carVo;
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

            public DriverVoBean getDriverVo() {
                return driverVo;
            }

            public void setDriverVo(DriverVoBean driverVo) {
                this.driverVo = driverVo;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getIsFlash() {
                return isFlash;
            }

            public void setIsFlash(int isFlash) {
                this.isFlash = isFlash;
            }

            public int getIsInOrderFlow() {
                return isInOrderFlow;
            }

            public void setIsInOrderFlow(int isInOrderFlow) {
                this.isInOrderFlow = isInOrderFlow;
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

            public int getOrderType() {
                return orderType;
            }

            public void setOrderType(int orderType) {
                this.orderType = orderType;
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

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getShopName() {
                return shopName;
            }

            public void setShopName(String shopName) {
                this.shopName = shopName;
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

            public StockistVoBean getStockistVo() {
                return stockistVo;
            }

            public void setStockistVo(StockistVoBean stockistVo) {
                this.stockistVo = stockistVo;
            }

            public int getStorageId() {
                return storageId;
            }

            public void setStorageId(int storageId) {
                this.storageId = storageId;
            }

            public String getStorageName() {
                return storageName;
            }

            public void setStorageName(String storageName) {
                this.storageName = storageName;
            }

            public static class CarVoBean {
                /**
                 * carNumber : 川A0998776
                 * carStatus : 1
                 * carStatusDisplay : 配送中
                 * creatTime : 2017-12-26 12:06:04
                 * id : 79
                 * remark : dsds
                 * storageId : 2
                 * storageVo : {"address":"西航港通关路69号","areaRange":8000,"city":"成都市","contacterName":"田总","contacterPhone":"18267049870","createTime":"2017-11-15 10:59:55","dicCityId":6820,"dicDdistrictId":6831,"dicProvinceId":6819,"district":"双流区","id":2,"leftAreaRange":5000,"province":"四川省","storageName":"田总的新中伟业仓库"}
                 */

                private String carNumber;
                private int carStatus;
                private String carStatusDisplay;
                private String creatTime;
                private int id;
                private String remark;
                private int storageId;
                private StorageVoBean storageVo;

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

                public int getStorageId() {
                    return storageId;
                }

                public void setStorageId(int storageId) {
                    this.storageId = storageId;
                }

                public StorageVoBean getStorageVo() {
                    return storageVo;
                }

                public void setStorageVo(StorageVoBean storageVo) {
                    this.storageVo = storageVo;
                }

                public static class StorageVoBean {
                    /**
                     * address : 西航港通关路69号
                     * areaRange : 8000
                     * city : 成都市
                     * contacterName : 田总
                     * contacterPhone : 18267049870
                     * createTime : 2017-11-15 10:59:55
                     * dicCityId : 6820
                     * dicDdistrictId : 6831
                     * dicProvinceId : 6819
                     * district : 双流区
                     * id : 2
                     * leftAreaRange : 5000
                     * province : 四川省
                     * storageName : 田总的新中伟业仓库
                     */

                    private String address;
                    private int areaRange;
                    private String city;
                    private String contacterName;
                    private String contacterPhone;
                    private String createTime;
                    private int dicCityId;
                    private int dicDdistrictId;
                    private int dicProvinceId;
                    private String district;
                    private int id;
                    private int leftAreaRange;
                    private String province;
                    private String storageName;

                    public String getAddress() {
                        return address;
                    }

                    public void setAddress(String address) {
                        this.address = address;
                    }

                    public int getAreaRange() {
                        return areaRange;
                    }

                    public void setAreaRange(int areaRange) {
                        this.areaRange = areaRange;
                    }

                    public String getCity() {
                        return city;
                    }

                    public void setCity(String city) {
                        this.city = city;
                    }

                    public String getContacterName() {
                        return contacterName;
                    }

                    public void setContacterName(String contacterName) {
                        this.contacterName = contacterName;
                    }

                    public String getContacterPhone() {
                        return contacterPhone;
                    }

                    public void setContacterPhone(String contacterPhone) {
                        this.contacterPhone = contacterPhone;
                    }

                    public String getCreateTime() {
                        return createTime;
                    }

                    public void setCreateTime(String createTime) {
                        this.createTime = createTime;
                    }

                    public int getDicCityId() {
                        return dicCityId;
                    }

                    public void setDicCityId(int dicCityId) {
                        this.dicCityId = dicCityId;
                    }

                    public int getDicDdistrictId() {
                        return dicDdistrictId;
                    }

                    public void setDicDdistrictId(int dicDdistrictId) {
                        this.dicDdistrictId = dicDdistrictId;
                    }

                    public int getDicProvinceId() {
                        return dicProvinceId;
                    }

                    public void setDicProvinceId(int dicProvinceId) {
                        this.dicProvinceId = dicProvinceId;
                    }

                    public String getDistrict() {
                        return district;
                    }

                    public void setDistrict(String district) {
                        this.district = district;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public int getLeftAreaRange() {
                        return leftAreaRange;
                    }

                    public void setLeftAreaRange(int leftAreaRange) {
                        this.leftAreaRange = leftAreaRange;
                    }

                    public String getProvince() {
                        return province;
                    }

                    public void setProvince(String province) {
                        this.province = province;
                    }

                    public String getStorageName() {
                        return storageName;
                    }

                    public void setStorageName(String storageName) {
                        this.storageName = storageName;
                    }
                }
            }

            public static class DriverVoBean {
                /**
                 * createTime : 2018-01-04 10:43:22
                 * driverName : 三菱司机
                 * driverPhone : 18782966666
                 * driverStatus : 1
                 * driverStatusDisplay : 配送中
                 * id : 13
                 * remark :
                 * storageId : 2
                 * storageVo : {"address":"西航港通关路69号","areaRange":8000,"city":"成都市","contacterName":"田总","contacterPhone":"18267049870","createTime":"2017-11-15 10:59:55","dicCityId":6820,"dicDdistrictId":6831,"dicProvinceId":6819,"district":"双流区","id":2,"leftAreaRange":5000,"province":"四川省","storageName":"田总的新中伟业仓库"}
                 */

                private String createTime;
                private String driverName;
                private String driverPhone;
                private int driverStatus;
                private String driverStatusDisplay;
                private int id;
                private String remark;
                private int storageId;
                private StorageVoBeanX storageVo;

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

                public int getStorageId() {
                    return storageId;
                }

                public void setStorageId(int storageId) {
                    this.storageId = storageId;
                }

                public StorageVoBeanX getStorageVo() {
                    return storageVo;
                }

                public void setStorageVo(StorageVoBeanX storageVo) {
                    this.storageVo = storageVo;
                }

                public static class StorageVoBeanX {
                    /**
                     * address : 西航港通关路69号
                     * areaRange : 8000
                     * city : 成都市
                     * contacterName : 田总
                     * contacterPhone : 18267049870
                     * createTime : 2017-11-15 10:59:55
                     * dicCityId : 6820
                     * dicDdistrictId : 6831
                     * dicProvinceId : 6819
                     * district : 双流区
                     * id : 2
                     * leftAreaRange : 5000
                     * province : 四川省
                     * storageName : 田总的新中伟业仓库
                     */

                    private String address;
                    private int areaRange;
                    private String city;
                    private String contacterName;
                    private String contacterPhone;
                    private String createTime;
                    private int dicCityId;
                    private int dicDdistrictId;
                    private int dicProvinceId;
                    private String district;
                    private int id;
                    private int leftAreaRange;
                    private String province;
                    private String storageName;

                    public String getAddress() {
                        return address;
                    }

                    public void setAddress(String address) {
                        this.address = address;
                    }

                    public int getAreaRange() {
                        return areaRange;
                    }

                    public void setAreaRange(int areaRange) {
                        this.areaRange = areaRange;
                    }

                    public String getCity() {
                        return city;
                    }

                    public void setCity(String city) {
                        this.city = city;
                    }

                    public String getContacterName() {
                        return contacterName;
                    }

                    public void setContacterName(String contacterName) {
                        this.contacterName = contacterName;
                    }

                    public String getContacterPhone() {
                        return contacterPhone;
                    }

                    public void setContacterPhone(String contacterPhone) {
                        this.contacterPhone = contacterPhone;
                    }

                    public String getCreateTime() {
                        return createTime;
                    }

                    public void setCreateTime(String createTime) {
                        this.createTime = createTime;
                    }

                    public int getDicCityId() {
                        return dicCityId;
                    }

                    public void setDicCityId(int dicCityId) {
                        this.dicCityId = dicCityId;
                    }

                    public int getDicDdistrictId() {
                        return dicDdistrictId;
                    }

                    public void setDicDdistrictId(int dicDdistrictId) {
                        this.dicDdistrictId = dicDdistrictId;
                    }

                    public int getDicProvinceId() {
                        return dicProvinceId;
                    }

                    public void setDicProvinceId(int dicProvinceId) {
                        this.dicProvinceId = dicProvinceId;
                    }

                    public String getDistrict() {
                        return district;
                    }

                    public void setDistrict(String district) {
                        this.district = district;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public int getLeftAreaRange() {
                        return leftAreaRange;
                    }

                    public void setLeftAreaRange(int leftAreaRange) {
                        this.leftAreaRange = leftAreaRange;
                    }

                    public String getProvince() {
                        return province;
                    }

                    public void setProvince(String province) {
                        this.province = province;
                    }

                    public String getStorageName() {
                        return storageName;
                    }

                    public void setStorageName(String storageName) {
                        this.storageName = storageName;
                    }
                }
            }

            public static class StockistVoBean {
                /**
                 * address : 双流区大件路文星段6号
                 * contactName : 路人甲
                 * createTime : 2017-11-15 11:04:49
                 * dealerNum : 6
                 * displayStockistType : 签单
                 * displayTypes : 酒吧
                 * id : 10
                 * latPoint : 30.32340
                 * lngPoint : 104.34320
                 * phone : 13111111111
                 * shopName : 路人甲的零售店
                 * stockistType : 38931
                 * types : 37763
                 */

                private String address;
                private String contactName;
                private String createTime;
                private int dealerNum;
                private String displayStockistType;
                private String displayTypes;
                private int id;
                private String latPoint;
                private String lngPoint;
                private String phone;
                private String shopName;
                private String stockistType;
                private String types;

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

                public String getDisplayStockistType() {
                    return displayStockistType;
                }

                public void setDisplayStockistType(String displayStockistType) {
                    this.displayStockistType = displayStockistType;
                }

                public String getDisplayTypes() {
                    return displayTypes;
                }

                public void setDisplayTypes(String displayTypes) {
                    this.displayTypes = displayTypes;
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

                public String getStockistType() {
                    return stockistType;
                }

                public void setStockistType(String stockistType) {
                    this.stockistType = stockistType;
                }

                public String getTypes() {
                    return types;
                }

                public void setTypes(String types) {
                    this.types = types;
                }
            }
        }

        public static class CatalogueVoListBean {
            /**
             * ReclaimCatalogueId : 1
             * price : 0.0
             * verifyNums : 3
             */

            private int ReclaimCatalogueId;
            private double price;
            private int reclaimNums;
            private int childReclaimNums;
            private String name1;
            private String name2;
            private String unit;
            private String subUnit;
            private int spec;
            private String viewSpec;

            public String getViewSpec() {
                return viewSpec;
            }

            public void setViewSpec(String viewSpec) {
                this.viewSpec = viewSpec;
            }

            public int getSpec() {
                return spec;
            }

            public void setSpec(int spec) {
                this.spec = spec;
            }

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }

            public String getSubUnit() {
                return subUnit;
            }

            public void setSubUnit(String subUnit) {
                this.subUnit = subUnit;
            }

            public String getName1() {
                return name1;
            }

            public void setName1(String name1) {
                this.name1 = name1;
            }

            public String getName2() {
                return name2;
            }

            public void setName2(String name2) {
                this.name2 = name2;
            }

            public int getReclaimCatalogueId() {
                return ReclaimCatalogueId;
            }

            public void setReclaimCatalogueId(int ReclaimCatalogueId) {
                this.ReclaimCatalogueId = ReclaimCatalogueId;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public int getReclaimNums(){
                return reclaimNums;
            }

            public void setReclaimNums(int reclaimNums) {
                this.reclaimNums = reclaimNums;
            }
            public int getChildReclaimNums() {
                return childReclaimNums;
            }

            public void setChildReclaimNums(int childReclaimNums) {
                this.childReclaimNums = childReclaimNums;
            }
        }

        public static class GoodsOrderVoListBean {
            /**
             * applyAmount : 23
             * areaName : XCW区
             * attribute : 100
             * awardAmount : 3
             * awardCash : 0.0
             * categoryVo : {"areaName":"XCW区","attribute":100,"childUnit":"包","createTime":"2017-11-15 13:54:43","goodsCategoryName":"牛板筋","goodsName":"牛板筋1号","guidePrice":2,"id":29,"isPublic":1,"storageAreaId":61,"storageId":2,"storageName":"田总的新中伟业仓库","unit":"件","visualAttribute":"12X500ml"}
             * childApplyAmount : 2
             * childAwardAmount : 0
             * childDeliverAmount : 2
             * childGoodsActualGetNums : 0
             * childGoodsReturnNums : 0
             * deliverAmount : 26
             * goodsActualGetNums : 0
             * goodsActualPrice : 11510.0
             * goodsApplyPrice : 11510.0
             * goodsName : 牛板筋1号
             * goodsReturnNums : 0
             * id : 647
             * orderNumber : B2017122114253596364
             * price : 5.0
             * saleGoodsId : 41
             * storageAreaId : 61
             * storageId : 2
             * storageName : 田总的新中伟业仓库
             * storageNums : 2104
             * nickName : xcxcs
             */

            private int applyAmount;
            private String areaName;
            private int attribute;
            private int awardAmount;
            private double awardCash;
            private CategoryVoBean categoryVo;
            private int childApplyAmount;
            private int childAwardAmount;
            private int childDeliverAmount;
            private int childGoodsActualGetNums;
            private int childGoodsReturnNums;
            private int deliverAmount;
            private int goodsActualGetNums;
            private double goodsActualPrice;
            private double goodsApplyPrice;
            private String goodsName;
            private int goodsReturnNums;
            private int id;
            private String orderNumber;
            private double price;
            private int saleGoodsId;
            private int storageAreaId;
            private int storageId;
            private String storageName;
            private int storageNums;
            private String nickName;

            public int getApplyAmount() {
                return applyAmount;
            }

            public void setApplyAmount(int applyAmount) {
                this.applyAmount = applyAmount;
            }

            public String getAreaName() {
                return areaName;
            }

            public void setAreaName(String areaName) {
                this.areaName = areaName;
            }

            public int getAttribute() {
                return attribute;
            }

            public void setAttribute(int attribute) {
                this.attribute = attribute;
            }

            public int getAwardAmount() {
                return awardAmount;
            }

            public void setAwardAmount(int awardAmount) {
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

            public int getChildApplyAmount() {
                return childApplyAmount;
            }

            public void setChildApplyAmount(int childApplyAmount) {
                this.childApplyAmount = childApplyAmount;
            }

            public int getChildAwardAmount() {
                return childAwardAmount;
            }

            public void setChildAwardAmount(int childAwardAmount) {
                this.childAwardAmount = childAwardAmount;
            }

            public int getChildDeliverAmount() {
                return childDeliverAmount;
            }

            public void setChildDeliverAmount(int childDeliverAmount) {
                this.childDeliverAmount = childDeliverAmount;
            }

            public int getChildGoodsActualGetNums() {
                return childGoodsActualGetNums;
            }

            public void setChildGoodsActualGetNums(int childGoodsActualGetNums) {
                this.childGoodsActualGetNums = childGoodsActualGetNums;
            }

            public int getChildGoodsReturnNums() {
                return childGoodsReturnNums;
            }

            public void setChildGoodsReturnNums(int childGoodsReturnNums) {
                this.childGoodsReturnNums = childGoodsReturnNums;
            }

            public int getDeliverAmount() {
                return deliverAmount;
            }

            public void setDeliverAmount(int deliverAmount) {
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

            public String getGoodsName() {
                return goodsName;
            }

            public void setGoodsName(String goodsName) {
                this.goodsName = goodsName;
            }

            public int getGoodsReturnNums() {
                return goodsReturnNums;
            }

            public void setGoodsReturnNums(int goodsReturnNums) {
                this.goodsReturnNums = goodsReturnNums;
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

            public String getStorageName() {
                return storageName;
            }

            public void setStorageName(String storageName) {
                this.storageName = storageName;
            }

            public int getStorageNums() {
                return storageNums;
            }

            public void setStorageNums(int storageNums) {
                this.storageNums = storageNums;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public static class CategoryVoBean {
                /**
                 * areaName : XCW区
                 * attribute : 100
                 * childUnit : 包
                 * createTime : 2017-11-15 13:54:43
                 * goodsCategoryName : 牛板筋
                 * goodsName : 牛板筋1号
                 * guidePrice : 2.0
                 * id : 29
                 * isPublic : 1
                 * storageAreaId : 61
                 * storageId : 2
                 * storageName : 田总的新中伟业仓库
                 * unit : 件
                 * visualAttribute : 12X500ml
                 */

                private String areaName;
                private int attribute;
                private String childUnit;
                private String createTime;
                private String goodsCategoryName;
                private String goodsName;
                private double guidePrice;
                private int id;
                private int isPublic;
                private int storageAreaId;
                private int storageId;
                private String storageName;
                private String unit;
                private String visualAttribute;

                public String getAreaName() {
                    return areaName;
                }

                public void setAreaName(String areaName) {
                    this.areaName = areaName;
                }

                public int getAttribute() {
                    return attribute;
                }

                public void setAttribute(int attribute) {
                    this.attribute = attribute;
                }

                public String getChildUnit() {
                    return childUnit;
                }

                public void setChildUnit(String childUnit) {
                    this.childUnit = childUnit;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public String getGoodsCategoryName() {
                    return goodsCategoryName;
                }

                public void setGoodsCategoryName(String goodsCategoryName) {
                    this.goodsCategoryName = goodsCategoryName;
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

                public String getStorageName() {
                    return storageName;
                }

                public void setStorageName(String storageName) {
                    this.storageName = storageName;
                }

                public String getUnit() {
                    return unit;
                }

                public void setUnit(String unit) {
                    this.unit = unit;
                }

                public String getVisualAttribute() {
                    return visualAttribute;
                }

                public void setVisualAttribute(String visualAttribute) {
                    this.visualAttribute = visualAttribute;
                }
            }
        }
    }
}

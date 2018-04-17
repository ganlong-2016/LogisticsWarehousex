package com.drkj.logisticswarehouse.bean;

/**
 * Created by ganlong on 2017/10/12.
 */

import java.util.List;

/**
 * 订单信息
 */
public class OrderBean {

    /**
     * 订单序号
     */
    private int serialNumber;

    /**
     * 经度
     */
    private  double latitude;

    /**
     * 纬度
     */
    private  double longitude;
    /**
     * 城市
     */
    private String city;
    /**
     * 地址
     */
    private String address;
    /**
     * 订单号
     */
    private String orderNumber;
    /**
     * 客户名称
     */
    private String clientName;

    /**
     * 数量
     */
    private int count;

    /**
     * 单价
     */
    private float unitPrice;
    /**
     * 货款金额
     */
    private float totalPrice;

    /**
     * 收货时间(12点之前/18点之前/18点之后/不限)
     */
    private String receiptTime;

    /**
     * 是否回瓶(是/否)
     */
    private boolean isRecovery;

    /**
     * 赠送数量
     */
    private int giveNumber;

    /**
     * 销售返点金额
     */
    private float salesRebateAmount;

    /**
     * 应配送数量
     */
    private int deliveryQuantity;

    /**
     * 应收货款
     */
    private float receivables;

    /**
     * 代收货款(是/否)
     */
    private boolean isCollectionPayment;

    /**
     * 回瓶数量
     */
    private int returnedNumber;

    /**
     * 单价(回瓶)
     */
    private float bottleUnitPrice;
    /**
     * 回瓶可抵扣金额
     */
    private float returnedBottleDeductible;

    /**
     * 瓶盖数量
     */
    private int bottleCapQuantity;

    /**
     * 单价(瓶盖)
     */
    private float bottleCapUnitPrice;

    /**
     *瓶盖可抵扣金额
     */
    private float returnedBottleCapDeductible;

    /**
     * 塑箱数量
     */
    private int plasticBoxQuantity;

    /**
     * 塑箱单价
     */
    private float plasticBoxUnitPrice;

    /**
     * 塑箱可抵扣金额
     */
    private float returnedplasticBoxDeductible;
    /**
     * 抵扣后应收取货款
     */
    private float afterDeductionPayment;

    /**
     * 实际收取货款
     */
    private float actualPayment;

    /**
     * 差异
     */
    private float difference;

    /**
     * 结单状态
     */
    private String orderState;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 商品种类
     */
    private List<GoodsDetail> GoodsDetails;

    public List<GoodsDetail> getGoodsDetails() {
        return GoodsDetails;
    }

    public void setGoodsDetails(List<GoodsDetail> goodsDetails) {
        GoodsDetails = goodsDetails;
    }

    public OrderBean(){}

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getReceiptTime() {
        return receiptTime;
    }

    public void setReceiptTime(String receiptTime) {
        this.receiptTime = receiptTime;
    }

    public boolean isRecovery() {
        return isRecovery;
    }

    public void setRecovery(boolean recovery) {
        isRecovery = recovery;
    }

    public int getGiveNumber() {
        return giveNumber;
    }

    public void setGiveNumber(int giveNumber) {
        this.giveNumber = giveNumber;
    }

    public float getSalesRebateAmount() {
        return salesRebateAmount;
    }

    public void setSalesRebateAmount(float salesRebateAmount) {
        this.salesRebateAmount = salesRebateAmount;
    }

    public int getDeliveryQuantity() {
        return deliveryQuantity;
    }

    public void setDeliveryQuantity(int deliveryQuantity) {
        this.deliveryQuantity = deliveryQuantity;
    }

    public float getReceivables() {
        return receivables;
    }

    public void setReceivables(float receivables) {
        this.receivables = receivables;
    }

    public boolean isCollectionPayment() {
        return isCollectionPayment;
    }

    public void setCollectionPayment(boolean collectionPayment) {
        isCollectionPayment = collectionPayment;
    }

    public int getReturnedNumber() {
        return returnedNumber;
    }

    public void setReturnedNumber(int returnedNumber) {
        this.returnedNumber = returnedNumber;
    }

    public float getBottleUnitPrice() {
        return bottleUnitPrice;
    }

    public void setBottleUnitPrice(float bottleUnitPrice) {
        this.bottleUnitPrice = bottleUnitPrice;
    }

    public float getReturnedBottleDeductible() {
        return returnedBottleDeductible;
    }

    public void setReturnedBottleDeductible(float returnedBottleDeductible) {
        this.returnedBottleDeductible = returnedBottleDeductible;
    }

    public int getBottleCapQuantity() {
        return bottleCapQuantity;
    }

    public void setBottleCapQuantity(int bottleCapQuantity) {
        this.bottleCapQuantity = bottleCapQuantity;
    }

    public float getBottleCapUnitPrice() {
        return bottleCapUnitPrice;
    }

    public void setBottleCapUnitPrice(float bottleCapUnitPrice) {
        this.bottleCapUnitPrice = bottleCapUnitPrice;
    }

    public float getReturnedBottleCapDeductible() {
        return returnedBottleCapDeductible;
    }

    public void setReturnedBottleCapDeductible(float returnedBottleCapDeductible) {
        this.returnedBottleCapDeductible = returnedBottleCapDeductible;
    }

    public float getAfterDeductionPayment() {
        return afterDeductionPayment;
    }

    public void setAfterDeductionPayment(float afterDeductionPayment) {
        this.afterDeductionPayment = afterDeductionPayment;
    }

    public float getActualPayment() {
        return actualPayment;
    }

    public void setActualPayment(float actualPayment) {
        this.actualPayment = actualPayment;
    }

    public float getDifference() {
        return difference;
    }

    public void setDifference(float difference) {
        this.difference = difference;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getPlasticBoxQuantity() {
        return plasticBoxQuantity;
    }

    public void setPlasticBoxQuantity(int plasticBoxQuantity) {
        this.plasticBoxQuantity = plasticBoxQuantity;
    }

    public float getPlasticBoxUnitPrice() {
        return plasticBoxUnitPrice;
    }

    public void setPlasticBoxUnitPrice(float plasticBoxUnitPrice) {
        this.plasticBoxUnitPrice = plasticBoxUnitPrice;
    }

    public float getReturnedplasticBoxDeductible() {
        return returnedplasticBoxDeductible;
    }

    public void setReturnedplasticBoxDeductible(float returnedplasticBoxDeductible) {
        this.returnedplasticBoxDeductible = returnedplasticBoxDeductible;
    }

    public static class GoodsDetail{
        private GoodsBean goodsBean;
        private int quantitys;
        private int returnQuantitys;
        private int actualQuantitys;

        public int getActualQuantitys() {
            return actualQuantitys;
        }

        public void setActualQuantitys(int actualQuantitys) {
            this.actualQuantitys = actualQuantitys;
        }

        public GoodsBean getGoodsBean() {
            return goodsBean;
        }

        public void setGoodsBean(GoodsBean goodsBean) {
            this.goodsBean = goodsBean;
        }

        public int getQuantitys() {
            return quantitys;
        }

        public void setQuantitys(int quantitys) {
            this.quantitys = quantitys;
        }

        public int getReturnQuantitys() {
            return returnQuantitys;
        }

        public void setReturnQuantitys(int returnQuantitys) {
            this.returnQuantitys = returnQuantitys;
        }
    }
}

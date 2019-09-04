package com.hndl.cn.dao.shop.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * shop_order_info
 * @author 
 */
public class ShopOrderInfoDo implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 是否被删除
     */
    private String isDeleted;

    /**
     * 创建人 (谁评论的)
     */
    private String createOperator;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建时间的毫秒值
     */
    private String createTimeLong;

    /**
     * 最后更新人
     */
    private String lastOperator;

    /**
     * 最后更新时间
     */
    private Date lastModifyTime;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 图片id
     */
    private Long itemId;

    /**
     * 这比订单单次购买这个商品的次数
     */
    private Integer buyCount;

    /**
     * 购买支付方式(芒果币、芒果豆、第三方支付)（db存dou/coin/thridPay）
     */
    private String payType;

    /**
     * 这次买了多少量的价格
     */
    private Double payCount;

    /**
     * 是否全额购买的
     */
    private String isAllBuy;

    /**
     * 这批订单是否中奖（开奖得到幸运号后，去shop_order_lucky_no查，可以得到哪个订单id中奖）
     */
    private String isTarget;

    /**
     * 购买者的当时的ip地址
     */
    private String ip;

    /**
     * ip地址属于哪里省市
     */
    private String ipAddress;

    /**
     * 给用户看的订单号，生成规则：年月日时分秒六位随机数（本表的id才是内置关联其他表的订单编号）
     */
    private String outOrderId;

    /**
     * 用户第三方支付成功后，回调我方错误了，我方先退回金币，这个字段应该变为y,如果为y，就作废了这条订单记录
     */
    private String isBackCoin;

    /**
     * 回调的时候更新
     */
    private String outTradeId;

    /**
     * 回调的时候更新
     */
    private String outTradeStatus;

    /**
     * )微信或者支付宝(alipay/weixinpay)下单的时候插入
     */
    private String outTradeType;

    /**
     * 中奖短信通知，通知了为y 未通知为n
     */
    private String isWinningNoticed;

    /**
     * 发货是否短信通知，通知了为y 未通知为n
     */
    private String isSendedNotice;

    /**
     * 购买的幸运号开始值
     */
    private String startLuckNumber;

    /**
     * 购买的幸运号结束
     */
    private String endLuckNumber;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCreateOperator() {
        return createOperator;
    }

    public void setCreateOperator(String createOperator) {
        this.createOperator = createOperator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateTimeLong() {
        return createTimeLong;
    }

    public void setCreateTimeLong(String createTimeLong) {
        this.createTimeLong = createTimeLong;
    }

    public String getLastOperator() {
        return lastOperator;
    }

    public void setLastOperator(String lastOperator) {
        this.lastOperator = lastOperator;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public Double getPayCount() {
        return payCount;
    }

    public void setPayCount(Double payCount) {
        this.payCount = payCount;
    }

    public String getIsAllBuy() {
        return isAllBuy;
    }

    public void setIsAllBuy(String isAllBuy) {
        this.isAllBuy = isAllBuy;
    }

    public String getIsTarget() {
        return isTarget;
    }

    public void setIsTarget(String isTarget) {
        this.isTarget = isTarget;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getOutOrderId() {
        return outOrderId;
    }

    public void setOutOrderId(String outOrderId) {
        this.outOrderId = outOrderId;
    }

    public String getIsBackCoin() {
        return isBackCoin;
    }

    public void setIsBackCoin(String isBackCoin) {
        this.isBackCoin = isBackCoin;
    }

    public String getOutTradeId() {
        return outTradeId;
    }

    public void setOutTradeId(String outTradeId) {
        this.outTradeId = outTradeId;
    }

    public String getOutTradeStatus() {
        return outTradeStatus;
    }

    public void setOutTradeStatus(String outTradeStatus) {
        this.outTradeStatus = outTradeStatus;
    }

    public String getOutTradeType() {
        return outTradeType;
    }

    public void setOutTradeType(String outTradeType) {
        this.outTradeType = outTradeType;
    }

    public String getIsWinningNoticed() {
        return isWinningNoticed;
    }

    public void setIsWinningNoticed(String isWinningNoticed) {
        this.isWinningNoticed = isWinningNoticed;
    }

    public String getIsSendedNotice() {
        return isSendedNotice;
    }

    public void setIsSendedNotice(String isSendedNotice) {
        this.isSendedNotice = isSendedNotice;
    }

    public String getStartLuckNumber() {
        return startLuckNumber;
    }

    public void setStartLuckNumber(String startLuckNumber) {
        this.startLuckNumber = startLuckNumber;
    }

    public String getEndLuckNumber() {
        return endLuckNumber;
    }

    public void setEndLuckNumber(String endLuckNumber) {
        this.endLuckNumber = endLuckNumber;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ShopOrderInfoDo other = (ShopOrderInfoDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateTimeLong() == null ? other.getCreateTimeLong() == null : this.getCreateTimeLong().equals(other.getCreateTimeLong()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()))
            && (this.getBuyCount() == null ? other.getBuyCount() == null : this.getBuyCount().equals(other.getBuyCount()))
            && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
            && (this.getPayCount() == null ? other.getPayCount() == null : this.getPayCount().equals(other.getPayCount()))
            && (this.getIsAllBuy() == null ? other.getIsAllBuy() == null : this.getIsAllBuy().equals(other.getIsAllBuy()))
            && (this.getIsTarget() == null ? other.getIsTarget() == null : this.getIsTarget().equals(other.getIsTarget()))
            && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
            && (this.getIpAddress() == null ? other.getIpAddress() == null : this.getIpAddress().equals(other.getIpAddress()))
            && (this.getOutOrderId() == null ? other.getOutOrderId() == null : this.getOutOrderId().equals(other.getOutOrderId()))
            && (this.getIsBackCoin() == null ? other.getIsBackCoin() == null : this.getIsBackCoin().equals(other.getIsBackCoin()))
            && (this.getOutTradeId() == null ? other.getOutTradeId() == null : this.getOutTradeId().equals(other.getOutTradeId()))
            && (this.getOutTradeStatus() == null ? other.getOutTradeStatus() == null : this.getOutTradeStatus().equals(other.getOutTradeStatus()))
            && (this.getOutTradeType() == null ? other.getOutTradeType() == null : this.getOutTradeType().equals(other.getOutTradeType()))
            && (this.getIsWinningNoticed() == null ? other.getIsWinningNoticed() == null : this.getIsWinningNoticed().equals(other.getIsWinningNoticed()))
            && (this.getIsSendedNotice() == null ? other.getIsSendedNotice() == null : this.getIsSendedNotice().equals(other.getIsSendedNotice()))
            && (this.getStartLuckNumber() == null ? other.getStartLuckNumber() == null : this.getStartLuckNumber().equals(other.getStartLuckNumber()))
            && (this.getEndLuckNumber() == null ? other.getEndLuckNumber() == null : this.getEndLuckNumber().equals(other.getEndLuckNumber()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        result = prime * result + ((getCreateOperator() == null) ? 0 : getCreateOperator().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateTimeLong() == null) ? 0 : getCreateTimeLong().hashCode());
        result = prime * result + ((getLastOperator() == null) ? 0 : getLastOperator().hashCode());
        result = prime * result + ((getLastModifyTime() == null) ? 0 : getLastModifyTime().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        result = prime * result + ((getBuyCount() == null) ? 0 : getBuyCount().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        result = prime * result + ((getPayCount() == null) ? 0 : getPayCount().hashCode());
        result = prime * result + ((getIsAllBuy() == null) ? 0 : getIsAllBuy().hashCode());
        result = prime * result + ((getIsTarget() == null) ? 0 : getIsTarget().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getIpAddress() == null) ? 0 : getIpAddress().hashCode());
        result = prime * result + ((getOutOrderId() == null) ? 0 : getOutOrderId().hashCode());
        result = prime * result + ((getIsBackCoin() == null) ? 0 : getIsBackCoin().hashCode());
        result = prime * result + ((getOutTradeId() == null) ? 0 : getOutTradeId().hashCode());
        result = prime * result + ((getOutTradeStatus() == null) ? 0 : getOutTradeStatus().hashCode());
        result = prime * result + ((getOutTradeType() == null) ? 0 : getOutTradeType().hashCode());
        result = prime * result + ((getIsWinningNoticed() == null) ? 0 : getIsWinningNoticed().hashCode());
        result = prime * result + ((getIsSendedNotice() == null) ? 0 : getIsSendedNotice().hashCode());
        result = prime * result + ((getStartLuckNumber() == null) ? 0 : getStartLuckNumber().hashCode());
        result = prime * result + ((getEndLuckNumber() == null) ? 0 : getEndLuckNumber().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", createOperator=").append(createOperator);
        sb.append(", createTime=").append(createTime);
        sb.append(", createTimeLong=").append(createTimeLong);
        sb.append(", lastOperator=").append(lastOperator);
        sb.append(", lastModifyTime=").append(lastModifyTime);
        sb.append(", userId=").append(userId);
        sb.append(", itemId=").append(itemId);
        sb.append(", buyCount=").append(buyCount);
        sb.append(", payType=").append(payType);
        sb.append(", payCount=").append(payCount);
        sb.append(", isAllBuy=").append(isAllBuy);
        sb.append(", isTarget=").append(isTarget);
        sb.append(", ip=").append(ip);
        sb.append(", ipAddress=").append(ipAddress);
        sb.append(", outOrderId=").append(outOrderId);
        sb.append(", isBackCoin=").append(isBackCoin);
        sb.append(", outTradeId=").append(outTradeId);
        sb.append(", outTradeStatus=").append(outTradeStatus);
        sb.append(", outTradeType=").append(outTradeType);
        sb.append(", isWinningNoticed=").append(isWinningNoticed);
        sb.append(", isSendedNotice=").append(isSendedNotice);
        sb.append(", startLuckNumber=").append(startLuckNumber);
        sb.append(", endLuckNumber=").append(endLuckNumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
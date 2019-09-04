package com.hndl.cn.dao.coin.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * happy_coin_bill_info 快乐币流水记录表
 * @author 
 */
public class HappyCoinBillInfoDo implements Serializable {
    /**
     * 数据库主键
     */
    private Integer id;

    /**
     * 是否支出 0 收入 1 支出
     */
    private Integer isPay;

    /**
     * 对应的是充值通道,如果是支出，那么就应该是系统消费PayChannelEnums.
     */
    private Integer payType;

    /**
     * 单位为分
     */
    private Long coinCount;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 本地订单id
     */
    private Long localTradeNo;

    /**
     * 第三方充值订单
     */
    private String remoteTradeNo;

    /**
     * 交易前的余额
     */
    private Long oldCoinCount;

    /**
     * 交易后的余额
     */
    private Long newCoinCount;

    /**
     * 创建用户id
     */
    private Long createUserId;

    /**
     * 消费的具体类型
     */
    private Integer reasonType;

    /**
     * 绑定id
     */
    private String reasonObjId;

    /**
     * 拓展字段1
     */
    private String expand1;

    /**
     * 拓展字段2
     */
    private String expand2;

    /**
     * 是否删除
     */
    private Integer isDelete;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsPay() {
        return isPay;
    }

    public void setIsPay(Integer isPay) {
        this.isPay = isPay;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Long getCoinCount() {
        return coinCount;
    }

    public void setCoinCount(Long coinCount) {
        this.coinCount = coinCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getLocalTradeNo() {
        return localTradeNo;
    }

    public void setLocalTradeNo(Long localTradeNo) {
        this.localTradeNo = localTradeNo;
    }

    public String getRemoteTradeNo() {
        return remoteTradeNo;
    }

    public void setRemoteTradeNo(String remoteTradeNo) {
        this.remoteTradeNo = remoteTradeNo;
    }

    public Long getOldCoinCount() {
        return oldCoinCount;
    }

    public void setOldCoinCount(Long oldCoinCount) {
        this.oldCoinCount = oldCoinCount;
    }

    public Long getNewCoinCount() {
        return newCoinCount;
    }

    public void setNewCoinCount(Long newCoinCount) {
        this.newCoinCount = newCoinCount;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getReasonType() {
        return reasonType;
    }

    public void setReasonType(Integer reasonType) {
        this.reasonType = reasonType;
    }

    public String getReasonObjId() {
        return reasonObjId;
    }

    public void setReasonObjId(String reasonObjId) {
        this.reasonObjId = reasonObjId;
    }

    public String getExpand1() {
        return expand1;
    }

    public void setExpand1(String expand1) {
        this.expand1 = expand1;
    }

    public String getExpand2() {
        return expand2;
    }

    public void setExpand2(String expand2) {
        this.expand2 = expand2;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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
        HappyCoinBillInfoDo other = (HappyCoinBillInfoDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsPay() == null ? other.getIsPay() == null : this.getIsPay().equals(other.getIsPay()))
            && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
            && (this.getCoinCount() == null ? other.getCoinCount() == null : this.getCoinCount().equals(other.getCoinCount()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLocalTradeNo() == null ? other.getLocalTradeNo() == null : this.getLocalTradeNo().equals(other.getLocalTradeNo()))
            && (this.getRemoteTradeNo() == null ? other.getRemoteTradeNo() == null : this.getRemoteTradeNo().equals(other.getRemoteTradeNo()))
            && (this.getOldCoinCount() == null ? other.getOldCoinCount() == null : this.getOldCoinCount().equals(other.getOldCoinCount()))
            && (this.getNewCoinCount() == null ? other.getNewCoinCount() == null : this.getNewCoinCount().equals(other.getNewCoinCount()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getReasonType() == null ? other.getReasonType() == null : this.getReasonType().equals(other.getReasonType()))
            && (this.getReasonObjId() == null ? other.getReasonObjId() == null : this.getReasonObjId().equals(other.getReasonObjId()))
            && (this.getExpand1() == null ? other.getExpand1() == null : this.getExpand1().equals(other.getExpand1()))
            && (this.getExpand2() == null ? other.getExpand2() == null : this.getExpand2().equals(other.getExpand2()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIsPay() == null) ? 0 : getIsPay().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        result = prime * result + ((getCoinCount() == null) ? 0 : getCoinCount().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLocalTradeNo() == null) ? 0 : getLocalTradeNo().hashCode());
        result = prime * result + ((getRemoteTradeNo() == null) ? 0 : getRemoteTradeNo().hashCode());
        result = prime * result + ((getOldCoinCount() == null) ? 0 : getOldCoinCount().hashCode());
        result = prime * result + ((getNewCoinCount() == null) ? 0 : getNewCoinCount().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getReasonType() == null) ? 0 : getReasonType().hashCode());
        result = prime * result + ((getReasonObjId() == null) ? 0 : getReasonObjId().hashCode());
        result = prime * result + ((getExpand1() == null) ? 0 : getExpand1().hashCode());
        result = prime * result + ((getExpand2() == null) ? 0 : getExpand2().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", isPay=").append(isPay);
        sb.append(", payType=").append(payType);
        sb.append(", coinCount=").append(coinCount);
        sb.append(", createTime=").append(createTime);
        sb.append(", localTradeNo=").append(localTradeNo);
        sb.append(", remoteTradeNo=").append(remoteTradeNo);
        sb.append(", oldCoinCount=").append(oldCoinCount);
        sb.append(", newCoinCount=").append(newCoinCount);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", reasonType=").append(reasonType);
        sb.append(", reasonObjId=").append(reasonObjId);
        sb.append(", expand1=").append(expand1);
        sb.append(", expand2=").append(expand2);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
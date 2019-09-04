package com.hndl.cn.dao.pay.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * pay_sys_trade
 * @author 
 */
public class PaySysTradeDo implements Serializable {
    /**
     * 数据库主键
     */
    private Integer id;

    /**
     * 支付管道
     */
    private Integer payChannel;

    /**
     * 本地系统订单id
     */
    private Long localTradeNo;

    /**
     * 第三方交易id
     */
    private String remoteTradeNo;

    /**
     * 交易创建时间
     */
    private Date createTime;

    /**
     * 回调时间
     */
    private Date callbackTime;

    /**
     * 创建用户id
     */
    private Long createUserId;

    /**
     * MD5
     */
    private String sign;

    /**
     * 交易金额（单位为分）
     */
    private Long moneyNumber;

    /**
     * 支付状态
     */
    private Integer payState;

    /**
     * 拓展字段1
     */
    private String expand1;

    /**
     * 拓展字段2
     */
    private String expand2;

    /**
     * 拓展字段3
     */
    private String expand3;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(Integer payChannel) {
        this.payChannel = payChannel;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCallbackTime() {
        return callbackTime;
    }

    public void setCallbackTime(Date callbackTime) {
        this.callbackTime = callbackTime;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Long getMoneyNumber() {
        return moneyNumber;
    }

    public void setMoneyNumber(Long moneyNumber) {
        this.moneyNumber = moneyNumber;
    }

    public Integer getPayState() {
        return payState;
    }

    public void setPayState(Integer payState) {
        this.payState = payState;
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

    public String getExpand3() {
        return expand3;
    }

    public void setExpand3(String expand3) {
        this.expand3 = expand3;
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
        PaySysTradeDo other = (PaySysTradeDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPayChannel() == null ? other.getPayChannel() == null : this.getPayChannel().equals(other.getPayChannel()))
            && (this.getLocalTradeNo() == null ? other.getLocalTradeNo() == null : this.getLocalTradeNo().equals(other.getLocalTradeNo()))
            && (this.getRemoteTradeNo() == null ? other.getRemoteTradeNo() == null : this.getRemoteTradeNo().equals(other.getRemoteTradeNo()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCallbackTime() == null ? other.getCallbackTime() == null : this.getCallbackTime().equals(other.getCallbackTime()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getSign() == null ? other.getSign() == null : this.getSign().equals(other.getSign()))
            && (this.getMoneyNumber() == null ? other.getMoneyNumber() == null : this.getMoneyNumber().equals(other.getMoneyNumber()))
            && (this.getPayState() == null ? other.getPayState() == null : this.getPayState().equals(other.getPayState()))
            && (this.getExpand1() == null ? other.getExpand1() == null : this.getExpand1().equals(other.getExpand1()))
            && (this.getExpand2() == null ? other.getExpand2() == null : this.getExpand2().equals(other.getExpand2()))
            && (this.getExpand3() == null ? other.getExpand3() == null : this.getExpand3().equals(other.getExpand3()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPayChannel() == null) ? 0 : getPayChannel().hashCode());
        result = prime * result + ((getLocalTradeNo() == null) ? 0 : getLocalTradeNo().hashCode());
        result = prime * result + ((getRemoteTradeNo() == null) ? 0 : getRemoteTradeNo().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCallbackTime() == null) ? 0 : getCallbackTime().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getSign() == null) ? 0 : getSign().hashCode());
        result = prime * result + ((getMoneyNumber() == null) ? 0 : getMoneyNumber().hashCode());
        result = prime * result + ((getPayState() == null) ? 0 : getPayState().hashCode());
        result = prime * result + ((getExpand1() == null) ? 0 : getExpand1().hashCode());
        result = prime * result + ((getExpand2() == null) ? 0 : getExpand2().hashCode());
        result = prime * result + ((getExpand3() == null) ? 0 : getExpand3().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", payChannel=").append(payChannel);
        sb.append(", localTradeNo=").append(localTradeNo);
        sb.append(", remoteTradeNo=").append(remoteTradeNo);
        sb.append(", createTime=").append(createTime);
        sb.append(", callbackTime=").append(callbackTime);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", sign=").append(sign);
        sb.append(", moneyNumber=").append(moneyNumber);
        sb.append(", payState=").append(payState);
        sb.append(", expand1=").append(expand1);
        sb.append(", expand2=").append(expand2);
        sb.append(", expand3=").append(expand3);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
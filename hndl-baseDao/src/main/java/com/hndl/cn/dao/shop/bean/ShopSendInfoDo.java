package com.hndl.cn.dao.shop.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * shop_send_info
 * @author 
 */
public class ShopSendInfoDo implements Serializable {
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
     * 最后更新人
     */
    private String lastOperator;

    /**
     * 最后更新时间
     */
    private Date lastModifyTime;

    /**
     * 游戏记录表Id/夺宝期号
     */
    private Long orderId;

    /**
     * 详细地址
     */
    private String sendAddress;

    /**
     * 手机
     */
    private String sendPhone;

    /**
     * 邮编
     */
    private String sendCode;

    /**
     * 姓名
     */
    private String sendName;

    /**
     * 发货状态（待发货、已发货、已收货）（分别db存：noSend/send/received）
     */
    private String sendStatus;

    /**
     * 发货的快递订单号
     */
    private String sendNo;

    /**
     * 快递公司名称
     */
    private String sendCompany;

    /**
     * 类型：shop/hudong(夺宝、互动)
     */
    private String type;

    /**
     * 用户的id
     */
    private String userId;

    /**
     * 发货时间
     */
    private Date sendTime;

    /**
     * 用户确认收货地址时间
     */
    private Date confrimItemTime;

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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getSendAddress() {
        return sendAddress;
    }

    public void setSendAddress(String sendAddress) {
        this.sendAddress = sendAddress;
    }

    public String getSendPhone() {
        return sendPhone;
    }

    public void setSendPhone(String sendPhone) {
        this.sendPhone = sendPhone;
    }

    public String getSendCode() {
        return sendCode;
    }

    public void setSendCode(String sendCode) {
        this.sendCode = sendCode;
    }

    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    public String getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(String sendStatus) {
        this.sendStatus = sendStatus;
    }

    public String getSendNo() {
        return sendNo;
    }

    public void setSendNo(String sendNo) {
        this.sendNo = sendNo;
    }

    public String getSendCompany() {
        return sendCompany;
    }

    public void setSendCompany(String sendCompany) {
        this.sendCompany = sendCompany;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getConfrimItemTime() {
        return confrimItemTime;
    }

    public void setConfrimItemTime(Date confrimItemTime) {
        this.confrimItemTime = confrimItemTime;
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
        ShopSendInfoDo other = (ShopSendInfoDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getSendAddress() == null ? other.getSendAddress() == null : this.getSendAddress().equals(other.getSendAddress()))
            && (this.getSendPhone() == null ? other.getSendPhone() == null : this.getSendPhone().equals(other.getSendPhone()))
            && (this.getSendCode() == null ? other.getSendCode() == null : this.getSendCode().equals(other.getSendCode()))
            && (this.getSendName() == null ? other.getSendName() == null : this.getSendName().equals(other.getSendName()))
            && (this.getSendStatus() == null ? other.getSendStatus() == null : this.getSendStatus().equals(other.getSendStatus()))
            && (this.getSendNo() == null ? other.getSendNo() == null : this.getSendNo().equals(other.getSendNo()))
            && (this.getSendCompany() == null ? other.getSendCompany() == null : this.getSendCompany().equals(other.getSendCompany()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getSendTime() == null ? other.getSendTime() == null : this.getSendTime().equals(other.getSendTime()))
            && (this.getConfrimItemTime() == null ? other.getConfrimItemTime() == null : this.getConfrimItemTime().equals(other.getConfrimItemTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        result = prime * result + ((getCreateOperator() == null) ? 0 : getCreateOperator().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastOperator() == null) ? 0 : getLastOperator().hashCode());
        result = prime * result + ((getLastModifyTime() == null) ? 0 : getLastModifyTime().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getSendAddress() == null) ? 0 : getSendAddress().hashCode());
        result = prime * result + ((getSendPhone() == null) ? 0 : getSendPhone().hashCode());
        result = prime * result + ((getSendCode() == null) ? 0 : getSendCode().hashCode());
        result = prime * result + ((getSendName() == null) ? 0 : getSendName().hashCode());
        result = prime * result + ((getSendStatus() == null) ? 0 : getSendStatus().hashCode());
        result = prime * result + ((getSendNo() == null) ? 0 : getSendNo().hashCode());
        result = prime * result + ((getSendCompany() == null) ? 0 : getSendCompany().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getSendTime() == null) ? 0 : getSendTime().hashCode());
        result = prime * result + ((getConfrimItemTime() == null) ? 0 : getConfrimItemTime().hashCode());
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
        sb.append(", lastOperator=").append(lastOperator);
        sb.append(", lastModifyTime=").append(lastModifyTime);
        sb.append(", orderId=").append(orderId);
        sb.append(", sendAddress=").append(sendAddress);
        sb.append(", sendPhone=").append(sendPhone);
        sb.append(", sendCode=").append(sendCode);
        sb.append(", sendName=").append(sendName);
        sb.append(", sendStatus=").append(sendStatus);
        sb.append(", sendNo=").append(sendNo);
        sb.append(", sendCompany=").append(sendCompany);
        sb.append(", type=").append(type);
        sb.append(", userId=").append(userId);
        sb.append(", sendTime=").append(sendTime);
        sb.append(", confrimItemTime=").append(confrimItemTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
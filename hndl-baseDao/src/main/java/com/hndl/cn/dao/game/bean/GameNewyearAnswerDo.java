package com.hndl.cn.dao.game.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * game_newyear_answer
 * @author 
 */
public class GameNewyearAnswerDo implements Serializable {
    /**
     * ä¸»é”®
     */
    private Long id;

    /**
     * 是否被删除
     */
    private String isDeleted;

    /**
     * 记录创建人
     */
    private String createOperator;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 记录的最后修改人
     */
    private String lastOperator;

    /**
     * 最后修改时间
     */
    private Date lastModifyTime;

    /**
     * userId
     */
    private Long userId;

    /**
     * 题目号（哪套题）
     */
    private String answerNum;

    /**
     * 答题的内容（A/B）
     */
    private String answerValue;

    /**
     * 投票的数据量
     */
    private String voteValue;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 是否已推送到电视的平台
     */
    private String isPushToTv;

    /**
     * 推送的时间
     */
    private Date isPushTime;

    /**
     * 支付了多少钱
     */
    private Double payCount;

    /**
     * 是否正确(正确答案配置在系统参数表）
     */
    private String isCorrect;

    /**
     * 支付的订单id（这个是判断的依据）
     */
    private String payOrderId;

    /**
     * 答题类型
     */
    private String type;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(String answerNum) {
        this.answerNum = answerNum;
    }

    public String getAnswerValue() {
        return answerValue;
    }

    public void setAnswerValue(String answerValue) {
        this.answerValue = answerValue;
    }

    public String getVoteValue() {
        return voteValue;
    }

    public void setVoteValue(String voteValue) {
        this.voteValue = voteValue;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIsPushToTv() {
        return isPushToTv;
    }

    public void setIsPushToTv(String isPushToTv) {
        this.isPushToTv = isPushToTv;
    }

    public Date getIsPushTime() {
        return isPushTime;
    }

    public void setIsPushTime(Date isPushTime) {
        this.isPushTime = isPushTime;
    }

    public Double getPayCount() {
        return payCount;
    }

    public void setPayCount(Double payCount) {
        this.payCount = payCount;
    }

    public String getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(String isCorrect) {
        this.isCorrect = isCorrect;
    }

    public String getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        GameNewyearAnswerDo other = (GameNewyearAnswerDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getAnswerNum() == null ? other.getAnswerNum() == null : this.getAnswerNum().equals(other.getAnswerNum()))
            && (this.getAnswerValue() == null ? other.getAnswerValue() == null : this.getAnswerValue().equals(other.getAnswerValue()))
            && (this.getVoteValue() == null ? other.getVoteValue() == null : this.getVoteValue().equals(other.getVoteValue()))
            && (this.getPhoneNumber() == null ? other.getPhoneNumber() == null : this.getPhoneNumber().equals(other.getPhoneNumber()))
            && (this.getIsPushToTv() == null ? other.getIsPushToTv() == null : this.getIsPushToTv().equals(other.getIsPushToTv()))
            && (this.getIsPushTime() == null ? other.getIsPushTime() == null : this.getIsPushTime().equals(other.getIsPushTime()))
            && (this.getPayCount() == null ? other.getPayCount() == null : this.getPayCount().equals(other.getPayCount()))
            && (this.getIsCorrect() == null ? other.getIsCorrect() == null : this.getIsCorrect().equals(other.getIsCorrect()))
            && (this.getPayOrderId() == null ? other.getPayOrderId() == null : this.getPayOrderId().equals(other.getPayOrderId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()));
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
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getAnswerNum() == null) ? 0 : getAnswerNum().hashCode());
        result = prime * result + ((getAnswerValue() == null) ? 0 : getAnswerValue().hashCode());
        result = prime * result + ((getVoteValue() == null) ? 0 : getVoteValue().hashCode());
        result = prime * result + ((getPhoneNumber() == null) ? 0 : getPhoneNumber().hashCode());
        result = prime * result + ((getIsPushToTv() == null) ? 0 : getIsPushToTv().hashCode());
        result = prime * result + ((getIsPushTime() == null) ? 0 : getIsPushTime().hashCode());
        result = prime * result + ((getPayCount() == null) ? 0 : getPayCount().hashCode());
        result = prime * result + ((getIsCorrect() == null) ? 0 : getIsCorrect().hashCode());
        result = prime * result + ((getPayOrderId() == null) ? 0 : getPayOrderId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
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
        sb.append(", userId=").append(userId);
        sb.append(", answerNum=").append(answerNum);
        sb.append(", answerValue=").append(answerValue);
        sb.append(", voteValue=").append(voteValue);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", isPushToTv=").append(isPushToTv);
        sb.append(", isPushTime=").append(isPushTime);
        sb.append(", payCount=").append(payCount);
        sb.append(", isCorrect=").append(isCorrect);
        sb.append(", payOrderId=").append(payOrderId);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
package com.hndl.cn.dao.member.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * member_experience_record
 * @author 
 */
public class MemberExperienceRecordDo implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 是否被删除
     */
    private String isDeleted;

    /**
     * 创建人
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
     * 用户ID
     */
    private Long userId;

    /**
     * 本次记录的数据
     */
    private Integer count;

    /**
     * 交易类型：+/-
     */
    private String type;

    /**
     * 原因：邀请-成功邀请徒弟,绑定邀请码/邀请-徒弟成功邀请徒弟,即徒孙/红包-积分红包/红包-芒果币红包/互动-投票，竞猜，抽奖，答题/福利-用积分抢福利/福利-用芒果币抢福利/任务-新用户第一次登陆芒果互动APP/任务-打开芒果互动APP/任务-新手任务：绑定手机，地址/任务-新手任务：分享App到社交平台/任务-新手任务：用第三方支付充值/
     */
    private String reason;

    /**
     * 游戏id/订单id/金币交易记录id/现金交易id/下线的userId
     */
    private String reasonId;

    /**
     * 交易前的余额
     */
    private Integer currentBalance;

    /**
     * 交易后的余额
     */
    private Integer afterBalance;

    /**
     * 下线的userId
     */
    private Long lastUserId;

    /**
     * 下线类型：1/2
     */
    private String xiaType;

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReasonId() {
        return reasonId;
    }

    public void setReasonId(String reasonId) {
        this.reasonId = reasonId;
    }

    public Integer getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Integer currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Integer getAfterBalance() {
        return afterBalance;
    }

    public void setAfterBalance(Integer afterBalance) {
        this.afterBalance = afterBalance;
    }

    public Long getLastUserId() {
        return lastUserId;
    }

    public void setLastUserId(Long lastUserId) {
        this.lastUserId = lastUserId;
    }

    public String getXiaType() {
        return xiaType;
    }

    public void setXiaType(String xiaType) {
        this.xiaType = xiaType;
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
        MemberExperienceRecordDo other = (MemberExperienceRecordDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCount() == null ? other.getCount() == null : this.getCount().equals(other.getCount()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()))
            && (this.getReasonId() == null ? other.getReasonId() == null : this.getReasonId().equals(other.getReasonId()))
            && (this.getCurrentBalance() == null ? other.getCurrentBalance() == null : this.getCurrentBalance().equals(other.getCurrentBalance()))
            && (this.getAfterBalance() == null ? other.getAfterBalance() == null : this.getAfterBalance().equals(other.getAfterBalance()))
            && (this.getLastUserId() == null ? other.getLastUserId() == null : this.getLastUserId().equals(other.getLastUserId()))
            && (this.getXiaType() == null ? other.getXiaType() == null : this.getXiaType().equals(other.getXiaType()));
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
        result = prime * result + ((getCount() == null) ? 0 : getCount().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        result = prime * result + ((getReasonId() == null) ? 0 : getReasonId().hashCode());
        result = prime * result + ((getCurrentBalance() == null) ? 0 : getCurrentBalance().hashCode());
        result = prime * result + ((getAfterBalance() == null) ? 0 : getAfterBalance().hashCode());
        result = prime * result + ((getLastUserId() == null) ? 0 : getLastUserId().hashCode());
        result = prime * result + ((getXiaType() == null) ? 0 : getXiaType().hashCode());
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
        sb.append(", count=").append(count);
        sb.append(", type=").append(type);
        sb.append(", reason=").append(reason);
        sb.append(", reasonId=").append(reasonId);
        sb.append(", currentBalance=").append(currentBalance);
        sb.append(", afterBalance=").append(afterBalance);
        sb.append(", lastUserId=").append(lastUserId);
        sb.append(", xiaType=").append(xiaType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
package com.hndl.cn.dao.member.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * member_money_trade_record
 * @author 
 */
public class MemberMoneyTradeRecordDo implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 公司空间/公司编号
     */
    private Integer namespace;

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

    private Long userId;

    /**
     * 交易的数据
     */
    private Double count;

    /**
     * 交易类型：+/-
     */
    private String type;

    /**
     * 原因：shop第三方支付夺宝购物/recharge充值
     */
    private String reason;

    /**
     * 游戏id/订单id/金币交易记录id/现金交易id
     */
    private String reasonId;

    /**
     * 第三方支付的交易id
     */
    private String outTradeId;

    /**
     * 第三方支付的交易状态
     */
    private String outTradeStatus;

    /**
     * 第三方支付类型：alipay/weixinpay
     */
    private String outTradeType;

    private String gameId;

    private String gameType;

    private String payTypeUser;

    private String voteId;

    private String guessGroup;

    private String guessInfoId;

    /**
     * 是否被使用
     */
    private String isUse;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNamespace() {
        return namespace;
    }

    public void setNamespace(Integer namespace) {
        this.namespace = namespace;
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

    public Double getCount() {
        return count;
    }

    public void setCount(Double count) {
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

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getPayTypeUser() {
        return payTypeUser;
    }

    public void setPayTypeUser(String payTypeUser) {
        this.payTypeUser = payTypeUser;
    }

    public String getVoteId() {
        return voteId;
    }

    public void setVoteId(String voteId) {
        this.voteId = voteId;
    }

    public String getGuessGroup() {
        return guessGroup;
    }

    public void setGuessGroup(String guessGroup) {
        this.guessGroup = guessGroup;
    }

    public String getGuessInfoId() {
        return guessInfoId;
    }

    public void setGuessInfoId(String guessInfoId) {
        this.guessInfoId = guessInfoId;
    }

    public String getIsUse() {
        return isUse;
    }

    public void setIsUse(String isUse) {
        this.isUse = isUse;
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
        MemberMoneyTradeRecordDo other = (MemberMoneyTradeRecordDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNamespace() == null ? other.getNamespace() == null : this.getNamespace().equals(other.getNamespace()))
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
            && (this.getOutTradeId() == null ? other.getOutTradeId() == null : this.getOutTradeId().equals(other.getOutTradeId()))
            && (this.getOutTradeStatus() == null ? other.getOutTradeStatus() == null : this.getOutTradeStatus().equals(other.getOutTradeStatus()))
            && (this.getOutTradeType() == null ? other.getOutTradeType() == null : this.getOutTradeType().equals(other.getOutTradeType()))
            && (this.getGameId() == null ? other.getGameId() == null : this.getGameId().equals(other.getGameId()))
            && (this.getGameType() == null ? other.getGameType() == null : this.getGameType().equals(other.getGameType()))
            && (this.getPayTypeUser() == null ? other.getPayTypeUser() == null : this.getPayTypeUser().equals(other.getPayTypeUser()))
            && (this.getVoteId() == null ? other.getVoteId() == null : this.getVoteId().equals(other.getVoteId()))
            && (this.getGuessGroup() == null ? other.getGuessGroup() == null : this.getGuessGroup().equals(other.getGuessGroup()))
            && (this.getGuessInfoId() == null ? other.getGuessInfoId() == null : this.getGuessInfoId().equals(other.getGuessInfoId()))
            && (this.getIsUse() == null ? other.getIsUse() == null : this.getIsUse().equals(other.getIsUse()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNamespace() == null) ? 0 : getNamespace().hashCode());
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
        result = prime * result + ((getOutTradeId() == null) ? 0 : getOutTradeId().hashCode());
        result = prime * result + ((getOutTradeStatus() == null) ? 0 : getOutTradeStatus().hashCode());
        result = prime * result + ((getOutTradeType() == null) ? 0 : getOutTradeType().hashCode());
        result = prime * result + ((getGameId() == null) ? 0 : getGameId().hashCode());
        result = prime * result + ((getGameType() == null) ? 0 : getGameType().hashCode());
        result = prime * result + ((getPayTypeUser() == null) ? 0 : getPayTypeUser().hashCode());
        result = prime * result + ((getVoteId() == null) ? 0 : getVoteId().hashCode());
        result = prime * result + ((getGuessGroup() == null) ? 0 : getGuessGroup().hashCode());
        result = prime * result + ((getGuessInfoId() == null) ? 0 : getGuessInfoId().hashCode());
        result = prime * result + ((getIsUse() == null) ? 0 : getIsUse().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", namespace=").append(namespace);
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
        sb.append(", outTradeId=").append(outTradeId);
        sb.append(", outTradeStatus=").append(outTradeStatus);
        sb.append(", outTradeType=").append(outTradeType);
        sb.append(", gameId=").append(gameId);
        sb.append(", gameType=").append(gameType);
        sb.append(", payTypeUser=").append(payTypeUser);
        sb.append(", voteId=").append(voteId);
        sb.append(", guessGroup=").append(guessGroup);
        sb.append(", guessInfoId=").append(guessInfoId);
        sb.append(", isUse=").append(isUse);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
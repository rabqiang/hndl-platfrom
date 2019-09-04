package com.hndl.cn.dao.common.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * common_redbag_info
 * @author 
 */
public class CommonRedbagInfoDo implements Serializable {
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
     * 游戏id
     */
    private Long gameId;

    /**
     * 红包总钱数
     */
    private Double totalMoney;

    /**
     * 红包总个数
     */
    private Integer totalCount;

    /**
     * 已设置红包个数
     */
    private Integer countAlr;

    /**
     * 赞助方
     */
    private String supporter;

    /**
     * 已配置钱数
     */
    private Double moneyAlr;

    /**
     * 红包开奖时间
     */
    private Date startTime;

    /**
     * 已发放红包数
     */
    private Integer sendCount;

    /**
     * 当前可用红包总个数
     */
    private Integer nowRedbagCount;

    /**
     * 红包类型:（普通芒果币、新手定时积分、定时芒果币）
     */
    private String redbagType;

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

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getCountAlr() {
        return countAlr;
    }

    public void setCountAlr(Integer countAlr) {
        this.countAlr = countAlr;
    }

    public String getSupporter() {
        return supporter;
    }

    public void setSupporter(String supporter) {
        this.supporter = supporter;
    }

    public Double getMoneyAlr() {
        return moneyAlr;
    }

    public void setMoneyAlr(Double moneyAlr) {
        this.moneyAlr = moneyAlr;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getSendCount() {
        return sendCount;
    }

    public void setSendCount(Integer sendCount) {
        this.sendCount = sendCount;
    }

    public Integer getNowRedbagCount() {
        return nowRedbagCount;
    }

    public void setNowRedbagCount(Integer nowRedbagCount) {
        this.nowRedbagCount = nowRedbagCount;
    }

    public String getRedbagType() {
        return redbagType;
    }

    public void setRedbagType(String redbagType) {
        this.redbagType = redbagType;
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
        CommonRedbagInfoDo other = (CommonRedbagInfoDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getGameId() == null ? other.getGameId() == null : this.getGameId().equals(other.getGameId()))
            && (this.getTotalMoney() == null ? other.getTotalMoney() == null : this.getTotalMoney().equals(other.getTotalMoney()))
            && (this.getTotalCount() == null ? other.getTotalCount() == null : this.getTotalCount().equals(other.getTotalCount()))
            && (this.getCountAlr() == null ? other.getCountAlr() == null : this.getCountAlr().equals(other.getCountAlr()))
            && (this.getSupporter() == null ? other.getSupporter() == null : this.getSupporter().equals(other.getSupporter()))
            && (this.getMoneyAlr() == null ? other.getMoneyAlr() == null : this.getMoneyAlr().equals(other.getMoneyAlr()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getSendCount() == null ? other.getSendCount() == null : this.getSendCount().equals(other.getSendCount()))
            && (this.getNowRedbagCount() == null ? other.getNowRedbagCount() == null : this.getNowRedbagCount().equals(other.getNowRedbagCount()))
            && (this.getRedbagType() == null ? other.getRedbagType() == null : this.getRedbagType().equals(other.getRedbagType()));
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
        result = prime * result + ((getGameId() == null) ? 0 : getGameId().hashCode());
        result = prime * result + ((getTotalMoney() == null) ? 0 : getTotalMoney().hashCode());
        result = prime * result + ((getTotalCount() == null) ? 0 : getTotalCount().hashCode());
        result = prime * result + ((getCountAlr() == null) ? 0 : getCountAlr().hashCode());
        result = prime * result + ((getSupporter() == null) ? 0 : getSupporter().hashCode());
        result = prime * result + ((getMoneyAlr() == null) ? 0 : getMoneyAlr().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getSendCount() == null) ? 0 : getSendCount().hashCode());
        result = prime * result + ((getNowRedbagCount() == null) ? 0 : getNowRedbagCount().hashCode());
        result = prime * result + ((getRedbagType() == null) ? 0 : getRedbagType().hashCode());
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
        sb.append(", gameId=").append(gameId);
        sb.append(", totalMoney=").append(totalMoney);
        sb.append(", totalCount=").append(totalCount);
        sb.append(", countAlr=").append(countAlr);
        sb.append(", supporter=").append(supporter);
        sb.append(", moneyAlr=").append(moneyAlr);
        sb.append(", startTime=").append(startTime);
        sb.append(", sendCount=").append(sendCount);
        sb.append(", nowRedbagCount=").append(nowRedbagCount);
        sb.append(", redbagType=").append(redbagType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
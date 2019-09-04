package com.hndl.cn.dao.star.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * star_guard_record
 * @author 
 */
public class StarGuardRecordDo implements Serializable {
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
     * 明星ID
     */
    private Long starId;

    /**
     * 评论人的id
     */
    private Long userId;

    private Integer guardCount;

    private Double money;

    private String ip;

    private String outTradeId;

    private String outTradeStatte;

    private Double currentBalance;

    private Double afterBalance;

    /**
     * 统计守护天数
     */
    private Integer countDay;

    /**
     * 是否弹幕（是 y/ 否 n）
     */
    private String isBarrage;

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

    public Long getStarId() {
        return starId;
    }

    public void setStarId(Long starId) {
        this.starId = starId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getGuardCount() {
        return guardCount;
    }

    public void setGuardCount(Integer guardCount) {
        this.guardCount = guardCount;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOutTradeId() {
        return outTradeId;
    }

    public void setOutTradeId(String outTradeId) {
        this.outTradeId = outTradeId;
    }

    public String getOutTradeStatte() {
        return outTradeStatte;
    }

    public void setOutTradeStatte(String outTradeStatte) {
        this.outTradeStatte = outTradeStatte;
    }

    public Double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Double getAfterBalance() {
        return afterBalance;
    }

    public void setAfterBalance(Double afterBalance) {
        this.afterBalance = afterBalance;
    }

    public Integer getCountDay() {
        return countDay;
    }

    public void setCountDay(Integer countDay) {
        this.countDay = countDay;
    }

    public String getIsBarrage() {
        return isBarrage;
    }

    public void setIsBarrage(String isBarrage) {
        this.isBarrage = isBarrage;
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
        StarGuardRecordDo other = (StarGuardRecordDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getStarId() == null ? other.getStarId() == null : this.getStarId().equals(other.getStarId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getGuardCount() == null ? other.getGuardCount() == null : this.getGuardCount().equals(other.getGuardCount()))
            && (this.getMoney() == null ? other.getMoney() == null : this.getMoney().equals(other.getMoney()))
            && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
            && (this.getOutTradeId() == null ? other.getOutTradeId() == null : this.getOutTradeId().equals(other.getOutTradeId()))
            && (this.getOutTradeStatte() == null ? other.getOutTradeStatte() == null : this.getOutTradeStatte().equals(other.getOutTradeStatte()))
            && (this.getCurrentBalance() == null ? other.getCurrentBalance() == null : this.getCurrentBalance().equals(other.getCurrentBalance()))
            && (this.getAfterBalance() == null ? other.getAfterBalance() == null : this.getAfterBalance().equals(other.getAfterBalance()))
            && (this.getCountDay() == null ? other.getCountDay() == null : this.getCountDay().equals(other.getCountDay()))
            && (this.getIsBarrage() == null ? other.getIsBarrage() == null : this.getIsBarrage().equals(other.getIsBarrage()));
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
        result = prime * result + ((getStarId() == null) ? 0 : getStarId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getGuardCount() == null) ? 0 : getGuardCount().hashCode());
        result = prime * result + ((getMoney() == null) ? 0 : getMoney().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getOutTradeId() == null) ? 0 : getOutTradeId().hashCode());
        result = prime * result + ((getOutTradeStatte() == null) ? 0 : getOutTradeStatte().hashCode());
        result = prime * result + ((getCurrentBalance() == null) ? 0 : getCurrentBalance().hashCode());
        result = prime * result + ((getAfterBalance() == null) ? 0 : getAfterBalance().hashCode());
        result = prime * result + ((getCountDay() == null) ? 0 : getCountDay().hashCode());
        result = prime * result + ((getIsBarrage() == null) ? 0 : getIsBarrage().hashCode());
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
        sb.append(", starId=").append(starId);
        sb.append(", userId=").append(userId);
        sb.append(", guardCount=").append(guardCount);
        sb.append(", money=").append(money);
        sb.append(", ip=").append(ip);
        sb.append(", outTradeId=").append(outTradeId);
        sb.append(", outTradeStatte=").append(outTradeStatte);
        sb.append(", currentBalance=").append(currentBalance);
        sb.append(", afterBalance=").append(afterBalance);
        sb.append(", countDay=").append(countDay);
        sb.append(", isBarrage=").append(isBarrage);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
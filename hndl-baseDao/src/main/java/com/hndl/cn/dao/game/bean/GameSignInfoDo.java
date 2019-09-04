package com.hndl.cn.dao.game.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * game_sign_info
 * @author 
 */
public class GameSignInfoDo implements Serializable {
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
     * 用户id
     */
    private Long userId;

    /**
     * 签到日期
     */
    private Date signDate;

    /**
     * 累计奖品类型：dou/coin
     */
    private String prizeTypeAll;

    /**
     * 累计奖品的数量
     */
    private Integer prizeCountAll;

    /**
     * 连续签到的奖品类型
     */
    private String prizeTypeContine;

    /**
     * 连续签到的奖品数量
     */
    private Integer prizeCountContine;

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

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public String getPrizeTypeAll() {
        return prizeTypeAll;
    }

    public void setPrizeTypeAll(String prizeTypeAll) {
        this.prizeTypeAll = prizeTypeAll;
    }

    public Integer getPrizeCountAll() {
        return prizeCountAll;
    }

    public void setPrizeCountAll(Integer prizeCountAll) {
        this.prizeCountAll = prizeCountAll;
    }

    public String getPrizeTypeContine() {
        return prizeTypeContine;
    }

    public void setPrizeTypeContine(String prizeTypeContine) {
        this.prizeTypeContine = prizeTypeContine;
    }

    public Integer getPrizeCountContine() {
        return prizeCountContine;
    }

    public void setPrizeCountContine(Integer prizeCountContine) {
        this.prizeCountContine = prizeCountContine;
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
        GameSignInfoDo other = (GameSignInfoDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getSignDate() == null ? other.getSignDate() == null : this.getSignDate().equals(other.getSignDate()))
            && (this.getPrizeTypeAll() == null ? other.getPrizeTypeAll() == null : this.getPrizeTypeAll().equals(other.getPrizeTypeAll()))
            && (this.getPrizeCountAll() == null ? other.getPrizeCountAll() == null : this.getPrizeCountAll().equals(other.getPrizeCountAll()))
            && (this.getPrizeTypeContine() == null ? other.getPrizeTypeContine() == null : this.getPrizeTypeContine().equals(other.getPrizeTypeContine()))
            && (this.getPrizeCountContine() == null ? other.getPrizeCountContine() == null : this.getPrizeCountContine().equals(other.getPrizeCountContine()));
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
        result = prime * result + ((getSignDate() == null) ? 0 : getSignDate().hashCode());
        result = prime * result + ((getPrizeTypeAll() == null) ? 0 : getPrizeTypeAll().hashCode());
        result = prime * result + ((getPrizeCountAll() == null) ? 0 : getPrizeCountAll().hashCode());
        result = prime * result + ((getPrizeTypeContine() == null) ? 0 : getPrizeTypeContine().hashCode());
        result = prime * result + ((getPrizeCountContine() == null) ? 0 : getPrizeCountContine().hashCode());
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
        sb.append(", signDate=").append(signDate);
        sb.append(", prizeTypeAll=").append(prizeTypeAll);
        sb.append(", prizeCountAll=").append(prizeCountAll);
        sb.append(", prizeTypeContine=").append(prizeTypeContine);
        sb.append(", prizeCountContine=").append(prizeCountContine);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
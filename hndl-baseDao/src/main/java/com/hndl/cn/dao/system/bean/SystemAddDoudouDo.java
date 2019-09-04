package com.hndl.cn.dao.system.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * system_add_doudou
 * @author 
 */
public class SystemAddDoudouDo implements Serializable {
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
    private Long userId;

    private String buisType;

    private String lastReason;

    private String jpushDesc;

    private String jpushToWhere;

    private String noticeTitle;

    private String state;

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

    public String getBuisType() {
        return buisType;
    }

    public void setBuisType(String buisType) {
        this.buisType = buisType;
    }

    public String getLastReason() {
        return lastReason;
    }

    public void setLastReason(String lastReason) {
        this.lastReason = lastReason;
    }

    public String getJpushDesc() {
        return jpushDesc;
    }

    public void setJpushDesc(String jpushDesc) {
        this.jpushDesc = jpushDesc;
    }

    public String getJpushToWhere() {
        return jpushToWhere;
    }

    public void setJpushToWhere(String jpushToWhere) {
        this.jpushToWhere = jpushToWhere;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
        SystemAddDoudouDo other = (SystemAddDoudouDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getBuisType() == null ? other.getBuisType() == null : this.getBuisType().equals(other.getBuisType()))
            && (this.getLastReason() == null ? other.getLastReason() == null : this.getLastReason().equals(other.getLastReason()))
            && (this.getJpushDesc() == null ? other.getJpushDesc() == null : this.getJpushDesc().equals(other.getJpushDesc()))
            && (this.getJpushToWhere() == null ? other.getJpushToWhere() == null : this.getJpushToWhere().equals(other.getJpushToWhere()))
            && (this.getNoticeTitle() == null ? other.getNoticeTitle() == null : this.getNoticeTitle().equals(other.getNoticeTitle()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()));
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
        result = prime * result + ((getBuisType() == null) ? 0 : getBuisType().hashCode());
        result = prime * result + ((getLastReason() == null) ? 0 : getLastReason().hashCode());
        result = prime * result + ((getJpushDesc() == null) ? 0 : getJpushDesc().hashCode());
        result = prime * result + ((getJpushToWhere() == null) ? 0 : getJpushToWhere().hashCode());
        result = prime * result + ((getNoticeTitle() == null) ? 0 : getNoticeTitle().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
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
        sb.append(", buisType=").append(buisType);
        sb.append(", lastReason=").append(lastReason);
        sb.append(", jpushDesc=").append(jpushDesc);
        sb.append(", jpushToWhere=").append(jpushToWhere);
        sb.append(", noticeTitle=").append(noticeTitle);
        sb.append(", state=").append(state);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
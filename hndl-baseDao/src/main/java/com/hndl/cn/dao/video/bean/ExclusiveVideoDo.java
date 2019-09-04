package com.hndl.cn.dao.video.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 独家视频基于腾讯视频
 * exclusive_video
 * @author 
 */
public class ExclusiveVideoDo implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 是否删除(1是0否)
     */
    private Integer isDeleted;

    /**
     * 创建人唯一标识
     */
    private Long createAdminId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 腾讯视频vid
     */
    private String txVid;

    /**
     * 描述
     */
    private String description;

    /**
     * 更新管理员id
     */
    private Long updateAdminId;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 标题
     */
    private String title;

    private String expand1;

    private String expand2;

    /**
     * 排序值
     */
    private Integer orderNum;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Long getCreateAdminId() {
        return createAdminId;
    }

    public void setCreateAdminId(Long createAdminId) {
        this.createAdminId = createAdminId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTxVid() {
        return txVid;
    }

    public void setTxVid(String txVid) {
        this.txVid = txVid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUpdateAdminId() {
        return updateAdminId;
    }

    public void setUpdateAdminId(Long updateAdminId) {
        this.updateAdminId = updateAdminId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
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
        ExclusiveVideoDo other = (ExclusiveVideoDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateAdminId() == null ? other.getCreateAdminId() == null : this.getCreateAdminId().equals(other.getCreateAdminId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getTxVid() == null ? other.getTxVid() == null : this.getTxVid().equals(other.getTxVid()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getUpdateAdminId() == null ? other.getUpdateAdminId() == null : this.getUpdateAdminId().equals(other.getUpdateAdminId()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getExpand1() == null ? other.getExpand1() == null : this.getExpand1().equals(other.getExpand1()))
            && (this.getExpand2() == null ? other.getExpand2() == null : this.getExpand2().equals(other.getExpand2()))
            && (this.getOrderNum() == null ? other.getOrderNum() == null : this.getOrderNum().equals(other.getOrderNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        result = prime * result + ((getCreateAdminId() == null) ? 0 : getCreateAdminId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getTxVid() == null) ? 0 : getTxVid().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getUpdateAdminId() == null) ? 0 : getUpdateAdminId().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getExpand1() == null) ? 0 : getExpand1().hashCode());
        result = prime * result + ((getExpand2() == null) ? 0 : getExpand2().hashCode());
        result = prime * result + ((getOrderNum() == null) ? 0 : getOrderNum().hashCode());
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
        sb.append(", createAdminId=").append(createAdminId);
        sb.append(", createTime=").append(createTime);
        sb.append(", txVid=").append(txVid);
        sb.append(", description=").append(description);
        sb.append(", updateAdminId=").append(updateAdminId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", title=").append(title);
        sb.append(", expand1=").append(expand1);
        sb.append(", expand2=").append(expand2);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
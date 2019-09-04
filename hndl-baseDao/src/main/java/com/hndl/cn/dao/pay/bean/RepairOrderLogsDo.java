package com.hndl.cn.dao.pay.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * repair_order_logs
 * @author 
 */
public class RepairOrderLogsDo implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建者id
     */
    private Long createAdminId;

    /**
     * 本地订单号
     */
    private Long localOrderId;

    /**
     * 用户唯一id
     */
    private Long userUniId;

    /**
     * 是否删除
     */
    private Integer isDelete;

    /**
     * 备注信息
     */
    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateAdminId() {
        return createAdminId;
    }

    public void setCreateAdminId(Long createAdminId) {
        this.createAdminId = createAdminId;
    }

    public Long getLocalOrderId() {
        return localOrderId;
    }

    public void setLocalOrderId(Long localOrderId) {
        this.localOrderId = localOrderId;
    }

    public Long getUserUniId() {
        return userUniId;
    }

    public void setUserUniId(Long userUniId) {
        this.userUniId = userUniId;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        RepairOrderLogsDo other = (RepairOrderLogsDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateAdminId() == null ? other.getCreateAdminId() == null : this.getCreateAdminId().equals(other.getCreateAdminId()))
            && (this.getLocalOrderId() == null ? other.getLocalOrderId() == null : this.getLocalOrderId().equals(other.getLocalOrderId()))
            && (this.getUserUniId() == null ? other.getUserUniId() == null : this.getUserUniId().equals(other.getUserUniId()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateAdminId() == null) ? 0 : getCreateAdminId().hashCode());
        result = prime * result + ((getLocalOrderId() == null) ? 0 : getLocalOrderId().hashCode());
        result = prime * result + ((getUserUniId() == null) ? 0 : getUserUniId().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", createAdminId=").append(createAdminId);
        sb.append(", localOrderId=").append(localOrderId);
        sb.append(", userUniId=").append(userUniId);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
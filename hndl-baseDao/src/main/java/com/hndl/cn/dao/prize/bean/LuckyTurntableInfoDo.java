package com.hndl.cn.dao.prize.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * lucky_turntable_info
 * @author 
 */
public class LuckyTurntableInfoDo implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 奖品名称
     */
    private String prizeName;

    /**
     * 创建用户id
     */
    private Long createAdminId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后修改人id
     */
    private Long upateAdminId;

    /**
     * 最后修改时间
     */
    private Date updateTime;

    /**
     * 权重概率
     */
    private Integer weightNum;

    /**
     * 排序值
     */
    private Integer orderNum;

    /**
     * 库存值
     */
    private Integer reserveNum;

    /**
     * 是不是实物
     */
    private Integer isEntity;

    /**
     * 用户最多获得次数
     */
    private Integer personMaxGet;

    /**
     * 用户最小抽奖次数
     */
    private Integer personMinDraw;

    /**
     * 是否删除:1是0否
     */
    private Integer isDelete;

    /**
     * 是否显示消息
     */
    private Integer showMessage;

    /**
     * 积分
     */
    private Long integral;

    /**
     * 标题
     */
    private String title;

    /**
     * 副标题
     */
    private String subhead;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
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

    public Long getUpateAdminId() {
        return upateAdminId;
    }

    public void setUpateAdminId(Long upateAdminId) {
        this.upateAdminId = upateAdminId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getWeightNum() {
        return weightNum;
    }

    public void setWeightNum(Integer weightNum) {
        this.weightNum = weightNum;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getReserveNum() {
        return reserveNum;
    }

    public void setReserveNum(Integer reserveNum) {
        this.reserveNum = reserveNum;
    }

    public Integer getIsEntity() {
        return isEntity;
    }

    public void setIsEntity(Integer isEntity) {
        this.isEntity = isEntity;
    }

    public Integer getPersonMaxGet() {
        return personMaxGet;
    }

    public void setPersonMaxGet(Integer personMaxGet) {
        this.personMaxGet = personMaxGet;
    }

    public Integer getPersonMinDraw() {
        return personMinDraw;
    }

    public void setPersonMinDraw(Integer personMinDraw) {
        this.personMinDraw = personMinDraw;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getShowMessage() {
        return showMessage;
    }

    public void setShowMessage(Integer showMessage) {
        this.showMessage = showMessage;
    }

    public Long getIntegral() {
        return integral;
    }

    public void setIntegral(Long integral) {
        this.integral = integral;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubhead() {
        return subhead;
    }

    public void setSubhead(String subhead) {
        this.subhead = subhead;
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
        LuckyTurntableInfoDo other = (LuckyTurntableInfoDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPrizeName() == null ? other.getPrizeName() == null : this.getPrizeName().equals(other.getPrizeName()))
            && (this.getCreateAdminId() == null ? other.getCreateAdminId() == null : this.getCreateAdminId().equals(other.getCreateAdminId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpateAdminId() == null ? other.getUpateAdminId() == null : this.getUpateAdminId().equals(other.getUpateAdminId()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getWeightNum() == null ? other.getWeightNum() == null : this.getWeightNum().equals(other.getWeightNum()))
            && (this.getOrderNum() == null ? other.getOrderNum() == null : this.getOrderNum().equals(other.getOrderNum()))
            && (this.getReserveNum() == null ? other.getReserveNum() == null : this.getReserveNum().equals(other.getReserveNum()))
            && (this.getIsEntity() == null ? other.getIsEntity() == null : this.getIsEntity().equals(other.getIsEntity()))
            && (this.getPersonMaxGet() == null ? other.getPersonMaxGet() == null : this.getPersonMaxGet().equals(other.getPersonMaxGet()))
            && (this.getPersonMinDraw() == null ? other.getPersonMinDraw() == null : this.getPersonMinDraw().equals(other.getPersonMinDraw()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getShowMessage() == null ? other.getShowMessage() == null : this.getShowMessage().equals(other.getShowMessage()))
            && (this.getIntegral() == null ? other.getIntegral() == null : this.getIntegral().equals(other.getIntegral()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getSubhead() == null ? other.getSubhead() == null : this.getSubhead().equals(other.getSubhead()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPrizeName() == null) ? 0 : getPrizeName().hashCode());
        result = prime * result + ((getCreateAdminId() == null) ? 0 : getCreateAdminId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpateAdminId() == null) ? 0 : getUpateAdminId().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getWeightNum() == null) ? 0 : getWeightNum().hashCode());
        result = prime * result + ((getOrderNum() == null) ? 0 : getOrderNum().hashCode());
        result = prime * result + ((getReserveNum() == null) ? 0 : getReserveNum().hashCode());
        result = prime * result + ((getIsEntity() == null) ? 0 : getIsEntity().hashCode());
        result = prime * result + ((getPersonMaxGet() == null) ? 0 : getPersonMaxGet().hashCode());
        result = prime * result + ((getPersonMinDraw() == null) ? 0 : getPersonMinDraw().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getShowMessage() == null) ? 0 : getShowMessage().hashCode());
        result = prime * result + ((getIntegral() == null) ? 0 : getIntegral().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getSubhead() == null) ? 0 : getSubhead().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", prizeName=").append(prizeName);
        sb.append(", createAdminId=").append(createAdminId);
        sb.append(", createTime=").append(createTime);
        sb.append(", upateAdminId=").append(upateAdminId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", weightNum=").append(weightNum);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", reserveNum=").append(reserveNum);
        sb.append(", isEntity=").append(isEntity);
        sb.append(", personMaxGet=").append(personMaxGet);
        sb.append(", personMinDraw=").append(personMinDraw);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", showMessage=").append(showMessage);
        sb.append(", integral=").append(integral);
        sb.append(", title=").append(title);
        sb.append(", subhead=").append(subhead);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
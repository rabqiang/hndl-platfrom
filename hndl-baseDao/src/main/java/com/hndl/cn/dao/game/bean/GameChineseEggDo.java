package com.hndl.cn.dao.game.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * game_chinese_egg
 * @author 
 */
public class GameChineseEggDo implements Serializable {
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
     * 花了多少钱
     */
    private Integer moeny;

    /**
     * 砸蛋的次数
     */
    private Integer clickCount;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 返回夺宝的商品id1
     */
    private String itemId1;

    /**
     * 返回夺宝的商品id2
     */
    private String itemId2;

    /**
     * 返回夺宝的商品id3
     */
    private String itemId3;

    /**
     * 备用字段
     */
    private String other1;

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

    public Integer getMoeny() {
        return moeny;
    }

    public void setMoeny(Integer moeny) {
        this.moeny = moeny;
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getItemId1() {
        return itemId1;
    }

    public void setItemId1(String itemId1) {
        this.itemId1 = itemId1;
    }

    public String getItemId2() {
        return itemId2;
    }

    public void setItemId2(String itemId2) {
        this.itemId2 = itemId2;
    }

    public String getItemId3() {
        return itemId3;
    }

    public void setItemId3(String itemId3) {
        this.itemId3 = itemId3;
    }

    public String getOther1() {
        return other1;
    }

    public void setOther1(String other1) {
        this.other1 = other1;
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
        GameChineseEggDo other = (GameChineseEggDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getMoeny() == null ? other.getMoeny() == null : this.getMoeny().equals(other.getMoeny()))
            && (this.getClickCount() == null ? other.getClickCount() == null : this.getClickCount().equals(other.getClickCount()))
            && (this.getPhoneNumber() == null ? other.getPhoneNumber() == null : this.getPhoneNumber().equals(other.getPhoneNumber()))
            && (this.getItemId1() == null ? other.getItemId1() == null : this.getItemId1().equals(other.getItemId1()))
            && (this.getItemId2() == null ? other.getItemId2() == null : this.getItemId2().equals(other.getItemId2()))
            && (this.getItemId3() == null ? other.getItemId3() == null : this.getItemId3().equals(other.getItemId3()))
            && (this.getOther1() == null ? other.getOther1() == null : this.getOther1().equals(other.getOther1()));
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
        result = prime * result + ((getMoeny() == null) ? 0 : getMoeny().hashCode());
        result = prime * result + ((getClickCount() == null) ? 0 : getClickCount().hashCode());
        result = prime * result + ((getPhoneNumber() == null) ? 0 : getPhoneNumber().hashCode());
        result = prime * result + ((getItemId1() == null) ? 0 : getItemId1().hashCode());
        result = prime * result + ((getItemId2() == null) ? 0 : getItemId2().hashCode());
        result = prime * result + ((getItemId3() == null) ? 0 : getItemId3().hashCode());
        result = prime * result + ((getOther1() == null) ? 0 : getOther1().hashCode());
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
        sb.append(", moeny=").append(moeny);
        sb.append(", clickCount=").append(clickCount);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", itemId1=").append(itemId1);
        sb.append(", itemId2=").append(itemId2);
        sb.append(", itemId3=").append(itemId3);
        sb.append(", other1=").append(other1);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
package com.hndl.cn.dao.shop.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * shop_app_item_count
 * @author 
 */
public class ShopAppItemCountDo implements Serializable {
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
     * 商品模板ID
     */
    private Long shopItemTempletId;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 统计日期
     */
    private Date countDate;

    /**
     * 参与人数
     */
    private Long partakePeopleNumber;

    /**
     * 游览量
     */
    private Long visitCount;

    /**
     * 订单量
     */
    private Long orderCount;

    /**
     * 开奖次数
     */
    private Long lotteryNumber;

    /**
     * 备用字段
     */
    private String reserve;

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

    public Long getShopItemTempletId() {
        return shopItemTempletId;
    }

    public void setShopItemTempletId(Long shopItemTempletId) {
        this.shopItemTempletId = shopItemTempletId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCountDate() {
        return countDate;
    }

    public void setCountDate(Date countDate) {
        this.countDate = countDate;
    }

    public Long getPartakePeopleNumber() {
        return partakePeopleNumber;
    }

    public void setPartakePeopleNumber(Long partakePeopleNumber) {
        this.partakePeopleNumber = partakePeopleNumber;
    }

    public Long getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Long visitCount) {
        this.visitCount = visitCount;
    }

    public Long getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Long orderCount) {
        this.orderCount = orderCount;
    }

    public Long getLotteryNumber() {
        return lotteryNumber;
    }

    public void setLotteryNumber(Long lotteryNumber) {
        this.lotteryNumber = lotteryNumber;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
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
        ShopAppItemCountDo other = (ShopAppItemCountDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getShopItemTempletId() == null ? other.getShopItemTempletId() == null : this.getShopItemTempletId().equals(other.getShopItemTempletId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getCountDate() == null ? other.getCountDate() == null : this.getCountDate().equals(other.getCountDate()))
            && (this.getPartakePeopleNumber() == null ? other.getPartakePeopleNumber() == null : this.getPartakePeopleNumber().equals(other.getPartakePeopleNumber()))
            && (this.getVisitCount() == null ? other.getVisitCount() == null : this.getVisitCount().equals(other.getVisitCount()))
            && (this.getOrderCount() == null ? other.getOrderCount() == null : this.getOrderCount().equals(other.getOrderCount()))
            && (this.getLotteryNumber() == null ? other.getLotteryNumber() == null : this.getLotteryNumber().equals(other.getLotteryNumber()))
            && (this.getReserve() == null ? other.getReserve() == null : this.getReserve().equals(other.getReserve()));
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
        result = prime * result + ((getShopItemTempletId() == null) ? 0 : getShopItemTempletId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getCountDate() == null) ? 0 : getCountDate().hashCode());
        result = prime * result + ((getPartakePeopleNumber() == null) ? 0 : getPartakePeopleNumber().hashCode());
        result = prime * result + ((getVisitCount() == null) ? 0 : getVisitCount().hashCode());
        result = prime * result + ((getOrderCount() == null) ? 0 : getOrderCount().hashCode());
        result = prime * result + ((getLotteryNumber() == null) ? 0 : getLotteryNumber().hashCode());
        result = prime * result + ((getReserve() == null) ? 0 : getReserve().hashCode());
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
        sb.append(", shopItemTempletId=").append(shopItemTempletId);
        sb.append(", title=").append(title);
        sb.append(", countDate=").append(countDate);
        sb.append(", partakePeopleNumber=").append(partakePeopleNumber);
        sb.append(", visitCount=").append(visitCount);
        sb.append(", orderCount=").append(orderCount);
        sb.append(", lotteryNumber=").append(lotteryNumber);
        sb.append(", reserve=").append(reserve);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
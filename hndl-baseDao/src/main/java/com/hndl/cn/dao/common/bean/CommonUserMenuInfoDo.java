package com.hndl.cn.dao.common.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * common_user_menu_info
 * @author 
 */
public class CommonUserMenuInfoDo implements Serializable {
    /**
     * 主键
     */
    private Long id;

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

    /**
     * 标题
     */
    private String title;

    /**
     * 图片
     */
    private String imgUrl;

    /**
     * 跳转类型：h5、itemDetail、shopHome、recharge、null
     */
    private String toType;

    /**
     * 跳转地址
     */
    private String toUrl;

    /**
     * 是否针对苹果客户端隐藏此菜单(y/n)
     */
    private String isIosHide;

    /**
     * 是否针对安卓客户端隐藏此菜单(y/n)
     */
    private String isAndroidHide;

    /**
     * 排序值：排序规则（降序）
     */
    private Integer orderNumber;

    /**
     * 是否针对苹果客户端版本号隐藏此菜单(y/n)
     */
    private String isIosVersionHide;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getToType() {
        return toType;
    }

    public void setToType(String toType) {
        this.toType = toType;
    }

    public String getToUrl() {
        return toUrl;
    }

    public void setToUrl(String toUrl) {
        this.toUrl = toUrl;
    }

    public String getIsIosHide() {
        return isIosHide;
    }

    public void setIsIosHide(String isIosHide) {
        this.isIosHide = isIosHide;
    }

    public String getIsAndroidHide() {
        return isAndroidHide;
    }

    public void setIsAndroidHide(String isAndroidHide) {
        this.isAndroidHide = isAndroidHide;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getIsIosVersionHide() {
        return isIosVersionHide;
    }

    public void setIsIosVersionHide(String isIosVersionHide) {
        this.isIosVersionHide = isIosVersionHide;
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
        CommonUserMenuInfoDo other = (CommonUserMenuInfoDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getImgUrl() == null ? other.getImgUrl() == null : this.getImgUrl().equals(other.getImgUrl()))
            && (this.getToType() == null ? other.getToType() == null : this.getToType().equals(other.getToType()))
            && (this.getToUrl() == null ? other.getToUrl() == null : this.getToUrl().equals(other.getToUrl()))
            && (this.getIsIosHide() == null ? other.getIsIosHide() == null : this.getIsIosHide().equals(other.getIsIosHide()))
            && (this.getIsAndroidHide() == null ? other.getIsAndroidHide() == null : this.getIsAndroidHide().equals(other.getIsAndroidHide()))
            && (this.getOrderNumber() == null ? other.getOrderNumber() == null : this.getOrderNumber().equals(other.getOrderNumber()))
            && (this.getIsIosVersionHide() == null ? other.getIsIosVersionHide() == null : this.getIsIosVersionHide().equals(other.getIsIosVersionHide()));
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
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getImgUrl() == null) ? 0 : getImgUrl().hashCode());
        result = prime * result + ((getToType() == null) ? 0 : getToType().hashCode());
        result = prime * result + ((getToUrl() == null) ? 0 : getToUrl().hashCode());
        result = prime * result + ((getIsIosHide() == null) ? 0 : getIsIosHide().hashCode());
        result = prime * result + ((getIsAndroidHide() == null) ? 0 : getIsAndroidHide().hashCode());
        result = prime * result + ((getOrderNumber() == null) ? 0 : getOrderNumber().hashCode());
        result = prime * result + ((getIsIosVersionHide() == null) ? 0 : getIsIosVersionHide().hashCode());
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
        sb.append(", title=").append(title);
        sb.append(", imgUrl=").append(imgUrl);
        sb.append(", toType=").append(toType);
        sb.append(", toUrl=").append(toUrl);
        sb.append(", isIosHide=").append(isIosHide);
        sb.append(", isAndroidHide=").append(isAndroidHide);
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", isIosVersionHide=").append(isIosVersionHide);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
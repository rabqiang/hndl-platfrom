package com.hndl.cn.dao.shop.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * shop_order_show_info
 * @author 
 */
public class ShopOrderShowInfoDo implements Serializable {
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
     * 用户id
     */
    private String userId;

    /**
     * 商品id
     */
    private String itemId;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 用户分享的时候 需要填写的 分享标题
     */
    private String showTitle;

    /**
     * 用户分享的文字（晒单的详情页面参考网易）
     */
    private String detail;

    /**
     * 晒单的图片1 http地址
     */
    private String img1;

    /**
     * 晒单的图片2 http地址
     */
    private String img2;

    /**
     * 晒单的图片3 http地址
     */
    private String img3;

    /**
     * 晒单的图片4 http地址
     */
    private String img4;

    /**
     * 晒单的图片5  http地址
     */
    private String img5;

    /**
     * 晒单的图片6 http地址
     */
    private String img6;

    /**
     * 晒单的图片7 http地址
     */
    private String img7;

    /**
     * 晒单的图片8 http地址
     */
    private String img8;

    /**
     * 晒单的图片9 http地址
     */
    private String img9;

    /**
     * 状态：提交审核中、审批通过、审核失败（db存：checking/online/checkFail）
     */
    private String showStatus;

    /**
     * 审批人的userId
     */
    private String checkOperator;

    /**
     * 奖励类型（芒果豆、芒果币）db存：dou/coin
     */
    private String prizeType;

    /**
     * 奖励的数量
     */
    private Integer prizeCount;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getShowTitle() {
        return showTitle;
    }

    public void setShowTitle(String showTitle) {
        this.showTitle = showTitle;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public String getImg4() {
        return img4;
    }

    public void setImg4(String img4) {
        this.img4 = img4;
    }

    public String getImg5() {
        return img5;
    }

    public void setImg5(String img5) {
        this.img5 = img5;
    }

    public String getImg6() {
        return img6;
    }

    public void setImg6(String img6) {
        this.img6 = img6;
    }

    public String getImg7() {
        return img7;
    }

    public void setImg7(String img7) {
        this.img7 = img7;
    }

    public String getImg8() {
        return img8;
    }

    public void setImg8(String img8) {
        this.img8 = img8;
    }

    public String getImg9() {
        return img9;
    }

    public void setImg9(String img9) {
        this.img9 = img9;
    }

    public String getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(String showStatus) {
        this.showStatus = showStatus;
    }

    public String getCheckOperator() {
        return checkOperator;
    }

    public void setCheckOperator(String checkOperator) {
        this.checkOperator = checkOperator;
    }

    public String getPrizeType() {
        return prizeType;
    }

    public void setPrizeType(String prizeType) {
        this.prizeType = prizeType;
    }

    public Integer getPrizeCount() {
        return prizeCount;
    }

    public void setPrizeCount(Integer prizeCount) {
        this.prizeCount = prizeCount;
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
        ShopOrderShowInfoDo other = (ShopOrderShowInfoDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getShowTitle() == null ? other.getShowTitle() == null : this.getShowTitle().equals(other.getShowTitle()))
            && (this.getDetail() == null ? other.getDetail() == null : this.getDetail().equals(other.getDetail()))
            && (this.getImg1() == null ? other.getImg1() == null : this.getImg1().equals(other.getImg1()))
            && (this.getImg2() == null ? other.getImg2() == null : this.getImg2().equals(other.getImg2()))
            && (this.getImg3() == null ? other.getImg3() == null : this.getImg3().equals(other.getImg3()))
            && (this.getImg4() == null ? other.getImg4() == null : this.getImg4().equals(other.getImg4()))
            && (this.getImg5() == null ? other.getImg5() == null : this.getImg5().equals(other.getImg5()))
            && (this.getImg6() == null ? other.getImg6() == null : this.getImg6().equals(other.getImg6()))
            && (this.getImg7() == null ? other.getImg7() == null : this.getImg7().equals(other.getImg7()))
            && (this.getImg8() == null ? other.getImg8() == null : this.getImg8().equals(other.getImg8()))
            && (this.getImg9() == null ? other.getImg9() == null : this.getImg9().equals(other.getImg9()))
            && (this.getShowStatus() == null ? other.getShowStatus() == null : this.getShowStatus().equals(other.getShowStatus()))
            && (this.getCheckOperator() == null ? other.getCheckOperator() == null : this.getCheckOperator().equals(other.getCheckOperator()))
            && (this.getPrizeType() == null ? other.getPrizeType() == null : this.getPrizeType().equals(other.getPrizeType()))
            && (this.getPrizeCount() == null ? other.getPrizeCount() == null : this.getPrizeCount().equals(other.getPrizeCount()));
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
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getShowTitle() == null) ? 0 : getShowTitle().hashCode());
        result = prime * result + ((getDetail() == null) ? 0 : getDetail().hashCode());
        result = prime * result + ((getImg1() == null) ? 0 : getImg1().hashCode());
        result = prime * result + ((getImg2() == null) ? 0 : getImg2().hashCode());
        result = prime * result + ((getImg3() == null) ? 0 : getImg3().hashCode());
        result = prime * result + ((getImg4() == null) ? 0 : getImg4().hashCode());
        result = prime * result + ((getImg5() == null) ? 0 : getImg5().hashCode());
        result = prime * result + ((getImg6() == null) ? 0 : getImg6().hashCode());
        result = prime * result + ((getImg7() == null) ? 0 : getImg7().hashCode());
        result = prime * result + ((getImg8() == null) ? 0 : getImg8().hashCode());
        result = prime * result + ((getImg9() == null) ? 0 : getImg9().hashCode());
        result = prime * result + ((getShowStatus() == null) ? 0 : getShowStatus().hashCode());
        result = prime * result + ((getCheckOperator() == null) ? 0 : getCheckOperator().hashCode());
        result = prime * result + ((getPrizeType() == null) ? 0 : getPrizeType().hashCode());
        result = prime * result + ((getPrizeCount() == null) ? 0 : getPrizeCount().hashCode());
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
        sb.append(", itemId=").append(itemId);
        sb.append(", orderId=").append(orderId);
        sb.append(", showTitle=").append(showTitle);
        sb.append(", detail=").append(detail);
        sb.append(", img1=").append(img1);
        sb.append(", img2=").append(img2);
        sb.append(", img3=").append(img3);
        sb.append(", img4=").append(img4);
        sb.append(", img5=").append(img5);
        sb.append(", img6=").append(img6);
        sb.append(", img7=").append(img7);
        sb.append(", img8=").append(img8);
        sb.append(", img9=").append(img9);
        sb.append(", showStatus=").append(showStatus);
        sb.append(", checkOperator=").append(checkOperator);
        sb.append(", prizeType=").append(prizeType);
        sb.append(", prizeCount=").append(prizeCount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
package com.hndl.cn.dao.system.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * system_notice_person_home
 * @author 
 */
public class SystemNoticePersonHomeDo implements Serializable {
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
     * 未读消息数目（常见问题）
     */
    private Integer normalQuestionCount;

    /**
     * 未读消息数目（检查更新）
     */
    private Integer productVersionUpdateCount;

    /**
     * 未读消息数目（关于芒果互动）
     */
    private Integer aboutMangguohudongCount;

    /**
     * 未读消息数目（最新消息）
     */
    private Integer laststInfoCount;

    /**
     * 未读消息数目（互动记录）
     */
    private Integer interactRecordCount;

    /**
     * 未读消息数目（夺宝记录）
     */
    private Integer shopRecordCount;

    /**
     * 未读消息数目（中奖纪录）
     */
    private Integer luckyRecordCount;

    /**
     * 未读消息数目（晒单记录）
     */
    private Integer shopOrderShowInfoRecordCount;

    /**
     * 未读消息数目（积分交易记录）
     */
    private Integer beanCoinCount;

    /**
     * 未读消息数目（芒果币交易记录）
     */
    private Integer shopCount;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 最新消息页面（未读的点赞消息统计数）
     */
    private Integer goodCount;

    /**
     * 最新消息页面（未读的评论回复的消息统计数）
     */
    private Integer commentCount;

    /**
     * 未读消息数目（公益-爱心交易记录）
     */
    private Integer welfareCount;

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

    public Integer getNormalQuestionCount() {
        return normalQuestionCount;
    }

    public void setNormalQuestionCount(Integer normalQuestionCount) {
        this.normalQuestionCount = normalQuestionCount;
    }

    public Integer getProductVersionUpdateCount() {
        return productVersionUpdateCount;
    }

    public void setProductVersionUpdateCount(Integer productVersionUpdateCount) {
        this.productVersionUpdateCount = productVersionUpdateCount;
    }

    public Integer getAboutMangguohudongCount() {
        return aboutMangguohudongCount;
    }

    public void setAboutMangguohudongCount(Integer aboutMangguohudongCount) {
        this.aboutMangguohudongCount = aboutMangguohudongCount;
    }

    public Integer getLaststInfoCount() {
        return laststInfoCount;
    }

    public void setLaststInfoCount(Integer laststInfoCount) {
        this.laststInfoCount = laststInfoCount;
    }

    public Integer getInteractRecordCount() {
        return interactRecordCount;
    }

    public void setInteractRecordCount(Integer interactRecordCount) {
        this.interactRecordCount = interactRecordCount;
    }

    public Integer getShopRecordCount() {
        return shopRecordCount;
    }

    public void setShopRecordCount(Integer shopRecordCount) {
        this.shopRecordCount = shopRecordCount;
    }

    public Integer getLuckyRecordCount() {
        return luckyRecordCount;
    }

    public void setLuckyRecordCount(Integer luckyRecordCount) {
        this.luckyRecordCount = luckyRecordCount;
    }

    public Integer getShopOrderShowInfoRecordCount() {
        return shopOrderShowInfoRecordCount;
    }

    public void setShopOrderShowInfoRecordCount(Integer shopOrderShowInfoRecordCount) {
        this.shopOrderShowInfoRecordCount = shopOrderShowInfoRecordCount;
    }

    public Integer getBeanCoinCount() {
        return beanCoinCount;
    }

    public void setBeanCoinCount(Integer beanCoinCount) {
        this.beanCoinCount = beanCoinCount;
    }

    public Integer getShopCount() {
        return shopCount;
    }

    public void setShopCount(Integer shopCount) {
        this.shopCount = shopCount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(Integer goodCount) {
        this.goodCount = goodCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getWelfareCount() {
        return welfareCount;
    }

    public void setWelfareCount(Integer welfareCount) {
        this.welfareCount = welfareCount;
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
        SystemNoticePersonHomeDo other = (SystemNoticePersonHomeDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getNormalQuestionCount() == null ? other.getNormalQuestionCount() == null : this.getNormalQuestionCount().equals(other.getNormalQuestionCount()))
            && (this.getProductVersionUpdateCount() == null ? other.getProductVersionUpdateCount() == null : this.getProductVersionUpdateCount().equals(other.getProductVersionUpdateCount()))
            && (this.getAboutMangguohudongCount() == null ? other.getAboutMangguohudongCount() == null : this.getAboutMangguohudongCount().equals(other.getAboutMangguohudongCount()))
            && (this.getLaststInfoCount() == null ? other.getLaststInfoCount() == null : this.getLaststInfoCount().equals(other.getLaststInfoCount()))
            && (this.getInteractRecordCount() == null ? other.getInteractRecordCount() == null : this.getInteractRecordCount().equals(other.getInteractRecordCount()))
            && (this.getShopRecordCount() == null ? other.getShopRecordCount() == null : this.getShopRecordCount().equals(other.getShopRecordCount()))
            && (this.getLuckyRecordCount() == null ? other.getLuckyRecordCount() == null : this.getLuckyRecordCount().equals(other.getLuckyRecordCount()))
            && (this.getShopOrderShowInfoRecordCount() == null ? other.getShopOrderShowInfoRecordCount() == null : this.getShopOrderShowInfoRecordCount().equals(other.getShopOrderShowInfoRecordCount()))
            && (this.getBeanCoinCount() == null ? other.getBeanCoinCount() == null : this.getBeanCoinCount().equals(other.getBeanCoinCount()))
            && (this.getShopCount() == null ? other.getShopCount() == null : this.getShopCount().equals(other.getShopCount()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getGoodCount() == null ? other.getGoodCount() == null : this.getGoodCount().equals(other.getGoodCount()))
            && (this.getCommentCount() == null ? other.getCommentCount() == null : this.getCommentCount().equals(other.getCommentCount()))
            && (this.getWelfareCount() == null ? other.getWelfareCount() == null : this.getWelfareCount().equals(other.getWelfareCount()));
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
        result = prime * result + ((getNormalQuestionCount() == null) ? 0 : getNormalQuestionCount().hashCode());
        result = prime * result + ((getProductVersionUpdateCount() == null) ? 0 : getProductVersionUpdateCount().hashCode());
        result = prime * result + ((getAboutMangguohudongCount() == null) ? 0 : getAboutMangguohudongCount().hashCode());
        result = prime * result + ((getLaststInfoCount() == null) ? 0 : getLaststInfoCount().hashCode());
        result = prime * result + ((getInteractRecordCount() == null) ? 0 : getInteractRecordCount().hashCode());
        result = prime * result + ((getShopRecordCount() == null) ? 0 : getShopRecordCount().hashCode());
        result = prime * result + ((getLuckyRecordCount() == null) ? 0 : getLuckyRecordCount().hashCode());
        result = prime * result + ((getShopOrderShowInfoRecordCount() == null) ? 0 : getShopOrderShowInfoRecordCount().hashCode());
        result = prime * result + ((getBeanCoinCount() == null) ? 0 : getBeanCoinCount().hashCode());
        result = prime * result + ((getShopCount() == null) ? 0 : getShopCount().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getGoodCount() == null) ? 0 : getGoodCount().hashCode());
        result = prime * result + ((getCommentCount() == null) ? 0 : getCommentCount().hashCode());
        result = prime * result + ((getWelfareCount() == null) ? 0 : getWelfareCount().hashCode());
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
        sb.append(", normalQuestionCount=").append(normalQuestionCount);
        sb.append(", productVersionUpdateCount=").append(productVersionUpdateCount);
        sb.append(", aboutMangguohudongCount=").append(aboutMangguohudongCount);
        sb.append(", laststInfoCount=").append(laststInfoCount);
        sb.append(", interactRecordCount=").append(interactRecordCount);
        sb.append(", shopRecordCount=").append(shopRecordCount);
        sb.append(", luckyRecordCount=").append(luckyRecordCount);
        sb.append(", shopOrderShowInfoRecordCount=").append(shopOrderShowInfoRecordCount);
        sb.append(", beanCoinCount=").append(beanCoinCount);
        sb.append(", shopCount=").append(shopCount);
        sb.append(", userId=").append(userId);
        sb.append(", goodCount=").append(goodCount);
        sb.append(", commentCount=").append(commentCount);
        sb.append(", welfareCount=").append(welfareCount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
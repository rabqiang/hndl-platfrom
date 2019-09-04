package com.hndl.cn.dao.game.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * game_question_info
 * @author 
 */
public class GameQuestionInfoDo implements Serializable {
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
     * 题目的主标题
     */
    private String title;

    /**
     * 二级标题
     */
    private String subTitle;

    /**
     * 顺序
     */
    private Integer orderNum;

    /**
     * 子标题标签
     */
    private String subTitleTag;

    /**
     * 图片
     */
    private String imgUrl;

    /**
     * 类型：single/multiple
     */
    private String type;

    /**
     * 答案：选项id,如果是多选，用英文的逗号隔开
     */
    private String answerId;

    /**
     * 题目类型: 汉语/体育/历史/哲学/文学
     */
    private String propertyType;

    /**
     * 单位：秒
     */
    private Integer limitTimeLong;

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

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getSubTitleTag() {
        return subTitleTag;
    }

    public void setSubTitleTag(String subTitleTag) {
        this.subTitleTag = subTitleTag;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public Integer getLimitTimeLong() {
        return limitTimeLong;
    }

    public void setLimitTimeLong(Integer limitTimeLong) {
        this.limitTimeLong = limitTimeLong;
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
        GameQuestionInfoDo other = (GameQuestionInfoDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getSubTitle() == null ? other.getSubTitle() == null : this.getSubTitle().equals(other.getSubTitle()))
            && (this.getOrderNum() == null ? other.getOrderNum() == null : this.getOrderNum().equals(other.getOrderNum()))
            && (this.getSubTitleTag() == null ? other.getSubTitleTag() == null : this.getSubTitleTag().equals(other.getSubTitleTag()))
            && (this.getImgUrl() == null ? other.getImgUrl() == null : this.getImgUrl().equals(other.getImgUrl()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getAnswerId() == null ? other.getAnswerId() == null : this.getAnswerId().equals(other.getAnswerId()))
            && (this.getPropertyType() == null ? other.getPropertyType() == null : this.getPropertyType().equals(other.getPropertyType()))
            && (this.getLimitTimeLong() == null ? other.getLimitTimeLong() == null : this.getLimitTimeLong().equals(other.getLimitTimeLong()));
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
        result = prime * result + ((getSubTitle() == null) ? 0 : getSubTitle().hashCode());
        result = prime * result + ((getOrderNum() == null) ? 0 : getOrderNum().hashCode());
        result = prime * result + ((getSubTitleTag() == null) ? 0 : getSubTitleTag().hashCode());
        result = prime * result + ((getImgUrl() == null) ? 0 : getImgUrl().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getAnswerId() == null) ? 0 : getAnswerId().hashCode());
        result = prime * result + ((getPropertyType() == null) ? 0 : getPropertyType().hashCode());
        result = prime * result + ((getLimitTimeLong() == null) ? 0 : getLimitTimeLong().hashCode());
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
        sb.append(", subTitle=").append(subTitle);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", subTitleTag=").append(subTitleTag);
        sb.append(", imgUrl=").append(imgUrl);
        sb.append(", type=").append(type);
        sb.append(", answerId=").append(answerId);
        sb.append(", propertyType=").append(propertyType);
        sb.append(", limitTimeLong=").append(limitTimeLong);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
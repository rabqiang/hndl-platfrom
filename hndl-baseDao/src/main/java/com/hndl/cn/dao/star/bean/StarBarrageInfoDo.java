package com.hndl.cn.dao.star.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * star_barrage_info
 * @author 
 */
public class StarBarrageInfoDo implements Serializable {
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
     * 明星ID
     */
    private Long starId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 明星头像
     */
    private String starImg;

    /**
     * 用户头像
     */
    private String userImg;

    /**
     * 明星昵称
     */
    private String starName;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 主标题
     */
    private String title;

    /**
     * 副标题
     */
    private String subTitle;

    /**
     * 内容
     */
    private String content;

    /**
     * 弹幕类型(用户、明星)
     */
    private String type;

    /**
     * 总数量
     */
    private Integer count;

    /**
     * 比心、打榜、守护、表白、召唤
     */
    private String type2;

    /**
     * 跳转地址
     */
    private String httpUrl;

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

    public Long getStarId() {
        return starId;
    }

    public void setStarId(Long starId) {
        this.starId = starId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStarImg() {
        return starImg;
    }

    public void setStarImg(String starImg) {
        this.starImg = starImg;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getStarName() {
        return starName;
    }

    public void setStarName(String starName) {
        this.starName = starName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getHttpUrl() {
        return httpUrl;
    }

    public void setHttpUrl(String httpUrl) {
        this.httpUrl = httpUrl;
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
        StarBarrageInfoDo other = (StarBarrageInfoDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getStarId() == null ? other.getStarId() == null : this.getStarId().equals(other.getStarId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getStarImg() == null ? other.getStarImg() == null : this.getStarImg().equals(other.getStarImg()))
            && (this.getUserImg() == null ? other.getUserImg() == null : this.getUserImg().equals(other.getUserImg()))
            && (this.getStarName() == null ? other.getStarName() == null : this.getStarName().equals(other.getStarName()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getSubTitle() == null ? other.getSubTitle() == null : this.getSubTitle().equals(other.getSubTitle()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getCount() == null ? other.getCount() == null : this.getCount().equals(other.getCount()))
            && (this.getType2() == null ? other.getType2() == null : this.getType2().equals(other.getType2()))
            && (this.getHttpUrl() == null ? other.getHttpUrl() == null : this.getHttpUrl().equals(other.getHttpUrl()));
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
        result = prime * result + ((getStarId() == null) ? 0 : getStarId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getStarImg() == null) ? 0 : getStarImg().hashCode());
        result = prime * result + ((getUserImg() == null) ? 0 : getUserImg().hashCode());
        result = prime * result + ((getStarName() == null) ? 0 : getStarName().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getSubTitle() == null) ? 0 : getSubTitle().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getCount() == null) ? 0 : getCount().hashCode());
        result = prime * result + ((getType2() == null) ? 0 : getType2().hashCode());
        result = prime * result + ((getHttpUrl() == null) ? 0 : getHttpUrl().hashCode());
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
        sb.append(", starId=").append(starId);
        sb.append(", userId=").append(userId);
        sb.append(", starImg=").append(starImg);
        sb.append(", userImg=").append(userImg);
        sb.append(", starName=").append(starName);
        sb.append(", userName=").append(userName);
        sb.append(", title=").append(title);
        sb.append(", subTitle=").append(subTitle);
        sb.append(", content=").append(content);
        sb.append(", type=").append(type);
        sb.append(", count=").append(count);
        sb.append(", type2=").append(type2);
        sb.append(", httpUrl=").append(httpUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
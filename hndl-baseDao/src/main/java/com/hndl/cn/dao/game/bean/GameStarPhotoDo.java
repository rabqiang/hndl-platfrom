package com.hndl.cn.dao.game.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * game_star_photo
 * @author 
 */
public class GameStarPhotoDo implements Serializable {
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
     * 用户ID
     */
    private Long userId;

    /**
     * 粉丝图片地址
     */
    private String userImgUrl;

    /**
     * 明星图片地址
     */
    private String starImgUrl;

    /**
     * 明星和粉丝图片合成的图片地址
     */
    private String allImgUrl;

    /**
     * 是否被后台抽中
     */
    private String isWin;

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

    public String getUserImgUrl() {
        return userImgUrl;
    }

    public void setUserImgUrl(String userImgUrl) {
        this.userImgUrl = userImgUrl;
    }

    public String getStarImgUrl() {
        return starImgUrl;
    }

    public void setStarImgUrl(String starImgUrl) {
        this.starImgUrl = starImgUrl;
    }

    public String getAllImgUrl() {
        return allImgUrl;
    }

    public void setAllImgUrl(String allImgUrl) {
        this.allImgUrl = allImgUrl;
    }

    public String getIsWin() {
        return isWin;
    }

    public void setIsWin(String isWin) {
        this.isWin = isWin;
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
        GameStarPhotoDo other = (GameStarPhotoDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserImgUrl() == null ? other.getUserImgUrl() == null : this.getUserImgUrl().equals(other.getUserImgUrl()))
            && (this.getStarImgUrl() == null ? other.getStarImgUrl() == null : this.getStarImgUrl().equals(other.getStarImgUrl()))
            && (this.getAllImgUrl() == null ? other.getAllImgUrl() == null : this.getAllImgUrl().equals(other.getAllImgUrl()))
            && (this.getIsWin() == null ? other.getIsWin() == null : this.getIsWin().equals(other.getIsWin()));
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
        result = prime * result + ((getUserImgUrl() == null) ? 0 : getUserImgUrl().hashCode());
        result = prime * result + ((getStarImgUrl() == null) ? 0 : getStarImgUrl().hashCode());
        result = prime * result + ((getAllImgUrl() == null) ? 0 : getAllImgUrl().hashCode());
        result = prime * result + ((getIsWin() == null) ? 0 : getIsWin().hashCode());
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
        sb.append(", userImgUrl=").append(userImgUrl);
        sb.append(", starImgUrl=").append(starImgUrl);
        sb.append(", allImgUrl=").append(allImgUrl);
        sb.append(", isWin=").append(isWin);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
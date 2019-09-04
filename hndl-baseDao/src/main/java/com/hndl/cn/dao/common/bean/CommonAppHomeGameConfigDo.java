package com.hndl.cn.dao.common.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * common_app_home_game_config
 * @author 
 */
public class CommonAppHomeGameConfigDo implements Serializable {
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
     * 游戏id
     */
    private Long gameId;

    /**
     * 排序（值越大排在越前面）
     */
    private Integer orderNum;

    /**
     * 调整类型（h5/column/video/live）
     */
    private String redirectType;

    private String redirectUrl1;

    private String redirectUrl2;

    /**
     * homeHot/homeGame
     */
    private String model;

    private String homeImgUrl;

    /**
     * 节目/游戏(game/library)
     */
    private String type;

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

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getRedirectType() {
        return redirectType;
    }

    public void setRedirectType(String redirectType) {
        this.redirectType = redirectType;
    }

    public String getRedirectUrl1() {
        return redirectUrl1;
    }

    public void setRedirectUrl1(String redirectUrl1) {
        this.redirectUrl1 = redirectUrl1;
    }

    public String getRedirectUrl2() {
        return redirectUrl2;
    }

    public void setRedirectUrl2(String redirectUrl2) {
        this.redirectUrl2 = redirectUrl2;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getHomeImgUrl() {
        return homeImgUrl;
    }

    public void setHomeImgUrl(String homeImgUrl) {
        this.homeImgUrl = homeImgUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        CommonAppHomeGameConfigDo other = (CommonAppHomeGameConfigDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getGameId() == null ? other.getGameId() == null : this.getGameId().equals(other.getGameId()))
            && (this.getOrderNum() == null ? other.getOrderNum() == null : this.getOrderNum().equals(other.getOrderNum()))
            && (this.getRedirectType() == null ? other.getRedirectType() == null : this.getRedirectType().equals(other.getRedirectType()))
            && (this.getRedirectUrl1() == null ? other.getRedirectUrl1() == null : this.getRedirectUrl1().equals(other.getRedirectUrl1()))
            && (this.getRedirectUrl2() == null ? other.getRedirectUrl2() == null : this.getRedirectUrl2().equals(other.getRedirectUrl2()))
            && (this.getModel() == null ? other.getModel() == null : this.getModel().equals(other.getModel()))
            && (this.getHomeImgUrl() == null ? other.getHomeImgUrl() == null : this.getHomeImgUrl().equals(other.getHomeImgUrl()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()));
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
        result = prime * result + ((getGameId() == null) ? 0 : getGameId().hashCode());
        result = prime * result + ((getOrderNum() == null) ? 0 : getOrderNum().hashCode());
        result = prime * result + ((getRedirectType() == null) ? 0 : getRedirectType().hashCode());
        result = prime * result + ((getRedirectUrl1() == null) ? 0 : getRedirectUrl1().hashCode());
        result = prime * result + ((getRedirectUrl2() == null) ? 0 : getRedirectUrl2().hashCode());
        result = prime * result + ((getModel() == null) ? 0 : getModel().hashCode());
        result = prime * result + ((getHomeImgUrl() == null) ? 0 : getHomeImgUrl().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
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
        sb.append(", gameId=").append(gameId);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", redirectType=").append(redirectType);
        sb.append(", redirectUrl1=").append(redirectUrl1);
        sb.append(", redirectUrl2=").append(redirectUrl2);
        sb.append(", model=").append(model);
        sb.append(", homeImgUrl=").append(homeImgUrl);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
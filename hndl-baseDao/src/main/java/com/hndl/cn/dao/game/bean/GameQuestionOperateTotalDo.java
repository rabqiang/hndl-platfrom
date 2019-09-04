package com.hndl.cn.dao.game.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * game_question_operate_total
 * @author 
 */
public class GameQuestionOperateTotalDo implements Serializable {
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
     * 用户_id
     */
    private Long userId;

    /**
     * 主题_id(废弃)
     */
    private Long themeId;

    /**
     * 分数总和
     */
    private Integer sumTotal;

    /**
     * 等级：abc
     */
    private String levelTotal;

    /**
     * 用户用时多少
     */
    private Integer userTime;

    /**
     * 答对的题数
     */
    private Integer rigthCount;

    /**
     * 答错的题数
     */
    private Integer errorCount;

    /**
     * 总题数
     */
    private Integer allCount;

    /**
     * 朋友加油的分
     */
    private Integer friendCount;

    private Long gameId;

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

    public Long getThemeId() {
        return themeId;
    }

    public void setThemeId(Long themeId) {
        this.themeId = themeId;
    }

    public Integer getSumTotal() {
        return sumTotal;
    }

    public void setSumTotal(Integer sumTotal) {
        this.sumTotal = sumTotal;
    }

    public String getLevelTotal() {
        return levelTotal;
    }

    public void setLevelTotal(String levelTotal) {
        this.levelTotal = levelTotal;
    }

    public Integer getUserTime() {
        return userTime;
    }

    public void setUserTime(Integer userTime) {
        this.userTime = userTime;
    }

    public Integer getRigthCount() {
        return rigthCount;
    }

    public void setRigthCount(Integer rigthCount) {
        this.rigthCount = rigthCount;
    }

    public Integer getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(Integer errorCount) {
        this.errorCount = errorCount;
    }

    public Integer getAllCount() {
        return allCount;
    }

    public void setAllCount(Integer allCount) {
        this.allCount = allCount;
    }

    public Integer getFriendCount() {
        return friendCount;
    }

    public void setFriendCount(Integer friendCount) {
        this.friendCount = friendCount;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
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
        GameQuestionOperateTotalDo other = (GameQuestionOperateTotalDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getThemeId() == null ? other.getThemeId() == null : this.getThemeId().equals(other.getThemeId()))
            && (this.getSumTotal() == null ? other.getSumTotal() == null : this.getSumTotal().equals(other.getSumTotal()))
            && (this.getLevelTotal() == null ? other.getLevelTotal() == null : this.getLevelTotal().equals(other.getLevelTotal()))
            && (this.getUserTime() == null ? other.getUserTime() == null : this.getUserTime().equals(other.getUserTime()))
            && (this.getRigthCount() == null ? other.getRigthCount() == null : this.getRigthCount().equals(other.getRigthCount()))
            && (this.getErrorCount() == null ? other.getErrorCount() == null : this.getErrorCount().equals(other.getErrorCount()))
            && (this.getAllCount() == null ? other.getAllCount() == null : this.getAllCount().equals(other.getAllCount()))
            && (this.getFriendCount() == null ? other.getFriendCount() == null : this.getFriendCount().equals(other.getFriendCount()))
            && (this.getGameId() == null ? other.getGameId() == null : this.getGameId().equals(other.getGameId()));
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
        result = prime * result + ((getThemeId() == null) ? 0 : getThemeId().hashCode());
        result = prime * result + ((getSumTotal() == null) ? 0 : getSumTotal().hashCode());
        result = prime * result + ((getLevelTotal() == null) ? 0 : getLevelTotal().hashCode());
        result = prime * result + ((getUserTime() == null) ? 0 : getUserTime().hashCode());
        result = prime * result + ((getRigthCount() == null) ? 0 : getRigthCount().hashCode());
        result = prime * result + ((getErrorCount() == null) ? 0 : getErrorCount().hashCode());
        result = prime * result + ((getAllCount() == null) ? 0 : getAllCount().hashCode());
        result = prime * result + ((getFriendCount() == null) ? 0 : getFriendCount().hashCode());
        result = prime * result + ((getGameId() == null) ? 0 : getGameId().hashCode());
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
        sb.append(", themeId=").append(themeId);
        sb.append(", sumTotal=").append(sumTotal);
        sb.append(", levelTotal=").append(levelTotal);
        sb.append(", userTime=").append(userTime);
        sb.append(", rigthCount=").append(rigthCount);
        sb.append(", errorCount=").append(errorCount);
        sb.append(", allCount=").append(allCount);
        sb.append(", friendCount=").append(friendCount);
        sb.append(", gameId=").append(gameId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
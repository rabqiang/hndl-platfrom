package com.hndl.cn.dao.game.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * game_star_vote_express
 * @author 
 */
public class GameStarVoteExpressDo implements Serializable {
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
     * 星明id
     */
    private Long starId;

    /**
     * 户用id
     */
    private Long userId;

    /**
     * 累计经验值
     */
    private Long expressCount;

    /**
     * 续连助力天数
     */
    private Integer continueVoteDay;

    /**
     * 粉丝头衔
     */
    private String titleFans;

    /**
     * 用户查看这个明星的记录时间
     */
    private String other1;

    /**
     * 是否关注（n/y）
     */
    private String other2;

    /**
     * 关注时间
     */
    private Date other3;

    /**
     * 跨年期间第一期时间内获得的贡献总值
     */
    private Long newyearExpressOne;

    /**
     * 跨年期间第二期时间内获得的贡献总值
     */
    private Long newyearExpressTwo;

    /**
     * 关注次数(与是否关注字段有联系)
     */
    private Integer followCount;

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

    public Long getExpressCount() {
        return expressCount;
    }

    public void setExpressCount(Long expressCount) {
        this.expressCount = expressCount;
    }

    public Integer getContinueVoteDay() {
        return continueVoteDay;
    }

    public void setContinueVoteDay(Integer continueVoteDay) {
        this.continueVoteDay = continueVoteDay;
    }

    public String getTitleFans() {
        return titleFans;
    }

    public void setTitleFans(String titleFans) {
        this.titleFans = titleFans;
    }

    public String getOther1() {
        return other1;
    }

    public void setOther1(String other1) {
        this.other1 = other1;
    }

    public String getOther2() {
        return other2;
    }

    public void setOther2(String other2) {
        this.other2 = other2;
    }

    public Date getOther3() {
        return other3;
    }

    public void setOther3(Date other3) {
        this.other3 = other3;
    }

    public Long getNewyearExpressOne() {
        return newyearExpressOne;
    }

    public void setNewyearExpressOne(Long newyearExpressOne) {
        this.newyearExpressOne = newyearExpressOne;
    }

    public Long getNewyearExpressTwo() {
        return newyearExpressTwo;
    }

    public void setNewyearExpressTwo(Long newyearExpressTwo) {
        this.newyearExpressTwo = newyearExpressTwo;
    }

    public Integer getFollowCount() {
        return followCount;
    }

    public void setFollowCount(Integer followCount) {
        this.followCount = followCount;
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
        GameStarVoteExpressDo other = (GameStarVoteExpressDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getStarId() == null ? other.getStarId() == null : this.getStarId().equals(other.getStarId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getExpressCount() == null ? other.getExpressCount() == null : this.getExpressCount().equals(other.getExpressCount()))
            && (this.getContinueVoteDay() == null ? other.getContinueVoteDay() == null : this.getContinueVoteDay().equals(other.getContinueVoteDay()))
            && (this.getTitleFans() == null ? other.getTitleFans() == null : this.getTitleFans().equals(other.getTitleFans()))
            && (this.getOther1() == null ? other.getOther1() == null : this.getOther1().equals(other.getOther1()))
            && (this.getOther2() == null ? other.getOther2() == null : this.getOther2().equals(other.getOther2()))
            && (this.getOther3() == null ? other.getOther3() == null : this.getOther3().equals(other.getOther3()))
            && (this.getNewyearExpressOne() == null ? other.getNewyearExpressOne() == null : this.getNewyearExpressOne().equals(other.getNewyearExpressOne()))
            && (this.getNewyearExpressTwo() == null ? other.getNewyearExpressTwo() == null : this.getNewyearExpressTwo().equals(other.getNewyearExpressTwo()))
            && (this.getFollowCount() == null ? other.getFollowCount() == null : this.getFollowCount().equals(other.getFollowCount()));
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
        result = prime * result + ((getExpressCount() == null) ? 0 : getExpressCount().hashCode());
        result = prime * result + ((getContinueVoteDay() == null) ? 0 : getContinueVoteDay().hashCode());
        result = prime * result + ((getTitleFans() == null) ? 0 : getTitleFans().hashCode());
        result = prime * result + ((getOther1() == null) ? 0 : getOther1().hashCode());
        result = prime * result + ((getOther2() == null) ? 0 : getOther2().hashCode());
        result = prime * result + ((getOther3() == null) ? 0 : getOther3().hashCode());
        result = prime * result + ((getNewyearExpressOne() == null) ? 0 : getNewyearExpressOne().hashCode());
        result = prime * result + ((getNewyearExpressTwo() == null) ? 0 : getNewyearExpressTwo().hashCode());
        result = prime * result + ((getFollowCount() == null) ? 0 : getFollowCount().hashCode());
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
        sb.append(", expressCount=").append(expressCount);
        sb.append(", continueVoteDay=").append(continueVoteDay);
        sb.append(", titleFans=").append(titleFans);
        sb.append(", other1=").append(other1);
        sb.append(", other2=").append(other2);
        sb.append(", other3=").append(other3);
        sb.append(", newyearExpressOne=").append(newyearExpressOne);
        sb.append(", newyearExpressTwo=").append(newyearExpressTwo);
        sb.append(", followCount=").append(followCount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
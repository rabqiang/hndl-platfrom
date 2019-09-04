package com.hndl.cn.dao.star.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * star_fans_experience_count
 * @author 
 */
public class StarRankRecordDo implements Serializable {
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
     * 明星ID
     */
    private Long starId;

    /**
     * 总经验值
     */
    private Integer voteCount;

    /**
     * 统计日期（2017-05、2017年第32周/2017-05-02/2017-05-02 20）
     */
    private String countDate;

    /**
     * 统计类型（周榜、月榜、日榜）（week/month/day）
     */
    private String countType;

    /**
     * 统计开始时间
     */
    private String other1;

    /**
     * 统计结束时间
     */
    private String other2;

    /**
     * 名次
     */
    private String other3;

    /**
     * 明星姓名
     */
    private String starName;

    /**
     * 明星头像
     */
    private String starImg;

    /**
     * 榜单时间，精确到天
     */
    private Long rankTime;

    /**
     * 送心票数
     */
    private Integer coinCount;

    /**
     * 积分打榜
     */
    private Integer integralCount;

    /**
     * 爱心票数
     */
    private Integer gettingLoveCount;

    /**
     * 当前排名
     */
    private Integer currentRank;

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

    public Long getStarId() {
        return starId;
    }

    public void setStarId(Long starId) {
        this.starId = starId;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public String getCountDate() {
        return countDate;
    }

    public void setCountDate(String countDate) {
        this.countDate = countDate;
    }

    public String getCountType() {
        return countType;
    }

    public void setCountType(String countType) {
        this.countType = countType;
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

    public String getOther3() {
        return other3;
    }

    public void setOther3(String other3) {
        this.other3 = other3;
    }

    public String getStarName() {
        return starName;
    }

    public void setStarName(String starName) {
        this.starName = starName;
    }

    public String getStarImg() {
        return starImg;
    }

    public void setStarImg(String starImg) {
        this.starImg = starImg;
    }

    public Long getRankTime() {
        return rankTime;
    }

    public void setRankTime(Long rankTime) {
        this.rankTime = rankTime;
    }

    public Integer getCoinCount() {
        return coinCount;
    }

    public void setCoinCount(Integer coinCount) {
        this.coinCount = coinCount;
    }

    public Integer getIntegralCount() {
        return integralCount;
    }

    public void setIntegralCount(Integer integralCount) {
        this.integralCount = integralCount;
    }

    public Integer getGettingLoveCount() {
        return gettingLoveCount;
    }

    public void setGettingLoveCount(Integer gettingLoveCount) {
        this.gettingLoveCount = gettingLoveCount;
    }

    public Integer getCurrentRank() {
        return currentRank;
    }

    public void setCurrentRank(Integer currentRank) {
        this.currentRank = currentRank;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StarRankRecordDo that = (StarRankRecordDo) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(isDeleted, that.isDeleted) &&
                Objects.equals(createOperator, that.createOperator) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(lastOperator, that.lastOperator) &&
                Objects.equals(lastModifyTime, that.lastModifyTime) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(starId, that.starId) &&
                Objects.equals(voteCount, that.voteCount) &&
                Objects.equals(countDate, that.countDate) &&
                Objects.equals(countType, that.countType) &&
                Objects.equals(other1, that.other1) &&
                Objects.equals(other2, that.other2) &&
                Objects.equals(other3, that.other3) &&
                Objects.equals(starName, that.starName) &&
                Objects.equals(starImg, that.starImg) &&
                Objects.equals(rankTime, that.rankTime) &&
                Objects.equals(coinCount, that.coinCount) &&
                Objects.equals(integralCount, that.integralCount) &&
                Objects.equals(gettingLoveCount, that.gettingLoveCount) &&
                Objects.equals(currentRank, that.currentRank);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, isDeleted, createOperator, createTime, lastOperator, lastModifyTime, userId, starId, voteCount, countDate, countType, other1, other2, other3, starName, starImg, rankTime, coinCount, integralCount, gettingLoveCount, currentRank);
    }

    @Override
    public String toString() {
        return "StarRankRecordDo{" +
                "id=" + id +
                ", isDeleted='" + isDeleted + '\'' +
                ", createOperator='" + createOperator + '\'' +
                ", createTime=" + createTime +
                ", lastOperator='" + lastOperator + '\'' +
                ", lastModifyTime=" + lastModifyTime +
                ", userId=" + userId +
                ", starId=" + starId +
                ", voteCount=" + voteCount +
                ", countDate='" + countDate + '\'' +
                ", countType='" + countType + '\'' +
                ", other1='" + other1 + '\'' +
                ", other2='" + other2 + '\'' +
                ", other3='" + other3 + '\'' +
                ", starName='" + starName + '\'' +
                ", starImg='" + starImg + '\'' +
                ", rankTime=" + rankTime +
                ", coinCount=" + coinCount +
                ", integralCount=" + integralCount +
                ", gettingLoveCount=" + gettingLoveCount +
                ", currentRank=" + currentRank +
                '}';
    }
}
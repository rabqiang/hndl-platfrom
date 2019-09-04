package com.hndl.cn.dao.game.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * game_star_vote
 * @author 
 */
public class GameStarVoteDo implements Serializable {
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
     * 姓名
     */
    private String name;

    /**
     * 头像图片的地址
     */
    private String headUrl;

    /**
     * 总票数
     */
    private Long voteCount;

    /**
     * 总投票人数
     */
    private Long votePersonCount;

    /**
     * 游戏id
     */
    private String other1;

    /**
     * 排序值
     */
    private String other2;

    /**
     * 明星类型
     */
    private String other3;

    /**
     * 评分五个星
     */
    private Double startScore;

    /**
     * 投票数
     */
    private Double weekVoteCount;

    /**
     * 表白数量
     */
    private Double weekExpressCount;

    /**
     * 送心数量
     */
    private Double weekGiveCount;

    /**
     * 守护数量
     */
    private Double weekGuardCount;

    /**
     * 召唤分享
     */
    private Double weekShareScore;

    /**
     * 每日爱心值
     */
    private Double weekWelfareScore;

    /**
     * 会长id
     */
    private Long presidentUserId;

    /**
     * 5个总分
     */
    private Double allCount;

    /**
     * 性别:女/男（F/M）
     */
    private String sex;

    /**
     * 明星语录(描述）
     */
    private String bak2;

    /**
     * 是否参与18年跨年
     */
    private String bak3;

    /**
     * 对粉丝的称呼
     */
    private String bak4;

    /**
     * 明星热搜数
     */
    private Integer bak5;

    /**
     * 最厉害粉丝的userId
     */
    private Long maxUserId;

    /**
     * 最厉害粉丝的昵称
     */
    private String maxUserName;

    /**
     * 最厉害粉丝的头像
     */
    private String maxUserImg;

    /**
     * 最厉害粉丝的投票次数
     */
    private Integer maxUserVoteCount;

    /**
     * 最厉害粉丝的粉丝级别
     */
    private Integer maxUserLevel;

    /**
     * 最新打call评论内容
     */
    private String newCall;

    /**
     * 最新的call时间
     */
    private Date newCallTime;

    /**
     * 最新call的id
     */
    private Long newCallId;

    /**
     * 粉丝会id
     */
    private Long fanId;

    /**
     * 守护数
     */
    private Long guardCount;

    /**
     * 点赞数
     */
    private Long goodCount;

    /**
     * 2019跨年时间段的打榜总票数(第一期),具体时间段待定
     */
    private Long newyearVoteOne;

    /**
     * 是否为搜索页的推荐明星
     */
    private String isRecommend;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public Long getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Long voteCount) {
        this.voteCount = voteCount;
    }

    public Long getVotePersonCount() {
        return votePersonCount;
    }

    public void setVotePersonCount(Long votePersonCount) {
        this.votePersonCount = votePersonCount;
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

    public Double getStartScore() {
        return startScore;
    }

    public void setStartScore(Double startScore) {
        this.startScore = startScore;
    }

    public Double getWeekVoteCount() {
        return weekVoteCount;
    }

    public void setWeekVoteCount(Double weekVoteCount) {
        this.weekVoteCount = weekVoteCount;
    }

    public Double getWeekExpressCount() {
        return weekExpressCount;
    }

    public void setWeekExpressCount(Double weekExpressCount) {
        this.weekExpressCount = weekExpressCount;
    }

    public Double getWeekGiveCount() {
        return weekGiveCount;
    }

    public void setWeekGiveCount(Double weekGiveCount) {
        this.weekGiveCount = weekGiveCount;
    }

    public Double getWeekGuardCount() {
        return weekGuardCount;
    }

    public void setWeekGuardCount(Double weekGuardCount) {
        this.weekGuardCount = weekGuardCount;
    }

    public Double getWeekShareScore() {
        return weekShareScore;
    }

    public void setWeekShareScore(Double weekShareScore) {
        this.weekShareScore = weekShareScore;
    }

    public Double getWeekWelfareScore() {
        return weekWelfareScore;
    }

    public void setWeekWelfareScore(Double weekWelfareScore) {
        this.weekWelfareScore = weekWelfareScore;
    }

    public Long getPresidentUserId() {
        return presidentUserId;
    }

    public void setPresidentUserId(Long presidentUserId) {
        this.presidentUserId = presidentUserId;
    }

    public Double getAllCount() {
        return allCount;
    }

    public void setAllCount(Double allCount) {
        this.allCount = allCount;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBak2() {
        return bak2;
    }

    public void setBak2(String bak2) {
        this.bak2 = bak2;
    }

    public String getBak3() {
        return bak3;
    }

    public void setBak3(String bak3) {
        this.bak3 = bak3;
    }

    public String getBak4() {
        return bak4;
    }

    public void setBak4(String bak4) {
        this.bak4 = bak4;
    }

    public Integer getBak5() {
        return bak5;
    }

    public void setBak5(Integer bak5) {
        this.bak5 = bak5;
    }

    public Long getMaxUserId() {
        return maxUserId;
    }

    public void setMaxUserId(Long maxUserId) {
        this.maxUserId = maxUserId;
    }

    public String getMaxUserName() {
        return maxUserName;
    }

    public void setMaxUserName(String maxUserName) {
        this.maxUserName = maxUserName;
    }

    public String getMaxUserImg() {
        return maxUserImg;
    }

    public void setMaxUserImg(String maxUserImg) {
        this.maxUserImg = maxUserImg;
    }

    public Integer getMaxUserVoteCount() {
        return maxUserVoteCount;
    }

    public void setMaxUserVoteCount(Integer maxUserVoteCount) {
        this.maxUserVoteCount = maxUserVoteCount;
    }

    public Integer getMaxUserLevel() {
        return maxUserLevel;
    }

    public void setMaxUserLevel(Integer maxUserLevel) {
        this.maxUserLevel = maxUserLevel;
    }

    public String getNewCall() {
        return newCall;
    }

    public void setNewCall(String newCall) {
        this.newCall = newCall;
    }

    public Date getNewCallTime() {
        return newCallTime;
    }

    public void setNewCallTime(Date newCallTime) {
        this.newCallTime = newCallTime;
    }

    public Long getNewCallId() {
        return newCallId;
    }

    public void setNewCallId(Long newCallId) {
        this.newCallId = newCallId;
    }

    public Long getFanId() {
        return fanId;
    }

    public void setFanId(Long fanId) {
        this.fanId = fanId;
    }

    public Long getGuardCount() {
        return guardCount;
    }

    public void setGuardCount(Long guardCount) {
        this.guardCount = guardCount;
    }

    public Long getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(Long goodCount) {
        this.goodCount = goodCount;
    }

    public Long getNewyearVoteOne() {
        return newyearVoteOne;
    }

    public void setNewyearVoteOne(Long newyearVoteOne) {
        this.newyearVoteOne = newyearVoteOne;
    }

    public String getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(String isRecommend) {
        this.isRecommend = isRecommend;
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
        GameStarVoteDo other = (GameStarVoteDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getHeadUrl() == null ? other.getHeadUrl() == null : this.getHeadUrl().equals(other.getHeadUrl()))
            && (this.getVoteCount() == null ? other.getVoteCount() == null : this.getVoteCount().equals(other.getVoteCount()))
            && (this.getVotePersonCount() == null ? other.getVotePersonCount() == null : this.getVotePersonCount().equals(other.getVotePersonCount()))
            && (this.getOther1() == null ? other.getOther1() == null : this.getOther1().equals(other.getOther1()))
            && (this.getOther2() == null ? other.getOther2() == null : this.getOther2().equals(other.getOther2()))
            && (this.getOther3() == null ? other.getOther3() == null : this.getOther3().equals(other.getOther3()))
            && (this.getStartScore() == null ? other.getStartScore() == null : this.getStartScore().equals(other.getStartScore()))
            && (this.getWeekVoteCount() == null ? other.getWeekVoteCount() == null : this.getWeekVoteCount().equals(other.getWeekVoteCount()))
            && (this.getWeekExpressCount() == null ? other.getWeekExpressCount() == null : this.getWeekExpressCount().equals(other.getWeekExpressCount()))
            && (this.getWeekGiveCount() == null ? other.getWeekGiveCount() == null : this.getWeekGiveCount().equals(other.getWeekGiveCount()))
            && (this.getWeekGuardCount() == null ? other.getWeekGuardCount() == null : this.getWeekGuardCount().equals(other.getWeekGuardCount()))
            && (this.getWeekShareScore() == null ? other.getWeekShareScore() == null : this.getWeekShareScore().equals(other.getWeekShareScore()))
            && (this.getWeekWelfareScore() == null ? other.getWeekWelfareScore() == null : this.getWeekWelfareScore().equals(other.getWeekWelfareScore()))
            && (this.getPresidentUserId() == null ? other.getPresidentUserId() == null : this.getPresidentUserId().equals(other.getPresidentUserId()))
            && (this.getAllCount() == null ? other.getAllCount() == null : this.getAllCount().equals(other.getAllCount()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getBak2() == null ? other.getBak2() == null : this.getBak2().equals(other.getBak2()))
            && (this.getBak3() == null ? other.getBak3() == null : this.getBak3().equals(other.getBak3()))
            && (this.getBak4() == null ? other.getBak4() == null : this.getBak4().equals(other.getBak4()))
            && (this.getBak5() == null ? other.getBak5() == null : this.getBak5().equals(other.getBak5()))
            && (this.getMaxUserId() == null ? other.getMaxUserId() == null : this.getMaxUserId().equals(other.getMaxUserId()))
            && (this.getMaxUserName() == null ? other.getMaxUserName() == null : this.getMaxUserName().equals(other.getMaxUserName()))
            && (this.getMaxUserImg() == null ? other.getMaxUserImg() == null : this.getMaxUserImg().equals(other.getMaxUserImg()))
            && (this.getMaxUserVoteCount() == null ? other.getMaxUserVoteCount() == null : this.getMaxUserVoteCount().equals(other.getMaxUserVoteCount()))
            && (this.getMaxUserLevel() == null ? other.getMaxUserLevel() == null : this.getMaxUserLevel().equals(other.getMaxUserLevel()))
            && (this.getNewCall() == null ? other.getNewCall() == null : this.getNewCall().equals(other.getNewCall()))
            && (this.getNewCallTime() == null ? other.getNewCallTime() == null : this.getNewCallTime().equals(other.getNewCallTime()))
            && (this.getNewCallId() == null ? other.getNewCallId() == null : this.getNewCallId().equals(other.getNewCallId()))
            && (this.getFanId() == null ? other.getFanId() == null : this.getFanId().equals(other.getFanId()))
            && (this.getGuardCount() == null ? other.getGuardCount() == null : this.getGuardCount().equals(other.getGuardCount()))
            && (this.getGoodCount() == null ? other.getGoodCount() == null : this.getGoodCount().equals(other.getGoodCount()))
            && (this.getNewyearVoteOne() == null ? other.getNewyearVoteOne() == null : this.getNewyearVoteOne().equals(other.getNewyearVoteOne()))
            && (this.getIsRecommend() == null ? other.getIsRecommend() == null : this.getIsRecommend().equals(other.getIsRecommend()));
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
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getHeadUrl() == null) ? 0 : getHeadUrl().hashCode());
        result = prime * result + ((getVoteCount() == null) ? 0 : getVoteCount().hashCode());
        result = prime * result + ((getVotePersonCount() == null) ? 0 : getVotePersonCount().hashCode());
        result = prime * result + ((getOther1() == null) ? 0 : getOther1().hashCode());
        result = prime * result + ((getOther2() == null) ? 0 : getOther2().hashCode());
        result = prime * result + ((getOther3() == null) ? 0 : getOther3().hashCode());
        result = prime * result + ((getStartScore() == null) ? 0 : getStartScore().hashCode());
        result = prime * result + ((getWeekVoteCount() == null) ? 0 : getWeekVoteCount().hashCode());
        result = prime * result + ((getWeekExpressCount() == null) ? 0 : getWeekExpressCount().hashCode());
        result = prime * result + ((getWeekGiveCount() == null) ? 0 : getWeekGiveCount().hashCode());
        result = prime * result + ((getWeekGuardCount() == null) ? 0 : getWeekGuardCount().hashCode());
        result = prime * result + ((getWeekShareScore() == null) ? 0 : getWeekShareScore().hashCode());
        result = prime * result + ((getWeekWelfareScore() == null) ? 0 : getWeekWelfareScore().hashCode());
        result = prime * result + ((getPresidentUserId() == null) ? 0 : getPresidentUserId().hashCode());
        result = prime * result + ((getAllCount() == null) ? 0 : getAllCount().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getBak2() == null) ? 0 : getBak2().hashCode());
        result = prime * result + ((getBak3() == null) ? 0 : getBak3().hashCode());
        result = prime * result + ((getBak4() == null) ? 0 : getBak4().hashCode());
        result = prime * result + ((getBak5() == null) ? 0 : getBak5().hashCode());
        result = prime * result + ((getMaxUserId() == null) ? 0 : getMaxUserId().hashCode());
        result = prime * result + ((getMaxUserName() == null) ? 0 : getMaxUserName().hashCode());
        result = prime * result + ((getMaxUserImg() == null) ? 0 : getMaxUserImg().hashCode());
        result = prime * result + ((getMaxUserVoteCount() == null) ? 0 : getMaxUserVoteCount().hashCode());
        result = prime * result + ((getMaxUserLevel() == null) ? 0 : getMaxUserLevel().hashCode());
        result = prime * result + ((getNewCall() == null) ? 0 : getNewCall().hashCode());
        result = prime * result + ((getNewCallTime() == null) ? 0 : getNewCallTime().hashCode());
        result = prime * result + ((getNewCallId() == null) ? 0 : getNewCallId().hashCode());
        result = prime * result + ((getFanId() == null) ? 0 : getFanId().hashCode());
        result = prime * result + ((getGuardCount() == null) ? 0 : getGuardCount().hashCode());
        result = prime * result + ((getGoodCount() == null) ? 0 : getGoodCount().hashCode());
        result = prime * result + ((getNewyearVoteOne() == null) ? 0 : getNewyearVoteOne().hashCode());
        result = prime * result + ((getIsRecommend() == null) ? 0 : getIsRecommend().hashCode());
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
        sb.append(", name=").append(name);
        sb.append(", headUrl=").append(headUrl);
        sb.append(", voteCount=").append(voteCount);
        sb.append(", votePersonCount=").append(votePersonCount);
        sb.append(", other1=").append(other1);
        sb.append(", other2=").append(other2);
        sb.append(", other3=").append(other3);
        sb.append(", startScore=").append(startScore);
        sb.append(", weekVoteCount=").append(weekVoteCount);
        sb.append(", weekExpressCount=").append(weekExpressCount);
        sb.append(", weekGiveCount=").append(weekGiveCount);
        sb.append(", weekGuardCount=").append(weekGuardCount);
        sb.append(", weekShareScore=").append(weekShareScore);
        sb.append(", weekWelfareScore=").append(weekWelfareScore);
        sb.append(", presidentUserId=").append(presidentUserId);
        sb.append(", allCount=").append(allCount);
        sb.append(", sex=").append(sex);
        sb.append(", bak2=").append(bak2);
        sb.append(", bak3=").append(bak3);
        sb.append(", bak4=").append(bak4);
        sb.append(", bak5=").append(bak5);
        sb.append(", maxUserId=").append(maxUserId);
        sb.append(", maxUserName=").append(maxUserName);
        sb.append(", maxUserImg=").append(maxUserImg);
        sb.append(", maxUserVoteCount=").append(maxUserVoteCount);
        sb.append(", maxUserLevel=").append(maxUserLevel);
        sb.append(", newCall=").append(newCall);
        sb.append(", newCallTime=").append(newCallTime);
        sb.append(", newCallId=").append(newCallId);
        sb.append(", fanId=").append(fanId);
        sb.append(", guardCount=").append(guardCount);
        sb.append(", goodCount=").append(goodCount);
        sb.append(", newyearVoteOne=").append(newyearVoteOne);
        sb.append(", isRecommend=").append(isRecommend);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
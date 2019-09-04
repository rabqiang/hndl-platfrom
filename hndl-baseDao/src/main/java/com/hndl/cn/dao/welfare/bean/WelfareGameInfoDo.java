package com.hndl.cn.dao.welfare.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * welfare_game_info
 * @author 
 */
public class WelfareGameInfoDo implements Serializable {
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
     * 游戏名称
     */
    private String title;

    /**
     * 游戏图片
     */
    private String imgUrl;

    /**
     * 玩的总人次
     */
    private Long playCount;

    /**
     * 奖品的跳转地址
     */
    private String rewardToUrl;

    /**
     * 游戏规则页面
     */
    private String descToUrl;

    /**
     * 游戏的跳转地址
     */
    private String toUrl;

    /**
     * 游戏的状态(ing,ok,fail)
     */
    private String state;

    /**
     * 挑战成功后奖励的积分
     */
    private Long reviveDoudouCount;

    /**
     * 奖励的爱心票数
     */
    private Long rewardHeart;

    /**
     * 达到限制的奖励游戏分数
     */
    private Long restrictScore;

    /**
     * 排行榜头部图片地址
     */
    private String other1;

    /**
     * 复活需要的积分
     */
    private String other2;

    /**
     * 排序
     */
    private Integer other3;

    /**
     * me/zhangmeng(自己的、第三方的)
     */
    private String type;

    /**
     * CP方分配给运营方的账号
     */
    private String email;

    /**
     * 第三方给我们的游戏地址
     */
    private String thriyGameUrl;

    /**
     * 第三方游戏需要我们的渠道名称
     */
    private String channelExt;

    /**
     * 第三方游戏支付成功后，我们平台调用这个第三方回调接口通知他们
     */
    private String payCallbackUrl;

    /**
     * 第三方游戏的key
     */
    private String gameKey;

    /**
     * 是否显示挑战
     */
    private String isShowChallenge;

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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Long getPlayCount() {
        return playCount;
    }

    public void setPlayCount(Long playCount) {
        this.playCount = playCount;
    }

    public String getRewardToUrl() {
        return rewardToUrl;
    }

    public void setRewardToUrl(String rewardToUrl) {
        this.rewardToUrl = rewardToUrl;
    }

    public String getDescToUrl() {
        return descToUrl;
    }

    public void setDescToUrl(String descToUrl) {
        this.descToUrl = descToUrl;
    }

    public String getToUrl() {
        return toUrl;
    }

    public void setToUrl(String toUrl) {
        this.toUrl = toUrl;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getReviveDoudouCount() {
        return reviveDoudouCount;
    }

    public void setReviveDoudouCount(Long reviveDoudouCount) {
        this.reviveDoudouCount = reviveDoudouCount;
    }

    public Long getRewardHeart() {
        return rewardHeart;
    }

    public void setRewardHeart(Long rewardHeart) {
        this.rewardHeart = rewardHeart;
    }

    public Long getRestrictScore() {
        return restrictScore;
    }

    public void setRestrictScore(Long restrictScore) {
        this.restrictScore = restrictScore;
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

    public Integer getOther3() {
        return other3;
    }

    public void setOther3(Integer other3) {
        this.other3 = other3;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getThriyGameUrl() {
        return thriyGameUrl;
    }

    public void setThriyGameUrl(String thriyGameUrl) {
        this.thriyGameUrl = thriyGameUrl;
    }

    public String getChannelExt() {
        return channelExt;
    }

    public void setChannelExt(String channelExt) {
        this.channelExt = channelExt;
    }

    public String getPayCallbackUrl() {
        return payCallbackUrl;
    }

    public void setPayCallbackUrl(String payCallbackUrl) {
        this.payCallbackUrl = payCallbackUrl;
    }

    public String getGameKey() {
        return gameKey;
    }

    public void setGameKey(String gameKey) {
        this.gameKey = gameKey;
    }

    public String getIsShowChallenge() {
        return isShowChallenge;
    }

    public void setIsShowChallenge(String isShowChallenge) {
        this.isShowChallenge = isShowChallenge;
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
        WelfareGameInfoDo other = (WelfareGameInfoDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getImgUrl() == null ? other.getImgUrl() == null : this.getImgUrl().equals(other.getImgUrl()))
            && (this.getPlayCount() == null ? other.getPlayCount() == null : this.getPlayCount().equals(other.getPlayCount()))
            && (this.getRewardToUrl() == null ? other.getRewardToUrl() == null : this.getRewardToUrl().equals(other.getRewardToUrl()))
            && (this.getDescToUrl() == null ? other.getDescToUrl() == null : this.getDescToUrl().equals(other.getDescToUrl()))
            && (this.getToUrl() == null ? other.getToUrl() == null : this.getToUrl().equals(other.getToUrl()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getReviveDoudouCount() == null ? other.getReviveDoudouCount() == null : this.getReviveDoudouCount().equals(other.getReviveDoudouCount()))
            && (this.getRewardHeart() == null ? other.getRewardHeart() == null : this.getRewardHeart().equals(other.getRewardHeart()))
            && (this.getRestrictScore() == null ? other.getRestrictScore() == null : this.getRestrictScore().equals(other.getRestrictScore()))
            && (this.getOther1() == null ? other.getOther1() == null : this.getOther1().equals(other.getOther1()))
            && (this.getOther2() == null ? other.getOther2() == null : this.getOther2().equals(other.getOther2()))
            && (this.getOther3() == null ? other.getOther3() == null : this.getOther3().equals(other.getOther3()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getThriyGameUrl() == null ? other.getThriyGameUrl() == null : this.getThriyGameUrl().equals(other.getThriyGameUrl()))
            && (this.getChannelExt() == null ? other.getChannelExt() == null : this.getChannelExt().equals(other.getChannelExt()))
            && (this.getPayCallbackUrl() == null ? other.getPayCallbackUrl() == null : this.getPayCallbackUrl().equals(other.getPayCallbackUrl()))
            && (this.getGameKey() == null ? other.getGameKey() == null : this.getGameKey().equals(other.getGameKey()))
            && (this.getIsShowChallenge() == null ? other.getIsShowChallenge() == null : this.getIsShowChallenge().equals(other.getIsShowChallenge()));
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
        result = prime * result + ((getImgUrl() == null) ? 0 : getImgUrl().hashCode());
        result = prime * result + ((getPlayCount() == null) ? 0 : getPlayCount().hashCode());
        result = prime * result + ((getRewardToUrl() == null) ? 0 : getRewardToUrl().hashCode());
        result = prime * result + ((getDescToUrl() == null) ? 0 : getDescToUrl().hashCode());
        result = prime * result + ((getToUrl() == null) ? 0 : getToUrl().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getReviveDoudouCount() == null) ? 0 : getReviveDoudouCount().hashCode());
        result = prime * result + ((getRewardHeart() == null) ? 0 : getRewardHeart().hashCode());
        result = prime * result + ((getRestrictScore() == null) ? 0 : getRestrictScore().hashCode());
        result = prime * result + ((getOther1() == null) ? 0 : getOther1().hashCode());
        result = prime * result + ((getOther2() == null) ? 0 : getOther2().hashCode());
        result = prime * result + ((getOther3() == null) ? 0 : getOther3().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getThriyGameUrl() == null) ? 0 : getThriyGameUrl().hashCode());
        result = prime * result + ((getChannelExt() == null) ? 0 : getChannelExt().hashCode());
        result = prime * result + ((getPayCallbackUrl() == null) ? 0 : getPayCallbackUrl().hashCode());
        result = prime * result + ((getGameKey() == null) ? 0 : getGameKey().hashCode());
        result = prime * result + ((getIsShowChallenge() == null) ? 0 : getIsShowChallenge().hashCode());
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
        sb.append(", imgUrl=").append(imgUrl);
        sb.append(", playCount=").append(playCount);
        sb.append(", rewardToUrl=").append(rewardToUrl);
        sb.append(", descToUrl=").append(descToUrl);
        sb.append(", toUrl=").append(toUrl);
        sb.append(", state=").append(state);
        sb.append(", reviveDoudouCount=").append(reviveDoudouCount);
        sb.append(", rewardHeart=").append(rewardHeart);
        sb.append(", restrictScore=").append(restrictScore);
        sb.append(", other1=").append(other1);
        sb.append(", other2=").append(other2);
        sb.append(", other3=").append(other3);
        sb.append(", type=").append(type);
        sb.append(", email=").append(email);
        sb.append(", thriyGameUrl=").append(thriyGameUrl);
        sb.append(", channelExt=").append(channelExt);
        sb.append(", payCallbackUrl=").append(payCallbackUrl);
        sb.append(", gameKey=").append(gameKey);
        sb.append(", isShowChallenge=").append(isShowChallenge);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
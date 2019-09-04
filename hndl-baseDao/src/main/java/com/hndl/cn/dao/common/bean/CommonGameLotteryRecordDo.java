package com.hndl.cn.dao.common.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * common_game_lottery_record
 * @author 
 */
public class CommonGameLotteryRecordDo implements Serializable {
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
     * 活动id
     */
    private Long gameId;

    /**
     * 这个游戏的期数
     */
    private Integer section;

    /**
     * 奖品id
     */
    private Long prizeId;

    /**
     * 是否中奖
     */
    private String isWin;

    /**
     * 玩游戏日期
     */
    private Date createDate;

    /**
     * 是否线下运营人员已经给用户发货了
     */
    private String isGivePrize;

    /**
     * 是不是免费玩的
     */
    private String isFreePlay;

    /**
     * 是否是游客模式下玩的
     */
    private String isVisitor;

    /**
     * 设备号用于游客模式
     */
    private String deviceNumber;

    /**
     * 是否确认收货
     */
    private String isGetPrize;

    /**
     * 投票投的common_vote_info表的id
     */
    private Long voteId;

    /**
     * 竞猜游戏投的A队还是B队：请填写A/B
     */
    private String groupName;

    /**
     * 竞猜记录id （hudong_game_guess_info的id）
     */
    private Long guessInfoId;

    /**
     * 是不是过期确认地址，用户过来15天后还未确认地址，将作废
     */
    private String isCofirmAddrOutDate;

    /**
     * 支付的订单id，对应的money表的id
     */
    private String payOrderId;

    /**
     * 明星投票记录id
     */
    private Long startRecordId;

    /**
     * 是否是明星投票的游戏
     */
    private String isStartVote;

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

    public Integer getSection() {
        return section;
    }

    public void setSection(Integer section) {
        this.section = section;
    }

    public Long getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Long prizeId) {
        this.prizeId = prizeId;
    }

    public String getIsWin() {
        return isWin;
    }

    public void setIsWin(String isWin) {
        this.isWin = isWin;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getIsGivePrize() {
        return isGivePrize;
    }

    public void setIsGivePrize(String isGivePrize) {
        this.isGivePrize = isGivePrize;
    }

    public String getIsFreePlay() {
        return isFreePlay;
    }

    public void setIsFreePlay(String isFreePlay) {
        this.isFreePlay = isFreePlay;
    }

    public String getIsVisitor() {
        return isVisitor;
    }

    public void setIsVisitor(String isVisitor) {
        this.isVisitor = isVisitor;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public String getIsGetPrize() {
        return isGetPrize;
    }

    public void setIsGetPrize(String isGetPrize) {
        this.isGetPrize = isGetPrize;
    }

    public Long getVoteId() {
        return voteId;
    }

    public void setVoteId(Long voteId) {
        this.voteId = voteId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Long getGuessInfoId() {
        return guessInfoId;
    }

    public void setGuessInfoId(Long guessInfoId) {
        this.guessInfoId = guessInfoId;
    }

    public String getIsCofirmAddrOutDate() {
        return isCofirmAddrOutDate;
    }

    public void setIsCofirmAddrOutDate(String isCofirmAddrOutDate) {
        this.isCofirmAddrOutDate = isCofirmAddrOutDate;
    }

    public String getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId;
    }

    public Long getStartRecordId() {
        return startRecordId;
    }

    public void setStartRecordId(Long startRecordId) {
        this.startRecordId = startRecordId;
    }

    public String getIsStartVote() {
        return isStartVote;
    }

    public void setIsStartVote(String isStartVote) {
        this.isStartVote = isStartVote;
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
        CommonGameLotteryRecordDo other = (CommonGameLotteryRecordDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getGameId() == null ? other.getGameId() == null : this.getGameId().equals(other.getGameId()))
            && (this.getSection() == null ? other.getSection() == null : this.getSection().equals(other.getSection()))
            && (this.getPrizeId() == null ? other.getPrizeId() == null : this.getPrizeId().equals(other.getPrizeId()))
            && (this.getIsWin() == null ? other.getIsWin() == null : this.getIsWin().equals(other.getIsWin()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getIsGivePrize() == null ? other.getIsGivePrize() == null : this.getIsGivePrize().equals(other.getIsGivePrize()))
            && (this.getIsFreePlay() == null ? other.getIsFreePlay() == null : this.getIsFreePlay().equals(other.getIsFreePlay()))
            && (this.getIsVisitor() == null ? other.getIsVisitor() == null : this.getIsVisitor().equals(other.getIsVisitor()))
            && (this.getDeviceNumber() == null ? other.getDeviceNumber() == null : this.getDeviceNumber().equals(other.getDeviceNumber()))
            && (this.getIsGetPrize() == null ? other.getIsGetPrize() == null : this.getIsGetPrize().equals(other.getIsGetPrize()))
            && (this.getVoteId() == null ? other.getVoteId() == null : this.getVoteId().equals(other.getVoteId()))
            && (this.getGroupName() == null ? other.getGroupName() == null : this.getGroupName().equals(other.getGroupName()))
            && (this.getGuessInfoId() == null ? other.getGuessInfoId() == null : this.getGuessInfoId().equals(other.getGuessInfoId()))
            && (this.getIsCofirmAddrOutDate() == null ? other.getIsCofirmAddrOutDate() == null : this.getIsCofirmAddrOutDate().equals(other.getIsCofirmAddrOutDate()))
            && (this.getPayOrderId() == null ? other.getPayOrderId() == null : this.getPayOrderId().equals(other.getPayOrderId()))
            && (this.getStartRecordId() == null ? other.getStartRecordId() == null : this.getStartRecordId().equals(other.getStartRecordId()))
            && (this.getIsStartVote() == null ? other.getIsStartVote() == null : this.getIsStartVote().equals(other.getIsStartVote()));
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
        result = prime * result + ((getSection() == null) ? 0 : getSection().hashCode());
        result = prime * result + ((getPrizeId() == null) ? 0 : getPrizeId().hashCode());
        result = prime * result + ((getIsWin() == null) ? 0 : getIsWin().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getIsGivePrize() == null) ? 0 : getIsGivePrize().hashCode());
        result = prime * result + ((getIsFreePlay() == null) ? 0 : getIsFreePlay().hashCode());
        result = prime * result + ((getIsVisitor() == null) ? 0 : getIsVisitor().hashCode());
        result = prime * result + ((getDeviceNumber() == null) ? 0 : getDeviceNumber().hashCode());
        result = prime * result + ((getIsGetPrize() == null) ? 0 : getIsGetPrize().hashCode());
        result = prime * result + ((getVoteId() == null) ? 0 : getVoteId().hashCode());
        result = prime * result + ((getGroupName() == null) ? 0 : getGroupName().hashCode());
        result = prime * result + ((getGuessInfoId() == null) ? 0 : getGuessInfoId().hashCode());
        result = prime * result + ((getIsCofirmAddrOutDate() == null) ? 0 : getIsCofirmAddrOutDate().hashCode());
        result = prime * result + ((getPayOrderId() == null) ? 0 : getPayOrderId().hashCode());
        result = prime * result + ((getStartRecordId() == null) ? 0 : getStartRecordId().hashCode());
        result = prime * result + ((getIsStartVote() == null) ? 0 : getIsStartVote().hashCode());
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
        sb.append(", section=").append(section);
        sb.append(", prizeId=").append(prizeId);
        sb.append(", isWin=").append(isWin);
        sb.append(", createDate=").append(createDate);
        sb.append(", isGivePrize=").append(isGivePrize);
        sb.append(", isFreePlay=").append(isFreePlay);
        sb.append(", isVisitor=").append(isVisitor);
        sb.append(", deviceNumber=").append(deviceNumber);
        sb.append(", isGetPrize=").append(isGetPrize);
        sb.append(", voteId=").append(voteId);
        sb.append(", groupName=").append(groupName);
        sb.append(", guessInfoId=").append(guessInfoId);
        sb.append(", isCofirmAddrOutDate=").append(isCofirmAddrOutDate);
        sb.append(", payOrderId=").append(payOrderId);
        sb.append(", startRecordId=").append(startRecordId);
        sb.append(", isStartVote=").append(isStartVote);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
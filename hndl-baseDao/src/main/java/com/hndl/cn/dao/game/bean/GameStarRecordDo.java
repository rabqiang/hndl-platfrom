package com.hndl.cn.dao.game.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * game_star_record
 * @author 
 */
public class GameStarRecordDo implements Serializable {
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
     * 明星id
     */
    private Long starId;

    /**
     * 投票数
     */
    private Integer voteNum;

    /**
     * 被扣积分数
     */
    private Integer doudouNum;

    /**
     * 总投票数
     */
    private Integer countNum;

    /**
     * 投票类型
     */
    private String voteShare;

    private Integer getExpress;

    private Long gameRecordId;

    private String isWin;

    /**
     * 是否弹幕（是 y/ 否 n）
     */
    private String isBarrage;

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

    public Integer getVoteNum() {
        return voteNum;
    }

    public void setVoteNum(Integer voteNum) {
        this.voteNum = voteNum;
    }

    public Integer getDoudouNum() {
        return doudouNum;
    }

    public void setDoudouNum(Integer doudouNum) {
        this.doudouNum = doudouNum;
    }

    public Integer getCountNum() {
        return countNum;
    }

    public void setCountNum(Integer countNum) {
        this.countNum = countNum;
    }

    public String getVoteShare() {
        return voteShare;
    }

    public void setVoteShare(String voteShare) {
        this.voteShare = voteShare;
    }

    public Integer getGetExpress() {
        return getExpress;
    }

    public void setGetExpress(Integer getExpress) {
        this.getExpress = getExpress;
    }

    public Long getGameRecordId() {
        return gameRecordId;
    }

    public void setGameRecordId(Long gameRecordId) {
        this.gameRecordId = gameRecordId;
    }

    public String getIsWin() {
        return isWin;
    }

    public void setIsWin(String isWin) {
        this.isWin = isWin;
    }

    public String getIsBarrage() {
        return isBarrage;
    }

    public void setIsBarrage(String isBarrage) {
        this.isBarrage = isBarrage;
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
        GameStarRecordDo other = (GameStarRecordDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getStarId() == null ? other.getStarId() == null : this.getStarId().equals(other.getStarId()))
            && (this.getVoteNum() == null ? other.getVoteNum() == null : this.getVoteNum().equals(other.getVoteNum()))
            && (this.getDoudouNum() == null ? other.getDoudouNum() == null : this.getDoudouNum().equals(other.getDoudouNum()))
            && (this.getCountNum() == null ? other.getCountNum() == null : this.getCountNum().equals(other.getCountNum()))
            && (this.getVoteShare() == null ? other.getVoteShare() == null : this.getVoteShare().equals(other.getVoteShare()))
            && (this.getGetExpress() == null ? other.getGetExpress() == null : this.getGetExpress().equals(other.getGetExpress()))
            && (this.getGameRecordId() == null ? other.getGameRecordId() == null : this.getGameRecordId().equals(other.getGameRecordId()))
            && (this.getIsWin() == null ? other.getIsWin() == null : this.getIsWin().equals(other.getIsWin()))
            && (this.getIsBarrage() == null ? other.getIsBarrage() == null : this.getIsBarrage().equals(other.getIsBarrage()));
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
        result = prime * result + ((getStarId() == null) ? 0 : getStarId().hashCode());
        result = prime * result + ((getVoteNum() == null) ? 0 : getVoteNum().hashCode());
        result = prime * result + ((getDoudouNum() == null) ? 0 : getDoudouNum().hashCode());
        result = prime * result + ((getCountNum() == null) ? 0 : getCountNum().hashCode());
        result = prime * result + ((getVoteShare() == null) ? 0 : getVoteShare().hashCode());
        result = prime * result + ((getGetExpress() == null) ? 0 : getGetExpress().hashCode());
        result = prime * result + ((getGameRecordId() == null) ? 0 : getGameRecordId().hashCode());
        result = prime * result + ((getIsWin() == null) ? 0 : getIsWin().hashCode());
        result = prime * result + ((getIsBarrage() == null) ? 0 : getIsBarrage().hashCode());
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
        sb.append(", starId=").append(starId);
        sb.append(", voteNum=").append(voteNum);
        sb.append(", doudouNum=").append(doudouNum);
        sb.append(", countNum=").append(countNum);
        sb.append(", voteShare=").append(voteShare);
        sb.append(", getExpress=").append(getExpress);
        sb.append(", gameRecordId=").append(gameRecordId);
        sb.append(", isWin=").append(isWin);
        sb.append(", isBarrage=").append(isBarrage);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
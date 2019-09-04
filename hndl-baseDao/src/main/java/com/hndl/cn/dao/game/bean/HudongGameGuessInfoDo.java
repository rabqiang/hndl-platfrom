package com.hndl.cn.dao.game.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * hudong_game_guess_info
 * @author 
 */
public class HudongGameGuessInfoDo implements Serializable {
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
     * 图-题目
     */
    private String title;

    /**
     * 图-答案1
     */
    private String titleSub;

    /**
     * 图-答案2
     */
    private String aImgUrl;

    /**
     * 图-答案3
     */
    private String aName;

    /**
     * A队票数
     */
    private String aVoteCount;

    private String bImgUrl;

    private String bName;

    /**
     * B队票数
     */
    private String bVoteCount;

    /**
     * 游戏的id
     */
    private Long gameId;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 跳转地址
     */
    private String directAddress;

    /**
     * 跳转类型：h5/itemDetail/live/video/videoList/hudongHome/shopHome/none
     */
    private String directType;

    private Integer orderNum;

    /**
     * 跳转标题
     */
    private String directTitle;

    /**
     * 初始的投票次数
     */
    private Integer initACount;

    /**
     * 初始的投票次数
     */
    private Integer initBCount;

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

    public String getTitleSub() {
        return titleSub;
    }

    public void setTitleSub(String titleSub) {
        this.titleSub = titleSub;
    }

    public String getaImgUrl() {
        return aImgUrl;
    }

    public void setaImgUrl(String aImgUrl) {
        this.aImgUrl = aImgUrl;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaVoteCount() {
        return aVoteCount;
    }

    public void setaVoteCount(String aVoteCount) {
        this.aVoteCount = aVoteCount;
    }

    public String getbImgUrl() {
        return bImgUrl;
    }

    public void setbImgUrl(String bImgUrl) {
        this.bImgUrl = bImgUrl;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getbVoteCount() {
        return bVoteCount;
    }

    public void setbVoteCount(String bVoteCount) {
        this.bVoteCount = bVoteCount;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDirectAddress() {
        return directAddress;
    }

    public void setDirectAddress(String directAddress) {
        this.directAddress = directAddress;
    }

    public String getDirectType() {
        return directType;
    }

    public void setDirectType(String directType) {
        this.directType = directType;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getDirectTitle() {
        return directTitle;
    }

    public void setDirectTitle(String directTitle) {
        this.directTitle = directTitle;
    }

    public Integer getInitACount() {
        return initACount;
    }

    public void setInitACount(Integer initACount) {
        this.initACount = initACount;
    }

    public Integer getInitBCount() {
        return initBCount;
    }

    public void setInitBCount(Integer initBCount) {
        this.initBCount = initBCount;
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
        HudongGameGuessInfoDo other = (HudongGameGuessInfoDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getTitleSub() == null ? other.getTitleSub() == null : this.getTitleSub().equals(other.getTitleSub()))
            && (this.getaImgUrl() == null ? other.getaImgUrl() == null : this.getaImgUrl().equals(other.getaImgUrl()))
            && (this.getaName() == null ? other.getaName() == null : this.getaName().equals(other.getaName()))
            && (this.getaVoteCount() == null ? other.getaVoteCount() == null : this.getaVoteCount().equals(other.getaVoteCount()))
            && (this.getbImgUrl() == null ? other.getbImgUrl() == null : this.getbImgUrl().equals(other.getbImgUrl()))
            && (this.getbName() == null ? other.getbName() == null : this.getbName().equals(other.getbName()))
            && (this.getbVoteCount() == null ? other.getbVoteCount() == null : this.getbVoteCount().equals(other.getbVoteCount()))
            && (this.getGameId() == null ? other.getGameId() == null : this.getGameId().equals(other.getGameId()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getDirectAddress() == null ? other.getDirectAddress() == null : this.getDirectAddress().equals(other.getDirectAddress()))
            && (this.getDirectType() == null ? other.getDirectType() == null : this.getDirectType().equals(other.getDirectType()))
            && (this.getOrderNum() == null ? other.getOrderNum() == null : this.getOrderNum().equals(other.getOrderNum()))
            && (this.getDirectTitle() == null ? other.getDirectTitle() == null : this.getDirectTitle().equals(other.getDirectTitle()))
            && (this.getInitACount() == null ? other.getInitACount() == null : this.getInitACount().equals(other.getInitACount()))
            && (this.getInitBCount() == null ? other.getInitBCount() == null : this.getInitBCount().equals(other.getInitBCount()));
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
        result = prime * result + ((getTitleSub() == null) ? 0 : getTitleSub().hashCode());
        result = prime * result + ((getaImgUrl() == null) ? 0 : getaImgUrl().hashCode());
        result = prime * result + ((getaName() == null) ? 0 : getaName().hashCode());
        result = prime * result + ((getaVoteCount() == null) ? 0 : getaVoteCount().hashCode());
        result = prime * result + ((getbImgUrl() == null) ? 0 : getbImgUrl().hashCode());
        result = prime * result + ((getbName() == null) ? 0 : getbName().hashCode());
        result = prime * result + ((getbVoteCount() == null) ? 0 : getbVoteCount().hashCode());
        result = prime * result + ((getGameId() == null) ? 0 : getGameId().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getDirectAddress() == null) ? 0 : getDirectAddress().hashCode());
        result = prime * result + ((getDirectType() == null) ? 0 : getDirectType().hashCode());
        result = prime * result + ((getOrderNum() == null) ? 0 : getOrderNum().hashCode());
        result = prime * result + ((getDirectTitle() == null) ? 0 : getDirectTitle().hashCode());
        result = prime * result + ((getInitACount() == null) ? 0 : getInitACount().hashCode());
        result = prime * result + ((getInitBCount() == null) ? 0 : getInitBCount().hashCode());
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
        sb.append(", titleSub=").append(titleSub);
        sb.append(", aImgUrl=").append(aImgUrl);
        sb.append(", aName=").append(aName);
        sb.append(", aVoteCount=").append(aVoteCount);
        sb.append(", bImgUrl=").append(bImgUrl);
        sb.append(", bName=").append(bName);
        sb.append(", bVoteCount=").append(bVoteCount);
        sb.append(", gameId=").append(gameId);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", directAddress=").append(directAddress);
        sb.append(", directType=").append(directType);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", directTitle=").append(directTitle);
        sb.append(", initACount=").append(initACount);
        sb.append(", initBCount=").append(initBCount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
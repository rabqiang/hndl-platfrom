package com.hndl.cn.dao.welfare.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * welfare_game_job_record
 * @author 
 */
public class WelfareGameJobRecordDo implements Serializable {
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
     * 用户id
     */
    private Long userId;

    /**
     * 领取状态 y/n
     */
    private String receiveState;

    /**
     * 积分数
     */
    private Integer doudou;

    /**
     * 爱心数
     */
    private Integer heart;

    /**
     * 类型  vote/share
     */
    private String type;

    /**
     * 游戏的id
     */
    private Long gameId;

    /**
     * 当前日期
     */
    private Date createDate;

    private String other1;

    private String other2;

    private String other3;

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

    public String getReceiveState() {
        return receiveState;
    }

    public void setReceiveState(String receiveState) {
        this.receiveState = receiveState;
    }

    public Integer getDoudou() {
        return doudou;
    }

    public void setDoudou(Integer doudou) {
        this.doudou = doudou;
    }

    public Integer getHeart() {
        return heart;
    }

    public void setHeart(Integer heart) {
        this.heart = heart;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
        WelfareGameJobRecordDo other = (WelfareGameJobRecordDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getReceiveState() == null ? other.getReceiveState() == null : this.getReceiveState().equals(other.getReceiveState()))
            && (this.getDoudou() == null ? other.getDoudou() == null : this.getDoudou().equals(other.getDoudou()))
            && (this.getHeart() == null ? other.getHeart() == null : this.getHeart().equals(other.getHeart()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getGameId() == null ? other.getGameId() == null : this.getGameId().equals(other.getGameId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getOther1() == null ? other.getOther1() == null : this.getOther1().equals(other.getOther1()))
            && (this.getOther2() == null ? other.getOther2() == null : this.getOther2().equals(other.getOther2()))
            && (this.getOther3() == null ? other.getOther3() == null : this.getOther3().equals(other.getOther3()));
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
        result = prime * result + ((getReceiveState() == null) ? 0 : getReceiveState().hashCode());
        result = prime * result + ((getDoudou() == null) ? 0 : getDoudou().hashCode());
        result = prime * result + ((getHeart() == null) ? 0 : getHeart().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getGameId() == null) ? 0 : getGameId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getOther1() == null) ? 0 : getOther1().hashCode());
        result = prime * result + ((getOther2() == null) ? 0 : getOther2().hashCode());
        result = prime * result + ((getOther3() == null) ? 0 : getOther3().hashCode());
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
        sb.append(", receiveState=").append(receiveState);
        sb.append(", doudou=").append(doudou);
        sb.append(", heart=").append(heart);
        sb.append(", type=").append(type);
        sb.append(", gameId=").append(gameId);
        sb.append(", createDate=").append(createDate);
        sb.append(", other1=").append(other1);
        sb.append(", other2=").append(other2);
        sb.append(", other3=").append(other3);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
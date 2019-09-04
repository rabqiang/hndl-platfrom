package com.hndl.cn.dao.imsinger.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * imsinger_who_come_record
 * @author 
 */
public class ImsingerWhoComeRecordDo implements Serializable {
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
     * 竞猜歌手ID
     */
    private Long voteSingerId1;

    /**
     * 竞猜歌手ID
     */
    private Long voteSingerId2;

    /**
     * 竞猜歌手ID
     */
    private Long voteSingerId3;

    /**
     * 竞猜歌手ID
     */
    private Long voteSingerId4;

    /**
     * 竞猜歌手ID
     */
    private Long voteSingerId5;

    /**
     * 竞猜歌手ID
     */
    private Long voteSingerId6;

    /**
     * 竞猜歌手ID
     */
    private Long voteSingerId7;

    /**
     * 日期
     */
    private Date createDate;

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

    public Long getVoteSingerId1() {
        return voteSingerId1;
    }

    public void setVoteSingerId1(Long voteSingerId1) {
        this.voteSingerId1 = voteSingerId1;
    }

    public Long getVoteSingerId2() {
        return voteSingerId2;
    }

    public void setVoteSingerId2(Long voteSingerId2) {
        this.voteSingerId2 = voteSingerId2;
    }

    public Long getVoteSingerId3() {
        return voteSingerId3;
    }

    public void setVoteSingerId3(Long voteSingerId3) {
        this.voteSingerId3 = voteSingerId3;
    }

    public Long getVoteSingerId4() {
        return voteSingerId4;
    }

    public void setVoteSingerId4(Long voteSingerId4) {
        this.voteSingerId4 = voteSingerId4;
    }

    public Long getVoteSingerId5() {
        return voteSingerId5;
    }

    public void setVoteSingerId5(Long voteSingerId5) {
        this.voteSingerId5 = voteSingerId5;
    }

    public Long getVoteSingerId6() {
        return voteSingerId6;
    }

    public void setVoteSingerId6(Long voteSingerId6) {
        this.voteSingerId6 = voteSingerId6;
    }

    public Long getVoteSingerId7() {
        return voteSingerId7;
    }

    public void setVoteSingerId7(Long voteSingerId7) {
        this.voteSingerId7 = voteSingerId7;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
        ImsingerWhoComeRecordDo other = (ImsingerWhoComeRecordDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getVoteSingerId1() == null ? other.getVoteSingerId1() == null : this.getVoteSingerId1().equals(other.getVoteSingerId1()))
            && (this.getVoteSingerId2() == null ? other.getVoteSingerId2() == null : this.getVoteSingerId2().equals(other.getVoteSingerId2()))
            && (this.getVoteSingerId3() == null ? other.getVoteSingerId3() == null : this.getVoteSingerId3().equals(other.getVoteSingerId3()))
            && (this.getVoteSingerId4() == null ? other.getVoteSingerId4() == null : this.getVoteSingerId4().equals(other.getVoteSingerId4()))
            && (this.getVoteSingerId5() == null ? other.getVoteSingerId5() == null : this.getVoteSingerId5().equals(other.getVoteSingerId5()))
            && (this.getVoteSingerId6() == null ? other.getVoteSingerId6() == null : this.getVoteSingerId6().equals(other.getVoteSingerId6()))
            && (this.getVoteSingerId7() == null ? other.getVoteSingerId7() == null : this.getVoteSingerId7().equals(other.getVoteSingerId7()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()));
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
        result = prime * result + ((getVoteSingerId1() == null) ? 0 : getVoteSingerId1().hashCode());
        result = prime * result + ((getVoteSingerId2() == null) ? 0 : getVoteSingerId2().hashCode());
        result = prime * result + ((getVoteSingerId3() == null) ? 0 : getVoteSingerId3().hashCode());
        result = prime * result + ((getVoteSingerId4() == null) ? 0 : getVoteSingerId4().hashCode());
        result = prime * result + ((getVoteSingerId5() == null) ? 0 : getVoteSingerId5().hashCode());
        result = prime * result + ((getVoteSingerId6() == null) ? 0 : getVoteSingerId6().hashCode());
        result = prime * result + ((getVoteSingerId7() == null) ? 0 : getVoteSingerId7().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
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
        sb.append(", voteSingerId1=").append(voteSingerId1);
        sb.append(", voteSingerId2=").append(voteSingerId2);
        sb.append(", voteSingerId3=").append(voteSingerId3);
        sb.append(", voteSingerId4=").append(voteSingerId4);
        sb.append(", voteSingerId5=").append(voteSingerId5);
        sb.append(", voteSingerId6=").append(voteSingerId6);
        sb.append(", voteSingerId7=").append(voteSingerId7);
        sb.append(", createDate=").append(createDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
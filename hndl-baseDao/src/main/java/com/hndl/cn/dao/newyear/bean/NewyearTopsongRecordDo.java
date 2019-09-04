package com.hndl.cn.dao.newyear.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * newyear_topsong_record
 * @author 
 */
public class NewyearTopsongRecordDo implements Serializable {
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
     * 投票歌曲Id
     */
    private Long songId1;

    /**
     * 投票歌曲Id
     */
    private Long songId2;

    /**
     * 投票歌曲Id
     */
    private Long songId3;

    /**
     * 投票歌曲Id
     */
    private Long songId4;

    /**
     * 投票歌曲Id
     */
    private Long songId5;

    /**
     * 投票歌曲Id
     */
    private Long songId6;

    /**
     * 投票歌曲Id
     */
    private Long songId7;

    /**
     * 投票歌曲Id
     */
    private Long songId8;

    /**
     * 投票歌曲Id
     */
    private Long songId9;

    /**
     * 投票歌曲Id
     */
    private Long songId10;

    /**
     * 投票日期
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

    public Long getSongId1() {
        return songId1;
    }

    public void setSongId1(Long songId1) {
        this.songId1 = songId1;
    }

    public Long getSongId2() {
        return songId2;
    }

    public void setSongId2(Long songId2) {
        this.songId2 = songId2;
    }

    public Long getSongId3() {
        return songId3;
    }

    public void setSongId3(Long songId3) {
        this.songId3 = songId3;
    }

    public Long getSongId4() {
        return songId4;
    }

    public void setSongId4(Long songId4) {
        this.songId4 = songId4;
    }

    public Long getSongId5() {
        return songId5;
    }

    public void setSongId5(Long songId5) {
        this.songId5 = songId5;
    }

    public Long getSongId6() {
        return songId6;
    }

    public void setSongId6(Long songId6) {
        this.songId6 = songId6;
    }

    public Long getSongId7() {
        return songId7;
    }

    public void setSongId7(Long songId7) {
        this.songId7 = songId7;
    }

    public Long getSongId8() {
        return songId8;
    }

    public void setSongId8(Long songId8) {
        this.songId8 = songId8;
    }

    public Long getSongId9() {
        return songId9;
    }

    public void setSongId9(Long songId9) {
        this.songId9 = songId9;
    }

    public Long getSongId10() {
        return songId10;
    }

    public void setSongId10(Long songId10) {
        this.songId10 = songId10;
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
        NewyearTopsongRecordDo other = (NewyearTopsongRecordDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getSongId1() == null ? other.getSongId1() == null : this.getSongId1().equals(other.getSongId1()))
            && (this.getSongId2() == null ? other.getSongId2() == null : this.getSongId2().equals(other.getSongId2()))
            && (this.getSongId3() == null ? other.getSongId3() == null : this.getSongId3().equals(other.getSongId3()))
            && (this.getSongId4() == null ? other.getSongId4() == null : this.getSongId4().equals(other.getSongId4()))
            && (this.getSongId5() == null ? other.getSongId5() == null : this.getSongId5().equals(other.getSongId5()))
            && (this.getSongId6() == null ? other.getSongId6() == null : this.getSongId6().equals(other.getSongId6()))
            && (this.getSongId7() == null ? other.getSongId7() == null : this.getSongId7().equals(other.getSongId7()))
            && (this.getSongId8() == null ? other.getSongId8() == null : this.getSongId8().equals(other.getSongId8()))
            && (this.getSongId9() == null ? other.getSongId9() == null : this.getSongId9().equals(other.getSongId9()))
            && (this.getSongId10() == null ? other.getSongId10() == null : this.getSongId10().equals(other.getSongId10()))
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
        result = prime * result + ((getSongId1() == null) ? 0 : getSongId1().hashCode());
        result = prime * result + ((getSongId2() == null) ? 0 : getSongId2().hashCode());
        result = prime * result + ((getSongId3() == null) ? 0 : getSongId3().hashCode());
        result = prime * result + ((getSongId4() == null) ? 0 : getSongId4().hashCode());
        result = prime * result + ((getSongId5() == null) ? 0 : getSongId5().hashCode());
        result = prime * result + ((getSongId6() == null) ? 0 : getSongId6().hashCode());
        result = prime * result + ((getSongId7() == null) ? 0 : getSongId7().hashCode());
        result = prime * result + ((getSongId8() == null) ? 0 : getSongId8().hashCode());
        result = prime * result + ((getSongId9() == null) ? 0 : getSongId9().hashCode());
        result = prime * result + ((getSongId10() == null) ? 0 : getSongId10().hashCode());
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
        sb.append(", songId1=").append(songId1);
        sb.append(", songId2=").append(songId2);
        sb.append(", songId3=").append(songId3);
        sb.append(", songId4=").append(songId4);
        sb.append(", songId5=").append(songId5);
        sb.append(", songId6=").append(songId6);
        sb.append(", songId7=").append(songId7);
        sb.append(", songId8=").append(songId8);
        sb.append(", songId9=").append(songId9);
        sb.append(", songId10=").append(songId10);
        sb.append(", createDate=").append(createDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
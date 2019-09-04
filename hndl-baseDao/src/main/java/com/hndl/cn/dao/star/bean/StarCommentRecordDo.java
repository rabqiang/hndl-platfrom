package com.hndl.cn.dao.star.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * star_comment_record
 * @author 
 */
public class StarCommentRecordDo implements Serializable {
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
     * 明星ID
     */
    private Long starId;

    /**
     * 评论人的id
     */
    private Long userId;

    /**
     * 回复人的ID
     */
    private Long replyUserId;

    /**
     * 评论的内容
     */
    private String commentText;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 回复的记录ID
     */
    private Long replyCommentId;

    /**
     * 子评论总数
     */
    private Integer replyCount;

    /**
     * 点赞数
     */
    private Integer goodCount;

    /**
     * 是否弹幕（是 y/ 否 n）
     */
    private String isBarrage;

    /**
     * 是否置顶
     */
    private String isTop;

    /**
     * 记录回复id，不是主call的id
     */
    private String bak1;

    private String bak2;

    private String bak3;

    /**
     * 图片数量
     */
    private Long imgCount;

    /**
     * 是否是精彩call
     */
    private String isExquisite;

    /**
     * 数据类型（normal正常、star明星）
     */
    private String type;

    /**
     * 微博圈Id
     */
    private String wId;

    /**
     * 视频数量
     */
    private Integer videoCount;

    /**
     * 分享数
     */
    private Integer shareCount;

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

    public Long getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(Long replyUserId) {
        this.replyUserId = replyUserId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getReplyCommentId() {
        return replyCommentId;
    }

    public void setReplyCommentId(Long replyCommentId) {
        this.replyCommentId = replyCommentId;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public Integer getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(Integer goodCount) {
        this.goodCount = goodCount;
    }

    public String getIsBarrage() {
        return isBarrage;
    }

    public void setIsBarrage(String isBarrage) {
        this.isBarrage = isBarrage;
    }

    public String getIsTop() {
        return isTop;
    }

    public void setIsTop(String isTop) {
        this.isTop = isTop;
    }

    public String getBak1() {
        return bak1;
    }

    public void setBak1(String bak1) {
        this.bak1 = bak1;
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

    public Long getImgCount() {
        return imgCount;
    }

    public void setImgCount(Long imgCount) {
        this.imgCount = imgCount;
    }

    public String getIsExquisite() {
        return isExquisite;
    }

    public void setIsExquisite(String isExquisite) {
        this.isExquisite = isExquisite;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getwId() {
        return wId;
    }

    public void setwId(String wId) {
        this.wId = wId;
    }

    public Integer getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(Integer videoCount) {
        this.videoCount = videoCount;
    }

    public Integer getShareCount() {
        return shareCount;
    }

    public void setShareCount(Integer shareCount) {
        this.shareCount = shareCount;
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
        StarCommentRecordDo other = (StarCommentRecordDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getStarId() == null ? other.getStarId() == null : this.getStarId().equals(other.getStarId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getReplyUserId() == null ? other.getReplyUserId() == null : this.getReplyUserId().equals(other.getReplyUserId()))
            && (this.getCommentText() == null ? other.getCommentText() == null : this.getCommentText().equals(other.getCommentText()))
            && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
            && (this.getReplyCommentId() == null ? other.getReplyCommentId() == null : this.getReplyCommentId().equals(other.getReplyCommentId()))
            && (this.getReplyCount() == null ? other.getReplyCount() == null : this.getReplyCount().equals(other.getReplyCount()))
            && (this.getGoodCount() == null ? other.getGoodCount() == null : this.getGoodCount().equals(other.getGoodCount()))
            && (this.getIsBarrage() == null ? other.getIsBarrage() == null : this.getIsBarrage().equals(other.getIsBarrage()))
            && (this.getIsTop() == null ? other.getIsTop() == null : this.getIsTop().equals(other.getIsTop()))
            && (this.getBak1() == null ? other.getBak1() == null : this.getBak1().equals(other.getBak1()))
            && (this.getBak2() == null ? other.getBak2() == null : this.getBak2().equals(other.getBak2()))
            && (this.getBak3() == null ? other.getBak3() == null : this.getBak3().equals(other.getBak3()))
            && (this.getImgCount() == null ? other.getImgCount() == null : this.getImgCount().equals(other.getImgCount()))
            && (this.getIsExquisite() == null ? other.getIsExquisite() == null : this.getIsExquisite().equals(other.getIsExquisite()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getwId() == null ? other.getwId() == null : this.getwId().equals(other.getwId()))
            && (this.getVideoCount() == null ? other.getVideoCount() == null : this.getVideoCount().equals(other.getVideoCount()))
            && (this.getShareCount() == null ? other.getShareCount() == null : this.getShareCount().equals(other.getShareCount()));
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
        result = prime * result + ((getReplyUserId() == null) ? 0 : getReplyUserId().hashCode());
        result = prime * result + ((getCommentText() == null) ? 0 : getCommentText().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getReplyCommentId() == null) ? 0 : getReplyCommentId().hashCode());
        result = prime * result + ((getReplyCount() == null) ? 0 : getReplyCount().hashCode());
        result = prime * result + ((getGoodCount() == null) ? 0 : getGoodCount().hashCode());
        result = prime * result + ((getIsBarrage() == null) ? 0 : getIsBarrage().hashCode());
        result = prime * result + ((getIsTop() == null) ? 0 : getIsTop().hashCode());
        result = prime * result + ((getBak1() == null) ? 0 : getBak1().hashCode());
        result = prime * result + ((getBak2() == null) ? 0 : getBak2().hashCode());
        result = prime * result + ((getBak3() == null) ? 0 : getBak3().hashCode());
        result = prime * result + ((getImgCount() == null) ? 0 : getImgCount().hashCode());
        result = prime * result + ((getIsExquisite() == null) ? 0 : getIsExquisite().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getwId() == null) ? 0 : getwId().hashCode());
        result = prime * result + ((getVideoCount() == null) ? 0 : getVideoCount().hashCode());
        result = prime * result + ((getShareCount() == null) ? 0 : getShareCount().hashCode());
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
        sb.append(", replyUserId=").append(replyUserId);
        sb.append(", commentText=").append(commentText);
        sb.append(", ip=").append(ip);
        sb.append(", replyCommentId=").append(replyCommentId);
        sb.append(", replyCount=").append(replyCount);
        sb.append(", goodCount=").append(goodCount);
        sb.append(", isBarrage=").append(isBarrage);
        sb.append(", isTop=").append(isTop);
        sb.append(", bak1=").append(bak1);
        sb.append(", bak2=").append(bak2);
        sb.append(", bak3=").append(bak3);
        sb.append(", imgCount=").append(imgCount);
        sb.append(", isExquisite=").append(isExquisite);
        sb.append(", type=").append(type);
        sb.append(", wId=").append(wId);
        sb.append(", videoCount=").append(videoCount);
        sb.append(", shareCount=").append(shareCount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
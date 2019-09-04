package com.hndl.cn.dao.video.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * weibo_video
 * @author 
 */
public class WeiboVideoDo implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建者id
     */
    private Long createAdmin;

    /**
     * 标题
     */
    private String title;

    /**
     * 微博展示的id
     */
    private String showId;

    /**
     * 视频图片
     */
    private String videoImg;

    /**
     * 内容
     */
    private String content;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新者id
     */
    private Long updateAdmin;

    /**
     * 排序号
     */
    private Long orderNum;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否删除
     */
    private Integer isDelete;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateAdmin() {
        return createAdmin;
    }

    public void setCreateAdmin(Long createAdmin) {
        this.createAdmin = createAdmin;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public String getVideoImg() {
        return videoImg;
    }

    public void setVideoImg(String videoImg) {
        this.videoImg = videoImg;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateAdmin() {
        return updateAdmin;
    }

    public void setUpdateAdmin(Long updateAdmin) {
        this.updateAdmin = updateAdmin;
    }

    public Long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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
        WeiboVideoDo other = (WeiboVideoDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateAdmin() == null ? other.getCreateAdmin() == null : this.getCreateAdmin().equals(other.getCreateAdmin()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getShowId() == null ? other.getShowId() == null : this.getShowId().equals(other.getShowId()))
            && (this.getVideoImg() == null ? other.getVideoImg() == null : this.getVideoImg().equals(other.getVideoImg()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdateAdmin() == null ? other.getUpdateAdmin() == null : this.getUpdateAdmin().equals(other.getUpdateAdmin()))
            && (this.getOrderNum() == null ? other.getOrderNum() == null : this.getOrderNum().equals(other.getOrderNum()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateAdmin() == null) ? 0 : getCreateAdmin().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getShowId() == null) ? 0 : getShowId().hashCode());
        result = prime * result + ((getVideoImg() == null) ? 0 : getVideoImg().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateAdmin() == null) ? 0 : getUpdateAdmin().hashCode());
        result = prime * result + ((getOrderNum() == null) ? 0 : getOrderNum().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", createAdmin=").append(createAdmin);
        sb.append(", title=").append(title);
        sb.append(", showId=").append(showId);
        sb.append(", videoImg=").append(videoImg);
        sb.append(", content=").append(content);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateAdmin=").append(updateAdmin);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", remark=").append(remark);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
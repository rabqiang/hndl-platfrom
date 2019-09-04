package com.hndl.cn.dao.system.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * t_recommend_node_info
 * @author 
 */
public class TRecommendNodeInfoDo implements Serializable {
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 栏目节点号
     */
    private String nodeid;

    /**
     * 排序号
     */
    private Integer ranking;

    /**
     * 描述
     */
    private String description;

    /**
     * 图片地址
     */
    private String picpath;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建者
     */
    private String createUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新者
     */
    private String updateUser;

    /**
     * 是否删除标记（0:没有删除，1：已删除）
     */
    private String isdelete;

    /**
     * 是否发布（0：没有发布，1：已发布）
     */
    private String ispublish;

    /**
     * 发布时间
     */
    private Date publishTime;

    /**
     * 发布者
     */
    private String publishUser;

    private String lContenttype;

    private String lNodeid;

    private String lContent;

    private String lPicpath;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNodeid() {
        return nodeid;
    }

    public void setNodeid(String nodeid) {
        this.nodeid = nodeid;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete;
    }

    public String getIspublish() {
        return ispublish;
    }

    public void setIspublish(String ispublish) {
        this.ispublish = ispublish;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getPublishUser() {
        return publishUser;
    }

    public void setPublishUser(String publishUser) {
        this.publishUser = publishUser;
    }

    public String getlContenttype() {
        return lContenttype;
    }

    public void setlContenttype(String lContenttype) {
        this.lContenttype = lContenttype;
    }

    public String getlNodeid() {
        return lNodeid;
    }

    public void setlNodeid(String lNodeid) {
        this.lNodeid = lNodeid;
    }

    public String getlContent() {
        return lContent;
    }

    public void setlContent(String lContent) {
        this.lContent = lContent;
    }

    public String getlPicpath() {
        return lPicpath;
    }

    public void setlPicpath(String lPicpath) {
        this.lPicpath = lPicpath;
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
        TRecommendNodeInfoDo other = (TRecommendNodeInfoDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getNodeid() == null ? other.getNodeid() == null : this.getNodeid().equals(other.getNodeid()))
            && (this.getRanking() == null ? other.getRanking() == null : this.getRanking().equals(other.getRanking()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getPicpath() == null ? other.getPicpath() == null : this.getPicpath().equals(other.getPicpath()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getIsdelete() == null ? other.getIsdelete() == null : this.getIsdelete().equals(other.getIsdelete()))
            && (this.getIspublish() == null ? other.getIspublish() == null : this.getIspublish().equals(other.getIspublish()))
            && (this.getPublishTime() == null ? other.getPublishTime() == null : this.getPublishTime().equals(other.getPublishTime()))
            && (this.getPublishUser() == null ? other.getPublishUser() == null : this.getPublishUser().equals(other.getPublishUser()))
            && (this.getlContenttype() == null ? other.getlContenttype() == null : this.getlContenttype().equals(other.getlContenttype()))
            && (this.getlNodeid() == null ? other.getlNodeid() == null : this.getlNodeid().equals(other.getlNodeid()))
            && (this.getlContent() == null ? other.getlContent() == null : this.getlContent().equals(other.getlContent()))
            && (this.getlPicpath() == null ? other.getlPicpath() == null : this.getlPicpath().equals(other.getlPicpath()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getNodeid() == null) ? 0 : getNodeid().hashCode());
        result = prime * result + ((getRanking() == null) ? 0 : getRanking().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getPicpath() == null) ? 0 : getPicpath().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getIsdelete() == null) ? 0 : getIsdelete().hashCode());
        result = prime * result + ((getIspublish() == null) ? 0 : getIspublish().hashCode());
        result = prime * result + ((getPublishTime() == null) ? 0 : getPublishTime().hashCode());
        result = prime * result + ((getPublishUser() == null) ? 0 : getPublishUser().hashCode());
        result = prime * result + ((getlContenttype() == null) ? 0 : getlContenttype().hashCode());
        result = prime * result + ((getlNodeid() == null) ? 0 : getlNodeid().hashCode());
        result = prime * result + ((getlContent() == null) ? 0 : getlContent().hashCode());
        result = prime * result + ((getlPicpath() == null) ? 0 : getlPicpath().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", nodeid=").append(nodeid);
        sb.append(", ranking=").append(ranking);
        sb.append(", description=").append(description);
        sb.append(", picpath=").append(picpath);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", isdelete=").append(isdelete);
        sb.append(", ispublish=").append(ispublish);
        sb.append(", publishTime=").append(publishTime);
        sb.append(", publishUser=").append(publishUser);
        sb.append(", lContenttype=").append(lContenttype);
        sb.append(", lNodeid=").append(lNodeid);
        sb.append(", lContent=").append(lContent);
        sb.append(", lPicpath=").append(lPicpath);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
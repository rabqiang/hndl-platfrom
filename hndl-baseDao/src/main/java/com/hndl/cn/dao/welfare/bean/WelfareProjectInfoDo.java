package com.hndl.cn.dao.welfare.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * welfare_project_info
 * @author 
 */
public class WelfareProjectInfoDo implements Serializable {
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
     * 组织的id
     */
    private Long orgId;

    /**
     * 当前项目状态（ok 上线、 ing 正在编辑  fail下架）
     */
    private String state;

    /**
     * list 项目名称
     */
    private String titleList;

    /**
     * list 项目副标题
     */
    private String titleSubList;

    /**
     * 项目公司标语
     */
    private String titleOrgList;

    /**
     * 详情标题
     */
    private String titleDetail;

    /**
     * 详情介绍
     */
    private String descDetail;

    /**
     * 项目负责人
     */
    private String author;

    /**
     * 项目负责人手机号码
     */
    private Long authorPhone;

    /**
     * 当前捐赠的爱心数量
     */
    private Long nowHeart;

    /**
     * 剩余的捐赠爱心值
     */
    private Long remainHeart;

    /**
     * 当前捐赠的兑换金额
     */
    private Double nowMoney;

    /**
     * 该项目需要金额
     */
    private Double needMoney;

    /**
     * 项目图片
     */
    private String imgUrl;

    /**
     * 详情页面，第三方地址 
     */
    private String describeToUrl;

    /**
     * 详情的title
     */
    private String describeTitle;

    /**
     * 详情logo
     */
    private String describeImgUrl;

    /**
     * 详情描述
     */
    private String describeDesc;

    /**
     * 弹幕@什么字段
     */
    private String other1;

    /**
     * 排序值，升续
     */
    private Integer other2;

    /**
     * 首页是否隐藏 n/y
     */
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

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTitleList() {
        return titleList;
    }

    public void setTitleList(String titleList) {
        this.titleList = titleList;
    }

    public String getTitleSubList() {
        return titleSubList;
    }

    public void setTitleSubList(String titleSubList) {
        this.titleSubList = titleSubList;
    }

    public String getTitleOrgList() {
        return titleOrgList;
    }

    public void setTitleOrgList(String titleOrgList) {
        this.titleOrgList = titleOrgList;
    }

    public String getTitleDetail() {
        return titleDetail;
    }

    public void setTitleDetail(String titleDetail) {
        this.titleDetail = titleDetail;
    }

    public String getDescDetail() {
        return descDetail;
    }

    public void setDescDetail(String descDetail) {
        this.descDetail = descDetail;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getAuthorPhone() {
        return authorPhone;
    }

    public void setAuthorPhone(Long authorPhone) {
        this.authorPhone = authorPhone;
    }

    public Long getNowHeart() {
        return nowHeart;
    }

    public void setNowHeart(Long nowHeart) {
        this.nowHeart = nowHeart;
    }

    public Long getRemainHeart() {
        return remainHeart;
    }

    public void setRemainHeart(Long remainHeart) {
        this.remainHeart = remainHeart;
    }

    public Double getNowMoney() {
        return nowMoney;
    }

    public void setNowMoney(Double nowMoney) {
        this.nowMoney = nowMoney;
    }

    public Double getNeedMoney() {
        return needMoney;
    }

    public void setNeedMoney(Double needMoney) {
        this.needMoney = needMoney;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescribeToUrl() {
        return describeToUrl;
    }

    public void setDescribeToUrl(String describeToUrl) {
        this.describeToUrl = describeToUrl;
    }

    public String getDescribeTitle() {
        return describeTitle;
    }

    public void setDescribeTitle(String describeTitle) {
        this.describeTitle = describeTitle;
    }

    public String getDescribeImgUrl() {
        return describeImgUrl;
    }

    public void setDescribeImgUrl(String describeImgUrl) {
        this.describeImgUrl = describeImgUrl;
    }

    public String getDescribeDesc() {
        return describeDesc;
    }

    public void setDescribeDesc(String describeDesc) {
        this.describeDesc = describeDesc;
    }

    public String getOther1() {
        return other1;
    }

    public void setOther1(String other1) {
        this.other1 = other1;
    }

    public Integer getOther2() {
        return other2;
    }

    public void setOther2(Integer other2) {
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
        WelfareProjectInfoDo other = (WelfareProjectInfoDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getTitleList() == null ? other.getTitleList() == null : this.getTitleList().equals(other.getTitleList()))
            && (this.getTitleSubList() == null ? other.getTitleSubList() == null : this.getTitleSubList().equals(other.getTitleSubList()))
            && (this.getTitleOrgList() == null ? other.getTitleOrgList() == null : this.getTitleOrgList().equals(other.getTitleOrgList()))
            && (this.getTitleDetail() == null ? other.getTitleDetail() == null : this.getTitleDetail().equals(other.getTitleDetail()))
            && (this.getDescDetail() == null ? other.getDescDetail() == null : this.getDescDetail().equals(other.getDescDetail()))
            && (this.getAuthor() == null ? other.getAuthor() == null : this.getAuthor().equals(other.getAuthor()))
            && (this.getAuthorPhone() == null ? other.getAuthorPhone() == null : this.getAuthorPhone().equals(other.getAuthorPhone()))
            && (this.getNowHeart() == null ? other.getNowHeart() == null : this.getNowHeart().equals(other.getNowHeart()))
            && (this.getRemainHeart() == null ? other.getRemainHeart() == null : this.getRemainHeart().equals(other.getRemainHeart()))
            && (this.getNowMoney() == null ? other.getNowMoney() == null : this.getNowMoney().equals(other.getNowMoney()))
            && (this.getNeedMoney() == null ? other.getNeedMoney() == null : this.getNeedMoney().equals(other.getNeedMoney()))
            && (this.getImgUrl() == null ? other.getImgUrl() == null : this.getImgUrl().equals(other.getImgUrl()))
            && (this.getDescribeToUrl() == null ? other.getDescribeToUrl() == null : this.getDescribeToUrl().equals(other.getDescribeToUrl()))
            && (this.getDescribeTitle() == null ? other.getDescribeTitle() == null : this.getDescribeTitle().equals(other.getDescribeTitle()))
            && (this.getDescribeImgUrl() == null ? other.getDescribeImgUrl() == null : this.getDescribeImgUrl().equals(other.getDescribeImgUrl()))
            && (this.getDescribeDesc() == null ? other.getDescribeDesc() == null : this.getDescribeDesc().equals(other.getDescribeDesc()))
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
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getTitleList() == null) ? 0 : getTitleList().hashCode());
        result = prime * result + ((getTitleSubList() == null) ? 0 : getTitleSubList().hashCode());
        result = prime * result + ((getTitleOrgList() == null) ? 0 : getTitleOrgList().hashCode());
        result = prime * result + ((getTitleDetail() == null) ? 0 : getTitleDetail().hashCode());
        result = prime * result + ((getDescDetail() == null) ? 0 : getDescDetail().hashCode());
        result = prime * result + ((getAuthor() == null) ? 0 : getAuthor().hashCode());
        result = prime * result + ((getAuthorPhone() == null) ? 0 : getAuthorPhone().hashCode());
        result = prime * result + ((getNowHeart() == null) ? 0 : getNowHeart().hashCode());
        result = prime * result + ((getRemainHeart() == null) ? 0 : getRemainHeart().hashCode());
        result = prime * result + ((getNowMoney() == null) ? 0 : getNowMoney().hashCode());
        result = prime * result + ((getNeedMoney() == null) ? 0 : getNeedMoney().hashCode());
        result = prime * result + ((getImgUrl() == null) ? 0 : getImgUrl().hashCode());
        result = prime * result + ((getDescribeToUrl() == null) ? 0 : getDescribeToUrl().hashCode());
        result = prime * result + ((getDescribeTitle() == null) ? 0 : getDescribeTitle().hashCode());
        result = prime * result + ((getDescribeImgUrl() == null) ? 0 : getDescribeImgUrl().hashCode());
        result = prime * result + ((getDescribeDesc() == null) ? 0 : getDescribeDesc().hashCode());
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
        sb.append(", orgId=").append(orgId);
        sb.append(", state=").append(state);
        sb.append(", titleList=").append(titleList);
        sb.append(", titleSubList=").append(titleSubList);
        sb.append(", titleOrgList=").append(titleOrgList);
        sb.append(", titleDetail=").append(titleDetail);
        sb.append(", descDetail=").append(descDetail);
        sb.append(", author=").append(author);
        sb.append(", authorPhone=").append(authorPhone);
        sb.append(", nowHeart=").append(nowHeart);
        sb.append(", remainHeart=").append(remainHeart);
        sb.append(", nowMoney=").append(nowMoney);
        sb.append(", needMoney=").append(needMoney);
        sb.append(", imgUrl=").append(imgUrl);
        sb.append(", describeToUrl=").append(describeToUrl);
        sb.append(", describeTitle=").append(describeTitle);
        sb.append(", describeImgUrl=").append(describeImgUrl);
        sb.append(", describeDesc=").append(describeDesc);
        sb.append(", other1=").append(other1);
        sb.append(", other2=").append(other2);
        sb.append(", other3=").append(other3);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
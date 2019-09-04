package com.hndl.cn.dao.common.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * common_activity_info
 * @author 
 */
public class CommonActivityInfoDo implements Serializable {
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
     * 活动名称
     */
    private String activityName;

    /**
     * 副标题
     */
    private String subtitle;

    /**
     * 开始时间
     */
    private Date startDate;

    /**
     * 结束时间
     */
    private Date endDate;

    /**
     * 活动描述
     */
    private String activityDesc;

    /**
     * 废弃
     */
    private String imgUrl;

    /**
     * 废弃
     */
    private String httpUrl;

    /**
     * 存储图片 废弃
     */
    private String img;

    private Integer orderNum;

    /**
     * 大图片地址 废弃
     */
    private String imgUrlMax;

    /**
     * 储存大图片  废弃
     */
    private String imgMax;

    /**
     * 参与人数
     */
    private Integer applyCount;

    /**
     * 2016版新的图片http地址 阿里云的
     */
    private String imgNewUrl1;

    private String imgNewUrl2;

    private String imgNewUrl3;

    private String imgNewUrl4;

    private String imgNewUrl5;

    private String showTitle;

    private String showDesc;

    private String showImg;

    private String showUrl;

    /**
     * 图片跳转类型1
     */
    private String adImgToType1;

    /**
     * 2
     */
    private String adImgToType2;

    /**
     * 3
     */
    private String adImgToType3;

    /**
     * 4
     */
    private String adImgToType4;

    /**
     * 5
     */
    private String adImgToType5;

    /**
     * 图片跳转地址1
     */
    private String adImgToUrl1;

    /**
     * 2
     */
    private String adImgToUrl2;

    /**
     * 3
     */
    private String adImgToUrl3;

    /**
     * 4
     */
    private String adImgToUrl4;

    /**
     * 5
     */
    private String adImgToUrl5;

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

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getActivityDesc() {
        return activityDesc;
    }

    public void setActivityDesc(String activityDesc) {
        this.activityDesc = activityDesc;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getHttpUrl() {
        return httpUrl;
    }

    public void setHttpUrl(String httpUrl) {
        this.httpUrl = httpUrl;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getImgUrlMax() {
        return imgUrlMax;
    }

    public void setImgUrlMax(String imgUrlMax) {
        this.imgUrlMax = imgUrlMax;
    }

    public String getImgMax() {
        return imgMax;
    }

    public void setImgMax(String imgMax) {
        this.imgMax = imgMax;
    }

    public Integer getApplyCount() {
        return applyCount;
    }

    public void setApplyCount(Integer applyCount) {
        this.applyCount = applyCount;
    }

    public String getImgNewUrl1() {
        return imgNewUrl1;
    }

    public void setImgNewUrl1(String imgNewUrl1) {
        this.imgNewUrl1 = imgNewUrl1;
    }

    public String getImgNewUrl2() {
        return imgNewUrl2;
    }

    public void setImgNewUrl2(String imgNewUrl2) {
        this.imgNewUrl2 = imgNewUrl2;
    }

    public String getImgNewUrl3() {
        return imgNewUrl3;
    }

    public void setImgNewUrl3(String imgNewUrl3) {
        this.imgNewUrl3 = imgNewUrl3;
    }

    public String getImgNewUrl4() {
        return imgNewUrl4;
    }

    public void setImgNewUrl4(String imgNewUrl4) {
        this.imgNewUrl4 = imgNewUrl4;
    }

    public String getImgNewUrl5() {
        return imgNewUrl5;
    }

    public void setImgNewUrl5(String imgNewUrl5) {
        this.imgNewUrl5 = imgNewUrl5;
    }

    public String getShowTitle() {
        return showTitle;
    }

    public void setShowTitle(String showTitle) {
        this.showTitle = showTitle;
    }

    public String getShowDesc() {
        return showDesc;
    }

    public void setShowDesc(String showDesc) {
        this.showDesc = showDesc;
    }

    public String getShowImg() {
        return showImg;
    }

    public void setShowImg(String showImg) {
        this.showImg = showImg;
    }

    public String getShowUrl() {
        return showUrl;
    }

    public void setShowUrl(String showUrl) {
        this.showUrl = showUrl;
    }

    public String getAdImgToType1() {
        return adImgToType1;
    }

    public void setAdImgToType1(String adImgToType1) {
        this.adImgToType1 = adImgToType1;
    }

    public String getAdImgToType2() {
        return adImgToType2;
    }

    public void setAdImgToType2(String adImgToType2) {
        this.adImgToType2 = adImgToType2;
    }

    public String getAdImgToType3() {
        return adImgToType3;
    }

    public void setAdImgToType3(String adImgToType3) {
        this.adImgToType3 = adImgToType3;
    }

    public String getAdImgToType4() {
        return adImgToType4;
    }

    public void setAdImgToType4(String adImgToType4) {
        this.adImgToType4 = adImgToType4;
    }

    public String getAdImgToType5() {
        return adImgToType5;
    }

    public void setAdImgToType5(String adImgToType5) {
        this.adImgToType5 = adImgToType5;
    }

    public String getAdImgToUrl1() {
        return adImgToUrl1;
    }

    public void setAdImgToUrl1(String adImgToUrl1) {
        this.adImgToUrl1 = adImgToUrl1;
    }

    public String getAdImgToUrl2() {
        return adImgToUrl2;
    }

    public void setAdImgToUrl2(String adImgToUrl2) {
        this.adImgToUrl2 = adImgToUrl2;
    }

    public String getAdImgToUrl3() {
        return adImgToUrl3;
    }

    public void setAdImgToUrl3(String adImgToUrl3) {
        this.adImgToUrl3 = adImgToUrl3;
    }

    public String getAdImgToUrl4() {
        return adImgToUrl4;
    }

    public void setAdImgToUrl4(String adImgToUrl4) {
        this.adImgToUrl4 = adImgToUrl4;
    }

    public String getAdImgToUrl5() {
        return adImgToUrl5;
    }

    public void setAdImgToUrl5(String adImgToUrl5) {
        this.adImgToUrl5 = adImgToUrl5;
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
        CommonActivityInfoDo other = (CommonActivityInfoDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getActivityName() == null ? other.getActivityName() == null : this.getActivityName().equals(other.getActivityName()))
            && (this.getSubtitle() == null ? other.getSubtitle() == null : this.getSubtitle().equals(other.getSubtitle()))
            && (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getActivityDesc() == null ? other.getActivityDesc() == null : this.getActivityDesc().equals(other.getActivityDesc()))
            && (this.getImgUrl() == null ? other.getImgUrl() == null : this.getImgUrl().equals(other.getImgUrl()))
            && (this.getHttpUrl() == null ? other.getHttpUrl() == null : this.getHttpUrl().equals(other.getHttpUrl()))
            && (this.getImg() == null ? other.getImg() == null : this.getImg().equals(other.getImg()))
            && (this.getOrderNum() == null ? other.getOrderNum() == null : this.getOrderNum().equals(other.getOrderNum()))
            && (this.getImgUrlMax() == null ? other.getImgUrlMax() == null : this.getImgUrlMax().equals(other.getImgUrlMax()))
            && (this.getImgMax() == null ? other.getImgMax() == null : this.getImgMax().equals(other.getImgMax()))
            && (this.getApplyCount() == null ? other.getApplyCount() == null : this.getApplyCount().equals(other.getApplyCount()))
            && (this.getImgNewUrl1() == null ? other.getImgNewUrl1() == null : this.getImgNewUrl1().equals(other.getImgNewUrl1()))
            && (this.getImgNewUrl2() == null ? other.getImgNewUrl2() == null : this.getImgNewUrl2().equals(other.getImgNewUrl2()))
            && (this.getImgNewUrl3() == null ? other.getImgNewUrl3() == null : this.getImgNewUrl3().equals(other.getImgNewUrl3()))
            && (this.getImgNewUrl4() == null ? other.getImgNewUrl4() == null : this.getImgNewUrl4().equals(other.getImgNewUrl4()))
            && (this.getImgNewUrl5() == null ? other.getImgNewUrl5() == null : this.getImgNewUrl5().equals(other.getImgNewUrl5()))
            && (this.getShowTitle() == null ? other.getShowTitle() == null : this.getShowTitle().equals(other.getShowTitle()))
            && (this.getShowDesc() == null ? other.getShowDesc() == null : this.getShowDesc().equals(other.getShowDesc()))
            && (this.getShowImg() == null ? other.getShowImg() == null : this.getShowImg().equals(other.getShowImg()))
            && (this.getShowUrl() == null ? other.getShowUrl() == null : this.getShowUrl().equals(other.getShowUrl()))
            && (this.getAdImgToType1() == null ? other.getAdImgToType1() == null : this.getAdImgToType1().equals(other.getAdImgToType1()))
            && (this.getAdImgToType2() == null ? other.getAdImgToType2() == null : this.getAdImgToType2().equals(other.getAdImgToType2()))
            && (this.getAdImgToType3() == null ? other.getAdImgToType3() == null : this.getAdImgToType3().equals(other.getAdImgToType3()))
            && (this.getAdImgToType4() == null ? other.getAdImgToType4() == null : this.getAdImgToType4().equals(other.getAdImgToType4()))
            && (this.getAdImgToType5() == null ? other.getAdImgToType5() == null : this.getAdImgToType5().equals(other.getAdImgToType5()))
            && (this.getAdImgToUrl1() == null ? other.getAdImgToUrl1() == null : this.getAdImgToUrl1().equals(other.getAdImgToUrl1()))
            && (this.getAdImgToUrl2() == null ? other.getAdImgToUrl2() == null : this.getAdImgToUrl2().equals(other.getAdImgToUrl2()))
            && (this.getAdImgToUrl3() == null ? other.getAdImgToUrl3() == null : this.getAdImgToUrl3().equals(other.getAdImgToUrl3()))
            && (this.getAdImgToUrl4() == null ? other.getAdImgToUrl4() == null : this.getAdImgToUrl4().equals(other.getAdImgToUrl4()))
            && (this.getAdImgToUrl5() == null ? other.getAdImgToUrl5() == null : this.getAdImgToUrl5().equals(other.getAdImgToUrl5()));
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
        result = prime * result + ((getActivityName() == null) ? 0 : getActivityName().hashCode());
        result = prime * result + ((getSubtitle() == null) ? 0 : getSubtitle().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getActivityDesc() == null) ? 0 : getActivityDesc().hashCode());
        result = prime * result + ((getImgUrl() == null) ? 0 : getImgUrl().hashCode());
        result = prime * result + ((getHttpUrl() == null) ? 0 : getHttpUrl().hashCode());
        result = prime * result + ((getImg() == null) ? 0 : getImg().hashCode());
        result = prime * result + ((getOrderNum() == null) ? 0 : getOrderNum().hashCode());
        result = prime * result + ((getImgUrlMax() == null) ? 0 : getImgUrlMax().hashCode());
        result = prime * result + ((getImgMax() == null) ? 0 : getImgMax().hashCode());
        result = prime * result + ((getApplyCount() == null) ? 0 : getApplyCount().hashCode());
        result = prime * result + ((getImgNewUrl1() == null) ? 0 : getImgNewUrl1().hashCode());
        result = prime * result + ((getImgNewUrl2() == null) ? 0 : getImgNewUrl2().hashCode());
        result = prime * result + ((getImgNewUrl3() == null) ? 0 : getImgNewUrl3().hashCode());
        result = prime * result + ((getImgNewUrl4() == null) ? 0 : getImgNewUrl4().hashCode());
        result = prime * result + ((getImgNewUrl5() == null) ? 0 : getImgNewUrl5().hashCode());
        result = prime * result + ((getShowTitle() == null) ? 0 : getShowTitle().hashCode());
        result = prime * result + ((getShowDesc() == null) ? 0 : getShowDesc().hashCode());
        result = prime * result + ((getShowImg() == null) ? 0 : getShowImg().hashCode());
        result = prime * result + ((getShowUrl() == null) ? 0 : getShowUrl().hashCode());
        result = prime * result + ((getAdImgToType1() == null) ? 0 : getAdImgToType1().hashCode());
        result = prime * result + ((getAdImgToType2() == null) ? 0 : getAdImgToType2().hashCode());
        result = prime * result + ((getAdImgToType3() == null) ? 0 : getAdImgToType3().hashCode());
        result = prime * result + ((getAdImgToType4() == null) ? 0 : getAdImgToType4().hashCode());
        result = prime * result + ((getAdImgToType5() == null) ? 0 : getAdImgToType5().hashCode());
        result = prime * result + ((getAdImgToUrl1() == null) ? 0 : getAdImgToUrl1().hashCode());
        result = prime * result + ((getAdImgToUrl2() == null) ? 0 : getAdImgToUrl2().hashCode());
        result = prime * result + ((getAdImgToUrl3() == null) ? 0 : getAdImgToUrl3().hashCode());
        result = prime * result + ((getAdImgToUrl4() == null) ? 0 : getAdImgToUrl4().hashCode());
        result = prime * result + ((getAdImgToUrl5() == null) ? 0 : getAdImgToUrl5().hashCode());
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
        sb.append(", activityName=").append(activityName);
        sb.append(", subtitle=").append(subtitle);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", activityDesc=").append(activityDesc);
        sb.append(", imgUrl=").append(imgUrl);
        sb.append(", httpUrl=").append(httpUrl);
        sb.append(", img=").append(img);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", imgUrlMax=").append(imgUrlMax);
        sb.append(", imgMax=").append(imgMax);
        sb.append(", applyCount=").append(applyCount);
        sb.append(", imgNewUrl1=").append(imgNewUrl1);
        sb.append(", imgNewUrl2=").append(imgNewUrl2);
        sb.append(", imgNewUrl3=").append(imgNewUrl3);
        sb.append(", imgNewUrl4=").append(imgNewUrl4);
        sb.append(", imgNewUrl5=").append(imgNewUrl5);
        sb.append(", showTitle=").append(showTitle);
        sb.append(", showDesc=").append(showDesc);
        sb.append(", showImg=").append(showImg);
        sb.append(", showUrl=").append(showUrl);
        sb.append(", adImgToType1=").append(adImgToType1);
        sb.append(", adImgToType2=").append(adImgToType2);
        sb.append(", adImgToType3=").append(adImgToType3);
        sb.append(", adImgToType4=").append(adImgToType4);
        sb.append(", adImgToType5=").append(adImgToType5);
        sb.append(", adImgToUrl1=").append(adImgToUrl1);
        sb.append(", adImgToUrl2=").append(adImgToUrl2);
        sb.append(", adImgToUrl3=").append(adImgToUrl3);
        sb.append(", adImgToUrl4=").append(adImgToUrl4);
        sb.append(", adImgToUrl5=").append(adImgToUrl5);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
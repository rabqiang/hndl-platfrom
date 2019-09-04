package com.hndl.cn.dao.fans.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * star_fans_experience_count
 * @author 
 */
public class FansRankRecordDo implements Serializable {
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

    private Long userId;

    /**
     * 姓名
     */
    private Long starId;

    /**
     * 总经验值
     */
    private Integer voteCount;

    /**
     * 统计日期（2017-05、2017年第32周/2017-05-02/2017-05-02 20）
     */
    private String countDate;

    /**
     * 统计类型（周榜、月榜、日榜）（week/month/day）
     */
    private String countType;

    /**
     * 统计开始时间
     */
    private String other1;

    /**
     * 统计结束时间
     */
    private String other2;

    /**
     * 名次
     */
    private String other3;

    /**
     * 用户唯一标识
     */
    private Long sysUniId;

    /**
     * 明星姓名
     */
    private String name;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 明星头像url
     */
    private String headUrl;

    /**
     * 用户头像url
     */
    private String personImgUrlMin;

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

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public String getCountDate() {
        return countDate;
    }

    public void setCountDate(String countDate) {
        this.countDate = countDate;
    }

    public String getCountType() {
        return countType;
    }

    public void setCountType(String countType) {
        this.countType = countType;
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

    public Long getSysUniId() {
        return sysUniId;
    }

    public void setSysUniId(Long sysUniId) {
        this.sysUniId = sysUniId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getPersonImgUrlMin() {
        return personImgUrlMin;
    }

    public void setPersonImgUrlMin(String personImgUrlMin) {
        this.personImgUrlMin = personImgUrlMin;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "FansRankRecordDo{" +
                "id=" + id +
                ", isDeleted='" + isDeleted + '\'' +
                ", createOperator='" + createOperator + '\'' +
                ", createTime=" + createTime +
                ", lastOperator='" + lastOperator + '\'' +
                ", lastModifyTime=" + lastModifyTime +
                ", userId=" + userId +
                ", starId=" + starId +
                ", voteCount=" + voteCount +
                ", countDate='" + countDate + '\'' +
                ", countType='" + countType + '\'' +
                ", other1='" + other1 + '\'' +
                ", other2='" + other2 + '\'' +
                ", other3='" + other3 + '\'' +
                ", sysUniId='" + sysUniId + '\'' +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", headUrl='" + headUrl + '\'' +
                ", personImgUrlMin='" + personImgUrlMin + '\'' +
                '}';
    }

}
package com.hndl.cn.dao.shop.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * shop_app_data
 * @author 
 */
public class ShopAppDataDo implements Serializable {
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
     * 统计的时间
     */
    private Date countTime;

    /**
     * 新增用户数
     */
    private Long newUserCount;

    /**
     * 总的购买人数
     */
    private Long totalBuyCount;

    /**
     * 用户购买人数(非机器人)
     */
    private Long userBuyCount;

    /**
     * 新增商品数
     */
    private Long newItemCount;

    /**
     * 商品开奖数量
     */
    private Long itemOpenCount;

    /**
     * 第三方消费金额
     */
    private Double thirdPayCount;

    /**
     * 芒果币消费金额
     */
    private Double coinPayCount;

    /**
     * 积分消费金额
     */
    private Double douPayCount;

    private Integer totalOrderCount;

    private Integer totalUserOrderCount;

    private Integer activityUserCount;

    private String bak1;

    private String bak2;

    private String bak3;

    private String bak4;

    private String bak5;

    /**
     * 芒果币比心数
     */
    private Integer mangoCurrencyCount;

    /**
     * 第三方支付比心数
     */
    private Integer thirdPayHeartCount;

    /**
     * 积分打榜数
     */
    private Integer scoringCount;

    /**
     * 芒果币比心人数
     */
    private Integer mangoCurrencyPersonCount;

    /**
     * 第三方支付比心人数
     */
    private Integer thirdPayHeartPersonCount;

    /**
     * 积分打榜人数
     */
    private Integer scoringPersonCount;

    /**
     * 充值数量
     */
    private Double rechargeCount;

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

    public Date getCountTime() {
        return countTime;
    }

    public void setCountTime(Date countTime) {
        this.countTime = countTime;
    }

    public Long getNewUserCount() {
        return newUserCount;
    }

    public void setNewUserCount(Long newUserCount) {
        this.newUserCount = newUserCount;
    }

    public Long getTotalBuyCount() {
        return totalBuyCount;
    }

    public void setTotalBuyCount(Long totalBuyCount) {
        this.totalBuyCount = totalBuyCount;
    }

    public Long getUserBuyCount() {
        return userBuyCount;
    }

    public void setUserBuyCount(Long userBuyCount) {
        this.userBuyCount = userBuyCount;
    }

    public Long getNewItemCount() {
        return newItemCount;
    }

    public void setNewItemCount(Long newItemCount) {
        this.newItemCount = newItemCount;
    }

    public Long getItemOpenCount() {
        return itemOpenCount;
    }

    public void setItemOpenCount(Long itemOpenCount) {
        this.itemOpenCount = itemOpenCount;
    }

    public Double getThirdPayCount() {
        return thirdPayCount;
    }

    public void setThirdPayCount(Double thirdPayCount) {
        this.thirdPayCount = thirdPayCount;
    }

    public Double getCoinPayCount() {
        return coinPayCount;
    }

    public void setCoinPayCount(Double coinPayCount) {
        this.coinPayCount = coinPayCount;
    }

    public Double getDouPayCount() {
        return douPayCount;
    }

    public void setDouPayCount(Double douPayCount) {
        this.douPayCount = douPayCount;
    }

    public Integer getTotalOrderCount() {
        return totalOrderCount;
    }

    public void setTotalOrderCount(Integer totalOrderCount) {
        this.totalOrderCount = totalOrderCount;
    }

    public Integer getTotalUserOrderCount() {
        return totalUserOrderCount;
    }

    public void setTotalUserOrderCount(Integer totalUserOrderCount) {
        this.totalUserOrderCount = totalUserOrderCount;
    }

    public Integer getActivityUserCount() {
        return activityUserCount;
    }

    public void setActivityUserCount(Integer activityUserCount) {
        this.activityUserCount = activityUserCount;
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

    public String getBak4() {
        return bak4;
    }

    public void setBak4(String bak4) {
        this.bak4 = bak4;
    }

    public String getBak5() {
        return bak5;
    }

    public void setBak5(String bak5) {
        this.bak5 = bak5;
    }

    public Integer getMangoCurrencyCount() {
        return mangoCurrencyCount;
    }

    public void setMangoCurrencyCount(Integer mangoCurrencyCount) {
        this.mangoCurrencyCount = mangoCurrencyCount;
    }

    public Integer getThirdPayHeartCount() {
        return thirdPayHeartCount;
    }

    public void setThirdPayHeartCount(Integer thirdPayHeartCount) {
        this.thirdPayHeartCount = thirdPayHeartCount;
    }

    public Integer getScoringCount() {
        return scoringCount;
    }

    public void setScoringCount(Integer scoringCount) {
        this.scoringCount = scoringCount;
    }

    public Integer getMangoCurrencyPersonCount() {
        return mangoCurrencyPersonCount;
    }

    public void setMangoCurrencyPersonCount(Integer mangoCurrencyPersonCount) {
        this.mangoCurrencyPersonCount = mangoCurrencyPersonCount;
    }

    public Integer getThirdPayHeartPersonCount() {
        return thirdPayHeartPersonCount;
    }

    public void setThirdPayHeartPersonCount(Integer thirdPayHeartPersonCount) {
        this.thirdPayHeartPersonCount = thirdPayHeartPersonCount;
    }

    public Integer getScoringPersonCount() {
        return scoringPersonCount;
    }

    public void setScoringPersonCount(Integer scoringPersonCount) {
        this.scoringPersonCount = scoringPersonCount;
    }

    public Double getRechargeCount() {
        return rechargeCount;
    }

    public void setRechargeCount(Double rechargeCount) {
        this.rechargeCount = rechargeCount;
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
        ShopAppDataDo other = (ShopAppDataDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getCountTime() == null ? other.getCountTime() == null : this.getCountTime().equals(other.getCountTime()))
            && (this.getNewUserCount() == null ? other.getNewUserCount() == null : this.getNewUserCount().equals(other.getNewUserCount()))
            && (this.getTotalBuyCount() == null ? other.getTotalBuyCount() == null : this.getTotalBuyCount().equals(other.getTotalBuyCount()))
            && (this.getUserBuyCount() == null ? other.getUserBuyCount() == null : this.getUserBuyCount().equals(other.getUserBuyCount()))
            && (this.getNewItemCount() == null ? other.getNewItemCount() == null : this.getNewItemCount().equals(other.getNewItemCount()))
            && (this.getItemOpenCount() == null ? other.getItemOpenCount() == null : this.getItemOpenCount().equals(other.getItemOpenCount()))
            && (this.getThirdPayCount() == null ? other.getThirdPayCount() == null : this.getThirdPayCount().equals(other.getThirdPayCount()))
            && (this.getCoinPayCount() == null ? other.getCoinPayCount() == null : this.getCoinPayCount().equals(other.getCoinPayCount()))
            && (this.getDouPayCount() == null ? other.getDouPayCount() == null : this.getDouPayCount().equals(other.getDouPayCount()))
            && (this.getTotalOrderCount() == null ? other.getTotalOrderCount() == null : this.getTotalOrderCount().equals(other.getTotalOrderCount()))
            && (this.getTotalUserOrderCount() == null ? other.getTotalUserOrderCount() == null : this.getTotalUserOrderCount().equals(other.getTotalUserOrderCount()))
            && (this.getActivityUserCount() == null ? other.getActivityUserCount() == null : this.getActivityUserCount().equals(other.getActivityUserCount()))
            && (this.getBak1() == null ? other.getBak1() == null : this.getBak1().equals(other.getBak1()))
            && (this.getBak2() == null ? other.getBak2() == null : this.getBak2().equals(other.getBak2()))
            && (this.getBak3() == null ? other.getBak3() == null : this.getBak3().equals(other.getBak3()))
            && (this.getBak4() == null ? other.getBak4() == null : this.getBak4().equals(other.getBak4()))
            && (this.getBak5() == null ? other.getBak5() == null : this.getBak5().equals(other.getBak5()))
            && (this.getMangoCurrencyCount() == null ? other.getMangoCurrencyCount() == null : this.getMangoCurrencyCount().equals(other.getMangoCurrencyCount()))
            && (this.getThirdPayHeartCount() == null ? other.getThirdPayHeartCount() == null : this.getThirdPayHeartCount().equals(other.getThirdPayHeartCount()))
            && (this.getScoringCount() == null ? other.getScoringCount() == null : this.getScoringCount().equals(other.getScoringCount()))
            && (this.getMangoCurrencyPersonCount() == null ? other.getMangoCurrencyPersonCount() == null : this.getMangoCurrencyPersonCount().equals(other.getMangoCurrencyPersonCount()))
            && (this.getThirdPayHeartPersonCount() == null ? other.getThirdPayHeartPersonCount() == null : this.getThirdPayHeartPersonCount().equals(other.getThirdPayHeartPersonCount()))
            && (this.getScoringPersonCount() == null ? other.getScoringPersonCount() == null : this.getScoringPersonCount().equals(other.getScoringPersonCount()))
            && (this.getRechargeCount() == null ? other.getRechargeCount() == null : this.getRechargeCount().equals(other.getRechargeCount()));
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
        result = prime * result + ((getCountTime() == null) ? 0 : getCountTime().hashCode());
        result = prime * result + ((getNewUserCount() == null) ? 0 : getNewUserCount().hashCode());
        result = prime * result + ((getTotalBuyCount() == null) ? 0 : getTotalBuyCount().hashCode());
        result = prime * result + ((getUserBuyCount() == null) ? 0 : getUserBuyCount().hashCode());
        result = prime * result + ((getNewItemCount() == null) ? 0 : getNewItemCount().hashCode());
        result = prime * result + ((getItemOpenCount() == null) ? 0 : getItemOpenCount().hashCode());
        result = prime * result + ((getThirdPayCount() == null) ? 0 : getThirdPayCount().hashCode());
        result = prime * result + ((getCoinPayCount() == null) ? 0 : getCoinPayCount().hashCode());
        result = prime * result + ((getDouPayCount() == null) ? 0 : getDouPayCount().hashCode());
        result = prime * result + ((getTotalOrderCount() == null) ? 0 : getTotalOrderCount().hashCode());
        result = prime * result + ((getTotalUserOrderCount() == null) ? 0 : getTotalUserOrderCount().hashCode());
        result = prime * result + ((getActivityUserCount() == null) ? 0 : getActivityUserCount().hashCode());
        result = prime * result + ((getBak1() == null) ? 0 : getBak1().hashCode());
        result = prime * result + ((getBak2() == null) ? 0 : getBak2().hashCode());
        result = prime * result + ((getBak3() == null) ? 0 : getBak3().hashCode());
        result = prime * result + ((getBak4() == null) ? 0 : getBak4().hashCode());
        result = prime * result + ((getBak5() == null) ? 0 : getBak5().hashCode());
        result = prime * result + ((getMangoCurrencyCount() == null) ? 0 : getMangoCurrencyCount().hashCode());
        result = prime * result + ((getThirdPayHeartCount() == null) ? 0 : getThirdPayHeartCount().hashCode());
        result = prime * result + ((getScoringCount() == null) ? 0 : getScoringCount().hashCode());
        result = prime * result + ((getMangoCurrencyPersonCount() == null) ? 0 : getMangoCurrencyPersonCount().hashCode());
        result = prime * result + ((getThirdPayHeartPersonCount() == null) ? 0 : getThirdPayHeartPersonCount().hashCode());
        result = prime * result + ((getScoringPersonCount() == null) ? 0 : getScoringPersonCount().hashCode());
        result = prime * result + ((getRechargeCount() == null) ? 0 : getRechargeCount().hashCode());
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
        sb.append(", countTime=").append(countTime);
        sb.append(", newUserCount=").append(newUserCount);
        sb.append(", totalBuyCount=").append(totalBuyCount);
        sb.append(", userBuyCount=").append(userBuyCount);
        sb.append(", newItemCount=").append(newItemCount);
        sb.append(", itemOpenCount=").append(itemOpenCount);
        sb.append(", thirdPayCount=").append(thirdPayCount);
        sb.append(", coinPayCount=").append(coinPayCount);
        sb.append(", douPayCount=").append(douPayCount);
        sb.append(", totalOrderCount=").append(totalOrderCount);
        sb.append(", totalUserOrderCount=").append(totalUserOrderCount);
        sb.append(", activityUserCount=").append(activityUserCount);
        sb.append(", bak1=").append(bak1);
        sb.append(", bak2=").append(bak2);
        sb.append(", bak3=").append(bak3);
        sb.append(", bak4=").append(bak4);
        sb.append(", bak5=").append(bak5);
        sb.append(", mangoCurrencyCount=").append(mangoCurrencyCount);
        sb.append(", thirdPayHeartCount=").append(thirdPayHeartCount);
        sb.append(", scoringCount=").append(scoringCount);
        sb.append(", mangoCurrencyPersonCount=").append(mangoCurrencyPersonCount);
        sb.append(", thirdPayHeartPersonCount=").append(thirdPayHeartPersonCount);
        sb.append(", scoringPersonCount=").append(scoringPersonCount);
        sb.append(", rechargeCount=").append(rechargeCount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
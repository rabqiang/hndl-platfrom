package com.hndl.cn.dao.common.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * common_prize_info
 * @author 
 */
public class CommonPrizeInfoDo implements Serializable {
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
     * 奖品名称
     */
    private String prizeName;

    /**
     * 商品的价值
     */
    private Integer price;

    /**
     * y必中奖 n普通奖 s签到奖 作废了 以前的
     */
    private String isFirstPrize;

    /**
     * 库存 不变
     */
    private Integer count;

    /**
     * 累计消耗量多少该奖品  累加
     */
    private Integer giveCount;

    /**
     * 奖品URL
     */
    private String imgUrl;

    /**
     * doudou豆/coin币/fare话费/flow流量/object实物奖
     */
    private String prizeType;

    /**
     * 奖品数量：5块钱话费填5，5个都都填5
     */
    private Double prizeCount;

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

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getIsFirstPrize() {
        return isFirstPrize;
    }

    public void setIsFirstPrize(String isFirstPrize) {
        this.isFirstPrize = isFirstPrize;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getGiveCount() {
        return giveCount;
    }

    public void setGiveCount(Integer giveCount) {
        this.giveCount = giveCount;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getPrizeType() {
        return prizeType;
    }

    public void setPrizeType(String prizeType) {
        this.prizeType = prizeType;
    }

    public Double getPrizeCount() {
        return prizeCount;
    }

    public void setPrizeCount(Double prizeCount) {
        this.prizeCount = prizeCount;
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
        CommonPrizeInfoDo other = (CommonPrizeInfoDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getPrizeName() == null ? other.getPrizeName() == null : this.getPrizeName().equals(other.getPrizeName()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getIsFirstPrize() == null ? other.getIsFirstPrize() == null : this.getIsFirstPrize().equals(other.getIsFirstPrize()))
            && (this.getCount() == null ? other.getCount() == null : this.getCount().equals(other.getCount()))
            && (this.getGiveCount() == null ? other.getGiveCount() == null : this.getGiveCount().equals(other.getGiveCount()))
            && (this.getImgUrl() == null ? other.getImgUrl() == null : this.getImgUrl().equals(other.getImgUrl()))
            && (this.getPrizeType() == null ? other.getPrizeType() == null : this.getPrizeType().equals(other.getPrizeType()))
            && (this.getPrizeCount() == null ? other.getPrizeCount() == null : this.getPrizeCount().equals(other.getPrizeCount()));
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
        result = prime * result + ((getPrizeName() == null) ? 0 : getPrizeName().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getIsFirstPrize() == null) ? 0 : getIsFirstPrize().hashCode());
        result = prime * result + ((getCount() == null) ? 0 : getCount().hashCode());
        result = prime * result + ((getGiveCount() == null) ? 0 : getGiveCount().hashCode());
        result = prime * result + ((getImgUrl() == null) ? 0 : getImgUrl().hashCode());
        result = prime * result + ((getPrizeType() == null) ? 0 : getPrizeType().hashCode());
        result = prime * result + ((getPrizeCount() == null) ? 0 : getPrizeCount().hashCode());
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
        sb.append(", prizeName=").append(prizeName);
        sb.append(", price=").append(price);
        sb.append(", isFirstPrize=").append(isFirstPrize);
        sb.append(", count=").append(count);
        sb.append(", giveCount=").append(giveCount);
        sb.append(", imgUrl=").append(imgUrl);
        sb.append(", prizeType=").append(prizeType);
        sb.append(", prizeCount=").append(prizeCount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
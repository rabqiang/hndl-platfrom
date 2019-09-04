package com.hndl.cn.dao.shop.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * shop_item_templet
 * @author 
 */
public class ShopItemTempletDo implements Serializable {
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
     * 图片地址
     */
    private String imgUrl;

    /**
     * 商品名称
     */
    private String title;

    /**
     * 副标题
     */
    private String titleSub;

    /**
     * 商品的对账名称，内部使用的
     */
    private String titleInner;

    /**
     * 轮播图地址1
     */
    private String adImg1;

    private String adImg2;

    private String adImg3;

    private String adImg4;

    private String adImg5;

    /**
     * 商品的文字描述
     */
    private String itemDesc;

    /**
     * 排序值（排序值越大排上面）
     */
    private Integer orderNumber;

    /**
     * 商品的总所需人次
     */
    private Integer priceCount;

    /**
     * 用户直接购买需要的购买的价格
     */
    private Integer directBuyPrice;

    /**
     * 用户直接购买需要的购买支付方式(元、芒果币、芒果豆)（db存rmb/dou/coin）
     */
    private String directBuyPriceType;

    /**
     * 商品类型：芒果类、公益类、普通类、十元专区(mangguo/help/normal/tenYuan)
     */
    private String type1;

    /**
     * 所属分类：门票、纪念品、手机、电器……
     */
    private String type2;

    /**
     * 品牌：小米、iphone
     */
    private String logoType;

    /**
     * 一个人最少需要购买的次数
     */
    private Integer buyMinCount;

    /**
     * 一个人最多购买的次数
     */
    private Integer buyMaxCount;

    /**
     * 支付方式：第三方支付、芒果币、芒果豆（db存：thridPay/coin/dou）
     */
    private String payType;

    /**
     * 商品属性：推荐、人气、默认
     */
    private String itemProperty;

    /**
     * 最大期数（相当于库存）
     */
    private Integer maxSection;

    /**
     * 当前开奖到哪一期了(最新这个商品在商品表的商品id)
     */
    private Integer currentSection;

    /**
     * 是否正式上架(初次上架，需要往shop_item_info表插入第一次商品）
     */
    private String isOnline;

    /**
     * 购买奖励的类型：芒果币、芒果豆（db存coin/dou）
     */
    private String buyPrizeType;

    /**
     * 购买这个商品后，奖励的数量
     */
    private Integer buyPrizeCount;

    /**
     * （作废，晒单奖励放到晒单审批里面去）晒单奖励的类型：芒果币、芒果豆（db存coin/dou）
     */
    private String showOrderPrizeType;

    /**
     * （作废，晒单奖励放到晒单审批里面去）晒单这个商品后，奖励的数量
     */
    private Integer showOrderPrizeCount;

    /**
     * 是否为公益类产品(y/n)
     */
    private String isHelp;

    /**
     * 级别要求
     */
    private String other1;

    /**
     * 特殊配置2（初始热度值）
     */
    private String other2;

    /**
     * 特殊配置3
     */
    private String other3;

    /**
     * 商品分类
     */
    private String other4;

    /**
     * 特殊配置5
     */
    private String other5;

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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleSub() {
        return titleSub;
    }

    public void setTitleSub(String titleSub) {
        this.titleSub = titleSub;
    }

    public String getTitleInner() {
        return titleInner;
    }

    public void setTitleInner(String titleInner) {
        this.titleInner = titleInner;
    }

    public String getAdImg1() {
        return adImg1;
    }

    public void setAdImg1(String adImg1) {
        this.adImg1 = adImg1;
    }

    public String getAdImg2() {
        return adImg2;
    }

    public void setAdImg2(String adImg2) {
        this.adImg2 = adImg2;
    }

    public String getAdImg3() {
        return adImg3;
    }

    public void setAdImg3(String adImg3) {
        this.adImg3 = adImg3;
    }

    public String getAdImg4() {
        return adImg4;
    }

    public void setAdImg4(String adImg4) {
        this.adImg4 = adImg4;
    }

    public String getAdImg5() {
        return adImg5;
    }

    public void setAdImg5(String adImg5) {
        this.adImg5 = adImg5;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getPriceCount() {
        return priceCount;
    }

    public void setPriceCount(Integer priceCount) {
        this.priceCount = priceCount;
    }

    public Integer getDirectBuyPrice() {
        return directBuyPrice;
    }

    public void setDirectBuyPrice(Integer directBuyPrice) {
        this.directBuyPrice = directBuyPrice;
    }

    public String getDirectBuyPriceType() {
        return directBuyPriceType;
    }

    public void setDirectBuyPriceType(String directBuyPriceType) {
        this.directBuyPriceType = directBuyPriceType;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getLogoType() {
        return logoType;
    }

    public void setLogoType(String logoType) {
        this.logoType = logoType;
    }

    public Integer getBuyMinCount() {
        return buyMinCount;
    }

    public void setBuyMinCount(Integer buyMinCount) {
        this.buyMinCount = buyMinCount;
    }

    public Integer getBuyMaxCount() {
        return buyMaxCount;
    }

    public void setBuyMaxCount(Integer buyMaxCount) {
        this.buyMaxCount = buyMaxCount;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getItemProperty() {
        return itemProperty;
    }

    public void setItemProperty(String itemProperty) {
        this.itemProperty = itemProperty;
    }

    public Integer getMaxSection() {
        return maxSection;
    }

    public void setMaxSection(Integer maxSection) {
        this.maxSection = maxSection;
    }

    public Integer getCurrentSection() {
        return currentSection;
    }

    public void setCurrentSection(Integer currentSection) {
        this.currentSection = currentSection;
    }

    public String getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(String isOnline) {
        this.isOnline = isOnline;
    }

    public String getBuyPrizeType() {
        return buyPrizeType;
    }

    public void setBuyPrizeType(String buyPrizeType) {
        this.buyPrizeType = buyPrizeType;
    }

    public Integer getBuyPrizeCount() {
        return buyPrizeCount;
    }

    public void setBuyPrizeCount(Integer buyPrizeCount) {
        this.buyPrizeCount = buyPrizeCount;
    }

    public String getShowOrderPrizeType() {
        return showOrderPrizeType;
    }

    public void setShowOrderPrizeType(String showOrderPrizeType) {
        this.showOrderPrizeType = showOrderPrizeType;
    }

    public Integer getShowOrderPrizeCount() {
        return showOrderPrizeCount;
    }

    public void setShowOrderPrizeCount(Integer showOrderPrizeCount) {
        this.showOrderPrizeCount = showOrderPrizeCount;
    }

    public String getIsHelp() {
        return isHelp;
    }

    public void setIsHelp(String isHelp) {
        this.isHelp = isHelp;
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

    public String getOther4() {
        return other4;
    }

    public void setOther4(String other4) {
        this.other4 = other4;
    }

    public String getOther5() {
        return other5;
    }

    public void setOther5(String other5) {
        this.other5 = other5;
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
        ShopItemTempletDo other = (ShopItemTempletDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getImgUrl() == null ? other.getImgUrl() == null : this.getImgUrl().equals(other.getImgUrl()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getTitleSub() == null ? other.getTitleSub() == null : this.getTitleSub().equals(other.getTitleSub()))
            && (this.getTitleInner() == null ? other.getTitleInner() == null : this.getTitleInner().equals(other.getTitleInner()))
            && (this.getAdImg1() == null ? other.getAdImg1() == null : this.getAdImg1().equals(other.getAdImg1()))
            && (this.getAdImg2() == null ? other.getAdImg2() == null : this.getAdImg2().equals(other.getAdImg2()))
            && (this.getAdImg3() == null ? other.getAdImg3() == null : this.getAdImg3().equals(other.getAdImg3()))
            && (this.getAdImg4() == null ? other.getAdImg4() == null : this.getAdImg4().equals(other.getAdImg4()))
            && (this.getAdImg5() == null ? other.getAdImg5() == null : this.getAdImg5().equals(other.getAdImg5()))
            && (this.getItemDesc() == null ? other.getItemDesc() == null : this.getItemDesc().equals(other.getItemDesc()))
            && (this.getOrderNumber() == null ? other.getOrderNumber() == null : this.getOrderNumber().equals(other.getOrderNumber()))
            && (this.getPriceCount() == null ? other.getPriceCount() == null : this.getPriceCount().equals(other.getPriceCount()))
            && (this.getDirectBuyPrice() == null ? other.getDirectBuyPrice() == null : this.getDirectBuyPrice().equals(other.getDirectBuyPrice()))
            && (this.getDirectBuyPriceType() == null ? other.getDirectBuyPriceType() == null : this.getDirectBuyPriceType().equals(other.getDirectBuyPriceType()))
            && (this.getType1() == null ? other.getType1() == null : this.getType1().equals(other.getType1()))
            && (this.getType2() == null ? other.getType2() == null : this.getType2().equals(other.getType2()))
            && (this.getLogoType() == null ? other.getLogoType() == null : this.getLogoType().equals(other.getLogoType()))
            && (this.getBuyMinCount() == null ? other.getBuyMinCount() == null : this.getBuyMinCount().equals(other.getBuyMinCount()))
            && (this.getBuyMaxCount() == null ? other.getBuyMaxCount() == null : this.getBuyMaxCount().equals(other.getBuyMaxCount()))
            && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
            && (this.getItemProperty() == null ? other.getItemProperty() == null : this.getItemProperty().equals(other.getItemProperty()))
            && (this.getMaxSection() == null ? other.getMaxSection() == null : this.getMaxSection().equals(other.getMaxSection()))
            && (this.getCurrentSection() == null ? other.getCurrentSection() == null : this.getCurrentSection().equals(other.getCurrentSection()))
            && (this.getIsOnline() == null ? other.getIsOnline() == null : this.getIsOnline().equals(other.getIsOnline()))
            && (this.getBuyPrizeType() == null ? other.getBuyPrizeType() == null : this.getBuyPrizeType().equals(other.getBuyPrizeType()))
            && (this.getBuyPrizeCount() == null ? other.getBuyPrizeCount() == null : this.getBuyPrizeCount().equals(other.getBuyPrizeCount()))
            && (this.getShowOrderPrizeType() == null ? other.getShowOrderPrizeType() == null : this.getShowOrderPrizeType().equals(other.getShowOrderPrizeType()))
            && (this.getShowOrderPrizeCount() == null ? other.getShowOrderPrizeCount() == null : this.getShowOrderPrizeCount().equals(other.getShowOrderPrizeCount()))
            && (this.getIsHelp() == null ? other.getIsHelp() == null : this.getIsHelp().equals(other.getIsHelp()))
            && (this.getOther1() == null ? other.getOther1() == null : this.getOther1().equals(other.getOther1()))
            && (this.getOther2() == null ? other.getOther2() == null : this.getOther2().equals(other.getOther2()))
            && (this.getOther3() == null ? other.getOther3() == null : this.getOther3().equals(other.getOther3()))
            && (this.getOther4() == null ? other.getOther4() == null : this.getOther4().equals(other.getOther4()))
            && (this.getOther5() == null ? other.getOther5() == null : this.getOther5().equals(other.getOther5()));
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
        result = prime * result + ((getImgUrl() == null) ? 0 : getImgUrl().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getTitleSub() == null) ? 0 : getTitleSub().hashCode());
        result = prime * result + ((getTitleInner() == null) ? 0 : getTitleInner().hashCode());
        result = prime * result + ((getAdImg1() == null) ? 0 : getAdImg1().hashCode());
        result = prime * result + ((getAdImg2() == null) ? 0 : getAdImg2().hashCode());
        result = prime * result + ((getAdImg3() == null) ? 0 : getAdImg3().hashCode());
        result = prime * result + ((getAdImg4() == null) ? 0 : getAdImg4().hashCode());
        result = prime * result + ((getAdImg5() == null) ? 0 : getAdImg5().hashCode());
        result = prime * result + ((getItemDesc() == null) ? 0 : getItemDesc().hashCode());
        result = prime * result + ((getOrderNumber() == null) ? 0 : getOrderNumber().hashCode());
        result = prime * result + ((getPriceCount() == null) ? 0 : getPriceCount().hashCode());
        result = prime * result + ((getDirectBuyPrice() == null) ? 0 : getDirectBuyPrice().hashCode());
        result = prime * result + ((getDirectBuyPriceType() == null) ? 0 : getDirectBuyPriceType().hashCode());
        result = prime * result + ((getType1() == null) ? 0 : getType1().hashCode());
        result = prime * result + ((getType2() == null) ? 0 : getType2().hashCode());
        result = prime * result + ((getLogoType() == null) ? 0 : getLogoType().hashCode());
        result = prime * result + ((getBuyMinCount() == null) ? 0 : getBuyMinCount().hashCode());
        result = prime * result + ((getBuyMaxCount() == null) ? 0 : getBuyMaxCount().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        result = prime * result + ((getItemProperty() == null) ? 0 : getItemProperty().hashCode());
        result = prime * result + ((getMaxSection() == null) ? 0 : getMaxSection().hashCode());
        result = prime * result + ((getCurrentSection() == null) ? 0 : getCurrentSection().hashCode());
        result = prime * result + ((getIsOnline() == null) ? 0 : getIsOnline().hashCode());
        result = prime * result + ((getBuyPrizeType() == null) ? 0 : getBuyPrizeType().hashCode());
        result = prime * result + ((getBuyPrizeCount() == null) ? 0 : getBuyPrizeCount().hashCode());
        result = prime * result + ((getShowOrderPrizeType() == null) ? 0 : getShowOrderPrizeType().hashCode());
        result = prime * result + ((getShowOrderPrizeCount() == null) ? 0 : getShowOrderPrizeCount().hashCode());
        result = prime * result + ((getIsHelp() == null) ? 0 : getIsHelp().hashCode());
        result = prime * result + ((getOther1() == null) ? 0 : getOther1().hashCode());
        result = prime * result + ((getOther2() == null) ? 0 : getOther2().hashCode());
        result = prime * result + ((getOther3() == null) ? 0 : getOther3().hashCode());
        result = prime * result + ((getOther4() == null) ? 0 : getOther4().hashCode());
        result = prime * result + ((getOther5() == null) ? 0 : getOther5().hashCode());
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
        sb.append(", imgUrl=").append(imgUrl);
        sb.append(", title=").append(title);
        sb.append(", titleSub=").append(titleSub);
        sb.append(", titleInner=").append(titleInner);
        sb.append(", adImg1=").append(adImg1);
        sb.append(", adImg2=").append(adImg2);
        sb.append(", adImg3=").append(adImg3);
        sb.append(", adImg4=").append(adImg4);
        sb.append(", adImg5=").append(adImg5);
        sb.append(", itemDesc=").append(itemDesc);
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", priceCount=").append(priceCount);
        sb.append(", directBuyPrice=").append(directBuyPrice);
        sb.append(", directBuyPriceType=").append(directBuyPriceType);
        sb.append(", type1=").append(type1);
        sb.append(", type2=").append(type2);
        sb.append(", logoType=").append(logoType);
        sb.append(", buyMinCount=").append(buyMinCount);
        sb.append(", buyMaxCount=").append(buyMaxCount);
        sb.append(", payType=").append(payType);
        sb.append(", itemProperty=").append(itemProperty);
        sb.append(", maxSection=").append(maxSection);
        sb.append(", currentSection=").append(currentSection);
        sb.append(", isOnline=").append(isOnline);
        sb.append(", buyPrizeType=").append(buyPrizeType);
        sb.append(", buyPrizeCount=").append(buyPrizeCount);
        sb.append(", showOrderPrizeType=").append(showOrderPrizeType);
        sb.append(", showOrderPrizeCount=").append(showOrderPrizeCount);
        sb.append(", isHelp=").append(isHelp);
        sb.append(", other1=").append(other1);
        sb.append(", other2=").append(other2);
        sb.append(", other3=").append(other3);
        sb.append(", other4=").append(other4);
        sb.append(", other5=").append(other5);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
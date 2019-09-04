package com.hndl.cn.dao.shop.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * shop_item_info
 * @author 
 */
public class ShopItemInfoDo implements Serializable {
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
     * 商品模板id
     */
    private Long shopItemTempletId;

    /**
     * 废弃：这个模板的商品当前的商品id
     */
    private Long currentItemId;

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
     * 已经被购买的次数（用户每一次购买，这个需要累加，另外如果是最后一个人购买的，立马需要去开奖算法计算）
     */
    private Integer applyCount;

    /**
     * 剩余多少人次名额
     */
    private Integer remainCount;

    /**
     * 用户直接购买需要的购买的价格
     */
    private Double directBuyPrice;

    /**
     * 用户直接购买需要的购买支付方式(人民币、芒果币、芒果豆)（db存rmb/dou/coin）
     */
    private String directBuyPriceType;

    /**
     * 商品类型：芒果类、公益类、普通类、十元专区( db存：mangguo、help、normal、tenYuan)
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
     * 一个人最少需要购买的次数(如果是10元专区、这里填10)
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
     * 当前开奖到哪一期了(内部期号，从1开始的)
     */
    private Integer currentSection;

    /**
     * 是否正式上架状态(人为后台下架这个商品，这个字段变为n)
     */
    private String isOnline;

    /**
     * 平台的总期数(从10001开始)对外看的 从系统参数表system_parameter_info取，然后给system_parameter_info的值累加
     */
    private Long allSectionCount;

    /**
     * 中奖的用户id
     */
    private String luckUserId;

    /**
     * 中奖的号码
     */
    private String luckNo;

    /**
     * 状态： init/ing/counting/opened/personClose（商品初始化中，需要job任务生成幸运号才变ing状态/商品上架中、卖完运算结果中、已开奖、后台控制下架）
     */
    private String itemStatus;

    /**
     * 参与的总人次
     */
    private Integer applyPersonCount;

    /**
     * 开奖时间(如果是最后一笔购买，这个时间=最后购买时间+参数表的open_times）给app的倒计时秒=这个字段-当前时间
     */
    private Date openDatetime;

    /**
     * 购买奖励的类型：芒果币、芒果豆（db存coin/dou）
     */
    private String buyPrizeType;

    /**
     * 购买这个商品后，奖励的数量
     */
    private Integer buyPrizeCount;

    /**
     * 是否为公益类产品(y/n)
     */
    private String isHelp;

    /**
     * 当前进度的百分比 db:23%/44%(四省五入)
     */
    private String currentPresent;

    /**
     * 重启时时彩的彩票数字
     */
    private String chongqinLuckyNoB;

    /**
     * 计算公司A：全站记录最近50条时间相加
     */
    private String countLuckyNoA;

    /**
     * 该商品第一次被购买的时间
     */
    private Date firstBuyTime;

    /**
     * 中奖的时候，重启时时彩的期号
     */
    private String chongqinLuckySection;

    /**
     * 商品卖完后，预测的期号
     */
    private String chongqinLuckySectionExpect;

    /**
     * 是不是过期确认地址，用户过来15天后还未确认地址，将作废
     */
    private String isCofirmAddrOutDate;

    /**
     * 游览次数
     */
    private Integer readCount;

    /**
     * 推送用户打开的次数
     */
    private Integer ispushCount;

    private String showTitle;

    private String showDesc;

    private String showImg;

    private String showUrl;

    /**
     * 级别要求
     */
    private String other1;

    /**
     * 特殊配置2
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

    /**
     * 购买到最后一个的编号
     */
    private String lastLuckNumber;

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

    public Long getShopItemTempletId() {
        return shopItemTempletId;
    }

    public void setShopItemTempletId(Long shopItemTempletId) {
        this.shopItemTempletId = shopItemTempletId;
    }

    public Long getCurrentItemId() {
        return currentItemId;
    }

    public void setCurrentItemId(Long currentItemId) {
        this.currentItemId = currentItemId;
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

    public Integer getApplyCount() {
        return applyCount;
    }

    public void setApplyCount(Integer applyCount) {
        this.applyCount = applyCount;
    }

    public Integer getRemainCount() {
        return remainCount;
    }

    public void setRemainCount(Integer remainCount) {
        this.remainCount = remainCount;
    }

    public Double getDirectBuyPrice() {
        return directBuyPrice;
    }

    public void setDirectBuyPrice(Double directBuyPrice) {
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

    public Long getAllSectionCount() {
        return allSectionCount;
    }

    public void setAllSectionCount(Long allSectionCount) {
        this.allSectionCount = allSectionCount;
    }

    public String getLuckUserId() {
        return luckUserId;
    }

    public void setLuckUserId(String luckUserId) {
        this.luckUserId = luckUserId;
    }

    public String getLuckNo() {
        return luckNo;
    }

    public void setLuckNo(String luckNo) {
        this.luckNo = luckNo;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    public Integer getApplyPersonCount() {
        return applyPersonCount;
    }

    public void setApplyPersonCount(Integer applyPersonCount) {
        this.applyPersonCount = applyPersonCount;
    }

    public Date getOpenDatetime() {
        return openDatetime;
    }

    public void setOpenDatetime(Date openDatetime) {
        this.openDatetime = openDatetime;
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

    public String getIsHelp() {
        return isHelp;
    }

    public void setIsHelp(String isHelp) {
        this.isHelp = isHelp;
    }

    public String getCurrentPresent() {
        return currentPresent;
    }

    public void setCurrentPresent(String currentPresent) {
        this.currentPresent = currentPresent;
    }

    public String getChongqinLuckyNoB() {
        return chongqinLuckyNoB;
    }

    public void setChongqinLuckyNoB(String chongqinLuckyNoB) {
        this.chongqinLuckyNoB = chongqinLuckyNoB;
    }

    public String getCountLuckyNoA() {
        return countLuckyNoA;
    }

    public void setCountLuckyNoA(String countLuckyNoA) {
        this.countLuckyNoA = countLuckyNoA;
    }

    public Date getFirstBuyTime() {
        return firstBuyTime;
    }

    public void setFirstBuyTime(Date firstBuyTime) {
        this.firstBuyTime = firstBuyTime;
    }

    public String getChongqinLuckySection() {
        return chongqinLuckySection;
    }

    public void setChongqinLuckySection(String chongqinLuckySection) {
        this.chongqinLuckySection = chongqinLuckySection;
    }

    public String getChongqinLuckySectionExpect() {
        return chongqinLuckySectionExpect;
    }

    public void setChongqinLuckySectionExpect(String chongqinLuckySectionExpect) {
        this.chongqinLuckySectionExpect = chongqinLuckySectionExpect;
    }

    public String getIsCofirmAddrOutDate() {
        return isCofirmAddrOutDate;
    }

    public void setIsCofirmAddrOutDate(String isCofirmAddrOutDate) {
        this.isCofirmAddrOutDate = isCofirmAddrOutDate;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public Integer getIspushCount() {
        return ispushCount;
    }

    public void setIspushCount(Integer ispushCount) {
        this.ispushCount = ispushCount;
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

    public String getLastLuckNumber() {
        return lastLuckNumber;
    }

    public void setLastLuckNumber(String lastLuckNumber) {
        this.lastLuckNumber = lastLuckNumber;
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
        ShopItemInfoDo other = (ShopItemInfoDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getShopItemTempletId() == null ? other.getShopItemTempletId() == null : this.getShopItemTempletId().equals(other.getShopItemTempletId()))
            && (this.getCurrentItemId() == null ? other.getCurrentItemId() == null : this.getCurrentItemId().equals(other.getCurrentItemId()))
            && (this.getImgUrl() == null ? other.getImgUrl() == null : this.getImgUrl().equals(other.getImgUrl()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getTitleSub() == null ? other.getTitleSub() == null : this.getTitleSub().equals(other.getTitleSub()))
            && (this.getAdImg1() == null ? other.getAdImg1() == null : this.getAdImg1().equals(other.getAdImg1()))
            && (this.getAdImg2() == null ? other.getAdImg2() == null : this.getAdImg2().equals(other.getAdImg2()))
            && (this.getAdImg3() == null ? other.getAdImg3() == null : this.getAdImg3().equals(other.getAdImg3()))
            && (this.getAdImg4() == null ? other.getAdImg4() == null : this.getAdImg4().equals(other.getAdImg4()))
            && (this.getAdImg5() == null ? other.getAdImg5() == null : this.getAdImg5().equals(other.getAdImg5()))
            && (this.getItemDesc() == null ? other.getItemDesc() == null : this.getItemDesc().equals(other.getItemDesc()))
            && (this.getOrderNumber() == null ? other.getOrderNumber() == null : this.getOrderNumber().equals(other.getOrderNumber()))
            && (this.getPriceCount() == null ? other.getPriceCount() == null : this.getPriceCount().equals(other.getPriceCount()))
            && (this.getApplyCount() == null ? other.getApplyCount() == null : this.getApplyCount().equals(other.getApplyCount()))
            && (this.getRemainCount() == null ? other.getRemainCount() == null : this.getRemainCount().equals(other.getRemainCount()))
            && (this.getDirectBuyPrice() == null ? other.getDirectBuyPrice() == null : this.getDirectBuyPrice().equals(other.getDirectBuyPrice()))
            && (this.getDirectBuyPriceType() == null ? other.getDirectBuyPriceType() == null : this.getDirectBuyPriceType().equals(other.getDirectBuyPriceType()))
            && (this.getType1() == null ? other.getType1() == null : this.getType1().equals(other.getType1()))
            && (this.getType2() == null ? other.getType2() == null : this.getType2().equals(other.getType2()))
            && (this.getLogoType() == null ? other.getLogoType() == null : this.getLogoType().equals(other.getLogoType()))
            && (this.getBuyMinCount() == null ? other.getBuyMinCount() == null : this.getBuyMinCount().equals(other.getBuyMinCount()))
            && (this.getBuyMaxCount() == null ? other.getBuyMaxCount() == null : this.getBuyMaxCount().equals(other.getBuyMaxCount()))
            && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
            && (this.getItemProperty() == null ? other.getItemProperty() == null : this.getItemProperty().equals(other.getItemProperty()))
            && (this.getCurrentSection() == null ? other.getCurrentSection() == null : this.getCurrentSection().equals(other.getCurrentSection()))
            && (this.getIsOnline() == null ? other.getIsOnline() == null : this.getIsOnline().equals(other.getIsOnline()))
            && (this.getAllSectionCount() == null ? other.getAllSectionCount() == null : this.getAllSectionCount().equals(other.getAllSectionCount()))
            && (this.getLuckUserId() == null ? other.getLuckUserId() == null : this.getLuckUserId().equals(other.getLuckUserId()))
            && (this.getLuckNo() == null ? other.getLuckNo() == null : this.getLuckNo().equals(other.getLuckNo()))
            && (this.getItemStatus() == null ? other.getItemStatus() == null : this.getItemStatus().equals(other.getItemStatus()))
            && (this.getApplyPersonCount() == null ? other.getApplyPersonCount() == null : this.getApplyPersonCount().equals(other.getApplyPersonCount()))
            && (this.getOpenDatetime() == null ? other.getOpenDatetime() == null : this.getOpenDatetime().equals(other.getOpenDatetime()))
            && (this.getBuyPrizeType() == null ? other.getBuyPrizeType() == null : this.getBuyPrizeType().equals(other.getBuyPrizeType()))
            && (this.getBuyPrizeCount() == null ? other.getBuyPrizeCount() == null : this.getBuyPrizeCount().equals(other.getBuyPrizeCount()))
            && (this.getIsHelp() == null ? other.getIsHelp() == null : this.getIsHelp().equals(other.getIsHelp()))
            && (this.getCurrentPresent() == null ? other.getCurrentPresent() == null : this.getCurrentPresent().equals(other.getCurrentPresent()))
            && (this.getChongqinLuckyNoB() == null ? other.getChongqinLuckyNoB() == null : this.getChongqinLuckyNoB().equals(other.getChongqinLuckyNoB()))
            && (this.getCountLuckyNoA() == null ? other.getCountLuckyNoA() == null : this.getCountLuckyNoA().equals(other.getCountLuckyNoA()))
            && (this.getFirstBuyTime() == null ? other.getFirstBuyTime() == null : this.getFirstBuyTime().equals(other.getFirstBuyTime()))
            && (this.getChongqinLuckySection() == null ? other.getChongqinLuckySection() == null : this.getChongqinLuckySection().equals(other.getChongqinLuckySection()))
            && (this.getChongqinLuckySectionExpect() == null ? other.getChongqinLuckySectionExpect() == null : this.getChongqinLuckySectionExpect().equals(other.getChongqinLuckySectionExpect()))
            && (this.getIsCofirmAddrOutDate() == null ? other.getIsCofirmAddrOutDate() == null : this.getIsCofirmAddrOutDate().equals(other.getIsCofirmAddrOutDate()))
            && (this.getReadCount() == null ? other.getReadCount() == null : this.getReadCount().equals(other.getReadCount()))
            && (this.getIspushCount() == null ? other.getIspushCount() == null : this.getIspushCount().equals(other.getIspushCount()))
            && (this.getShowTitle() == null ? other.getShowTitle() == null : this.getShowTitle().equals(other.getShowTitle()))
            && (this.getShowDesc() == null ? other.getShowDesc() == null : this.getShowDesc().equals(other.getShowDesc()))
            && (this.getShowImg() == null ? other.getShowImg() == null : this.getShowImg().equals(other.getShowImg()))
            && (this.getShowUrl() == null ? other.getShowUrl() == null : this.getShowUrl().equals(other.getShowUrl()))
            && (this.getOther1() == null ? other.getOther1() == null : this.getOther1().equals(other.getOther1()))
            && (this.getOther2() == null ? other.getOther2() == null : this.getOther2().equals(other.getOther2()))
            && (this.getOther3() == null ? other.getOther3() == null : this.getOther3().equals(other.getOther3()))
            && (this.getOther4() == null ? other.getOther4() == null : this.getOther4().equals(other.getOther4()))
            && (this.getOther5() == null ? other.getOther5() == null : this.getOther5().equals(other.getOther5()))
            && (this.getLastLuckNumber() == null ? other.getLastLuckNumber() == null : this.getLastLuckNumber().equals(other.getLastLuckNumber()));
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
        result = prime * result + ((getShopItemTempletId() == null) ? 0 : getShopItemTempletId().hashCode());
        result = prime * result + ((getCurrentItemId() == null) ? 0 : getCurrentItemId().hashCode());
        result = prime * result + ((getImgUrl() == null) ? 0 : getImgUrl().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getTitleSub() == null) ? 0 : getTitleSub().hashCode());
        result = prime * result + ((getAdImg1() == null) ? 0 : getAdImg1().hashCode());
        result = prime * result + ((getAdImg2() == null) ? 0 : getAdImg2().hashCode());
        result = prime * result + ((getAdImg3() == null) ? 0 : getAdImg3().hashCode());
        result = prime * result + ((getAdImg4() == null) ? 0 : getAdImg4().hashCode());
        result = prime * result + ((getAdImg5() == null) ? 0 : getAdImg5().hashCode());
        result = prime * result + ((getItemDesc() == null) ? 0 : getItemDesc().hashCode());
        result = prime * result + ((getOrderNumber() == null) ? 0 : getOrderNumber().hashCode());
        result = prime * result + ((getPriceCount() == null) ? 0 : getPriceCount().hashCode());
        result = prime * result + ((getApplyCount() == null) ? 0 : getApplyCount().hashCode());
        result = prime * result + ((getRemainCount() == null) ? 0 : getRemainCount().hashCode());
        result = prime * result + ((getDirectBuyPrice() == null) ? 0 : getDirectBuyPrice().hashCode());
        result = prime * result + ((getDirectBuyPriceType() == null) ? 0 : getDirectBuyPriceType().hashCode());
        result = prime * result + ((getType1() == null) ? 0 : getType1().hashCode());
        result = prime * result + ((getType2() == null) ? 0 : getType2().hashCode());
        result = prime * result + ((getLogoType() == null) ? 0 : getLogoType().hashCode());
        result = prime * result + ((getBuyMinCount() == null) ? 0 : getBuyMinCount().hashCode());
        result = prime * result + ((getBuyMaxCount() == null) ? 0 : getBuyMaxCount().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        result = prime * result + ((getItemProperty() == null) ? 0 : getItemProperty().hashCode());
        result = prime * result + ((getCurrentSection() == null) ? 0 : getCurrentSection().hashCode());
        result = prime * result + ((getIsOnline() == null) ? 0 : getIsOnline().hashCode());
        result = prime * result + ((getAllSectionCount() == null) ? 0 : getAllSectionCount().hashCode());
        result = prime * result + ((getLuckUserId() == null) ? 0 : getLuckUserId().hashCode());
        result = prime * result + ((getLuckNo() == null) ? 0 : getLuckNo().hashCode());
        result = prime * result + ((getItemStatus() == null) ? 0 : getItemStatus().hashCode());
        result = prime * result + ((getApplyPersonCount() == null) ? 0 : getApplyPersonCount().hashCode());
        result = prime * result + ((getOpenDatetime() == null) ? 0 : getOpenDatetime().hashCode());
        result = prime * result + ((getBuyPrizeType() == null) ? 0 : getBuyPrizeType().hashCode());
        result = prime * result + ((getBuyPrizeCount() == null) ? 0 : getBuyPrizeCount().hashCode());
        result = prime * result + ((getIsHelp() == null) ? 0 : getIsHelp().hashCode());
        result = prime * result + ((getCurrentPresent() == null) ? 0 : getCurrentPresent().hashCode());
        result = prime * result + ((getChongqinLuckyNoB() == null) ? 0 : getChongqinLuckyNoB().hashCode());
        result = prime * result + ((getCountLuckyNoA() == null) ? 0 : getCountLuckyNoA().hashCode());
        result = prime * result + ((getFirstBuyTime() == null) ? 0 : getFirstBuyTime().hashCode());
        result = prime * result + ((getChongqinLuckySection() == null) ? 0 : getChongqinLuckySection().hashCode());
        result = prime * result + ((getChongqinLuckySectionExpect() == null) ? 0 : getChongqinLuckySectionExpect().hashCode());
        result = prime * result + ((getIsCofirmAddrOutDate() == null) ? 0 : getIsCofirmAddrOutDate().hashCode());
        result = prime * result + ((getReadCount() == null) ? 0 : getReadCount().hashCode());
        result = prime * result + ((getIspushCount() == null) ? 0 : getIspushCount().hashCode());
        result = prime * result + ((getShowTitle() == null) ? 0 : getShowTitle().hashCode());
        result = prime * result + ((getShowDesc() == null) ? 0 : getShowDesc().hashCode());
        result = prime * result + ((getShowImg() == null) ? 0 : getShowImg().hashCode());
        result = prime * result + ((getShowUrl() == null) ? 0 : getShowUrl().hashCode());
        result = prime * result + ((getOther1() == null) ? 0 : getOther1().hashCode());
        result = prime * result + ((getOther2() == null) ? 0 : getOther2().hashCode());
        result = prime * result + ((getOther3() == null) ? 0 : getOther3().hashCode());
        result = prime * result + ((getOther4() == null) ? 0 : getOther4().hashCode());
        result = prime * result + ((getOther5() == null) ? 0 : getOther5().hashCode());
        result = prime * result + ((getLastLuckNumber() == null) ? 0 : getLastLuckNumber().hashCode());
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
        sb.append(", shopItemTempletId=").append(shopItemTempletId);
        sb.append(", currentItemId=").append(currentItemId);
        sb.append(", imgUrl=").append(imgUrl);
        sb.append(", title=").append(title);
        sb.append(", titleSub=").append(titleSub);
        sb.append(", adImg1=").append(adImg1);
        sb.append(", adImg2=").append(adImg2);
        sb.append(", adImg3=").append(adImg3);
        sb.append(", adImg4=").append(adImg4);
        sb.append(", adImg5=").append(adImg5);
        sb.append(", itemDesc=").append(itemDesc);
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", priceCount=").append(priceCount);
        sb.append(", applyCount=").append(applyCount);
        sb.append(", remainCount=").append(remainCount);
        sb.append(", directBuyPrice=").append(directBuyPrice);
        sb.append(", directBuyPriceType=").append(directBuyPriceType);
        sb.append(", type1=").append(type1);
        sb.append(", type2=").append(type2);
        sb.append(", logoType=").append(logoType);
        sb.append(", buyMinCount=").append(buyMinCount);
        sb.append(", buyMaxCount=").append(buyMaxCount);
        sb.append(", payType=").append(payType);
        sb.append(", itemProperty=").append(itemProperty);
        sb.append(", currentSection=").append(currentSection);
        sb.append(", isOnline=").append(isOnline);
        sb.append(", allSectionCount=").append(allSectionCount);
        sb.append(", luckUserId=").append(luckUserId);
        sb.append(", luckNo=").append(luckNo);
        sb.append(", itemStatus=").append(itemStatus);
        sb.append(", applyPersonCount=").append(applyPersonCount);
        sb.append(", openDatetime=").append(openDatetime);
        sb.append(", buyPrizeType=").append(buyPrizeType);
        sb.append(", buyPrizeCount=").append(buyPrizeCount);
        sb.append(", isHelp=").append(isHelp);
        sb.append(", currentPresent=").append(currentPresent);
        sb.append(", chongqinLuckyNoB=").append(chongqinLuckyNoB);
        sb.append(", countLuckyNoA=").append(countLuckyNoA);
        sb.append(", firstBuyTime=").append(firstBuyTime);
        sb.append(", chongqinLuckySection=").append(chongqinLuckySection);
        sb.append(", chongqinLuckySectionExpect=").append(chongqinLuckySectionExpect);
        sb.append(", isCofirmAddrOutDate=").append(isCofirmAddrOutDate);
        sb.append(", readCount=").append(readCount);
        sb.append(", ispushCount=").append(ispushCount);
        sb.append(", showTitle=").append(showTitle);
        sb.append(", showDesc=").append(showDesc);
        sb.append(", showImg=").append(showImg);
        sb.append(", showUrl=").append(showUrl);
        sb.append(", other1=").append(other1);
        sb.append(", other2=").append(other2);
        sb.append(", other3=").append(other3);
        sb.append(", other4=").append(other4);
        sb.append(", other5=").append(other5);
        sb.append(", lastLuckNumber=").append(lastLuckNumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
package com.hndl.cn.dao.common.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * common_game_info
 * @author 
 */
public class CommonGameInfoDo implements Serializable {
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
     * 游戏名称
     */
    private String gameName;

    /**
     * 游戏描述
     */
    private String gameDesc;

    /**
     * 活动ID
     */
    private Integer activityId;

    /**
     * 顺序值大的排越上面
     */
    private Integer orderNum;

    /**
     * 开始时间
     */
    private Date startDate;

    /**
     * 结束时间
     */
    private Date endDate;

    /**
     * 标题
     */
    private String title;

    /**
     * 第二标题
     */
    private String titleSecond;

    /**
     * 多少人玩过了，参与了 这个游戏
     */
    private Integer applyCount;

    /**
     * 游戏logo
     */
    private String imgUrl;

    /**
     * 游戏类型：db存：抽奖、红包、竞猜、投票、点播、直播
     */
    private String type;

    /**
     * 期数(如果这个游戏是竞猜类、投票类的，这个字段关联到投票的选项和题目表的section字段)
     */
    private String section;

    /**
     * 免费玩次数
     */
    private Integer freeTimes;

    /**
     * 不免费次数
     */
    private Integer noFreeTimes;

    /**
     * db存：/dou/coin/第三方支付  thridPay/第三方支付+芒果币 thridPayCoin
     */
    private String payType;

    /**
     * w玩一次这个游戏需要的金额(单位：几分钱/芒果豆)
     */
    private Integer payCount;

    /**
     * 如果这个游戏有多期、这个字段表示当前展示哪期 废弃
     */
    private String isShow;

    /**
     * 这个游戏主页面被查看的次数
     */
    private Integer readCount;

    /**
     * 轮播图1
     */
    private String adUrl1;

    private String adUrl2;

    private String adUrl3;

    private String adUrl4;

    private String adUrl5;

    /**
     * 游戏的规则图片
     */
    private String ruleUrl;

    /**
     * 竞猜猜的哪组
     */
    private String guessGroup;

    /**
     * 投票投的选项id
     */
    private Long voteId;

    /**
     * 直播点播的内容id
     */
    private String contentId;

    private String showTitle;

    private String showDesc;

    private String showImg;

    private String showUrl;

    /**
     * 这个游戏用户中了积分后点击“去夺宝”按钮的次数
     */
    private Integer toShopOnclickCount;

    /**
     * 初始的参与人数字段
     */
    private Integer initApplyCount;

    /**
     * 特殊配置1
     */
    private String other1;

    /**
     * 特殊配置2
     */
    private String other2;

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

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameDesc() {
        return gameDesc;
    }

    public void setGameDesc(String gameDesc) {
        this.gameDesc = gameDesc;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleSecond() {
        return titleSecond;
    }

    public void setTitleSecond(String titleSecond) {
        this.titleSecond = titleSecond;
    }

    public Integer getApplyCount() {
        return applyCount;
    }

    public void setApplyCount(Integer applyCount) {
        this.applyCount = applyCount;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Integer getFreeTimes() {
        return freeTimes;
    }

    public void setFreeTimes(Integer freeTimes) {
        this.freeTimes = freeTimes;
    }

    public Integer getNoFreeTimes() {
        return noFreeTimes;
    }

    public void setNoFreeTimes(Integer noFreeTimes) {
        this.noFreeTimes = noFreeTimes;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public Integer getPayCount() {
        return payCount;
    }

    public void setPayCount(Integer payCount) {
        this.payCount = payCount;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public String getAdUrl1() {
        return adUrl1;
    }

    public void setAdUrl1(String adUrl1) {
        this.adUrl1 = adUrl1;
    }

    public String getAdUrl2() {
        return adUrl2;
    }

    public void setAdUrl2(String adUrl2) {
        this.adUrl2 = adUrl2;
    }

    public String getAdUrl3() {
        return adUrl3;
    }

    public void setAdUrl3(String adUrl3) {
        this.adUrl3 = adUrl3;
    }

    public String getAdUrl4() {
        return adUrl4;
    }

    public void setAdUrl4(String adUrl4) {
        this.adUrl4 = adUrl4;
    }

    public String getAdUrl5() {
        return adUrl5;
    }

    public void setAdUrl5(String adUrl5) {
        this.adUrl5 = adUrl5;
    }

    public String getRuleUrl() {
        return ruleUrl;
    }

    public void setRuleUrl(String ruleUrl) {
        this.ruleUrl = ruleUrl;
    }

    public String getGuessGroup() {
        return guessGroup;
    }

    public void setGuessGroup(String guessGroup) {
        this.guessGroup = guessGroup;
    }

    public Long getVoteId() {
        return voteId;
    }

    public void setVoteId(Long voteId) {
        this.voteId = voteId;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
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

    public Integer getToShopOnclickCount() {
        return toShopOnclickCount;
    }

    public void setToShopOnclickCount(Integer toShopOnclickCount) {
        this.toShopOnclickCount = toShopOnclickCount;
    }

    public Integer getInitApplyCount() {
        return initApplyCount;
    }

    public void setInitApplyCount(Integer initApplyCount) {
        this.initApplyCount = initApplyCount;
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
        CommonGameInfoDo other = (CommonGameInfoDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getGameName() == null ? other.getGameName() == null : this.getGameName().equals(other.getGameName()))
            && (this.getGameDesc() == null ? other.getGameDesc() == null : this.getGameDesc().equals(other.getGameDesc()))
            && (this.getActivityId() == null ? other.getActivityId() == null : this.getActivityId().equals(other.getActivityId()))
            && (this.getOrderNum() == null ? other.getOrderNum() == null : this.getOrderNum().equals(other.getOrderNum()))
            && (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getTitleSecond() == null ? other.getTitleSecond() == null : this.getTitleSecond().equals(other.getTitleSecond()))
            && (this.getApplyCount() == null ? other.getApplyCount() == null : this.getApplyCount().equals(other.getApplyCount()))
            && (this.getImgUrl() == null ? other.getImgUrl() == null : this.getImgUrl().equals(other.getImgUrl()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getSection() == null ? other.getSection() == null : this.getSection().equals(other.getSection()))
            && (this.getFreeTimes() == null ? other.getFreeTimes() == null : this.getFreeTimes().equals(other.getFreeTimes()))
            && (this.getNoFreeTimes() == null ? other.getNoFreeTimes() == null : this.getNoFreeTimes().equals(other.getNoFreeTimes()))
            && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
            && (this.getPayCount() == null ? other.getPayCount() == null : this.getPayCount().equals(other.getPayCount()))
            && (this.getIsShow() == null ? other.getIsShow() == null : this.getIsShow().equals(other.getIsShow()))
            && (this.getReadCount() == null ? other.getReadCount() == null : this.getReadCount().equals(other.getReadCount()))
            && (this.getAdUrl1() == null ? other.getAdUrl1() == null : this.getAdUrl1().equals(other.getAdUrl1()))
            && (this.getAdUrl2() == null ? other.getAdUrl2() == null : this.getAdUrl2().equals(other.getAdUrl2()))
            && (this.getAdUrl3() == null ? other.getAdUrl3() == null : this.getAdUrl3().equals(other.getAdUrl3()))
            && (this.getAdUrl4() == null ? other.getAdUrl4() == null : this.getAdUrl4().equals(other.getAdUrl4()))
            && (this.getAdUrl5() == null ? other.getAdUrl5() == null : this.getAdUrl5().equals(other.getAdUrl5()))
            && (this.getRuleUrl() == null ? other.getRuleUrl() == null : this.getRuleUrl().equals(other.getRuleUrl()))
            && (this.getGuessGroup() == null ? other.getGuessGroup() == null : this.getGuessGroup().equals(other.getGuessGroup()))
            && (this.getVoteId() == null ? other.getVoteId() == null : this.getVoteId().equals(other.getVoteId()))
            && (this.getContentId() == null ? other.getContentId() == null : this.getContentId().equals(other.getContentId()))
            && (this.getShowTitle() == null ? other.getShowTitle() == null : this.getShowTitle().equals(other.getShowTitle()))
            && (this.getShowDesc() == null ? other.getShowDesc() == null : this.getShowDesc().equals(other.getShowDesc()))
            && (this.getShowImg() == null ? other.getShowImg() == null : this.getShowImg().equals(other.getShowImg()))
            && (this.getShowUrl() == null ? other.getShowUrl() == null : this.getShowUrl().equals(other.getShowUrl()))
            && (this.getToShopOnclickCount() == null ? other.getToShopOnclickCount() == null : this.getToShopOnclickCount().equals(other.getToShopOnclickCount()))
            && (this.getInitApplyCount() == null ? other.getInitApplyCount() == null : this.getInitApplyCount().equals(other.getInitApplyCount()))
            && (this.getOther1() == null ? other.getOther1() == null : this.getOther1().equals(other.getOther1()))
            && (this.getOther2() == null ? other.getOther2() == null : this.getOther2().equals(other.getOther2()));
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
        result = prime * result + ((getGameName() == null) ? 0 : getGameName().hashCode());
        result = prime * result + ((getGameDesc() == null) ? 0 : getGameDesc().hashCode());
        result = prime * result + ((getActivityId() == null) ? 0 : getActivityId().hashCode());
        result = prime * result + ((getOrderNum() == null) ? 0 : getOrderNum().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getTitleSecond() == null) ? 0 : getTitleSecond().hashCode());
        result = prime * result + ((getApplyCount() == null) ? 0 : getApplyCount().hashCode());
        result = prime * result + ((getImgUrl() == null) ? 0 : getImgUrl().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getSection() == null) ? 0 : getSection().hashCode());
        result = prime * result + ((getFreeTimes() == null) ? 0 : getFreeTimes().hashCode());
        result = prime * result + ((getNoFreeTimes() == null) ? 0 : getNoFreeTimes().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        result = prime * result + ((getPayCount() == null) ? 0 : getPayCount().hashCode());
        result = prime * result + ((getIsShow() == null) ? 0 : getIsShow().hashCode());
        result = prime * result + ((getReadCount() == null) ? 0 : getReadCount().hashCode());
        result = prime * result + ((getAdUrl1() == null) ? 0 : getAdUrl1().hashCode());
        result = prime * result + ((getAdUrl2() == null) ? 0 : getAdUrl2().hashCode());
        result = prime * result + ((getAdUrl3() == null) ? 0 : getAdUrl3().hashCode());
        result = prime * result + ((getAdUrl4() == null) ? 0 : getAdUrl4().hashCode());
        result = prime * result + ((getAdUrl5() == null) ? 0 : getAdUrl5().hashCode());
        result = prime * result + ((getRuleUrl() == null) ? 0 : getRuleUrl().hashCode());
        result = prime * result + ((getGuessGroup() == null) ? 0 : getGuessGroup().hashCode());
        result = prime * result + ((getVoteId() == null) ? 0 : getVoteId().hashCode());
        result = prime * result + ((getContentId() == null) ? 0 : getContentId().hashCode());
        result = prime * result + ((getShowTitle() == null) ? 0 : getShowTitle().hashCode());
        result = prime * result + ((getShowDesc() == null) ? 0 : getShowDesc().hashCode());
        result = prime * result + ((getShowImg() == null) ? 0 : getShowImg().hashCode());
        result = prime * result + ((getShowUrl() == null) ? 0 : getShowUrl().hashCode());
        result = prime * result + ((getToShopOnclickCount() == null) ? 0 : getToShopOnclickCount().hashCode());
        result = prime * result + ((getInitApplyCount() == null) ? 0 : getInitApplyCount().hashCode());
        result = prime * result + ((getOther1() == null) ? 0 : getOther1().hashCode());
        result = prime * result + ((getOther2() == null) ? 0 : getOther2().hashCode());
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
        sb.append(", gameName=").append(gameName);
        sb.append(", gameDesc=").append(gameDesc);
        sb.append(", activityId=").append(activityId);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", title=").append(title);
        sb.append(", titleSecond=").append(titleSecond);
        sb.append(", applyCount=").append(applyCount);
        sb.append(", imgUrl=").append(imgUrl);
        sb.append(", type=").append(type);
        sb.append(", section=").append(section);
        sb.append(", freeTimes=").append(freeTimes);
        sb.append(", noFreeTimes=").append(noFreeTimes);
        sb.append(", payType=").append(payType);
        sb.append(", payCount=").append(payCount);
        sb.append(", isShow=").append(isShow);
        sb.append(", readCount=").append(readCount);
        sb.append(", adUrl1=").append(adUrl1);
        sb.append(", adUrl2=").append(adUrl2);
        sb.append(", adUrl3=").append(adUrl3);
        sb.append(", adUrl4=").append(adUrl4);
        sb.append(", adUrl5=").append(adUrl5);
        sb.append(", ruleUrl=").append(ruleUrl);
        sb.append(", guessGroup=").append(guessGroup);
        sb.append(", voteId=").append(voteId);
        sb.append(", contentId=").append(contentId);
        sb.append(", showTitle=").append(showTitle);
        sb.append(", showDesc=").append(showDesc);
        sb.append(", showImg=").append(showImg);
        sb.append(", showUrl=").append(showUrl);
        sb.append(", toShopOnclickCount=").append(toShopOnclickCount);
        sb.append(", initApplyCount=").append(initApplyCount);
        sb.append(", other1=").append(other1);
        sb.append(", other2=").append(other2);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
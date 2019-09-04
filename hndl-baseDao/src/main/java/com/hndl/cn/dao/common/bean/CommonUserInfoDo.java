package com.hndl.cn.dao.common.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * common_user_info
 * @author 
 */
public class CommonUserInfoDo implements Serializable {
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
     * 手机网络类型
     */
    private String netType;

    /**
     * 手机号码(登录名)
     */
    private String phoneNum;

    /**
     * 个人的手机号
     */
    private Long phoneNumPerson;

    /**
     * 动态密码
     */
    private String dynamicPassword;

    /**
     * 密码
     */
    private String password;

    /**
     * 注册验证码
     */
    private String confirmNumberLogin;

    /**
     * 修改验证码
     */
    private String confirmNumberForget;

    /**
     * 是否为vip
     */
    private String isVip;

    /**
     * vip类型(包月/按次)
     */
    private String vipType;

    /**
     * vip开始日期
     */
    private Date vipStartDate;

    /**
     * VIP结束日期
     */
    private Date vipEndDate;

    /**
     * 包月用户首次玩游戏是否中奖
     */
    private String isFirstGameWin;

    /**
     * 我是歌手的 累积签到次数
     */
    private Integer imsSignTotalDay;

    /**
     * 我是歌手的 连续签到次数
     */
    private Integer imsSignContinueDay;

    /**
     * 包月100%第一次中奖是否线下真正领奖
     */
    private String isGivePrize;

    /**
     * 姓名(作废)
     */
    private String personName;

    /**
     * 修改手机号的时候临时的手机号
     */
    private String prizeGivePhone;

    /**
     * 个人头像大图片地址(网址) max和min默认一样
     */
    private String personImgUrlMax;

    /**
     * 个人头像小图片地址(网址)max和min默认一样
     */
    private String personImgUrlMin;

    /**
     * 芒果豆、积分
     */
    private Integer doudouCount;

    /**
     * 芒果币
     */
    private Double coniCount;

    /**
     * 微信或者qq昵称或者最后自己修改后的昵称
     */
    private String nickName;

    /**
     * 微信的openid
     */
    private String weixinOpenId;

    private String weixinUniId;

    /**
     * 手机设备号，创建游客账号
     */
    private String deviceNumber;

    /**
     * qq的openid
     */
    private String qqOpenId;

    /**
     * 是否为平台自动生成的机器人用户
     */
    private String isRobot;

    /**
     * 机器人的下单ip, 机器人用户生成时，下单ip就分配了
     */
    private String robotOrderIp;

    /**
     * 手机类型：ios/android
     */
    private String appType;

    /**
     * 手机型号
     */
    private String phoneName;

    private String isTaskPhone;

    private String isTaskAddress;

    private Integer taskAllDoudou;

    /**
     * 用户的渠道标识
     */
    private String umengChannel;

    private Integer smsSendCount;

    private Date smsSendLastTime;

    private Integer contributionValue;

    private Integer contributionLevel;

    /**
     * 师父/邀请人的ID
     */
    private String lastUserId;

    /**
     * 贡献值
     */
    private String requestCode;

    private Integer showAddSendSmsEveryday;

    private Integer showAddSendJpushEveryday;

    private Date showAddSendSmsDate;

    private Date showAddSendJpushDate;

    /**
     * 幸运值多少(华人春晚累加的）
     */
    private Integer luckyCount;

    /**
     * 用户参加活动时候填的手机号
     */
    private Long phoneNumberActivity;

    private Integer luckyShopCount;

    /**
     * 微博的openid
     */
    private String weiboOpenId;

    /**
     * 明星头像1
     */
    private String starImgOne;

    /**
     * 明星头像2
     */
    private String starImgTwo;

    /**
     * 明星头像3
     */
    private String starImgThree;

    /**
     * 明星ID1
     */
    private Long starIdOne;

    /**
     * 明星ID2
     */
    private Long starIdTwo;

    /**
     * 明星ID3
     */
    private Long starIdThree;

    /**
     * 总投票数1
     */
    private Integer voteCountOne;

    /**
     * 总投票数2
     */
    private Integer voteCountTwo;

    /**
     * 总投票数3
     */
    private Integer voteCountThree;

    /**
     * 明星描述1
     */
    private String starDescOne;

    /**
     * 明星描述2
     */
    private String starDescTwo;

    /**
     * 明星描述3
     */
    private String starDescThree;

    /**
     * 明星性别1：M/F（男/女）
     */
    private String starSexOne;

    /**
     * 明星性别2：M/F（男/女）
     */
    private String starSexTwo;

    /**
     * 明星性别3：M/F（男/女）
     */
    private String starSexThree;

    /**
     * 第一个明星粉丝级别
     */
    private Integer starLevelOne;

    /**
     * 个人首页 背景图片
     */
    private String personalHomepageImg;

    /**
     * 个人签名
     */
    private String personalAutograph;

    /**
     * 累计的爱心值
     */
    private Long heartCount;

    /**
     * 当日获得的爱心值
     */
    private Integer heartCountToday;

    /**
     * 公益-累积捐赠爱心
     */
    private Long heartDonateCount;

    /**
     * 公益-累积捐赠钱
     */
    private Double moneyDonateCount;

    /**
     * 小程序openId
     */
    private String xcxOpenId;

    /**
     * 系统唯一标识id
     */
    private Long sysUniId;

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

    public String getNetType() {
        return netType;
    }

    public void setNetType(String netType) {
        this.netType = netType;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Long getPhoneNumPerson() {
        return phoneNumPerson;
    }

    public void setPhoneNumPerson(Long phoneNumPerson) {
        this.phoneNumPerson = phoneNumPerson;
    }

    public String getDynamicPassword() {
        return dynamicPassword;
    }

    public void setDynamicPassword(String dynamicPassword) {
        this.dynamicPassword = dynamicPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmNumberLogin() {
        return confirmNumberLogin;
    }

    public void setConfirmNumberLogin(String confirmNumberLogin) {
        this.confirmNumberLogin = confirmNumberLogin;
    }

    public String getConfirmNumberForget() {
        return confirmNumberForget;
    }

    public void setConfirmNumberForget(String confirmNumberForget) {
        this.confirmNumberForget = confirmNumberForget;
    }

    public String getIsVip() {
        return isVip;
    }

    public void setIsVip(String isVip) {
        this.isVip = isVip;
    }

    public String getVipType() {
        return vipType;
    }

    public void setVipType(String vipType) {
        this.vipType = vipType;
    }

    public Date getVipStartDate() {
        return vipStartDate;
    }

    public void setVipStartDate(Date vipStartDate) {
        this.vipStartDate = vipStartDate;
    }

    public Date getVipEndDate() {
        return vipEndDate;
    }

    public void setVipEndDate(Date vipEndDate) {
        this.vipEndDate = vipEndDate;
    }

    public String getIsFirstGameWin() {
        return isFirstGameWin;
    }

    public void setIsFirstGameWin(String isFirstGameWin) {
        this.isFirstGameWin = isFirstGameWin;
    }

    public Integer getImsSignTotalDay() {
        return imsSignTotalDay;
    }

    public void setImsSignTotalDay(Integer imsSignTotalDay) {
        this.imsSignTotalDay = imsSignTotalDay;
    }

    public Integer getImsSignContinueDay() {
        return imsSignContinueDay;
    }

    public void setImsSignContinueDay(Integer imsSignContinueDay) {
        this.imsSignContinueDay = imsSignContinueDay;
    }

    public String getIsGivePrize() {
        return isGivePrize;
    }

    public void setIsGivePrize(String isGivePrize) {
        this.isGivePrize = isGivePrize;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPrizeGivePhone() {
        return prizeGivePhone;
    }

    public void setPrizeGivePhone(String prizeGivePhone) {
        this.prizeGivePhone = prizeGivePhone;
    }

    public String getPersonImgUrlMax() {
        return personImgUrlMax;
    }

    public void setPersonImgUrlMax(String personImgUrlMax) {
        this.personImgUrlMax = personImgUrlMax;
    }

    public String getPersonImgUrlMin() {
        return personImgUrlMin;
    }

    public void setPersonImgUrlMin(String personImgUrlMin) {
        this.personImgUrlMin = personImgUrlMin;
    }

    public Integer getDoudouCount() {
        return doudouCount;
    }

    public void setDoudouCount(Integer doudouCount) {
        this.doudouCount = doudouCount;
    }

    public Double getConiCount() {
        return coniCount;
    }

    public void setConiCount(Double coniCount) {
        this.coniCount = coniCount;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getWeixinOpenId() {
        return weixinOpenId;
    }

    public void setWeixinOpenId(String weixinOpenId) {
        this.weixinOpenId = weixinOpenId;
    }

    public String getWeixinUniId() {
        return weixinUniId;
    }

    public void setWeixinUniId(String weixinUniId) {
        this.weixinUniId = weixinUniId;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public String getQqOpenId() {
        return qqOpenId;
    }

    public void setQqOpenId(String qqOpenId) {
        this.qqOpenId = qqOpenId;
    }

    public String getIsRobot() {
        return isRobot;
    }

    public void setIsRobot(String isRobot) {
        this.isRobot = isRobot;
    }

    public String getRobotOrderIp() {
        return robotOrderIp;
    }

    public void setRobotOrderIp(String robotOrderIp) {
        this.robotOrderIp = robotOrderIp;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getIsTaskPhone() {
        return isTaskPhone;
    }

    public void setIsTaskPhone(String isTaskPhone) {
        this.isTaskPhone = isTaskPhone;
    }

    public String getIsTaskAddress() {
        return isTaskAddress;
    }

    public void setIsTaskAddress(String isTaskAddress) {
        this.isTaskAddress = isTaskAddress;
    }

    public Integer getTaskAllDoudou() {
        return taskAllDoudou;
    }

    public void setTaskAllDoudou(Integer taskAllDoudou) {
        this.taskAllDoudou = taskAllDoudou;
    }

    public String getUmengChannel() {
        return umengChannel;
    }

    public void setUmengChannel(String umengChannel) {
        this.umengChannel = umengChannel;
    }

    public Integer getSmsSendCount() {
        return smsSendCount;
    }

    public void setSmsSendCount(Integer smsSendCount) {
        this.smsSendCount = smsSendCount;
    }

    public Date getSmsSendLastTime() {
        return smsSendLastTime;
    }

    public void setSmsSendLastTime(Date smsSendLastTime) {
        this.smsSendLastTime = smsSendLastTime;
    }

    public Integer getContributionValue() {
        return contributionValue;
    }

    public void setContributionValue(Integer contributionValue) {
        this.contributionValue = contributionValue;
    }

    public Integer getContributionLevel() {
        return contributionLevel;
    }

    public void setContributionLevel(Integer contributionLevel) {
        this.contributionLevel = contributionLevel;
    }

    public String getLastUserId() {
        return lastUserId;
    }

    public void setLastUserId(String lastUserId) {
        this.lastUserId = lastUserId;
    }

    public String getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(String requestCode) {
        this.requestCode = requestCode;
    }

    public Integer getShowAddSendSmsEveryday() {
        return showAddSendSmsEveryday;
    }

    public void setShowAddSendSmsEveryday(Integer showAddSendSmsEveryday) {
        this.showAddSendSmsEveryday = showAddSendSmsEveryday;
    }

    public Integer getShowAddSendJpushEveryday() {
        return showAddSendJpushEveryday;
    }

    public void setShowAddSendJpushEveryday(Integer showAddSendJpushEveryday) {
        this.showAddSendJpushEveryday = showAddSendJpushEveryday;
    }

    public Date getShowAddSendSmsDate() {
        return showAddSendSmsDate;
    }

    public void setShowAddSendSmsDate(Date showAddSendSmsDate) {
        this.showAddSendSmsDate = showAddSendSmsDate;
    }

    public Date getShowAddSendJpushDate() {
        return showAddSendJpushDate;
    }

    public void setShowAddSendJpushDate(Date showAddSendJpushDate) {
        this.showAddSendJpushDate = showAddSendJpushDate;
    }

    public Integer getLuckyCount() {
        return luckyCount;
    }

    public void setLuckyCount(Integer luckyCount) {
        this.luckyCount = luckyCount;
    }

    public Long getPhoneNumberActivity() {
        return phoneNumberActivity;
    }

    public void setPhoneNumberActivity(Long phoneNumberActivity) {
        this.phoneNumberActivity = phoneNumberActivity;
    }

    public Integer getLuckyShopCount() {
        return luckyShopCount;
    }

    public void setLuckyShopCount(Integer luckyShopCount) {
        this.luckyShopCount = luckyShopCount;
    }

    public String getWeiboOpenId() {
        return weiboOpenId;
    }

    public void setWeiboOpenId(String weiboOpenId) {
        this.weiboOpenId = weiboOpenId;
    }

    public String getStarImgOne() {
        return starImgOne;
    }

    public void setStarImgOne(String starImgOne) {
        this.starImgOne = starImgOne;
    }

    public String getStarImgTwo() {
        return starImgTwo;
    }

    public void setStarImgTwo(String starImgTwo) {
        this.starImgTwo = starImgTwo;
    }

    public String getStarImgThree() {
        return starImgThree;
    }

    public void setStarImgThree(String starImgThree) {
        this.starImgThree = starImgThree;
    }

    public Long getStarIdOne() {
        return starIdOne;
    }

    public void setStarIdOne(Long starIdOne) {
        this.starIdOne = starIdOne;
    }

    public Long getStarIdTwo() {
        return starIdTwo;
    }

    public void setStarIdTwo(Long starIdTwo) {
        this.starIdTwo = starIdTwo;
    }

    public Long getStarIdThree() {
        return starIdThree;
    }

    public void setStarIdThree(Long starIdThree) {
        this.starIdThree = starIdThree;
    }

    public Integer getVoteCountOne() {
        return voteCountOne;
    }

    public void setVoteCountOne(Integer voteCountOne) {
        this.voteCountOne = voteCountOne;
    }

    public Integer getVoteCountTwo() {
        return voteCountTwo;
    }

    public void setVoteCountTwo(Integer voteCountTwo) {
        this.voteCountTwo = voteCountTwo;
    }

    public Integer getVoteCountThree() {
        return voteCountThree;
    }

    public void setVoteCountThree(Integer voteCountThree) {
        this.voteCountThree = voteCountThree;
    }

    public String getStarDescOne() {
        return starDescOne;
    }

    public void setStarDescOne(String starDescOne) {
        this.starDescOne = starDescOne;
    }

    public String getStarDescTwo() {
        return starDescTwo;
    }

    public void setStarDescTwo(String starDescTwo) {
        this.starDescTwo = starDescTwo;
    }

    public String getStarDescThree() {
        return starDescThree;
    }

    public void setStarDescThree(String starDescThree) {
        this.starDescThree = starDescThree;
    }

    public String getStarSexOne() {
        return starSexOne;
    }

    public void setStarSexOne(String starSexOne) {
        this.starSexOne = starSexOne;
    }

    public String getStarSexTwo() {
        return starSexTwo;
    }

    public void setStarSexTwo(String starSexTwo) {
        this.starSexTwo = starSexTwo;
    }

    public String getStarSexThree() {
        return starSexThree;
    }

    public void setStarSexThree(String starSexThree) {
        this.starSexThree = starSexThree;
    }

    public Integer getStarLevelOne() {
        return starLevelOne;
    }

    public void setStarLevelOne(Integer starLevelOne) {
        this.starLevelOne = starLevelOne;
    }

    public String getPersonalHomepageImg() {
        return personalHomepageImg;
    }

    public void setPersonalHomepageImg(String personalHomepageImg) {
        this.personalHomepageImg = personalHomepageImg;
    }

    public String getPersonalAutograph() {
        return personalAutograph;
    }

    public void setPersonalAutograph(String personalAutograph) {
        this.personalAutograph = personalAutograph;
    }

    public Long getHeartCount() {
        return heartCount;
    }

    public void setHeartCount(Long heartCount) {
        this.heartCount = heartCount;
    }

    public Integer getHeartCountToday() {
        return heartCountToday;
    }

    public void setHeartCountToday(Integer heartCountToday) {
        this.heartCountToday = heartCountToday;
    }

    public Long getHeartDonateCount() {
        return heartDonateCount;
    }

    public void setHeartDonateCount(Long heartDonateCount) {
        this.heartDonateCount = heartDonateCount;
    }

    public Double getMoneyDonateCount() {
        return moneyDonateCount;
    }

    public void setMoneyDonateCount(Double moneyDonateCount) {
        this.moneyDonateCount = moneyDonateCount;
    }

    public String getXcxOpenId() {
        return xcxOpenId;
    }

    public void setXcxOpenId(String xcxOpenId) {
        this.xcxOpenId = xcxOpenId;
    }

    public Long getSysUniId() {
        return sysUniId;
    }

    public void setSysUniId(Long sysUniId) {
        this.sysUniId = sysUniId;
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
        CommonUserInfoDo other = (CommonUserInfoDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateOperator() == null ? other.getCreateOperator() == null : this.getCreateOperator().equals(other.getCreateOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getNetType() == null ? other.getNetType() == null : this.getNetType().equals(other.getNetType()))
            && (this.getPhoneNum() == null ? other.getPhoneNum() == null : this.getPhoneNum().equals(other.getPhoneNum()))
            && (this.getPhoneNumPerson() == null ? other.getPhoneNumPerson() == null : this.getPhoneNumPerson().equals(other.getPhoneNumPerson()))
            && (this.getDynamicPassword() == null ? other.getDynamicPassword() == null : this.getDynamicPassword().equals(other.getDynamicPassword()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getConfirmNumberLogin() == null ? other.getConfirmNumberLogin() == null : this.getConfirmNumberLogin().equals(other.getConfirmNumberLogin()))
            && (this.getConfirmNumberForget() == null ? other.getConfirmNumberForget() == null : this.getConfirmNumberForget().equals(other.getConfirmNumberForget()))
            && (this.getIsVip() == null ? other.getIsVip() == null : this.getIsVip().equals(other.getIsVip()))
            && (this.getVipType() == null ? other.getVipType() == null : this.getVipType().equals(other.getVipType()))
            && (this.getVipStartDate() == null ? other.getVipStartDate() == null : this.getVipStartDate().equals(other.getVipStartDate()))
            && (this.getVipEndDate() == null ? other.getVipEndDate() == null : this.getVipEndDate().equals(other.getVipEndDate()))
            && (this.getIsFirstGameWin() == null ? other.getIsFirstGameWin() == null : this.getIsFirstGameWin().equals(other.getIsFirstGameWin()))
            && (this.getImsSignTotalDay() == null ? other.getImsSignTotalDay() == null : this.getImsSignTotalDay().equals(other.getImsSignTotalDay()))
            && (this.getImsSignContinueDay() == null ? other.getImsSignContinueDay() == null : this.getImsSignContinueDay().equals(other.getImsSignContinueDay()))
            && (this.getIsGivePrize() == null ? other.getIsGivePrize() == null : this.getIsGivePrize().equals(other.getIsGivePrize()))
            && (this.getPersonName() == null ? other.getPersonName() == null : this.getPersonName().equals(other.getPersonName()))
            && (this.getPrizeGivePhone() == null ? other.getPrizeGivePhone() == null : this.getPrizeGivePhone().equals(other.getPrizeGivePhone()))
            && (this.getPersonImgUrlMax() == null ? other.getPersonImgUrlMax() == null : this.getPersonImgUrlMax().equals(other.getPersonImgUrlMax()))
            && (this.getPersonImgUrlMin() == null ? other.getPersonImgUrlMin() == null : this.getPersonImgUrlMin().equals(other.getPersonImgUrlMin()))
            && (this.getDoudouCount() == null ? other.getDoudouCount() == null : this.getDoudouCount().equals(other.getDoudouCount()))
            && (this.getConiCount() == null ? other.getConiCount() == null : this.getConiCount().equals(other.getConiCount()))
            && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
            && (this.getWeixinOpenId() == null ? other.getWeixinOpenId() == null : this.getWeixinOpenId().equals(other.getWeixinOpenId()))
            && (this.getWeixinUniId() == null ? other.getWeixinUniId() == null : this.getWeixinUniId().equals(other.getWeixinUniId()))
            && (this.getDeviceNumber() == null ? other.getDeviceNumber() == null : this.getDeviceNumber().equals(other.getDeviceNumber()))
            && (this.getQqOpenId() == null ? other.getQqOpenId() == null : this.getQqOpenId().equals(other.getQqOpenId()))
            && (this.getIsRobot() == null ? other.getIsRobot() == null : this.getIsRobot().equals(other.getIsRobot()))
            && (this.getRobotOrderIp() == null ? other.getRobotOrderIp() == null : this.getRobotOrderIp().equals(other.getRobotOrderIp()))
            && (this.getAppType() == null ? other.getAppType() == null : this.getAppType().equals(other.getAppType()))
            && (this.getPhoneName() == null ? other.getPhoneName() == null : this.getPhoneName().equals(other.getPhoneName()))
            && (this.getIsTaskPhone() == null ? other.getIsTaskPhone() == null : this.getIsTaskPhone().equals(other.getIsTaskPhone()))
            && (this.getIsTaskAddress() == null ? other.getIsTaskAddress() == null : this.getIsTaskAddress().equals(other.getIsTaskAddress()))
            && (this.getTaskAllDoudou() == null ? other.getTaskAllDoudou() == null : this.getTaskAllDoudou().equals(other.getTaskAllDoudou()))
            && (this.getUmengChannel() == null ? other.getUmengChannel() == null : this.getUmengChannel().equals(other.getUmengChannel()))
            && (this.getSmsSendCount() == null ? other.getSmsSendCount() == null : this.getSmsSendCount().equals(other.getSmsSendCount()))
            && (this.getSmsSendLastTime() == null ? other.getSmsSendLastTime() == null : this.getSmsSendLastTime().equals(other.getSmsSendLastTime()))
            && (this.getContributionValue() == null ? other.getContributionValue() == null : this.getContributionValue().equals(other.getContributionValue()))
            && (this.getContributionLevel() == null ? other.getContributionLevel() == null : this.getContributionLevel().equals(other.getContributionLevel()))
            && (this.getLastUserId() == null ? other.getLastUserId() == null : this.getLastUserId().equals(other.getLastUserId()))
            && (this.getRequestCode() == null ? other.getRequestCode() == null : this.getRequestCode().equals(other.getRequestCode()))
            && (this.getShowAddSendSmsEveryday() == null ? other.getShowAddSendSmsEveryday() == null : this.getShowAddSendSmsEveryday().equals(other.getShowAddSendSmsEveryday()))
            && (this.getShowAddSendJpushEveryday() == null ? other.getShowAddSendJpushEveryday() == null : this.getShowAddSendJpushEveryday().equals(other.getShowAddSendJpushEveryday()))
            && (this.getShowAddSendSmsDate() == null ? other.getShowAddSendSmsDate() == null : this.getShowAddSendSmsDate().equals(other.getShowAddSendSmsDate()))
            && (this.getShowAddSendJpushDate() == null ? other.getShowAddSendJpushDate() == null : this.getShowAddSendJpushDate().equals(other.getShowAddSendJpushDate()))
            && (this.getLuckyCount() == null ? other.getLuckyCount() == null : this.getLuckyCount().equals(other.getLuckyCount()))
            && (this.getPhoneNumberActivity() == null ? other.getPhoneNumberActivity() == null : this.getPhoneNumberActivity().equals(other.getPhoneNumberActivity()))
            && (this.getLuckyShopCount() == null ? other.getLuckyShopCount() == null : this.getLuckyShopCount().equals(other.getLuckyShopCount()))
            && (this.getWeiboOpenId() == null ? other.getWeiboOpenId() == null : this.getWeiboOpenId().equals(other.getWeiboOpenId()))
            && (this.getStarImgOne() == null ? other.getStarImgOne() == null : this.getStarImgOne().equals(other.getStarImgOne()))
            && (this.getStarImgTwo() == null ? other.getStarImgTwo() == null : this.getStarImgTwo().equals(other.getStarImgTwo()))
            && (this.getStarImgThree() == null ? other.getStarImgThree() == null : this.getStarImgThree().equals(other.getStarImgThree()))
            && (this.getStarIdOne() == null ? other.getStarIdOne() == null : this.getStarIdOne().equals(other.getStarIdOne()))
            && (this.getStarIdTwo() == null ? other.getStarIdTwo() == null : this.getStarIdTwo().equals(other.getStarIdTwo()))
            && (this.getStarIdThree() == null ? other.getStarIdThree() == null : this.getStarIdThree().equals(other.getStarIdThree()))
            && (this.getVoteCountOne() == null ? other.getVoteCountOne() == null : this.getVoteCountOne().equals(other.getVoteCountOne()))
            && (this.getVoteCountTwo() == null ? other.getVoteCountTwo() == null : this.getVoteCountTwo().equals(other.getVoteCountTwo()))
            && (this.getVoteCountThree() == null ? other.getVoteCountThree() == null : this.getVoteCountThree().equals(other.getVoteCountThree()))
            && (this.getStarDescOne() == null ? other.getStarDescOne() == null : this.getStarDescOne().equals(other.getStarDescOne()))
            && (this.getStarDescTwo() == null ? other.getStarDescTwo() == null : this.getStarDescTwo().equals(other.getStarDescTwo()))
            && (this.getStarDescThree() == null ? other.getStarDescThree() == null : this.getStarDescThree().equals(other.getStarDescThree()))
            && (this.getStarSexOne() == null ? other.getStarSexOne() == null : this.getStarSexOne().equals(other.getStarSexOne()))
            && (this.getStarSexTwo() == null ? other.getStarSexTwo() == null : this.getStarSexTwo().equals(other.getStarSexTwo()))
            && (this.getStarSexThree() == null ? other.getStarSexThree() == null : this.getStarSexThree().equals(other.getStarSexThree()))
            && (this.getStarLevelOne() == null ? other.getStarLevelOne() == null : this.getStarLevelOne().equals(other.getStarLevelOne()))
            && (this.getPersonalHomepageImg() == null ? other.getPersonalHomepageImg() == null : this.getPersonalHomepageImg().equals(other.getPersonalHomepageImg()))
            && (this.getPersonalAutograph() == null ? other.getPersonalAutograph() == null : this.getPersonalAutograph().equals(other.getPersonalAutograph()))
            && (this.getHeartCount() == null ? other.getHeartCount() == null : this.getHeartCount().equals(other.getHeartCount()))
            && (this.getHeartCountToday() == null ? other.getHeartCountToday() == null : this.getHeartCountToday().equals(other.getHeartCountToday()))
            && (this.getHeartDonateCount() == null ? other.getHeartDonateCount() == null : this.getHeartDonateCount().equals(other.getHeartDonateCount()))
            && (this.getMoneyDonateCount() == null ? other.getMoneyDonateCount() == null : this.getMoneyDonateCount().equals(other.getMoneyDonateCount()))
            && (this.getXcxOpenId() == null ? other.getXcxOpenId() == null : this.getXcxOpenId().equals(other.getXcxOpenId()))
            && (this.getSysUniId() == null ? other.getSysUniId() == null : this.getSysUniId().equals(other.getSysUniId()));
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
        result = prime * result + ((getNetType() == null) ? 0 : getNetType().hashCode());
        result = prime * result + ((getPhoneNum() == null) ? 0 : getPhoneNum().hashCode());
        result = prime * result + ((getPhoneNumPerson() == null) ? 0 : getPhoneNumPerson().hashCode());
        result = prime * result + ((getDynamicPassword() == null) ? 0 : getDynamicPassword().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getConfirmNumberLogin() == null) ? 0 : getConfirmNumberLogin().hashCode());
        result = prime * result + ((getConfirmNumberForget() == null) ? 0 : getConfirmNumberForget().hashCode());
        result = prime * result + ((getIsVip() == null) ? 0 : getIsVip().hashCode());
        result = prime * result + ((getVipType() == null) ? 0 : getVipType().hashCode());
        result = prime * result + ((getVipStartDate() == null) ? 0 : getVipStartDate().hashCode());
        result = prime * result + ((getVipEndDate() == null) ? 0 : getVipEndDate().hashCode());
        result = prime * result + ((getIsFirstGameWin() == null) ? 0 : getIsFirstGameWin().hashCode());
        result = prime * result + ((getImsSignTotalDay() == null) ? 0 : getImsSignTotalDay().hashCode());
        result = prime * result + ((getImsSignContinueDay() == null) ? 0 : getImsSignContinueDay().hashCode());
        result = prime * result + ((getIsGivePrize() == null) ? 0 : getIsGivePrize().hashCode());
        result = prime * result + ((getPersonName() == null) ? 0 : getPersonName().hashCode());
        result = prime * result + ((getPrizeGivePhone() == null) ? 0 : getPrizeGivePhone().hashCode());
        result = prime * result + ((getPersonImgUrlMax() == null) ? 0 : getPersonImgUrlMax().hashCode());
        result = prime * result + ((getPersonImgUrlMin() == null) ? 0 : getPersonImgUrlMin().hashCode());
        result = prime * result + ((getDoudouCount() == null) ? 0 : getDoudouCount().hashCode());
        result = prime * result + ((getConiCount() == null) ? 0 : getConiCount().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getWeixinOpenId() == null) ? 0 : getWeixinOpenId().hashCode());
        result = prime * result + ((getWeixinUniId() == null) ? 0 : getWeixinUniId().hashCode());
        result = prime * result + ((getDeviceNumber() == null) ? 0 : getDeviceNumber().hashCode());
        result = prime * result + ((getQqOpenId() == null) ? 0 : getQqOpenId().hashCode());
        result = prime * result + ((getIsRobot() == null) ? 0 : getIsRobot().hashCode());
        result = prime * result + ((getRobotOrderIp() == null) ? 0 : getRobotOrderIp().hashCode());
        result = prime * result + ((getAppType() == null) ? 0 : getAppType().hashCode());
        result = prime * result + ((getPhoneName() == null) ? 0 : getPhoneName().hashCode());
        result = prime * result + ((getIsTaskPhone() == null) ? 0 : getIsTaskPhone().hashCode());
        result = prime * result + ((getIsTaskAddress() == null) ? 0 : getIsTaskAddress().hashCode());
        result = prime * result + ((getTaskAllDoudou() == null) ? 0 : getTaskAllDoudou().hashCode());
        result = prime * result + ((getUmengChannel() == null) ? 0 : getUmengChannel().hashCode());
        result = prime * result + ((getSmsSendCount() == null) ? 0 : getSmsSendCount().hashCode());
        result = prime * result + ((getSmsSendLastTime() == null) ? 0 : getSmsSendLastTime().hashCode());
        result = prime * result + ((getContributionValue() == null) ? 0 : getContributionValue().hashCode());
        result = prime * result + ((getContributionLevel() == null) ? 0 : getContributionLevel().hashCode());
        result = prime * result + ((getLastUserId() == null) ? 0 : getLastUserId().hashCode());
        result = prime * result + ((getRequestCode() == null) ? 0 : getRequestCode().hashCode());
        result = prime * result + ((getShowAddSendSmsEveryday() == null) ? 0 : getShowAddSendSmsEveryday().hashCode());
        result = prime * result + ((getShowAddSendJpushEveryday() == null) ? 0 : getShowAddSendJpushEveryday().hashCode());
        result = prime * result + ((getShowAddSendSmsDate() == null) ? 0 : getShowAddSendSmsDate().hashCode());
        result = prime * result + ((getShowAddSendJpushDate() == null) ? 0 : getShowAddSendJpushDate().hashCode());
        result = prime * result + ((getLuckyCount() == null) ? 0 : getLuckyCount().hashCode());
        result = prime * result + ((getPhoneNumberActivity() == null) ? 0 : getPhoneNumberActivity().hashCode());
        result = prime * result + ((getLuckyShopCount() == null) ? 0 : getLuckyShopCount().hashCode());
        result = prime * result + ((getWeiboOpenId() == null) ? 0 : getWeiboOpenId().hashCode());
        result = prime * result + ((getStarImgOne() == null) ? 0 : getStarImgOne().hashCode());
        result = prime * result + ((getStarImgTwo() == null) ? 0 : getStarImgTwo().hashCode());
        result = prime * result + ((getStarImgThree() == null) ? 0 : getStarImgThree().hashCode());
        result = prime * result + ((getStarIdOne() == null) ? 0 : getStarIdOne().hashCode());
        result = prime * result + ((getStarIdTwo() == null) ? 0 : getStarIdTwo().hashCode());
        result = prime * result + ((getStarIdThree() == null) ? 0 : getStarIdThree().hashCode());
        result = prime * result + ((getVoteCountOne() == null) ? 0 : getVoteCountOne().hashCode());
        result = prime * result + ((getVoteCountTwo() == null) ? 0 : getVoteCountTwo().hashCode());
        result = prime * result + ((getVoteCountThree() == null) ? 0 : getVoteCountThree().hashCode());
        result = prime * result + ((getStarDescOne() == null) ? 0 : getStarDescOne().hashCode());
        result = prime * result + ((getStarDescTwo() == null) ? 0 : getStarDescTwo().hashCode());
        result = prime * result + ((getStarDescThree() == null) ? 0 : getStarDescThree().hashCode());
        result = prime * result + ((getStarSexOne() == null) ? 0 : getStarSexOne().hashCode());
        result = prime * result + ((getStarSexTwo() == null) ? 0 : getStarSexTwo().hashCode());
        result = prime * result + ((getStarSexThree() == null) ? 0 : getStarSexThree().hashCode());
        result = prime * result + ((getStarLevelOne() == null) ? 0 : getStarLevelOne().hashCode());
        result = prime * result + ((getPersonalHomepageImg() == null) ? 0 : getPersonalHomepageImg().hashCode());
        result = prime * result + ((getPersonalAutograph() == null) ? 0 : getPersonalAutograph().hashCode());
        result = prime * result + ((getHeartCount() == null) ? 0 : getHeartCount().hashCode());
        result = prime * result + ((getHeartCountToday() == null) ? 0 : getHeartCountToday().hashCode());
        result = prime * result + ((getHeartDonateCount() == null) ? 0 : getHeartDonateCount().hashCode());
        result = prime * result + ((getMoneyDonateCount() == null) ? 0 : getMoneyDonateCount().hashCode());
        result = prime * result + ((getXcxOpenId() == null) ? 0 : getXcxOpenId().hashCode());
        result = prime * result + ((getSysUniId() == null) ? 0 : getSysUniId().hashCode());
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
        sb.append(", netType=").append(netType);
        sb.append(", phoneNum=").append(phoneNum);
        sb.append(", phoneNumPerson=").append(phoneNumPerson);
        sb.append(", dynamicPassword=").append(dynamicPassword);
        sb.append(", password=").append(password);
        sb.append(", confirmNumberLogin=").append(confirmNumberLogin);
        sb.append(", confirmNumberForget=").append(confirmNumberForget);
        sb.append(", isVip=").append(isVip);
        sb.append(", vipType=").append(vipType);
        sb.append(", vipStartDate=").append(vipStartDate);
        sb.append(", vipEndDate=").append(vipEndDate);
        sb.append(", isFirstGameWin=").append(isFirstGameWin);
        sb.append(", imsSignTotalDay=").append(imsSignTotalDay);
        sb.append(", imsSignContinueDay=").append(imsSignContinueDay);
        sb.append(", isGivePrize=").append(isGivePrize);
        sb.append(", personName=").append(personName);
        sb.append(", prizeGivePhone=").append(prizeGivePhone);
        sb.append(", personImgUrlMax=").append(personImgUrlMax);
        sb.append(", personImgUrlMin=").append(personImgUrlMin);
        sb.append(", doudouCount=").append(doudouCount);
        sb.append(", coniCount=").append(coniCount);
        sb.append(", nickName=").append(nickName);
        sb.append(", weixinOpenId=").append(weixinOpenId);
        sb.append(", weixinUniId=").append(weixinUniId);
        sb.append(", deviceNumber=").append(deviceNumber);
        sb.append(", qqOpenId=").append(qqOpenId);
        sb.append(", isRobot=").append(isRobot);
        sb.append(", robotOrderIp=").append(robotOrderIp);
        sb.append(", appType=").append(appType);
        sb.append(", phoneName=").append(phoneName);
        sb.append(", isTaskPhone=").append(isTaskPhone);
        sb.append(", isTaskAddress=").append(isTaskAddress);
        sb.append(", taskAllDoudou=").append(taskAllDoudou);
        sb.append(", umengChannel=").append(umengChannel);
        sb.append(", smsSendCount=").append(smsSendCount);
        sb.append(", smsSendLastTime=").append(smsSendLastTime);
        sb.append(", contributionValue=").append(contributionValue);
        sb.append(", contributionLevel=").append(contributionLevel);
        sb.append(", lastUserId=").append(lastUserId);
        sb.append(", requestCode=").append(requestCode);
        sb.append(", showAddSendSmsEveryday=").append(showAddSendSmsEveryday);
        sb.append(", showAddSendJpushEveryday=").append(showAddSendJpushEveryday);
        sb.append(", showAddSendSmsDate=").append(showAddSendSmsDate);
        sb.append(", showAddSendJpushDate=").append(showAddSendJpushDate);
        sb.append(", luckyCount=").append(luckyCount);
        sb.append(", phoneNumberActivity=").append(phoneNumberActivity);
        sb.append(", luckyShopCount=").append(luckyShopCount);
        sb.append(", weiboOpenId=").append(weiboOpenId);
        sb.append(", starImgOne=").append(starImgOne);
        sb.append(", starImgTwo=").append(starImgTwo);
        sb.append(", starImgThree=").append(starImgThree);
        sb.append(", starIdOne=").append(starIdOne);
        sb.append(", starIdTwo=").append(starIdTwo);
        sb.append(", starIdThree=").append(starIdThree);
        sb.append(", voteCountOne=").append(voteCountOne);
        sb.append(", voteCountTwo=").append(voteCountTwo);
        sb.append(", voteCountThree=").append(voteCountThree);
        sb.append(", starDescOne=").append(starDescOne);
        sb.append(", starDescTwo=").append(starDescTwo);
        sb.append(", starDescThree=").append(starDescThree);
        sb.append(", starSexOne=").append(starSexOne);
        sb.append(", starSexTwo=").append(starSexTwo);
        sb.append(", starSexThree=").append(starSexThree);
        sb.append(", starLevelOne=").append(starLevelOne);
        sb.append(", personalHomepageImg=").append(personalHomepageImg);
        sb.append(", personalAutograph=").append(personalAutograph);
        sb.append(", heartCount=").append(heartCount);
        sb.append(", heartCountToday=").append(heartCountToday);
        sb.append(", heartDonateCount=").append(heartDonateCount);
        sb.append(", moneyDonateCount=").append(moneyDonateCount);
        sb.append(", xcxOpenId=").append(xcxOpenId);
        sb.append(", sysUniId=").append(sysUniId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
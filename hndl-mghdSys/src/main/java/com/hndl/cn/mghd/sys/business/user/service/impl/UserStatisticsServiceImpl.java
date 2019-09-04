package com.hndl.cn.mghd.sys.business.user.service.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.user.UserNormalityTaskEnums;
import com.hndl.cn.base.redis.user.UserInfoKey;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.follow.service.UserFollowService;
import com.hndl.cn.mghd.sys.business.resources.service.ResourcesService;
import com.hndl.cn.mghd.sys.business.user.service.UserStatisticsService;
import com.hndl.cn.mghd.sys.business.user.vo.UserInfoVo;
import com.hndl.cn.mghd.sys.business.user.vo.UserStatisticsParamVo;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import com.hndl.cn.mghd.sys.exception.MghdSysExceptionEnums;
import com.hndl.cn.mongodb.manager.comment.manager.UserCommentManager;
import com.hndl.cn.mongodb.manager.content.manager.StarCallContentManger;
import com.hndl.cn.mongodb.manager.star.manager.StarFansDayStatisticsManager;
import com.hndl.cn.mongodb.manager.star.manager.StarFansMonthStatisticsManager;
import com.hndl.cn.mongodb.manager.star.manager.StarFansWeekStatisticsManager;
import com.hndl.cn.mongodb.manager.task.manager.UserNormalityTaskManager;
import com.hndl.cn.mongodb.manager.user.bean.UserStatisticsDo;
import com.hndl.cn.mongodb.manager.user.manager.UserStatisticsDoManager;
import com.hndl.cn.mysql.manager.common.manager.CommonUserInfoManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.mobile.MobileUtil;
import com.hndl.cn.utils.number.LevelUtil;
import com.hndl.cn.utils.string.SensitiveWordFilter;
import com.hndl.cn.utils.string.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/4/23 15:22
 * @Created by 湖南达联
 */
@Service
public class UserStatisticsServiceImpl implements UserStatisticsService {
    private static final Logger log = LoggerFactory.getLogger(UserStatisticsServiceImpl.class);
    //用户统计dao层
    @Resource
    private UserStatisticsDoManager userStatisticsDoManager;
    //用户基本信息dao层
    @Resource
    private CommonUserInfoManager commonUserInfoManager;
    //资源上传service层
    @Resource
    private ResourcesService resourcesService;
    //星粉日榜
    @Resource
    private StarFansDayStatisticsManager starFansDayStatisticsManager;
    //星粉月榜
    @Resource
    private StarFansMonthStatisticsManager starFansMonthStatisticsManager;
    //星粉周榜
    @Resource
    private StarFansWeekStatisticsManager starFansWeekStatisticsManager;

    @Resource
    private StarCallContentManger starCallContentManger;

    @Resource
    UserCommentManager userCommentManager;

    @Resource
    UserFollowService userFollowService;

    @Resource
    UserNormalityTaskManager userNormalityTaskManager;


    @Resource
    RedisService redisService;

    @Override
    public Result<Object> initUserGettingCount() {
        userStatisticsDoManager.initUserGettingLoveCount();
        return ResultFactory.success();
    }

    /**
     * 查询用户信息
     *
     * @param userId
     * @return
     */
    @Override
    public Result<Object> findUserStatisticsByUserUinId(Long userId) {
        // 因为在controller层进行判断返回,如果是空就将返回查询的用户不存在,并且打印错误日志
        if (userId == null) {
            log.error("=====================没有将用户的id:" + userId + "传递过来===========");
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_NOT_FIND_USER_EXCEPTION.getCode());
        }
        //获取用户的昵称,头像,快乐币、快乐号
        CommonUserInfoDo userInfo = commonUserInfoManager.findUserByUniId(userId);

        if (userInfo == null) {
            log.error("=====================查询用户的id为:" + userId + " 失败===========");
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_NOT_FIND_USER_EXCEPTION.getCode());
        }

        //创建一个新的UserStatisticsParamVo类
        UserStatisticsParamVo userStatisticsParam = new UserStatisticsParamVo();
        //获取用户积分、爱心值、经验值
        UserStatisticsDo charUserStatisticsByUin = userStatisticsDoManager.findUserStatisticsByUserUinId(userId);
        //查询用户数据不在统计表中就生成
        if (charUserStatisticsByUin == null) {
            charUserStatisticsByUin = new UserStatisticsDo();
            charUserStatisticsByUin.setUserUniId(userInfo.getSysUniId());
            charUserStatisticsByUin.setCreateTime(userInfo.getCreateTime().getTime());
            charUserStatisticsByUin.setIntegralCount(userInfo.getDoudouCount().longValue());
            charUserStatisticsByUin.setEmpirical(userInfo.getContributionValue().longValue());
            charUserStatisticsByUin.setSlaveCount(commonUserInfoManager.countApprentice(userInfo.getId()).size()); //徒弟数
            charUserStatisticsByUin.setGettingLoveCount(userInfo.getHeartCountToday().longValue());
            charUserStatisticsByUin.setSlaveFansContribute(0L);
            charUserStatisticsByUin.setFoucaultCount(0);
            userStatisticsDoManager.initUserStatistics(charUserStatisticsByUin);
        }

        //计算用户距离下次升级还需要多少经验值
        //获取当前用户等级
        int contributionLevel = LevelUtil.getContributionLevel(charUserStatisticsByUin.getEmpirical().intValue());
        long experienceByUserLevel = 0L; //设置下次升级需要的经验值
        //判断等级不能大于等于25级
        if (contributionLevel < 25) {
            //下一级的需要达到的经验值
            int userLevel = LevelUtil.getExperienceByUserLevel(contributionLevel + 1);
            experienceByUserLevel = userLevel - charUserStatisticsByUin.getEmpirical();
        }
        userStatisticsParam.setId(userInfo.getId());                                                                            //用户快乐号返回的页面上
        userStatisticsParam.setUserUniId(userInfo.getSysUniId());                                                               //用户唯一的id值
        userStatisticsParam.setFaceImg(userInfo.getPersonImgUrlMax());                                                          //用户头像
        userStatisticsParam.setNickName(userInfo.getNickName());                                                                //用户昵称
        userStatisticsParam.setEmpiricalCount(charUserStatisticsByUin.getEmpirical());                                          //用户经验值
        userStatisticsParam.setGrade(contributionLevel);                                                                        //用户等级
        userStatisticsParam.setFollowCount(userFollowService.findFollowCount(userInfo).getFollowCount());                       //关注数
        userStatisticsParam.setFansCount(userFollowService.findFollowCount(userInfo).getFansCount());                           //粉丝数
        userStatisticsParam.setGradePercentage(LevelUtil.initProgressValue(charUserStatisticsByUin.getEmpirical().intValue())); //用户升级下个等级百分比
        userStatisticsParam.setRequirementEmpirical(experienceByUserLevel);                                                     //根据下一级的经验值与现有的经验值进行相减,知道下次升级需要多少经验值
        userStatisticsParam.setIntegralCount(charUserStatisticsByUin.getIntegralCount());                                       //用户积分数
        userStatisticsParam.setConiCount(userInfo.getConiCount().longValue());                                                  //用户的快乐币(芒果币)
        userStatisticsParam.setPhoneNumPerson(MobileUtil.validatePhoneNum(userInfo.getPhoneNum()));                             //用户手机号
        userStatisticsParam.setPersonalAutograph(userInfo.getPersonalAutograph());                                              //用户的个性签名
        userStatisticsParam.setGettingLoveCount(charUserStatisticsByUin.getGettingLoveCount());                                 //用户的爱心值
        userStatisticsParam.setRequestCode(userInfo.getRequestCode());                                                          //用户的邀请码
        userStatisticsParam.setHomepageImg(userInfo.getPersonalHomepageImg());                                                  //用户个人主页的背景图片
        userStatisticsParam.setGettingLoveCount(charUserStatisticsByUin.getGettingLoveCount());                                 //爱心值
        return ResultFactory.success(userStatisticsParam);
    }

    /**
     * 修改用户头像
     * 要用 resourcesService 中的方法
     *
     * @param
     * @param userImgUrl
     * @return
     */
    @Override
    public Result<Object> updateUserPersonImgUrl(CommonUserInfoDo commonUserInfoDo, String userImgUrl) {
        //先将图片url地址保存到临时文件中,替换之前文件中的头像,然后在将头像地址返回
        String minUrl = resourcesService.registerUserImgUrl(userImgUrl, commonUserInfoDo.getId());
        String maxUrl = resourcesService.registerUserImgUrl(userImgUrl.replace("min", "max"), commonUserInfoDo.getId());
        CommonUserInfoDo userInfoDo = new CommonUserInfoDo();
        userInfoDo.setSysUniId(commonUserInfoDo.getSysUniId());
        //个人头像大图片地址(网址) max和min默认一样
        userInfoDo.setPersonImgUrlMax(maxUrl);
        userInfoDo.setPersonImgUrlMin(minUrl);
        commonUserInfoManager.updateUserInfo(userInfoDo);
        //通过用户id和创建时间为条件,修改用户头像
        starFansDayStatisticsManager.updateStarFansDayByImgUrl(commonUserInfoDo.getSysUniId(), minUrl);
        //通过用户id和创建时间为条件,修改用户头像
        starFansMonthStatisticsManager.updateStarFansMonthGetUserImgUrl(commonUserInfoDo.getSysUniId(), minUrl);
        //通过用户id和创建时间为条件,修改用户头像
        starFansWeekStatisticsManager.updateStarFansWeekGetUserImgUrl(commonUserInfoDo.getSysUniId(), minUrl);
        //修改打coll
        starCallContentManger.updateUserImgByUniId(commonUserInfoDo.getSysUniId(), minUrl);
        userCommentManager.updateImgAndNameByUniId(commonUserInfoDo.getSysUniId(), minUrl, null);
        String userKey = UserInfoKey.getUserInfoCacheKey(commonUserInfoDo.getSysUniId());
        CommonUserInfoDo userByUniId = commonUserInfoManager.findUserByUniId(commonUserInfoDo.getSysUniId());
        redisService.set(userKey, userByUniId, UserInfoKey.OUT_TIME);
        //保存用户头像成功
        return ResultFactory.success(minUrl);

    }

    /**
     * 修改用户昵称
     *
     * @param
     * @param nickName
     * @return
     */
    @Override
    public Result<Object> updateUserNickName(CommonUserInfoDo commonUserInfoDo, String nickName) {
        //1，判断用户昵称长度 >指定長度
        if (nickName.length() > 16) {
            //昵称过长
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_UPDATE_USER_NICKNAME_LENGTH_OVERSIZE_EXCEPTION.getCode());
        }
        nickName = StringUtils.filterEmoji(nickName);
        //2，昵称存在
        if (commonUserInfoManager.existNickName(nickName)) {
            //昵称已被占用
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_UPDATE_USER_NICKNAME_IS_EXIST_EXCEPTION.getCode());
        }

        //3，判断是否有敏感词并且替换
        if (SensitiveWordFilter.INSTANCE.isContaintSensitiveWord(nickName, SensitiveWordFilter.maxMatchType)) {
            nickName = SensitiveWordFilter.INSTANCE.replaceSensitiveWord(nickName, SensitiveWordFilter.maxMatchType);

        }
        //接下來操作：
        CommonUserInfoDo userInfo = new CommonUserInfoDo();
        userInfo.setSysUniId(commonUserInfoDo.getSysUniId());  //用户uniId
        userInfo.setNickName(nickName);                        //用户昵称
        commonUserInfoManager.updateUserInfo(userInfo);
        commonUserInfoDo.setNickName(nickName);                //用户统计表中用户昵称
        //通过用户id和创建时间为条件,修改用户昵称
        starFansDayStatisticsManager.updateStarFansDayByNickName(commonUserInfoDo.getSysUniId(), userInfo.getNickName());
        //通过用户id和创建时间为条件,修改用户昵称
        starFansMonthStatisticsManager.updateStarFansMonthGetUserNickName(commonUserInfoDo.getSysUniId(), userInfo.getNickName());
        //通过用户id和创建时间为条件,修改用户昵称
        starFansWeekStatisticsManager.updateStarFansWeekGetUserNickName(commonUserInfoDo.getSysUniId(), userInfo.getNickName());
        starCallContentManger.updateUserNickNameByUniId(commonUserInfoDo.getSysUniId(), userInfo.getNickName());
        userCommentManager.updateImgAndNameByUniId(commonUserInfoDo.getSysUniId(), null, userInfo.getNickName());
        //刷新用户缓存
        String key = UserInfoKey.getUserInfoCacheKey(commonUserInfoDo.getSysUniId());
        CommonUserInfoDo userByUniId = commonUserInfoManager.findUserByUniId(commonUserInfoDo.getSysUniId());
        redisService.set(key, userByUniId, UserInfoKey.OUT_TIME);

        //返回成功
        return ResultFactory.success(nickName);


    }

    /**
     * 修改用户手机号
     *
     * @param
     * @param phoneNum
     * @return
     */
    @Override
    public Result<Object> updateUserPhoneNum(CommonUserInfoDo commonUserInfoDo, String phoneNum) {
        //判断当前用户绑定手机号,并且修改后的手机号与之前没有变化
        if (StringUtils.isNotEmpty(commonUserInfoDo.getPhoneNum()) && commonUserInfoDo.getPhoneNum().equals(phoneNum)) {
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_USER_PHONE_NUM_NOT_IS_ME.getCode());
        }
        if (phoneNum.length() == 11) {
            String mobile = MobileUtil.validateMobile(phoneNum);
            //有就直接进行修改就好
            CommonUserInfoDo userInfoDo = new CommonUserInfoDo();
            userInfoDo.setSysUniId(commonUserInfoDo.getSysUniId());
            userInfoDo.setPhoneNum(phoneNum);
            userInfoDo.setPhoneNumPerson(Long.parseLong(phoneNum));
            userInfoDo.setNetType(mobile);
            commonUserInfoManager.updateUserInfo(userInfoDo);
            //判断之前没有绑定手机号
            if (!userNormalityTaskManager.findUserByNumber(commonUserInfoDo.getSysUniId())) {
                //用户完成绑定手机号，新增用户完成任务就要修改可以领取的奖励
                userNormalityTaskManager.insert(commonUserInfoDo.getSysUniId(), phoneNum, UserNormalityTaskEnums.BIND_PHONE, IsValidEnums.NO.getValue());
            }
            //修改用户手机号成功，返回手机号
            return ResultFactory.success(phoneNum);
        } else {
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_USER_PHONE_NUM_NOT_NULL.getCode());
        }


    }

    /**
     * 修改用户个性签名
     *
     * @param
     * @param personalAutograph
     * @return
     */
    @Override
    public Result<Object> updateUserPersonalAutograph(CommonUserInfoDo commonUserInfoDo, String personalAutograph) {
        //个性签名最多20个字,所以判断签名的长度不能大于20
        if (personalAutograph.length() <= 20) {
            CommonUserInfoDo userInfo = new CommonUserInfoDo();
            userInfo.setSysUniId(commonUserInfoDo.getSysUniId());
            //判断是否有敏感词
            if (SensitiveWordFilter.INSTANCE.isContaintSensitiveWord(personalAutograph, SensitiveWordFilter.maxMatchType)) {
                userInfo.setPersonalAutograph(SensitiveWordFilter.INSTANCE.replaceSensitiveWord(personalAutograph, SensitiveWordFilter.maxMatchType));
            } else {
                userInfo.setPersonalAutograph(personalAutograph);
            }
            commonUserInfoManager.updateUserInfo(userInfo);
        }
        return ResultFactory.success(personalAutograph);

    }

    /**
     * 修改我的日常 背景图
     *
     * @param
     * @param homepageImg
     * @return
     */
    @Override
    public Result<Object> updateUserHomepageImg(CommonUserInfoDo commonUserInfoDo, String homepageImg) {
        //判断用户传入进来的图片的url的长度不能大于2000个字段
        if (homepageImg.length() < 2000) {
            //先将图片url地址保存到临时文件中,替换之前文件中的头像,然后在将头像地址返回
            String minUrl = resourcesService.registerUserBackgroundImg(homepageImg, commonUserInfoDo.getSysUniId());
            CommonUserInfoDo userInfoDo = new CommonUserInfoDo();
            userInfoDo.setSysUniId(commonUserInfoDo.getSysUniId());
            userInfoDo.setPersonalHomepageImg(minUrl);
            commonUserInfoManager.updateUserInfo(userInfoDo);
            //保存个人首页 背景图片成功
            return ResultFactory.success("上传成功");
        } else {
            //如果长度过于长，就返回 头像长度过长的一个异常
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_UPDATE_USER_IMG_URL_FIND.getCode());
        }
    }

    /**
     * 根据快乐号带token登陆,获取用户信息
     *
     * @param commonUserInfoDo 登陆的用户
     * @param id               需要获取信息的id
     * @return
     */
    @Override
    public Result<Object> findIdGetUser(CommonUserInfoDo commonUserInfoDo, Long id) {
        UserInfoVo vo = new UserInfoVo();
        CommonUserInfoDo user = commonUserInfoManager.findUserByUserId(id);
        if (user == null) {
            log.error("----------------- 查询快乐号:" + id + "不存在-----------------------");
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_NOT_FIND_USER_EXCEPTION.getCode());
        }
        vo.setId(user.getId());
        vo.setNickName(user.getNickName());
        vo.setImgMin(user.getPersonImgUrlMin());
        return ResultFactory.success(vo);
    }


}

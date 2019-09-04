package com.hndl.cn.mghd.sys.business.call.service.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.enums.comment.CommentType;
import com.hndl.cn.base.enums.fans.FansGroupContributeEnums;
import com.hndl.cn.base.enums.user.UserDayTaskEnums;
import com.hndl.cn.base.exception.enums.ExceptionSysMarkEnum;
import com.hndl.cn.base.plugin.snowflakeid.service.ISnowflakeIdService;
import com.hndl.cn.base.plugin.snowflakeid.service.impl.SnowflakeIdServiceImpl;
import com.hndl.cn.base.redis.MgHdRedisKeyEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.call.service.StarFansCircleService;
import com.hndl.cn.mghd.sys.business.call.vo.StarCallContentVo;
import com.hndl.cn.mghd.sys.business.call.vo.TopicCommentVo;
import com.hndl.cn.mghd.sys.business.call.vo.UserInfoVo;
import com.hndl.cn.mghd.sys.business.comment.service.UserCommentService;
import com.hndl.cn.mghd.sys.business.comment.vo.ReUserCommentVo;
import com.hndl.cn.mghd.sys.business.resources.service.ResourcesService;
import com.hndl.cn.mghd.sys.business.star.service.StarFansGroupRelationService;
import com.hndl.cn.mghd.sys.business.star.service.StarFansGroupService;
import com.hndl.cn.mghd.sys.business.star.service.StarFansStatisticsService;
import com.hndl.cn.mghd.sys.business.star.vo.StarFansGroupRelationVo;
import com.hndl.cn.mghd.sys.business.star.vo.StarFansGroupVo;
import com.hndl.cn.mghd.sys.business.task.service.UserDayTaskService;
import com.hndl.cn.mghd.sys.common.constants.MghdSysConstants;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import com.hndl.cn.mghd.sys.exception.MghdSysExceptionEnums;
import com.hndl.cn.mongodb.manager.comment.manager.UserCommentManager;
import com.hndl.cn.mongodb.manager.content.bean.StarCallContentDo;
import com.hndl.cn.mongodb.manager.content.manager.ContentLikeManager;
import com.hndl.cn.mongodb.manager.content.manager.StarCallContentManger;
import com.hndl.cn.mongodb.manager.follow.manager.UserFollowManager;
import com.hndl.cn.mongodb.manager.star.bean.StarFansGroupDo;
import com.hndl.cn.mongodb.manager.star.manager.StarFansGroupManager;
import com.hndl.cn.mongodb.manager.topic.bean.TopicCommentDo;
import com.hndl.cn.mongodb.manager.topic.bean.TopicDo;
import com.hndl.cn.mongodb.manager.topic.manager.TopicCommentManager;
import com.hndl.cn.mongodb.manager.topic.manager.TopicManager;
import com.hndl.cn.mysql.manager.common.manager.CommonUserInfoManager;
import com.hndl.cn.nosql.redis.annotation.lock.SubmitLock;
import com.hndl.cn.nosql.redis.page.RedisPageService;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.collection.MapUtils;
import com.hndl.cn.utils.page.PageUtils;
import com.hndl.cn.utils.reg.RegExUtil;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import com.hndl.cn.utils.string.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

;

/**
 * @program: hndl-platform
 * @description: 星粉圈
 * @author: 易成贤
 * @create: 2019-05-08 20:42 @Created by 湖南达联
 */
@Service
@Slf4j
@Validated
public class StarFansCircleServiceImpl implements StarFansCircleService {

    @Resource
    UserDayTaskService userDayTaskService;

    @Resource
    StarCallContentManger starCallContentManger;

    @Resource
    StarFansGroupManager starFansGroupManager;

    @Resource
    ContentLikeManager contentLikeManager;

    @Resource
    ResourcesService resourcesService;

    @Resource
    TopicCommentManager topicCommentManager;

    @Resource
    TopicManager topicManager;

    @Resource
    StarFansGroupRelationService starFansGroupRelationService;

    @Resource
    StarFansStatisticsService starFansStatisticsService;

    @Resource
    CommonUserInfoManager commonUserInfoManager;

    @Resource
    UserCommentManager userCommentManager;

    ISnowflakeIdService iSnowflakeIdService = SnowflakeIdServiceImpl.INSTANCE;

    @Resource
    UserFollowManager userFollowManager;

    @Resource
    RedisService redisService;
    @Resource
    RedisPageService redisPageService;
    @Resource
    UserCommentService userCommentService;
    @Resource
    StarFansGroupService starFansGroupService;

    /**
     * 根据用户和打call数据增加是否点赞
     *
     * @param commonUserInfoDo
     * @param starCallContentVos
     * @return
     */
    @Override
    public List<StarCallContentVo> findLike(CommonUserInfoDo commonUserInfoDo, List<StarCallContentVo> starCallContentVos) {
        // 1，判断传入星粉圈是否为空，如果为空直接返回
        if (CollectionUtils.isEmpty(starCallContentVos)) {
            return new ArrayList<>(1);
        }

        // 2，判断是否有用户 没有用户
        if (null == commonUserInfoDo) {
            // 2-1，全部设置没点赞
            starCallContentVos.stream().forEach(starCallContentVo -> starCallContentVo.setIsLike(IsValidEnums.NO.getValue()));
            // 2-2，全部返回
            return starCallContentVos;
        }
        // 2-1,获取所有callId
        List<Long> likes =
                starCallContentVos.stream().map(v -> v.getCallId()).collect(Collectors.toList());
        // 2-2,如果一个点赞数据都查不到
        Map<Long, Integer> batchIsLike =
                contentLikeManager.findBatchIsLike(commonUserInfoDo.getSysUniId(), likes);
        if (MapUtils.isEmpty(batchIsLike)) {
            // 2-2-1,全部设置为没有点赞
            starCallContentVos.stream()
                    .forEach(starCallContentVo -> starCallContentVo.setIsLike(IsValidEnums.NO.getValue()));
            // 2-2-2，全部返回
            return starCallContentVos;
        } else {
            // 2-2-1，循环遍历点赞数据
            starCallContentVos.stream()
                    .forEach(
                            starCallContentVo -> {
                                // 2-2-1-1，获取点赞数据
                                Integer isLike = batchIsLike.get(starCallContentVo.getCallId());
                                // 2-2-1-2，如果查不到
                                if (null == isLike) {
                                    // 2-2-1-2-1,设置为未点赞
                                    starCallContentVo.setIsLike(IsValidEnums.NO.getValue());
                                } else {
                                    // 2-2-1-2-2,否则设置点赞数据
                                    starCallContentVo.setIsLike(isLike);
                                }
                            });
        }
        // 3,返回本身
        return starCallContentVos;

    }

    /**
     * 查询星粉圈数据分页查询星粉圈数据200条
     *
     * @param starId
     * @return
     */
    @Override
    public List<StarCallContentVo> findAllStarFansCircle(CommonUserInfoDo commonUserInfoDo, Integer pageNo, Long starId, String id) {
        // 1，判断明星在不在
        if (starFansGroupManager.findStarFansGroup(starId) == null) {
            // 抛出异常 明星/粉丝会不存在
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_FANS_NULL_EXCEPTION.getCode());
        }
        if (pageNo == null && id == null) {
            // 传参错误
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        // 穿透部分
        if (pageNo > MghdSysConstants.NOW_PAGE_NUM) {
            List<StarCallContentVo> contentVos = findStarCallById(starId, id);
            return this.findLike(commonUserInfoDo, contentVos);
        } else {
            List<StarCallContentVo> contentVos = findStarCallByPageNo(starId, pageNo);
            return this.findLike(commonUserInfoDo, contentVos);
        }
    }

    /**
     * 粉丝会穿透部分
     * @param starId 明星id
     * @param id 游标分页id
     * @return
     */
    private List<StarCallContentVo> findStarCallById(Long starId,String id){
        //校验参数
        if (StringUtils.isBlank(id) || !PageUtils.checkMongoDbObjId(id)) {
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        List<StarCallContentDo> starCallContent = starCallContentManger.findStarCallContent(starId, id, MghdSysConstants.INIT_PAGE_LIMIT);
        // 查询穿透数据库 ，20条每页
        List<StarCallContentVo> contentVos = SpringCglibBeanUtils.convertByList(starCallContent, StarCallContentVo.class);
        return contentVos;
    }

    /**
     * 粉丝会分页查询
     * @return
     */
    private List<StarCallContentVo> findStarCallByPageNo(Long starId,Integer pageNo){
        // 设置key
        String key = MgHdRedisKeyEnums.CALL_CACHE_KEY.getCacheKey(starId);
       List<StarCallContentVo> starCallContentVos =  redisPageService.getKVList(key, pageNo, MghdSysConstants.INIT_PAGE_LIMIT);
       if (CollectionUtils.isNotEmpty(starCallContentVos)){
           return starCallContentVos;
       }

        // 2，查询200条数据存入缓存
        List<StarCallContentDo> content = starCallContentManger.findStarCallContent(starId, null, MghdSysConstants.MAX_PAGE_NUM);
        if (CollectionUtils.isEmpty(content)) {
            return new ArrayList<>(1);
        }
        starCallContentVos = SpringCglibBeanUtils.convertByList(content,StarCallContentVo.class);
        // 存入缓存
        redisService.set(key, starCallContentVos, MgHdRedisKeyEnums.CALL_CACHE_KEY.getExpireTime());

        starCallContentVos = redisPageService.getKVList(key, pageNo, MghdSysConstants.INIT_PAGE_LIMIT);

        return starCallContentVos;
    }

    /**
     * 查询首页
     *
     * @param commonUserInfoDo
     * @param pageNo
     * @return
     */
    @Override
    public List<StarCallContentVo> findAppHomeStarFansCircle(CommonUserInfoDo commonUserInfoDo, Integer pageNo) {
        // 1，查询缓存
        List<StarCallContentVo> starCallContentVos;
        String redisKey = MgHdRedisKeyEnums.APP_HOME_CACHE_KEY.getCacheKey();
        // 2，获取缓存数据
        starCallContentVos = redisPageService.getKVList(redisKey, pageNo, MghdSysConstants.INIT_PAGE_LIMIT);
        // 3，判断缓存是否有数据
        if (CollectionUtils.isNotEmpty(starCallContentVos)) {
            // 3-1，给数据加上是否关注状态
            List<StarCallContentVo> callContentVos = findIsRelation(commonUserInfoDo, starCallContentVos);
            // 3-2调用是否点赞接口并返回数据
            return findLike(commonUserInfoDo, callContentVos);
        }

        //查询推荐列表
        List<StarCallContentDo> recommen = findRecommen();

        // 3，缓存没有走数据库查询
        List<StarCallContentDo> Content =
                starCallContentManger.findStarListSaidContent(
                        null, IsValidEnums.YES, null, MghdSysConstants.HOME_CONTENT_LIMIT - recommen.size());
        recommen.addAll(Content);
        // 3-1，判断数据是否为空如果为null 抛出异常首页数据加载失败
        if (CollectionUtils.isEmpty(recommen)) {
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_INIT_APP_HOME_EX.getCode());
        }

        // 3-2,把打call数据转换成vo
        List<StarCallContentVo> contentVos =
                SpringCglibBeanUtils.convertByList(recommen, StarCallContentVo.class);

        // 3-3,获取打call数据对应的粉丝会
        Map<Long, StarFansGroupVo> starFansGroupMap =
                starFansGroupService.findStarFansGroupMap(contentVos);
        // 3-4，把打粉丝会set到这条打call数据
        contentVos.stream()
                .forEach(contentVo ->
                                // 遍历存入粉丝数据
                                contentVo.setStarFansGroupVo(starFansGroupMap.get(contentVo.getStarId())));
        // 3-5 把首页数据存入缓存
        redisService.set(redisKey, contentVos, MgHdRedisKeyEnums.CALL_CACHE_KEY.getExpireTime());

        // 3-6，给数据加入是否关注状态
        List<StarCallContentVo> callContentVos = findIsRelation(commonUserInfoDo, contentVos);

        // 3-7，调用是打call数据否点赞并且返回数据
        return findLike(commonUserInfoDo, callContentVos);
    }

    /**
     * 查询推荐内容
     *
     * @return
     */
    private List<StarCallContentDo> findRecommen() {
        List<StarCallContentDo> list = starCallContentManger.findRecommenByUser(BaseConstants.MAX_CALL_RCOMMEND_LIMIT);
        if (null == list) {
            return new ArrayList<>(1);
        }
        return list;
    }

    /**
     * 查询是否关注
     *
     * @param commonUserInfoDo   用户
     * @param starCallContentVos call列表
     * @return
     */
    private List<StarCallContentVo> findIsRelation(CommonUserInfoDo commonUserInfoDo, List<StarCallContentVo> starCallContentVos) {
        // 1，查询用户关注的粉丝会
        Map<Long, StarFansGroupRelationVo> relationVoMap = starFansGroupRelationService.findstarFansGroupRelationMap(commonUserInfoDo.getSysUniId());
        // 2，遍历集合，取值
        starCallContentVos.stream()
                .forEach(starCallContentVo -> {
                            // 2-1，取值是否关注
                            Integer isRelation =
                                    null == relationVoMap.get(starCallContentVo.getStarId())
                                            ? IsValidEnums.NO.getValue()
                                            : IsValidEnums.YES.getValue();
                            // 2-2，获取粉丝会
                            StarFansGroupVo starFansGroupVo = starCallContentVo.getStarFansGroupVo();
                            // 2-3,设置值
                            if (null != starCallContentVo) {
                                starFansGroupVo.setIsRelation(isRelation);
                            }
                            // 2-4，把粉丝会数据设置回去
                            starCallContentVo.setStarFansGroupVo(starFansGroupVo);
                        });
        // 3,返回数据
        return starCallContentVos;
    }

    /**
     * 打call
     *
     * @param commonUserInfoDo
     * @param starId           明星id
     * @param content          内容
     * @param contentImgList   图片
     * @return 返回成功数据date包含CallId
     */
    @Override
    @SubmitLock(keys = "commonUserInfoDo#sysUniId",sysMarkEnum = ExceptionSysMarkEnum.MGHD_SYS)
    public Result<Object> addStarFansCircle(CommonUserInfoDo commonUserInfoDo, Long starId, String content, List<String> contentImgList) {
        // 查询该粉丝会是否存在
        StarFansGroupDo group = starFansGroupManager.findStarFansGroup(starId);
        if (group == null) {
            // 1-1，如果粉丝会为空，粉丝会不存在
            log.info("打call时候传来一条不存在的粉丝会，该粉丝会id为：" + starId);
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_FANS_NULL_EXCEPTION.getCode());
        }
        //校验图片地址
        boolean flag = CollectionUtils.isNotEmpty(contentImgList);
        // reg_exp：简单校验 http://mghd.oss-cn-hangzhou.aliyuncs.com/temp/min_img/ + 日期/+18位数字. +图片格式
        if (flag && contentImgList.stream().filter(url -> !RegExUtil.isImgUrl(url)).count() > 0){
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_PIC_DATA_EXCEPTION.getCode());
        }
        // 生成callId
        long callId = iSnowflakeIdService.nextCallId();
        //把存储的临时存储的图像注册并返回注册地址
        List<String> imgUrl;

        if (flag) {
            //循环遍历图片url
            imgUrl = contentImgList.stream().map(v -> {
                                // 3-1-1，注册大图地址
                                resourcesService.registerCallImg(callId, v.replace("min", "max"));
                                // 3-1-2，注册小图地址
                                return resourcesService.registerCallImg(callId, v);
                            }).collect(Collectors.toList());
        }else {
            //否则存储一个空数组
            imgUrl = new ArrayList<>(1);
        }

        //打call插入数据
        starCallContentManger.addCall(callId, commonUserInfoDo.getSysUniId(), commonUserInfoDo.getNickName(), commonUserInfoDo.getPersonImgUrlMin(), starId, content, imgUrl);

        // 插入打call任务记录
        userDayTaskService.insetTask(commonUserInfoDo.getSysUniId(), starId, UserDayTaskEnums.CALL_TASK);


        // 增加打call后数据操作———》增加用户行为数据
        starFansStatisticsService.addConductStatistics(commonUserInfoDo, group, FansGroupContributeEnums.CALL);

        // 返回callId,便于查询打call详细页
        return ResultFactory.success(callId);
    }


    /**
     * 查询爱豆说
     *
     * @param starId
     * @param id
     * @return
     */
    @Override
    public List<StarCallContentVo> findStarSaid(CommonUserInfoDo commonUserInfoDo, Integer pageNo, Long starId, String id) {

        List<StarCallContentDo> starCallContentDos;
        //判断明星在不在
        StarFansGroupDo fansGroup = starFansGroupManager.findStarFansGroup(starId);
        if (fansGroup == null) {
            // 明星/粉丝会不存在
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_FANS_NULL_EXCEPTION.getCode());
        }
        if (pageNo > MghdSysConstants.NOW_PAGE_NUM) {
            if (!PageUtils.checkMongoDbObjId(id)) {
                throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
            }
            starCallContentDos = starCallContentManger.findStarSaidContent(starId, id, MghdSysConstants.INIT_PAGE_LIMIT);
            // 查询穿透数据库 ，20条每页
            List<StarCallContentVo> contentVos = SpringCglibBeanUtils.convertByList(starCallContentDos, StarCallContentVo.class);
            return this.findLike(commonUserInfoDo, contentVos);
        } else {
            // 设置key
            String redisKey = MgHdRedisKeyEnums.STAR_SAID_CACHE_KEY.getCacheKey(starId);
            starCallContentDos = redisPageService.getKVList(redisKey, pageNo, MghdSysConstants.INIT_PAGE_LIMIT);
            if (CollectionUtils.isNotEmpty(starCallContentDos)) {
                List<StarCallContentVo> contentVos = SpringCglibBeanUtils.convertByList(starCallContentDos, StarCallContentVo.class);
                return this.findLike(commonUserInfoDo, contentVos);
            }
            // 2，查询200条数据存入缓存
            List<StarCallContentDo> content =
                    starCallContentManger.findStarSaidContent(starId, null, MghdSysConstants.MAX_PAGE_NUM);
            // 存入缓存
            redisService.set(redisKey, content, MgHdRedisKeyEnums.CALL_CACHE_KEY.getExpireTime());
            // 获取缓存数据
            content = redisPageService.getKVList(redisKey, pageNo, MghdSysConstants.INIT_PAGE_LIMIT);
            List<StarCallContentVo> contentVos = SpringCglibBeanUtils.convertByList(content, StarCallContentVo.class);

            return this.findLike(commonUserInfoDo, contentVos);
        }
    }

    /**
     * 查询指定用户的打call
     *
     * @param commonUserInfoDo
     * @param userUniId
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> findUserCall(CommonUserInfoDo commonUserInfoDo, Integer pageNo, Long userUniId, String id) {
        List<StarCallContentVo> contentVos;
        // 1，查询用户
        final CommonUserInfoDo user = commonUserInfoManager.findUserByUniId(userUniId);
        // 2，判断用户是否存在
        if (null == user) {
            // 2-1，抛出异常，用户不存在
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_NOT_FIND_USER_EXCEPTION.getCode());
        }
        // 3,判断是否大于10页
        if (pageNo > MghdSysConstants.NOW_PAGE_NUM) {
            Map map = new HashMap(1);
            contentVos = findUserCallById(id, userUniId);
            // 判断是否点赞的状态并且存入map集合
            map.put("callContent", findLike(commonUserInfoDo, contentVos));
            // 返回map集合
            return map;
        } else {
             contentVos = findUserCallByPageNo(pageNo, userUniId);
                // 判断页数是否大于1
                if (pageNo > 1) {
                    // 3-3-2-1，那么创建一个只有一个对象的map用于返回list集合
                    Map map = new HashMap(1);
                    // 3-3-2-2,把点赞数据加上并且放入map
                    map.put("callContent", findLike(commonUserInfoDo, contentVos));
                    // 3-3-2-3，返回数据
                    return map;
                } else {
                    // 3-3-2-1,否则页数是初始页面具备两个参数【第一是展示数据，第二是展示call列表】
                    Map map = new HashMap(3);
                    // 3-3-2-2，查询打call列表头部信息
                    UserInfoVo userInfoVo = userInfo(commonUserInfoDo, user);
                    List<TopicCommentVo> topicComment = findTopicComment(userUniId);
                    map.put("userInfoVo", userInfoVo);
                    map.put("topicComment", topicComment);
                    map.put("callContent", findLike(commonUserInfoDo, contentVos));
                    return map;
                }
        }
    }

    /**
     * * 查询用户call列表头部信息
     *
     * @param myUser 我的用户
     * @param user   查询到的用户
     * @return
     */
    private UserInfoVo userInfo(CommonUserInfoDo myUser, CommonUserInfoDo user) {
        // 3-3-2-2第一部分是用户数据
        UserInfoVo userInfoVo = new UserInfoVo();
        // 昵称
        userInfoVo.setUserNickName(user.getNickName());
        // 小图地址
        userInfoVo.setUserImgUrl(user.getPersonImgUrlMin());
        // 个性签名
        userInfoVo.setPersonalSignature(user.getPersonalAutograph());
        // 是否关注
        Integer isfollow = IsValidEnums.NO.getValue();
        if (null != myUser) {
            isfollow = userFollowManager.eachotherFollow(myUser.getSysUniId(), user.getSysUniId())
                            ? IsValidEnums.YES.getValue()
                            : IsValidEnums.NO.getValue();
        }
        userInfoVo.setIsFollow(isfollow);
        return userInfoVo;
    }

    /**
     * 查询用户打call穿透部分
     * @param id
     * @param userUniId
     * @return
     */
    private List<StarCallContentVo> findUserCallById(String id,Long userUniId){
        //判断是否传输过来ObjId
        if (!PageUtils.checkMongoDbObjId(id)) {
            // 没有就抛出参数异常
            log.info("查询用户打call->传入id异常，该id为{}",id);
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        // 查询数据库20条
        List<StarCallContentDo> starCallContentDos = starCallContentManger.findUserCallContent(userUniId, id, MghdSysConstants.INIT_PAGE_LIMIT);
        //转换为vo
        List<StarCallContentVo> contentVos = SpringCglibBeanUtils.convertByList(starCallContentDos, StarCallContentVo.class);
        // 获取打call数据对应的粉丝会
        Map<Long, StarFansGroupVo> starFansGroupMap = starFansGroupService.findStarFansGroupMap(contentVos);
        // 设置call数据的粉丝会
        contentVos.stream().forEach(contentVo -> contentVo.setStarFansGroupVo(starFansGroupMap.get(contentVo.getStarId())));
        return contentVos;
    }

    /**
     * 分页查询用户call
     * @param pageNo
     * @param userUniId
     * @return
     */
    private List<StarCallContentVo> findUserCallByPageNo(Integer pageNo,Long userUniId){
        //设置key
        String rediskey = MgHdRedisKeyEnums.USER_CALL_CACHE_KEY.getCacheKey(userUniId);
        //获取缓存内数据
        List<StarCallContentVo> starCallContentVos = redisPageService.getKVList(rediskey, pageNo, MghdSysConstants.INIT_PAGE_LIMIT);
        if (CollectionUtils.isNotEmpty(starCallContentVos)) {
            return starCallContentVos;
        }
        //没有缓存查询200条数据存入缓存
        List<StarCallContentDo> content = starCallContentManger.findUserCallContent(userUniId, null, MghdSysConstants.MAX_PAGE_NUM);
        //转换为vo
        starCallContentVos = SpringCglibBeanUtils.convertByList(content, StarCallContentVo.class);
        //加入粉丝会详细信息
        Map<Long, StarFansGroupVo> starFansGroupMap = starFansGroupService.findStarFansGroupMap(starCallContentVos);
        //设置call数据的粉丝会
        starCallContentVos.stream().forEach(contentVo -> contentVo.setStarFansGroupVo(starFansGroupMap.get(contentVo.getStarId())));
        //存入缓存
        redisService.set(rediskey, starCallContentVos, MgHdRedisKeyEnums.USER_CALL_CACHE_KEY.getExpireTime());
        //获取缓存指定页
       return redisPageService.getKVList(rediskey, pageNo, MghdSysConstants.INIT_PAGE_LIMIT);

    }

    private List<TopicCommentVo> findTopicComment(Long userUniId){
        //查询话题评论
        List<TopicCommentDo> topicCommentByUserUniId = topicCommentManager.findTopicCommentByUserUniId(userUniId, null, MghdSysConstants.DAILY_TOPIC_COMMENT_LIMIT);
        List<TopicCommentVo> topicCommentVoList = SpringCglibBeanUtils.convertByList(topicCommentByUserUniId, TopicCommentVo.class);
        //获取话题标题
        Set<String> set = new HashSet();
        topicCommentVoList.forEach(v ->set.add(v.getId()));
        Map<String, List<TopicDo>> map = topicManager.findTopicByIds(set).stream().collect(Collectors.groupingBy(TopicDo::getId));
        topicCommentVoList.forEach(
              v -> v.setTopicTitle(null == map.get(v.getTopicId()) ? "无标题": map.get(v.getTopicId()).get(0).getTitle())

        );
        return topicCommentVoList;
    }

    /**
     * 查询单个callId的数据.用于查看详细
     *
     * @param commonUserInfoDo
     * @param callId
     * @return
     */
    @Override
    public Result<Map<String, Object>> findOneDetailCall(CommonUserInfoDo commonUserInfoDo, Long callId, String id) {
        StarCallContentDo starCallContentDo = starCallContentManger.findCallContent(callId);

        if (null == starCallContentDo) {
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_NOT_FIND_CALL_EXCEPTION.getCode());
        }

        StarCallContentVo callContentVo = SpringCglibBeanUtils.convert(starCallContentDo, StarCallContentVo.class);
        boolean like = contentLikeManager.isLike(commonUserInfoDo.getSysUniId(), callId);
        if (like) {
            callContentVo.setIsLike(IsValidEnums.YES.getValue());
        } else {
            callContentVo.setIsLike(IsValidEnums.NO.getValue());
        }
        // 查询粉丝会信息
        StarFansGroupVo fansGroupDetailVo = starFansGroupService.findStarFansGroupDetail(commonUserInfoDo, callContentVo.getStarId());
        callContentVo.setStarFansGroupVo(fansGroupDetailVo);
        // 判断传过来id是否为空，那么就是第一页
        if (null == id) {
            Map map = new HashMap(3);
            // 查询评论
            List<ReUserCommentVo> comment =
                    userCommentService.findPageUserCommentByTargetId(
                            callId, CommentType.COMMENT_TYPE_TEST, null);
            // 头部信息
            UserInfoVo userInfoVo = new UserInfoVo();
            userInfoVo.setUserImgUrl(callContentVo.getUserImg());
            userInfoVo.setUserNickName(callContentVo.getUserNickName());
            if (null != commonUserInfoDo) {
                Integer isFollow = userFollowManager.eachotherFollow(commonUserInfoDo.getSysUniId(), callContentVo.getUserUniId()) ? IsValidEnums.YES.getValue() : IsValidEnums.NO.getValue();
                userInfoVo.setIsFollow(isFollow);
            } else {
                userInfoVo.setIsFollow(IsValidEnums.NO.getValue());
            }
            map.put("info", userInfoVo);
            // call内容
            map.put("callContent", callContentVo);
            // 评论
            map.put("comment", comment);
            return ResultFactory.success(map);
        } else {
            // 否则就是下拉返回评论，那只要返回评论即可
            Map map = new HashMap(1);
            // 判断id是否准确
            if (!PageUtils.checkMongoDbObjId(id)) {
                throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
            }
            List<ReUserCommentVo> comment = userCommentService.findPageUserCommentByTargetId(callId, CommentType.COMMENT_TYPE_TEST, id);
            map.put("comment", comment);
            return ResultFactory.success(map);
        }
    }

    /**
     * 删除打call数据
     *
     * @param commonUserInfoDo
     * @param callId
     * @return
     */
    @Override
    public Result<Object> deleteCall(CommonUserInfoDo commonUserInfoDo, Long callId) {
        // 1，查询打call数据
        StarCallContentDo callContent = starCallContentManger.findCallContent(callId);
        // 2，判断打call数据是否存在
        if (null == callContent) {
            // 2-1,call数据不存在
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_NOT_FIND_CALL_EXCEPTION.getCode());
        }
        // 3，判断是否是用户自己的call
        if (!callContent.getUserUniId().equals(commonUserInfoDo.getSysUniId())) {
            // 3-1，不是用户自己的call
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_CALL_USER_NOT_IS_ME_EXCEPTION.getCode());
        }
        // 4，逻辑删除打call数据
        starCallContentManger.deleteCall(callId);
        // 5，物理删除点赞数据
        contentLikeManager.deleteLike(callId);
        // 6，逻辑删除评论数据
        if (userCommentManager.countCommentByCallId(callId) > 0) {
            userCommentManager.delCommentByCallId(callId);
        }
        // 7，删除成功
        return ResultFactory.success();
    }
}

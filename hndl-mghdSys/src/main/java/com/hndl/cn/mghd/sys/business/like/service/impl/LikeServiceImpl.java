package com.hndl.cn.mghd.sys.business.like.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hndl.cn.base.enums.fans.FansGroupContributeEnums;
import com.hndl.cn.base.enums.message.MessageTypeEnums;
import com.hndl.cn.base.enums.user.UserDayTaskEnums;
import com.hndl.cn.base.exception.enums.ExceptionSysMarkEnum;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.like.service.LikeService;
import com.hndl.cn.mghd.sys.business.message.service.UserMessageService;
import com.hndl.cn.mghd.sys.business.message.vo.UserMessageVo;
import com.hndl.cn.mghd.sys.business.star.service.StarFansStatisticsService;
import com.hndl.cn.mghd.sys.business.task.service.UserDayTaskService;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import com.hndl.cn.mghd.sys.exception.MghdSysExceptionEnums;
import com.hndl.cn.mongodb.manager.content.bean.StarCallContentDo;
import com.hndl.cn.mongodb.manager.content.manager.ContentLikeManager;
import com.hndl.cn.mongodb.manager.content.manager.StarCallContentManger;
import com.hndl.cn.mongodb.manager.star.bean.StarFansGroupDo;
import com.hndl.cn.mongodb.manager.star.manager.StarFansGroupManager;
import com.hndl.cn.nosql.redis.annotation.lock.SubmitLock;
import com.hndl.cn.utils.string.MessageFormatUtils;
import com.hndl.cn.utils.string.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @program: hndl-platform
 * @description: 点赞
 * @author: 易成贤
 * @create: 2019-05-09 11:01
 * @Created by 湖南达联
 **/
@Service
@Slf4j
public class LikeServiceImpl implements LikeService {


    @Resource
    ContentLikeManager contentLikeManager;

    @Resource
    StarCallContentManger starCallContentManger;

    @Resource
    UserDayTaskService userDayTaskService;
    @Resource
    StarFansGroupManager starFansGroupManager;
    @Resource
    StarFansStatisticsService starFansStatisticsService;
    @Resource
    UserMessageService userMessageService;

    /**
     * 点赞
     *
     * @param commonUserInfoDo
     * @param targetId         点赞的对象
     * @return
     */
    @Override
    @SubmitLock(keys = "commonUserInfoDo#sysUniId",sysMarkEnum = ExceptionSysMarkEnum.MGHD_SYS)
    public Result<Object> addLike(CommonUserInfoDo commonUserInfoDo, Long starId, Long targetId, Long userUniId) {
        //0，查一下这个点赞的对象在不在
        StarCallContentDo callContent = starCallContentManger.findCallContent(targetId);
        if (null == callContent) {
            //call数据不存在，点赞对象不存在
            log.info("点赞时候传来一条不存在的callId:"+targetId);
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_NOT_FIND_CALL_EXCEPTION.getCode());
        }
        //1，查询点没点过赞
        if (contentLikeManager.isLike(commonUserInfoDo.getSysUniId(), targetId)) {
            log.info("已经是点赞状态，不应该调用点赞接口");
            //已经点过赞了
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_IS_LIKE_EXCEPTION.getCode());
        }
        //2,插入点赞数据
        contentLikeManager.insertLike(commonUserInfoDo.getSysUniId(), targetId);
        //3,StarCallContent点赞数
        //增加点赞数
        starCallContentManger.incLikeCount(callContent.getCallId());
        //4，插入点赞任务
        userDayTaskService.insetTask(commonUserInfoDo.getSysUniId(), starId, UserDayTaskEnums.LIKE_TASK);

        //4，增加点赞后相关数据
        StarFansGroupDo fansGroup = starFansGroupManager.findStarFansGroup(starId);
        if (fansGroup == null) {
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_FANS_NULL_EXCEPTION.getCode());
        }
        starFansStatisticsService.addConductStatistics(commonUserInfoDo, fansGroup, FansGroupContributeEnums.LIKE);

        JSONObject json = new JSONObject();
        json.put("userNickName", commonUserInfoDo.getNickName());//用户昵称
        json.put("userImg", commonUserInfoDo.getPersonImgUrlMin());//用户头像url
        json.put("targetId",targetId);//点赞对象
        //插入消息
        userMessageService.insertUserMessage(
                UserMessageVo.builder()
                        .createUserId(commonUserInfoDo.getSysUniId())
                        .messageType(MessageTypeEnums.LIKE_MSG.getType())
                        .title(MessageFormatUtils.getAddlikeTitle(commonUserInfoDo.getNickName())).content(StringUtils.subContent(callContent.getContent()))
                        .sendUserId(userUniId).expandJson(json.toJSONString()).build());

        //点赞成功
        return ResultFactory.success();
    }

}

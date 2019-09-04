package com.hndl.cn.mghd.sys.business.comment.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.enums.comment.CommentType;
import com.hndl.cn.base.enums.message.MessageTypeEnums;
import com.hndl.cn.base.enums.user.UserDayTaskEnums;
import com.hndl.cn.base.exception.enums.ExceptionSysMarkEnum;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.comment.service.UserCommentService;
import com.hndl.cn.mghd.sys.business.comment.vo.ReUserCommentVo;
import com.hndl.cn.mghd.sys.business.comment.vo.UserCommentVo;
import com.hndl.cn.mghd.sys.business.message.service.UserMessageService;
import com.hndl.cn.mghd.sys.business.message.vo.UserMessageVo;
import com.hndl.cn.mghd.sys.business.task.service.UserDayTaskService;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import com.hndl.cn.mghd.sys.exception.MghdSysExceptionEnums;
import com.hndl.cn.mongodb.manager.comment.bean.UserCommentDo;
import com.hndl.cn.mongodb.manager.comment.manager.UserCommentManager;
import com.hndl.cn.mongodb.manager.content.bean.StarCallContentDo;
import com.hndl.cn.mongodb.manager.content.manager.StarCallContentManger;
import com.hndl.cn.mysql.manager.common.manager.CommonUserInfoManager;
import com.hndl.cn.nosql.redis.annotation.lock.SubmitLock;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.page.PageUtils;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import com.hndl.cn.utils.string.MessageFormatUtils;
import com.hndl.cn.utils.string.SensitiveWordFilter;
import com.hndl.cn.utils.string.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 尹争鸣
 * @Description TODO
 * @Date 2019年5月8日 11:17:53
 * @Created by 湖南达联
 */

@Service
public class UserCommentServiceImpl implements UserCommentService {
    @Resource
    private UserCommentManager userCommentManager;


    @Resource
    private CommonUserInfoManager commonUserInfoManager;

    @Resource
    private StarCallContentManger starCallContentManger;

    @Resource
    private UserDayTaskService userDayTaskService;

    @Resource
    private UserMessageService userMessageService;


    /**
     * 添加评论
     */
    @Override
    @SubmitLock(keys="commonUserInfoDo#sysUniId",sysMarkEnum = ExceptionSysMarkEnum.MGHD_SYS)
    public Result<Object> insertUserComment(CommonUserInfoDo commonUserInfoDo, UserCommentVo userCommentVo) {
        //判断被回复的评论主题是否存在
        if (!starCallContentManger.isCall(userCommentVo.getTargetId())) {
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_NOT_CALL_EXCEPTION.getCode());
        }

       //自己不能回复自己但自己可以评论自己
        if (null!=userCommentVo.getRepliesId()){
       if (commonUserInfoDo.getSysUniId().equals(userCommentVo.getRepliesUserId())){
           throw new MghdSysException(MghdSysExceptionEnums. MGHD_SYS_NOT_REPETITION_EXCEPTION.getCode());

       }}



       if (SensitiveWordFilter.INSTANCE.isContaintSensitiveWord(userCommentVo.getContent(),SensitiveWordFilter.maxMatchType)){
           userCommentVo.setContent( SensitiveWordFilter.INSTANCE.replaceSensitiveWord(userCommentVo.getContent(),SensitiveWordFilter.maxMatchType));
       }



        UserCommentDo userCommentDo = SpringCglibBeanUtils.convert(userCommentVo, UserCommentDo.class);

        userCommentDo.setUserUniId(commonUserInfoDo.getSysUniId());
        userCommentDo.setCommentType(BaseConstants.DEFAULT_COMMENT_TYPE);
        userCommentDo.setUserNickName(commonUserInfoDo.getNickName());
        userCommentDo.setUserImg(commonUserInfoDo.getPersonImgUrlMin());
        if (null!=userCommentVo.getRepliesId()) {
            userCommentDo.setRepliesUserId(userCommentVo.getRepliesUserId());

        }

        JSONObject json = new JSONObject();
        json.put("userNickName",commonUserInfoDo.getNickName());//用户昵称
        json.put("userImg",commonUserInfoDo.getPersonImgUrlMin());//用户头像url
        json.put("targetId",userCommentVo.getTargetId());
        if (StringUtils.isBlank(userCommentVo.getRepliesId())){
            StarCallContentDo callContent = starCallContentManger.findCallContent(userCommentVo.getTargetId());
            json.put("commentContent",StringUtils.subContent(callContent.getContent()));
        } else
        {
            if (!PageUtils.checkMongoDbObjId(userCommentVo.getRepliesId())) {
                throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
            }
            UserCommentDo commentByCommentId = userCommentManager.findCommentByCommentId(userCommentVo.getRepliesId());
             if (null==commentByCommentId) {
                 throw new MghdSysException(MghdSysExceptionEnums. MGHD_SYS_NOT_COMMENT_EXCEPTION.getCode());
             }
            json.put("commentContent", StringUtils.subContent(commentByCommentId.getContent()));
        }

        if (null==userCommentVo.getRepliesId()) {
            userDayTaskService.insetTask(commonUserInfoDo.getSysUniId(), userCommentVo.getStarId(), UserDayTaskEnums.COMMENT_TASK);
        }

        //插入消息
        userMessageService.insertUserMessage(
                UserMessageVo.builder()
                        .createUserId(commonUserInfoDo.getSysUniId())
                        .messageType(MessageTypeEnums.COMMENT_MSG.getType())
                        .title(MessageFormatUtils.getCommentTitle(commonUserInfoDo.getNickName())).content(StringUtils.subContent(userCommentVo.getContent()))
                        .sendUserId(userCommentVo.getRepliesUserId()).expandJson(json.toJSONString()).build());




        userCommentManager.insertComment(userCommentDo);
        starCallContentManger.incCommentCount(userCommentVo.getTargetId(),IsValidEnums.YES);

        Map<String,Object> map= new HashMap<>();

        map.put("callCount",this.countCallComment(userCommentDo.getTargetId()));
        return ResultFactory.success(map);
    }


    /**
     * 查询评论
     *
     * @param targetId
     * @param commentType
     * @param objId
     * @return
     */
    @Override
    public List<ReUserCommentVo> findPageUserCommentByTargetId(Long targetId, CommentType commentType, String objId) {

        if (null != objId && !PageUtils.checkMongoDbObjId(objId)) {
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }

        List<UserCommentDo> userCommenList = userCommentManager.findPageCommentByTargetId(targetId, commentType, objId);

        return  CollectionUtils.isEmpty(userCommenList) ? new ArrayList<>() :
                SpringCglibBeanUtils.convertByList(userCommenList, ReUserCommentVo.class);

    }

    /**
     * 删除评论
     * @param commonUserInfoDo 当前登陆的用户
     * @param id mongo ObjId
     * @return 返回删除成功或者异常信息
     */
    @Override
    public Result<Object> deleteComment(CommonUserInfoDo commonUserInfoDo,String id) {

        if (null != id && !PageUtils.checkMongoDbObjId(id)) {
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }

        //1,查询评论数据是否存在
       UserCommentDo userCommentDo =  userCommentManager.findCommentByUniIdAndId(commonUserInfoDo.getSysUniId(),id);
        if (null ==  userCommentDo) {
            //1-1，不是自己的评论或者评论数据不存在
            throw new  MghdSysException(MghdSysExceptionEnums.MGHD_SYS_COMMENT_BELONG_TO_ME_OR_NOT_FIND_EXCEPTION.getCode());
        }
        //2,逻辑删除评论
        userCommentManager.delCommentById(id);
        starCallContentManger.incCommentCount(userCommentDo.getTargetId(), IsValidEnums.NO);

        Map<String,Object> map= new HashMap<>();

        map.put("callCount",this.countCallComment(userCommentDo.getTargetId()));
        //3，返回成功
        return ResultFactory.success(map);
    }

    private  int  countCallComment(Long callId){

        return  userCommentManager.countCommentByCallId(callId);
    }
}

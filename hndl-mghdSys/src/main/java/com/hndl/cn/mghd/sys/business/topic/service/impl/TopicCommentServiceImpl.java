package com.hndl.cn.mghd.sys.business.topic.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.enums.message.MessageTypeEnums;
import com.hndl.cn.base.exception.enums.ExceptionSysMarkEnum;
import com.hndl.cn.base.redis.MgHdRedisKeyEnums;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.message.service.UserMessageService;
import com.hndl.cn.mghd.sys.business.message.vo.UserMessageVo;
import com.hndl.cn.mghd.sys.business.resources.service.ResourcesService;
import com.hndl.cn.mghd.sys.business.topic.service.TopicCommentService;
import com.hndl.cn.mghd.sys.business.topic.vo.TopicCommentVo;
import com.hndl.cn.mghd.sys.business.topic.vo.TopicCommentVos;
import com.hndl.cn.mghd.sys.common.constants.MghdSysConstants;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import com.hndl.cn.mghd.sys.exception.MghdSysExceptionEnums;
import com.hndl.cn.mongodb.manager.content.manager.ContentLikeManager;
import com.hndl.cn.mongodb.manager.topic.bean.TopicCommentDo;
import com.hndl.cn.mongodb.manager.topic.manager.TopicCommentManager;
import com.hndl.cn.mongodb.manager.topic.manager.TopicManager;
import com.hndl.cn.nosql.redis.annotation.lock.SubmitLock;
import com.hndl.cn.nosql.redis.page.RedisPageService;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.page.PageUtils;
import com.hndl.cn.utils.reg.RegExUtil;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import com.hndl.cn.utils.string.SensitiveWordFilter;
import com.hndl.cn.utils.string.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 尹争鸣
 * @Description TODO
 * @Date 2019年7月25日15:45:15
 * @Created by 湖南达联
 */

@Service
@Slf4j
public class TopicCommentServiceImpl implements TopicCommentService {

    @Resource
    private TopicCommentManager topicCommentManager;

    @Resource
    private ContentLikeManager contentLikeManager;

    @Resource
    private UserMessageService userMessageService;
    @Resource
    private TopicManager topicManager;

    @Resource
    private RedisService redisService;

    @Resource
    private RedisPageService redisPageService;

    @Resource
    private ResourcesService resourcesService;


    @Override
    @SubmitLock(keys="commonUserInfoDo#sysUniId",sysMarkEnum = ExceptionSysMarkEnum.MGHD_SYS)
    public void saveTopicComment(CommonUserInfoDo commonUserInfoDo, TopicCommentVo topicCommentVo) {

        //效验话题ID
        if (StringUtils.isNotBlank(topicCommentVo.getTopicId()) && !PageUtils.checkMongoDbObjId(topicCommentVo.getTopicId())) {
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
/*
        //效验话题评论ID
        if (StringUtils.isNotBlank(topicCommentVo.getTopicCommentId()) && !PageUtils.checkMongoDbObjId(topicCommentVo.getTopicCommentId())) {
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }*/

        //如果图片为空 内容不能为空
        if (null==topicCommentVo.getContentImgList()&&StringUtils.isBlank(topicCommentVo.getContent())){
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_TOPIC_COMMENT_CONTENT_NULL.getCode());
        }

    /*    // 判断话题是否存在
        TopicDo topicById = topicManager.findTopicById(topicCommentVo.getTopicId());
        if (null==topicById){
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_TOPIC_NOT_FIND_EXCEPTION.getCode());
        }
*/
       //如果是 回复 判断 评论是否存在
        if (null!=topicCommentVo.getReplyCommentId()&&null==topicCommentManager.findTopicCommentById(topicCommentVo.getReplyCommentId())){
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_TOPIC_COMMENT_NULL.getCode());
        }

        //敏感词过滤
        if (SensitiveWordFilter.INSTANCE.isContaintSensitiveWord(topicCommentVo.getContent(), SensitiveWordFilter.maxMatchType)) {
            topicCommentVo.setContent(SensitiveWordFilter.INSTANCE.replaceSensitiveWord(topicCommentVo.getContent(), SensitiveWordFilter.maxMatchType));
        }


        // 校验图片地址
        if (CollectionUtils.isNotEmpty(topicCommentVo.getContentImgList())) {
            for (String url : topicCommentVo.getContentImgList()) {
                // reg_exp：简单校验 http://mghd.oss-cn-hangzhou.aliyuncs.com/temp/min_img/ + 日期/+18位数字. +图片格式
                if (!RegExUtil.isImgUrl(url)) {
                    throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_PIC_DATA_EXCEPTION.getCode());
                }
            }
        }else {
            topicCommentVo.setContentImgList(new ArrayList<>(1));
        }

        //把存储的临时存储的图像注册并返回注册地址
        List<String> imgUrl = null;
        if (CollectionUtils.isNotEmpty(topicCommentVo.getContentImgList())) {
            // 循环遍历图片url
            imgUrl =
                    topicCommentVo.getContentImgList().stream()
                            .map(
                                    v -> {
                                        // ，注册大图地址
                                        resourcesService.registerTopicCommentImg(topicCommentVo.getTopicId(), v.replace("min", "max"));
                                        // 注册小图地址
                                        return resourcesService.registerTopicCommentImg(topicCommentVo.getTopicId(), v);
                                    })
                            .collect(Collectors.toList());
        }

        //防止传ID
        topicCommentVo.setId(null);
        //用户信息
        topicCommentVo.setUserUniId(commonUserInfoDo.getSysUniId());
        topicCommentVo.setUserNickName(commonUserInfoDo.getNickName());
        topicCommentVo.setUserImg(commonUserInfoDo.getPersonImgUrlMin());

        //热度值  点赞数  评论数 初始化
        topicCommentVo.setCommentCount(0);
        topicCommentVo.setHotCount(0);
        topicCommentVo.setLikeCount(0);

        topicCommentVo.setContentImgList(imgUrl);

        TopicCommentDo topicCommentDo = SpringCglibBeanUtils.convert(topicCommentVo, TopicCommentDo.class);

        topicCommentManager.insertTopicComment(topicCommentDo);

       //话题表中 评论数+1
        topicManager.incTopicCommentCount(topicCommentVo.getTopicId(), 1);

        // 被回复 评论热度值上升 评论数+1
        if (null!=topicCommentVo.getReplyCommentId()){

            TopicCommentDo topicCommentById = topicCommentManager.findTopicCommentById(topicCommentVo.getReplyCommentId());
            //评论未删除 才增加热度
            if (null!=topicCommentById){
                 //热度上升
                topicCommentManager.incHotCountById(topicCommentVo.getReplyCommentId());
            /*     //评论数+1
                topicCommentManager.incCommentCountById(topicCommentVo.getTopicCommentId(), 1);*/

                JSONObject json = new JSONObject();
                json.put("userNickName", commonUserInfoDo.getNickName());//用户昵称
                json.put("userImg", commonUserInfoDo.getPersonImgUrlMin());//用户头像url
                json.put("topicCommentId",topicCommentVo.getReplyCommentId() );//评论对象
                json.put("topicId",topicCommentVo.getTopicId());
                //插入消息
                userMessageService.insertUserMessage(
                        UserMessageVo.builder()
                                .createUserId(commonUserInfoDo.getSysUniId())
                                .messageType(MessageTypeEnums.COMMENT_MSG.getType())
                                .title(commonUserInfoDo.getNickName() + "评论了您").content(StringUtils.subContent(topicCommentDo.getContent(),50))
                                .sendUserId(topicCommentDo.getUserUniId()).expandJson(json.toJSONString()).build());
            }
        }


    }

    @Override
    public void delTopicCommentById(CommonUserInfoDo commonUserInfoDo, String id) {

        //效验话题评论ID
        if (StringUtils.isNotBlank(id) && !PageUtils.checkMongoDbObjId(id)) {
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }

        //判断是否 是自己的评论
        TopicCommentDo topicCommentDo = topicCommentManager.selectTopicCommentByIdAndUserUniId(id, commonUserInfoDo.getSysUniId());
        if (null==topicCommentDo){
           throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_COMMENT_BELONG_TO_ME_OR_NOT_FIND_EXCEPTION.getCode());
       }

        topicCommentManager.delTopicCommentById(id);
      //  topicCommentManager.delTopicCommentByTopicCommentId(id);
        Integer commentCount = topicCommentDo.getCommentCount()+1;
        //话题表中评论数-1
        topicManager.incTopicCommentCount(topicCommentDo.getTopicId(),-commentCount);
        //评论数-1
        if (null != topicCommentDo.getReplyCommentId()){
            topicCommentManager.incCommentCountById(topicCommentDo.getReplyCommentId(),-commentCount);
        }

    }

    @Override
    public void addLike(CommonUserInfoDo commonUserInfoDo, Long commentId) {

        /*//效验话题评论ID
        if (StringUtils.isNotBlank(id) && !PageUtils.checkMongoDbObjId(id)) {
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }*/

        TopicCommentDo topicCommentDo = topicCommentManager.findTopicCommentById(commentId);
        //判断评论是否存在
        if (null == topicCommentDo) {
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_NOT_COMMENT_EXCEPTION.getCode());
        }
        if (contentLikeManager.isLike(commonUserInfoDo.getSysUniId(), commentId)) {
            log.info("已经是点赞状态，不应该调用点赞接口");
            //已经点过赞了
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_IS_LIKE_EXCEPTION.getCode());
        }
       //插入点赞数据
        contentLikeManager.insertLike(commonUserInfoDo.getSysUniId(),commentId);

        //增加点赞数
        topicCommentManager.incLikeCountById(commentId);
        topicManager.incTopicLikeCount(topicCommentDo.getTopicId());
        //热度上升
        if (null!=topicCommentDo.getReplyCommentId()) {
            topicCommentManager.incHotCountById(topicCommentDo.getReplyCommentId());
        } else {
            topicCommentManager.incHotCountById(topicCommentDo.getCommentId());
        }

        JSONObject json = new JSONObject();
        json.put("userNickName", commonUserInfoDo.getNickName());//用户昵称
        json.put("userImg", commonUserInfoDo.getPersonImgUrlMin());//用户头像url
        json.put("topicCommentId", commentId);//点赞对象
        //插入消息
        userMessageService.insertUserMessage(
                UserMessageVo.builder()
                        .createUserId(commonUserInfoDo.getSysUniId())
                        .messageType(MessageTypeEnums.LIKE_MSG.getType())
                        .title(commonUserInfoDo.getNickName() + "给你点了赞").content(StringUtils.subContent(topicCommentDo.getContent()))
                        .sendUserId(topicCommentDo.getUserUniId()).expandJson(json.toJSONString()).build());

    }

    @Override
    public TopicCommentVos findPageTopicCommentByTopicIdAndTopicCommentId( String objId, Long commentId) {

        if (StringUtils.isNotBlank(objId) && !PageUtils.checkMongoDbObjId(objId)) {
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }

        if (null==commentId||null==topicCommentManager.findTopicCommentById(commentId)){
            log.info("查询评论：没有传CommentId或评论不存在");
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_TOPIC_COMMENT_NULL.getCode());
        }
        String key=MgHdRedisKeyEnums.TOPIC_COMMENT_NEW_CACKE_KEY.getCacheKey(objId+commentId);
        TopicCommentVos topicCommentVos=redisService.get(key);

        if (null==topicCommentVos){
            topicCommentVos=SpringCglibBeanUtils.convert(topicCommentManager.findTopicCommentById(commentId),TopicCommentVos.class);
            List<TopicCommentDo> topicCommentDoList = topicCommentManager.findPageTopicCommentByTopicCommentId(null, objId, IsValidEnums.NO,commentId, BaseConstants.DEFAULT_LIMIT);
            topicCommentVos.setTopicCommentVo(SpringCglibBeanUtils.convertByList(topicCommentDoList, TopicCommentVo.class));
            redisService.set(key,topicCommentVos,MgHdRedisKeyEnums.TOPIC_COMMENT_NEW_CACKE_KEY.getExpireTime());

        }

        return topicCommentVos;

    }

    /**
     * 查询评论
     * @param id
     * @param topicId
     * @param pageNo
     * @param isHot
     * @return
     */
    @Override
    public List<TopicCommentVos> findTopicComment(String id,String topicId,Integer pageNo,IsValidEnums isHot) {

        //传入话题id为
        if (StringUtils.isBlank(topicId)){
            log.info("查询评论：传入话题id为空");
            throw  new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }

        //未穿id，传了id小于1参数错误
        if (StringUtils.isBlank(id) && (null==pageNo || pageNo < 1)){
            log.info("查询评论：没有传id，pageNo传错");
            throw  new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        //连个参数都传
        if (StringUtils.isNotBlank(id) && null != pageNo){
            log.info("查询评论：又传id，又传了pageNo");
            throw  new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }

        //查询热评论
        if (IsValidEnums.YES.equals(isHot)){
            return findHotTopicComment(topicId,pageNo);
         //查询最新评论
        }else {
            return findNewTopicComment(id,topicId);
        }


    }

    /**
     * 查询最新的评论数据
     * @param id
     * @param topicId
     * @return
     */
    private List<TopicCommentVos> findNewTopicComment(String id,String topicId){


        String newKey= MgHdRedisKeyEnums.TOPIC_COMMENT_NEW_CACKE_KEY.getCacheKey(topicId);

        List<TopicCommentVos> topicCommentVosList= null;
        if (StringUtils.isBlank(id)){
         topicCommentVosList =redisService.get(newKey);

        }
        if (CollectionUtils.isEmpty(topicCommentVosList)) {
            List<TopicCommentDo> comment = topicCommentManager.findPageTopicCommentByTopicCommentId(topicId, id, IsValidEnums.NO, null, BaseConstants.DEFAULT_LIMIT);

            topicCommentVosList = SpringCglibBeanUtils.convertByList(comment, TopicCommentVos.class);
            topicCommentVosList.forEach(
                    val -> {
                        List<TopicCommentDo> topicCommentId = topicCommentManager.findPageTopicCommentByTopicCommentId(topicId, id, IsValidEnums.NO, val.getCommentId(), MghdSysConstants.SON_TOPIC_COMMENT_LIMIT);

                        List<TopicCommentVo> commentVos = SpringCglibBeanUtils.convertByList(topicCommentId, TopicCommentVo.class);
                        val.setTopicCommentVo(commentVos);
                    }
            );
            if (StringUtils.isBlank(id)){
                redisService.set(newKey,topicCommentVosList, MgHdRedisKeyEnums.TOPIC_COMMENT_NEW_CACKE_KEY.getExpireTime());
            }

        }
        return topicCommentVosList;
    }

    /**
     * 查询热评论
     * @return
     */
    private List<TopicCommentVos> findHotTopicComment(String topicId,Integer pageNo){
        String hotKey= MgHdRedisKeyEnums.TOPIC_COMMENT_HOT_CACKE_KEY.getCacheKey(topicId);
        List<TopicCommentVos> topicCommentVosList =redisService.get(hotKey);
        if (CollectionUtils.isEmpty(topicCommentVosList)){

            List<TopicCommentDo> topicCommentDoList= topicCommentManager.findPageTopicCommentByTopicCommentId(topicId,null,IsValidEnums.YES,null, MghdSysConstants.MAX_PAGE_NUM);

            topicCommentVosList = SpringCglibBeanUtils.convertByList(topicCommentDoList, TopicCommentVos.class);

            topicCommentVosList.forEach(val->{
                List<TopicCommentDo> topicCommentId = topicCommentManager.findPageTopicCommentByTopicCommentId(topicId, null, IsValidEnums.NO, val.getCommentId(), MghdSysConstants.SON_TOPIC_COMMENT_LIMIT);

                List<TopicCommentVo> commentVos = SpringCglibBeanUtils.convertByList(topicCommentId, TopicCommentVo.class);
                val.setTopicCommentVo(commentVos);
            });
            redisService.set(hotKey,topicCommentVosList,MgHdRedisKeyEnums.TOPIC_COMMENT_HOT_CACKE_KEY.getExpireTime());
        }

        return redisPageService.getKVList(hotKey,pageNo,BaseConstants.DEFAULT_LIMIT);
    }


}

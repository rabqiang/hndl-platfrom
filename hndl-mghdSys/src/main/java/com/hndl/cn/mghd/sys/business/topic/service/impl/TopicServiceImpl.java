package com.hndl.cn.mghd.sys.business.topic.service.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.redis.MgHdRedisKeyEnums;
import com.hndl.cn.mghd.sys.business.topic.service.TopicCommentService;
import com.hndl.cn.mghd.sys.business.topic.service.TopicService;
import com.hndl.cn.mghd.sys.business.topic.vo.TopicCommentVos;
import com.hndl.cn.mghd.sys.business.topic.vo.TopicVo;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import com.hndl.cn.mghd.sys.exception.MghdSysExceptionEnums;
import com.hndl.cn.mongodb.manager.topic.bean.TopicDo;
import com.hndl.cn.mongodb.manager.topic.manager.TopicManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.nosql.redis.page.RedisPageService;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.page.PageUtils;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import com.hndl.cn.utils.string.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program:hndl-platform
 * @description:TODO 话题
 * @author: 易成贤
 * @create: 2019/7/29 14:46
 * @Created by湖南达联
 **/
@Service
public class TopicServiceImpl implements TopicService {

    @Resource
    TopicManager topicManager;

    @Resource
    TopicCommentService topicCommentService;

    @Resource
    RedisService redisService;
    @Resource
    RedisPageService redisPageService;


    /**
     * 查询话题广场
     *
     * @param
     * @return
     */
    @Override
    public Map<String,Object> findTopicPlaza(Integer pageNo) {
        //推荐话题的key
       String recommenTopicKey = MgHdRedisKeyEnums.TOPIC_CACHE_KEY.getCacheKey("recommenTopic");

        long timeMillis = System.currentTimeMillis();

        List<TopicVo> recommenTopicVos = redisService.get(recommenTopicKey);
        if (CollectionUtils.isEmpty(recommenTopicVos)){
            //查询推荐话题
            List<TopicDo> recommenTopic = topicManager.findRecommenTopic(timeMillis);
            recommenTopicVos = SpringCglibBeanUtils.convertByList(recommenTopic, TopicVo.class);
            redisService.set(recommenTopicKey,recommenTopicVos,MgHdRedisKeyEnums.TOPIC_CACHE_KEY.getExpireTime());
        }
        //过往话题的key
        String pastTopicKey = MgHdRedisKeyEnums.TOPIC_CACHE_KEY.getCacheKey("pastTopic");
        List<TopicVo> pastTopicVos = redisPageService.getKVList(pastTopicKey,pageNo, BaseConstants.DEFAULT_LIMIT);
        if (CollectionUtils.isEmpty(pastTopicVos)){
            //查询过往话题
            List<TopicDo> pastTopic = topicManager.findPastTopic(timeMillis);
            List<TopicVo> topicVos = SpringCglibBeanUtils.convertByList(pastTopic, TopicVo.class);
            redisService.set(pastTopicKey, topicVos,MgHdRedisKeyEnums.TOPIC_CACHE_KEY.getExpireTime());
            pastTopicVos = redisPageService.getKVList(pastTopicKey,pageNo,BaseConstants.DEFAULT_LIMIT);
        }

        /**
         * 封装成map返回
         */
        Map map = new HashMap(2);
        map.put("recommenTopic",recommenTopicVos);
        map.put("pastTopic",pastTopicVos);
        return map;
    }

    /**
     * 查询话题详细
     *
     * @param topicId
     * @param isHot
     * @return
     */
    @Override
    public Map<String,Object> findTopicDetail(String id,String topicId, Integer pageNo, Integer isHot) {

        if (StringUtils.isBlank(topicId)){
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        Map map;

        if (StringUtils.isNotBlank(id) && !PageUtils.checkMongoDbObjId(id)){
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }

        //通过话题id查询话题是否存在
        TopicDo topic = topicManager.findTopicById(topicId);
        if (null == topic){
            //话题不存在
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_TOPIC_NOT_FIND_EXCEPTION.getCode());
        }

        //查询评论
        if (null != id  || pageNo > 1){
            map = new HashMap(1);
            //查询评论数据
            List<TopicCommentVos> topicComment = topicCommentService.findTopicComment(id, topicId, pageNo, IsValidEnums.evalVal(isHot));
            map.put("topicComment",topicComment);
            return map;
        }

        //第一页

        //转换vo
        TopicVo topicVo = SpringCglibBeanUtils.convert(topic, TopicVo.class);

        List<TopicCommentVos> topicComment = topicCommentService.findTopicComment(null, topicId, pageNo, IsValidEnums.evalVal(isHot));
        //组装数据
        map = new HashMap(2);
        map.put("topic",topicVo);
        map.put("topicComment",topicComment);
        return map;
    }
}

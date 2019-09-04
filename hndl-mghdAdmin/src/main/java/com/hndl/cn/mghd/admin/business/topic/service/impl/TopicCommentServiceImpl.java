package com.hndl.cn.mghd.admin.business.topic.service.impl;

import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.mghd.admin.business.topic.service.TopicCommentService;
import com.hndl.cn.mghd.admin.business.topic.vo.TopicCommentVo;
import com.hndl.cn.mghd.admin.exception.MghdAdminException;
import com.hndl.cn.mongodb.manager.topic.bean.TopicCommentDo;
import com.hndl.cn.mongodb.manager.topic.manager.TopicCommentManager;
import com.hndl.cn.utils.page.PageUtils;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import com.hndl.cn.utils.string.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
*  @author 尹争鸣
*  @Description TODO
*  @Date   2019年8月6日16:48:42
*  @Created by 湖南达联
*/
@Slf4j
@Service
public class TopicCommentServiceImpl implements TopicCommentService {

    @Resource
    private TopicCommentManager topicCommentManager;

    @Override
    public Result deleteTopicCommentById(String id) {

        if (!PageUtils.checkMongoDbObjId(id)){
            throw new MghdAdminException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        topicCommentManager.delTopicCommentById(id);
        return  ResultFactory.success();
    }


    @Override
    public Result<List<TopicCommentVo>> findPageTopicComment(String id,String nikeName,String topicId,Long userUniId) {


        if (StringUtils.isNotBlank(id) && !PageUtils.checkMongoDbObjId(id)){
            throw new MghdAdminException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }


        List<TopicCommentDo> topicComment = topicCommentManager.findTopicComment(id, nikeName, topicId, userUniId);

        return  ResultFactory.success(SpringCglibBeanUtils.convertByList(topicComment,TopicCommentVo.class));
    }
}

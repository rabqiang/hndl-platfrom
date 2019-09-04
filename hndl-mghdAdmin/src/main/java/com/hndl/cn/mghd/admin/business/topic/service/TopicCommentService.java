package com.hndl.cn.mghd.admin.business.topic.service;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.mghd.admin.business.topic.vo.TopicCommentVo;

import java.util.List;
/**
*  @author 尹争鸣
*  @Description TODO
*  @Date  2019年8月6日16:46:41
*  @Created by 湖南达联
*/

public interface TopicCommentService {


    /**
     * 删除话题评论
     * */
    Result deleteTopicCommentById(String id);


    Result<List<TopicCommentVo>>  findPageTopicComment(String id,String nikeName,String topicId,Long userUniId);
}

package com.hndl.cn.mghd.sys.business.topic.service;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.topic.vo.TopicCommentVo;
import com.hndl.cn.mghd.sys.business.topic.vo.TopicCommentVos;

import java.util.List;

/**
*  @author 尹争鸣
*  @Description TODO
*  @Date 2019年7月25日15:45:01
*  @Created by 湖南达联
*/

public interface TopicCommentService {


    /**
     *  添加话题评论
     * */
    void saveTopicComment(CommonUserInfoDo commonUserInfoDo,TopicCommentVo topicCommentVo);

    /**
     *  删除话题评论
     * */
    void delTopicCommentById(CommonUserInfoDo commonUserInfoDo,String id);

    /**
     *  点赞
     */
    void addLike(CommonUserInfoDo commonUserInfoDo, Long commentId);


    /**
     *  根据话题ID查询
     *    可以按 hot 和 时间 排序
     * */
    TopicCommentVos findPageTopicCommentByTopicIdAndTopicCommentId( String objId,Long commentId);


    /**
     * 查询话题详细下的评论数据
     * @param topicId
     * @param pageNo
     * @return
     */
    List<TopicCommentVos> findTopicComment(String id, String topicId, Integer pageNo, IsValidEnums isHot);



}

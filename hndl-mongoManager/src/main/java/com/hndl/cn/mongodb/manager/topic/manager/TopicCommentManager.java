package com.hndl.cn.mongodb.manager.topic.manager;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.mongodb.manager.topic.bean.TopicCommentDo;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface TopicCommentManager {

    /**
     *  新增话题评论
     * */
    void  insertTopicComment(TopicCommentDo topicCommentDo);


    /**
     *  根据ID删除话题评论
     * */
    void  delTopicCommentById(String id);


    /**
     *  根据topicCommentId 删除评论
     * */
     void delTopicCommentByTopicCommentId(Long replyCommentId);


    /**
     * 根据userUniId修改头像和名字
     * */
    void updateImgAndNameByUniId(Long userUniId,String userImg,String userNickName);


    /**
     *  根据ID查询话题评论
     * */
    TopicCommentDo findTopicCommentById(Long commentId);


    /**
     * 根据userUniId查询话题评论
     */

    List<TopicCommentDo>  findTopicCommentByUserUniId(Long userUniId,Long  replyCommentId,@NotNull  Integer limit);

    /**
     *  瀑布流 分页查询     * */
    List<TopicCommentDo> findPageTopicCommentByTopicCommentId(String topicId, String objId, IsValidEnums isHot, Long replyCommentId,@NotNull  Integer limit);


    /**
     *  点赞递增
     * */
    void  incLikeCountById(Long commentId);


    /**
     *  热度递增
     * */
    void  incHotCountById(Long commentId);

    /**
     *  评论数递增 或 递减
     * */
    boolean  incCommentCountById(Long commentId,Integer value);

    /**
     *  根据评论ID和用户ID查询
     *   可以判断是否我的评论
     * */
    TopicCommentDo selectTopicCommentByIdAndUserUniId(String id ,Long userUniId);


    List<TopicCommentDo> findTopicComment(String id,String nikeName,String topicId,Long userUniId);

}

package com.hndl.cn.mongodb.manager.topic.manager;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.topic.TopicStatusEnums;
import com.hndl.cn.mongodb.manager.topic.bean.TopicDo;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;

/**
 * @program:hndl-platform
 * @description:TODO 话题
 * @author: 易成贤
 * @create: 2019/7/29 14:47
 * @Created by湖南达联
 **/
public interface TopicManager {

    /**
     *查询推荐话题
     * @return
     */
    List<TopicDo> findRecommenTopic(Long time);

    /**
     * 查询过往话题
     * @return
     */
    List<TopicDo> findPastTopic(Long time);

    /**
     * 通过主键id查询发布的话题
     * @param id
     * @return
     */
    TopicDo findTopicById(String id);

    /**
     * 通过id查询话题<br/>
     *
     * @param id
     * @return
     */
    TopicDo findTopic(String id);

    /**
     * 通过in的方式查询话题
     * @param ids
     * @return
     */
    List<TopicDo> findTopicByIds(Collection<String> ids);

    /**
     * 原子更新评论数
     * @param id
     * @return
     */
    boolean incTopicCommentCount(String id,Integer value);

    /**
     * 查询所有话题
     * @param id
     * @param parameter
     * @param topicStatusEnums
     * @param isRecommen 是否推荐
     * @param isDelete
     * @param limit
     * @return
     */
    List<TopicDo> findAllTopic(String id, String parameter, TopicStatusEnums topicStatusEnums, IsValidEnums isRecommen, IsValidEnums isDelete, Integer limit);

    /**
     * 插入话题
     * @param topicDo
     */
    void insertTopic(TopicDo topicDo);

    /**
     * 更新话题
     * @param topicDo
     */
    void upsertTopic(TopicDo topicDo);

    /**
     * 跟新话题
     * @param topicDo
     */
    void updateTopic(TopicDo topicDo);

    /**
     * 统计推荐话题个数
     * @return
     */
    Long countByRecommen(IsValidEnums isRecommen);

    /**
     *  点赞递增
     * */
    void incTopicLikeCount(String id);


    /**
     * 查询所有话题
     * @param id
     * @param topicStatusEnums
     * @param isDelete
     * @param defaultLimit
     * @return
     */
    List<TopicDo> findAllTopic(String id, @NotNull Collection<Integer> topicStatusEnums, IsValidEnums isDelete, @NotNull Integer defaultLimit);

    /**
     * 根据标题查找话题
     * @param title
     * @return
     */
    TopicDo findTopicByTitle(String title);
}

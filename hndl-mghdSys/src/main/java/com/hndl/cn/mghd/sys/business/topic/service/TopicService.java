package com.hndl.cn.mghd.sys.business.topic.service;

import java.util.Map;

/**
 * @program:hndl-platform
 * @description:TODO 话题
 * @author: 易成贤
 * @create: 2019/7/29 14:46
 * @Created by湖南达联
 **/
public interface TopicService {
    /**
     * 查询话题广场
     * @param
     * @return
     */
    Map<String,Object> findTopicPlaza(Integer pageNo);

    /**
     * 查询话题详细
     * @param topicId
     * @param isHot
     * @return
     */
    Map<String,Object> findTopicDetail(String id,String topicId, Integer pageNo, Integer isHot);

}

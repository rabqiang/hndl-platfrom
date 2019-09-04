package com.hndl.cn.mghd.admin.business.topic.service;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.admin.bean.AdminUserInfoDo;
import com.hndl.cn.mghd.admin.business.topic.vo.ReceiveTopicVo;
import com.hndl.cn.mghd.admin.business.topic.vo.TopicStatusVo;
import com.hndl.cn.mghd.admin.business.topic.vo.TopicVo;

import java.util.List;

/**
 * @program:hndl-platform
 * @description:TODO 话题接口
 * @author: 易成贤
 * @create: 2019/7/29 19:55
 * @Created by湖南达联
 **/
public interface TopicService {
    /**
     * 查询所有话题
     * @param id 分页
     * @param parameter 参数
     * @param topicStatus 话题状态
     * @return
     */
    List<TopicVo> findAllTopic(String id,String parameter,Integer topicStatus,Integer isRecommen,Integer isDelete);

    /**
     * 添加话题
     * @param adminUserInfoDo
     * @param receiveTopicVo
     * @return
     */
    Result addTopic(AdminUserInfoDo adminUserInfoDo, ReceiveTopicVo receiveTopicVo);

    /**
     * 更新话题
     * @param loginUser
     * @param receiveTopicVo
     * @return
     */
    Result updateTopic(AdminUserInfoDo loginUser,String id, ReceiveTopicVo receiveTopicVo);

    /**
     * 删除话题
     * @param loginUser
     * @param id
     * @return
     */
    Result deleteTopic(AdminUserInfoDo loginUser, String id);

    /**
     * 取消发布话题
     * @param loginUser
     * @param id
     * @return
     */
    Result unPublishedTopic(AdminUserInfoDo loginUser, String id);

    /**
     * 查看单个话题
     * @param id
     * @return
     */
    Result<TopicVo> findTopicById(String id);

    /**
     * 通过话题
     * @param loginUser
     * @param id
     * @return
     */
    Result passTopic(AdminUserInfoDo loginUser, String id);

    /**
     *提交审核
     * @param loginUser
     * @param id
     * @return
     */
    Result submitAudit(AdminUserInfoDo loginUser, String id);

    /**
     * 查询编辑人员的话题列表
     * @param id
     * @param topicStatus
     * @return
     */
    List<TopicVo> findAllEditTopic(String id, Integer topicStatus);

    /**
     * 查询审核人员的话题列表
     * @param id
     * @param topicStatus
     * @return
     */
    List<TopicVo> findAllCheckTopic(String id, Integer topicStatus);

    /**
     * 不通过话题
     * @param loginUser
     * @param id
     * @return
     */
    Result noPassTopic(AdminUserInfoDo loginUser, String id);

    /**
     * 查询审核人员的状态
     * @return
     */
    Result<List<TopicStatusVo>> findCheckStatus();

    /**
     * 查询编辑人的查询状态
     * @return
     */
    Result<List<TopicStatusVo>> findEditStatus();
}

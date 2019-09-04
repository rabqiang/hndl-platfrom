package com.hndl.cn.mghd.admin.business.topic.service.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.enums.topic.TopicStatusEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.admin.bean.AdminUserInfoDo;
import com.hndl.cn.mghd.admin.business.resources.service.ResourcesService;
import com.hndl.cn.mghd.admin.business.topic.service.TopicService;
import com.hndl.cn.mghd.admin.business.topic.vo.ReceiveTopicVo;
import com.hndl.cn.mghd.admin.business.topic.vo.TopicStatusVo;
import com.hndl.cn.mghd.admin.business.topic.vo.TopicVo;
import com.hndl.cn.mghd.admin.exception.MghdAdminException;
import com.hndl.cn.mghd.admin.exception.MghdAdminExceptionEnums;
import com.hndl.cn.mongodb.manager.topic.bean.TopicDo;
import com.hndl.cn.mongodb.manager.topic.manager.TopicManager;
import com.hndl.cn.utils.page.PageUtils;
import com.hndl.cn.utils.reg.RegExUtil;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import com.hndl.cn.utils.string.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @program:hndl-platform
 * @description:TODO 话题接口
 * @author: 易成贤
 * @create: 2019/7/29 19:57
 * @Created by湖南达联
 **/
@Slf4j
@Service
public class TopicServiceImpl implements TopicService {

    @Resource
    TopicManager topicManager;

    @Resource
    ResourcesService resourcesService;

    /**
     * 查询所有话题
     * @param id 分页
     * @param parameter 参数
     * @param topicStatus 话题状态
     * @return
     */
    @Override
    public List<TopicVo> findAllTopic(String id, String parameter, Integer topicStatus, Integer isRecommen, Integer isDelete) {

        TopicStatusEnums topicStatusEnums = TopicStatusEnums.evalVal(topicStatus);
        if (null == topicStatusEnums) {
            throw new MghdAdminException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        List<TopicDo> topic = topicManager.findAllTopic(id, parameter, topicStatusEnums, IsValidEnums.evalVal(isRecommen), IsValidEnums.evalVal(isDelete), BaseConstants.DEFAULT_LIMIT);

        long timeMillis = System.currentTimeMillis();
        List<TopicVo> topicVos = topic.stream().map(val -> {
            TopicVo convert = SpringCglibBeanUtils.convert(val, TopicVo.class);
            if (val.getIsRecommen() > 0L && val.getEndRecommendTime() > timeMillis) {
                convert.setIsRecommen("推荐");
                convert.setIsRecommenInt(IsValidEnums.YES.getValue());
            } else {
                convert.setIsRecommen("非推荐");
                convert.setIsRecommenInt(IsValidEnums.NO.getValue());
            }
            convert.setAuditStr(TopicStatusEnums.evalVal(convert.getAudit()).getDescription());
            if (val.getPublishTime()>timeMillis){
                convert.setAuditStr("定时发布");
            }
            return convert;
        }).collect(Collectors.toList());

        return topicVos;
    }

    /**
     * 添加话题
     *
     * @param adminUserInfoDo
     * @param receiveTopicVo
     * @return
     */
    @Override
    public Result addTopic(AdminUserInfoDo adminUserInfoDo, ReceiveTopicVo receiveTopicVo) {

        TopicDo topicDo = SpringCglibBeanUtils.convert(receiveTopicVo, TopicDo.class);

        TopicDo topic =topicManager.findTopicByTitle(topicDo.getTitle());
        if (null != topic ){
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_TOPIC_TITLE_EXCEPTION.getCode());
        }

        //防止传id过来
        topicDo.setId(null);

        //创建时间
        long createTime = System.currentTimeMillis();
        topicDo.setCreateTime(createTime);
        //创建人
        topicDo.setCreateAdminId(adminUserInfoDo.getId());
        //更新时间
        topicDo.setUpdateTime(createTime);
        //更新id
        topicDo.setUpdateAdminId(adminUserInfoDo.getId());
        //审核状态
        topicDo.setAudit(TopicStatusEnums.NEW.getType());
        //点赞数
        topicDo.setLikeCount(0);
        //评论数
        topicDo.setCommentCount(0);
        //设定推荐值
        topicDo.setIsRecommen(topicDo.getEndRecommendTime());
        //删除状态
        topicDo.setIsDelete(IsValidEnums.NO.getValue());

        //校验传入图片
        if (!RegExUtil.isImgUrl(topicDo.getTitleImgUrl())) {
            throw new MghdAdminException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        //注册话题图片
        String topicImg = resourcesService.registerTopicImg(topicDo.getTitleImgUrl().replace("min", "max"));
        topicDo.setTitleImgUrl(topicImg);
        //插入话题
        topicManager.insertTopic(topicDo);

        return ResultFactory.success();
    }

    /**
     * 更新话题
     *
     * @param loginUser
     * @param receiveTopicVo
     * @return
     */
    @Override
    public Result updateTopic(AdminUserInfoDo loginUser, String id,ReceiveTopicVo receiveTopicVo) {

        //防止多人修改，笨重锁
        synchronized (this) {

            TopicDo topic = topicManager.findTopic(id);
            //话题不存在
            if (null == topic) {
                throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_TOPIC_IS_NULL_EXCEPTION.getCode());
            }
            //已发布话题无法修改
            if (TopicStatusEnums.PUBLISHED.getType().equals(topic.getAudit())){
                throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_TOPIC_PUBLISHED_EXCEPTION.getCode());
            }
            //话题待审核无法更改
            if(TopicStatusEnums.WAITAUDIT.getType().equals(topic.getAudit())){
                throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_TOPIC_IS_WAITTING_EXCEPTION.getCode());
            }

            TopicDo topicDo = SpringCglibBeanUtils.convert(receiveTopicVo, TopicDo.class);

            topicDo.setId(topic.getId());
            //时间
            long createTime = System.currentTimeMillis();
            //更新时间
            topicDo.setUpdateTime(createTime);
            //更新id
            topicDo.setUpdateAdminId(loginUser.getId());
            //审核状态
            topicDo.setAudit(TopicStatusEnums.NEW.getType());
            //删除状态
            topicDo.setIsDelete(IsValidEnums.NO.getValue());
            //推荐
            topicDo.setIsRecommen(topicDo.getEndRecommendTime());
            //判断是不原图
            if (!topic.getTitleImgUrl().equals(topicDo.getTitleImgUrl())) {
                String topicImg = resourcesService.registerTopicImg(topicDo.getTitleImgUrl().replace("min", "max"));
                topicDo.setTitleImgUrl(topicImg);
            }
            //更新
            topicManager.updateTopic(topicDo);
            log.info("原话题" + topic.toString() + "\n更新===》" + topicDo.toString());
            return ResultFactory.success();
        }
    }

    /**
     * 删除话题
     *
     * @param loginUser
     * @param id
     * @return
     */
    @Override
    public Result deleteTopic(AdminUserInfoDo loginUser, String id) {

        if (StringUtils.isBlank(id) || !PageUtils.checkMongoDbObjId(id)) {
            throw new MghdAdminException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        TopicDo topicDo = topicManager.findTopic(id);
        if (null == topicDo || IsValidEnums.YES.getValue().equals(topicDo.getIsDelete())) {
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_TOPIC_IS_NULL_EXCEPTION.getCode());
        }
        if (TopicStatusEnums.WAITAUDIT.getType().equals(topicDo.getAudit())){
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_TOPIC_IS_WAITTING_EXCEPTION.getCode());
        }
        if (TopicStatusEnums.PUBLISHED.getType().equals(topicDo.getAudit())){
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_TOPIC_PUBLISHED_EXCEPTION.getCode());
        }

        //时间
        long createTime = System.currentTimeMillis();
        //更新时间
        topicDo.setUpdateTime(createTime);
        //更新id
        topicDo.setUpdateAdminId(loginUser.getId());
        //审核状态不发布
        topicDo.setAudit(TopicStatusEnums.UNPUBLISHED.getType());
        //删除状态
        topicDo.setIsDelete(IsValidEnums.YES.getValue());
        //更新
        topicManager.updateTopic(topicDo);
        return ResultFactory.success();
    }

    /**
     * 取消发布话题
     *
     * @param loginUser
     * @param id
     * @return
     */
    @Override
    public Result unPublishedTopic(AdminUserInfoDo loginUser, String id) {
        //判断话题存在否
        TopicDo topicDo = topicManager.findTopic(id);
        if (null == topicDo || IsValidEnums.YES.getValue().equals(topicDo.getIsDelete())) {
            log.info("话题都不存在点击了取消发布话题！话题id ==》" + id);
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_TOPIC_IS_NULL_EXCEPTION.getCode());
        }

        if (TopicStatusEnums.NOPASS.getType().equals(topicDo.getAudit())) {
            log.info("话题都没通过却点击了取消发布话题！话题Id==>" + id);
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_TOPIC_IS_NOT_PASS_EXCEPTION.getCode());
        }

        if (TopicStatusEnums.UNPUBLISHED.getType().equals(topicDo.getAudit())) {
            log.info("话题未发布状态却点击了取消发布话题！话题Id==>" + id);
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_TOPIC_IS_UNPUBLISH_EXCEPTION.getCode());
        }


        //时间
        long createTime = System.currentTimeMillis();
        //更新时间
        topicDo.setUpdateTime(createTime);
        //更新id
        topicDo.setUpdateAdminId(loginUser.getId());
        //审核状态不发布
        topicDo.setAudit(TopicStatusEnums.UNPUBLISHED.getType());

        //更新
        topicManager.updateTopic(topicDo);
        return ResultFactory.success();
    }

    /**
     * 查看单个话题
     *
     * @param id
     * @return
     */
    @Override
    public Result<TopicVo> findTopicById(String id) {
        if (StringUtils.isBlank(id)||!PageUtils.checkMongoDbObjId(id)){
            throw new MghdAdminException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        //判断话题存在否
        TopicDo topicDo = topicManager.findTopic(id);
        if (null == topicDo) {
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_TOPIC_IS_NULL_EXCEPTION.getCode());
        }


        long timeMillis = System.currentTimeMillis();
        TopicVo topicVo = SpringCglibBeanUtils.convert(topicDo, TopicVo.class);

        if (topicDo.getIsRecommen() > 0L && topicDo.getEndRecommendTime() > timeMillis) {
            topicVo.setIsRecommen("推荐");
            topicVo.setIsRecommenInt(IsValidEnums.YES.getValue());
        } else {
           topicVo.setIsRecommen("非推荐");
            topicVo.setIsRecommenInt(IsValidEnums.NO.getValue());
        }
        topicVo.setAuditStr(TopicStatusEnums.evalVal(topicVo.getAudit()).getDescription());
        if (topicDo.getPublishTime()>timeMillis){
            topicVo.setAuditStr("定时发布");
        }
        return ResultFactory.success(topicVo);
    }

    /**
     * 通过话题
     *
     * @param loginUser
     * @param id
     * @return
     */
    @Override
    public Result passTopic(AdminUserInfoDo loginUser, String id) {
        TopicDo topicDo = topicManager.findTopic(id);
        if (null == topicDo) {
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_TOPIC_IS_NULL_EXCEPTION.getCode());
        }

        if (!TopicStatusEnums.WAITAUDIT.getType().equals(topicDo.getAudit())){
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_TOPIC_NOT_IS_WAITTING_EXCEPTION.getCode());
        }

        //判断推荐话题上限
        Long recommenCount = topicManager.countByRecommen(IsValidEnums.YES);
        if (recommenCount > BaseConstants.MAX_RECOMMEN_TOPIC_COUNT) {
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_TOPIC_RECOMMEN_IS_MAX_EXCEPTION.getCode());
        }
        //判断非推荐话题上限
        Long notRecommenCount = topicManager.countByRecommen(IsValidEnums.NO);
        if (recommenCount > BaseConstants.MAX_NOTRECOMMEN_TOPIC_COUNT) {
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_TOPIC_NOTRECOMMEN_IS_MAX_EXCEPTION.getCode());
        }

        //时间
        long createTime = System.currentTimeMillis();
        //更新时间
        topicDo.setUpdateTime(createTime);
        //更新id
        topicDo.setUpdateAdminId(loginUser.getId());
        //审核状态：发布
        topicDo.setAudit(TopicStatusEnums.PUBLISHED.getType());
        //删除状态
        topicDo.setIsDelete(IsValidEnums.NO.getValue());
        //判断时间
        if (topicDo.getPublishTime()<createTime){
            topicDo.setPublishTime(createTime);
        }
        //更新
        topicManager.updateTopic(topicDo);
        return ResultFactory.success();
    }

    /**
     * 提交审核
     *
     * @param loginUser
     * @param id
     * @return
     */
    @Override
    public Result submitAudit(AdminUserInfoDo loginUser, String id) {

        if (!PageUtils.checkMongoDbObjId(id)) {
            throw new MghdAdminException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        TopicDo topicDo = topicManager.findTopic(id);
        if (null == topicDo || IsValidEnums.YES.getValue().equals(topicDo.getIsDelete())) {
            log.info("有一条不存在或者已被删除的话题被提交审核！话题id：" + id);
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_TOPIC_IS_NULL_EXCEPTION.getCode());
        }
        topicDo.setId(id);
        //时间
        long createTime = System.currentTimeMillis();
        //更新时间
        topicDo.setUpdateTime(createTime);
        //更新id
        topicDo.setUpdateAdminId(loginUser.getId());
        //审核状态发布
        topicDo.setAudit(TopicStatusEnums.WAITAUDIT.getType());
        //删除状态
        topicDo.setIsDelete(IsValidEnums.NO.getValue());
        //更新
        topicManager.updateTopic(topicDo);
        return ResultFactory.success();
    }

    /**
     * 查询编辑人员的话题列表
     *
     * @param id
     * @param topicStatus
     * @return
     */
    @Override
    public List<TopicVo> findAllEditTopic(String id, Integer topicStatus) {
        TopicStatusEnums topicStatusEnums = TopicStatusEnums.getEdit().get(topicStatus);
        if (null != topicStatus && null == topicStatusEnums) {
            throw new MghdAdminException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }

        Set<Integer> set = new HashSet();

        //如果传入了筛选条件
        if (null != topicStatusEnums){
            set.add(topicStatusEnums.getType());
        }else {
            //否则未传入筛选条件
            for (TopicStatusEnums statusEnums : TopicStatusEnums.getEdit().values()) {
                set.add(statusEnums.getType());
            }
        }
        List<TopicDo> topic = topicManager.findAllTopic(id,set, IsValidEnums.NO, BaseConstants.DEFAULT_LIMIT);
        long timeMillis = System.currentTimeMillis();
        List<TopicVo> topicVos = topic.stream().map(val -> {
            TopicVo topicVo = SpringCglibBeanUtils.convert(val, TopicVo.class);

            if (val.getIsRecommen() > 0L && val.getEndRecommendTime() > timeMillis) {
                topicVo.setIsRecommen("推荐");
                topicVo.setIsRecommenInt(IsValidEnums.YES.getValue());
            } else {
                topicVo.setIsRecommen("非推荐");
                topicVo.setIsRecommenInt(IsValidEnums.NO.getValue());
            }
            topicVo.setAuditStr(TopicStatusEnums.getEdit().get(val.getAudit()).getDescription());
            return topicVo;
        }).collect(Collectors.toList());
        return topicVos;
    }

    /**
     * 查询审核人员的话题列表
     *
     * @param id
     * @param topicStatus
     * @return
     */
    @Override
    public List<TopicVo> findAllCheckTopic(String id, Integer topicStatus) {
        //校验参数
        TopicStatusEnums topicStatusEnums = TopicStatusEnums.getCheck().get(topicStatus);
        if (null != topicStatus && null == topicStatusEnums) {
            throw new MghdAdminException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }

       Set<Integer> set = new HashSet();

        //如果传入了筛选条件
        if (null != topicStatusEnums){
            set.add(topicStatusEnums.getType());
        }else {
            //否则未传入筛选条件
            for (TopicStatusEnums statusEnums : TopicStatusEnums.getCheck().values()) {
                set.add(statusEnums.getType());
            }
        }
        List<TopicDo> topic = topicManager.findAllTopic(id,set, IsValidEnums.NO, BaseConstants.DEFAULT_LIMIT);
        long timeMillis = System.currentTimeMillis();
        List<TopicVo> topicVos = topic.stream().map(val -> {
            TopicVo topicVo = SpringCglibBeanUtils.convert(val, TopicVo.class);

            if (val.getIsRecommen() > 0L && val.getEndRecommendTime() > timeMillis) {
                topicVo.setIsRecommen("推荐");
                topicVo.setIsRecommenInt(IsValidEnums.YES.getValue());
            } else {
                topicVo.setIsRecommen("非推荐");
                topicVo.setIsRecommenInt(IsValidEnums.NO.getValue());
            }
            topicVo.setAuditStr(TopicStatusEnums.getCheck().get(val.getAudit()).getDescription());

            if (TopicStatusEnums.PUBLISHED.getType().equals(val.getAudit()) && val.getPublishTime()>timeMillis){
                topicVo.setAuditStr("定时发布");
            }
            return topicVo;
        }).collect(Collectors.toList());
        return topicVos;
    }

    /**
     * 不通过话题
     *
     * @param loginUser
     * @param id
     * @return
     */
    @Override
    public Result noPassTopic(AdminUserInfoDo loginUser, String id) {

        //判断话题存在否
        TopicDo topicDo = topicManager.findTopic(id);
        if (null == topicDo || IsValidEnums.YES.getValue().equals(topicDo.getIsDelete())) {
            log.info("话题都不存在点击了通过话题！话题id ==》" + id);
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_TOPIC_IS_NULL_EXCEPTION.getCode());
        }

        if (TopicStatusEnums.PUBLISHED.getType().equals(topicDo.getAudit())) {
            log.info("话题已经发布点击了发布话题！话题id ==》" + id);
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_TOPIC_PUBLISHED_EXCEPTION.getCode());
        }

        if (!TopicStatusEnums.WAITAUDIT.getType().equals(topicDo.getAudit())){
            log.info("话题不是待审核状态点击了不通过 ==》" + id);
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_TOPIC_NOT_IS_WAITTING_EXCEPTION.getCode());
        }

        //时间
        long createTime = System.currentTimeMillis();
        //更新时间
        topicDo.setUpdateTime(createTime);
        //更新id
        topicDo.setUpdateAdminId(loginUser.getId());
        //审核状态：发布
        topicDo.setAudit(TopicStatusEnums.UNPUBLISHED.getType());
        //删除状态
        topicDo.setIsDelete(IsValidEnums.NO.getValue());
        //更新
        topicManager.updateTopic(topicDo);
        return ResultFactory.success();
    }

    /**
     * 查询审核人员的状态
     *
     * @return
     */
    @Override
    public Result<List<TopicStatusVo>> findCheckStatus() {
        List<TopicStatusVo> list = new ArrayList();
        for (TopicStatusEnums statusEnums : TopicStatusEnums.getCheck().values()) {
            TopicStatusVo statusVo = TopicStatusVo.builder().type(statusEnums.getType()).description(statusEnums.getDescription()).build();
            list.add(statusVo);
        }
        return ResultFactory.success(list);
    }

    /**
     * 查询编辑人员人员的状态
     *
     * @return
     */
    @Override
    public Result<List<TopicStatusVo>> findEditStatus() {
        List<TopicStatusVo> list = new ArrayList();
        for (TopicStatusEnums statusEnums : TopicStatusEnums.getEdit().values()) {
            TopicStatusVo statusVo = TopicStatusVo.builder().type(statusEnums.getType()).description(statusEnums.getDescription()).build();
            list.add(statusVo);
        }
        return ResultFactory.success(list);
    }

}

package com.hndl.cn.mghd.admin.business.call.service.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.mghd.admin.business.call.service.CallContentService;
import com.hndl.cn.mghd.admin.business.call.vo.CallContentVo;
import com.hndl.cn.mghd.admin.exception.MghdAdminException;
import com.hndl.cn.mghd.admin.exception.MghdAdminExceptionEnums;
import com.hndl.cn.mongodb.manager.comment.manager.UserCommentManager;
import com.hndl.cn.mongodb.manager.content.bean.StarCallContentDo;
import com.hndl.cn.mongodb.manager.content.manager.ContentLikeManager;
import com.hndl.cn.mongodb.manager.content.manager.StarCallContentManger;
import com.hndl.cn.mongodb.manager.star.bean.StarFansGroupDo;
import com.hndl.cn.mongodb.manager.star.manager.StarFansGroupManager;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program:hndl-platform
 * @description: call内容管理
 * @author: 易成贤
 * @create: 2019-06-25 10:48
 * @Created by湖南达联
 **/
@Service
@Slf4j
public class CallContentServiceImpl implements CallContentService {
    /**
     * 用户id长度
     */
    private final int UNIID_LENGTH = 18;

    @Resource
    StarCallContentManger starCallContentManger;
    @Resource
    ContentLikeManager contentLikeManager;
    @Resource
    UserCommentManager userCommentManager;

    @Resource
    StarFansGroupManager starFansGroupManager;
    /**
     * 删除call内容
     *
     * @param callId
     * @return
     */
    @Override
    public Result deleteCall(Long callId) {

        if (null == starCallContentManger.findCallContent(callId)) {
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_CALL_NOT_FIND_EXCEPTION.getCode());
        }
        //1,删除call
        starCallContentManger.deleteCall(callId);
        //2,评论信息删除
        userCommentManager.delCommentByCallId(callId);
        //3，删除点赞信息
        contentLikeManager.deleteLike(callId);
        return ResultFactory.success();
    }

    /**
     * 查询call
     *
     * @param
     * @return
     */
    @Override
    public  Result<List<CallContentVo>> findCall(String id,String parameters,Integer isDelete) {
        Set<Long> starId = null;
        Long userUniId = null;

        IsValidEnums validEnums = IsValidEnums.evalVal(isDelete);

        //对传入参数进行判断
        Long uid = NumberUtils.toLong(parameters);
        if (!uid.equals(0L)){
            //判断传入参数为数字情况
            if (UNIID_LENGTH ==  parameters.length()) {
                userUniId = uid;
            }else {
                starId = new HashSet<>(1);
                starId.add(uid);
            }

        }else {
            //否则就是明星名字
            List<StarFansGroupDo> group = starFansGroupManager.findFansGroupByKeyword(parameters);
            if (CollectionUtils.isNotEmpty(group)) {
                for (StarFansGroupDo starFansGroupDo : group) {
                    starId = new HashSet<>();
                    starId.add(starFansGroupDo.getStarId());
                }
            }

        }
        List<StarCallContentDo> starCallContents = starCallContentManger.findAllCall(id,starId, userUniId,validEnums,BaseConstants.ADMIN_CALL_LIMIT);

        List<CallContentVo> callContentVos = SpringCglibBeanUtils.convertByList(starCallContents, CallContentVo.class);

        return ResultFactory.success(callContentVos);
    }

    /**
     * 加入精华call（设置精华打call）<br/>
     * Quintessence(n.精华/典范)
     *
     * @param callId
     * @return
     */
    @Override
    public Result addQuintessence(Long callId) {
        StarCallContentDo callContent = starCallContentManger.findCallContent(callId);
        if (null == callContent) {
            //没有找到call
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_CALL_NOT_FIND_EXCEPTION.getCode());
        }
        //dao修改字段为当前时间（用于将来排序）
        starCallContentManger.updateIsRecommen(callContent.getId(),System.currentTimeMillis());
      return ResultFactory.success("加入精华打call成功！");
    }

    /**
     * 移除精华
     *
     * @param callId
     * @return
     */
    @Override
    public Result removeQuintessence(Long callId) {
        StarCallContentDo callContent = starCallContentManger.findCallContent(callId);
        if (null == callContent) {
            //没有找到call
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_CALL_NOT_FIND_EXCEPTION.getCode());
        }
        //
        starCallContentManger.updateIsRecommen(callContent.getId(),0L);
        return ResultFactory.success("取消精华打call成功！");
    }

    /**
     * 查询单个call
     *
     * @param callId
     * @return
     */
    @Override
    public Result<CallContentVo> findOneCall(Long callId) {
        StarCallContentDo callContent = starCallContentManger.findCallContent(callId);
        CallContentVo callContentVo = SpringCglibBeanUtils.convert(callContent, CallContentVo.class);
        return ResultFactory.success(callContentVo);
    }

}

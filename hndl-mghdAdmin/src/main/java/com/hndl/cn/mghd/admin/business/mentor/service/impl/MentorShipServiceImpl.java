package com.hndl.cn.mghd.admin.business.mentor.service.impl;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.admin.business.mentor.service.MentorShipService;
import com.hndl.cn.mghd.admin.business.mentor.vo.MentorShipVo;
import com.hndl.cn.mongodb.manager.task.bean.UserDayTaskDo;
import com.hndl.cn.mongodb.manager.task.bean.UserNormalityTaskDo;
import com.hndl.cn.mongodb.manager.task.manager.UserDayTaskManager;
import com.hndl.cn.mongodb.manager.task.manager.UserNormalityTaskManager;
import com.hndl.cn.mysql.manager.common.manager.CommonUserInfoManager;
import com.hndl.cn.utils.collection.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 曹加丽
 * @Description TODO 后台查询师徒信息
 * @Date 2019/6/19 16:59
 * @Created by 湖南达联
 */
@Service
public class MentorShipServiceImpl implements MentorShipService {
    @Resource
    UserNormalityTaskManager userNormalityTaskManager;
    @Resource
    CommonUserInfoManager commonUserInfoManager;
    @Resource
    UserDayTaskManager userDayTaskManager;

    @Override
    public Result<Object> findUserMentorAll(Long userId, String id) {
        List<MentorShipVo> voList = new ArrayList<>();
        //查询师徒信息
        List<UserNormalityTaskDo> slave = userNormalityTaskManager.getSlave(id, userId);
        //判断师徒信息是否为空
        if (CollectionUtils.isEmpty(slave)){
            return ResultFactory.success(voList);
        }
        for (UserNormalityTaskDo userNormalityTaskDo : slave) {
            MentorShipVo mentorVo = new MentorShipVo();
            mentorVo.setId(userNormalityTaskDo.getId());                                                                //_id
            mentorVo.setUserId(userNormalityTaskDo.getUserUniId());                                                     // 师父id(即用户id)
            CommonUserInfoDo commonUserInfo = commonUserInfoManager.findUserByUniId(Long.valueOf(userNormalityTaskDo.getObjId()));
            mentorVo.setSlaveId(commonUserInfo.getSysUniId());                                                          //徒弟id
            mentorVo.setSlaveCreateTime(userNormalityTaskDo.getCreateTime());                                           //收徒时间
            mentorVo.setSlaveName(commonUserInfo.getNickName());                                                        //徒弟昵称
            UserDayTaskDo userLastLoginTime = userDayTaskManager.getUserLastLoginTime(userNormalityTaskDo.getUserUniId());
            if (userLastLoginTime != null) {
                mentorVo.setSlaveLastTime(userLastLoginTime.getCreateTime());                                           //徒弟最后活跃时间(即最后登陆时间)
            }
            mentorVo.setSlaveSum(userNormalityTaskManager.countApprentice(userNormalityTaskDo.getUserUniId()).longValue());//用户徒弟数
            voList.add(mentorVo);
        }
        return ResultFactory.success(voList);
    }
}

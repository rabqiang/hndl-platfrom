package com.hndl.cn.mghd.sys.business.user.service.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.message.MessageTypeEnums;
import com.hndl.cn.base.enums.user.UserDayEmpiricalTypeEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.mghd.sys.business.user.service.UserIntegralLogService;
import com.hndl.cn.mghd.sys.business.user.vo.UserIntegralVo;
import com.hndl.cn.mongodb.manager.message.bean.UserMessageDo;
import com.hndl.cn.mongodb.manager.message.manager.UserMessageManager;
import com.hndl.cn.mongodb.manager.user.bean.UserIntegralLogDo;
import com.hndl.cn.mongodb.manager.user.manager.UserIntegralLogManager;
import com.hndl.cn.utils.string.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 曹加丽
 * @Description
 * @Date 2019/5/20 11:22
 * @Created by 湖南达联
 */
@Service
public class UserIntegralLogServiceImpl implements UserIntegralLogService {

    //用户积分
    @Resource
    private UserIntegralLogManager userIntegralLogManager;

    @Resource
    private UserMessageManager userMessageManager;

    /**
     * 查询用户积分明细
     *
     * @param userUinId    用户id
     * @param isValidEnums 积分数据是支出还是收入
     * @param pageNo       页数
     * @param
     * @return
     */
    @Override
    public Result<Object> findUserIntegralLog(Long userUinId, IsValidEnums isValidEnums, Integer pageNo,String id) {
        List<UserIntegralVo> list = new ArrayList<>();
        String lt = "";
        if (isValidEnums.getOldValue().equals(IsValidEnums.YES.getOldValue())) {
            lt = "奖励";
        }
        //旧版本pageNo第二页无数据
        if (null !=pageNo && pageNo > 1){
            return ResultFactory.success(new ArrayList<>(1));
        }
        //查询用户积分流水
        List<UserIntegralLogDo> userIntegralLogManagers = userIntegralLogManager.userIntegralLogAll(userUinId, pageNo,isValidEnums, id);
        if (userIntegralLogManagers != null) {
            for (UserIntegralLogDo integralLogManager : userIntegralLogManagers) {
                UserIntegralVo userIntegralVo = new UserIntegralVo();
                userIntegralVo.setId(integralLogManager.getId());
                userIntegralVo.setCreateTime(integralLogManager.getCreateTime());
                userIntegralVo.setIntegral(integralLogManager.getIntegralCount());
                if(StringUtils.isNotEmpty(userIntegralVo.getDescription())){
                    userIntegralVo.setDescription(integralLogManager.getDescription());
                }
                else{
                    UserDayEmpiricalTypeEnums typeEnums = UserDayEmpiricalTypeEnums.evalVal(integralLogManager.getGetIntegralType());
                    if (null != typeEnums) {
                        userIntegralVo.setDescription(typeEnums.getDescription() + lt);
                        if (integralLogManager.getGetIntegralType().equals(UserDayEmpiricalTypeEnums.FANS_REWARD.getTaskType())) {
                            UserMessageDo userMessageDo = userMessageManager.selectBySendUserIdAndTimeAndType(userUinId, integralLogManager.getCreateTime(), MessageTypeEnums.SYS_MSG.getType());
                            if (userMessageDo != null) {
                                String title = userMessageDo.getTitle().substring(4, 12);
                                userIntegralVo.setDescription(UserDayEmpiricalTypeEnums.FANS_REWARD.getDescription() + title);
                            } else {
                                userIntegralVo.setDescription(UserDayEmpiricalTypeEnums.FANS_REWARD.getDescription() + "--奖励");
                            }
                        }
                    }
                }
                list.add(userIntegralVo);
            }
        }
        return ResultFactory.success(list);

    }

}

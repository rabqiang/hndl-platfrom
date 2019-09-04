package com.hndl.cn.mghd.admin.business.user.service.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.user.UserDayEmpiricalTypeEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.admin.business.user.service.UserIntegralService;
import com.hndl.cn.mghd.admin.business.user.vo.UserIntegralVo;
import com.hndl.cn.mongodb.manager.user.bean.UserIntegralLogDo;
import com.hndl.cn.mongodb.manager.user.manager.UserIntegralLogManager;
import com.hndl.cn.mongodb.manager.user.manager.UserStatisticsDoManager;
import com.hndl.cn.mysql.manager.common.manager.CommonUserInfoManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/6/20 20:05
 * @Created by 湖南达联
 */
@Service
public class UserIntegralServiceImpl implements UserIntegralService {
    @Resource
    private UserIntegralLogManager userIntegralLogManager;
    @Resource
    private UserStatisticsDoManager userStatisticsDoManager;
    Long sum = 0L;

    @Override
    public Result<Object> findUserIntegralById(Long userUniId, String id) {
        //1.创建返回前台的listVo
        List<UserIntegralVo> voList = new ArrayList<>();
        //查询查询用户积分详细信息
        List<UserIntegralLogDo> userIntegralLogDos = userIntegralLogManager.userIntegralLogAll(userUniId, null, id, BaseConstants.DEFAULT_LIMIT);
        Long uid = 0L; //保存用户id
        Long integralCount = 0L;//保存用户积分数
        Long beforeValue = 0L;  //操作前积分数
        Long beforeOldValue = 0L;//操作后积分数
        for (UserIntegralLogDo userIntegralLogDo : userIntegralLogDos) {
            //获取当前积分数
            integralCount = userStatisticsDoManager.findUserStatisticsByUserUinId(userIntegralLogDo.getUserUniId()).getIntegralCount();

            if (id != null) {//判断_id不等于空时，将积分数赋予积分数中
                integralCount = sum;
            }
            if (uid.equals(userIntegralLogDo.getUserUniId())) integralCount = beforeOldValue;
            //判断操作前积分数不为空,并且当前的用户id与上一页的最后一个用户uid不一致
            if (beforeOldValue != 0 && !uid.equals(userIntegralLogDo.getUserUniId())) {
                //用户id防水变化重新查询当前积分数
                integralCount = userStatisticsDoManager.findUserStatisticsByUserUinId(userIntegralLogDo.getUserUniId()).getIntegralCount();
            }

            UserIntegralVo vo = new UserIntegralVo();
            vo.setId(userIntegralLogDo.getId());
            vo.setUserId(userIntegralLogDo.getUserUniId());
            vo.setCreateTime(userIntegralLogDo.getCreateTime());
            vo.setIntegralCount(userIntegralLogDo.getIntegralCount());
            IsValidEnums isValidEnums1 = IsValidEnums.evalVal(userIntegralLogDo.getIsIncome());
            if (beforeValue == 0) { //判断操作前积分数为空，将赋予查询出的积分数
                beforeValue = integralCount;
            }
            //判断积分数操作是否是增加
            if (isValidEnums1.getValue().equals(IsValidEnums.YES.getValue())) {
                vo.setConsumptionType(" + ");
                beforeValue = integralCount;
                beforeOldValue = beforeValue - userIntegralLogDo.getIntegralCount();
            } else {
                vo.setConsumptionType("- ");
                beforeValue = integralCount;
                beforeOldValue = beforeValue + userIntegralLogDo.getIntegralCount();
            }

            //判断当前积分描述为空,并且当前的是收入的类型
            if (userIntegralLogDo.getDescription() == null && isValidEnums1.getValue().equals(IsValidEnums.YES.getValue())) {
                vo.setGetIntegralType(UserDayEmpiricalTypeEnums.evalVal(userIntegralLogDo.getGetIntegralType()).getDescription() + "奖励");
            }
            else if (userIntegralLogDo.getDescription() == null && isValidEnums1.getValue().equals(IsValidEnums.NO.getValue())) {
                //判断当前积分描述为空,并且当前的是支出的类型
                vo.setGetIntegralType(UserDayEmpiricalTypeEnums.evalVal(userIntegralLogDo.getGetIntegralType()).getDescription());
            }
            else {
                vo.setGetIntegralType(userIntegralLogDo.getDescription());
            }
            vo.setIntegralSum(userStatisticsDoManager.findUserStatisticsByUserUinId(userIntegralLogDo.getUserUniId()).getIntegralCount()); //添加用户当前总积分
            vo.setBeforeOldValue(beforeOldValue); //将操作前积分保存到vo类中
            vo.setBeforeValue(beforeValue);         //将操作后积分保存到vo类中
            //判断查询用户数等于分页数，将积分操作前的记录保存到总值中
            if (userIntegralLogDos.size() == BaseConstants.DEFAULT_LIMIT) sum = beforeOldValue;
            uid = userIntegralLogDo.getUserUniId(); //将用户id保存到id中去
            voList.add(vo);
        }
        //返回ListVo对象
        return ResultFactory.success(voList);
    }


}

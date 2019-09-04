package com.hndl.cn.mghd.admin.business.user.service.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.user.UserDayEmpiricalTypeEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.mghd.admin.business.user.service.UserEmpiricalService;
import com.hndl.cn.mghd.admin.business.user.vo.EmpiricalVo;
import com.hndl.cn.mongodb.manager.user.bean.UserEmpiricalLogDo;
import com.hndl.cn.mongodb.manager.user.manager.UserEmpiricalLogDoManager;
import com.hndl.cn.mongodb.manager.user.manager.UserStatisticsDoManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/6/20 20:28
 * @Created by 湖南达联
 */
@Service
public class UserEmpiricalServiceImpl implements UserEmpiricalService {
    @Resource
    UserEmpiricalLogDoManager userEmpiricalLogDoManager;
    @Resource
    UserStatisticsDoManager userStatisticsDoManager;

    @Override
    public Result<Object> findUserEmpiricalById(Long userUniId,String pageNo) {
        //返回的页面是的结果
        List<EmpiricalVo> voeList = new ArrayList<>();
        //查询经验值
        List<UserEmpiricalLogDo> userEmpiricalLogDo = userEmpiricalLogDoManager.findUserEmpiricalLogDo(userUniId, pageNo, BaseConstants.DEFAULT_LIMIT);
        if (userEmpiricalLogDo == null) {
            return null;
        }
        userEmpiricalLogDo.stream().filter(userEmpirical -> userEmpirical != null).forEach(userEmpirical -> {
            EmpiricalVo voe = new EmpiricalVo();
            voe.setId(userEmpirical.getId());
            voe.setUserUniId(userEmpirical.getUserUniId());         //用户id
            voe.setCreateTime(userEmpirical.getCreateTime());       // 创建时间
            voe.setEmpiricalCount(userEmpirical.getEmpiricalCount());//获取经验值数
            voe.setGetEmpiricalType(UserDayEmpiricalTypeEnums.evalVal(userEmpirical.getGetChannel()).getDescription());  //获取途径
            voe.setEmpiricalSum(userStatisticsDoManager.findUserStatisticsByUserUinId(userEmpirical.getUserUniId()).getEmpirical()); //当前用户经验值
            //查询用户统计表中的经验值,返回
            voeList.add(voe);
        });

        return ResultFactory.success(voeList);
    }


}

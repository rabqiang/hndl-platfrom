package com.hndl.cn.shop.sys.business.welfare.service.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.math.NumberEnums;
import com.hndl.cn.base.enums.user.FoucaultGetTypeEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mongodb.manager.luckdraw.manager.FoucaultLogManager;
import com.hndl.cn.shop.sys.business.welfare.service.FoucaultLogService;
import com.hndl.cn.shop.sys.business.welfare.vo.FoucaultLogVo;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Classname
 * @Created by 湖南达联
 * @Date 2019/8/1 10 55
 * @Description:
 * @Author: 资龙茂
 */
@Service
public class FoucaultLogServiceImpl implements FoucaultLogService {

    @Resource
    private FoucaultLogManager foucaultLogManager;

    @Override
    public Result<Object> findFoucaultAddInfo(@NotNull CommonUserInfoDo commonUserInfoDo, String id) {
        List<FoucaultLogVo> foucaultLogVoList = SpringCglibBeanUtils.convertByList(foucaultLogManager.findFoucaultLogByUserId(
                commonUserInfoDo.getSysUniId(),
                IsValidEnums.YES.getValue(),
                id,
                NumberEnums.TWENTY.getNumber()), FoucaultLogVo.class);
        setValue(foucaultLogVoList);
        return ResultFactory.success(foucaultLogVoList);
    }

    @Override
    public Result<Object> findFoucaultRedInfo(@NotNull CommonUserInfoDo commonUserInfoDo, String id) {
        List<FoucaultLogVo> foucaultLogVoList = SpringCglibBeanUtils.convertByList(foucaultLogManager.findFoucaultLogByUserId(
                commonUserInfoDo.getSysUniId(),
                IsValidEnums.NO.getValue(),
                id,
                NumberEnums.TWENTY.getNumber()), FoucaultLogVo.class);
        setValue(foucaultLogVoList);
        return ResultFactory.success(foucaultLogVoList);
    }

    /**
     * 循环给VO赋交易类型 & 交易图片值
     * @param foucaultLogVoList
     * @return
     */
    private List<FoucaultLogVo> setValue(List<FoucaultLogVo> foucaultLogVoList) {
        if (CollectionUtils.isNotEmpty(foucaultLogVoList)) {
            foucaultLogVoList.stream().forEach(
                foucaultLogVo ->{
                    FoucaultGetTypeEnums eval = FoucaultGetTypeEnums.eval(foucaultLogVo.getTaskType());
                    if (eval != null) {
                        foucaultLogVo.setDealType(eval.getTaskTitle());
                        foucaultLogVo.setTypeImg(eval.getImgUrl());
                    } else {
                        foucaultLogVo.setDealType(FoucaultGetTypeEnums.TURN_TURNTABLE.getTaskTitle());
                        foucaultLogVo.setTypeImg(FoucaultGetTypeEnums.TURN_TURNTABLE.getImgUrl());
                    }
                }
            );
        }
        return foucaultLogVoList;
    }
}

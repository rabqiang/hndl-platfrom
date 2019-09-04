package com.hndl.cn.mghd.sys.business.pay.service.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.pay.PayReasonType;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.coin.bean.HappyCoinBillInfoDo;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.pay.service.HappyCoinBillInfoService;
import com.hndl.cn.mghd.sys.business.pay.vo.HappyCoinBillInfoVo;
import com.hndl.cn.mysql.manager.coin.manager.HappyCoinBillInfoManger;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: hndl-platform
 * @description: 快乐币流水
 * @author: 易成贤
 * @create: 2019-05-22 16:55
 * @Created by 湖南达联
 **/
@Service
public class HappyCoinBillInfoServiceImpl implements HappyCoinBillInfoService {
    @Resource
    HappyCoinBillInfoManger happyCoinBillInfoManger;


    /**
     * 查询快乐币流水
     *
     * @param commonUserInfo
     * @param currentPage
     * @param isValidEnums
     * @return
     */
    @Override
    public Result<List<HappyCoinBillInfoVo>> findHappyCoinBillInfo(CommonUserInfoDo commonUserInfo, Integer currentPage, IsValidEnums isValidEnums) {

        List<HappyCoinBillInfoDo> happyCoinBillInfos = happyCoinBillInfoManger.findHappyCoinBillInfo(commonUserInfo.getSysUniId(), currentPage, isValidEnums);

        List<HappyCoinBillInfoVo> collect = happyCoinBillInfos.stream().map(happyCoinBillInfoDo -> {
            HappyCoinBillInfoVo convert = SpringCglibBeanUtils.convert(happyCoinBillInfoDo, HappyCoinBillInfoVo.class);
            convert.setCreateTime(happyCoinBillInfoDo.getCreateTime().getTime());
                Integer reasonType = happyCoinBillInfoDo.getReasonType();
                String description = PayReasonType.evalVal(reasonType).getDescription();
                convert.setPayReasonDescription(description);
                return convert;
        }).collect(Collectors.toList());

        return ResultFactory.success(collect);
    }
}

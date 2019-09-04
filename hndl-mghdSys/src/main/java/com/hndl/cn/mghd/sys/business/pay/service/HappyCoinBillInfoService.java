package com.hndl.cn.mghd.sys.business.pay.service;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.pay.vo.HappyCoinBillInfoVo;

import java.util.List;

/**
 * @program: hndl-platform
 * @description: 快乐币流水
 * @author: 易成贤
 * @create: 2019-05-22 16:54
 * @Created by 湖南达联
 **/
public interface HappyCoinBillInfoService {

    /**
     * 查询快乐币流水
     * @param commonUserInfo
     * @param currentPage
     * @param isValidEnums
     * @return
     */
   Result<List<HappyCoinBillInfoVo>> findHappyCoinBillInfo(CommonUserInfoDo commonUserInfo, Integer currentPage, IsValidEnums isValidEnums);


}

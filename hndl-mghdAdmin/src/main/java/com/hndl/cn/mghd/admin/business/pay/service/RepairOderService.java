package com.hndl.cn.mghd.admin.business.pay.service;

import com.hndl.cn.base.result.Result;

/**
 * @program:hndl-platform
 * @description:TODO 补单
 * @author: 易成贤
 * @create: 2019/8/7 14:31
 * @Created by湖南达联
 **/
public interface RepairOderService {
    /**
     * 自动补单
     * @param userUniId
     * @param localOrder
     * @return
     */
    Result appleRepairOder(Long adminId,Long userUniId, Long localOrder,Integer isEnforcement,String remark);

}

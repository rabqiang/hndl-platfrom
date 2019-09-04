package com.hndl.cn.mghd.admin.business.star.service;


import com.hndl.cn.base.result.Result;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Classname
 * @Created by 湖南达联
 * @Date 2019/7/3 11 02
 * @Description:
 * @Author: 资龙茂
 */
public interface StarActiveDataService {

    /**
     * 根据明星姓名查询明星活跃数据
     * @param starName
     * @param startDate
     * @param endDate
     * @return
     */
    Result<Object> findStarActiveInfoByName(@NotNull String starName, @NotNull Long startDate, @NotNull Long endDate);
}

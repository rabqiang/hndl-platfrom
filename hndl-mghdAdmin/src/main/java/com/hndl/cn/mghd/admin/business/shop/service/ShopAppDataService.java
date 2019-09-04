package com.hndl.cn.mghd.admin.business.shop.service;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.mghd.admin.business.shop.vo.ShopAppDataVo;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @Classname 统计数据查询
 * @Created by 湖南达联
 * @Date 2019/7/15 14 55
 * @Description:
 * @Author: 资龙茂
 */
public interface ShopAppDataService {

    /**
     * 根据时间查询统计数据
     * @param limitStart 页码
     * @param pageSize 每页数量
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @return
     */
    Result<Object> findShopAppDataByDate(@NotNull Integer limitStart, @NotNull Integer pageSize, Long startDate, Long endDate);

    /**
     * 查询当天数据
     * @return
     */
    Result<Object> findCurrentShopAppData();
}

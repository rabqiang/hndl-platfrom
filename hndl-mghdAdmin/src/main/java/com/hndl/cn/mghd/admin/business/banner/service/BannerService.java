package com.hndl.cn.mghd.admin.business.banner.service;

import com.hndl.cn.base.enums.banner.BannerEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.admin.bean.AdminUserInfoDo;
import com.hndl.cn.dao.common.bean.CommonAdInfoDo;
import com.hndl.cn.mghd.admin.auth.user.vo.AdminUserVo;
import com.hndl.cn.mghd.admin.business.banner.vo.BannerVo;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Classname
 * @Created by 湖南达联
 * @Date 2019/6/24 22 09
 * @Description:
 * @Author: 资龙茂
 */
public interface BannerService {

    /**
     * 后台管理分页查询所有banner
     * @param model
     * @param pageNo
     * @param order
     * @return
     */
    List<BannerVo> findBannerInfo(String model, @NotNull Integer pageNo, Integer order);

    /**
     * 后台管理根据时间点查询对应模块banner
     * @param model
     * @param showTime
     * @return
     */
    List<BannerVo> findBannerInfoByTime(@NotNull String model, @NotNull Long showTime);

    /**
     * 根据model查询banner数量
     * @param model
     * @return
     */
    Long findBannerCount(String model);

    /**
     * 后台管理添加Banner
     * @param adminUserInfoDo
     * @param bannerVo
     * @return
     */
    Result<Object> addBanner(@NotNull AdminUserInfoDo adminUserInfoDo, BannerVo bannerVo);

    /**
     * 后台管理修改Banner
     * @param adminUserInfoDo
     * @param bannerVo
     * @return
     */
    Result<Object> updateBanner(@NotNull AdminUserInfoDo adminUserInfoDo, BannerVo bannerVo);

    /**
     * 后台管理删除Banner
     * @param adminUserInfoDo
     * @param id
     * @return
     */
    Result<Object> deleteBanner(@NotNull AdminUserInfoDo adminUserInfoDo, Long id);

    /**
     * 后台管理查询单条banner
     * @param id
     * @return
     */
    Result<Object> findBannerInfoSingle(Long id);

    /**
     * 刷新所有banner的Redis
     */
    Result<Object> refreshAllBanner();
}

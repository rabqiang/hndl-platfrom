package com.hndl.cn.mghd.admin.business.banner.service.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.banner.BannerEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.admin.bean.AdminUserInfoDo;
import com.hndl.cn.dao.common.bean.CommonAdInfoDo;
import com.hndl.cn.mghd.admin.business.banner.service.BannerService;
import com.hndl.cn.mghd.admin.business.banner.vo.BannerVo;
import com.hndl.cn.mghd.admin.business.resources.service.ResourcesService;
import com.hndl.cn.mghd.admin.common.enums.MgHdRedisKeyEnums;
import com.hndl.cn.mghd.admin.exception.MghdAdminException;
import com.hndl.cn.mghd.admin.exception.MghdAdminExceptionEnums;
import com.hndl.cn.mysql.manager.banner.manager.BannerManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.date.DateUtil;
import com.hndl.cn.utils.reg.RegExUtil;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import com.hndl.cn.utils.string.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Classname
 * @Created by 湖南达联
 * @Date 2019/6/25 10 39
 * @Description:
 * @Author: 资龙茂
 */
@Service
public class BannerServiceImpl implements BannerService {

    private static final Logger log = LoggerFactory.getLogger(BannerServiceImpl.class);

    @Resource
    private ResourcesService resourcesService;

    @Resource
    private BannerManager bannerManager;

    @Resource
    private RedisService redisService;

    @Override
    public List<BannerVo> findBannerInfo(String model, Integer pageNo, Integer order) {
        return convertByList(bannerManager.findBanner(BannerEnums.eval(model), pageNo, BaseConstants.BANNER_LIMIT, order));
    }

    @Override
    public List<BannerVo> findBannerInfoByTime(String model, Long showTime) {
        return convertByList(bannerManager.findBannerByShowTime(model, showTime));
    }

    @Override
    public Long findBannerCount(String model) {
        return bannerManager.getBannerSum(BannerEnums.eval(model));
    }

    @Override
    public Result<Object> addBanner(AdminUserInfoDo adminUserInfoDo, BannerVo bannerVo) {
        BannerEnums eval = BannerEnums.eval(bannerVo.getModel());
        checkEnumIsNull(eval);
        checkValue(bannerVo);
        // 插入banner数据
        CommonAdInfoDo commonAdInfoDo = new CommonAdInfoDo();
        commonAdInfoDo.setCreateOperator(adminUserInfoDo.getNickName());
        commonAdInfoDo.setCreateTime(new Date());

        commonAdInfoDo = setValue(commonAdInfoDo, adminUserInfoDo, bannerVo);
        bannerManager.addBanner(commonAdInfoDo);
        // 刷新Redis
        this.refreshBannerRedis(bannerVo.getModel());

        return ResultFactory.success();
    }

    @Override
    public Result<Object> updateBanner(AdminUserInfoDo adminUserInfoDo, BannerVo bannerVo) {
        checkValue(bannerVo);
        // 3. 修改banner数据
        CommonAdInfoDo commonAdInfoDo = bannerManager.findBannerById(bannerVo.getId());
        commonAdInfoDo = setValue(commonAdInfoDo, adminUserInfoDo, bannerVo);
        bannerManager.updateBanner(commonAdInfoDo);
        // 4. 刷新Redis
        this.refreshBannerRedis(bannerVo.getModel());

        return ResultFactory.success();
    }

    @Override
    public Result<Object> deleteBanner(AdminUserInfoDo adminUserInfoDo, Long id) {
        // 修改banner删除状态
        CommonAdInfoDo commonAdInfoDo = bannerManager.findBannerById(id);
        if (commonAdInfoDo == null) {
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_BANNER_NOTFOUND.getCode());
        }
        commonAdInfoDo.setLastModifyTime(new Date());
        commonAdInfoDo.setLastOperator(adminUserInfoDo.getLoginName());
        // 这里的删除状态应为'y'
        commonAdInfoDo.setIsDeleted(IsValidEnums.YES.getOldValue());
        bannerManager.updateBanner(commonAdInfoDo);
        // 刷新Redis
        this.refreshBannerRedis(commonAdInfoDo.getModel());

        return ResultFactory.success();
    }

    @Override
    public Result<Object> findBannerInfoSingle(Long id) {
        CommonAdInfoDo commonAdInfoDo = bannerManager.findBannerById(id);
        if (commonAdInfoDo.getIsDeleted().equals(IsValidEnums.YES.getOldValue())) {
            return null;
        }
        return ResultFactory.success(commonAdInfoDo);
    }

    @Override
    public Result<Object> refreshAllBanner() {
        Class<BannerEnums> bannerEnums = BannerEnums.class;
        for(BannerEnums obj : bannerEnums.getEnumConstants()){
            this.refreshBannerRedis(obj.getPath());
        }
        return ResultFactory.success();
    }



    /**
     * 检查枚举是否为空
     */
    private void checkEnumIsNull(BannerEnums eval) {
        if (eval == null) {
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_BANNER_ENUM_NOTFOUND.getCode());
        }
    }

    /**
     * 转换数据类型 & 给vo赋"是否有效"值
     * @param commonAdInfoDoList
     * @return
     */
    List<BannerVo> convertByList(List<CommonAdInfoDo> commonAdInfoDoList) {
        Date nowDate = new Date();
        // 如果当前时间处于banner有效期, 则set为有效, 否则set为无效
        return commonAdInfoDoList.stream().map(info -> {
            BannerVo bannerVo = SpringCglibBeanUtils.convert(info, BannerVo.class);
            if (DateUtil.isBetween(nowDate, bannerVo.getStartDate(), bannerVo.getEndDate())) {
                bannerVo.setIsValid(IsValidEnums.YES.getValue());
            } else {
                bannerVo.setIsValid(IsValidEnums.NO.getValue());
            }
            return bannerVo;
        }).collect(Collectors.toList());
    }

    /**
     * 刷新对应model的redis数据
     * @param model
     */
    public void refreshBannerRedis(String model) {
        String key = MgHdRedisKeyEnums.BANNER_CACHE_KEY.getCacheKey(model);
        List<CommonAdInfoDo> list = bannerManager.findBannerByModel(BannerEnums.eval(model));
        System.out.println(model + "   " + list.size());
        redisService.set(key, list, MgHdRedisKeyEnums.BANNER_CACHE_KEY.getExpireTime());
    }

    /**
     * 把bannerVo里的值赋给bannerDo
     * @param commonAdInfoDo
     * @param adminUserInfoDo
     * @param bannerVo
     * @return
     */
    CommonAdInfoDo setValue(CommonAdInfoDo commonAdInfoDo, AdminUserInfoDo adminUserInfoDo, BannerVo bannerVo) {
        // 结束时间不能小于开始时间
        if (bannerVo.getEndDate().getTime() < bannerVo.getStartDate().getTime()) {
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_DATE_ERROR.getCode());
        }
        commonAdInfoDo.setLastOperator(adminUserInfoDo.getLoginName());
        commonAdInfoDo.setLastModifyTime(new Date());
        commonAdInfoDo.setIsDeleted(IsValidEnums.NO.getOldValue());

        commonAdInfoDo.setStartDate(bannerVo.getStartDate());
        commonAdInfoDo.setEndDate(bannerVo.getEndDate());
        commonAdInfoDo.setImgUrl(bannerVo.getImgUrl());
        commonAdInfoDo.setHttpUrl(bannerVo.getHttpUrl());
        commonAdInfoDo.setOrderNum(bannerVo.getOrderNum());
        commonAdInfoDo.setModel(bannerVo.getModel());
        commonAdInfoDo.setAdDesc(bannerVo.getAdDesc());
        return commonAdInfoDo;
    }

    void checkValue(BannerVo bannerVo) {
        // 检查图片地址是否为空
        if (StringUtils.isBlank(bannerVo.getImgUrl())) {
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_PIC_DATA_EXCEPTION.getCode());
        }
        // 注册banner图片
        try {
            // 小图
            // resourcesService.registerBannerImg(bannerVo.getImgUrl());
            // 大图
            if (!bannerVo.getImgUrl().contains("banner")) {
                bannerVo.setImgUrl(resourcesService.registerBannerImg(bannerVo.getImgUrl().replace("min_img", "max_img")));
            }
        } catch (Exception e) {
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_PIC_DATA_EXCEPTION.getCode());
        }
    }

}

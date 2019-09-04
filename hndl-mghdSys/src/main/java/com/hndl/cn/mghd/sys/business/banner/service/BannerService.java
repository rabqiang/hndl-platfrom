package com.hndl.cn.mghd.sys.business.banner.service;

import com.hndl.cn.base.enums.banner.BannerEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonAdInfoDo;
import com.hndl.cn.mghd.sys.business.banner.vo.BannerVo;

import java.util.List;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/4/29 17:03
 * @Created by 湖南达联
 */
public interface BannerService {


    /**
     * 查询banner
     * @param bannerEnums
     * @return
     */
    List<BannerVo> findBannerInfo(BannerEnums bannerEnums);


    /**
     * 查询banner
     * @param bannerEnums
     * @return
     */
    Result<Object> findBannerInfoByBannerEnums(BannerEnums bannerEnums);
}

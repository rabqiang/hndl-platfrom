package com.hndl.cn.mysql.manager.banner.manager;

import com.hndl.cn.base.enums.banner.BannerEnums;
import com.hndl.cn.dao.common.bean.CommonAdInfoDo;
import com.hndl.cn.dao.common.bean.CommonAdInfoDoExample;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author 赵俊凯
 * @Description Banner Manager
 * @Date 2019/4/29 13:45
 * @Created by 湖南达联
 */
public interface BannerManager {


    /**
     * 根据类型查询Banner
     * @param bannerEnums
     * @return
     */
    List<CommonAdInfoDo> findBannerByModel(BannerEnums bannerEnums);

    /**
     * 后台管理查询所有Banner
     * @return
     */
    List<CommonAdInfoDo> selectByExample();

    /**
     * 统计banner数量
     * @param bannerEnums
     * @return
     */
    Long getBannerSum(BannerEnums bannerEnums);

    /**
     * 新增banner
     * @param commonAdInfoDo
     * @return
     */
    int addBanner(CommonAdInfoDo commonAdInfoDo);

    /**
     * 修改banner
     * @param commonAdInfoDo
     * @return
     */
    int updateBanner(CommonAdInfoDo commonAdInfoDo);

    /**
     * 根据ID查询banner详细信息
     * @param id
     * @return
     */
    CommonAdInfoDo findBannerById(Long id);

    /**
     * 根据时间&类型&有效无效分页查询所有banner
     * @param bannerEnums
     * @param pageNo
     * @param bannerLimit
     * @param order
     * @return
     */
    List<CommonAdInfoDo> findBanner(BannerEnums bannerEnums, Integer pageNo, Integer bannerLimit, Integer order);

    /**
     * 查看banner预览图
     * @param model
     * @param showTime
     * @return
     */
    List<CommonAdInfoDo> findBannerByShowTime(@NotNull String model, @NotNull Long showTime);
}

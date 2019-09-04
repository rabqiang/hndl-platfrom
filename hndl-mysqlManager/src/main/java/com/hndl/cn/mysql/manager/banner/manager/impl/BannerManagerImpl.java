package com.hndl.cn.mysql.manager.banner.manager.impl;

import com.github.pagehelper.PageHelper;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.banner.BannerEnums;
import com.hndl.cn.dao.common.bean.CommonAdInfoDo;
import com.hndl.cn.dao.common.bean.CommonAdInfoDoExample;
import com.hndl.cn.dao.common.mapper.CommonAdInfoDoMapper;
import com.hndl.cn.mysql.manager.banner.manager.BannerManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/4/29 13:50
 * @Created by 湖南达联
 */
@Service
public class BannerManagerImpl implements BannerManager {

    @Resource
    private CommonAdInfoDoMapper commonAdInfoDoMapper;


    @Override
    public List<CommonAdInfoDo> findBannerByModel(BannerEnums bannerEnums) {
        return commonAdInfoDoMapper.queryByModel(bannerEnums.getPath());
    }

    @Override
    public List<CommonAdInfoDo> selectByExample() {
        CommonAdInfoDoExample commonAdInfoDoExample = new CommonAdInfoDoExample();
        return commonAdInfoDoMapper.selectByExample(commonAdInfoDoExample);
    }

    @Override
    public Long getBannerSum(BannerEnums bannerEnums) {
        CommonAdInfoDoExample example = new CommonAdInfoDoExample();
        CommonAdInfoDoExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeletedEqualTo(IsValidEnums.NO.getOldValue());
        //判断model不等于空
        if (bannerEnums != null) {
            criteria.andModelEqualTo(bannerEnums.getPath());
        }
        return commonAdInfoDoMapper.countByExample(example);
    }

    @Override
    public List<CommonAdInfoDo> findBanner(BannerEnums bannerEnums, Integer pageNo, Integer bannerLimit, Integer order) {
        CommonAdInfoDoExample example = new CommonAdInfoDoExample();
        // 正序 or 倒序
        if (IsValidEnums.YES.getValue().equals(order)) {
            example.setOrderByClause(" create_time ASC");
        } else {
            example.setOrderByClause(" create_time DESC");
        }
        example.setOffset(Long.valueOf((pageNo - 1) * bannerLimit));
        example.setLimit(bannerLimit);
        CommonAdInfoDoExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(IsValidEnums.NO.getOldValue());
        // 根据banner类型查询
        if (bannerEnums != null) {
            criteria.andModelEqualTo(bannerEnums.getPath());
        }
        return commonAdInfoDoMapper.selectByExample(example);
    }

    @Override
    public List<CommonAdInfoDo> findBannerByShowTime(@NotNull String model, @NotNull Long showTime) {
        return commonAdInfoDoMapper.queryBannerByShowTime(model, new Date(showTime));
    }

    @Override
    public int addBanner(CommonAdInfoDo commonAdInfoDo) {
        return commonAdInfoDoMapper.insertSelective(commonAdInfoDo);
    }

    @Override
    public int updateBanner(CommonAdInfoDo commonAdInfoDo) {
        return commonAdInfoDoMapper.updateByPrimaryKey(commonAdInfoDo);
    }

    @Override
    public CommonAdInfoDo findBannerById(Long id) {
        return commonAdInfoDoMapper.selectByPrimaryKey(id);
    }
}

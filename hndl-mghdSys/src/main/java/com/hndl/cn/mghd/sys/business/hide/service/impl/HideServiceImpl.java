package com.hndl.cn.mghd.sys.business.hide.service.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.RequestTypeEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.mghd.sys.business.hide.service.HideService;
import com.hndl.cn.mghd.sys.business.hide.vo.HideVo;
import com.hndl.cn.mghd.sys.business.menu.service.CommonUserMenuInfoService;
import com.hndl.cn.utils.string.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program:hndl-platform
 * @description: 隐藏
 * @author: 易成贤
 * @create: 2019-06-12 15:11 @Created by湖南达联
 */
@Service
@Slf4j
public class HideServiceImpl implements HideService {

  @Resource CommonUserMenuInfoService commonUserMenuInfoService;
  /**
   * 隐藏
   *
   * @param source
   * @param version
   * @return
   */
  @Override
  public Result<HideVo> findIosHide(String source, String version) {
    HideVo hideVo = new HideVo();
    hideVo.setType(01);
    hideVo.setIsHide(IsValidEnums.NO.getValue());
    if (RequestTypeEnums.IOS.getValue().equals(source)
        && (StringUtils.stringToInteger(version) > commonUserMenuInfoService.findSysVersion())) {
      hideVo.setIsHide(IsValidEnums.YES.getValue());
    }
    return ResultFactory.success(hideVo);
  }

  /**
   * 插入隐藏
   *
   * @param hideVo
   */
  @Override
  public void insertHide(HideVo hideVo) {}
}

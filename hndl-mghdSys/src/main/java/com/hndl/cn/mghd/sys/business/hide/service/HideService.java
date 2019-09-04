package com.hndl.cn.mghd.sys.business.hide.service;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.mghd.sys.business.hide.vo.HideVo;

/**
 * @program:hndl-platform
 * @description: 隐藏
 * @author: 易成贤
 * @create: 2019-06-12 15:08 @Created by湖南达联
 */
public interface HideService {

  /**
   * 隐藏
   *
   * @param source
   * @param version
   * @return
   */
  Result<HideVo> findIosHide(String source, String version);

    /**
     * 插入隐藏
     * @param hideVo
     */
  void insertHide(HideVo hideVo);

}

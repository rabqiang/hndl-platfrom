package com.hndl.cn.mghd.sys.business.menu.service;


import com.hndl.cn.base.result.Result;
import com.hndl.cn.mghd.sys.business.menu.vo.UserMenuVo;

import java.util.List;

/**
 * @author 尹争鸣
 * @Description TODO
 * @Date 2019年5月10日 11:17:53
 * @Created by 湖南达联
 */

public interface CommonUserMenuInfoService {


     /**
      *  查询MENU信息
      * */

     List<UserMenuVo> findUserMenuInfo(String version);

     /**
      *  IOS根据版本号决定是否显示功能
      * */
     Result<Object> getUserMenuInfo(String version);


     /**
      * 获取当前系统版本号
      * @return
      */
     Integer findSysVersion();
}

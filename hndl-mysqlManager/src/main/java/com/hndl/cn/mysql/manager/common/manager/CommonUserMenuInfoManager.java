package com.hndl.cn.mysql.manager.common.manager;

import com.hndl.cn.dao.common.bean.CommonUserMenuInfoDo;
import com.hndl.cn.dao.common.bean.CommonUserMenuInfoDoExample;

import java.util.List;

public interface CommonUserMenuInfoManager {

    List<CommonUserMenuInfoDo> selectUserMenuInfo();

    CommonUserMenuInfoDo findMenuInfoById(Long id);

    int updateUserMenuInfo(CommonUserMenuInfoDo commonUserMenuInfoDo);

    int addUserMenuInfo(CommonUserMenuInfoDo commonUserMenuInfoDo);
}

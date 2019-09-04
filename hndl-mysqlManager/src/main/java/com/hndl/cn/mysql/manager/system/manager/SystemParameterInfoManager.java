package com.hndl.cn.mysql.manager.system.manager;

import com.hndl.cn.dao.system.bean.SystemParameterInfoDo;
import org.springframework.transaction.annotation.Transactional;

public interface SystemParameterInfoManager {

    SystemParameterInfoDo findByParameterName(String parameterName);

    /**
     * 定时刷新微博token
     * @param parameterName
     * @param token
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    boolean updateValueByParameterName(String parameterName, String token);

    /**
     *
     * @param key
     * @return
     */
    SystemParameterInfoDo selectByKey(String key);
}

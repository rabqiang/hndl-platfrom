package com.hndl.cn.version.sys.business.version.service;

import com.hndl.cn.version.sys.business.version.vo.VersionNewVo;
import com.hndl.cn.version.sys.business.version.vo.VersionVo;

/**
 * @author 尹争鸣
 * @Description 版本号
 * @Date 2019年6月1日18:33:25
 * @Created by 湖南达联
 */

public interface VersionService {


    /**
     *   获取版本信息
     * */
    VersionVo querySystemVersionInfo(String appType, String appName);


    /**
     *  获取版本信息 2.0
     * */
    VersionNewVo findVersionAndMaintain(String appType, String appName);


    /**
     *  获取版本信息 2.0
     * */
    VersionNewVo findVersionAndMaintain(String appType, String appName,String versionId);
}

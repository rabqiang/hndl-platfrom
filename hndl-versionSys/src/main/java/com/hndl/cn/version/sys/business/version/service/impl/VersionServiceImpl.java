package com.hndl.cn.version.sys.business.version.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.redis.MgHdRedisKeyEnums;
import com.hndl.cn.dao.system.bean.SystemParameterInfoDo;
import com.hndl.cn.dao.system.bean.SystemVersionInfoDo;
import com.hndl.cn.dao.system.bean.SystemVersionInfoDoExample;
import com.hndl.cn.dao.system.mapper.SystemVersionInfoDoMapper;
import com.hndl.cn.mysql.manager.system.manager.SystemParameterInfoManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import com.hndl.cn.utils.string.StringUtils;
import com.hndl.cn.version.sys.business.version.service.VersionService;
import com.hndl.cn.version.sys.business.version.vo.VersionNewVo;
import com.hndl.cn.version.sys.business.version.vo.VersionVo;
import com.hndl.cn.version.sys.common.constants.VersionSysConstants;
import com.hndl.cn.version.sys.exception.VersionSysException;
import com.hndl.cn.version.sys.exception.VersionSysExceptionEnums;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 尹争鸣
 * @Description 版本号VO
 * @Date 2019年6月1日18:33:25
 * @Created by 湖南达联
 */
@Service
public class VersionServiceImpl implements VersionService {

    @Resource
    private SystemVersionInfoDoMapper systemVersionInfoDoMapper;


    @Resource
    private SystemParameterInfoManager systemParameterInfoManager;


    @Resource
    private RedisService redisService;


    @Override
    public VersionVo querySystemVersionInfo(String appType, String appName) {

        String key = MgHdRedisKeyEnums.VERSION_CACHE_KEY.getCacheKey(appType);

        VersionVo versionVo = redisService.get(key);
        if (null == versionVo) {
            List<SystemVersionInfoDo> systemVersionInfoDos = this.findVersion(appType, appName);

            if (CollectionUtils.isNotEmpty(systemVersionInfoDos)) {
                versionVo = SpringCglibBeanUtils.convert(systemVersionInfoDos.get(0), VersionVo.class);
            }
            redisService.set(key, versionVo, MgHdRedisKeyEnums.VERSION_CACHE_KEY.getExpireTime());
        }


        return null == versionVo ? null : versionVo;
    }

    @Override
    public VersionNewVo findVersionAndMaintain(String appType, String appName) {

        String key = MgHdRedisKeyEnums.VERSION_MAINTAIN_STATE_CACHE_KEY.getCacheKey(appName + appType);

        if (null == redisService.get(key)) {
            VersionNewVo versionNewVo = new VersionNewVo();
            versionNewVo.setVersionVo(this.querySystemVersionInfo(appType, appName));
            String sysParameter = this.findSysParameter();
            JSONObject jsonObject= JSON.parseObject(sysParameter);
            versionNewVo.setMaintainState(jsonObject.getString("maintainState"));
            versionNewVo.setDescription(jsonObject.getString("description"));
            redisService.set(key, versionNewVo, MgHdRedisKeyEnums.VERSION_MAINTAIN_STATE_CACHE_KEY.getExpireTime());
        }

        return null == redisService.get(key) ? null : redisService.get(key);
    }

    @Override
    public VersionNewVo findVersionAndMaintain(String appType, String appName, String versionId) {

        String key = MgHdRedisKeyEnums.VERSION_MAINTAIN_STATE_CACHE_KEY.getCacheKey(appType+versionId);

        if (null == redisService.get(key)) {
            VersionNewVo versionNewVo = new VersionNewVo();
            List<SystemVersionInfoDo> systemVersionInfoDos = this.findVersion(appType, appName);

            versionNewVo.setRenewalType(VersionSysConstants.NORMAL);
            VersionVo versionVo = new VersionVo();
            if (CollectionUtils.isNotEmpty(systemVersionInfoDos)) {
                versionVo = SpringCglibBeanUtils.convert(systemVersionInfoDos.get(0), VersionVo.class);
                if (StringUtils.stringToInteger(versionVo.getVersionId()) > StringUtils.stringToInteger(versionId)) {
                    versionNewVo.setRenewalType(VersionSysConstants.REGULAR_UPDATES);
                }
                //判断历史版本中 是否有强更
                for (SystemVersionInfoDo systemVersionInfoDo : systemVersionInfoDos) {
                    Integer versionNumber = StringUtils.stringToInteger(systemVersionInfoDo.getVersionId());
                    //在未更新的版本中 只要有一个版本是强更，则直接强更到最新版本（如当前版本2.0.2（不强更版），用户版本1.9.4，但2.0.0是强更版，则用户直接强更到2.0.2）
                    if (versionNumber > StringUtils.stringToInteger(versionId) && IsValidEnums.YES.getOldValue().equals(systemVersionInfoDo.getIsForce())) {
                        versionVo.setIsForce(IsValidEnums.YES.getOldValue());
                        versionNewVo.setRenewalType(VersionSysConstants.FORCED_UPDATING);
                        break;
                    }
                }
            }

            versionNewVo.setVersionVo(versionVo);
            String sysParameter = this.findSysParameter();
            JSONObject jsonObject= JSON.parseObject(sysParameter);
            versionNewVo.setMaintainState(jsonObject.getString("maintainState"));
            versionNewVo.setDescription(jsonObject.getString("description"));
            redisService.set(key, versionNewVo, MgHdRedisKeyEnums.VERSION_MAINTAIN_STATE_CACHE_KEY.getExpireTime());

        }

        return null == redisService.get(key) ? null : redisService.get(key);
    }


    /**
     * 获取当前维护状态 0正常,1更新，2维护
     *
     * @return
     */
    private String findSysParameter() {

        SystemParameterInfoDo systemParameterInfoDo = systemParameterInfoManager.findByParameterName(VersionSysConstants.PARAMETER_NAME);

        if (null == systemParameterInfoDo) {
            throw new VersionSysException(VersionSysExceptionEnums.MGHD_SYS_MENU_NULL_PARAMETER_VALUE_EXCEPTION.getCode());
        }

        //获取维护状态
        return systemParameterInfoDo.getParameterValue();
    }

    private List<SystemVersionInfoDo> findVersion(String appType, String appName) {
        //获取Key
        String key = MgHdRedisKeyEnums.VERSION_CACHE_KEY.getCacheKey(appName + appType);
        //获取缓存
        List<SystemVersionInfoDo> systemVersionInfoDos = redisService.get(key);
        if (CollectionUtils.isEmpty(systemVersionInfoDos)) {
            SystemVersionInfoDoExample example = new SystemVersionInfoDoExample();
            example.createCriteria().andAppNameEqualTo(appName).andAppTypeEqualTo(appType).andIsDeletedEqualTo(IsValidEnums.NO.getOldValue());
            example.setOrderByClause("serial_number desc");
            // example.setLimit(VersionSysConstants.ONE);
            systemVersionInfoDos = systemVersionInfoDoMapper.selectByExample(example);
            redisService.set(key, systemVersionInfoDos, MgHdRedisKeyEnums.VERSION_CACHE_KEY.getExpireTime());
        }
        return CollectionUtils.isEmpty(systemVersionInfoDos) ? new ArrayList<>() : systemVersionInfoDos;
    }
}



package com.hndl.cn.mghd.sys.business.menu.service.impl;


import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.common.bean.CommonUserMenuInfoDo;
import com.hndl.cn.dao.system.bean.SystemParameterInfoDo;
import com.hndl.cn.mghd.sys.business.menu.service.CommonUserMenuInfoService;
import com.hndl.cn.mghd.sys.business.menu.vo.UserMenuVo;
import com.hndl.cn.base.redis.MgHdRedisKeyEnums;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import com.hndl.cn.mghd.sys.exception.MghdSysExceptionEnums;
import com.hndl.cn.mysql.manager.common.manager.CommonUserMenuInfoManager;
import com.hndl.cn.mysql.manager.system.manager.SystemParameterInfoManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import com.hndl.cn.utils.string.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * @author 尹争鸣
 * @Description TODO
 * @Date 2019年5月10日 11:17:53
 * @Created by 湖南达联
 */

@Service
public class CommonUserMenuInfServiceImpl implements CommonUserMenuInfoService {

    @Resource
    private CommonUserMenuInfoManager commonUserMenuInfoManager;

    @Resource
    private SystemParameterInfoManager systemParameterInfoManager;


    @Resource
    private RedisService redisService;

    private static String PARAMETER_NAME="ios_audit_version";

    /**
     *  IOS根据版本号决定是否显示功能
     * */
    @Override
    public Result<Object> getUserMenuInfo(String version){
        return ResultFactory.success(this.findUserMenuInfo(version));
    }



    @Override
    public  List<UserMenuVo> findUserMenuInfo(String version){
        String key = MgHdRedisKeyEnums.MENU_CACHE_KEY.getCacheKey();

        List<CommonUserMenuInfoDo> doList= redisService.get(key);


        if (CollectionUtils.isEmpty(doList)){
            doList = commonUserMenuInfoManager.selectUserMenuInfo();
            redisService.set(key,doList,MgHdRedisKeyEnums.MENU_CACHE_KEY.getExpireTime());
        }

        Integer sysVersion = this.findSysVersion();


        List<UserMenuVo> voList = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(doList)){
            //在这里处理版本号相关
            for(CommonUserMenuInfoDo menuInfoDo : doList){
                if(menuInfoDo == null){
                    continue;
                }
                if(StringUtils.stringToInteger(version) > sysVersion
                        && menuInfoDo.getIsIosHide().equals(IsValidEnums.YES.getOldValue())){
                    continue;
                }
                UserMenuVo vo = SpringCglibBeanUtils.convert(menuInfoDo,UserMenuVo.class);
                voList.add(vo);
            }
        }
        return voList;
    }




    /**
     * 获取当前系统版本号,需要配置缓存
     * @return
     */
    public Integer findSysVersion(){

        String key=MgHdRedisKeyEnums.PARAMETER_CACHE_KEY.getCacheKey(PARAMETER_NAME);

        String sysVersion = redisService.get(key);

        if(StringUtils.isNotBlank(sysVersion)){
             return StringUtils.stringToInteger(sysVersion);
        }


        SystemParameterInfoDo systemParameterInfoDo = systemParameterInfoManager.findByParameterName(PARAMETER_NAME);

        if (systemParameterInfoDo==null){
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_MENU_NULLPARAMETERVALUE_EXCEPTION.getCode());
        }

        redisService.set(key,sysVersion,MgHdRedisKeyEnums.PARAMETER_CACHE_KEY.getExpireTime());
        //获取审核版本号
        return StringUtils.stringToInteger(systemParameterInfoDo.getParameterValue());
    }

}

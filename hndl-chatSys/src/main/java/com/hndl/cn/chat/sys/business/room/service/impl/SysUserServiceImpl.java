package com.hndl.cn.chat.sys.business.room.service.impl;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.chat.sys.business.maesmob.bean.EaesMobRequestUserParam;
import com.hndl.cn.chat.sys.business.maesmob.bean.EaesMobUserInfoResponseParam;
import com.hndl.cn.chat.sys.business.maesmob.service.EaseMobIMUserService;
import com.hndl.cn.chat.sys.business.room.service.SysUserInfoService;
import com.hndl.cn.chat.sys.business.room.vo.EaseMobUserInfoVo;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mongodb.manager.easemob.bean.EaseMobUserInfoDo;
import com.hndl.cn.mongodb.manager.easemob.manager.EaseMobUserInfoManager;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import com.hndl.cn.utils.string.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname 赵俊凯
 * @Description
 * @Date 2019/3/21 21:17
 * @Created by 湖南达联
 */
@Service
public class SysUserServiceImpl implements SysUserInfoService {

    @Resource
    private EaseMobUserInfoManager easeMobUserInfoManager;

    @Resource
    private EaseMobIMUserService easeMobIMUserService;


    @Override
    public Result<Object> insertEaseMobUser(CommonUserInfoDo commonUserInfoDo) {

        //先判断已经保存数据
        EaseMobUserInfoDo easeMobUserInfoBySysUniId = easeMobUserInfoManager.findEaseMobUserInfoBySysUniId(commonUserInfoDo.getSysUniId());

        //如果保存过的
        if(easeMobUserInfoBySysUniId != null){
              return ResultFactory.success(SpringCglibBeanUtils.convert(easeMobUserInfoBySysUniId,EaseMobUserInfoVo.class));
        }

        //构建请求参数
        EaesMobRequestUserParam eaesMobRequestUserParam = EaesMobRequestUserParam.builder()
                .username(String.valueOf(commonUserInfoDo.getSysUniId()))
                .password(StringUtils.getRandomString()).nickname(commonUserInfoDo.getNickName()).build();


        EaesMobUserInfoResponseParam responseParam = easeMobIMUserService.createNewIMUserSingle(eaesMobRequestUserParam);

        EaseMobUserInfoDo easeMobUserInfoDo = null;
        //保存用户
        if(responseParam != null){
            easeMobUserInfoDo = EaseMobUserInfoDo.builder().easeMobUserName(responseParam.getUsername())
                    .easeMobUserType(responseParam.getType()).easeMobNickname(responseParam.getNickname())
                    .easeMobPassWord(eaesMobRequestUserParam.getPassword()).easeMobUuid(responseParam.getUuid())
                    .sysUniUserId(commonUserInfoDo.getSysUniId()).createTime(responseParam.getCreated())
                     .modifyTime(responseParam.getModified()).build();
            easeMobUserInfoManager.insertEaseMobUserInfo(easeMobUserInfoDo);
        }

        return ResultFactory.success(SpringCglibBeanUtils.convert(easeMobUserInfoDo,EaseMobUserInfoVo.class));
    }
}

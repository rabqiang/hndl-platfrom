package com.hndl.cn.chat.sys.business.maesmob.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hndl.cn.chat.sys.business.maesmob.bean.EaesMobRequestUserParam;
import com.hndl.cn.chat.sys.business.maesmob.bean.EaesMobUserInfoResponseParam;
import com.hndl.cn.chat.sys.business.maesmob.bean.EaesMobUserResponseParam;
import com.hndl.cn.chat.sys.business.maesmob.service.EaseMobIMUserService;
import com.hndl.cn.chat.sys.business.maesmob.service.EaseMobTokenService;
import com.hndl.cn.chat.sys.easemob.OrgInfoConfig;
import com.hndl.cn.chat.sys.easemob.enums.EaseMobBusinessEnums;
import com.hndl.cn.chat.sys.exception.ChatSysException;
import com.hndl.cn.chat.sys.exception.ChatSysExceptionEnums;
import com.hndl.cn.utils.http.HttpClientUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/21 14:04
 * @Created by 湖南达联
 */
@Service
public class EaseMobIMUserServiceImpl implements EaseMobIMUserService {


    @Resource
    private EaseMobTokenService easeMobTokenService;


    @Resource
    private OrgInfoConfig orgInfoConfigConfig;

    @Override
    public EaesMobUserInfoResponseParam createNewIMUserSingle(EaesMobRequestUserParam eaesMobRequestUserParam) {
        //初始化参数
        EaesMobUserInfoResponseParam responseParam = null;

        String[] params ={orgInfoConfigConfig.getSeaemobServerUrl() ,
                orgInfoConfigConfig.getOrgName() , orgInfoConfigConfig.getAppName(),
                EaseMobBusinessEnums.EASE_MOB_USER.getBusinessUrl()};
        //http rest 环信传建用户
        try{
        String resData = HttpClientUtil.doPostJson(EaseMobBusinessEnums.getEasemobServeUrl(params),
                easeMobTokenService.getEaseMobToken(),JSONObject.toJSONString(eaesMobRequestUserParam));
        //数据转化成obj
        EaesMobUserResponseParam eaesMobUserResponseParam =
                JSONObject.parseObject(resData,EaesMobUserResponseParam.class);

            String[] strings = eaesMobUserResponseParam.getEntities();
            //因为这里是注册单个用户，所以是 index[0]
            if(strings != null){
                 responseParam = JSONObject.parseObject(strings[0],EaesMobUserInfoResponseParam.class);

            }
        }catch (Exception e){
            throw new ChatSysException(
                    ChatSysExceptionEnums.CHAT_SYS_EX_EASE_MOB_CREATE_USER_ERROR.getCode());
        }
        return responseParam;
    }
}

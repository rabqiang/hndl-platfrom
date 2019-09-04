package com.hndl.cn.chat.sys.business.maesmob.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hndl.cn.chat.sys.business.maesmob.bean.EaesMobMsgParam;
import com.hndl.cn.chat.sys.business.maesmob.bean.EaesMobMsgResponseParam;
import com.hndl.cn.chat.sys.business.maesmob.bean.EaesMobRequestMsgParam;
import com.hndl.cn.chat.sys.business.maesmob.service.EaseMobSendMessageService;
import com.hndl.cn.chat.sys.business.maesmob.service.EaseMobTokenService;
import com.hndl.cn.chat.sys.easemob.OrgInfoConfig;
import com.hndl.cn.chat.sys.easemob.enums.EaesMobMsgTypeEnums;
import com.hndl.cn.chat.sys.easemob.enums.EaseMobBusinessEnums;
import com.hndl.cn.chat.sys.easemob.enums.EaseMobTargetTypeEnums;
import com.hndl.cn.chat.sys.exception.ChatSysException;
import com.hndl.cn.chat.sys.exception.ChatSysExceptionEnums;
import com.hndl.cn.utils.http.HttpClientUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/21 16:28
 * @Created by 湖南达联
 */
@Service
public class EaseMobSendMessageServiceImpl implements EaseMobSendMessageService {


    @Resource
    private OrgInfoConfig orgInfoConfigConfig;

    @Resource
    private EaseMobTokenService easeMobTokenService;


    @Override
    public void sendTxtMessageByRoomId(String targetType, String roomId, String fromNickName,String msg) {
        //初始化参数
        String[] params ={orgInfoConfigConfig.getSeaemobServerUrl() ,
                orgInfoConfigConfig.getOrgName() , orgInfoConfigConfig.getAppName(),
                EaseMobBusinessEnums.EASE_MOB_MSG.getBusinessUrl()};

        try {

            EaesMobMsgParam mobMsgParam = EaesMobMsgParam.builder().msg(msg).type(EaesMobMsgTypeEnums.TXT.getType()).build();
            EaesMobRequestMsgParam eaesMobRequestMsgParam = EaesMobRequestMsgParam.
                    builder().target_type(EaseMobTargetTypeEnums.CHAT_ROOMS.getType())
                    .target(new String[]{roomId}).from(fromNickName).eaesMobMsgParam(mobMsgParam).build();

            //执行
          String result =  HttpClientUtil.doPostJson(EaseMobBusinessEnums.getEasemobServeUrl(params),
                    easeMobTokenService.getEaseMobToken(),JSONObject.toJSONString(eaesMobRequestMsgParam));
          if(result != null){
              //暂时返回值，可能以后需要做异步发消息
              JSONObject.parseObject(result,EaesMobMsgResponseParam.class);
          }
        }catch (Exception e){
            throw new ChatSysException(
                    ChatSysExceptionEnums.CHAT_SYS_EX_EASE_MOB_CREATE_USER_ERROR.getCode());
        }


    }
}

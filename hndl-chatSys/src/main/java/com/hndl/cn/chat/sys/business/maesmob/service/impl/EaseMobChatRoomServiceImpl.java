package com.hndl.cn.chat.sys.business.maesmob.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.hndl.cn.chat.sys.business.maesmob.bean.EaesMobAddUserToChatRoomResponseParam;
import com.hndl.cn.chat.sys.business.maesmob.bean.EaesMobChatRoomResponseParam;
import com.hndl.cn.chat.sys.business.maesmob.bean.EaesMobRequestRoomParam;
import com.hndl.cn.chat.sys.business.maesmob.service.EaseMobChatRoomService;
import com.hndl.cn.chat.sys.business.maesmob.service.EaseMobTokenService;
import com.hndl.cn.chat.sys.easemob.OrgInfoConfig;
import com.hndl.cn.chat.sys.easemob.enums.EaseMobBusinessEnums;
import com.hndl.cn.chat.sys.exception.ChatSysException;
import com.hndl.cn.chat.sys.exception.ChatSysExceptionEnums;
import com.hndl.cn.utils.http.HttpClientUtil;
import com.hndl.cn.utils.string.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/21 14:13
 * @Created by 湖南达联
 */
@Service
public class EaseMobChatRoomServiceImpl implements EaseMobChatRoomService {

    private static final Logger log = LoggerFactory.getLogger(EaseMobChatRoomServiceImpl.class);

    @Resource
    private EaseMobTokenService easeMobTokenService;

    @Resource
    private OrgInfoConfig orgInfoConfigConfig;



    @Override
    public String createChatRoom(EaesMobRequestRoomParam eaesMobRequestRoomParam) {
         //初始化请求参数
         String chatRoomId = null;
         String[] params = {orgInfoConfigConfig.getSeaemobServerUrl(), orgInfoConfigConfig.getOrgName(),
                 orgInfoConfigConfig.getAppName(), EaseMobBusinessEnums.EASE_MOB_CHAT_ROOM.getBusinessUrl()};


        try {
            //rest http
            String  resultData = HttpClientUtil.doPostJson(EaseMobBusinessEnums.getEasemobServeUrl(params),
                    easeMobTokenService.getEaseMobToken(),JSONObject.toJSONString(eaesMobRequestRoomParam));

            //参数转化
            EaesMobChatRoomResponseParam responseParam = JSONObject.parseObject(resultData,EaesMobChatRoomResponseParam.class);

            String data = responseParam.getData();

            if(StringUtils.isNotBlank(data)){
                Gson gson = new Gson();
                Map gmap = gson.fromJson(data, Map.class);
                chatRoomId = (String) gmap.get("id");
            }

            if(chatRoomId == null){
                throw new ChatSysException(
                        ChatSysExceptionEnums.CHAT_SYS_EX_EASE_MOB_CREATE_ROOM_ERROR.getCode());
            }

        }catch (Exception e){
            e.printStackTrace();
            throw new ChatSysException(
                    ChatSysExceptionEnums.CHAT_SYS_EX_EASE_MOB_CREATE_ROOM_ERROR.getCode());
        }

        return chatRoomId;
    }

    @Override
    public Object getChatRoomDetail(String roomId) {
        String[] params = {orgInfoConfigConfig.getSeaemobServerUrl(), orgInfoConfigConfig.getOrgName(),
                orgInfoConfigConfig.getAppName(), EaseMobBusinessEnums.EASE_MOB_CHAT_ROOM.getBusinessUrl(),roomId};

        //请求参数
        String result = HttpClientUtil.doGet(EaseMobBusinessEnums.getEasemobServeUrl(params),null,
                easeMobTokenService.getEaseMobToken());

        log.info(result);

        return null;
    }

    @Override
    public boolean addSingleUserToChatRoom(String roomId, String userName) {
        //参数初始化
        String[] params = {orgInfoConfigConfig.getSeaemobServerUrl(), orgInfoConfigConfig.getOrgName(),
                orgInfoConfigConfig.getAppName(), EaseMobBusinessEnums.EASE_MOB_CHAT_ROOM.getBusinessUrl()
                           ,roomId,EaseMobBusinessEnums.EASE_MOB_USER.getBusinessUrl(),userName};


        try {
            //请求
            String result = HttpClientUtil.doPostJson(EaseMobBusinessEnums.getEasemobServeUrl(params),
                    easeMobTokenService.getEaseMobToken(),null);

            //判空
            if(StringUtils.isNotBlank(result)){
                EaesMobChatRoomResponseParam roomResponseParam = JSONObject.parseObject(result,EaesMobChatRoomResponseParam.class);
                String data = roomResponseParam.getData();
                //判空
                if(StringUtils.isNotBlank(data)){
                    EaesMobAddUserToChatRoomResponseParam param = JSONObject.parseObject(data,EaesMobAddUserToChatRoomResponseParam.class);
                    return param.isResult();
                }

            }
        }catch (Exception e){
            throw new ChatSysException(
                    ChatSysExceptionEnums.CHAT_SYS_EX_EASE_MOB_USER_TO_CREATE_ROOM_ERROR.getCode());
        }


        return false;
    }
}

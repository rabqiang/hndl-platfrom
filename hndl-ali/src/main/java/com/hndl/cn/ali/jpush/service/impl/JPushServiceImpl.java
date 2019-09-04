package com.hndl.cn.ali.jpush.service.impl;

import cn.jpush.api.JPushClient;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import com.hndl.cn.ali.jpush.service.JPushService;
import com.hndl.cn.base.properties.BasePropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/5/5 18:08
 * @Created by 湖南达联
 */
@Service
public class JPushServiceImpl implements JPushService {

    private static final Logger log = LoggerFactory.getLogger(JPushServiceImpl.class);

    @Resource
    private JPushClient jPushClient;

    @Value("${spring.boot.jpush.apnsProduction}")
    private String apnsProduction;

    @Value("${spring.boot.jpush.to.where}")
    private String toWhere;

    private boolean getApnsProduction(){
        return Boolean.valueOf(apnsProduction);
    }

    @Override
    public void noticeToOne(long userId,String msgContent) {

        PushPayload payload =  PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.alias(String.valueOf(userId)))
                .setMessage(Message.newBuilder()
                .setMsgContent(msgContent)
                .addExtra("from", toWhere)
                .build())
                .build();
        try {
            jPushClient.sendPush(payload);
        } catch (Exception e) {
            log.error("noticeToOne error",e);
        }
    }

    @Override
    public void noticeToAll(String ALERT, String toWhere) {
         PushPayload build = PushPayload.newBuilder()
                .setPlatform(Platform.all())//设置接受的平台
                .setAudience(Audience.all())//Audience设置为all，说明采用广播方式推送，所有用户都可以接收到
                .setNotification(Notification.alert(ALERT))
                .build();

        try {
            jPushClient.sendPush(build);
        } catch (Exception e) {
            log.error("noticeToAll error",e);
        }
    }
}

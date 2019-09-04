package com.hndl.cn.ali.mq.producer.service;

import com.aliyun.openservices.ons.api.OnExceptionContext;
import com.aliyun.openservices.ons.api.SendCallback;
import com.aliyun.openservices.ons.api.SendResult;
import org.springframework.stereotype.Service;

/**
 * @author 赵俊凯
 * @Description 异步发送消息回调处理
 * @Date 2019/4/24 18:18
 * @Created by 湖南达联
 */
@Service
public class SendCallbackImpl implements SendCallback {


    @Override
    public void onSuccess(SendResult sendResult) {
         return;
    }

    @Override
    public void onException(OnExceptionContext context) {
         //这里需要处理失败的消息
    }
}

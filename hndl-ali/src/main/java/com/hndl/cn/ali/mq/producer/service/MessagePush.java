package com.hndl.cn.ali.mq.producer.service;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.SendCallback;
import com.aliyun.openservices.ons.api.SendResult;
import com.hndl.cn.ali.mq.enums.RocketSendTypeEnums;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @author 赵俊凯
 * @Description 普通的发送
 * @Date 2019/4/24 17:49
 * @Created by 湖南达联
 */
@Component
public class MessagePush {

    private static final Logger log = LoggerFactory.getLogger(MessagePush.class);

    @Resource
    private Producer producer;


    @Resource
    private SendCallback sendCallback;

    /**
     * 发送消息
     * @param message 消息体
     * @param rocketSendTypeEnums 选择的模式
     */
    public void sendMessage(Message message,RocketSendTypeEnums rocketSendTypeEnums){

        switch (rocketSendTypeEnums){
            case SYNCH:
                //同步模式，消息不会丢失，性能一般
                SendResult sendResult =  producer.send(message);
                if(sendResult != null){
                    log.info("=============Message 消费成功,{}==================",message.getKey());
                }else {
                    //这里处理失败
                }
                break;
            case ASYNC:
                //异步处理,消息不会丢失，性能一般
                producer.sendAsync(message,sendCallback);
                break;
            case ONEWAY:
                //当向发送，可能会丢消息，性能最好，适合于比较并发较高并且 一致性较低的业务
                producer.sendOneway(message);
                break;
                default:
                    log.error("================未定义的枚举类型rocketSendTypeEnums==================");
                    break;
        }
    }
}

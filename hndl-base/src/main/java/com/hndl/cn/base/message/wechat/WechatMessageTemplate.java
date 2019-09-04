package com.hndl.cn.base.message.wechat;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/8/26 14:37
 * @Created by 湖南达联
 */
@Data
public class WechatMessageTemplate implements Serializable {

    private String touser;//哪个用户

    private String msgtype;//消息类型

}

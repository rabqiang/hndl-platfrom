package com.hndl.cn.chat.sys.business.maesmob.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Classname 赵俊凯
 * @Description 请求环信消息
 * @Date 2019/3/22 16:56
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EaesMobRequestMsgParam implements Serializable {

    private String target_type;//EaseMobTargetTypeEnums

    /**
     * 发送的目标；注意这里需要用数组，数组长度建议不大于20，即使只有一个用户，
     * 也要用数组 ['u1']；给用户发送时数组元素是用户名，给群组发送时，数组元素是groupid
     */
    private String[] target;

    private EaesMobMsgParam eaesMobMsgParam;

    private String from;//表示消息发送者


}

package com.hndl.cn.chat.sys.business.maesmob.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Classname 赵俊凯
 * @Description 环信消息
 * @Date 2019/3/22 16:49
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EaesMobMsgParam implements Serializable {

    private String type;//EaesMobMsgTypeEnums

    private String msg;//消息内容
}

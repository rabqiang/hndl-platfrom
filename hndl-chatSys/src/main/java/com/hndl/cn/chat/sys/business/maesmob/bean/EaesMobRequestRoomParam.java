package com.hndl.cn.chat.sys.business.maesmob.bean;

import lombok.*;

import java.io.Serializable;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/22 10:23
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EaesMobRequestRoomParam implements Serializable {

    private String name;//聊天室名称

    private String description;//聊天室描述

    private Integer maxusers;//最大人数，默认最大

    private String owner;//聊天室管理员
}

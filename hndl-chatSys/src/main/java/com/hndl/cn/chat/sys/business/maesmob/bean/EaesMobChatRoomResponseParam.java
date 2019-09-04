package com.hndl.cn.chat.sys.business.maesmob.bean;

import lombok.*;

import java.io.Serializable;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/22 15:21
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EaesMobChatRoomResponseParam implements Serializable {

    private String action;

    private String application;

    private String url;

    private String[] entities;

    private Long timestamp;

    private Integer duration;

    private String organization;

    private String applicationName;

    private String data;//数据
}

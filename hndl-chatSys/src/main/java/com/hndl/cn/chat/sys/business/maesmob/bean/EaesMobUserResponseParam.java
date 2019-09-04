package com.hndl.cn.chat.sys.business.maesmob.bean;

import lombok.*;

import java.io.Serializable;

/**
 * @Classname 赵俊凯
 * @Description 环信创建用户响应信息
 * @Date 2019/3/22 12:04
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EaesMobUserResponseParam implements Serializable {

    private String action;

    private String application;

    private String path;

    private String url;

    private String[] entities;

    private Long timestamp;

    private Integer duration;

    private String organization;

    private String applicationName;
}

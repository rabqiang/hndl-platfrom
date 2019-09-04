package com.hndl.cn.chat.sys.business.maesmob.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/22 17:08
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EaesMobMsgResponseParam implements Serializable {

    private String action;

    private String application;

    private String path;

    private String url;

    private Long timestamp;

    private Integer duration;

    private String organization;

    private String applicationName;

    private String data;//数据
}

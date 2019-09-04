package com.hndl.cn.chat.sys.business.maesmob.bean;

import lombok.*;

import java.io.Serializable;

/**
 * @Classname 赵俊凯
 * @Description 环信用户具体信息
 * @Date 2019/3/22 12:06
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EaesMobUserInfoResponseParam implements Serializable {

    private String uuid;

    private String type;

    private Long created;

    private Long modified;

    private String username;

    private String  nickname;

}

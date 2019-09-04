package com.hndl.cn.chat.sys.business.maesmob.bean;

import lombok.*;

import java.io.Serializable;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/21 14:21
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EaesMobRequestUserParam implements Serializable {

    private String username;//用户账号

    private String password;//用户密码

    private String nickname;//昵称
}

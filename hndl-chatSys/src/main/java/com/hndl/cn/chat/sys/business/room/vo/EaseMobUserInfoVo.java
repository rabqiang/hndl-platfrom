package com.hndl.cn.chat.sys.business.room.vo;

import lombok.*;

import java.io.Serializable;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/21 21:31
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EaseMobUserInfoVo implements Serializable {

    private String easeMobUserName;//环信用户名

    private String easeMobPassWord;//环信密码


}

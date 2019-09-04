package com.hndl.cn.chat.sys.business.maesmob.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/22 16:24
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EaesMobAddUserToChatRoomResponseParam implements Serializable {

    private boolean result;

    private String add_member;

    private String id;

    private String user;
}

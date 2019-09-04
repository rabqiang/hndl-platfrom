package com.hndl.cn.mghd.sys.business.star.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program:hndl-platform
 * @description: 返回用户数据
 * @author: 易成贤
 * @create: 2019-04-29 16:50
 * @Created by 湖南达联
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoVo implements Serializable {
    //用户id
    private Long sysUniId;
    //小头像地址
    private String personImgUrlMin;
    //昵称
    private String nickName;
    //贡献值
    private Long fansContribute;
}

package com.hndl.cn.mghd.sys.business.follow.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 尹争鸣
 * @Description 返回关注相关信息VO
 * @Date 2019年5月31日11:01:40
 * @Created by 湖南达联
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoVo implements Serializable {

    private Long starIdOrUniId;

    private String nikeName; //名字

    private String description; // 类似个性签名

    private String imgUrl;// 头像路径

    private Integer state;// 是否互相关注 1相互关注  0单向关注

    private Integer  roleType; // 角色类型 普通用户 20 or 明星 10
}

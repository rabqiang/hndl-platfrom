package com.hndl.cn.mghd.admin.business.friend.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 尹争鸣
 * @Description 返回关注相关信息VO
 * @Date 2019年6月23日11:01:40
 * @Created by 湖南达联
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FriendInfoVo implements Serializable {

    private String  id;

    private Long uNiId;

    private String nikeName; //名字

    private Integer state;// 是否互相关注 0 关注 1粉丝  2好友

    private Long  friendTime;// 建立关系时间

    private Long  activeTime;//最后活跃时间
}

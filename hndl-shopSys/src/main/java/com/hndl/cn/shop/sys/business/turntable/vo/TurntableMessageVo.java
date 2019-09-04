package com.hndl.cn.shop.sys.business.turntable.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 尹争鸣
 * @Description TODO
 * @Date 2019年7月10日11:08:20
 * @Created by 湖南达联
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TurntableMessageVo {

    
    private String id;

    private Long createTime;//创建时间

    private Integer isEntity;// 1 实物 0 虚拟物品

    private String msgContent;//消息体
}

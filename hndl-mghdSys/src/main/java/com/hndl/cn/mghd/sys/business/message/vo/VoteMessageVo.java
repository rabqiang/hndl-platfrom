package com.hndl.cn.mghd.sys.business.message.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/5/16 10:38
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VoteMessageVo implements Serializable {

    private Long createTime;//创建时间

    private String msgContent;//消息体

    private Long starId;//明星id
}

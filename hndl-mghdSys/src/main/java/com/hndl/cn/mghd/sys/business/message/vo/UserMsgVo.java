package com.hndl.cn.mghd.sys.business.message.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
*  @author 尹争鸣
*  @Description TODO
*  @Date  2019年8月16日11:13:47
*  @Created by 湖南达联
*/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserMsgVo implements Serializable {

    private   UserMessageVo  sysMsg;

    private   UserMessageVo  likeMsg;

    private   UserMessageVo  commentMsg;

    private   Long   sysCount;

    private   Long   likeCount;

    private   Long   commentCount;

    private   Long   count;



}

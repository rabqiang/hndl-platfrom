package com.hndl.cn.mghd.admin.business.message.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminMessageVo  implements Serializable {

    private Long messageId;//消息id 生成工具升成

    private Long createTime;

    private Long createUserId;//创建者id,如果是系统消息0表示

    private Integer messageType;//消息类型MessageTypeEnums

    private String title;//标题

    private String content;//内容

    private String sendUserId;//这里是接收id,如果是全局的 用0表示

    private Integer isSms;//是否发送短信 1 YES  0 NO
}

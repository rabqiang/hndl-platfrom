package com.hndl.cn.mghd.sys.business.message.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserMessageVo implements Serializable {

    private String id; //objId，主要返回给前端用户查询分页用户数据

    private Long messageId;//消息id 生成工具升成

    @NotNull
    private Long createUserId;//创建者id,如果是系统消息0表示

    private Long createTime;//创建时间

    @NotNull
    private Integer messageType;//消息类型MessageTypeEnums

    private String title;//标题

    private String content;//内容

    @NotNull
    private Long sendUserId;//这里是接收id,如果是全局的 用0表示

    private Integer state;// 0 消息未读 1 消息已读

    private String expandJson;//这里保存的是拓展的json数据,对应的是需要冗余的数据



}

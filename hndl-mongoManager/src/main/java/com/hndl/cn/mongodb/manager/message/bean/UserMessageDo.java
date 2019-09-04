package com.hndl.cn.mongodb.manager.message.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author 赵俊凯
 * @Description  消息表
 * @Date 2019/5/21 18:03
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business_user_message_info")
@CompoundIndexes(
        @CompoundIndex(name = "sendUserId_messageType_createTime_isDelete", def = "{'sendUserId':-1,'messageType':1,'createTime':-1,'isDelete':1}")
)
public class   UserMessageDo implements Serializable{

    @Id
    private String id;

    @Indexed
    private Long messageId;//消息id 生成工具升成

    @Indexed(direction = IndexDirection.DESCENDING)
    private Long createTime;

    @Indexed
    private Long createUserId;//创建者id,如果是系统消息0表示

    @Indexed
    private Integer messageType;//消息类型MessageTypeEnums

    private String title;//标题

    private String content;//内容

    @Indexed
    private Long sendUserId;//这里是接收id,如果是全局的 用0表示

    private String expandJson;//这里保存的是拓展的json数据,对应的是需要冗余的数据

    @Indexed
    private Integer isDelete;//是否删除
}

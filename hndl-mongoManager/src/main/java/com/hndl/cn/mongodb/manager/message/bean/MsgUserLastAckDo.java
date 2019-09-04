package com.hndl.cn.mongodb.manager.message.bean;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author 尹争鸣
 * @Description TODO
 * @Date 2019年8月14日11:36:09
 * @Created by 湖南达联
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "message_user_last_ack")
@CompoundIndexes(
        {
                @CompoundIndex(name = "sysUniId_messageType", def = "{'sysUniId':-1,'messageType':1}",unique = true)
        })
public class MsgUserLastAckDo implements Serializable {

    @Id
    private String id;

    private Long sysUniId;//用户标识Id

    @Indexed
    private Long haveReadMessageId;//已读消息Id

    private Integer messageType;//消息类型MessageTypeEnums


}

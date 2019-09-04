package com.hndl.cn.mongodb.manager.message.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author 赵俊凯
 * @Description 投票消息
 * @Date 2019/5/14 14:52
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business_vote_message_info")
public class VoteMessageDo implements Serializable {

    @Id
    private String id;

    @Indexed
    private Long starId;

    @Indexed(direction = IndexDirection.DESCENDING)
    private Long createTime;//创建时间

    private String msgContent;//消息体
}

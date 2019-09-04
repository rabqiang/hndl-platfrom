package com.hndl.cn.mongodb.manager.message.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/5/22 10:42
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business_user_message_relation_info")
public class UserMessageRelationDo implements Serializable {

    @Id
    private String id;

    @Indexed
    private String  mesRelationId;// userUniId + "_"+ messageId;

    private Integer messageType;

}

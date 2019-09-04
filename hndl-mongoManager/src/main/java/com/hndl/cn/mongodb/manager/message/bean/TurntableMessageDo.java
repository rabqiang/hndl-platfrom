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
 * @author 尹争鸣
 * @Description  转盘消息表
 * @Date  2019年7月5日17:41:20
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business_turntable_message_info")
public class TurntableMessageDo implements Serializable {

    @Id
    private String id;

    @Indexed(direction = IndexDirection.DESCENDING)
    private Long createTime;//创建时间

    private  Integer isEntity;// 1 实物 0 虚拟物品

    private String msgContent;//消息体
}

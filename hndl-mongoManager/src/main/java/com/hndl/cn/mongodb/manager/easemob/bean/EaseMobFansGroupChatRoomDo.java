package com.hndl.cn.mongodb.manager.easemob.bean;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Classname 赵俊凯
 * @Description 粉丝会和
 * @Date 2019/3/22 13:50
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business_ease_mob_fans_group_chat_room")
public class EaseMobFansGroupChatRoomDo {

    @Id
    private String id;//obj id

    @Indexed(unique = true)
    private Long fansGroupId;//粉丝会id

    private String fansGroupName;//粉丝会名称

    private String chatRoomId;//聊天室id

    private String roomMaster;//聊天室管理员

    private Long createTime;//创建时间

    private Long modifyTime;//修改时间

    private Integer roomCount;//已加入的人数

    private Integer isValid;//是否有效

}

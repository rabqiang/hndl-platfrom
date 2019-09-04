package com.hndl.cn.mongodb.manager.easemob.bean;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/22 19:12
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business_user_is_to_room")
@CompoundIndexes({@CompoundIndex(unique = true,name="mapping_index",def = "{sysUniUserId:1,chatRoomId:1}")})
public class UserIsToRoomInfoDo {

    @Id
    private String id;

    @Indexed
    private Long sysUniUserId;

    private String chatRoomId;

    private Long createTime;//创建时间
}

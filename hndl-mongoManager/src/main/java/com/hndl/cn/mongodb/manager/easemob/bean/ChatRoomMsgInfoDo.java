package com.hndl.cn.mongodb.manager.easemob.bean;

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
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/4/3 10:18
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business_ease_mob_chat_room_msg_info")
@CompoundIndexes({@CompoundIndex(name="fans_day_statistics_index",def = "{createTime:-1,roomId:1")})
public class ChatRoomMsgInfoDo implements Serializable {

    @Id
    private String id;//

    private String nickName;//昵称

    private Long userId;//旧的id

    private Long userUinId;//userId

    @Indexed(direction = IndexDirection.DESCENDING)
    private Long createTime;//创建时间

    @Indexed
    private String roomId;//聊天室id

    private String faceImg;//用户头像

    private String msg;//聊天内容

}

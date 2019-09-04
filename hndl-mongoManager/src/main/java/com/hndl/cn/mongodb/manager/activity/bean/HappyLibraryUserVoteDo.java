package com.hndl.cn.mongodb.manager.activity.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @Classname 赵俊凯
 * @Description 保存快乐图书室投票用户关系
 * @Date 2019/3/29 16:47
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "activity_happy_library_user_vote_mapping")
public class HappyLibraryUserVoteDo implements Serializable {

    @Id
    private String id;

    @Indexed
    private Long sysUniId;//用户id

    private Integer version;//版本

    private Long voteTime;//投票时间,精确到天

    private String starName;//明星名称

    private Long groupId;//战队id绑定用户id

    private String groupName;//战队名称


}

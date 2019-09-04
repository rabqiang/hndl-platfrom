package com.hndl.cn.mongodb.manager.activity.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @Classname 赵俊凯
 * @Description 快乐图书室活动类
 * @Date 2019/3/29 16:20
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "activity_happy_library_share_vote")
public class HappyLibraryShareVoteDo implements Serializable {

    @Id
    private String id;//obj id

    private Integer version;//版本

    private Long startTime;//开始时间

    private Long endTime;//结束时间

    private String starName;//明星名称

    private Long starId;//明星id

    private Long groupId;//战队id

    private String faceImg;//用户头像

    private String groupName;//战队名称

    private Long  voteCount;//统计票数

}

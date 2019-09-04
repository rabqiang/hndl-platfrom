package com.hndl.cn.mongodb.manager.task.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author 赵俊凯
 * @Description 用户每日完成任务 易成贤
 * @Date 2019/4/18 14:48
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business_user_day_task")
@CompoundIndexes({
        @CompoundIndex(name="user_day_task_index",def = "{userUniId:1,taskType:1,createTime:-1,isDelete:1}")
})
public class UserDayTaskDo implements Serializable {

    @Id
    private String id;


    private Long userUniId; //用户唯一标识id


    private Long createTime; //创建时间 精确


    private Integer taskType; //任务类型UserDayTaskEnums


    private Long starId; //用户每天的任务对应的粉丝会id

    private Integer isDelete; //是否被删除，这里对应的是否被领取

}

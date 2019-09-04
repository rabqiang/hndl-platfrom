package com.hndl.cn.mongodb.manager.task.bean;

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
 * @Description 用户常态任务实体类 曹佳丽
 * @Date 2019/4/18 16:03
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business_user_normality_task")
public class UserNormalityTaskDo implements Serializable {

    @Id
    private String id;

    @Indexed
    private Long userUniId;//用户唯一标识id

    @Indexed
    private Long createTime;//创建时间

    @Indexed
    private Integer taskType;//任务类型UserNormalityTaskEnums

    @Indexed
    private String objId;//对象id 对应的是公众号 和 收徒 用户id

    @Indexed
    private Integer isDelete;//是否被删除，这里对应的是否被领取

    private  Long  cumulativeReward ;//师父获取额外积分

}

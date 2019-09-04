package com.hndl.cn.mongodb.manager.task.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author 赵俊凯
 * @Description 达到奖励的师傅
 * @Date 2019/5/7 16:15
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business_master_day_reward")
@CompoundIndexes({@CompoundIndex(unique = true,name="master_day_reward_index",def = "{masterId:1,slaveId:1,createTime:1}")})
public class MasterDayReward {


    @Id
    private String id;

    private Long masterId;//师傅id

    private Long slaveId;//徒弟id

    @Indexed
    private Long createTime;//创建时间 精确到天
}

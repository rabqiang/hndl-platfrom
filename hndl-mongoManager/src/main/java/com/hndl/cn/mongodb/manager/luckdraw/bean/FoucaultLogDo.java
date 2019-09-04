package com.hndl.cn.mongodb.manager.luckdraw.bean;

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
 * @Description 福卡交易记录DO
 * @Date 2019/7/22 16:49
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business_foucault_log")
public class FoucaultLogDo implements Serializable {

    @Id
    private String id;

    @Indexed
    private Long userUniId;

    @Indexed
    private Long createTime;

    @Indexed
    private Integer taskType;//获取/消费途径

    @Indexed
    private Integer isIncome;//是否收入

    private Integer foucaultCount;//福卡数量

    @Indexed
    private Integer isDelete;//是否删除
}

package com.hndl.cn.mongodb.manager.user.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author 赵俊凯
 * @Description 用户积分获取记录,前端定义模板消息 汪海
 * createTime,userUinId,objId联合唯一索引
 * @Date 2019/4/18 14:41
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business_user_integral_log")
public class UserIntegralLogDo implements Serializable {

    @Id
    private String id;

    @Indexed
    private Long userUniId;//用户唯一标识id

    @Indexed
    private Long createTime;//创建时间

    @Indexed
    private Integer getIntegralType;//积分获取途径,对应用积分的任务

    @Indexed
    private String objId; //消费对象的id

    @Indexed
    private Integer isIncome;//收入还是支出

    private Integer IntegralCount;//获取积分数

    @Indexed
    private Integer isDelete;//是否被删除

    private String description;//获取积分描述

}

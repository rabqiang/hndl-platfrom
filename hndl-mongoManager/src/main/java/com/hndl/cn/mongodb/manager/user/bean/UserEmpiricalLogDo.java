package com.hndl.cn.mongodb.manager.user.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author 赵俊凯
 * @Description 用户经验日志 曹佳丽
 * @Date 2019/4/18 19:59
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business_user_empirical_log")
public class UserEmpiricalLogDo implements Serializable {


    @Id
    private String id;

    @Indexed
    private Long userUniId;//用户唯一标识id

    @Indexed(direction = IndexDirection.DESCENDING)
    private Long createTime;//创建时间

    private Integer empiricalType;//是产品经验还是粉丝会经验 EmpiricalTypeEnums

    private Integer empiricalCount;//获取的经验值

    private Integer getChannel;//获取途径 对应加经验的任务

    private Integer isDelete;//是否被删除

}

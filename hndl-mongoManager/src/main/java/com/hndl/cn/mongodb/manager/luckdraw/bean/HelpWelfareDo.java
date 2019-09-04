package com.hndl.cn.mongodb.manager.luckdraw.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * @author 赵俊凯
 * @Description 福利设置
 * @Date 2019/7/24 14:53
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business_help_welfare")
public class HelpWelfareDo implements Serializable {

    @Id
    private String id;

    @Indexed(unique = true)
    private String welfareNumber;//期号

    private String description;//福利描述

    @Indexed
    private Long createTime;//创建时间

    private Long createName;//创建人

    private String prizeName;//奖品名称

    private String prizeImg;//奖品封面图

    private List<String> detailsPrizeImg;//详细奖品图片

    private Integer prizeCount;//奖品库存

    private Integer foucaultCount;//消耗福卡数量

    private Integer sortCount;//前多少名才可以获得奖励

    private Long startTime;//开始时间

    private Long endTime;//结束时间

    private Integer helpCount;//开奖助力阈值

    private Integer nowSumCount;//当前助力值

    private Integer isSuccess;//是否开奖成功

    private Long successTime;//开奖时间

    private List<Long> successUserUniId;//中奖人id

    private Integer isDelete;//是否删除
}

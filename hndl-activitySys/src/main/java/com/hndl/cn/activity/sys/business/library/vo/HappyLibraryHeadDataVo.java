package com.hndl.cn.activity.sys.business.library.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/31 17:59
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HappyLibraryHeadDataVo implements Serializable {

    private String starName;

    private String groupName;

    private Long startTime;//开始时间

    private Long endTime;//结束时间

    private Integer version;//版本

    private Long nowVoteCount;//每天用户投票次数

    private Long starSumCount;//总次数

}

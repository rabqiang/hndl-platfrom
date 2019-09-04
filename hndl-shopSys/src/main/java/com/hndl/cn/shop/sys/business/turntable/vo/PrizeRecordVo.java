package com.hndl.cn.shop.sys.business.turntable.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program:hndl-platform
 * @description:TODO 奖品记录vo
 * @author: 易成贤
 * @create: 2019/7/18 19:09
 * @Created by湖南达联
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("奖品记录vo")
public class PrizeRecordVo {


    String id;
    /**
     * 奖品id
     */
    private Long prizeId;

    /**
     * 奖品时间
     */
    private Long time;
    /**
     * 奖品描述
     */
    private String description;

}

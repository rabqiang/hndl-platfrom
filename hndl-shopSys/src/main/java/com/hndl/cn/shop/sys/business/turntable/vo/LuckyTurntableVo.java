package com.hndl.cn.shop.sys.business.turntable.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program:hndl-platform
 * @description:TODO 幸运转盘vo
 * @author: 易成贤
 * @create: 2019/7/9 20:20
 * @Created by湖南达联
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("转盘vo")
public class LuckyTurntableVo {
    /**
     * 主键id
     * 把20积分作为默认值
     */
    private Long id = 2L;

    /**
     * 奖品名称
     */
    private String prizeName = "再接再励";

    /**
     * 库存值
     */
    private Integer reserveNum = 0;
    /**
     * 积分
     */
    private Long integral = 0L;

    /**
     * 标题
     */
    private String title = "再接";

    /**
     * 副标题
     */
    private String subhead = "再厉";

    /**
     * 版本
     */
    private Integer version = 0 ;

    /**
     * 抽奖次数
     */
    private Integer drawCount =0 ;

    private String hint = "很遗憾，您未中奖";


}

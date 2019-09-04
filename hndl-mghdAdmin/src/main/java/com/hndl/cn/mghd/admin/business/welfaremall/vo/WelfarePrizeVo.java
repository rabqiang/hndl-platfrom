package com.hndl.cn.mghd.admin.business.welfaremall.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;
import java.util.List;

/**
 * @author 资龙茂
 * @Description 福利商城奖品Vo
 * @Date 2019年8月1日 10:59:31
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WelfarePrizeVo implements Serializable {

    @Id
    private String id;

    /** 期号 */
    @Indexed(unique = true)
    private String welfareNumber;

    /** 福利描述 */
    private String description;

    /** 奖品名称 */
    private String prizeName;

    /** 奖品封面图 */
    private String prizeImg;

    /** 详细奖品图片 */
    private List<String> detailsPrizeImg;

    /** 奖品库存 */
    private Integer prizeCount;

    /** 消耗福卡数量 */
    private Integer foucaultCount;

    /** 开始时间 */
    private Long startTime;

    /** 结束时间 */
    private Long endTime;

    /** 开奖助力阈值 */
    private Integer helpCount;

    /** 当前助力值 */
    private Integer nowSumCount;

    /** 当前助力进度 */
    private String workProgress;

    /** 是否开奖成功 */
    private Integer isSuccess;

    /** 开奖时间 */
    private Long successTime;

    /** 中奖人id, 这个字段绝对不能暴露给客户端 */
//    private List<Long> successUserUniId;

    /** 已有多少人抢到福利 */
    private Integer gotWelfarePerson;

    /** 参与人数 */
    private Integer partakePersonCount;
}

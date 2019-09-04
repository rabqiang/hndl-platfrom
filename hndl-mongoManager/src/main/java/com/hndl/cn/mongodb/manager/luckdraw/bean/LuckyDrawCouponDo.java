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
 * @Description TODO
 * @Date 2019/7/2 16:20
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business_lucky_draw_coupon_log")
public class LuckyDrawCouponDo implements Serializable {

    @Id
    private String id;

    @Indexed
    private Long userUniId;

    @Indexed
    private Long createTime;

    @Indexed
    private Long prizeId;//奖品id

    @Indexed
    private Integer welfareType;//这里只的是福利类型
    /**
     * 领取状态
     * 0: 未领取 (实物默认是未领取)
     * 1: 已领取 (虚拟物品默认是已领取)
     * 2: 未开奖 (抢福利可能出现未开奖的情况)
     * 3: 已开奖 (开奖了, 但没中到)
     * 4: 已中奖 (实物, 但未输入地址)
     * 5: 已发货 (实物, 已输入地址, 后台已发货)
     * 经产品判定, 2345已废弃
     */
    private Integer isGet;

    /**
     * 是不是实物
     */
    private Integer isEntity;

    private Integer isDelete;//是否删除


}

package com.hndl.cn.base.dto.pay;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 赵俊凯
 * @Description 支付传输对象
 * @Date 2019/4/19 15:36
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PayNoticeDto implements Serializable {

    private Long payUserId;//支付用户id

    private Long coinCount;//快乐币金额

    private Long localTradeNo;//本地订单id

    private Integer payChannel;//支付渠道

    private String remoteTradeNo;//第三方支付订单

    private Long payTime;//支付时间
}

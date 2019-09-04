package com.hndl.cn.pay.sys.business.apple.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/6/27 20:35
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplePayVo implements Serializable {

    @NotNull(message = "订单id不能为空")
    private Long orderId;

    @NotNull(message = "凭证id不能为空")
    private String payData;
}

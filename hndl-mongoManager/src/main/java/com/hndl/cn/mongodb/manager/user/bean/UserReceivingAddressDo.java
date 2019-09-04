package com.hndl.cn.mongodb.manager.user.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author 赵俊凯
 * @Description 福利收获地址
 * @Date 2019/7/24 15:22
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business_user_receiving_address")
public class UserReceivingAddressDo {

    @Id
    private String id;

    @Indexed
    private Long userUniId;//用户id

    private String welfareNumber;//期号

    private String phoneNumber;//收货人手机号

    private String receivingName;//收货人姓名

    private String receivingAddress;//收货地址

    private Integer isDelivery;  //是否发货(0.已中奖,1.未发货,2.已发货)

    private Integer isDelete;//是否删除

    private Long createTime; // 创建(中奖)时间

    private Long receivingNumber;//发货单号

    private String reason;// 备注
}

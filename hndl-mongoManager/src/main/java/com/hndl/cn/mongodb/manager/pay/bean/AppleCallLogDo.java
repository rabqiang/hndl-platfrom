package com.hndl.cn.mongodb.manager.pay.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @program:hndl-platform
 * @description:TODO 苹果异常回调日志
 * @author: 易成贤
 * @create: 2019/8/5 21:06
 * @Created by湖南达联
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business_apple_call_exception_log")
@CompoundIndexes({
        // 唯一复合索引
        @CompoundIndex(name = "userOrder", def = "{'userUniId' : 1, 'orderId': 1}",unique=true)
})
public class AppleCallLogDo {


    @Id
    String id;

    /**
     * 创建时间
     */
    Long createTime;

    /**
     * 用户uniId
     */
    @Indexed
    Long userUniId;

    /**
     * 本地订单号
     */
    @Indexed
    Long orderId;

    /**
     * 票据信息
     */
    String receiptData;

    /**
     * 是否删除
     */
    Integer isDelete;


}

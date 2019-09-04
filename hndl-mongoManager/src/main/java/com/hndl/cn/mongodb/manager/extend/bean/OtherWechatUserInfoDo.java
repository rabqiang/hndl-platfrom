package com.hndl.cn.mongodb.manager.extend.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/4/28 18:41
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "other_wechat_user_info")
public class OtherWechatUserInfoDo {

    @Id
    private String id;

    @Indexed(unique = true)
    private Long userUniId;

    private String channelName;//渠道名称

    private String ipAddress;//请求的ip地址

    @Indexed(direction = IndexDirection.DESCENDING)
    private Long createTime;//创建时间
}

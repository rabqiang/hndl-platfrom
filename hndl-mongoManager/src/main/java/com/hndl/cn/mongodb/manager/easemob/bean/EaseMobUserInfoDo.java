package com.hndl.cn.mongodb.manager.easemob.bean;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @Classname 赵俊凯
 * @Description  环信id用户映射collection
 * @Date 2019/3/21 10:50
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business_ease_mob_user_info")
public class EaseMobUserInfoDo implements Serializable {


    @Id
    private String id; //mongodb 唯一id

    @Indexed(unique = true)//唯一索引
    private Long sysUniUserId;//系统用户id

    private String easeMobUuid;//环信生成的uuid

    private String easeMobUserType;//用户类型

    private String easeMobUserName;//环信用户名

    private String easeMobPassWord;//环信密码

    private String easeMobNickname;//环信昵称

    private Long createTime;//创建时间

    private Long modifyTime;//修改时间

    private Integer isValid;//是否有效


}

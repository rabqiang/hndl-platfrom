package com.hndl.cn.mongodb.manager.luckdraw.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author 赵俊凯
 * @Description 用户参与助力
 * @Date 2019/7/24 15:11
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business_user_welfare")
@CompoundIndexes({@CompoundIndex(unique = true,name="welfareNumber_user_index",def = "{userUniId:1,welfareNumber:1}")})
public class UserWelfareMappingDo implements Serializable {

    @Id
    private String id;

    @Indexed
    private String welfareNumber;//期号

    @Indexed
    private Long userUniId;//用户id

    private String openId;//微信openId，发消息用

    private String userNickName;//用户昵称 冗余

    private String userImg;//用户图片 冗余

    private String fromId; //小程序提交的fromId 发消息用

    @Indexed
    private Long createTime;//创建时间

    @Indexed
    private Integer helpCount;//助力值

    @Indexed
    private Integer lastHelpCount;//最后助力值

    private Integer isDelete;//是否删除

    @Indexed
    private Long lastModifyTime; //最后修改时间
}

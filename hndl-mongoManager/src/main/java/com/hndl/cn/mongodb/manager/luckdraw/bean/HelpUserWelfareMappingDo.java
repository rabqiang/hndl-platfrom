package com.hndl.cn.mongodb.manager.luckdraw.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/7/24 15:17
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business_help_user_welfare")
public class HelpUserWelfareMappingDo {

    @Id
    private String id;

    @Indexed
    private String welfareNumber;//期号

    @Indexed
    private Long userUniId;//用户id

    private String userNickName;//用户昵称 冗余

    private String userImg;//用户图片 冗余

    @Indexed
    private Long helpUserId;//被助力

    @Indexed
    private Long createTime;//创建时间

    private Integer helpCount;//助力值

    private Integer isDelete;//是否删除
}

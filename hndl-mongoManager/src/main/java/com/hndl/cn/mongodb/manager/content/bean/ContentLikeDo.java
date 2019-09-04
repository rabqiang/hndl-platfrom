package com.hndl.cn.mongodb.manager.content.bean;

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
 * @Date 2019/5/7 10:52
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business_like_mapping")
public class ContentLikeDo {

    @Id
    private String id;

    /**
     *  用户id
     */
    @Indexed
    private Long userUniId;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 点赞对象id
     */
    @Indexed
    private Long targetId;


}

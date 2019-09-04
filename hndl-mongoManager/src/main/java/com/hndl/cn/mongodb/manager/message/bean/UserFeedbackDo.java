package com.hndl.cn.mongodb.manager.message.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author 曹加丽
 * @Description  用户反馈表
 * @Date 2019/5/25 14:28
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business_user_feedback_info")
public class UserFeedbackDo {
    @Id
    private String id;

    @Indexed
    private Long userUniId;//用户唯一标识id

    @Indexed
    private Long createTime;//创建时间

    private String  objId;// 对象id(被举报人id \ 被举报的内容)

    private Integer contentType;//反馈类型FeedbackEnums

    private String contentText;//（反馈/建议）内容

    private String phone;//手机号码

    private String qq;//QQ号

    private List<String> imgList; // 反馈图片集合

    private String isTouch;// 是否处理(ing/ok）

    /**
     * 客服回复
     */
    private String replyContent;// 回复内容

    private Long replyUserId;   //回复人id

}

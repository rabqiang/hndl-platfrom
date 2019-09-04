package com.hndl.cn.mghd.sys.business.comment.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCommentVo implements Serializable {

    private String  repliesId;

    @NotNull(message = "评论对象id不能为空")
    private Long targetId;//评论对象id


    @NotNull(message = "starId不能为空")
    private  Long starId;


    @Length(min = 1,max = 300)
    private String content;//内容

    private Long repliesUserId;//回复人id

    private String repliesNickName;//回复人昵称




}

package com.hndl.cn.mghd.sys.business.call.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
*  @author 尹争鸣
*  @Description  日常-话题评论
*  @Date  2019年8月1日10:27:08
*  @Created by 湖南达联
*/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopicCommentVo implements Serializable {

    private String id;

    @ApiModelProperty(value = " 创建人ID")
    private Long userUniId;

    @ApiModelProperty(value = " 话题id")
    @NotNull
    private String topicId;

    @ApiModelProperty(value = " 用户昵称")
    private String userNickName;

    @ApiModelProperty(value = "用户头像")
    private String userImg;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    @ApiModelProperty(value = "内容")
    @Length(min = 1,max = 1000 )
    private String content;

    @ApiModelProperty(value = "内容图片")
    @Valid
    @Size(max = 9,message = "图片个数超过最大值")
    private List<String> contentImgList;

    @ApiModelProperty(value = "话题标题")
    private String topicTitle;
}

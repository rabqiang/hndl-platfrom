package com.hndl.cn.mghd.admin.business.feedback.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/6/19 16:05
 * @Created by 湖南达联
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "用户反馈数据的vo")
public class FeedbackVo implements Serializable {
    private String id;
    @ApiModelProperty(value = "用户id")
    private Long userId;              //用户id
    @ApiModelProperty(value = "反馈时间")
    private String createTime;        //反馈时间
    @ApiModelProperty(value = "反馈内容")
    private String userContent;           //反馈内容
    private String objId;                    //举报对象
    @ApiModelProperty(value = "反馈图片")
    private List<String> pictureSet;         //反馈图片
    @ApiModelProperty(value = "手机号码")
    private String cellPhoneNumber;   //手机
    @ApiModelProperty(value = "qq号码")
    private String qqNumber;          //qq
    @ApiModelProperty(value = "反馈类型(举报/建议)")
    private String feedbackType;      //反馈类型(举报/建议)
    @ApiModelProperty(value = "客服回复内容")
    private String reportContent;    //客服回复
    @ApiModelProperty(value = "是否处理 (1.已处理/ 0.待处理)")
    private String isHandle;          //是否处理 (已处理/ 待处理)
}

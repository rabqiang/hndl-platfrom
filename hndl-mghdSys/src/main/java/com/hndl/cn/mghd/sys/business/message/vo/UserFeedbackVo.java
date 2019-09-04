package com.hndl.cn.mghd.sys.business.message.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author 曹加丽
 * @Description  用户反馈vo类
 * @Date 2019/5/25 17:45
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "用户反馈")
public class UserFeedbackVo implements Serializable {


    @ApiModelProperty(value = "用户反馈(建议)内容",required = true)
    @NotNull(message = "内容不为空")
    private String contentText;//用户反馈(建议)内容

    @ApiModelProperty(value = "图片说明,最多三张")
    private List<String>  img_list;//图片说明,最多三张

    @ApiModelProperty(value = "在用户填写建议时,必填QQ号")
    private String qq;//QQ号

    @ApiModelProperty(value = "在填写建议时,手机号码可以选择性填写" )
    private String phone;//手机号码,可以选择性填写

}

package com.hndl.cn.mghd.sys.business.call.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * @program: hndl-platform
 * @description: 接收打call 数据
 * @author: 易成贤
 * @create: 2019-05-10 12:01
 * @Created by 湖南达联
 **/

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "用户打call数据",description = "用户打call需要传的相关数据")
public class ReceiveCallContentVo implements Serializable {

    @ApiModelProperty(value = "粉丝会id")
    @NotNull(message = "粉丝会id不为空")
    private Long starId;

    @ApiModelProperty(value = "打call的内容")
    @NotNull(message = "内容不为空!" )
    @Length(min = 1,max = 1000 ,message = "打call内容字数限制位1-1000")
    private String content;

    @ApiModelProperty(value = "图片列表(小 )")
    @Valid
    @Size(max = 9,message = "图片个数超过最大值")
    private List<String> contentImgList;

}

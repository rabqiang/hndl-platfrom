package com.hndl.cn.mghd.admin.business.resources.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/5/7 14:33
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Base64Vo")
public class Base64Vo implements Serializable {

    @NotNull(message = "资源不能为空!")
    @Length(message = "图片大小有误!")
    @ApiModelProperty("base64的图片字符串")
    private String baseImg;
}

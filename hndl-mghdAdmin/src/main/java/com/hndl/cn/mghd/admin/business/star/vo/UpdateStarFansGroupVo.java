package com.hndl.cn.mghd.admin.business.star.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @program:hndl-platform
 * @description:TODO 更新粉丝会的vo
 * @author: 易成贤
 * @create: 2019/7/23 10:58
 * @Created by湖南达联
 **/
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "更新粉丝会数据的vo")
public class UpdateStarFansGroupVo {

    @NotNull
    private Long starId;

    @ApiModelProperty("明星名字")
    @NotBlank
    private String starName;

    @ApiModelProperty("明星头像url")
    @NotBlank
    private String starImg;


    @ApiModelProperty("明星描述")
    @NotBlank
    private String starDescription;
    @ApiModelProperty("明星类型")
    @NotNull
    private String starType;
    @ApiModelProperty("明星性别F/M")
    @Pattern(regexp = "(F|M)")
    @NotNull
    private String sex;
    @ApiModelProperty("粉丝名称")
    @NotBlank
    private String fansName;

    @ApiModelProperty("微博id")
    @NotNull
    @Length(min = 4,message = "微博的id不合法")
    private String weiboId;

    public static void main(String[] args) {
        String a = "(F|M)";

        System.out.println(a.matches("F"));
    }
}

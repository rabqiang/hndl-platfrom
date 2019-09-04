package com.hndl.cn.mghd.admin.business.star.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @program:hndl-platform
 * @description: 粉丝会接收类
 * @author: 易成贤
 * @create: 2019-06-19 17:03
 * @Created by湖南达联
 **/
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "接收粉丝会数据的vo")
public class ReceiveStarFansGroupVo implements Serializable {

    private Long starId;

    @ApiModelProperty("明星名字")
    @NotBlank
    private String starName;

    @ApiModelProperty("明星头像url")
    @NotBlank(message = "明星头像地址不合法")
    private String starImg;

    @ApiModelProperty("总投票数")
    @NotNull
    @Min(value = 0,message = "总投票数不小于0")
    private Long voteCount;

    @ApiModelProperty("投票总用户数")
    @NotNull
    @Min(value = 0,message = "总投票人数不小于0")
    private Integer voteUserCount;

    @ApiModelProperty("明星描述")
    @NotBlank
    private String starDescription;

    @ApiModelProperty("明星类型")
    @NotNull
    private String starType;

    @ApiModelProperty("明星性别F/M")
    @Pattern(regexp = "(F|M)")
    private String sex;

    @ApiModelProperty("粉丝名称")
    @NotBlank
    private String fansName;

    @ApiModelProperty("微博id")
    @NotNull
    @Length(min = 4,message = "微博的id不合法")
    private String weiboId;



    public static void main(String[] args) {
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("http:\\/\\/mghd.oss-cn-hangzhou.aliyuncs.com\\/((formal\\/star\\/\\d{1,4})|(temp))\\/min_img\\/\\d{4}-\\d{2}-\\d{2}\\/\\d{18}.(png|jpg|gif)");
        String pattern1 = pattern.pattern();
        System.out.println(pattern1);
        boolean matches = pattern1.matches("http://mghd.oss-cn-hangzhou.aliyuncs.com/formal/star/815/min_img/2019-07-10/267126704542257152.png");
        System.out.println(matches);
    }
}

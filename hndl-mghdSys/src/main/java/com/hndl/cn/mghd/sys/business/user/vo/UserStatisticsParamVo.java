package com.hndl.cn.mghd.sys.business.user.vo;

import io.swagger.annotations.ApiModel;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/4/23 17:16
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "")
public class UserStatisticsParamVo implements Serializable {


    @NotNull(message = "用户id不能为空")

    private Long Id;

    @NotNull(message = "用户快乐号不能为空")
    private Long userUniId;


    @NotBlank(message = "用户头像不能为空")
    private String faceImg;//用户头像

    @NotBlank(message = "用户昵称不能为空")
    @Length(min = 1, max = 15)
    private String nickName;//昵称

    private String phoneNumPerson;//手机号

    private String personalAutograph;//个性签名

    private Integer followCount;//关注

    private Integer FansCount;//粉丝关注

    private Long empiricalCount;//经验值

    private Integer grade; //等级

    private Double gradePercentage;//用户升级下个等级百分比

    private Long requirementEmpirical;//下次升级需要多少经验值

    private Long integralCount;//用户积分

    private Long coniCount;//用户快乐币

    private Long gettingLoveCount;//爱心值

    private String requestCode;//邀请码

    private String homepageImg;//背景图片

}


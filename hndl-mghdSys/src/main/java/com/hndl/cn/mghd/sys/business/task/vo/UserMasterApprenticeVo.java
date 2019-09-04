package com.hndl.cn.mghd.sys.business.task.vo;

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
 * @Date 2019/5/24 14:27
 * @Created by 湖南达联
 */
@ApiModel(value = "师徒系统信息")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserMasterApprenticeVo implements Serializable {
    @ApiModelProperty(value = "用户昵称")
    private String nickName;//昵称
    @ApiModelProperty(value = "用户头像")
    private String ImgUrl;//用户头像
    @ApiModelProperty(value = "用户等级")
    private Integer level; //等级
    @ApiModelProperty(value = "邀请码是可变的,但是旧邀请码也可用")
    private String requstCode; //邀请码
    @ApiModelProperty(value = "徒弟数")
    private Integer  apprenticeCount;//徒弟数
    @ApiModelProperty(value = "累计获取的额外积分")
    private Long   integralSum;//累计积分
    @ApiModelProperty(value = "用户的师父id")
    private  Long masterId;//用户师父id
    @ApiModelProperty(value = "用户的师父头像")
    private  String masterImgUrl;//用户师父头像
    @ApiModelProperty(value = "用户师父昵称")
    private String  masterNickName;//用户师父昵称
    @ApiModelProperty(value = "徒弟列表")
    private List<SlaveUserVo> userInfoDoList;//徒弟列表

}

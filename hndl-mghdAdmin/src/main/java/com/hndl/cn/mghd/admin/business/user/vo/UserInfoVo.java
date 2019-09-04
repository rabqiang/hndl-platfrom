package com.hndl.cn.mghd.admin.business.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/6/19 15:52
 * @Created by 湖南达联
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "用户基本数据的vo")
public class UserInfoVo implements Serializable {
    /**
     * 快乐号
     */
    @ApiModelProperty(value = "快乐号")
    private Long id;

    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "用户昵称")
    private String userName;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Long createTime;
    /**
     * 运营商
     */
    @ApiModelProperty(value = "运营商(中国联通,中国移动,中国电信,其他(没有绑定手机号))")
    private String netType;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String cellPhoneNumber;
    /**
     * //手机类型
     */
    @ApiModelProperty(value = "手机类型(类似 iOS,Android,其他)")
    private String appType;
    /**
     * // 手机型号
     */
    @ApiModelProperty(value = "手机型号(类似于 iPhone,HUAWEI,SM)")
    private String phoneName;
    /**
     * // 最后登陆时间
     */
    @ApiModelProperty(value = "最后登陆时间(来自于用户最近一次登陆时间)")
    private Long lastTime;

}

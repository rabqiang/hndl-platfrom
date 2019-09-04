package com.hndl.cn.mghd.sys.business.sign.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/4/23 16:05
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WechatLoginParamVo implements Serializable {

    @NotBlank(message = "参数错误")
    private String appType;//手机类型 ios/android

    @NotBlank(message = "参数错误")
    private String deviceNumber;//手机设备号

    @NotBlank(message = "参数错误")
    private String loginType;//登陆方式

    @NotBlank(message = "参数错误")
    private String nickName;//昵称

    @NotBlank(message = "参数错误")
    private String phoneName;//手机型号

    @NotBlank(message = "参数错误")
    private String userImgUrl;//用户头像

    @NotBlank(message = "参数错误")
    private String weixinOpenId;//微信OpenId

    @NotBlank(message = "参数错误")
    private String weixinUniId;//微信UniId

    @NotBlank(message = "参数错误")
    private String umengChannel;//用户的渠道标识 如果没有，默认为klfsh



}

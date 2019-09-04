package com.hndl.cn.mghd.sys.business.sign.vo;

import com.hndl.cn.utils.aes.AESUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author 赵俊凯
 * @Description qq登陆入参
 * @Date 2019/4/23 19:17
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QQLoginParamVo implements Serializable {

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
    private String qqOpenId;//qqOpenId

    @NotBlank(message = "参数错误")
    private String weixinUniId;//weixinUniId

    @NotBlank(message = "参数错误")
    private String umengChannel;//用户的渠道标识 如果没有，默认为klfsh

    public static void main(String[] args) {
//        QQLoginParamVo qqLoginParamVo = new QQLoginParamVo();
//        qqLoginParamVo.setAppType("android");
//        qqLoginParamVo.setDeviceNumber("862427049445853");
//        qqLoginParamVo.setLoginType("qq");
//        qqLoginParamVo.setNickName("Max.葭措");
//        qqLoginParamVo.setPhoneName("MI 9 SE");
//        qqLoginParamVo.setUserImgUrl("http://thirdqq.qlogo.cn/g?b=oidb&k=XIaEJxmg9k8tQMaQKxmOwQ&s=100");
//        qqLoginParamVo.setQqOpenId("8F963BDDD31C283DD3769EF32A8D2496");
//        qqLoginParamVo.setWeixinUniId("8F963BDDD31C283DD3769EF32A8D2496");
//        qqLoginParamVo.setUmengChannel("baidu");
//        System.out.println(JSONObject.toJSONString(qqLoginParamVo));
//        String aesStr = AESUtil.encrypt(JSONObject.toJSONString(qqLoginParamVo),"192.168.1.");
//        System.out.println("encrypt:"+aesStr);
        String str2 = "oilnZWlUGgZDSLUnk3GCK0fHpAG5b/GhWoxJTbA+in1RBYOCJ9QHfSICqL6gvntswHnP2CE3dCZINlXLeSoDhjDzSXb3TuimylBpgXMsUDv1I48Mn4qQ16Q6c7ZvSLHO1gkzEhG99zDAlhnZE+qs4n8hKE18kGTjSk0FuvTAIp8T4eQBjeagpx3Xc6TzLFQiEUnnHeY4CKUmgWzZjZwPFe5xxuoc+dRFFECXN0aqGlitsGIjb4TfoK0EbsPPwdROTMHNcqJDkaOUjlpUFv7FjwO3p1S+7bdTmysKo7Z+Hy7Dal/ARp75zoQO4Xtv1xwR/orrqnZHkGHP8fO0/xk0eooLqJB49zMKn0AIrMrXzWYBFkgXEkaUt31RWtXER765IXsaUMxK4kTS+AmFtMxzDnfuS4qByWBGxgUYX3hi+tM=";
        System.out.println("decrypt:"+AESUtil.decrypt(str2,"8624270494458530"));
//        String str1 = "9mZJs4zh2a0XPqimeekfDaNye7AP4R90OnK/hmzf8FTnG8jthI6qEMhiOv/yC2MoseXxvpBKSsiyYXB6kvlOgOs6sspNbZGAlY/y4hpBDZEpIYDblX2Te/FH2mp+DV31Tf8xANVyRO/Wt5nr0me5hhBY+wvfDxA8MmPg+mqCFVKQpbfimx2k/PcCjLrVpS04kMYpfNbMzjkpfozoXrbWeRUxo7ol0Jq+KQzoNKlcZG+eZaNqj4MTQbCU2WsDmgt06MNU44w3AcfCCqE4VMy2OkjcaINSXvnh+dfx9P0YNKhZhWoHSTQCPbYmbgrY39K1LctKRuYB0h4jv0ct8aFjtmA28txIf18apvTPH5uKQ0pl43BJFHnpFd8oyTzASM7UkCkmlAwrapx/GSdKzfabYMaMeseC704HpnumQ7H3+JY=";
    }
}

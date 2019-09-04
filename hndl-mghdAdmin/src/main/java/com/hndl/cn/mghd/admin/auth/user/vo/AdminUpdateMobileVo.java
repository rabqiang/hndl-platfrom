package com.hndl.cn.mghd.admin.auth.user.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/6/20 16:48
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminUpdateMobileVo implements Serializable {

    /**
     * 用户昵称
     */
    @NotBlank(message = "手机号不能为空")
    @Size(min = 10,max = 15,message = "手机号长度不合法")
    private String mobile;
}

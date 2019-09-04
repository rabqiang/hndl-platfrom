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
public class AdminUpdateNickNameVo implements Serializable {

    /**
     * 用户昵称
     */
    @NotBlank(message = "用户昵称不能为空")
    @Size(min = 2,max = 20,message = "用户昵称长度不和法")
    private String nickName;
}

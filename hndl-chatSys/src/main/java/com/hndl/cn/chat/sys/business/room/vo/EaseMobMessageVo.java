package com.hndl.cn.chat.sys.business.room.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/22 21:57
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EaseMobMessageVo {

    @NotBlank(message = "消息不能为空")
    @Size(min = 1,max = 30,message = "消息长度不合法")
    private String msg;

    @NotBlank(message = "聊天室不能为空")
    @Size(min = 5,max = 30,message = "聊天室id不合法")
    private String roomId;


}

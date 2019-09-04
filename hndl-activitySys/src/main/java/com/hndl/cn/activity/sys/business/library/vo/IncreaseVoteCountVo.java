package com.hndl.cn.activity.sys.business.library.vo;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/31 18:38
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncreaseVoteCountVo implements Serializable {

    @NotNull(message = "活动期数不能为空")
    private Integer version;//版本号

    @NotNull(message = "战队id不能为空")
    private Long groupId;//战队id== 用户id
}

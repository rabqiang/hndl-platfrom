package com.hndl.cn.activity.sys.business.library.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/31 18:43
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncreaseVoteCountByKeyVo implements Serializable {

    @NotNull(message = "活动期数不能为空")
    private Integer version;//版本号

    @NotNull(message = "战队id不能为空")
    private Long groupId;//战队id对应用户id

    @NotBlank(message = "非法请求")
    @Size(min = 10,max = 20,message = "非法请求")
    private String key;

    @NotNull(message = "非法请求")
    private Long voteCount;

}

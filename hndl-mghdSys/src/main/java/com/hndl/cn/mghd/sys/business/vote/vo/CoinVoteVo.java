package com.hndl.cn.mghd.sys.business.vote.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/5/9 11:43
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "快乐币打榜入参vo")
public class CoinVoteVo {

    @NotNull(message = "明星id不能为空")
    @ApiModelProperty(value = "明星id",required = true)
    private Long starId;

    @NotNull(message = "快乐币不能为空")
    @Range(min = 100,max = 999900,message = "快乐币数不合法")
    @ApiModelProperty(value = "快乐币",required = true)
    private Long coinNum;
}

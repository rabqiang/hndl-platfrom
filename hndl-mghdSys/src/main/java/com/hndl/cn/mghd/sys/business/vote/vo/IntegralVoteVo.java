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
 * @Description 积分打榜入参vo
 * @Date 2019/5/9 11:19
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "积分打榜入参vo")
public class IntegralVoteVo {


    @NotNull(message = "明星id不能为空")
    @ApiModelProperty(value = "明星id",required = true)
    private Long starId;

  @NotNull(message = "积分不能为空")
  @Range(min = 10, max = 9999, message = "每次积分打榜：1-9999哦~")
  @ApiModelProperty(value = "打榜积分数", required = true)
  private Long integralNum;
}

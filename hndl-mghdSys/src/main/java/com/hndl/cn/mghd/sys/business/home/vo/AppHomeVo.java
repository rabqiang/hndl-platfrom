package com.hndl.cn.mghd.sys.business.home.vo;

import com.hndl.cn.base.vo.StarDayRankVo;
import com.hndl.cn.mghd.sys.business.banner.vo.BannerVo;
import com.hndl.cn.mghd.sys.business.call.vo.StarCallContentVo;
import com.hndl.cn.mghd.sys.business.menu.vo.AppHomeMenuVo;
import com.hndl.cn.mghd.sys.business.message.vo.VoteMessageVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/5/16 10:34
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "初始化首页数据", description = "初始化首页数据")
public class AppHomeVo {

    @ApiModelProperty(value = "菜单栏")
    private List<AppHomeMenuVo> menuVoList;//菜单栏

    @ApiModelProperty(value = "Banner")
    private List<BannerVo> bannerVoList;//Banner 部分

    @ApiModelProperty(value = "弹幕消息")
    private List<VoteMessageVo> messageVoList;//消息部分

    @ApiModelProperty(value = "排行榜")
    private List<StarDayRankVo> starDayRankVoList;//排行榜部分

    @ApiModelProperty(value = "首页内容部分")
    private List<StarCallContentVo> homeContentVoList;//内容部分
}

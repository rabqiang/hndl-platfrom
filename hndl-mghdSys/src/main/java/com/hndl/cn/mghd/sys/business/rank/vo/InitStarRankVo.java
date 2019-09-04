package com.hndl.cn.mghd.sys.business.rank.vo;

import com.hndl.cn.base.vo.StarDayRankVo;
import com.hndl.cn.mghd.sys.business.banner.vo.BannerVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 赵俊凯
 * @Description 首次打开粉丝榜数据Vo
 * @Date 2019/4/29 17:28
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InitStarRankVo {

    private List<BannerVo> bannerVoList;//banner 图

    private List<StarDayRankVo> starDayRankVoList;//排行榜图

    private List<MyStarVo>  myStarVoList;//我关注的明星
}

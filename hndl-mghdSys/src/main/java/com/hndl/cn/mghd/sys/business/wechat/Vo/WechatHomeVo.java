package com.hndl.cn.mghd.sys.business.wechat.Vo;

import com.hndl.cn.mghd.sys.business.banner.vo.BannerVo;
import com.hndl.cn.mongodb.manager.star.bean.StarDayRankDo;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author 曹加丽
 * @Description 打开小程序首页的信息
 * @Date 2019/5/23 10:06
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "打开小程序首页的vo")
public class WechatHomeVo implements Serializable {


    private List<BannerVo> bannerVoList;// banner图

    private List<StarDayRankDo> starDayRankVoList;//明星日榜排行榜
}

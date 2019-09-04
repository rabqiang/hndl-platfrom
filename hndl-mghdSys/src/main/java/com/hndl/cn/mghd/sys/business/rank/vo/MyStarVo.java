package com.hndl.cn.mghd.sys.business.rank.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 赵俊凯
 * @Description 我关注的明星
 * @Date 2019/5/14 14:38
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyStarVo {

    private Long starId;//明星id

    private String starImg;//明星头像

    private String starName;//明星name

    private Long starVote;//明星总票数

    private Long myContribute;//我的贡献

    private Integer voteDayCount;//累计打榜天数
}

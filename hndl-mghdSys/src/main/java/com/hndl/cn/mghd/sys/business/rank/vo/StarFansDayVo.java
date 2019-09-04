package com.hndl.cn.mghd.sys.business.rank.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/5/21 21:53
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StarFansDayVo<T,V> implements Serializable {


    private List<T> fansRankList;//list 数据

    private V myMaxContribute;//我的贡献
}

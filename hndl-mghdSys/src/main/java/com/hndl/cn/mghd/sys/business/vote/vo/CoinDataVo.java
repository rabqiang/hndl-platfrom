package com.hndl.cn.mghd.sys.business.vote.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/8/22 20:09
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoinDataVo implements Serializable {

    private Long nowCoinCount;//当前剩余快乐币

    private Long voteCount;//增加票数
}

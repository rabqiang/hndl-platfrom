package com.hndl.cn.mghd.job.business.welfaremall.service;

import javax.validation.constraints.NotNull;

/**
 * @Classname
 * @Created by 湖南达联
 * @Date 2019/8/13 21 10
 * @Description:
 * @Author: 资龙茂
 */
public interface MessageService {

    /**
     * 开奖时推送消息
     * @param welfareNumber
     */
    void welfarePrizeLottery(@NotNull String welfareNumber);

}

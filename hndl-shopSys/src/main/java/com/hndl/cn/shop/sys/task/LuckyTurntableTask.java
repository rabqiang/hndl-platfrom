package com.hndl.cn.shop.sys.task;

import com.hndl.cn.shop.sys.config.LuckyTurntableConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * @program:hndl-platform
 * @description:TODO 幸运转盘Task
 * @author: 易成贤
 * @create: 2019/7/25 15:04
 * @Created by湖南达联
 **/
@Slf4j
public class LuckyTurntableTask {

    @Resource
    LuckyTurntableConfig luckyTurntableConfig;

    /**
     * 定时刷新奖品
     */
    @Scheduled(cron = "0 0/30 * * * ?")
    //@Scheduled(cron = "0 0/1 * * * ?") 测试使用
    private void fushPrize(){
        log.info("开始刷新转盘奖品，当前时间为："+ LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));

        luckyTurntableConfig.savePrizeList();

        log.info("刷新转盘奖品结束，当前时间为："+ LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
    }

}

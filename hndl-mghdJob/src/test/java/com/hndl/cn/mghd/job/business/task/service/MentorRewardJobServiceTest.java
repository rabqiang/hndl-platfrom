package com.hndl.cn.mghd.job.business.task.service;
import com.hndl.cn.mghd.job.business.welfaremall.service.WelfareMallJobService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/6/4 17:58
 * @Created by 湖南达联
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MentorRewardJobServiceTest {

    @Resource
    WelfareMallJobService welfareMallJobService;

    @Test
    public void testSlave(){
        welfareMallJobService.findHelpUserUpdateSuccess();
    }



}
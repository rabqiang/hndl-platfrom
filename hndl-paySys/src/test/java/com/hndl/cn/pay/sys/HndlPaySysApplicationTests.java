package com.hndl.cn.pay.sys;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.pay.sys.business.wechat.service.WechatPayService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HndlPaySysApplicationTests {

    @Resource
    private WechatPayService wechatPayService;

    @Test
    public void wechatTest() {

         Result<Object> result = wechatPayService.preOrderByWechatPay(1234567123123890L, 1000L);
         System.out.println(result);
    }

}

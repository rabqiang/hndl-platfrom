package com.hndl.cn.shop.sys;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mongodb.manager.luckdraw.manager.LuckyDrawCouponManager;
import com.hndl.cn.shop.sys.business.turntable.service.LuckyTurntableService;
import com.hndl.cn.shop.sys.business.turntable.vo.LuckyTurntableVo;
import com.hndl.cn.shop.sys.config.LuckyTurntableConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopSysApplicationTests {

    @Resource
    LuckyTurntableService luckyTurntableService;

    @Resource
    LuckyDrawCouponManager luckyDrawCouponManager;
    
    @Resource
    LuckyTurntableConfig luckyTurntableConfig;

    @Test
    public void contextLoads() {
        for (int x = 0; x < 1 ; x++) {
            System.out.println("第多少次"+x);
            int count1 = 0;
            int count2 = 0;
            int count3 = 0;
            int count4 = 0;
            int count5 = 0;
            int count6 = 0;
            int count7 = 0;
            int count8 = 0;

        for (int i = 0; i <50000 ; i++) {
            CommonUserInfoDo commonUserInfoDo = new CommonUserInfoDo();
            commonUserInfoDo.setSysUniId(229666660162916352L);
            commonUserInfoDo.setNickName("昵称");
             Result<LuckyTurntableVo> luckyTurntableVoResult = luckyTurntableService.prizeDraw(commonUserInfoDo, 1);
            Long luckAllDraw = luckyTurntableVoResult.getData().getId();
            //Long luckAllDraw = luckyTurntableConfig.luckAllDraw(1);
            if (luckAllDraw.equals(1L)) {
                count1++;
            }

            if (luckAllDraw.equals(2L)) {
                count2++;
            }
            if (luckAllDraw.equals(3L)) {
                count3++;
            }
            if (luckAllDraw.equals(4L)) {
                count4++;
            } if (luckAllDraw.equals(5L)) {
                count5++;
            } if (luckAllDraw.equals(6L)) {
                count6++;
            }
            if (luckAllDraw.equals(7L)) {
                count7++;
            }
            if (luckAllDraw.equals(8L)) {
                count8++;
            }

        }
        System.out.println("奖品10积分次数======"+count1);
        System.out.println("奖品再接再厉次数======"+count2);
        System.out.println("奖品20积分次数======"+count3);
        System.out.println("奖品50积分次数======"+count4);
        System.out.println("奖品800积分次数======"+count5);
        System.out.println("奖品明星专辑次数======"+count6);
        System.out.println("奖品签名照次数======"+count7);
        System.out.println("奖品快本次数======"+count8);
        }

    }


    @Test
    public void test(){
   /*     //
        for (int i = 0; i <1000 ; i++) {
            luckyDrawCouponManager.insertLuckyDrawCouponByUserUinId(229666660162916352L, FoucaultGetTypeEnums.WATCH_VIDEO);
        }
        System.out.println("完成！");*/
       // System.out.println(luckyDrawCouponManager.countCanDraw(229666660162916352L));

    }



}

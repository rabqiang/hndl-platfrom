//package com.hndl.cn.shop.admin.business.turntable.controller;
//
//import com.hndl.cn.base.enums.IsValidEnums;
//import com.hndl.cn.base.enums.user.FoucaultGetTypeEnums;
//import com.hndl.cn.mongodb.manager.luckdraw.bean.HelpWelfareDo;
//import com.hndl.cn.mongodb.manager.luckdraw.bean.UserWelfareMappingDo;
//import com.hndl.cn.mongodb.manager.luckdraw.manager.FoucaultLogManager;
//import com.hndl.cn.mongodb.manager.luckdraw.manager.HelpWelfareManager;
//import com.hndl.cn.mongodb.manager.luckdraw.manager.UserWelfareMappingManager;
//import com.hndl.cn.mongodb.manager.user.manager.UserStatisticsDoManager;
//import com.hndl.cn.shop.admin.business.resources.service.ResourcesService;
//import com.hndl.cn.utils.date.LocalDateTimeUtil;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.TreeMap;
//
///**
// * @author 曹加丽
// * @Description TODO
// * @Date 2019/7/15 12:03
// * @Created by 湖南达联
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class LuckyTurntableControllerTest {
//
//    @Resource
//    HelpWelfareManager helpWelfareManager;
//
//    @Resource
//    UserWelfareMappingManager userWelfareMappingManager;
//    @Resource
//    ResourcesService resourcesService;
//
//    @Resource
//    FoucaultLogManager foucaultLogManager;
//    @Resource
//    UserStatisticsDoManager userStatisticsDoManager;
//
//
//    /**
//     * 开奖
//     * 1.查询现在未开奖商品
//     * 2.获取满足开奖条件商品
//     * 3 查询参与活动人数(人数根据设置前几名中奖获得)
//     * 4.查询指定人id是否在人数中,有就去除,将奖品数减一,指定人id添加在中奖人id中
//     * 5..如果还剩余中奖次数就继续抽奖,直到抽完为止
//     * 6.将商品开奖保存中奖人id信息,后\形成中奖记录和收货信息
//     */
//    @Test
//    public void assignRest() {
////        1.查询现在未开奖商品
//        List<HelpWelfareDo> helpUserById = helpWelfareManager.findSuccessAll(System.currentTimeMillis());
//        for (HelpWelfareDo helpWelfareDo : helpUserById) {
//            System.out.println("可开奖商品:" + helpWelfareDo);
//            List<UserWelfareMappingDo> userWelfareByWelfareNumber = userWelfareMappingManager.findUserWelfare(helpWelfareDo.getWelfareNumber(), helpWelfareDo.getSuccessUserUniId(), helpWelfareDo.getSortCount());
//            //如果有指定人id就要奖励次数减去指定人数
//            helpWelfareDo.setPrizeCount(helpWelfareDo.getPrizeCount() - helpWelfareDo.getSuccessUserUniId().size());
//            System.out.println(" 奖品数: " + helpWelfareDo.getPrizeCount() + "___ 可抽奖人数:" + userWelfareByWelfareNumber.size());
//            //4. 如果还剩余中奖次数就继续抽奖,直到抽完为止
//            for (int j = 0; j < helpWelfareDo.getPrizeCount(); j++) {
//                int len = userWelfareByWelfareNumber.size(); //获取当前助力人数
//                //以权重区间段的后面的值作为key存当前信息
//                TreeMap<Integer, UserWelfareMappingDo> map = new TreeMap<>();
//                int total = 0; //总权重
//                map.clear();
//                for (int i = 0; i < len; i++) {
//                    UserWelfareMappingDo array = userWelfareByWelfareNumber.get(i); //获取用户
//                    total += array.getHelpCount();
//                    map.put(total, array);
//                }
//                //系统随机选取大于等于 0.0 且小于 1.0 的伪随机 double 值
//                int random = (int) (Math.random() * total);
//                Integer key = map.ceilingKey(random);
//                helpWelfareDo.getSuccessUserUniId().add(map.get(key).getUserUniId()); //获取中奖用户信息
//                userWelfareByWelfareNumber.remove(map.get(key)); //移除抽中用户信息
//            }
//
//            //5.将商品开奖保存中奖人id信息,形成中奖记录和收货信息
////           helpWelfareManager.updateHelpUserLottery(helpWelfareDo.getWelfareNumber(), helpWelfareDo.getNowSumCount(), helpWelfareDo.getSuccessUserUniId());
//
//        }
//    }
//
//    /**
//     * 开奖失败,退还福卡数
//     */
//    @Test
//    public void returnFouca() {
//        List<HelpWelfareDo> helpUserById = helpWelfareManager.findHelpUserById(null, null, 0, null);
//        for (HelpWelfareDo helpWelfareDo : helpUserById) {
////            判断当前时间大于商品结束时间,就进行修改商品的开奖状态
//            if (helpWelfareDo.getEndTime() < System.currentTimeMillis()) {
//                //给未达到开奖条件的奖品,状态修改为失效
//                if (helpWelfareManager.updateHelpUserInvalid(helpWelfareDo.getWelfareNumber(), helpWelfareDo.getNowSumCount())) {
//                    //查询参与此次活动用户信息
//                    List<UserWelfareMappingDo> userWelfareByWelfareNumber = userWelfareMappingManager.findUserWelfare(helpWelfareDo.getWelfareNumber(),  null, null);
//                    for (UserWelfareMappingDo mappingDo : userWelfareByWelfareNumber) {
//                        //将退还的福卡数添加到用户统计表中
//                        userStatisticsDoManager.userAddFoucaultCount(mappingDo.getUserUniId(), helpWelfareDo.getFoucaultCount());
//                        //将退还的福卡生成退还记录
//                        foucaultLogManager.insertFoucaultLog(mappingDo.getUserUniId(), FoucaultGetTypeEnums.DAYLIGHT_ROBBERY, IsValidEnums.NO, helpWelfareDo.getFoucaultCount());
//                    }
//                }
//            }
//        }
//
//    }
//
//    @Test
//    public void getCommodity() {
//        HelpWelfareDo helpWelfareDo = new HelpWelfareDo();
//        //设置奖品期号
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");//获取当前的年月日
//        // 1.获取当日增加了多少商品再加1
//        String format = String.format("%02d", helpWelfareManager.countAddCommodity() + 1);
//        helpWelfareDo.setWelfareNumber(sdf.format(new Date()) + format); //设置奖品期号
//        helpWelfareDo.setPrizeName("快乐大本营门票");                                 //奖品名称
//        helpWelfareDo.setStartTime(LocalDateTimeUtil.getNowMinTimeMilli());                                 //抽奖开始时间
//        helpWelfareDo.setEndTime(LocalDateTimeUtil.getNowMaxTimeMilli());                                   //抽奖结束时间
//        helpWelfareDo.setFoucaultCount(10);                              //消耗福卡数
//        helpWelfareDo.setHelpCount(100);                                  //开奖助力阈值
//        helpWelfareDo.setPrizeCount(1);                                 //奖品数量
//        helpWelfareDo.setPrizeImg(resourcesService.registerHelpWelfareImg("http://mghd.oss-cn-hangzhou.aliyuncs.com/temp/min_img/2019-08-05/276591869566332928.jpg"));//奖品封面图
//        List<String> prizeImg = new ArrayList<>();
//        prizeImg.add(resourcesService.registerHelpWelfareImg("http://mghd.oss-cn-hangzhou.aliyuncs.com/temp/min_img/2019-08-05/276591869566332928.jpg"));
//        helpWelfareDo.setDetailsPrizeImg(prizeImg);                     //奖品详情图
//        helpWelfareDo.setDescription("你帮我，我帮你，大家一起抢福利~~");                               //奖品描述
//        helpWelfareDo.setSortCount(0);                                  //前多少名才可以获得奖励
//        helpWelfareManager.insertHelpWelfare(helpWelfareDo);
//    }
//
//
//}
//
//
//
//
//

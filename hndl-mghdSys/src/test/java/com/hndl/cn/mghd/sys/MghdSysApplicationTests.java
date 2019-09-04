package com.hndl.cn.mghd.sys;

import com.google.common.collect.Sets;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.fans.FansGroupContributeEnums;
import com.hndl.cn.base.enums.user.UserNormalityTaskEnums;
import com.hndl.cn.base.enums.vote.VoteTypeEnums;
import com.hndl.cn.base.plugin.snowflakeid.service.ISnowflakeIdService;
import com.hndl.cn.base.plugin.snowflakeid.service.impl.SnowflakeIdServiceImpl;
import com.hndl.cn.dao.common.bean.CommonAdInfoDo;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.dao.game.mapper.GameStarVoteDoMapper;
import com.hndl.cn.dao.game.mapper.GameStarVoteExpressDoMapper;
import com.hndl.cn.dao.star.mapper.StarWeiboRelationDoMapper;
import com.hndl.cn.mghd.sys.business.banner.vo.BannerVo;
import com.hndl.cn.mghd.sys.business.rank.service.StarRankVoteService;
import com.hndl.cn.mghd.sys.business.star.service.StarFansStatisticsService;
import com.hndl.cn.mghd.sys.business.task.service.UserNormalityTaskService;
import com.hndl.cn.mghd.sys.business.vote.service.StarVoteService;
import com.hndl.cn.mongodb.manager.star.bean.StarFansGroupDo;
import com.hndl.cn.mongodb.manager.star.bean.StarMonthRankDo;
import com.hndl.cn.mongodb.manager.star.manager.StarFansGroupManager;
import com.hndl.cn.mongodb.manager.star.manager.StarFansWeekStatisticsManager;
import com.hndl.cn.mongodb.manager.star.manager.StarMonthRankManager;
import com.hndl.cn.mongodb.manager.user.bean.UserStatisticsDo;
import com.hndl.cn.mongodb.manager.user.manager.UserStatisticsDoManager;
import com.hndl.cn.mysql.manager.common.manager.CommonUserInfoManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import com.hndl.cn.utils.date.LocalDateUtil;
import com.hndl.cn.utils.number.CoinUtils;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import com.hndl.cn.utils.string.SensitiveWordFilter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MghdSysApplicationTests {


    @Resource
    private UserNormalityTaskService userNormalityTaskService;

    @Test
    public void testTask(){
        userNormalityTaskService.insertTaskAddIntegralCount(229650998870855681L, UserNormalityTaskEnums.OBEY_MASTER);
    }

    @Test
    public void contextLoads() {

        CommonAdInfoDo commonAdInfoDo = new CommonAdInfoDo();
        commonAdInfoDo.setHttpUrl("www.baidu.com");
        commonAdInfoDo.setStartDate(new Date());
        commonAdInfoDo.setImgUrl("www.baidu.com");
        commonAdInfoDo.setEndDate(new Date());
        final BannerVo convert = SpringCglibBeanUtils.convert(commonAdInfoDo, BannerVo.class);
        System.out.println(convert);


    }


    @Test
    public void test1(){
        userNormalityTaskService.insertTaskAddIntegralCount(229645071614660608L,UserNormalityTaskEnums.OBEY_SLAVE);
    }


    public static void main(String[] args) {
//        System.out.println(SensitiveWordFilter.INSTANCE.sensitiveWordMap.size());
        String string = "资龙茂";
        System.out.println("待检测语句字数：" + string.length());
        long beginTime = System.currentTimeMillis();
        boolean flag =  SensitiveWordFilter.INSTANCE.isContaintSensitiveWord(string,SensitiveWordFilter.maxMatchType);
        long endTime = System.currentTimeMillis();
        System.out.println("语句中是否包含敏感词：" + flag);
        System.out.println("总共消耗时间为：" + (endTime - beginTime));
        Set<String> sensitiveWord = SensitiveWordFilter.INSTANCE.getSensitiveWord(string, SensitiveWordFilter.maxMatchType);
        System.out.println(sensitiveWord.size() +" ====== " + sensitiveWord);
        System.out.println(SensitiveWordFilter.INSTANCE.replaceSensitiveWord(string,SensitiveWordFilter.minMatchTYpe));
    }



    //测试刷入数据
//    @Resource
//    StarFansGroupManager starFansGroupManager;
    @Resource
    GameStarVoteDoMapper gameStarVoteDoMapper;


    @Resource
    GameStarVoteExpressDoMapper gameStarVoteExpressDoMapper;
    @Resource
    StarWeiboRelationDoMapper starWeiboRelationDoMapper;

    ISnowflakeIdService iSnowflakeIdService = SnowflakeIdServiceImpl.INSTANCE;

    @Test
    public void test() throws  Exception{
        Long startTime = System.currentTimeMillis();
        Set<Long> longs = Sets.newConcurrentHashSet();

        Thread thread1 = new Thread(() -> {
            System.out.println("线程1启动");
            for (int j = 0; j < 2000000; j++) {
                long id = iSnowflakeIdService.nextUserId();

                longs.add(id);
            }
            System.out.println("线程1执行完毕");
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            System.out.println("线程2启动");
            for (int j = 0; j < 2000000; j++) {
                long id = iSnowflakeIdService.nextUserId();

                longs.add(id);
            }
            System.out.println("线程2执行完毕");
        });
        thread2.start();

        Thread thread3 = new Thread(() -> {
            System.out.println("线程3启动");
            for (int j = 0; j < 2000000; j++) {
                long id = iSnowflakeIdService.nextUserId();

                longs.add(id);
            }
            System.out.println("线程3执行完毕");
        });
        thread3.start();

        Thread thread4 = new Thread(() ->{
            System.out.println("线程4启动");
            for (int j = 0; j < 2000000; j++) {
                long id = iSnowflakeIdService.nextUserId();

                longs.add(id);
            }
            System.out.println("线程4执行完毕");
        });

        thread4.start();

        Thread thread5 = new Thread(() -> {
            System.out.println("线程5启动");
            for (int j = 0; j < 2000000; j++) {
                long id = iSnowflakeIdService.nextUserId();

                longs.add(id);
            }
            System.out.println("线程5执行完毕");
        });
        thread5.start();


        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();

        System.out.println(longs.size());


        System.out.println(System.currentTimeMillis() - startTime);
    }

    @Resource
    private StarFansStatisticsService starFansStatisticsService;


    @Test
    public void testSnowflakeId() throws Exception{
        CommonUserInfoDo commonUserInfoDo = new CommonUserInfoDo();
        commonUserInfoDo.setSysUniId(250583131147796480L);
        StarFansGroupDo starFansGroupDo = new StarFansGroupDo();
        starFansGroupDo.setStarId(41L);
        starFansStatisticsService.addVoteStatistics(commonUserInfoDo,starFansGroupDo,VoteTypeEnums.INTEGRAL_VOTE,100L);

        Thread.sleep(5000L);
        System.out.println("======================");
    }

//    @Test
//    public void testInbanch() throws Exception {
//
//
//        long count = gameStarVoteDoMapper.countByExample(new GameStarVoteDoExample());//统计一下多少条，
//        if (count <= 100) { //如果小于100条
//
//            //===========================================
//            //直接查询插入
//            //查询gameStarVote
//            List<GameStarVoteDo> gameStarVoteDos = gameStarVoteDoMapper.selectByExample(new GameStarVoteDoExample());
//
//            List<StarFansGroupDo> collect = gameStarVoteDos.stream().map(gameStarVoteDo -> {
//                StarFansGroupDo convert = SpringCglibBeanUtils.convert(gameStarVoteDo, StarFansGroupDo.class);
//                convert.setCreateTime(gameStarVoteDo.getCreateTime().getTime());
//                convert.setLastAdminUserId(gameStarVoteDo.getLastOperator());
//                convert.setUpdateTime(gameStarVoteDo.getLastModifyTime().getTime());
//                convert.setStarId(gameStarVoteDo.getId());
//                convert.setStarName(gameStarVoteDo.getName());
//                convert.setStarImg(gameStarVoteDo.getHeadUrl());
//                convert.setVoteUserCount(gameStarVoteDo.getVotePersonCount().intValue());
//                convert.setStarDescription(gameStarVoteDo.getBak2());
//                convert.setStarType(gameStarVoteDo.getOther3());
//                convert.setFansName(gameStarVoteDo.getBak4());//粉丝称呼
//                convert.setSex(gameStarVoteDo.getSex().toCharArray()[0]);
//                convert.setGuardCount(gameStarVoteDo.getGuardCount());
//               // convert.setMappingUserId(Long.valueOf(gameStarVoteDo.getCreateOperator()));
//                //获取微博圈名字
//                StarWeiboRelationDoExample weiboRelationDoExample = new StarWeiboRelationDoExample();
//                weiboRelationDoExample.createCriteria().andIsDeletedEqualTo("n").andStarIdEqualTo(gameStarVoteDo.getId());
//                List<StarWeiboRelationDo> dos = starWeiboRelationDoMapper.selectByExample(weiboRelationDoExample);
//
//
//                for (StarWeiboRelationDo aDo : dos) {
//                    System.out.println("=================微博id是==============" + aDo.getWeiboId().toString());
//                    System.out.println("==================映射用户id============"+ aDo.getUserId().toString());
//                    convert.setWeiboId(aDo.getWeiboId().toString());
//                    convert.setMappingUserId(aDo.getUserId());
//                }
//
//
//                //获取加入粉丝会人数
//                GameStarVoteExpressDoExample example = new GameStarVoteExpressDoExample();
//                example.createCriteria().andIsDeletedEqualTo("n").andStarIdEqualTo(gameStarVoteDo.getId());
//                Long count1 = gameStarVoteExpressDoMapper.countByExample(example);
//                convert.setUserCount(count1.intValue());
//
//                return convert;
//            }).collect(Collectors.toList());
//
//            starFansGroupManager.insertInBatchStarFansGroupRelation(collect);
//            System.out.println("=============插入执行中===========");
//            Thread.sleep(10000L);
//            //===============================
//        } else {
//            Long l = count / 100; //分多少页
//            Long l1 = count % 100; //把剩余多少条算出来
//            for (int i = 1; i <= l; i++) {
//                PageHelper.startPage(i, 100);//第i页，分100条
//                //查询
//                List<GameStarVoteDo> gameStarVoteDos = gameStarVoteDoMapper.selectByExample(new GameStarVoteDoExample());
//                //插入
//                List<StarFansGroupDo> collect = gameStarVoteDos.stream().map(gameStarVoteDo -> {
//                    StarFansGroupDo convert = SpringCglibBeanUtils.convert(gameStarVoteDo, StarFansGroupDo.class);
//                    convert.setCreateTime(gameStarVoteDo.getCreateTime().getTime());
//                    convert.setLastAdminUserId(gameStarVoteDo.getLastOperator());
//                    convert.setUpdateTime(gameStarVoteDo.getLastModifyTime().getTime());
//                    convert.setStarId(gameStarVoteDo.getId());
//                    convert.setStarName(gameStarVoteDo.getName());
//                    convert.setStarImg(gameStarVoteDo.getHeadUrl());
//                    convert.setVoteUserCount(gameStarVoteDo.getVotePersonCount().intValue());
//                    convert.setStarDescription(gameStarVoteDo.getBak2());
//                    convert.setStarType(gameStarVoteDo.getOther3());
//                    convert.setFansName(gameStarVoteDo.getBak4());//粉丝称呼
//                    convert.setSex(gameStarVoteDo.getSex().toCharArray()[0]);
//                    convert.setGuardCount(gameStarVoteDo.getGuardCount());
//
//                    //获取微博圈名字
//                    StarWeiboRelationDoExample weiboRelationDoExample = new StarWeiboRelationDoExample();
//                    weiboRelationDoExample.createCriteria().andIsDeletedEqualTo("n").andStarIdEqualTo(gameStarVoteDo.getId());
//                    List<StarWeiboRelationDo> dos = starWeiboRelationDoMapper.selectByExample(weiboRelationDoExample);
//
//
//                    for (StarWeiboRelationDo aDo : dos) {
//                        System.out.println("=================微博id是==============" + aDo.getWeiboId().toString());
//                        convert.setWeiboId(aDo.getWeiboId().toString());
//                    }
//
//
//                    //获取加入粉丝会人数
//                    GameStarVoteExpressDoExample example = new GameStarVoteExpressDoExample();
//                    example.createCriteria().andIsDeletedEqualTo("n").andStarIdEqualTo(gameStarVoteDo.getId());
//                    Long count1 = gameStarVoteExpressDoMapper.countByExample(example);
//                    convert.setUserCount(count1.intValue());
//
//                    return convert;
//                }).collect(Collectors.toList());
//
//                starFansGroupManager.insertInBatchStarFansGroupRelation(collect);
//                System.out.println("=============插入执行中===========");
//                Thread.sleep(10000L);
//                //===============================
//            }
//            //如果剩余条数不是0
//            if (l1 != 0)
//                //分页
//                PageHelper.startPage(l.intValue() + 1, l1.intValue());
//            //查询
//            List<GameStarVoteDo> gameStarVoteDos = gameStarVoteDoMapper.selectByExample(new GameStarVoteDoExample());
//            //插入
//            //插入
//            List<StarFansGroupDo> collect = gameStarVoteDos.stream().map(gameStarVoteDo -> {
//                StarFansGroupDo convert = SpringCglibBeanUtils.convert(gameStarVoteDo, StarFansGroupDo.class);
//                convert.setCreateTime(gameStarVoteDo.getCreateTime().getTime());
//                convert.setLastAdminUserId(gameStarVoteDo.getLastOperator());
//                convert.setUpdateTime(gameStarVoteDo.getLastModifyTime().getTime());
//                convert.setStarId(gameStarVoteDo.getId());
//                convert.setStarName(gameStarVoteDo.getName());
//                convert.setStarImg(gameStarVoteDo.getHeadUrl());
//                convert.setVoteUserCount(gameStarVoteDo.getVotePersonCount().intValue());
//                convert.setStarDescription(gameStarVoteDo.getBak2());
//                convert.setStarType(gameStarVoteDo.getOther3());
//                convert.setFansName(gameStarVoteDo.getBak4());//粉丝称呼
//                convert.setSex(gameStarVoteDo.getSex().toCharArray()[0]);
//                convert.setGuardCount(gameStarVoteDo.getGuardCount());
//
//                //获取微博圈名字
//                StarWeiboRelationDoExample weiboRelationDoExample = new StarWeiboRelationDoExample();
//                weiboRelationDoExample.createCriteria().andIsDeletedEqualTo("n").andStarIdEqualTo(gameStarVoteDo.getId());
//                List<StarWeiboRelationDo> dos = starWeiboRelationDoMapper.selectByExample(weiboRelationDoExample);
//
//
//                for (StarWeiboRelationDo aDo : dos) {
//                    System.out.println("=================微博id是==============" + aDo.getWeiboId().toString());
//                    convert.setWeiboId(aDo.getWeiboId().toString());
//                }
//
//
//                //获取加入粉丝会人数
//                GameStarVoteExpressDoExample example = new GameStarVoteExpressDoExample();
//                example.createCriteria().andIsDeletedEqualTo("n").andStarIdEqualTo(gameStarVoteDo.getId());
//                Long count1 = gameStarVoteExpressDoMapper.countByExample(example);
//                convert.setUserCount(count1.intValue());
//
//                return convert;
//            }).collect(Collectors.toList());
//
//            starFansGroupManager.insertInBatchStarFansGroupRelation(collect);
//            System.out.println("=============插入执行中===========");
//            Thread.sleep(10000L);
//            //===============================
//            //完事
//
//        }
//    }

    @Resource
    private CommonUserInfoManager commonUserInfoManager;

    @Test
    public void testAddCoin(){
        boolean flag = commonUserInfoManager.increaseCoinByUserUinId(248002007506681856L, CoinUtils.longConvertDouble(600l));
        System.out.println(flag);
    }

    @Resource
    private StarVoteService starVoteService;



//    @Test
//    public void integralVote() throws Exception{
//        CommonUserInfoDo userByUniId = commonUserInfoManager.findUserByUniId(229667836187037696L);
//        starVoteService.integralVote(userByUniId,1L,10L);
//        Thread.sleep(5000L);
//    }
//
//    @Test
//    public void coinVote() throws Exception{
//        CommonUserInfoDo userByUniId = commonUserInfoManager.findUserByUniId(229667836187037696L);
//        starVoteService.coinVote(userByUniId,1L,400L);
//        Thread.sleep(5000L);
//    }

    @Resource
    private StarRankVoteService starRankVoteService;

    @Resource
    private StarFansGroupManager starFansGroupManager;

    @Resource
    private StarMonthRankManager starMonthRankManager;

    @Test
    public void voteByStarId() throws Exception{
        LocalDate localDate = LocalDateUtil.firstDayOfMonth();
        System.out.println("开始时间" + localDate);
        for(int i = 0 ; i < 90; i ++){
            List<StarMonthRankDo> starDayRankByRankDate = starMonthRankManager.findByRankDate(LocalDateUtil.localDateToMilliSecond(localDate), 2);
            StarMonthRankDo no1 = starDayRankByRankDate.get(0);
            StarMonthRankDo no2 = starDayRankByRankDate.get(1);
            //小于300W 时不加票,5分钟执行一次
            if((no1.getVoteCount() - no2.getVoteCount()) < 3000000L){
                System.out.println("票数比例正常");
                Thread.sleep(120 * 1000);
                continue;
            }
            //每次加2000分之一
            Long addCount  = (no1.getVoteCount() - no2.getVoteCount()) / 200;

            Long count = addCount / 827;

            starFansGroupManager.updateGuardCount(no2.getStarId(),count);

            System.out.println(LocalDateTime.now().toString() + " 加票 : " + addCount + ",  添加多少守护" + count);
            starRankVoteService.asyncIncreaseAllVote(VoteTypeEnums.LOVE_VOTE,null,no2.getStarId(), addCount);
            Thread.sleep(180 * 1000);
//            if(System.currentTimeMillis() > 1565148600000L){
//                System.out.println("=====时间到，结束==="+ LocalDateTime.now().toString());
//                break;
//            }
        }

    }



    @Resource
    private MongoDbService mongoDbService;

    @Resource
    private UserStatisticsDoManager userStatisticsDoManager;

    @Test
    public void findAndModify(){
//        Query query = new Query(Criteria.where("userUniId").is(229667836187037696L).and("integralCount").gte(1000));
//        Update update = new Update();
//        update.inc("integralCount", -1000);
//        boolean flag = mongoDbService.incByResult(query, update, UserStatisticsDo.class);
//        System.out.println(flag);
        UserStatisticsDo andAddIntegralCount = userStatisticsDoManager.findAndAddIntegralCount(229667836187037696L, 1000L, IsValidEnums.YES);
        System.out.println(andAddIntegralCount);
    }

    @Resource
    StarFansWeekStatisticsManager starFansWeekStatisticsManager;


    @Test
    public void upsertWeekVote()throws Exception{
        CommonUserInfoDo commonUserInfoDo = new CommonUserInfoDo();
        commonUserInfoDo.setSysUniId(1234L);
        commonUserInfoDo.setPersonImgUrlMin("test");
        commonUserInfoDo.setNickName("test");
        StarFansGroupDo starFansGroupDo = new StarFansGroupDo();
        starFansGroupDo.setStarId(12345L);
        starFansGroupDo.setStarName("testStarId");
        starFansGroupDo.setStarImg("123");


        starFansStatisticsService.addConductStatistics(commonUserInfoDo,starFansGroupDo, FansGroupContributeEnums.CALL);
        starFansStatisticsService.addVoteStatistics(commonUserInfoDo,starFansGroupDo,VoteTypeEnums.INTEGRAL_VOTE,100l);
        Thread.sleep(300000L);
//        starFansWeekStatisticsManager.upsertWeekVote(
//                1234L,"test","test",12345L,"testStarId","123",VoteTypeEnums.INTEGRAL_VOTE,100l);
    }

}

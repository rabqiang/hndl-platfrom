package com.hndl.cn.wechat.sys;

import com.hndl.cn.base.plugin.snowflakeid.service.ISnowflakeIdService;
import com.hndl.cn.base.plugin.snowflakeid.service.impl.SnowflakeIdServiceImpl;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.dao.common.mapper.CommonUserInfoDoMapper;
import com.hndl.cn.dao.game.bean.GameStarVoteExpressDo;
import com.hndl.cn.dao.game.bean.GameStarVoteExpressDoExample;
import com.hndl.cn.dao.game.mapper.GameStarVoteExpressDoMapper;
import com.hndl.cn.dao.star.bean.StarFansExperienceCountDo;
import com.hndl.cn.dao.star.bean.StarFansExperienceCountDoExample;
import com.hndl.cn.dao.star.mapper.StarFansExperienceCountDoMapper;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.date.DateUtil;
import com.hndl.cn.utils.number.LevelUtil;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import com.hndl.cn.wechat.sys.business.user.manager.CommonUserInfoManager;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WechatSysApplicationTests {

    @Resource
    private CommonUserInfoManager commonUserInfoManager;

    @Resource
    private ISnowflakeIdService iSnowflakeIdService;

    @Resource
    private CommonUserInfoDoMapper commonUserInfoDoMapper;

    @Resource
    private StarFansExperienceCountDoMapper starFansExperienceCountDoMapper;

    @Resource
    private GameStarVoteExpressDoMapper expressDoMapper;

    @Test
    public void contextLoads()  {

        Long beginTime = System.currentTimeMillis();
        System.out.println("====================用户生成id开始============================");
        System.out.println("=================开始时间："+ LocalDateTime.now() +"====================");

        Integer pageNo = 1 ;

        Integer pageSize = 100;

        boolean flag = true;

        while (flag){
            List<CommonUserInfoDo> byUserPage = commonUserInfoManager.findByUserPageByUniIdIsNull(pageNo, pageSize);

            //如果没有数据直接退出循环
            if(CollectionUtils.isEmpty(byUserPage)){
                break;
            }
            //如果数据不足，下次不循环
            if(CollectionUtils.isNotEmpty(byUserPage) && byUserPage.size() < pageSize){
                flag = false;
            }

            byUserPage.parallelStream().filter(bean -> bean != null).forEach(bean -> {
                if(bean.getSysUniId() ==null){
                    CommonUserInfoDo commonUserInfoDo = new CommonUserInfoDo();
                    commonUserInfoDo.setId(bean.getId());
                    commonUserInfoDo.setSysUniId(iSnowflakeIdService.nextUserId());
                    commonUserInfoManager.updateUserInfo(commonUserInfoDo);
                    try {
                        Thread.sleep(1L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            System.out.println("=============执行到"+pageNo+"页================");
            pageNo ++;
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("==================耗费时间："+(endTime - beginTime)+"=================");
        System.out.println("===============结束时间"+LocalDateTime.now()+"========================");
        System.out.println("====================用户id生成完毕======================");



    }

    @Test
    public void exl() throws IOException {
//        String path = "C:\\Users\\赵俊凯\\Desktop\\2019-03-30丢失贡献统计.xls";
//        HSSFWorkbook workbook= new HSSFWorkbook(new FileInputStream(path));
//        Sheet sht0 = workbook.getSheetAt(0);
//        List<StarFansData> list = new ArrayList<>();
//        for(Row row : sht0){
//            StarFansData starFansData = new StarFansData();
//            row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
//            starFansData.setUserId(Long.valueOf(row.getCell(0).getStringCellValue()));
//            row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
//            starFansData.setStarId(Long.valueOf(row.getCell(1).getStringCellValue()));
//            row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
//            starFansData.setVoteCount(Long.valueOf(row.getCell(5).getStringCellValue()));
//            System.out.println(starFansData.toString());
//            list.add(starFansData);
//        }
//
//        list.stream().forEach( bean -> {
//            GameStarVoteExpressDoExample example = new GameStarVoteExpressDoExample();
//            GameStarVoteExpressDoExample.Criteria criteria = example.createCriteria();
//            criteria.andStarIdEqualTo(bean.getStarId());
//            criteria.andUserIdEqualTo(bean.getUserId());
//            criteria.andIsDeletedEqualTo("n");
//            List<GameStarVoteExpressDo> gameStarVoteExpressDos = expressDoMapper.selectByExample(example);
//            if(CollectionUtils.isEmpty(gameStarVoteExpressDos) && gameStarVoteExpressDos.size() > 1){
//                bean.toString();
//            }else {
//                 GameStarVoteExpressDo gameStarVoteExpressDo = gameStarVoteExpressDos.get(0);
//                 Long nowCount =  gameStarVoteExpressDo.getExpressCount();
//                 String fansTitle = this.getFansTitle(nowCount.intValue());
//                 gameStarVoteExpressDo.setTitleFans(fansTitle);
//                 expressDoMapper.updateByPrimaryKey(gameStarVoteExpressDo);
//
//            }
//        });




//        list.stream().forEach(bean -> {
//            CommonUserInfoDo commonUserInfoDo = commonUserInfoDoMapper.selectByPrimaryKey(bean.getUserId());
//            Integer count = commonUserInfoDo.getContributionValue();
//            Integer level =  LevelUtil.getContributionLevel(count);
//            commonUserInfoDo.setContributionLevel(level);
//            commonUserInfoDoMapper.updateByPrimaryKey(commonUserInfoDo);
//        });

//        list.stream().forEach( bean -> {
//            GameStarVoteExpressDoExample example = new GameStarVoteExpressDoExample();
//            GameStarVoteExpressDoExample.Criteria criteria = example.createCriteria();
//            criteria.andStarIdEqualTo(bean.getStarId());
//            criteria.andUserIdEqualTo(bean.getUserId());
//            criteria.andIsDeletedEqualTo("n");
//            List<GameStarVoteExpressDo> gameStarVoteExpressDos = expressDoMapper.selectByExample(example);
//            if(CollectionUtils.isEmpty(gameStarVoteExpressDos) && gameStarVoteExpressDos.size() > 1){
//                bean.toString();
//            }else {
//                 GameStarVoteExpressDo gameStarVoteExpressDo = gameStarVoteExpressDos.get(0);
//                 Long nowCount =  gameStarVoteExpressDo.getExpressCount() + bean.getVoteCount().intValue();
//                 gameStarVoteExpressDo.setExpressCount(nowCount);
//                 expressDoMapper.updateByPrimaryKey(gameStarVoteExpressDo);
//
//            }
//        });



//        list.stream().forEach(bean -> {
//            CommonUserInfoDo commonUserInfoDo = commonUserInfoDoMapper.selectByPrimaryKey(bean.getUserId());
//            if(commonUserInfoDo == null){
//                System.out.println(bean.getUserId());
//            }
//            commonUserInfoDo.setContributionValue(commonUserInfoDo.getContributionValue() == null ? 0 :commonUserInfoDo.getContributionValue()
//                    + bean.getVoteCount().intValue());
//            commonUserInfoDoMapper.updateByPrimaryKey(commonUserInfoDo);
//        });


//        StarFansExperienceCountDoExample example = new StarFansExperienceCountDoExample();
//        StarFansExperienceCountDoExample.Criteria criteria = example.createCriteria();
//        Date date  = DateUtil.addDays(new Date(), -3);
//        Date startDate =  DateUtil.beginOfDate(date);
//        Date endDate =  DateUtil.endOfDate(date);
//        System.out.println(startDate);
//        System.out.println(endDate);
//        criteria.andCreateTimeBetween(startDate,endDate);
//        criteria.andCountTypeEqualTo("day");
//        example.setOrderByClause(" vote_count desc ");
//        List<StarFansExperienceCountDo> selectList = starFansExperienceCountDoMapper.selectByExample(example);
//        System.out.println(list.size());
//        LocalDate localDate = LocalDate.of(2019,03,30);
//        Date date  = DateUtil.addDays(new Date(), -3);
//        Date startDate =  DateUtil.beginOfDate(date);
//        Date endDate =  DateUtil.endOfDate(date);

//        for(int i = 0 ;i < 99 ; i++){
//            StarFansData starFansData = list.get(i);
//            StarFansExperienceCountDo countDo = new StarFansExperienceCountDo();
//            countDo.setIsDeleted("n");
//            countDo.setStarId(starFansData.getStarId());
//            countDo.setVoteCount(starFansData.getVoteCount().intValue());
//            countDo.setUserId(starFansData.getUserId());
//            countDo.setCountDate(localDate.toString());
//            countDo.setCountType("day");
//            countDo.setCreateOperator("systemJob");
//            countDo.setCreateTime(date);
//            countDo.setLastModifyTime(date);
//            countDo.setLastOperator("systemJob");
//            countDo.setOther1("2019-03-30 00:00:00");
//            countDo.setOther2("2019-03-30 23:59:59");
//            StarFansExperienceCountDo oldDo =  selectList.get(i);
//            oldDo.setIsDeleted("y");
//            先把他状态修改
//            starFansExperienceCountDoMapper.updateByPrimaryKeySelective(oldDo);
//            StarFansExperienceCountDo newDo = SpringCglibBeanUtils.convert(oldDo,StarFansExperienceCountDo.class);
//            StarFansData exlDo =  list.get(i);
//            newDo.setId(null);
//            newDo.setUserId(exlDo.getUserId());
//            newDo.setStarId(exlDo.getStarId());
//            newDo.setIsDeleted("n");
//            newDo.setVoteCount(exlDo.getVoteCount().intValue());
//            starFansExperienceCountDoMapper.insert(countDo);

//        }
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void test29DayFansData(){

    }

    public static String getFansTitle(Integer expressCountOld){
        String titleFans = "1";
        if (expressCountOld <= 100) {
            titleFans = "1";
        } else if (expressCountOld >= 101 && expressCountOld <= 200) {
            titleFans = "2";
        } else if (expressCountOld >= 201 && expressCountOld <= 300) {
            titleFans = "3";
        } else if (expressCountOld >= 301 && expressCountOld <= 400) {
            titleFans = "4";
        } else if (expressCountOld >= 501 && expressCountOld <= 600) {
            titleFans = "5";
        } else if (expressCountOld >= 601 && expressCountOld <= 1000) {
            titleFans = "6";
        } else if (expressCountOld >= 1001 && expressCountOld <= 2000) {
            titleFans = "7";
        } else if (expressCountOld >= 2001 && expressCountOld <= 4000) {
            titleFans = "8";
        } else if (expressCountOld >= 4001 && expressCountOld <= 10000) {
            titleFans = "9";
        } else if (expressCountOld >= 10001 && expressCountOld <= 20000) {
            titleFans = "10";
        } else if (expressCountOld >= 20001 && expressCountOld <= 40000) {
            titleFans = "11";
        } else if (expressCountOld >= 40001 && expressCountOld <= 70000) {
            titleFans = "12";
        } else if (expressCountOld >= 70001 && expressCountOld <= 150000) {
            titleFans = "13";
        } else if (expressCountOld >= 150001 && expressCountOld <= 300000) {
            titleFans = "14";
        } else if (expressCountOld >= 300001 && expressCountOld <= 800000) {
            titleFans = "15";
        } else if (expressCountOld >= 800001 && expressCountOld <= 1800000) {
            titleFans = "16";
        } else if (expressCountOld >= 1800001 && expressCountOld <= 3800000) {
            titleFans = "17";
        } else if (expressCountOld >= 3800001 && expressCountOld <= 7800000) {
            titleFans = "18";
        } else if (expressCountOld >= 7800001 && expressCountOld <= 17800000) {
            titleFans = "19";
        } else if (expressCountOld >= 17800001) {
            titleFans = "20";
        }else{
            titleFans = "21";
        }
        return titleFans;
    }

}

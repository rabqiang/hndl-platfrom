package com.hndl.cn.mghd.sys.business.rank.controller;

import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.annotation.auth.CurrentUser;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.rank.service.StarRankService;
import com.hndl.cn.mghd.sys.common.constants.MghdSysConstants;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import com.hndl.cn.utils.date.LocalDateTimeUtil;
import com.hndl.cn.utils.date.LocalDateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.time.LocalDate;

/**
 * @author 赵俊凯
 * @Description  明星排名查询相关
 * @Date 2019/4/28 14:07
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/{source}/star/rank")
@Api(tags = "StarRank")
public class StarRankController {

    @Resource
    private StarRankService starRankService;


    @GetMapping("/initRunTimeDayStarRank")
    @ApiOperation(value="初始化明星榜页面接口", notes="包含Banner和明星榜")
    @CrossOrigin
    @AuthPassport
    public Result<Object> initRunTimeDayStarRank(@PathVariable String source, @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo){
        return starRankService.initRunTimeDayStarRank(commonUserInfoDo.getSysUniId());
    }


    @GetMapping("/findRunTimeDayStarRank")
    @CrossOrigin
    @ApiOperation(value="实时日榜明星榜数据接口", notes="实时日榜明星榜")
    public Result<Object> findRunTimeDayStarRank(@PathVariable String source,
                                                 @RequestParam Integer pageNo,
                                                 @RequestParam Integer pageSize){
        return starRankService.findRunTimeDayStarRank(pageNo, pageSize);
    }

    @GetMapping("/findRunTimeWeekStarRank")
    @CrossOrigin
    @ApiOperation(value="实时周榜明星榜数据接口", notes="实时周榜明星榜")
    public Result<Object> findRunTimeWeekStarRank(@PathVariable String source,
                                                  @RequestParam Integer pageNo,
                                                  @RequestParam Integer pageSize){
        return starRankService.findRunTimeWeekStarRank(pageNo, pageSize);
    }

    @GetMapping("/findRunTimeMonthStarRank")
    @CrossOrigin
    @ApiOperation(value="实时月榜明星榜数据接口", notes="实时月榜明星榜")
    public Result<Object> findRunTimeMonthStarRank(@PathVariable String source,
                                                   @RequestParam Integer pageNo,
                                                   @RequestParam Integer pageSize){
        return starRankService.findRunTimeMonthStarRank(pageNo, pageSize);
    }

    @GetMapping("/findHistoryDayStarRank")
    @ApiOperation(value="历史日榜榜明星榜数据接口", notes="历史日明星榜")
    public Result<Object> findHistoryDayStarRank(@PathVariable String source,
                                                 @ApiParam(name="date",value="毫秒数,精确到天,只能查询近7天的数据",required=true)
                                                 @RequestParam Long date){

        LocalDate localDate = LocalDateTimeUtil.milliSecondToLocalDateTime(date).toLocalDate();

        //判断是否是第今天,然后判断是否在时间范围之内
        if(LocalDateUtil.isNowDate(localDate) || LocalDateUtil.isBeforeNowDay(localDate,MghdSysConstants.STAR_MIN_HISTORY_DAY)){
             throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }

        return starRankService.findHistoryDayStarRank(localDate);
    }

    @GetMapping("/findHistoryWeekStarRank")
    public Result<Object> findHistoryWeekStarRank(@PathVariable String source,
                                                  @ApiParam(name="date",value="周一毫秒数,精确到天,只能查询近7周天的数据",required=true)
                                                  @RequestParam Long date){

        LocalDate localDate = LocalDateTimeUtil.milliSecondToLocalDateTime(date).toLocalDate();

        //判断是否是第今天,然后判断是否在时间范围之内
        if(LocalDateUtil.isNowDate(localDate) ||
                !LocalDateUtil.isMONDAY(localDate) ||
                LocalDateUtil.isBeforeNowWeek(localDate,MghdSysConstants.STAR_MIN_HISTORY_WEEK)){
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }

        return starRankService.findHistoryWeekStarRank(localDate);
    }

    @GetMapping("/findHistoryMonthStarRank")
    public Result<Object> findHistoryMonthStarRank(@PathVariable String source,
                                                   @ApiParam(name="date",value="每月第一天毫秒数,精确到天,只能查询近7月的数据",required=true)
                                                   @RequestParam Long date){

        LocalDate localDate = LocalDateTimeUtil.milliSecondToLocalDateTime(date).toLocalDate();

        //判断是否是第今天,然后判断是否在时间范围之内
        if(LocalDateUtil.isNowDate(localDate) ||
                !LocalDateUtil.isFirstDayOfMonth(localDate)||
                 LocalDateUtil.isBeforeNowMonth(localDate,MghdSysConstants.STAR_MIN_HISTORY_MONTH)){
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        return starRankService.findHistoryMonthStarRank(localDate);
    }

}

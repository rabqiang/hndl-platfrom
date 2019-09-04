package com.hndl.cn.mghd.sys.business.rank.controller;

import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.annotation.auth.CurrentUser;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.rank.service.FansRankService;
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
 * @Description 星粉榜相关接口
 * @Date 2019/5/6 10:19
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/{source}/fans/rank")
@Api(tags = "FansRank")
public class FansRankController {

    @Resource
    private FansRankService fansRankService;

    /**
     * 星粉日榜实时数据
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/findRunTimeDayFansRank")
    @CrossOrigin
    @AuthPassport(validate = false)
    @ApiOperation(value="查询实时星粉日榜接口", notes="日榜实时数据")
    public Result<Object> findRunTimeDayFansRank(@PathVariable String source,
                                                 @RequestParam Integer pageNo,
                                                 @RequestParam Integer pageSize,
                                                 @CurrentUser @ApiIgnore CommonUserInfoDo userInfoDo){
        return fansRankService.findRunTimeDayFansRank(userInfoDo== null ? null : userInfoDo.getSysUniId()
                ,pageNo, pageSize);
    }

    /**
     * 星粉周榜实时数据
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/findRunTimeWeekFansRank")
    @CrossOrigin
    @AuthPassport(validate = false)
    @ApiOperation(value="查询实时星粉周榜接口", notes="周榜实时数据")
    public Result<Object> findRunTimeWeekFansRank(@PathVariable String source,
                                                  @RequestParam Integer pageNo,
                                                  @RequestParam Integer pageSize,
                                                  @CurrentUser @ApiIgnore CommonUserInfoDo userInfoDo){
        return fansRankService.findRunTimeWeekFansRank(userInfoDo== null ? null : userInfoDo.getSysUniId()
                ,pageNo, pageSize);
    }

    /**
     *星粉月榜实时数据
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/findRunTimeMonthFansRank")
    @CrossOrigin
    @AuthPassport(validate = false)
    @ApiOperation(value="查询实时星粉月榜接口", notes="月榜实时数据")
    public Result<Object> findRunTimeMonthFansRank(@PathVariable String source,
                                                   @RequestParam Integer pageNo,
                                                   @RequestParam Integer pageSize,
                                                   @CurrentUser @ApiIgnore CommonUserInfoDo userInfoDo){
        return fansRankService.findRunTimeMonthFansRank(userInfoDo== null ? null : userInfoDo.getSysUniId(),
                pageNo, pageSize);
    }


    /**
     * 星粉榜历史数据
     * @param date
     * @return
     */
    @GetMapping("/findHistoryDayFansRank")
    @AuthPassport(validate = false)
    @ApiOperation(value="查询历史星粉日榜接口", notes="日榜实时数据")
    public Result<Object> findHistoryDayFansRank(@PathVariable String source,
                                                 @ApiParam(name="date",value="毫秒数,精确到天,只能查询近7天的数据",required=true)
                                                 @RequestParam Long date,
                                                 @CurrentUser @ApiIgnore CommonUserInfoDo userInfoDo){

        LocalDate localDate = LocalDateTimeUtil.milliSecondToLocalDateTime(date).toLocalDate();

        //判断是否是第今天,然后判断是否在时间范围之内
        if(LocalDateUtil.isNowDate(localDate) || LocalDateUtil.isBeforeNowDay(localDate,MghdSysConstants.STAR_MIN_HISTORY_DAY)){
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }

        return fansRankService.findHistoryDayFansRank(userInfoDo== null ? null : userInfoDo.getSysUniId(),localDate);
    }


    @GetMapping("/findHistoryWeekFansRank")
    @AuthPassport(validate = false)
    @ApiOperation(value="查询历史星粉周榜接口", notes="周榜实时数据")
    public Result<Object> findHistoryWeekFansRank(@PathVariable String source,
                                                  @ApiParam(name="date",value="每周一毫秒数,精确到天,只能查询近7周的数据",required=true)
                                                  @RequestParam Long date,
                                                  @CurrentUser @ApiIgnore CommonUserInfoDo userInfoDo){

        LocalDate localDate = LocalDateTimeUtil.milliSecondToLocalDateTime(date).toLocalDate();

        //判断是否是第今天,然后判断是否在时间范围之内
        if(LocalDateUtil.isNowDate(localDate) ||
                !LocalDateUtil.isMONDAY(localDate) ||
                LocalDateUtil.isBeforeNowWeek(localDate,MghdSysConstants.STAR_MIN_HISTORY_WEEK)){
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }

        return fansRankService.findHistoryWeekFansRank(userInfoDo== null ? null : userInfoDo.getSysUniId(),localDate);
    }


    /**
     * 星粉榜月榜数据
     * @param date
     * @return
     */
    @GetMapping("/findHistoryMonthFansRank")
    @AuthPassport(validate = false)
    @ApiOperation(value="查询历史星粉月榜接口", notes="周榜实时数据")
    public Result<Object> findHistoryMonthFansRank(@PathVariable String source,
                                                   @ApiParam(name="date",value="每月第一天毫秒数,精确到天,只能查询近7月的数据",required=true)
                                                   @RequestParam Long date,
                                                   @CurrentUser @ApiIgnore CommonUserInfoDo userInfoDo){

        LocalDate localDate = LocalDateTimeUtil.milliSecondToLocalDateTime(date).toLocalDate();

        //判断是否是第今天,然后判断是否在时间范围之内
        if(LocalDateUtil.isNowDate(localDate) ||
                LocalDateUtil.isBeforeNowMonth(localDate,MghdSysConstants.STAR_MIN_HISTORY_MONTH)){
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }

        return fansRankService.findHistoryMonthFansRank(userInfoDo== null ? null : userInfoDo.getSysUniId(), localDate);
    }



}

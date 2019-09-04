package com.hndl.cn.mghd.sys.business.vote.controller;

import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.annotation.auth.CurrentUser;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.vote.service.StarVoteService;
import com.hndl.cn.mghd.sys.business.vote.vo.CoinVoteVo;
import com.hndl.cn.mghd.sys.business.vote.vo.IntegralVoteVo;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import com.hndl.cn.utils.number.CoinUtils;
import com.hndl.cn.utils.string.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author 赵俊凯
 * @Description 用户打榜相关接口
 * @Date 2019/5/9 11:10
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/{source}/star/vote")
@Api(value = "/{source}/star/vote",tags = "用户打榜相关接口")
public class StarVoteController {

    @Resource
    private StarVoteService starVoteService;



    @PostMapping(value = {"/integralVote/{version:.+}","/integralVote"})
    @ApiOperation(value="积分打榜")
    @AuthPassport
    public Result<Object> integralVote(@CurrentUser @ApiIgnore CommonUserInfoDo userInfoDo,@PathVariable(required = false) String version,
                                       @Valid @RequestBody IntegralVoteVo voteVo){
        boolean flag = StringUtils.isNotEmpty(version);
        return starVoteService.integralVote(userInfoDo,voteVo.getStarId(),voteVo.getIntegralNum(),flag);
    }


    @PostMapping(value = {"/coinVote/{version:.+}","/coinVote"})
    @ApiOperation(value="快乐币打榜")
    @AuthPassport
    public Result<Object> coinVote( @CurrentUser @ApiIgnore CommonUserInfoDo userInfoDo,@PathVariable(required = false) String version,
                                    @Valid @RequestBody CoinVoteVo voteVo){
        //校验参数是否正常
        if(!CoinUtils.checkCoin(voteVo.getCoinNum())){
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        boolean flag = StringUtils.isNotEmpty(version);
        return starVoteService.coinVote(userInfoDo,voteVo.getStarId(),voteVo.getCoinNum(),flag);
    }


//    @PostMapping("/loveVote")
//    @ApiOperation(value="爱心打榜", notes="爱心打榜")
//    @AuthPassport
//    public Result<Object> loveVote(@CurrentUser @ApiIgnore CommonUserInfoDo userInfoDo,
//                                   @Valid @RequestBody CoinVoteVo voteVo){
//        //校验参数是否正常
//        if(!CoinUtils.checkCoin(voteVo.getCoinNum())){
//            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
//        }
//
//        return starVoteService.loveVote(userInfoDo,voteVo.getStarId(),voteVo.getCoinNum());
//    }

}

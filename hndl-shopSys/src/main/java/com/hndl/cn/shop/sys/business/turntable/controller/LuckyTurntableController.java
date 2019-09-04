package com.hndl.cn.shop.sys.business.turntable.controller;

import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.annotation.auth.CurrentUser;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.shop.sys.business.turntable.service.LuckyTurntableService;
import com.hndl.cn.shop.sys.business.turntable.service.TurntableMessageService;
import com.hndl.cn.shop.sys.business.turntable.vo.LuckyTurntableVo;
import com.hndl.cn.shop.sys.business.turntable.vo.TurntableMessageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @program:hndl-platform
 * @description:TODO 幸运转盘
 * @author: 易成贤
 * @create: 2019/7/15 17:59
 * @Created by湖南达联
 **/
@RestController
@RequestMapping("/luckyTurntable")
@Api(tags = "luckyTurntable")
public class LuckyTurntableController {

    @Resource
    LuckyTurntableService luckyTurntableService;

    @Resource
    private TurntableMessageService turntableMessageService;

    /**
     * 抽奖
     *
     * @param commonUserInfoDo
     * @return
     */
    @GetMapping("/prizeDraw")
    @ApiOperation(value = "抽奖")
    @AuthPassport
    public Result<LuckyTurntableVo> prizeDraw(@CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo,@RequestParam Integer version) {
        return luckyTurntableService.prizeDraw(commonUserInfoDo,version);
    }

    @GetMapping("/findPrize")
    @ApiOperation(value = "查询奖品列表")
    @AuthPassport
    public Result<Map<String,Object>> findPrize(@CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo) {
        return luckyTurntableService.findPrize(commonUserInfoDo);
    }


    @GetMapping("/reportVideo")
    @ApiOperation(value = "观看视频上报接口")
    @AuthPassport
    public Result<Map<String,Object>> reportVideo(@CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo) {
        return luckyTurntableService.reportVideo(commonUserInfoDo);
    }


    /**
     *  获取弹幕
     *  isEntity 0虚拟  1实物  null代表虚拟and实物
     * */
    @GetMapping("/findTurntableMessage")
    @ApiOperation(value = "查询转盘弹幕")
    public Result<List<TurntableMessageVo>>  findTurntableMessage(Integer isEntity){
        return  ResultFactory.success(turntableMessageService.findTurntableMessageByEntity(isEntity));
    }

    @GetMapping("/findUserPrize")
    @ApiOperation(value = "查看用户奖品列表")
    @AuthPassport
    public Result<Map<String,Object>> findUserPrize(@CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo ,String id) {
        return luckyTurntableService.findUserDraw(commonUserInfoDo,id);
    }

    @GetMapping("/findUserFoucault")
    @ApiOperation(value = "查询用户福卡相关")
    @AuthPassport
    public Result<Map<String,Object>> findUserFoucault(@CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo) {
        return luckyTurntableService.findUserFoucault(commonUserInfoDo);
    }
}

package com.hndl.cn.mghd.sys.business.call.controller;

import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.annotation.auth.CurrentUser;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.call.service.StarFansCircleService;
import com.hndl.cn.mghd.sys.business.call.vo.ReceiveCallContentVo;
import com.hndl.cn.mghd.sys.business.call.vo.StarCallContentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;


/**
 * @program: hndl-platform
 * @description: 星粉圈操作
 * @author: 易成贤
 * @create: 2019-05-08 20:29
 * @Created by 湖南达联
 **/
@RestController
@RequestMapping(path = "/{source}/star/starFansCircle")
@Api(tags = "打call")
public class StarFansCircleController {

    @Resource
    StarFansCircleService starFansCircleService;

    /**
     * 查询星粉圈数据
     *
     * @param commonUserInfoDo
     * @param starId
     * @param id
     * @return
     */
    @CrossOrigin
    @GetMapping("/findStarFansCircle")
    @AuthPassport(validate = false)
    @ApiOperation(value = "查询星粉圈",notes = "该接口主要查询星粉圈<br/>星粉圈数据包括&#58;<b>用户打call与爱豆说</b>的数据")
    public Result<List<StarCallContentVo>> findStarFansCircle(@PathVariable String source, @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo,
                                             @ApiParam(value = "当前页") @RequestParam Integer pageNo,
                                             @ApiParam( value = "明星id", required = true) @RequestParam Long starId,
                                             @ApiParam(value = "ObjId")String id) {
        List<StarCallContentVo> vos = starFansCircleService.findAllStarFansCircle(commonUserInfoDo, pageNo,starId, id);
        return ResultFactory.success(vos);
    }

    /**
     * 查询爱豆说
     *
     * @param starId
     * @param id
     * @return
     */
    @CrossOrigin
    @ApiOperation(value = "查询爱豆说", notes = "只包含爱豆说,不包含用户打call的数据,<br/>当前页>10,才会传ObjId")
    @GetMapping("/findStarSaid")
    @AuthPassport(validate = false)
    public Result<List<StarCallContentVo>> findStarSaid(@PathVariable String source,@CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo,
                                       @ApiParam(value = "当前页")
                                       @RequestParam Integer pageNo,
                                       @ApiParam(value = "明星id", required = true)
                                       @RequestParam Long starId,
                                       @ApiParam( value = "ObjId")
                                        String id) {
        List<StarCallContentVo> vos = starFansCircleService.findStarSaid(commonUserInfoDo, pageNo,starId, id);
        return ResultFactory.success(vos);
    }

    /**
     * 查询用户发布的打call数据
     *
     * @param commonUserInfoDo
     * @param userUniId
     * @param id
     * @return
     */
    @ApiOperation(value = "查询用户打call/可用于查询用户自己的打call数据", notes = "只包含用户打call,不包含爱豆说数据")
    @GetMapping("/findUserCall")
    @AuthPassport(validate = false)
    public Result<Map<String,Object>> findUserCall(@PathVariable String source,@CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo,
                                       @ApiParam(value = "当前页") @RequestParam Integer pageNo,
                                       @ApiParam(value = "用户Id", required = true) @RequestParam Long userUniId,
                                       @ApiParam(value = "ObjId") String id) {
        Map<String, Object> userCallMap = starFansCircleService.findUserCall(commonUserInfoDo, pageNo, userUniId, id);
        return ResultFactory.success(userCallMap);
    }

    /**
     * 打call 插入一条星粉圈数据
     *
     * @param //commonUserInfoDo
     * @return
     */
    @ApiOperation(value = "用户打call",notes = "用户必须登陆", httpMethod = "POST")
    @PostMapping("/addCallContent")
    @AuthPassport
    public Result<Object> addCallContent(@PathVariable String source,@CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo,
            @ApiParam(value = "打call数据对象")
            @RequestBody @Valid  ReceiveCallContentVo receiveCallContentVo) {
       return starFansCircleService.addStarFansCircle(
                 commonUserInfoDo, receiveCallContentVo.getStarId(),
                receiveCallContentVo.getContent(),
                receiveCallContentVo.getContentImgList());


    }
    @ApiOperation(value = "查询单个打call数据详细")
    @GetMapping("/findDetailCall")
    @AuthPassport
    public Result<Map<String,Object>> findDetailCall(@PathVariable String source, @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo,
                                                     @ApiParam(value = "指定打call的数据") @RequestParam Long callId,
                                                     @ApiParam(value = "ObjId") String id){
       return starFansCircleService.findOneDetailCall(commonUserInfoDo,callId,id);
    }

    @GetMapping("/deleteCall")
    @ApiOperation(value = "删除自己的打call数据")
    @AuthPassport(validate = true)
    public Result<Object> deleteCall(@PathVariable String source, @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo,
                                                     @ApiParam(value = "指定打call的数据") @RequestParam Long callId){
        return starFansCircleService.deleteCall(commonUserInfoDo,callId);
    }
}

package com.hndl.cn.mghd.admin.business.call.controller;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.mghd.admin.business.call.service.CallContentService;
import com.hndl.cn.mghd.admin.business.call.vo.CallContentVo;
import com.hndl.cn.mghd.admin.common.annotation.AdminLog;
import com.hndl.cn.mghd.admin.common.annotation.AuthPower;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program:hndl-platform
 * @description:TODO 打call内容管理
 * @author: 易成贤
 * @create: 2019/7/1 10:58
 * @Created by湖南达联
 **/
@Api(tags = "call 内容管理")
@RequestMapping("/call")
@RestController
public class CallContentController {

    @Resource
    CallContentService callContentService;

    /**
     * 查询
     * @param id 主要作用用于分页
     * @param parameters 传入参数 (只可以是用户id或者明星id)
     * @return
     */
    @GetMapping("/findCall")
    @ApiOperation(value = "查询call")
    @AdminLog
    @AuthPower
    public Result<List<CallContentVo>> findCall(String id, String parameters,Integer isDelete){
       return callContentService.findCall(id,parameters,isDelete);
    }

    /**
     *加入精华打call
     * @param callId
     * @return
     */
    @GetMapping("/addQuintessenceCall")
    @ApiOperation(value = "加入精华call")
    @AdminLog
    @AuthPower
    public Result addQuintessenceCall(@RequestParam Long callId){
        return callContentService.addQuintessence(callId);
    }

    /**
     * 移除精华打call
     * @param callId
     * @return
     */
    @GetMapping("/removeQuintessenceCall")
    @ApiOperation(value = "移除精华call")
    @AdminLog
    @AuthPower
    public Result removeQuintessenceCall(@RequestParam Long callId){
        return callContentService.removeQuintessence(callId);
    }

    /***
     * 删除打call
     * @param callId
     * @return
     */
    @GetMapping("/deleteCall")
    @ApiOperation(value = "删除指定call")
    @AdminLog
    @AuthPower
    public Result deleteCall(@RequestParam Long callId){
        return callContentService.deleteCall(callId);
    }

    /**
     * 查询单个call
     * @return
     */
    @GetMapping("/findOneCall")
    @AdminLog
    @AuthPower
    public Result<CallContentVo> findOneCall(@RequestParam Long callId){
        return callContentService.findOneCall(callId);
    }
}

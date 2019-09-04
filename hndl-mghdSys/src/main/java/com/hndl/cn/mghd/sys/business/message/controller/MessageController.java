package com.hndl.cn.mghd.sys.business.message.controller;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.mghd.sys.business.message.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 赵俊凯
 * @Description 弹幕消息
 * @Date 2019/5/15 15:06
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/{source}/message")
@Api(value = "/{source}/message")
public class MessageController {

    @Resource
    private MessageService messageService;


    @GetMapping("/findBarrageMsg")
    @ApiOperation(value="获取弹幕信息", notes="查询banner")
    public Result<Object> findBannerInfoByBannerEnums(@PathVariable String source,
                                                      @ApiParam(name="createTime",value="当前时间")
                                                      @RequestParam Long createTime){
        return messageService.findBarrageMsg(createTime);
    }
}

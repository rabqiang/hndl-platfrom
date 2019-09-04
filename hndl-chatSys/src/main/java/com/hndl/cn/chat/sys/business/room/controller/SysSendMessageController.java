package com.hndl.cn.chat.sys.business.room.controller;

import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.annotation.auth.CurrentUser;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.chat.sys.business.room.service.SysSendMessageService;
import com.hndl.cn.chat.sys.business.room.vo.EaseMobMessageVo;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/22 21:55
 * @Created by 湖南达联
 */
@RestController
    @RequestMapping("/message")
public class SysSendMessageController {

    @Resource
    private SysSendMessageService sysSendMessageService;


//    @AuthPassport
//    @PostMapping("/insertEaseMobUser")
//    public Result<Object> insertEaseMobUser(@CurrentUser CommonUserInfoDo commonUserInfoDo,
//                                            @Valid @RequestBody EaseMobMessageVo easeMobMessageVo){
//        return sysSendMessageService.sendTxtMessage(commonUserInfoDo.getSysUniId(),
//                easeMobMessageVo.getMsg(),easeMobMessageVo.getRoomId());
//    }

    @AuthPassport
    @PostMapping("/insertSendMessageTask")
    public Result<Object> reportMessageRewardTask(@Ignore @CurrentUser CommonUserInfoDo commonUserInfoDo
                                                 ,@Valid @RequestBody EaseMobMessageVo easeMobMessageVo){
        return sysSendMessageService.reportMessageRewardTask(commonUserInfoDo,easeMobMessageVo);
    }

    @GetMapping("/findHistoryChatMessageByRoomId")
    public Result<Object> findHistoryChatMessageByRoomId(@RequestParam String roomId){
        return sysSendMessageService.findHistoryChatMessageByRoomId(roomId);
    }
}

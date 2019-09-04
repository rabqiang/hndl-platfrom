package com.hndl.cn.chat.sys.business.room.controller;

import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.annotation.auth.CurrentUser;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.chat.sys.business.room.service.SysChatRoomService;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/22 21:52
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/room")
public class SysChatRoomController {


    @Resource
    private SysChatRoomService sysChatRoomService;


    @AuthPassport
    @PostMapping("/addFansGroupChatRoomOrUserToRoom/{fansGroupId}")
    public Result<Object> addFansGroupChatRoomOrUserToRoom(@CurrentUser CommonUserInfoDo commonUserInfoDo,
                                                           @PathVariable Long fansGroupId){
        return sysChatRoomService.addFansGroupChatRoomOrUserToRoom(commonUserInfoDo,fansGroupId);
    }

}

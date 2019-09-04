package com.hndl.cn.mghd.admin.business.friend.controller;


import com.hndl.cn.mghd.admin.business.friend.service.FriendService;
import com.hndl.cn.mghd.admin.business.friend.vo.FriendsVo;
import com.hndl.cn.mghd.admin.common.annotation.AdminLog;
import com.hndl.cn.mghd.admin.common.annotation.AuthPower;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 尹争鸣
 * @Description TODO
 * @Date 2019年6月26日11:07:29
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/friend")
@Api(value = "/friend", tags = "admin-friend-controller")
public class FriendController {

    @Resource
    private FriendService friendService;


    /**
     * 因为查询所需内容 破坏了 ID有序性  分页可能造成部分数据显示丢失
     */
    @ApiOperation(value = " 查询好友", notes = "根据uniId查询好友")
    @AuthPower
    @AdminLog
    @GetMapping("/findFriendByUniId")
    public FriendsVo findFriendByUniId(@RequestParam Long uniId, String id) {
        return friendService.findFriendsByUserId(uniId, id);
    }

}

package com.hndl.cn.mghd.admin.business.mentor.controller;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.mghd.admin.business.mentor.service.MentorShipService;
import com.hndl.cn.mghd.admin.common.annotation.AdminLog;
import com.hndl.cn.mghd.admin.common.annotation.AuthPower;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/6/20 16:42
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/userMentor")
@Api(value = "/userMentor",tags = "师徒查询管理")
public class MentorShipController {

    @Resource
    private MentorShipService mentorService;


    /**
     * 查询师徒信息
     *
     * @return
     */
    @ApiOperation(value = "查询师徒信息", notes = "查询用户徒弟信息")
    @AdminLog
    @AuthPower
    @GetMapping("/findUserMentorAll")
    public Result<Object> findUserMentorAll(@ApiParam(value = "用户UniId")@RequestParam(required = false) Long userUniId,
                                            @ApiParam(value = "上一页的最后一条记录的id, 根据此字段分页") @RequestParam(required = false) String id) {

        return mentorService.findUserMentorAll(userUniId, id);

    }


}

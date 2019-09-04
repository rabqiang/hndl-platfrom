package com.hndl.cn.mghd.sys.business.star.controller;

import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.mghd.sys.business.star.service.StarActivityInfoService;
import com.hndl.cn.mghd.sys.business.star.vo.StarActivityVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "activity")
@RestController
@RequestMapping(path = "/{source}/star")
public class StarActivityInfoController {

    @Resource
    private StarActivityInfoService starActivityInfoService;

    @CrossOrigin
    @ApiOperation(value = "心愿数相关接口",notes = "exp:用户点击粉丝会查看到的数据")
    @AuthPassport(validate = false)
    @GetMapping(path = "/findActivity")
    public Result<List<StarActivityVo>> findActivity(@PathVariable String source,@RequestParam String typeKey,@RequestParam Long pageNo){

        return  ResultFactory.success(starActivityInfoService.findActivity(typeKey,pageNo));
    }
}

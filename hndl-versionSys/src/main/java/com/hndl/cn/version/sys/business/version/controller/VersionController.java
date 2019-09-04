package com.hndl.cn.version.sys.business.version.controller;


import com.alibaba.fastjson.JSONObject;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.version.sys.business.version.service.VersionService;
import com.hndl.cn.version.sys.business.version.vo.VersionVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Api(value = "/systemM")
public class VersionController {

    @Resource
    private VersionService versionService;

    /**
     * 查询版本号的信息
     *
     * @return
     */
    @ApiOperation(value = "查询版本号信息")
    @RequestMapping("/SystemVersionInfo_querySystemVersionInfo.do")
    public JSONObject findUserStatisticsByUserUinId(@RequestParam String appType, @RequestParam String appName) {
        JSONObject json = new JSONObject();
        VersionVo versionVo = versionService.querySystemVersionInfo(appType, appName);
        if (null != versionVo) {
            json.put("success", true);
            json.put("msg", "查询成功");
            json.put("data", versionVo);
        } else {
            json.put("success", false);
            json.put("msg", "查询失败");
        }
        return json;
    }


    /**
     * 获取version 2.0
     * 获取版本信息 和 维护状态
     */
    @GetMapping("/findVersionAndMaintainState")
    public Result<Object> findVersionAndMaintainState(@RequestParam String appType, @RequestParam String appName) {


        return ResultFactory.success(versionService.findVersionAndMaintain(appType, appName));
    }

    @GetMapping("/findVersionAndMaintainStateTwo")
    public Result<Object> findVersionAndMaintainState(@RequestParam String appType, @RequestParam String appName ,@RequestParam String versionId ) {

        return ResultFactory.success(versionService.findVersionAndMaintain(appType, appName,versionId));
    }

}

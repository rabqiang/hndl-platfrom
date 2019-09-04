package com.hndl.cn.mghd.sys.business.video.controller;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.mghd.sys.business.video.service.VideoService;
import com.hndl.cn.mghd.sys.business.video.vo.ExclusiveVideoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @program:hndl-platform
 * @description: 独家视频
 * @author: 易成贤
 * @create: 2019-06-10 17:41
 * @Created by湖南达联
 **/
@RestController
@RequestMapping("/{source}/video")
@Api(tags = "视频相关接口")
public class VideoController {

    @Resource
    VideoService videoService;

    @CrossOrigin
    @GetMapping("/findExclusiveVideo")
    @ApiOperation(value = "查询独家视频")
    public Result<List<ExclusiveVideoVo>> findExclusiveVideo(Integer pageNo){
       return videoService.ExclusiveVideo(pageNo);
    }

    @CrossOrigin
    @GetMapping("/findWeiBoVideo")
    @ApiOperation(value = "查询微博视频")
    public  Result<Map<String,Object>> findWeiBoVideo(@RequestParam Integer pageNo){
        return videoService.findWeiBoVideo(pageNo);
    }
}

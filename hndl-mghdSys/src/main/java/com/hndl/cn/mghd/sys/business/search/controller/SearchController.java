package com.hndl.cn.mghd.sys.business.search.controller;

import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.annotation.auth.CurrentUser;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.search.service.SearchService;
import com.hndl.cn.mghd.sys.business.search.vo.FansGroupVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @program:hndl-platform
 * @description: 搜索
 * @author: 易成贤
 * @create: 2019-05-27 17:41
 * @Created by湖南达联
 **/
@RestController
@RequestMapping(path = "/{source}/search")
@Api(tags = "搜索")
public class SearchController {

    @Resource
    SearchService searchService;

    @GetMapping("/searchFansGroup")
    @AuthPassport
    @ApiOperation(value = "关键词匹配明星",notes = "左匹配方式")
    public Result<List<FansGroupVo>> searchFansGroup(@PathVariable String source, @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo,
                                                   @ApiParam(value = "关键字",required = true) @RequestParam String keyWords) {
        List<FansGroupVo> fansGroupVos = searchService.searchFansGroup(commonUserInfoDo, keyWords);
        return ResultFactory.success(fansGroupVos);
    }
    @GetMapping("/searchRecommend")
    @AuthPassport
    @ApiOperation(value = "展示搜索推荐列表")
    public Result<Map<String,List<FansGroupVo>>> searchRecommend(@PathVariable String source, @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo) {
        Map<String, List<FansGroupVo>> map = searchService.searchRecommend(commonUserInfoDo);

      return ResultFactory.success(map);
    }

}

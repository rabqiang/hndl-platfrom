//package com.hndl.cn.activity.sys.business.library.controller;
//
//import com.hndl.cn.activity.sys.business.library.service.HappyLibraryService;
//import com.hndl.cn.activity.sys.business.library.vo.IncreaseVoteCountByKeyVo;
//import com.hndl.cn.activity.sys.business.library.vo.IncreaseVoteCountVo;
//import com.hndl.cn.activity.sys.constants.ActivitySysConstants;
//import com.hndl.cn.activity.sys.exception.ActivitySysException;
//import com.hndl.cn.base.annotation.auth.AuthPassport;
//import com.hndl.cn.base.annotation.auth.CurrentUser;
//import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
//import com.hndl.cn.base.properties.BasePropertiesUtil;
//import com.hndl.cn.base.result.Result;
//import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
//import jdk.nashorn.internal.ir.annotations.Ignore;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import javax.validation.Valid;
//
///**
// * @Classname 赵俊凯
// * @Description TODO
// * @Date 2019/3/31 18:35
// * @Created by 湖南达联
// */
//@RestController
//@RequestMapping("/happy/library")
//public class HappyLibraryController {
//
//    @Resource
//    private HappyLibraryService happyLibraryService;
//
//    private String secretKey = BasePropertiesUtil.getPropertyValue("secret_key");
//
//    @AuthPassport(validate = false)
//    @GetMapping("/findHappyLibraryByVersion")
//    @CrossOrigin
//    public Result<Object> findHappyLibraryByVersion(@Ignore @CurrentUser CommonUserInfoDo commonUserInfoDo){
//        return happyLibraryService.findHappyLibraryByVersion(commonUserInfoDo == null ? null : commonUserInfoDo.getSysUniId());
//    }
//
//    @AuthPassport
//    @PostMapping("/increaseVoteCount")
//    @CrossOrigin
//    public Result<Object> increaseVoteCount(@Ignore @CurrentUser CommonUserInfoDo commonUserInfoDo,
//                                                           @Valid @RequestBody IncreaseVoteCountVo increaseVoteCountVo){
//        return happyLibraryService.increaseVoteCount(increaseVoteCountVo.getVersion(),increaseVoteCountVo.getGroupId(),
//                commonUserInfoDo.getSysUniId(), ActivitySysConstants.HAPPY_LIBRARY_VOTE_NUMBER);
//    }
//
//
//    @PostMapping("/increaseVoteCountByKey")
//    @CrossOrigin
//    public Result<Object> increaseVoteCountByKey(@Valid @RequestBody IncreaseVoteCountByKeyVo increaseVoteCountVo){
//        if(!secretKey.equals(increaseVoteCountVo.getKey())){
//            throw new ActivitySysException(PublicExceptionCodeEnum.EX_JURISDICTION_LESS.getCode());
//        }
//
//        return happyLibraryService.increaseVoteCountByKey(increaseVoteCountVo.getVersion(),increaseVoteCountVo.getGroupId(),increaseVoteCountVo.getVoteCount());
//    }
//
//}

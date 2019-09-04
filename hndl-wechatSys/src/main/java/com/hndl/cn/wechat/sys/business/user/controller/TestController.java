//package com.hndl.cn.wechat.sys.business.room.controller;
//
//import com.hndl.cn.base.annotation.auth.AuthPassport;
//import com.hndl.cn.base.annotation.auth.CurrentUser;
//import com.hndl.cn.base.result.Result;
//import com.hndl.cn.base.result.ResultFactory;
//import com.hndl.cn.dao.enums.bean.CommonUserInfoDo;
//import com.hndl.cn.dao.enums.mapper.TestTableDoMapper;
//import com.hndl.cn.wechat.sys.business.room.manager.CommonUserInfoManager;
//import jdk.nashorn.internal.ir.annotations.Ignore;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//
//
///**
// * @Classname 赵俊凯
// * @Description TODO
// * @Date 2019/3/18 13:10
// * @Created by 湖南达联
// */
//@RestController
//@RequestMapping("/test")
//public class TestController {
//
////    @Resource
////    private TestTableDoMapper testTableDoMapper;
////
////    @Resource
////    private CommonUserInfoManager commonUserInfoManager;
//    @AuthPassport
//    @GetMapping("/findById")
//    public Result<Object> findById(@CurrentUser CommonUserInfoDo commonUserInfoDo){
//         return ResultFactory.success(commonUserInfoDo);
////        return ResultFactory.success(testTableDoMapper.selectByPrimaryKey(1L));
//    }
//}

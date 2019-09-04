package com.hndl.cn.mghd.sys.business.message.service.impl;

import com.hndl.cn.base.enums.message.FeedbackEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.mghd.sys.business.message.service.UserFeedbackService;
import com.hndl.cn.mghd.sys.business.message.vo.UserFeedbackVo;
import com.hndl.cn.mghd.sys.business.resources.service.ResourcesService;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import com.hndl.cn.mghd.sys.exception.MghdSysExceptionEnums;
import com.hndl.cn.mongodb.manager.message.bean.UserFeedbackDo;
import com.hndl.cn.mongodb.manager.message.manager.UserFeedbackManager;
import com.hndl.cn.utils.date.LocalDateUtil;
import com.hndl.cn.utils.mobile.MobileUtil;
import com.hndl.cn.utils.string.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/5/25 18:01
 * @Created by 湖南达联
 */
@Service
public class UserFeedbackServiceImpl implements UserFeedbackService {
    private static final Logger log = LoggerFactory.getLogger(UserFeedbackServiceImpl.class);
    @Resource
    private UserFeedbackManager userFeedbackManager;

    @Resource
    ResourcesService resourcesService;

    /**
     * 新增建议信息
     *
     * @param userUniId
     * @param feedbackEnums
     * @param userFeedbackVo
     * @return
     */
    @Override
    public Result<String> insertUserFeedback(Long userUniId, String objId, FeedbackEnums feedbackEnums, UserFeedbackVo userFeedbackVo) {
        UserFeedbackDo userFeedbackDo = new UserFeedbackDo();
        userFeedbackDo.setUserUniId(userUniId);//设置创建人id
        if (objId.equals(userUniId.toString())) {
            log.error("========================用户不能举报自己====================");
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_NOT_FEEDBACK_NOT_ME.getCode());
        }
        //先查询该用户已经举报该内容或者用户,举报就直接返回重复举报,没有就添加进去
        if (userFeedbackManager.findUserFeedbackByObjId(userUniId, objId) != null) {
            log.error("========================用户已经举报过" + objId + "对象信息=====================");
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_NOT_FEEDBACK_EXCEPTION.getCode());
        } else {
            userFeedbackDo.setObjId(objId);
        }
        userFeedbackDo.setCreateTime(LocalDateUtil.localDateToMilliSecond(LocalDate.now())); //创建时间
        userFeedbackDo.setContentType(feedbackEnums.getTypeId()); //反馈类型
        userFeedbackDo.setContentText(userFeedbackVo.getContentText()); //反馈内容
//            在建议必须传入qq号码, 在举报不需要添加QQ号码
        if (feedbackEnums.getTypeId().equals(FeedbackEnums.FANS_SUGGESTIONS.getTypeId()) && userFeedbackVo.getQq() != null) {
            userFeedbackDo.setQq(userFeedbackVo.getQq());//QQ号码
        }
        //把存储的临时存储的图像注册并返回注册地址
        List<String> imgUrlList = new ArrayList<>();
        //判断用户传递进来的图片不为空

        if (userFeedbackVo.getImg_list() != null) {
            imgUrlList = userFeedbackVo.getImg_list();
        }
        //将图片保存到反馈
        userFeedbackDo.setImgList(imgUrlList);
        //判断用户将手机号传递,判断手机号不能为空
        if (StringUtils.isNotEmpty(userFeedbackVo.getPhone())) {
            String mobile = MobileUtil.validateMobile(userFeedbackVo.getPhone());
            userFeedbackDo.setPhone(userFeedbackVo.getPhone());
        }

        userFeedbackManager.insertUserFeedback(userFeedbackDo);

        return ResultFactory.success("提交成功,工作人员会尽快联系您!");
    }

}

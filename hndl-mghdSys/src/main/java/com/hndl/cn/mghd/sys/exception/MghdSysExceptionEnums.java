package com.hndl.cn.mghd.sys.exception;

import com.hndl.cn.base.enums.PublicExceptionCodeEnum;

/**
 * @Classname 赵俊凯
 * @Description wecatsys业务异常类，异常码8位，16开头
 * @Date 2019/3/20 9:32
 * @Created by 湖南达联
 */
public enum MghdSysExceptionEnums {

    MGHD_SYS_EXCEPTION_ENUMS("16000000","这是一个例子，请参考"),

    MGHD_SYS_PAY_COIN_EXCEPTION("16010101","充值用户快乐币添加失败"),

    MGHD_SYS_ADD_USER__EXCEPTION("16020201","用户创建失败"),

    MGHD_SYS_FANS_NULL_EXCEPTION("16030202","粉丝会不存在"),
    MGHD_SYS_FANSGOUP_NOT_FIND_EXCEPTION("16030203","没有找到用户加入的粉丝会"),
    MGHD_SYS_ADD_FANSRELATION_EXCEPTION("16030101","加入粉丝会失败"),
    MGHD_SYS_ADD_FANSRELATION_MAX_EXCEPTION("16030102","加入粉丝会已超上限"),
    MGHD_SYS_ADD_INTEGRALCOUNT_EXCEPTION("16030103","粉丝打榜失败"),
    MGHD_SYS_ADD_COINCOUNT_EXCEPTION("16030104","粉丝比心失败"),
    MGHD_SYS_ADD_GETTINGLOVECOUNT_EXCEPTION("16030105","粉丝送爱心失败"),
    MGHD_SYS_ADD_IS_GUARD_EXCEPTION("16030106","已经守护过该明星了"),
    MGHD_SYS_EXSIT_FANSRELATION_EXCEPTION("16030107","用户已在粉丝会"),
    MGHD_SYS_ADD_MAX_GUARD_EXCEPTION("16030108","今日守护已达上限"),

    /**
     * 个人基本信息
     */
    MGHD_SYS_USER_EMPIRICAL_LOG_NULL_EXCEPTION("16040201","查询用户在APP上的个人信息失败"),
    MGHD_UPDATE_USER_IMG_URL_FIND("16040202","头像格式有误,暂只支持jpg/png图片"),
    MGHD_UPDATE_USER_NICKNAME_LENGTH_OVERSIZE_EXCEPTION("16040203","昵称过长"),
    MGHD_UPDATE_USER_NICKNAME_IS_EXIST_EXCEPTION("16040205","昵称已被占用了啦！"),
    MGHD_UPDATE_USER_MOBILE_FIND("16040204","用户传入的手机号有误"),
    /**
     * 用户已经绑定手机号
     */
    MGHD_SYS_USER_PHONE_NUM_NOT("16040206","您输入的验证码错误，请查正后输入"),
    MGHD_SYS_USER_PHONE_NUM_NOT_NULL("16040207","请确定是否输入正确的手机号"),
    MGHD_SYS_USER_PHONE_NUM_NOT_IS_ME("16040208","您之前就绑定该手机号"),

    MGHD_SYS_INIT_STAR_RANK_EX("16050101","初始化明星榜单失败"),
    MGHD_SYS_INIT_APP_HOME_EX("16050901","首页数据加载失败"),

    //常态任务异常
    /**
     * (师徒系统中)用户已经拜过师
     */
    MGHD_SYS_USER_MASTER_NOT_NULL("16060201","您已经拜过师父"),
    MGHD_SYS_USER_MASTER_ID_NOT_ME("16060202","您不能拜你的徒弟为师父"),
    MGHD_SYS_USER_LAST_ID_NOT_NULL("16060203","邀请码错误"),
    MGHD_SYS_NOT_FIND_USER_EXCEPTION("16060204","用户不存在"),
    MGHD_SYS_USER_MASTER_NOT_IS_ME("16060205","用户不能拜自己为师"),
    MGHD_SYS_USER_MASTER_LEVEL_GREATER_THREE ("16060206  ","用户等级必须大于等于三级,才能拜师"),
    /**
     * 用户已经领取过该徒弟的收徒奖励
     */
    MGHD_SYS_USER_APPRENTICE_NOT_NULL("16060207","用户已经领取过该徒弟的收徒奖励"),
    /**
     * 用户已经关注该公众号
     */
    MGHD_SYS_USER_PUBLIC_ADDRESS_NOT_NULL("16060208","用户已经关注该公众号"),



    MGHD_SYS_INTEGRAL_NOT_ENOUGH("16070101","积分余额不足"),
    MGHD_SYS_INTEGRAL_NOT_FIND("16070102","用户统计信息查询失败"),
    MGHD_SYS_COIN_NOT_ENOUGH("16070102","快乐币余额不足"),

    //打call
    MGHD_SYS_CALL_EXCEPTION("16080101","打call失败"),
    MGHD_SYS_NOT_FIND_CALL_EXCEPTION("16080102","call数据不存在"),
    MGHD_SYS_PIC_DATA_EXCEPTION("16080103","图片URL有误"),
    MGHD_SYS_CALL_USER_NOT_IS_ME_EXCEPTION("16080104","不是用户自己打call"),
    //点赞
    MGHD_SYS_FIND_LIKE_EXCEPTION("16090101","查询点赞数据失败"),
    MGHD_SYS_IS_LIKE_EXCEPTION("16090102","已经点赞"),



    //评论
    MGHD_SYS_NOT_COMMENT_EXCEPTION("16100100","评论不存在"),
    MGHD_SYS_NOTUSER_COMMENT_EXCEPTION("16100101","回复人信息有误"),
    MGHD_SYS_NOT_REPETITION_EXCEPTION("16100102","不能自己回复自己"),
    MGHD_SYS_COMMENT_BELONG_TO_ME_OR_NOT_FIND_EXCEPTION("16100103","不是自己的评论或评论数据不存在"),
    MGHD_SYS_NOT_CALL_EXCEPTION("16100104","call不存在"),

    //用户消息
    MGHD_SYS_NOT_MESSAGE_EXCEPTION("16100200","该用户没有消息"),

    //用户关注
    MGHD_SYS_NOT_FOLLOW_EXCEPTION("16100300","关注用户不存在"),

    MGHD_SYS_EQUALITY_FOLLOW_EXCEPTION("16100301","不能自己关注自己"),

    MGHD_SYS_REPETITION_FOLLOW_EXCEPTION("16100302","不能重复关注"),

    //菜单按钮
    MGHD_SYS_MENU_NULLVERSION_EXCEPTION("16100001","version传输数据为空"),

    MGHD_SYS_MENU_NULLPARAMETERVALUE_EXCEPTION("16100002","parametervalue为空"),

    MGHD_SYS_MENU_NULLCOMMONUSERMENUINFO_EXCEPTION("16100003","commonUserMenuInfoDoList为空"),

    MGHD_SYS_GET_FAILURE_EXCEPTION("16110001","领取失败"),

    //用户反馈异常
    MGHD_SYS_NOT_FEEDBACK_EXCEPTION("16120101","重复举报"),
    MGHD_SYS_NOT_FEEDBACK_NOT_ME("16120102","您不能举报自己"),
    //资源上传（illegal：非法的）
    MGHD_SYS_FILE_ILLEGAL_EXCEPTION("16130101","图片格式有误,暂只支持jpg/gif/png图片"),
    MGHD_SYS_PIC_IS_NULL_EXCEPTION("16130102","图片为空!"),
    MGHD_SYS_PIC_UPLOAD_FAIL_EXCEPTION("16130103","图片上传失败!请稍后再试或者换一张图片试试!"),

    //话题
    MGHD_SYS_TOPIC_NOT_FIND_EXCEPTION("16140101","话题不存在！"),

    MGHD_SYS_TOPIC_COMMENT_CONTENT_NULL("16140102","内容不能为空"),

    MGHD_SYS_TOPIC_COMMENT_NULL("16140103","评论不存在！")


    ;





    private String code;

    private String msg;

    MghdSysExceptionEnums(String code, String message) {
        this.code = code;
        this.msg = message;
    }

    public String getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }

    public static String getExceptionMsg(String code){
        MghdSysExceptionEnums exceptionEnums = null;
        for(MghdSysExceptionEnums enums : MghdSysExceptionEnums.values()){
                if(enums.code.equals(code)){
                      return enums.getMsg();
                }
        }

        if(exceptionEnums == null){
           return PublicExceptionCodeEnum.getMsg(code);
        }
        return "";
    }
}

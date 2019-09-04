package com.hndl.cn.mghd.admin.exception;

import com.hndl.cn.base.enums.PublicExceptionCodeEnum;

/**
 * @Classname 赵俊凯
 * @Description wecatsys业务异常类，异常码8位，16开头
 * @Date 2019/3/20 9:32
 * @Created by 湖南达联
 */
public enum MghdAdminExceptionEnums {

    MGHD_ADMIN_EXCEPTION_ENUMS("17000000","这是一个例子，请参考"),

    MGHD_ADMIN_LOGIN_NAME_EXCEPTION("17010101","用户名以及存在"),

    MGHD_ADMIN_USER_NOT_FIND_EXCEPTION("17010102","用户不存在"),

    MGHD_ADMIN_USER_NOT_DEL_ME_EXCEPTION("17010103","不能删除自己"),

    MGHD_ADMIN_USER_NOT_RE_ME_EXCEPTION("17010104","不能重置自己的密码"),

    MGHD_ADMIN_LOGIN_EX("17010105","请不要重复登陆"),

    MGHD_ADMIN_ROLE_NOT_FIND_EXCEPTION("17010201","角色不存在"),

    MGHD_ADMIN_USER_ROLE_IS_TRUE_EXCEPTION("17010202","用户角色已经绑定"),

    MGHD_ADMIN_USER_ROLE_IS_NOT_EXCEPTION("17010203","用户角色没有绑定"),

    MGHD_ADMIN_PATH_EXCEPTION("17010301","错误的路径"),

    MGHD_ADMIN_ROLE_IS_NOT_EXCEPTION("17010302","角色名不能为重复"),

    //===call管理==

    MGHD_CALL_NOT_FIND_EXCEPTION("17010401","Call不存在或已被删除！"),

    //===call管理===

    //****图片**
    MGHD_SYS_PIC_UPLOAD_FAIL_EXCEPTION("17010501","图片上传失败" ),
    //****图片***

    //****粉丝会***
    MGHD_STAR_FANS_GROUP_IS_NULL_EXCEPTION("17010601","粉丝会不存在！"),
    MGHD_STAR_FANS_GROUP_IS_DELETE_EXCEPTION("17010602","粉丝会已删除！"),
    //****粉丝会***

    MGHD_UPDATE_INTEGRAL_IS_NOT_LESS_ZERO("17020101", "操作完后积分不能小于零"),

    MGHD_UPDATE_CONICOUNT_IS_NOT_LESS_ZERO("17020102", "操作完后快乐币不能小于零"),

    MGHD_UPDATE_USER_INTEGRAL_IS_NULL("17020103", "操作增减积分的用户不存在"),

    MGHD_UPDATE_USER_CONICOUNT_IS_NULL("17020104", "操作增减快乐币的用户不存在"),
    MGHD_COLSE_USER_IS_NULL("17020104", "封号用户不存在"),

    MGHD_MESSAGE_SYS_EX_EASE_MOB_CREATE_RUN_TIME_ERROR("17030101","正在发送消息，请稍后"),

    MGHD_ADMIN_PIC_DATA_EXCEPTION("17030102", "图片有误"),

    /*   ****  Banner start ****  */
    MGHD_ADMIN_BANNER_ENUM_NOTFOUND("17030103", "Banner类型有误"),

    MGHD_ADMIN_DATE_ERROR("17030104","开始时间不能大于结束时间"),

    MGHD_ADMIN_DATE_TOO_LONG("17030105","查询时间段过长, 请输入一个月内的时间"),

    MGHD_ADMIN_BANNER_NOTFOUND("17030106","此Banner不存在！"),
    /*   ****  Banner end ****  */

    /*   ****  UserMenu start ****  */
    MGHD_ADMIN_USER_MENU_NOTFOUND("17030107", "没有找到此菜单"),

    MGHD_ADMIN_USER_MENU_DATA_ERROR("17030108", "传入参数异常"),
    /*   ****  UserMenu start ****  */

    /*   ****  ShopAppData start ****  */

    MGHD_ADMIN_SHOP_APP_DATA_ERROR("17030109", "传入参数异常"),
    /*   ****  ShopAppData start ****  */

    /* ============话题=========*/
    MGHD_ADMIN_TOPIC_IS_NULL_EXCEPTION("17040101","话题不存在！"),
    MGHD_ADMIN_TOPIC_RECOMMEN_IS_MAX_EXCEPTION("17040102","推荐话题已达上限！"),
    MGHD_ADMIN_TOPIC_NOTRECOMMEN_IS_MAX_EXCEPTION("17040103","非推荐话题已达上限！"),
    MGHD_ADMIN_TOPIC_IS_NOT_PASS_EXCEPTION("17040104","话题没通过！"),
    MGHD_ADMIN_TOPIC_IS_UNPUBLISH_EXCEPTION("17040105","话题未发布！"),
    MGHD_ADMIN_TOPIC_PUBLISHED_EXCEPTION("17040106","话题已发布！"),
    MGHD_ADMIN_TOPIC_NOT_IS_WAITTING_EXCEPTION("17040107","话题非待审核状态！"),
    MGHD_ADMIN_TOPIC_IS_WAITTING_EXCEPTION("17040108","话题待审核中！"),
    MGHD_ADMIN_TOPIC_TITLE_EXCEPTION("17040109","话题重名！"),


    /* ============补单=========*/
    MGHD_ADMIN_RECEIPTDATA_NOT_FIND_EXCEPTION("17050101","apple票据信息未找到！"),
    MGHD_ADMIN_PAYSYSTRADE_NOT_FIND_EXCEPTION("17050102","没有找到预下单信息！"),
    MGHD_ADMIN_USER_NOT_EQUALLY_EXCEPTION("17050103","预下单用户与异常数据用户不一致！"),
    MGHD_ADMIN_ORDER_IS_PAY_EXCEPTION("17050104","订单已是支付状态!"),
    MGHD_ADMIN_REPLACEMENT_ORDER_IS_EXIST_EXCEPTION("17050105","已有补单记录!"),
    MGHD_ADMIN_APPLE_ORDER_NOT_SUCCE_EXCEPTION("17050106","通过票据获取状态非成功状态！"),
    MGHD_ADMIN_APPLE_PRODUCTID_ERROR_EXCEPTION("17050107","productId异常！"),
    MGHD_ADMIN_APPLE_MONEY_EQUALLY_EXCEPTION("17050108","本地下单金额不一致！"),
    MGHD_ADMIN_PAYSYSTRADE_UPDATE_FAIL_EXCEPTION("17050109","订单操作失败！"),
    MGHD_ADMIN_APPLE_GET_PAY_STATUS_EXCEPTION("17050110","从苹果获取订单数据异常！"),
    MGHD_ADMIN_NOT_IS_APPLE_PAY_EXCEPTION("17050111","非苹果订单！"),
    MGHD_ADMIN_APPLE_NOT_FIND_DATE_EXCEPTION("17050112","无法从数据中获取关于支付的productId"),

    /*========福利商城============*/

    MGHD_ADMIN_OF_VALUE_NOT_ENOUGH("17060101", "输入的用户没有参与此次福利"),
    MGHD_ADMIN_START_DATE_ERROR("17060102","传入的开始时间有误,必须大于当日凌晨时间"),
    MGHD_ADMIN_END_DATE_ERROR("17060103","传入的结束时间有误"),
    MGHD_ADMIN_WELFARE_DATA_EXCEPTION("17060104","传入的图片有误"),
    MGHD_ADMIN__VALUE_NOT_ENOUGH("17060105", "输入的用户目前没有助力值"),
    MGHD_ADMIN_WELFARENUMBER__NOT_ZERO("17060106", "此商品已经开奖或者开奖失败,不能再调整商品信息"),
    MGHD_ADMIN__WELFARENUMBER_SORTCOUNT_LESS_PRIZECOUNT("17060107","设置商品前多少名可中奖必须大于奖品数"),

    ;



    private String code;

    private String msg;

    MghdAdminExceptionEnums(String code, String message) {
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
        MghdAdminExceptionEnums exceptionEnums = null;
        for(MghdAdminExceptionEnums enums : MghdAdminExceptionEnums.values()){
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

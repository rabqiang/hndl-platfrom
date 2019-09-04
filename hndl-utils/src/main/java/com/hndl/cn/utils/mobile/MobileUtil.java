package com.hndl.cn.utils.mobile;

public class MobileUtil {

    /**
     * 判断传入的参数号码为哪家运营商
     *
     * @param mobile
     * @return 运营商名称
     */
    public static String validateMobile(String mobile) {
        String returnString = "";
        if (mobile == null || mobile.trim().length() != 11) {
            return "未知非11位手机号";        //mobile参数为空或者手机号码长度不为11，错误！  
        }
        String pre = mobile.trim().substring(0, 3);
        String[] yidongStr = {"134", "135", "136", "137", "138", "139", "150",
                "151", "152", "157", "158", "159"
                , "182", "183", "184", "187", "188"
                , "147", "178", "184"};

        for (String yidong : yidongStr) {
            if (pre.equals(yidong)) {
                return "中国移动";//中国移动
            }
        }
        String[] liantongStr = {"130", "131", "132",
                "155", "156"
                , "185", "186"
                , "145", "176"};

        for (String liantong : liantongStr) {
            if (pre.equals(liantong)) {
                return "中国联通";//中国移动
            }
        }

        String[] dianxinStr = {"133",
                "153", "173", "177"
                , "180", "181", "189"};
        for (String dianxin : dianxinStr) {
            if (pre.equals(dianxin)) {
                return "中国电信";//中国移动
            }
        }
        if ("".equals(returnString.trim())) {
            returnString = "未知运营商 " + pre;   //未知运营商
        }
        return returnString;
    }


    /**
     * 手机号星号代替中间号码，前后留3位
     * @param phoneNum 用户手机号
     * @return  替换后的手机号
     */
    public static String validatePhoneNum(String phoneNum) {
        String phoneNumber;
        //1. 判断传进来的手机号为空或者手机号码长度不为11,都为未绑定
        if (phoneNum == null || phoneNum.length() != 11) {
            return null;
        }
        //通过正则检验,替换中间4位数,返回替换值
        phoneNumber = phoneNum.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");

        return phoneNumber;
    }


}

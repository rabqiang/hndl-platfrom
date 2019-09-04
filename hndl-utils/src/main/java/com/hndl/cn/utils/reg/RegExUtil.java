package com.hndl.cn.utils.reg;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @author : 孙超飞
 * @title :
 * @description :
 * @copyright :润投科技
 * @date : 2018-01-03 16:05
 */

public class RegExUtil {
    /**
     * 特殊字符
     */
    private static final String SPECIAL_CHARACTER_REG = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";

    private static final Pattern SPECIAL_CHARACTER_PATTERN = Pattern.compile(SPECIAL_CHARACTER_REG);

    private static final String TAG_CHARACTER_REG_D = "(^[1-9][0-9]*){1}([,][1-9][0-9]*){0,2}";

    private static final String TAG_CHARACTER_REG_F = "(^[1-9][0-9]*){1}([;][1-9][0-9]*){0,2}";

    private static final String TAG_CHARACTER_REG_D_6 = "(^[1-9][0-9]*){1}([,][1-9][0-9]*){0,5}";

    private static final String TAG_CHARACTER_REG_F_D = "(^[1-9][0-9]*){1}([,|;][1-9][0-9]*){0,5}";

    private static final Pattern TAG_CHARACTER_PATTERN_F_D = Pattern.compile(TAG_CHARACTER_REG_F_D);

    private static final Pattern TAG_CHARACTER_PATTERN_D_6 = Pattern.compile(TAG_CHARACTER_REG_D_6);

    private static final Pattern TAG_CHARACTER_PATTERN_D = Pattern.compile(TAG_CHARACTER_REG_D);

    private static final Pattern TAG_CHARACTER_PATTERN_F = Pattern.compile(TAG_CHARACTER_REG_F);

    private  static  final  Pattern IMG_URL = Pattern.compile("http:/\\/mghd.oss-cn-hangzhou.aliyuncs.com\\/temp\\/min_img\\/+(\\d{4}-\\d{2}-\\d{2})\\/\\d{18}.(jpg|jpeg|png|gif)");


    /**
     * 除去特殊字符，除去逗号
     */
    private static final String SPECIAL_CHARACTER_WITHOUT_COMMA_REG = "[`~!@#$%^&*()+=|{}':;'\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";

    private static final Pattern SPECIAL_CHARACTER_WITHOUT_COMMA_PATTERN = Pattern
            .compile(SPECIAL_CHARACTER_WITHOUT_COMMA_REG);

    /**
     * 除去特殊字符，除去逗号和分号
     */
    private static final String SPECIAL_CHARACTER_WITHOUT_COMMA_SEMICOLON_REG = "[`~!@#$%^&*()+=|{}':'\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";

    private static final Pattern SPECIAL_CHARACTER_WITHOUT_COMMA_SEMICOLON_PATTERN = Pattern
            .compile(SPECIAL_CHARACTER_WITHOUT_COMMA_SEMICOLON_REG);

    /**
     * 中国其他地区号码
     */
    private static final String CHINA_OTHER_PHONE_REG = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|17[0-9]|18[0|1|2|3|4|5|6|7|8|9])\\d{8}$";

    private static final Pattern CHINA_OTHER_PHONE_PATTERN = Pattern.compile(CHINA_OTHER_PHONE_REG);

    /**
     * 中国香港号码
     */
    private static final String CHINA_HK_PHONE_REG = "^(5|6|8|9)\\d{7}$";

    private static final Pattern CHINA_HK_PHONE_PATTERN = Pattern.compile(CHINA_HK_PHONE_REG);

    public static boolean checkSpecialCharacter(String content) {
        if (!StringUtils.isBlank(content)) {
            if (content.length() > 20) {
                return true;
            }
        }
        Matcher m = SPECIAL_CHARACTER_PATTERN.matcher(content);
        return m.find();
    }

    /**
     * 逗号除外
     * 
     * @param content
     * @return
     */
    public static boolean checkSpecialCharacterWithoutComma(String content) {

        if (!StringUtils.isBlank(content)) {
            if (content.length() > 20) {
                return true;
            }
        }
        Matcher m = SPECIAL_CHARACTER_WITHOUT_COMMA_PATTERN.matcher(content);
        return m.find();
    }

    /**
     * 逗号和分号除外
     *
     * @param content
     * @return
     */
    public static boolean checkSpecialCharacterWithoutCommaAndSemicolon(String content) {

        if (!StringUtils.isBlank(content)) {
            if (content.length() > 20) {
                return true;
            }
        }
        Matcher m = SPECIAL_CHARACTER_WITHOUT_COMMA_SEMICOLON_PATTERN.matcher(content);
        return m.find();
    }

    /**
     * 大陆号码或香港号码均可
     */
    public static boolean isPhoneLegal(String str) throws PatternSyntaxException {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        return isChinaPhoneLegal(str) || isChinaHKPhoneLegal(str);
    }

    /**
     * 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数 此方法中前三位格式有： 13+任意数 15+除4的任意数 18+除1和4的任意数
     * 17+除9的任意数 147
     */
    public static boolean isChinaPhoneLegal(String str) throws PatternSyntaxException {
        Matcher m = CHINA_OTHER_PHONE_PATTERN.matcher(str);
        return m.matches();
    }

    /**
     * 香港手机号码8位数，5|6|8|9开头+7位任意数
     */
    public static boolean isChinaHKPhoneLegal(String str) throws PatternSyntaxException {
        Matcher m = CHINA_HK_PHONE_PATTERN.matcher(str);
        return m.matches();
    }

    public static boolean isTagRegD(String str) throws PatternSyntaxException {
        Matcher m = TAG_CHARACTER_PATTERN_D.matcher(str);
        return m.matches();
    }

    public static boolean isTagRegF(String str) throws PatternSyntaxException {
        Matcher m = TAG_CHARACTER_PATTERN_F.matcher(str);
        return m.matches();
    }

    public static boolean isTagRegFD(String str) throws PatternSyntaxException {
        Matcher m = TAG_CHARACTER_PATTERN_F_D.matcher(str);
        return m.matches();
    }

    public static boolean isTagRegD6(String str) throws PatternSyntaxException {
        Matcher m = TAG_CHARACTER_PATTERN_D_6.matcher(str);
        return m.matches();
    }

    /**
     * 校验是本项目临时图片url
     * @param imgUrl
     * @return
     */
   public static  boolean isImgUrl(String imgUrl){
       if (null == imgUrl){
           return false;
       }
       return IMG_URL.matcher(imgUrl).matches();
   }

  public static void main(String[] args) {
    //
    System.out.println(isImgUrl(null));
  }
}

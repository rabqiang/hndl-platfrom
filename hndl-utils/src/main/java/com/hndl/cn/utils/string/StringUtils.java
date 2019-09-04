package com.hndl.cn.utils.string;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *
 * 【标题】: String查关工具类
 * 【描述】: 
 * 【版权】: 湖南达联
 * 【作者】: 赵俊凯
 * 【时间】: 2017年6月5日 下午2:01:36
 * </pre>
 */
public class StringUtils extends org.apache.commons.lang.StringUtils {

    private static String string = "1234567890abcdefghijklmnopqrstuvwxyz";

    private static int RANDOM_STR_SIZE = 10;

    private static int getRandom(int count) {
        return (int) Math.round(Math.random() * (count));
    }

    public static String getRandomString(){
        return getRandomString(RANDOM_STR_SIZE);
    }

    public static String getRandomString(Integer length){
        StringBuffer sb = new StringBuffer();
        int len = string.length();
        for (int i = 0; i < length; i++) {
            sb.append(string.charAt(getRandom(len-1)));
        }
        return sb.toString();
    }



    /**
     * 将字符串分割转换为长整数列表
     * 
     * @param str
     *            需要分割转换的字符串
     * 
     * @param splitKey
     *            分隔符
     * 
     * @return 长整数列表
     */
    public static List<Long> strToIdList(String str, String splitKey) {
        List<Long> ids = new ArrayList<Long>();

        if (StringUtils.isNotBlank(str) && StringUtils.isNotBlank(splitKey)) {

            String[] strIds = str.split(splitKey);

            if (strIds != null) {
                for (String strId : strIds) {
                    try {
                        Long id = Long.parseLong(strId);
                        ids.add(id);
                    } catch (Exception e) {

                    }

                }
            }
        }

        return ids;

    }

    /**
     * null值处理
     * 
     * @Description
     * @author 张国栋
     * @param str
     * @return
     */
    public static String nvl(String str) {
        if (str == null) {
            return "";
        } else {
            return str;
        }
    }
    
    /**
     * toString，对于null值不做处理
     * @Description 
     * @author 张国栋
     * @param obj
     * @return
     */
    public static String valueOf(Object obj){
        return obj == null ? null : obj.toString();
    }

    /**
     * 将驼峰结构转化为下划线结构
     * 
     * @Description
     * @author 赵俊凯
     * @param str
     * @return
     */
    public static String convertHumpToUnderline(String str) {
        char[] cArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : cArray) {
            if (!Character.isUpperCase(c)) {
                sb.append(c);
            } else {
                sb.append("_").append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }

    /**
     * 将版本号转未Int
     * @param version
     * @return
     */
    public static Integer stringToInteger(String version){
        if(StringUtils.isBlank(version)){
            return 0;
        }
        return  Integer.valueOf(version.replace(".",""));
    }

    /**
     * 截取内容，只保留10个字多余用...替换<br/>
     * exp: 内容“123456789012345”
     * @param content 输入的内容
     * @return 返回被截取后的内容
     */
    public static String subContent(String content){
        if (StringUtils.isBlank(content)) {
            return content;
        }
        if (content.length() > 20) {
            return  content.substring(0,20)+"...";
        }
        return content;
    }


    /**
     * 截取内容，只保留length个字多余用...替换<br/>
     * exp: 内容“123456789012345”
     * @param content 输入的内容
     * @return 返回被截取后的内容
     */
    public static String subContent(String content,Integer length){
        if (StringUtils.isBlank(content)) {
            return content;
        }
        if (content.length() > length) {
            return  content.substring(0,length)+"...";
        }
        return content;
    }

    /**
     * 过滤emoji 或者 其他非文字类型的字符
     * //emoji正则"[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]"
     * @param source
     * @return
     */
    public static String filterEmoji(String source)
    {
        if (isBlank(source)) {
            return source;
        }
        int len = source.length();
        StringBuilder buf = new StringBuilder(len);
        for (int i = 0; i < len; i++)
        {
            char codePoint = source.charAt(i);
            if (isNotEmojiCharacter(codePoint))
            {
                buf.append(codePoint);
            } else{
                buf.append("*");
            }
        }
        return buf.toString();
    }


    /**
     * 获取指定字符串的次数
     * @param str
     * @param tag
     * @return
     */
    public static int getStrCount(String str, String tag) {
        int index = 0;
        int count = 0;
        while ((index = str.indexOf(tag)) != -1 ) {
            str = str.substring(index + tag.length());
            count++;
        }
        return count;
    }


    private static boolean isNotEmojiCharacter(char codePoint)
    {
        return (codePoint == 0x0) ||
                (codePoint == 0x9) ||
                (codePoint == 0xA) ||
                (codePoint == 0xD) ||
                ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) ||
                ((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) ||
                ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
    }

  public static void main(String[] args) {
    //
    String s = "1234*&*&（（*\uD83D\uDE04你好蔡徐坤";

      String emoji = filterEmoji(s);
      System.out.println(emoji);
    System.out.println(s.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", "*"));
  }
}

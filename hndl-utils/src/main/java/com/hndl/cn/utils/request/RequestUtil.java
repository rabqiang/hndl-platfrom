package com.hndl.cn.utils.request;

import com.hndl.cn.utils.request.enums.BrowserTypeEnum;
import com.hndl.cn.utils.request.enums.DeviceTypeEnum;
import com.hndl.cn.utils.string.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/13 16:01
 * @Created by 湖南达联
 */
public class RequestUtil {

    /**
     * 获取用户请求url中的ip：port/工程名
     *
     * @param request
     * @return
     * @Description
     * @author 赵俊凯
     */
    public static String getServerHost(HttpServletRequest request) {
        String host = request.getHeader("HostPort");

        if (host == null || host.length() == 0 || "unknown".equalsIgnoreCase(host)) {
            return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                    + request.getContextPath();
        } else {
            return request.getScheme() + "://" + host + request.getContextPath();
        }

    }

    /**
     * 获取用户真实ip
     *
     * @param request
     * @return
     * @Description
     * @author 赵俊凯
     */
    public static String getClientIP(HttpServletRequest request) {
        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("HTTP_CLIENT_IP");
        }

        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("HTTP_X_FORWARDED_FOR");
        }

        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
                // 根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inet.getHostAddress();
            }
        }
        // 对于通过多个代理的情况，中第一个非unknown的有效IP字符串
        if (ipAddress != null && ipAddress.length() > 15) {
            if (ipAddress.indexOf(",") > 0) {
                String[] ipArray = ipAddress.split(",");
                for (String ip : ipArray) {
                    if (!"unknown".equalsIgnoreCase(ipAddress)) {
                        ipAddress = ip;
                        break;
                    }
                }
            }
        }
        return ipAddress;
    }

    /**
     * 获取浏览器类型
     *
     * @param request
     * @return
     * @Description
     * @author 赵俊凯
     */
    public static BrowserTypeEnum getBrowserType(HttpServletRequest request) {
        // 获取浏览器类型
        BrowserTypeEnum browserType = BrowserTypeEnum.OTHER_TYPE;
        String userAgent = request.getHeader("room-agent");
        // 待扩展TODO
        if (userAgent == null || userAgent.equals("")) {
            browserType = null;
        } else if (userAgent.indexOf("MSIE") > 0) {
            browserType = BrowserTypeEnum.IE_TYPE;
        } else if (userAgent.indexOf("Firefox") > 0) {
            browserType = BrowserTypeEnum.HUOHU_TYPE;
        } else if (userAgent.indexOf("Chrome") > 0) {
            browserType = BrowserTypeEnum.CHROME_TYPE;
        } else if (userAgent.indexOf("Safari") > 0) {
            browserType = BrowserTypeEnum.IE_PHONE_TYPE;
        } else if (userAgent.indexOf("Camino") > 0) {
            browserType = BrowserTypeEnum.OTHER_TYPE;
        } else if (userAgent.indexOf("Konqueror") > 0) {
            browserType = BrowserTypeEnum.OTHER_TYPE;
        }
        return browserType;
    }

    public static DeviceTypeEnum getDeviceType(HttpServletRequest request) {
        DeviceTypeEnum deviceType = DeviceTypeEnum.OTHER;
        String userAgent = request.getHeader("room-agent");
        if (userAgent.contains("Android")) {
            deviceType = DeviceTypeEnum.ANDROID;
        } else if (userAgent.contains("iPhone")) {
            deviceType = DeviceTypeEnum.IPHONE;
        } else if (userAgent.contains("iPad")) {
            deviceType = DeviceTypeEnum.IPAD;
        }

        return deviceType;
    }

    public static String getRequestPath(HttpServletRequest request) {
        if (request != null) {
            return request.getServletPath();
        }
        return null;
    }

    /**
     * 获取错误请求
     *
     * @Description
     * @author 赵俊凯
     * @param request
     * @return
     */
    public static String getErrorMsg(HttpServletRequest request) {
        String errorIp = RequestUtil.getClientIP(request);
        String errorPath = RequestUtil.getRequestPath(request);
        return "[error request]" + errorIp  + errorPath;
    }


    public static boolean checkVerifyCode(String verifyCode){
        return StringUtils.isNotBlank(verifyCode) || verifyCode.length() == 6 ||  StringUtils.isNumeric(verifyCode) ;
    }


    /**
     * 获取 request token的key
     * @param request
     * @param key
     * @return
     */
    public static String getRequestHeaderByKey(HttpServletRequest request,String key){
        return request.getHeader(key);
    }


    //判断该对象是否: 返回ture表示所有属性不为null  返回false表示不是所有属性都是null
    public static boolean isFieldNull(Object obj){
        if(obj == null){
            return false;
        }
        try {
            Class classz = obj.getClass();// 得到类对象
            Field[] fs = classz.getDeclaredFields();//得到属性集合

            for (Field f : fs) {//遍历属性
                f.setAccessible(true); // 设置属性是可以访问的(私有的也可以)
                Object val = f.get(obj);// 得到此属性的值
                if(val==null) {//只要有1个属性为空,那么就不是所有的属性值都为空
                    return false;
                }
            }
            return true;
        }catch (Exception e){
           e.printStackTrace();
        }
        return false;
    }

    /**
     * 是否是Ajax请求
     * @param request
     * @return
     */
    public static boolean isAjax(ServletRequest request){
        String header = ((HttpServletRequest) request).getHeader("X-Requested-With");
        if("XMLHttpRequest".equalsIgnoreCase(header)){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 获取POST请求中Body参数
     * @param request
     * @return 字符串
     */
    public static String getBodyParm(HttpServletRequest request) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String line = null;
        StringBuilder sb = new StringBuilder();
        try {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}

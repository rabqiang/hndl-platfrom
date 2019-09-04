package com.hndl.cn.utils.weibo;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/5/25 18:04
 * @Created by 湖南达联
 */
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.*;


public class WeiboLoginer {

    private HttpClient httpClient; //httpClient实例初始化



    public  WeiboLoginer() {

        //httpclient连接配置
        MultiThreadedHttpConnectionManager httpManager = new MultiThreadedHttpConnectionManager();
        HttpConnectionManagerParams connectParams = httpManager.getParams();
        connectParams.setConnectionTimeout(3000);
        connectParams.setDefaultMaxConnectionsPerHost(100);
        connectParams.setSoTimeout(3000);
        //httpclient参数配置
        HttpClientParams httpParams = new HttpClientParams();
        httpParams.setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
        httpParams.setVersion(HttpVersion.HTTP_1_1);
        //设置默认Header
        List<Header> headers = new ArrayList<Header>();
        headers.add(new Header("Content-Type", "application/x-www-form-urlencoded"));
        headers.add(new Header("Host", "login.sina.com.cn"));
        headers.add(new Header("User-Agent","Mozilla/5.0 (Windows NT 6.1; rv:25.0) Gecko/20100101 Firefox/25.0"));
        headers.add(new Header("API-RemoteIP", "192.168.0.1"));//伪造新浪验证IP
        headers.add(new Header("X-Forwarded-For","192.168.0.1"));//伪造真实IP
        headers.add(new Header("CLIENT-IP", "192.168.0.1"));//伪造客户端IP
        //初始化httpclient
        httpClient = new HttpClient(httpParams, httpManager);
        httpClient.getHostConfiguration().getParams().setParameter("http.default-headers", headers);

        //设置代理
//        httpClient.getHostConfiguration().setProxy("", 0);
//        httpClient.getParams().setAuthenticationPreemptive(false);
    }

    /**
     * 登陆并获取code值,如果出现验证码则返回还有验证码的参数信息
     * @return
     */
    public LoginParams doLogin(String username, String password) {

        Map<String,String> properties = initProperties();
        String base64UserCount = WeiboEncoder.encodeAccount(username);
        HashMap<String, String> pubkeyMap = null;
        String sp = null;
        String imgUrl = null;
        LoginParams loginParams = new LoginParams();
        try {
            pubkeyMap = pubKeyMap(base64UserCount);
            sp = WeiboEncoder.RSAEncrypt(password, pubkeyMap.get("pubkey"),"10001");
            imgUrl = getPin(pubkeyMap);
            if (imgUrl != null) {
                loginParams.setPcid(pubkeyMap.get("pcid"));
                loginParams.setNonce(pubkeyMap.get("nonce"));
                loginParams.setServertime(pubkeyMap.get("servertime"));
                loginParams.setRsakv(pubkeyMap.get("rsakv"));
                loginParams.setImgUrl(imgUrl);
                loginParams.setSp(sp);
                return loginParams;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        HashMap<String, String> ticketMap = null;
        try {
            ticketMap = getTicket(base64UserCount, sp, pubkeyMap);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        //确认在最终登陆后是否再需要验证码(账号为新浪的注册邮箱)
        String vcUrl = isHasPinAgain(pubkeyMap, ticketMap);
        if (vcUrl != null) {
            loginParams.setPcid(pubkeyMap.get("pcid"));
            loginParams.setNonce(pubkeyMap.get("nonce"));
            loginParams.setServertime(pubkeyMap.get("servertime"));
            loginParams.setRsakv(pubkeyMap.get("rsakv"));
            loginParams.setImgUrl(imgUrl);
            loginParams.setSp(sp);
            return loginParams;
        }

        try {
            String code = authorize(ticketMap.get("ticket"), properties.get("authorizeURL"),
                    properties.get("redirect_URI"), properties.get("client_ID"),
                    username, ticketMap.get("uid"));

            loginParams.setCode(code);
        } catch (KeyManagementException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return loginParams;

    }

    /**
     * 有验证码时登陆
     * @param sp
     * @param pin
     * @param pcid
     * @param servertime
     * @param nonce
     * @param rsakv
     * @return
     */
    public LoginParams doLoginByPin(String username, String sp, String pin, String pcid,
                                    String servertime,String nonce,String rsakv ) {

        Map<String,String> properties = initProperties();
        String base64UserCount = WeiboEncoder.encodeAccount(username);
        HashMap<String, String> ticketMap = null;
        LoginParams params = new LoginParams();
        try {
            ticketMap = getTicket(base64UserCount, sp, pin, pcid,
                    servertime, nonce, rsakv);
            if (ticketMap.containsKey("reason")) {
                //意为"输入的验证码不正确"
                String reply = "\\u8f93\\u5165\\u7684\\u9a8c\\u8bc1\\u7801\\u4e0d\\u6b63\\u786e";
                String reasonStr = ticketMap.get("reason");
                if (reasonStr.equals(reply)) {
                    params.setLogin(false);
                    return params;
                }
            }
            String code = authorize(ticketMap.get("ticket"), properties.get("authorizeURL"),
                    properties.get("redirect_URI"), properties.get("client_ID"),
                    username, ticketMap.get("uid"));
            params.setCode(code);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return params;
    }

    /**
     * 模拟新浪授权
     * @param ticket ticket参数
     * @param redirectURI 回调地址
     * @param clientId appKey
     * @param username 用户名
     * @return token
     * @throws IOException
     * @throws KeyManagementException
     * @throws NoSuchAlgorithmException
     */
    private String authorize(String ticket, String authorizeURL, String redirectURI,
                             String clientId, String username, String uid) throws IOException,
            KeyManagementException, NoSuchAlgorithmException {

        String code = null;
        String url = authorizeURL + "?client_id=" + clientId + "&redirect_uri="
                + redirectURI + "&response_type=code&forcelogin=true";
        String regCallback = authorizeURL + "?client_id=" + clientId + "&redirect_uri="
                + redirectURI + "&response_type=code&display=default&from=&with_cookie=";
        PostMethod post = new PostMethod(authorizeURL);
        //模拟申请token的链接，如果不添加，那么回调地址返回则为空
        post.setRequestHeader("Referer",url);
        // 模拟登录时所要提交的参数信息
        NameValuePair[] formpPairs=new NameValuePair[]{
                new NameValuePair("action", "login"),
                new NameValuePair("userId",username),
                new NameValuePair("ticket", ticket),
                new NameValuePair("response_type", "code"),
                new NameValuePair("redirect_uri", redirectURI),
                new NameValuePair("client_id", clientId),
                new NameValuePair("regCallback", URLEncoder.encode(regCallback, "UTF-8"))
        };
        post.setRequestBody(formpPairs);
        int status = httpClient.executeMethod(post);
        if (status == HttpStatus.SC_OK) {
//            InputStream responseBodyAsStream = post.getResponseBodyAsStream();

            code = authorizeAgain(this.responseToString(post).getBytes(), ticket, authorizeURL,
                    redirectURI, clientId, username, uid);
        }else if (status == 302) {
            Header locationHeader = post.getResponseHeader("location");
            String location = locationHeader.getValue();
            code = location.substring(location.indexOf("=")+1);
        }

        return code;
    }

    /**
     * 二次提交授权申请
     * @param htmlDatas 第一次授权申请返回的页面数据
     * @return
     * @throws IOException
     * @throws HttpException
     */
    private String authorizeAgain(byte[] htmlDatas, String ticket, String authorizeURL,
                                  String redirectURI,String clientId, String username,
                                  String uid) throws HttpException, IOException {

        String verifyToken = null;
        String html = new String(htmlDatas, "utf-8");
        Document doc = Jsoup.parse(html);
        Element verifyTokeneElement = doc.select("input[name=verifyToken]").first();
        verifyToken = verifyTokeneElement.attr("value");
        String code = null;
        String url = authorizeURL + "?client_id=" + clientId + "&redirect_uri="
                + redirectURI + "&response_type=code&forcelogin=true";
        String regCallback = authorizeURL + "?client_id=" + clientId + "&redirect_uri="
                + redirectURI + "&response_type=code&display=default&from=&with_cookie=";
        PostMethod post = new PostMethod(authorizeURL);
        //模拟申请token的链接，如果不添加，那么回调地址返回则为空
        post.setRequestHeader("Referer",authorizeURL);
        // 模拟登录时所要提交的参数信息
        NameValuePair[] formpPairs=new NameValuePair[]{
                new NameValuePair("action", "authorize"),
                new NameValuePair("uid",uid),
                new NameValuePair("url", url),
                new NameValuePair("response_type", "code"),
                new NameValuePair("redirect_uri", redirectURI),
                new NameValuePair("client_id", clientId),
                new NameValuePair("verifyToken", verifyToken),
                new NameValuePair("regCallback", URLEncoder.encode(regCallback, "UTF-8"))
        };
        post.setRequestBody(formpPairs);
        int status = httpClient.executeMethod(post);
        if (status == 302) {
            Header locationHeader = post.getResponseHeader("location");
            String location = locationHeader.getValue();
            if (location == null) {
                throw new NullPointerException("redirect_uri is null");
            }
            code = location.substring(location.indexOf("=")+1);
        }
        return code;
    }

    /**
     * 模拟用户预登录
     * @param unameBase64
     * @return
     * @throws IOException
     */
    private HashMap<String, String> pubKeyMap(String unameBase64)
            throws IOException {

        String url = "https://login.sina.com.cn/sso/prelogin.php?"
                + "entry=openapi&"
                + "callback=sinaSSOController.preloginCallBack&" + "su="
                + unameBase64 + "&" + "rsakt=mod&" + "checkpin=1&"
                + "client=ssologin.js(v1.4.5)" + "&_=" + new Date().getTime();
        return getParaFromResult(get(url));
    }

    /**
     * 预登陆是否需要验证码
     * @param pubkeyMap
     * @return
     */
    private String getPin(HashMap<String, String> pubkeyMap) {

        String imgUrl = null;
        int isShowpin = 0;
        if (pubkeyMap != null) {
            String showpin = pubkeyMap.get("showpin");
            if (showpin != null) {
                isShowpin = Integer.parseInt(showpin);
                if (isShowpin == 1) {
                    String url = "https://login.sina.com.cn/cgi/pin.php?"
                            + "r=" + Math.floor(Math.random() * 100000000)
                            + "&s=0"
                            + "&p=" + pubkeyMap.get("pcid");

                    imgUrl = url;
                }
            }
        }
        return imgUrl;
    }


    /**
     * 确认登陆后是否需要再验证
     * @return
     */
    private String isHasPinAgain(HashMap<String, String> pubkeyMap,
                                 HashMap<String, String> ticketMap) {

        String imgUrl = null;
        int isHasPin = 0;
        if ((pubkeyMap != null) && (ticketMap != null)) {
            //意为"为了您的帐号安全，请输入验证码"
            String str = "\\u4e3a\\u4e86\\u60a8\\u7684\\u5e10\\u53f7\\u5b89" +
                    "\\u5168\\uff0c\\u8bf7\\u8f93\\u5165\\u9a8c\\u8bc1\\u7801";

            if (ticketMap.containsKey("reason")) {
                String reasonStr = ticketMap.get("reason");
                if (reasonStr.equals(str)) {
                    isHasPin = 1;
                    String url = "https://login.sina.com.cn/cgi/pin.php?"
                            + "r=" + Math.floor(Math.random() * 100000000)
                            + "&s=0"
                            + "&p=" + pubkeyMap.get("pcid");

                    imgUrl = url;
                }
            }
        }
        return imgUrl;
    }

    /**
     * 获取验证码
     */
    public String getVCode(String pcid) {

        String imgUrl = null;
        if (pcid != null) {
            String url = "https://login.sina.com.cn/cgi/pin.php?"
                    + "r=" + Math.floor(Math.random() * 100000000)
                    + "&s=0"
                    + "&p=" + pcid;

            imgUrl = url;
        }
        return imgUrl;
    }

    /**
     * 保存验证码
     * @param url 验证码链接
     */
    public void saveVCodeImg(String url) {

        GetMethod getImages = new GetMethod(url);
        try {
            int status = httpClient.executeMethod(getImages);
            if (status == HttpStatus.SC_OK) {
                FileOutputStream outputStream = new FileOutputStream("vc.jpg");
                outputStream.write(this.responseToString(getImages).getBytes());
                outputStream.close();
            }
        } catch (HttpException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * 无验证码时模拟用户登录,并获取ticket
     * @param usernameBase64 使用Base64加密的用户名
     * @param sp 使用SHA1加密后的用户密码
     * @return
     * @throws Exception
     */
    private HashMap<String, String> getTicket(String usernameBase64,
                                              String sp, HashMap<String, String> pubkeyMap) throws Exception {
        String url = null;
        if (pubkeyMap != null) {
            url = "https://login.sina.com.cn/sso/login.php?"
                    + "entry=openapi&"
                    + "gateway=1&"
                    + "from=&"
                    + "savestate=0&"
                    + "useticket=1&"
                    + "pagerefer=&"
                    + "ct=1800&"
                    + "s=1&"
                    + "vsnf=1&"
                    + "vsnval=&"
                    + "door=&"
                    + "su="+ usernameBase64
                    + "&"
                    + "service=miniblog&"
                    + "servertime="+ pubkeyMap.get("servertime")
                    + "&"
                    + "nonce="+ pubkeyMap.get("nonce")
                    + "&"
                    + "pwencode=rsa&"
                    + "rsakv="+ pubkeyMap.get("rsakv")
                    + "&"
                    + "sp="+ sp
                    + "&"
                    + "encoding=UTF-8&"
                    + "callback=sinaSSOController.loginCallBack&"
                    + "cdult=2&"
                    + "domain=weibo.com&"
                    + "prelt=37&"
                    + "returntype=TEXT&"
                    + "client=ssologin.js(v1.4.5)&" + "_=" + new Date().getTime();

        }
        return getParaFromResult(get(url));
    }

    /**
     * 有验证码时模拟用户登录,并获取ticket
     * @param usernameBase64
     * @param sp
     * @param pin
     * @param pcid
     * @param servertime
     * @param nonce
     * @param rsakv
     * @return
     * @throws Exception
     */
    public HashMap<String, String> getTicket(String usernameBase64, String sp, String pin,
                                             String pcid, String servertime,String nonce,String rsakv) throws Exception {

        String url = "https://login.sina.com.cn/sso/login.php?"
                + "entry=openapi&"
                + "gateway=1&"
                + "from=&"
                + "savestate=0&"
                + "useticket=1&"
                + "pagerefer=&"
                + "pcid=" + pcid + "&"
                + "ct=1800&"
                + "s=1&"
                + "vsnf=1&"
                + "vsnval=&"
                + "door=" + pin + "&"
                + "su="+ usernameBase64
                + "&"
                + "service=miniblog&"
                + "servertime="+ servertime
                + "&"
                + "nonce="+ nonce
                + "&"
                + "pwencode=rsa&"
                + "rsakv="+ rsakv
                + "&"
                + "sp="+ sp
                + "&"
                + "encoding=UTF-8&"
                + "callback=sinaSSOController.loginCallBack&"
                + "cdult=2&"
                + "domain=weibo.com&"
                + "prelt=37&"
                + "returntype=TEXT&"
                + "client=ssologin.js(v1.4.5)&" + "_=" + new Date().getTime();

        return getParaFromResult(get(url));
    }

    /**
     * 分析结果,取出所需参数
     * @param result 页面内容
     * @return
     */
    private HashMap<String, String> getParaFromResult(String result) {

        HashMap<String, String> hm = new HashMap<String, String>();
        result = result.substring(result.indexOf("{") + 1, result.indexOf("}"));
        String[] r = result.split(",");
        String[] temp;
        for (int i = 0; i < r.length; i++) {
            temp = r[i].split(":");
            for (int j = 0; j < 2; j++) {
                if (temp[j].contains("\""))
                    temp[j] = temp[j].substring(1, temp[j].length() - 1);
            }
            hm.put(temp[0], temp[1]);
        }
        return hm;
    }

    /**
     * 执行给定的URL,并输出目标URL返回的页面结果
     * @param url
     * @return
     * @throws IOException
     */
    private String get(String url) throws IOException {

        String surl = null;
        GetMethod getMethod = new GetMethod(url);
        int status = httpClient.executeMethod(getMethod);
        if (status == HttpStatus.SC_OK) {
            surl = this.responseToString(getMethod);
        }
        getMethod.releaseConnection();
        return surl;
    }


    private String responseToString(HttpMethod post) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(post.getResponseBodyAsStream(),"UTF-8"));
        StringBuffer stringBuffer = new StringBuffer();
        String str = "";
        while((str = reader.readLine())!=null){
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }
    /**
     * 配置信息初始化
     * @return
     */
    private Map<String,String> initProperties() {

        Map<String,String> map = new HashedMap();
        map.put("authorizeURL","https://api.weibo.com/oauth2/authorize");
        map.put("redirect_URI","https://api.weibo.com/oauth2/default.html");
        map.put("client_ID","644266243");

        return map;
    }


    public static String getWeiboCode(String username ,String password) {

        WeiboLoginer loginer = new WeiboLoginer();
        LoginParams loginParams = loginer.doLogin(username,password);
        //有验证码时
        if (loginParams.getCode() == null) {
            String pcid = loginParams.getPcid();

            String nonce = loginParams.getNonce();

            String rsakv = loginParams.getRsakv();

            String servertime = loginParams.getServertime();

            String sp = loginParams.getSp();

            Scanner input = new Scanner(System.in);

            String pin = input.nextLine();

            LoginParams loginResult = loginer.doLoginByPin(username,sp, pin, pcid, servertime, nonce, rsakv);
            if (!loginResult.isLogin()) {
                Scanner input1= new Scanner(System.in);

                String pin1 = input1.nextLine();

                return loginer.doLoginByPin(username,sp, pin1, pcid, servertime, nonce, rsakv).getCode();
            }
        }else {
            //无验证码时
            return loginParams.getCode();
        }

        return null;
    }


}
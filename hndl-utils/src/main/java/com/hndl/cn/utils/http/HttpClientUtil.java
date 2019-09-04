package com.hndl.cn.utils.http;

import com.hndl.cn.utils.string.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * HttpClient工具类
 * @Description 
 * @author 赵俊凯
 * @date 2017年9月29日 下午3:23:57
 */
public class HttpClientUtil {  
  
    public static String doGet(String url, Map<String, String> param) {
        return doGet(url,param,null);
    }


    public static String doGet(String url, Map<String, String> param,String authorization) {

        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        String resultString = "";
        CloseableHttpResponse response = null;
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));
                }
            }
            URI uri = builder.build();
            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);
            if(StringUtils.isNotBlank(authorization)){
                httpGet.setHeader("Authorization",authorization);
            }
            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return resultString;
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }
  
    public static String doGet(String url) {  
        return doGet(url, null);  
    }

    public static String doPost(String url, Map<String, String> param) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {  
            // 创建Http Post请求  
            HttpPost httpPost = new HttpPost(url);  
            // 创建参数列表  
            if (param != null) {  
                List<NameValuePair> paramList = new ArrayList<>();  
                for (String key : param.keySet()) {  
                    paramList.add(new BasicNameValuePair(key, param.get(key)));  
                }  
                // 模拟表单  
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList,"utf-8");
                httpPost.setEntity(entity);
            }
            // 执行http请求  
            response = httpClient.execute(httpPost);  
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                response.close();  
            } catch (IOException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
  
        return resultString;  
    }  
  
    public static String doPost(String url) {  
        return doPost(url, null);  
    }  
      
    public static String doPostJson(String url, String json) {  
        return doPostJson(url,null,json);
    }

    public static String doPostJson(String url,String authorization, String json) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建请求内容
            if(StringUtils.isNotBlank(authorization)){
                httpPost.setHeader("Authorization",authorization);
            }
            if(StringUtils.isNotBlank(json)){
                StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
                httpPost.setEntity(entity);
            }
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            return resultString;
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return resultString;
    }

    public static String postXml(String url,String xmlInfo){
        CloseableHttpClient httpclient =HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try{

            // 创建Http Post请求
//            HttpPost httpPost = new HttpPost(url);
            StringEntity entity = new StringEntity(xmlInfo,"utf-8");
//            httpPost.setEntity(entity);

            HttpUriRequest httpUriRequest = RequestBuilder.post()
                    .setUri(new URI(url))
                    .setEntity(entity)
                    .setHeader("Content-Type", "application/xml").build();

            // 执行http请求
            response =  httpclient.execute(httpUriRequest);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");

        }catch(Exception e){
            e.printStackTrace();
        }
        return resultString;
    }


    /**
     * http post请求
     * @param url						地址
     * @param postContent				post内容格式为param1=value&param2=value2&param3=value3
     * @return
     * @throws IOException
     */
    public static String doPost(URL url, String postContent) throws Exception {
        OutputStream outputstream = null;
        BufferedReader in = null;
        try {
            URLConnection httpurlconnection = url.openConnection();
            httpurlconnection.setConnectTimeout(10 * 1000);
            httpurlconnection.setDoOutput(true);
            httpurlconnection.setUseCaches(false);
            OutputStreamWriter out = new OutputStreamWriter(httpurlconnection
                    .getOutputStream(), "UTF-8");
            out.write(postContent);
            out.flush();
            StringBuffer result = new StringBuffer();
            in = new BufferedReader(new InputStreamReader(httpurlconnection.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (outputstream != null) {
                try {
                    outputstream.close();
                } catch (IOException e) {
                    outputstream = null;
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    in = null;
                }
            }
        }
       return null;
    }
}  

package com.hndl.cn.base.message.wechat.customer;

import com.hndl.cn.base.message.wechat.WechatMessageTemplate;
import lombok.Data;

import java.util.Map;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/8/26 14:43
 * @Created by 湖南达联
 */
@Data
public class CustomerTextData extends WechatMessageTemplate {

    private Map<String,Object> text;



//    public static void main(String[] args) {
//        CustomerTextData customerTextData = new CustomerTextData();
//        customerTextData.setTouser("12312312");
//        customerTextData.setMsgtype("text");
//        Map<String,Object> map = new HashMap<>();
//        map.put("content","Hello World");
//        customerTextData.setText(map);
//        System.out.println(customerTextData);
//        System.out.println(JSONObject.toJSONString(customerTextData));
//    }
}

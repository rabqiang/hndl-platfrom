package com.hndl.cn.base.message.wechat.customer;

import com.hndl.cn.base.message.wechat.WechatMessageTemplate;
import lombok.Data;

import java.util.Map;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/8/26 14:59
 * @Created by 湖南达联
 */
@Data
public class CustomerImageData extends WechatMessageTemplate {

    private Map<String,Object> image;
}

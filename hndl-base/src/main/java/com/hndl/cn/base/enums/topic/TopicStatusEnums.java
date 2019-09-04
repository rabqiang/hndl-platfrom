package com.hndl.cn.base.enums.topic;

import java.util.HashMap;
import java.util.Map;

/**
 * @program:hndl-platform
 * @description:TODO 话题审核状态枚举
 * @author: 易成贤
 * @create: 2019/7/29 16:26
 * @Created by湖南达联
 **/
public enum  TopicStatusEnums {

    NOPASS(1,"不通过"),

    PUBLISHED(2,"发布"),

    UNPUBLISHED(3,"不发布"),

    NEW(4,"新增"),

    WAITAUDIT(5,"待审核")

    ;
    /**
     * 类型
     */
    private Integer type;
    /**
     * 描述
     */
    private String description;

    TopicStatusEnums(Integer type, String description) {
        this.type = type;
        this.description = description;
    }

    public Integer getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public static TopicStatusEnums evalVal(Integer value) {
        for (TopicStatusEnums type : TopicStatusEnums.values()) {
            if (type.getType().equals(value)) {
                return type;
            }
        }
        return null;
    }

    public static Map<Integer,TopicStatusEnums> getCheck(){
        Map map =new HashMap(2);
        map.put(PUBLISHED.getType(),PUBLISHED);
        map.put(WAITAUDIT.getType(),WAITAUDIT);
        return map;
    }

    public static Map<Integer,TopicStatusEnums> getEdit(){
        Map map =new HashMap(4);
        map.put(NOPASS.getType(),NOPASS);
        map.put(UNPUBLISHED.getType(),UNPUBLISHED);
        map.put(WAITAUDIT.getType(),WAITAUDIT);
        map.put(NEW.getType(),NEW);
        return map;
    }
}

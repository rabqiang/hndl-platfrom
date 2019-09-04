package com.hndl.cn.base.enums.message;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 曹加丽
 * @Description  投诉类型
 * @Date 2019/5/25 13:22
 * @Created by 湖南达联
 */
public enum FeedbackEnums {

    DEFAMATION_LOVE_BEAN(1,"发布不友善内容"),

    FRAUD_INFORMATION(2,"诈骗、诱导"),

    PUBLISH_ADVERTISEMENT(3,"散布广告"),

    TRANSPORT_PLAGIARISM(4, " 搬运抄袭"),

    FALSE_CONTENT(5,"虚假内容"),

    Rumor_LOVE_BEAN(6,"造谣爱豆"),

    SLANDER_OTHERS(7,"诋毁他人"),

    FANS_SUGGESTIONS(9,"粉丝建议"),

    OTHER_TYPES(10,"其他"),
            ;

    private Integer  typeId;//类型id

    private String description;//描述

     FeedbackEnums(Integer typeId, String description) {
        this.typeId = typeId;
        this.description = description;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public String getDescription() {
        return description;
    }
    public static FeedbackEnums evalVal(Integer value) {
        for (FeedbackEnums type : FeedbackEnums.values()) {
            if (type.getTypeId().equals(value)) {
                return type;
            }
        }
        return null;
    }

    public static FeedbackEnums evalOldVal(String oldValue) {
        for (FeedbackEnums type : FeedbackEnums.values()) {
            if (type.getTypeId().equals(oldValue)) {
                return type;
            }
        }
        return null;
    }
    public static Map<Integer, FeedbackEnums> getFeedback() {

        Map<Integer, FeedbackEnums> map = new HashMap(8);
        map.put(FeedbackEnums.DEFAMATION_LOVE_BEAN.getTypeId(), FeedbackEnums.DEFAMATION_LOVE_BEAN);
        map.put(FeedbackEnums.FRAUD_INFORMATION.getTypeId(), FeedbackEnums.FRAUD_INFORMATION);
        map.put(FeedbackEnums.PUBLISH_ADVERTISEMENT.getTypeId(), FeedbackEnums.PUBLISH_ADVERTISEMENT);
        map.put(FeedbackEnums.TRANSPORT_PLAGIARISM.getTypeId(), FeedbackEnums.TRANSPORT_PLAGIARISM);
        map.put(FeedbackEnums.FALSE_CONTENT.getTypeId(), FeedbackEnums.FALSE_CONTENT);
        map.put(FeedbackEnums.Rumor_LOVE_BEAN.getTypeId(), FeedbackEnums.Rumor_LOVE_BEAN);
        map.put(FeedbackEnums.SLANDER_OTHERS.getTypeId(), FeedbackEnums.SLANDER_OTHERS);
        map.put(FeedbackEnums.OTHER_TYPES.getTypeId(), FeedbackEnums.OTHER_TYPES);

        return map;
    }
}

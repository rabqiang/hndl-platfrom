package com.hndl.cn.base.enums;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/21 11:07
 * @Created by 湖南达联
 */
public enum IsValidEnums {

    YES(1,"y"), NO(0,"n");

    private Integer value;//新值

    private String oldValue; //旧值

    IsValidEnums(Integer value,String oldValue) {
        this.value = value;
        this.oldValue = oldValue;

    }

    public Integer getValue() {
        return value;
    }

    public String getOldValue(){
        return oldValue;
    }

    public static boolean checkVal(Integer value) {
        if (value != null) {
            for (IsValidEnums c : IsValidEnums.values()) {
                if (c.getValue().equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkOldVal(String oldValue) {
        if (oldValue != null) {
            for (IsValidEnums c : IsValidEnums.values()) {
                if (c.getOldValue().equals(oldValue)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static IsValidEnums evalVal(Integer value) {
        for (IsValidEnums type : IsValidEnums.values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        return null;
    }

    public static IsValidEnums evalOldVal(String oldValue) {
        for (IsValidEnums type : IsValidEnums.values()) {
            if (type.getOldValue().equals(oldValue)) {
                return type;
            }
        }
        return null;
    }
}

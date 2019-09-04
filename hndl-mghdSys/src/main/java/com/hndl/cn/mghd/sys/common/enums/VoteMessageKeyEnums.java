package com.hndl.cn.mghd.sys.common.enums;

public enum VoteMessageKeyEnums {

    VOTE_MESSAGE_KEY("vote"),

    VOTE_MESSAGE_HEART_KEY("heart"),

    VOTE_MESSAGE_TOP_KEY("top")

    ;
    private String behaviorName;

    VoteMessageKeyEnums(String behaviorName) {
        this.behaviorName = behaviorName;
    }

    public String getBehaviorName() {
        return behaviorName;
    }

    public void setBehaviorName(String behaviorName) {
        this.behaviorName = behaviorName;
    }
}

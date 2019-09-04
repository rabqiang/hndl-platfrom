package com.hndl.cn.mghd.sys.business.message.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReUserMessageVo implements Serializable {

    private List<UserMessageVo> userMessageVoList; //消息

    private int count;//未读条数
}

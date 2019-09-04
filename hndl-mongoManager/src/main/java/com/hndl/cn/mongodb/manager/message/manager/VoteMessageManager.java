package com.hndl.cn.mongodb.manager.message.manager;

import com.hndl.cn.mongodb.manager.message.bean.VoteMessageDo;

import java.util.List;

public interface VoteMessageManager {


  /**
   *  根据时间查询弹幕消息
   * @param createTime
   * @return
   */
  List<VoteMessageDo> findByCreateTime(Long createTime);


  /**
   * 添加弹幕消息
   */
  void insertVoteMessageDo(Long starId,String msgContent);

  /**
   *  删除小于指定ID的弹幕消息
   * */
  void delVoteMessageLtId(String id);



 VoteMessageDo findVoteMessage();
}

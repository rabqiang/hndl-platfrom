package com.hndl.cn.mghd.admin.business.message.service;


import com.hndl.cn.mghd.admin.business.message.vo.AdminMessageVo;

import java.util.List;

/**
 * @author 尹争鸣
 * @Description TODO
 * @Date 2019年6月20日14:04:45
 * @Created by 湖南达联
 * */
public interface AdminMessageInfoService {


    /**
     * 保存消息
     * */
    void saveMessage(AdminMessageVo adminMessageVo);


     /**
     * 查询消息
     * */
     List<AdminMessageVo> findByMessage(AdminMessageVo adminMessageVo,Long messageId);


    /**
     * 修改消息
     * */
    void updateMessage(AdminMessageVo adminMessageVo);


    /**
     * 删除消息
     * */
    void removeMessage(Long messageId);






}

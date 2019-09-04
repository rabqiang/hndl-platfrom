package com.hndl.cn.mysql.manager.pay.manager;

/**
 * @program:hndl-platform
 * @description:TODO 补单
 * @author: 易成贤
 * @create: 2019/8/7 14:38
 * @Created by湖南达联
 **/
public interface RepairOrderLogManager {
    /**
     * 插入一条补单记录
     * @param
     * @return
     */
    Integer insertReplacementOder(Long createAdminId,Long localOrderId,Long userUniId,String remark);


    /**
     * 查询补单
     * @param userUniId
     * @param localOrder
     * @return
     */
    boolean existReplacementOder(Long userUniId, Long localOrder);
}

package com.hndl.cn.mysql.manager.pay.manager.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.dao.pay.bean.RepairOrderLogsDo;
import com.hndl.cn.dao.pay.bean.RepairOrderLogsDoExample;
import com.hndl.cn.dao.pay.mapper.RepairOrderLogsMapper;
import com.hndl.cn.mysql.manager.pay.manager.RepairOrderLogManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @program:hndl-platform
 * @description:TODO 补单
 * @author: 易成贤
 * @create: 2019/8/7 14:39
 * @Created by湖南达联
 **/
@Slf4j
@Service
public class RepairOrderLogManagerImpl implements RepairOrderLogManager {

    @Resource
    RepairOrderLogsMapper repairOrderLogsMapper;

    /**
     * 插入一条补单记录
     * @param
     * @return
     */
    @Override
    public Integer insertReplacementOder(Long createAdminId,Long localOrderId,Long userUniId,String remark){

        RepairOrderLogsDo infoDo = new RepairOrderLogsDo();
        //创建人
        infoDo.setCreateAdminId(createAdminId);
        //时间
        infoDo.setCreateTime(new Date(System.currentTimeMillis()));
        //非删除
        infoDo.setIsDelete(IsValidEnums.NO.getValue());
        //本地订单
        infoDo.setLocalOrderId(localOrderId);
        //备注信息
        infoDo.setRemark(remark);

        infoDo.setUserUniId(userUniId);

      return  repairOrderLogsMapper.insert(infoDo);
    }

    /**
     * 查询补单
     *
     * @param userUniId
     * @param localOrder
     * @return
     */
    @Override
    public boolean existReplacementOder(Long userUniId, Long localOrder) {
        RepairOrderLogsDoExample example = new RepairOrderLogsDoExample();
        example.createCriteria().andUserUniIdEqualTo(userUniId).andLocalOrderIdEqualTo(localOrder);
        return repairOrderLogsMapper.countByExample(example) > 0;
    }
}

package com.hndl.cn.mongodb.manager.user.manager.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.mongodb.manager.user.bean.UserEmpiricalLogDo;
import com.hndl.cn.mongodb.manager.user.manager.UserEmpiricalLogDoManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/4/19 14:45
 * @Created by 湖南达联
 */
@Service
public class UserEmpiricalLogDoManagerImpl implements UserEmpiricalLogDoManager {

    //连接MongoDB的服务接口
    @Resource
    private MongoDbService mongoDbService;


    @Override
    public void UserEmpiricalLogDoAddEmpiricalCount(UserEmpiricalLogDo userEmpiricalLogDo) {
        userEmpiricalLogDo.setIsDelete(IsValidEnums.NO.getValue());
        mongoDbService.insert(userEmpiricalLogDo);
    }


    @Override
    public List<UserEmpiricalLogDo> findUserEmpiricalLogDo(Long userUniId, String id , Integer pageSize) {
        ///如果分页数大于零，那就直接查询所有
        Criteria criteria = new Criteria();
        if (userUniId != null) {
             criteria.and("userUniId").is(userUniId);
        }
        if (id != null){
            criteria.and("_id").lt(new ObjectId(id));
        }
        //实例化sort对象
        Sort sort = Sort.by(Sort.Order.desc("createTime"));
        //查询用户经验值日志，分页二十条
        Query query = new Query(criteria).with(sort).limit(pageSize);

        return mongoDbService.findAll(query, UserEmpiricalLogDo.class);

    }
//


}

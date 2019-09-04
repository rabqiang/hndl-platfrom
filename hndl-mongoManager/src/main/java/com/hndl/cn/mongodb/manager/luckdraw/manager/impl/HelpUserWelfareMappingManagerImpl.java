package com.hndl.cn.mongodb.manager.luckdraw.manager.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.math.NumberEnums;
import com.hndl.cn.mongodb.manager.luckdraw.bean.HelpUserWelfareMappingDo;
import com.hndl.cn.mongodb.manager.luckdraw.manager.HelpUserWelfareMappingManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import com.hndl.cn.utils.date.LocalDateTimeUtil;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/7/24 17:19
 * @Created by 湖南达联
 */
@Service
public class HelpUserWelfareMappingManagerImpl implements HelpUserWelfareMappingManager {

    @Resource
    private MongoDbService mongoDbService;

    /**
     * 站外好友给用户增加助力数
     *
     * @param helpUserWelfareMappingDo
     */
    @Override
    public void addHelpUserWelfareMapping(HelpUserWelfareMappingDo helpUserWelfareMappingDo) {
        mongoDbService.insert(helpUserWelfareMappingDo);
    }

    @Override
    public HelpUserWelfareMappingDo queryHelpByUserId(String welfareNumber, Long userUniId) {
        Criteria criteria = new Criteria();
        criteria.and("welfareNumber").is(welfareNumber);
        criteria.and("userUniId").is(userUniId);
        return mongoDbService.findOne(new Query(criteria), HelpUserWelfareMappingDo.class);
    }

    @Override
    public Long queryHelpCountByUserId(Long userUniId) {
        Criteria criteria = Criteria.where("userUniId").is(userUniId)
                .and("createTime").gte(LocalDateTimeUtil.getNowMinTimeMilli()).lte(LocalDateTimeUtil.getNowMaxTimeMilli())
                .and("isDelete").is(IsValidEnums.NO.getValue());
        return mongoDbService.count(new Query(criteria), HelpUserWelfareMappingDo.class);
    }

    @Override
    public List<HelpUserWelfareMappingDo> queryHelpMeFriend(Long userUniId, String welfareNumber) {
        Criteria criteria = new Criteria();
        criteria.and("welfareNumber").is(welfareNumber);
        criteria.and("helpUserId").is(userUniId);
        // 根据创建时间倒序
        Sort sort = Sort.by(Sort.Order.desc("createTime"));
        Query query = new Query(criteria).with(sort);
        query.limit(NumberEnums.TEN.getNumber());
        return mongoDbService.findAll(query, HelpUserWelfareMappingDo.class);
    }

    @Override
    public Long queryHelpMeFriendCount(Long userUniId, String welfareNumber) {
        Criteria criteria = new Criteria();
        criteria.and("welfareNumber").is(welfareNumber);
        criteria.and("helpUserId").is(userUniId);
        return mongoDbService.count(new Query(criteria), HelpUserWelfareMappingDo.class);
    }

    @Override
    public void updateUserImgByUserUniId(Long userUniId, String userImg) {
        Query query = new Query(Criteria.where("userUniId").is(userUniId));
        Update update = new Update();
        update.set("userImg", userImg);
        mongoDbService.update(query, update, HelpUserWelfareMappingDo.class);
    }

    @Override
    public void updateUserNickNameByUserUniId(Long userUniId, String userNickName) {
        Query query = new Query(Criteria.where("userUniId").is(userUniId));
        Update update = new Update();
        update.set("userNickName", userNickName);
        mongoDbService.update(query, update, HelpUserWelfareMappingDo.class);
    }
}

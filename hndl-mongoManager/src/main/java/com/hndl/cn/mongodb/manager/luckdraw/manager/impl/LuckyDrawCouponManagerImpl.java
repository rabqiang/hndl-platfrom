package com.hndl.cn.mongodb.manager.luckdraw.manager.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.user.FoucaultGetTypeEnums;
import com.hndl.cn.base.enums.welfare.WelfareTypeEnums;
import com.hndl.cn.mongodb.manager.luckdraw.bean.LuckyDrawCouponDo;
import com.hndl.cn.mongodb.manager.luckdraw.manager.LuckyDrawCouponManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import com.hndl.cn.utils.date.LocalDateTimeUtil;
import com.hndl.cn.utils.string.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @program:hndl-platform
 * @description:TODO 奖品记录
 * @author: 易成贤
 * @create: 2019/7/5 18:21
 * @Created by湖南达联
 **/
@Service
@Slf4j
public class LuckyDrawCouponManagerImpl implements LuckyDrawCouponManager {

    @Resource
    MongoDbService mongoDbService;

    @Override
    public Long countByUserUniId(Long userUniId,WelfareTypeEnums welfareTypeEnums) {
        Criteria criteria = Criteria.where("userUniId").is(userUniId).and("prizeId").ne(IsValidEnums.NO.getValue()).and("isDelete").is(IsValidEnums.NO.getValue());
        return mongoDbService.count(new Query(criteria), LuckyDrawCouponDo.class);
    }

    @Override
    public  List<LuckyDrawCouponDo> countLuckyDraw(Long userUniId, Long statTime, Long endTime) {
        Criteria criteria = Criteria.where("userUniId").is(userUniId).and("prizeId").ne(IsValidEnums.NO.getValue()).ne(2);
        if (statTime != null && endTime != null) {
            criteria.and("createTime").gte(statTime).lte(endTime);
        }
        return mongoDbService.findAll(new Query(criteria), LuckyDrawCouponDo.class);
    }

    /**
     * 根据用户id查询用户中奖信息
     */
    @Override
    public List<LuckyDrawCouponDo> findWinningByUserUniId(Long userUniId, String id, Long statTime, Long endTime) {
        Criteria criteria =new Criteria();
        if (userUniId != null) {
            criteria.and("userUniId").is(userUniId);
        }
        if (statTime != null && endTime != null) {
            criteria.and("createTime").gte(statTime).lte(endTime);
        }
        if (id != null) {
            criteria.and("_id").lte(new ObjectId(id));
        }
        Sort sort = Sort.by(Sort.Order.desc("createTime"));
        //加分页的页数
        Query query = new Query(criteria).with(sort).limit(BaseConstants.DEFAULT_LIMIT);
        return mongoDbService.findAll(query, LuckyDrawCouponDo.class);
    }

    @Override
    public Long countWinning(Long UserUinId, Long prizeId,WelfareTypeEnums welfareTypeEnums) {
        Criteria criteria = Criteria.where("prizeId").is(prizeId);
        if (UserUinId != null) {
            criteria.and("userUniId").is(UserUinId);
        }
        if (null != welfareTypeEnums){
            criteria.and("welfareType").is(welfareTypeEnums.getValue());
        }
        return mongoDbService.count(new Query(criteria), LuckyDrawCouponDo.class);
    }

    @Override
    public Long countWinning(Long UserUinId, Long prizeId, Long statTime, Long endTime) {
        Criteria criteria = Criteria.where("prizeId").is(prizeId);
        if (UserUinId != null) {
            criteria.and("userUniId").is(UserUinId);
        }
        if (statTime != null && endTime != null) criteria.and("createTime").gte(statTime).lte(endTime);
        return mongoDbService.count(new Query(criteria), LuckyDrawCouponDo.class);
    }

    @Override
    public Long countWinningToDayByUserUniId(Long userUniId, FoucaultGetTypeEnums foucaultGetTypeEnums) {
        Long startTime = LocalDateTimeUtil.getNowMinTimeMilli();
        Long endTime = LocalDateTimeUtil.getNowMaxTimeMilli();
        Criteria criteria = Criteria.where("createTime").gte(startTime).lte(endTime).and("taskType").is(foucaultGetTypeEnums.getTaskType());
        return mongoDbService.count(new Query(criteria),LuckyDrawCouponDo.class);
    }







    /**
     * 统计奖品获得记录
     *
     * @param prizeId
     * @return
     */
    @Override
    public Long countByPrizeId(Long prizeId,WelfareTypeEnums welfareTypeEnums) {
        Criteria criteria = Criteria.where("prizeId").is(prizeId).and("welfareType").is(welfareTypeEnums.getValue()).and("isDelete").is(IsValidEnums.NO.getValue());
        return mongoDbService.count(new Query(criteria), LuckyDrawCouponDo.class);
    }


  

    /**
     * 通过奖品id 查询用户奖品信息
     *
     * @param sysUniId
     * @param isEntity
     * @param limit
     * @return
     */
    @Override
    public List<LuckyDrawCouponDo> findUserList(String id,  long sysUniId,  IsValidEnums isEntity,  Integer limit,WelfareTypeEnums welfareTypeEnums) {

        Criteria criteria = Criteria.where("userUniId").is(sysUniId)
                .and("isDelete").is(IsValidEnums.NO.getValue())
                .and("welfareType").is(welfareTypeEnums.getValue())
                .and("isEntity").is(isEntity.getValue());

        if (StringUtils.isNotBlank(id)){
            criteria.and("_id").lt(new ObjectId(id));
        }
        Sort sort = Sort.by(Sort.Order.desc("createTime"));
        Query query = new Query(criteria).limit(limit).with(sort);
        return mongoDbService.findAll(query, LuckyDrawCouponDo.class);
    }

    /**
     * 统计用户指定渠道上获取的今天条数
     *
     * @param sysUniId         用户id
     * @param isEntity         是不是实物
     * @param welfareTypeEnums 渠道
     * @return
     */
    @Override
    public Long countToDayWinByUser(@NotNull Long sysUniId, @NotNull IsValidEnums isEntity, @NotNull WelfareTypeEnums welfareTypeEnums) {
        Criteria criteria = Criteria.where("userUniId").is(sysUniId)
                .and("isDelete").is(IsValidEnums.NO.getValue())
                .and("welfareType").is(welfareTypeEnums.getValue())
                .and("isEntity").is(isEntity.getValue())
                .and("createTime").gte(LocalDateTimeUtil.getNowMinTimeMilli()).lte(LocalDateTimeUtil.getNowMaxTimeMilli());
        return mongoDbService.count(new Query(criteria),LuckyDrawCouponDo.class);
    }

    /**
     * 插入一条奖品记录
     *
     * @param userUniId
     * @param prizeId
     * @param welfareType
     */
    @Override
    public void insertLuckyDrawCoupon(Long userUniId, Long prizeId, WelfareTypeEnums welfareType,IsValidEnums isGet,IsValidEnums isEntity) {
        mongoDbService.insert(LuckyDrawCouponDo.builder()
                .userUniId(userUniId)
                .createTime(System.currentTimeMillis())
                .prizeId(prizeId)
                .welfareType(welfareType.getValue())
                .isDelete(IsValidEnums.NO.getValue())
                .isGet(isGet.getValue())
                .isEntity(isEntity.getValue())
                .build());
    }

    /**
     * 统计渠道商当天获取实物/非实物的条数
     *
     * @param isEntity
     * @param welfareTypeEnums
     * @return
     */
    @Override
    public Long countToDayByEntity(@NotNull IsValidEnums isEntity, @NotNull WelfareTypeEnums welfareTypeEnums) {
        Criteria criteria = Criteria.where("isDelete").is(IsValidEnums.NO.getValue())
                .and("welfareType").is(welfareTypeEnums.getValue())
                .and("isEntity").is(isEntity.getValue())
                .and("createTime").gte(LocalDateTimeUtil.getNowMinTimeMilli()).lte(LocalDateTimeUtil.getNowMaxTimeMilli());
        return mongoDbService.count(new Query(criteria),LuckyDrawCouponDo.class);
    }

    /**
     * 修改领取福利的状态
     * @param userUniId     用户uniId
     * @param prizeId       奖品id
     * @param welfareType   福利类型
     * @return
     */
    @Override
    public boolean updateLuckyDrawCoupon(Long userUniId, Long prizeId, WelfareTypeEnums welfareType) {
        Criteria criteria =Criteria.where("userUniId").is(userUniId).and("prizeId").is(prizeId)
                .and("welfareType").is(welfareType.getValue());
        Update update = new Update();
        update.set("isGet",IsValidEnums.YES.getValue());
        return mongoDbService.incByResult(new Query(criteria),update,LuckyDrawCouponDo.class);
    }

}

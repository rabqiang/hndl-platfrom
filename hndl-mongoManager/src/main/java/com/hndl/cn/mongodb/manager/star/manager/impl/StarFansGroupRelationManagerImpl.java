package com.hndl.cn.mongodb.manager.star.manager.impl;
import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.permission.RelationPermissionEnum;
import com.hndl.cn.base.enums.vote.VoteTypeEnums;
import com.hndl.cn.mongodb.manager.star.bean.StarFansGroupRelationDo;
import com.hndl.cn.mongodb.manager.star.manager.StarFansGroupRelationManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 易成贤
 * @Description 处理明星与用户之间的关系
 * @Date 2019/4/18 10:54
 * @Created by 湖南达联
 */
@Service
public class StarFansGroupRelationManagerImpl implements StarFansGroupRelationManager {

    /**
     *
     */
    @Resource
    private MongoDbService mongoDbService;


    /**
     * 创建用户粉丝会关系
     * @param userUniId
     * @param starId
     */
    @Override
    public void  insertStarFansGroupRelation(Long userUniId, Long starId) {

        StarFansGroupRelationDo starFansGroupRelation = new StarFansGroupRelationDo();
        //用户
        starFansGroupRelation.setUserUniId(userUniId);
        //明星
        starFansGroupRelation.setStarId(starId);
        //设置创建时间，应该设定dao层第一次插入数据时间
        starFansGroupRelation.setCreateTime(System.currentTimeMillis());
        //新加,贡献值贡献值不+
        starFansGroupRelation.setFansContribute(BaseConstants.STARTING_LONG_VALUE);
        //粉丝总票数
        starFansGroupRelation.setVoteCount(BaseConstants.STARTING_LONG_VALUE);
        //爱心票数
        starFansGroupRelation.setGettingLoveCount(BaseConstants.STARTING_INT_VALUE);
        //累计打榜天数
        starFansGroupRelation.setVoteDayCount(BaseConstants.STARTING_INT_VALUE);
        //设置为普通用户
        starFansGroupRelation.setPower(RelationPermissionEnum.FANS_ORDINARY.getValue());
        //设置是否删除状态为否
        starFansGroupRelation.setIsDelete(IsValidEnums.NO.getValue());
        //积分
        starFansGroupRelation.setIntegralCount(BaseConstants.STARTING_INT_VALUE);
        //拉新人数
        starFansGroupRelation.setSpreadCount(BaseConstants.STARTING_INT_VALUE);
        //插入
        mongoDbService.insert(starFansGroupRelation);
    }

    /**
     * 批量插入数据
     *
     * @param list
     */
    @Override
    public void inbanch(List<StarFansGroupRelationDo> list) {
        mongoDbService.insertInBatch(list,StarFansGroupRelationDo.class);
    }

    /**
     * 根据用户id和粉丝会查询这个明星粉丝会关系,没有就应该返回null
     * @param userUniId
     * @param starId
     */
    @Override
    public StarFansGroupRelationDo findStarFansGroupRelation(Long userUniId, Long starId) {
        //创建criteria对象
        Criteria criteria = Criteria
                .where("userUniId").is(userUniId)
                .and("starId").is(starId)
                /*.and("isDelete").is(IsValidEnums.NO)*/;
        //构建query
        Query query = new Query(criteria);
        //返回指定对象
        return mongoDbService.findOne(query, StarFansGroupRelationDo.class);
    }

    /**
     * 根据用户id查询所有粉丝会
     *
     * @param userUniId
     * @return
     */
    @Override
    public List<StarFansGroupRelationDo> findByUserUinId(Long userUniId) {
        //构建criteria //没有退出粉丝会才查出来
        Criteria criteria = Criteria.where("userUniId").is(userUniId)
                .and("isDelete").is(IsValidEnums.NO.getValue());
        //创建查询对象
        Query query = new Query(criteria).with(Sort.by(Sort.Order.desc("createTime")));
        //把粉丝关注的粉丝会都查出来
        return mongoDbService.findAll(query, StarFansGroupRelationDo.class);
    }

    /**
     * 查询粉丝会粉丝数量
     * exp：
     * @param starId
     * @return
     */
    @Override
    public Long getFansCountByStarId(Long starId) {
        //构建criteria //如果是用户退出了粉丝会，就不应该统计他
        Criteria criteria = Criteria
                .where("starId").is(starId)
                .and("isDelete").is(IsValidEnums.NO.getValue());
        //创建query
        Query query = new Query(criteria);
        //返回粉丝会的粉丝数量
        return mongoDbService.count(query, StarFansGroupRelationDo.class);
    }

    /**
     * 查询用户关注粉丝会的数量
     *
     * @param userUniId
     * @return
     */
    @Override
    public Long getFansCountByUserUinId(Long userUniId) {
        //构建criteria //必须是加入到粉丝会的才统计
        Criteria criteria = Criteria
                .where("userUniId").is(userUniId)
                .and("isDelete").is(IsValidEnums.NO.getValue());
        //实例化query
        Query query = new Query(criteria);
        //返回用户关注的粉丝会数量
        return mongoDbService.count(query.limit(10), StarFansGroupRelationDo.class);
    }

    /**
     * 获取粉丝会中指定权限的粉丝数量<br/>
     * exp：查询粉丝会关系表,然后统计粉丝会中普通/大咖/大使权限的粉丝数量
     *
     * @param starId
     * @param relationPermission
     * @return
     */
    @Override
    public Integer getPowerFansCount(Long starId, RelationPermissionEnum relationPermission) {
        //构建criteria
        Criteria criteria = Criteria
                .where("starId").is(starId)
                .and("power").is(relationPermission.getValue());

        Query query = new Query(criteria);

        return (int)mongoDbService.count(query, StarFansGroupRelationDo.class);
    }

    /**
     * 更新粉丝权限
     *
     * @param relationPermission
     * @param starFansGroupRelation
     */
    @Override
    public void updatePower(RelationPermissionEnum relationPermission, StarFansGroupRelationDo starFansGroupRelation) {
        //设置粉丝权限
        starFansGroupRelation.setPower(relationPermission.getValue());

        //构建criteria
        Criteria criteria = Criteria
                .where("userUniId").is(starFansGroupRelation.getUserUniId())
                .and("starId").is(starFansGroupRelation.getStarId());
        //构建query
        Query query = new Query(criteria);
        mongoDbService.update(query, starFansGroupRelation, StarFansGroupRelationDo.class);
    }

    /**
     *
     * @param starFansGroupRelation
     */
    @Override
    public void updateStarFansGroupRelation(StarFansGroupRelationDo starFansGroupRelation) {

        //构建criteria
        Criteria criteria = Criteria
                .where("userUniId").is(starFansGroupRelation.getUserUniId())
                .and("starId").is(starFansGroupRelation.getStarId());
        //构建query
        Query query = new Query(criteria);
        //更新数据
        mongoDbService.update(query, starFansGroupRelation, StarFansGroupRelationDo.class);
    }

    /**
     * 更新粉丝会贡献值/粉丝票数/送心票数/积分打榜/爱心数量
     *
     * @param userUniId 用户id
     * @param starId 明星id
     * @param voteTypeEnum 粉丝会数据
     * @param voteNum 票数
     */
    @Override
    public void updateVote(Long userUniId, Long starId, VoteTypeEnums voteTypeEnum, Long voteNum) {
        //构建criteria
        Criteria criteria = Criteria.where("userUniId").is(userUniId).and("starId").is(starId);
        //实例化Query
        Query query = new Query(criteria);


        //更新对象
        Update update = new Update();

        switch (voteTypeEnum){
            //比心(花钱的)
            case COIN_VOTE:
                update.inc("coinCount",voteNum);
                break;
             //积分打榜(不花钱的/送的)
            case INTEGRAL_VOTE:
                update.inc("integralCount",voteNum);
                break;
           //送爱心(做公益所增加的爱心值)
            case LOVE_VOTE:
                update.inc("gettingLoveCount",voteNum);
                break;
                //其他不操作
                default:
                    return;
        }
        //贡献值
        update.inc("fansContribute",voteNum);
        //票数
        update.inc("voteCount",voteNum);
        //执行原子更新
        mongoDbService.inc(query,update,StarFansGroupRelationDo.class);

    }

    /**
     * 更新是否删除字段
     *
     * @param sysUniId
     * @param starId
     * @param isValidEnums
     */
    @Override
    public void updateIsDelete(Long sysUniId, Long starId, IsValidEnums isValidEnums) {
        //构建criteria
        Criteria criteria = Criteria.where("userUniId").is(sysUniId).and("starId").is(starId);
        //实例化Query
        Query query = new Query(criteria);
        //更新
        Map map = new HashMap(1);
        map.put("isDelete",isValidEnums.getValue());
        mongoDbService.updateOne(query,map,StarFansGroupRelationDo.class);
    }

    /**
     * 获取粉丝会中指定权限的用户
     *
     * @param starId
     * @param relationPermissionEnum
     * @return
     */
    @Override
    public List<StarFansGroupRelationDo> getPowerFans(Long starId, RelationPermissionEnum relationPermissionEnum) {
        //构建criteria
        Criteria criteria = Criteria
                .where("starId").is(starId).and("isDelete").is(IsValidEnums.NO.getValue());
        //查询对象
        Query query = new Query(criteria);
        query.with(Sort.by(Sort.Direction.DESC,"fansContribute"));

        if (null != relationPermissionEnum ) {
                criteria.and("power").is(relationPermissionEnum.getValue());
                query.limit(50);
        }

        return  mongoDbService.findAll(query,StarFansGroupRelationDo.class);

    }

    /**
     * 查询用户投没投过票
     *
     * @param userUniId
     * @param starId
     * @return
     */
    @Override
    public boolean findVote(Long userUniId, Long starId) {

        //构建criteria //没有退出粉丝会才查出来
        Criteria criteria = Criteria
                .where("userUniId").is(userUniId)
                .and("starId").is(starId)
                .and("isDelete").is(IsValidEnums.NO.getValue());
        //创建查询对象
        Query query = new Query(criteria);
       return mongoDbService.findOne(query, StarFansGroupRelationDo.class).getVoteCount() > 0 ? true :false;

    }

    /**
     * 更新累计打榜天数
     *
     * @param userUniId
     * @param starId
     * @return
     */
    @Override
    public boolean updateVoteDayCount(Long userUniId, Long starId) {
        //查询条件
        Criteria criteria = Criteria
                .where("userUniId").is(userUniId)
                .and("starId").is(starId)
                .and("isDelete").is(IsValidEnums.NO.getValue());
        Query query = new Query(criteria);
        Update update = new Update();
        update.inc("voteDayCount");
        return mongoDbService.incByResult(query,update,StarFansGroupRelationDo.class);
    }

    /**
     * 根据粉丝会id删除关系
     *
     * @param starId
     */
    @Override
    public void updateIsDeleteBystarId(Long starId,IsValidEnums isDelete) {
        Criteria criteria = Criteria.where("starId").is(starId).and("isDelete").is(IsValidEnums.NO.getValue());
        Query query = new Query(criteria);
        Map map = new HashMap(1);
        map.put("isDelete",isDelete.getValue());
        mongoDbService.update(query,map,StarFansGroupRelationDo.class);
    }

    @Override
    public void insert(StarFansGroupRelationDo starFansGroupRelationDo) {
        Criteria criteria = Criteria.where("starId").is(starFansGroupRelationDo.getStarId()).and("userUniId").is(starFansGroupRelationDo.getUserUniId());
        mongoDbService.upsert(new Query(criteria),starFansGroupRelationDo,StarFansGroupRelationDo.class);
    }


}




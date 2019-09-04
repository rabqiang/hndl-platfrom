package com.hndl.cn.mongodb.utils;

import com.hndl.cn.base.enums.fans.FansGroupContributeEnums;
import com.hndl.cn.base.enums.vote.VoteTypeEnums;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/4/29 19:54
 * @Created by 湖南达联
 */
public class MongoDbUpdateUtils {

    public static void setFansContribute(Update update, Criteria criteria, FansGroupContributeEnums fansGroupContributeEnums){
        switch (fansGroupContributeEnums){
            case CALL:
                criteria.and("callCount").lt(fansGroupContributeEnums.getDayCount());
                break;
            case LIKE:
                criteria.and("likeCount").lt(fansGroupContributeEnums.getDayCount());
                break;
            case SUMMON:
                criteria.and("summonCount").lt(fansGroupContributeEnums.getDayCount());
                break;
            case GUARD:
                criteria.and("guardCount").lt(fansGroupContributeEnums.getDayCount());
                break;
            case COMMENT:
                criteria.and("commentCount").lt(fansGroupContributeEnums.getDayCount());
                break;
            default:
                return;
        }
        update.inc("fansContribute",fansGroupContributeEnums.getContributeCount());
    }

    public static void setFansStatistics(Update update,FansGroupContributeEnums fansGroupContributeEnums){
        switch (fansGroupContributeEnums){
            case CALL:
                update.inc("callCount", 1);
                break;
            case LIKE:
                update.inc("likeCount", 1);
                break;
            case SUMMON:
                update.inc("summonCount",1);
                break;
            case GUARD:
                update.inc("guardCount", 1);
                break;
            case COMMENT:
                update.inc("commentCount", 1);
                break;
            default:
                return;
        }
    }




    public static void   setVoteUpdate(Update update, VoteTypeEnums voteTypeEnums, Long voteNumber){
        update.inc("voteCount",voteNumber);
        update.inc("fansContribute",voteNumber);
        switch (voteTypeEnums){
            case COIN_VOTE:
                update.inc("coinCount",voteNumber);
                break;
            case INTEGRAL_VOTE:
                update.inc("integralCount",voteNumber);
                break;
            case LOVE_VOTE:
                update.inc("gettingLoveCount",voteNumber);
                break;
            default:
                return;
        }
    }
}

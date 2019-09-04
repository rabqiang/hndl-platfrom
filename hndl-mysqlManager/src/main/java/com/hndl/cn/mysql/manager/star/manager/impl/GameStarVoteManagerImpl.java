package com.hndl.cn.mysql.manager.star.manager.impl;

import com.hndl.cn.dao.game.bean.GameStarVoteDo;
import com.hndl.cn.dao.game.mapper.GameStarVoteDoMapper;
import com.hndl.cn.mysql.manager.star.manager.GameStarVoteManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program:hndl-platform
 * @description:TODO 粉丝会
 * @author: 易成贤
 * @create: 2019/7/17 14:35
 * @Created by湖南达联
 **/
@Service
public class GameStarVoteManagerImpl implements GameStarVoteManager {

    @Resource
    GameStarVoteDoMapper gameStarVoteDoMapper;

    /**
     * 获取一个新的粉丝会id
     *
     * @return 粉丝id
     */
    @Override
    public Long getNewStarId() {
        GameStarVoteDo gameStarVoteDo = new GameStarVoteDo();
        gameStarVoteDo.setVoteCount(0L);
        gameStarVoteDo.setLastOperator("获取Id使用");
        gameStarVoteDoMapper.insertAndGetId(gameStarVoteDo);
        return gameStarVoteDo.getId();
    }
}

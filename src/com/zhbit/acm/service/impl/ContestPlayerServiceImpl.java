package com.zhbit.acm.service.impl;

import com.zhbit.acm.dao.ContestPlayerDao;
import com.zhbit.acm.domain.ContestPlayer;
import com.zhbit.acm.domain.Score;
import com.zhbit.acm.service.ContestPlayerService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Cyril on 16/6/21.
 */

@Component(value = "contestPlayerService")
@Scope(value = "prototype")
public class ContestPlayerServiceImpl implements ContestPlayerService {

    private ContestPlayerDao playerDao;

    public ContestPlayerDao getContestPlayerDao() {
        return playerDao;
    }
    @Resource(name = "contestPlayerDao")
    public void setContestPlayerDao(ContestPlayerDao contestPlayerDao) {
        this.playerDao = contestPlayerDao;
    }

    @Override
    public boolean exist(String userName, int contestId) {
        if (playerDao.getContsetId(userName,contestId)!=null)
            return true;
        return false;
    }

    @Override
    public boolean join(String userName, int contestId) {
        ContestPlayer player = new ContestPlayer();
        player.setContestId(contestId);
        player.setUserName(userName);
        playerDao.save(player);
        return true;
    }

}

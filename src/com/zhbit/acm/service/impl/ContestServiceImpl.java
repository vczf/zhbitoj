package com.zhbit.acm.service.impl;

import com.zhbit.acm.dao.ContestDao;
import com.zhbit.acm.dao.ScoreDao;
import com.zhbit.acm.domain.Contest;
import com.zhbit.acm.domain.Score;
import com.zhbit.acm.service.ContestService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Cyril on 16/6/19.
 */


@Component(value = "contestService")
@Scope(value = "prototype")
public class ContestServiceImpl implements ContestService {

    private ContestDao contestDao;

    private ScoreDao scoreDao;

    public ContestDao getContestDao() {
        return contestDao;
    }

    @Resource(name="scoreDao")
    public void setScoreDao(ScoreDao scoreDao) {
        this.scoreDao = scoreDao;
    }

    @Resource(name="contestDao")
    public void setContestDao(ContestDao contestDao) {
        this.contestDao = contestDao;
    }

    @Override
    public Contest getContestById(int id) {
        return contestDao.getContestById(id);
    }

    @Override
    public List<Score> getRanking(int contestId){
        return scoreDao.getPlayerScoreByContestId(contestId);
    }

    @Override
    public List ShowContestsByPage(int page) {
        return contestDao.showContestsByPage(page);
    }

    @Override
    public int getPageCount() {
        int count = contestDao.getContestCount();
        return (count+19) / 20;
    }

    public Contest getAllContestInfoById(int id) {
        return contestDao.getContestById(id);
    }

}

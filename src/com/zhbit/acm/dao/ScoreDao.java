package com.zhbit.acm.dao;

import com.zhbit.acm.domain.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.script.Compilable;
import java.util.*;

/**
 * Created by Cyril on 16/6/22.
 */
@Component("scoreDao")
@Scope(value = "prototype")
public class ScoreDao {
    private ContestDao contestDao;

    private final int WRONG_PUNISH = 20;

    @Resource(name = "contestDao")
    public void setContestDao(ContestDao contestDao) {
        this.contestDao = contestDao;
    }

    public List<Score> getPlayerScoreByContestId(int contestId){
        List<Score> list = new ArrayList<>();

        Contest contest = contestDao.getContestById(contestId);

//      比赛开始时间
        Date contestStartTime = contest.getStart_time();

        Set<ContestPlayer> players = contest.getPlayers();

        for (ContestPlayer player:players){
//          初始化一个新的个人成绩
            Score score = new Score();
            score.setUserName(player.getUserName());
            int wrongCount = 0;
            for (ContestRanking r:player.getRankings()){
                UserProblemScore userProblemScore = new UserProblemScore();
//              如果该题目AC了 , 将AC所用的秒数放入userProblemScore中.
                if (r.getAcTime()!=null){
                    int ttime = (int) (r.getAcTime().getTime()-contestStartTime.getTime())/1000;

                    userProblemScore.setAcTime(ttime);

                    score.setScore(score.getScore()+1);
                    score.setTotleTime(score.getTotleTime()+ttime);
                    wrongCount+=r.getSubmit();
                }
//              在每一个格子中添加wrong次数 显示表单用
                userProblemScore.setWrongCount(r.getSubmit());

//              添加进map用
                score.getProblemScore().put(r.getProblemId(),userProblemScore);
            }
            score.setTotleTime(score.getTotleTime()+wrongCount*this.WRONG_PUNISH*60);
            list.add(score);
        }

//      对list进行排序  按照规则,先按照AC数较多者,再按照总时间(包括罚时)较少者
        Collections.sort(list);

        return list;
    }
}

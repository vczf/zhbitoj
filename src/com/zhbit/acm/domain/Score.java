package com.zhbit.acm.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cyril on 16/6/22.
 */
public class Score implements Comparable<Score>{
    private String userName;
//  做题数
    private int score;
//  所花时间
    private int totleTime;
    private Map<Integer,UserProblemScore> problemScore;

    public Score() {
        this.userName = "";
        this.score = 0;
        this.totleTime = 0;
        this.problemScore = new HashMap<Integer,UserProblemScore>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotleTime() {
        return totleTime;
    }

    public void setTotleTime(int totleTime) {
        this.totleTime = totleTime;
    }

    public Map<Integer, UserProblemScore> getProblemScore() {
        return problemScore;
    }

    public void setProblemScore(Map<Integer, UserProblemScore> problemScore) {
        this.problemScore = problemScore;
    }


     public String intToTime(){
        Integer cnt = this.totleTime;
        String ans = "";
        ans = String.valueOf(cnt/3600);
        cnt%=3600;
        ans = ans + ":" + String.valueOf(cnt/60)+":"+String.valueOf(cnt%60);
        return ans;
    }

    @Override
    public int compareTo(Score o) {
        if (this.score!=o.score)
            return o.score-this.score;
        if (this.totleTime!=o.totleTime)
            return this.totleTime-o.totleTime;

        return this.userName.compareTo(o.userName);
    }

}



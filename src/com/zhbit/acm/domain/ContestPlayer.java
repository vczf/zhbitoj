package com.zhbit.acm.domain;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by Cyril on 16/6/20.
 */
public class ContestPlayer implements Serializable{
    private int contestId;
    private String userName;
    private Set<ContestRanking> rankings;

    public Set<ContestRanking> getRankings() {
        return rankings;
    }

    public void setRankings(Set<ContestRanking> rankings) {
        this.rankings = rankings;
    }

    public int getContestId() {
        return contestId;
    }

    public void setContestId(int contestId) {
        this.contestId = contestId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean equals(Object obj){
        if(obj==this) return true;
        if(!(obj instanceof ContestProblem)) return false;
        ContestPlayer test = (ContestPlayer) obj;
        if(userName.equals(test.getUserName())&&
                contestId == test.getContestId()) return true;
        return false;
    }
    public int hashCode(){
        return new HashCodeBuilder().append(userName)
                .append(contestId).toHashCode();
    }
}

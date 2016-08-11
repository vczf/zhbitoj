package com.zhbit.acm.domain;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Cyril on 16/6/21.
 */
public class ContestRanking implements Serializable {
    private int contestId;
    private String userName;
    private int problemId;
    private Date acTime;
    private int submit;


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

    public int getProblemId() {
        return problemId;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }

    public Date getAcTime() {
        return acTime;
    }

    public void setAcTime(Date acTime) {
        this.acTime = acTime;
    }

    public int getSubmit() {
        return submit;
    }

    public void setSubmit(int submit) {
        this.submit = submit;
    }

    public boolean equals(Object obj){
        if(obj==this) return true;
        if(!(obj instanceof ContestProblem)) return false;
        ContestRanking test = (ContestRanking) obj;
        if(userName.equals(test.getUserName())&&
                contestId == test.getContestId() &&
                problemId == test.getProblemId())
            return true;
        return false;
    }
    public int hashCode(){
        return new HashCodeBuilder().append(userName)
                .append(contestId).append(problemId).toHashCode();
    }
}

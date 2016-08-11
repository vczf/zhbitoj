package com.zhbit.acm.domain;


import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by czf on 16-6-17.
 */
public class ContestProblem implements Serializable{
    private Integer problemid;
    private Integer contestid;
    private String title;
    private Date time;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getProblemid() {
        return problemid;
    }

    public void setProblemid(Integer problemid) {
        this.problemid = problemid;
    }

    public Integer getContestid() {
        return contestid;
    }

    public void setContestid(Integer contestid) {
        this.contestid = contestid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public boolean equals(Object obj){
        if(obj==this) return true;
        if(!(obj instanceof ContestProblem)) return false;
        ContestProblem test = (ContestProblem) obj;
        if(problemid.equals(test.getProblemid())&&
                contestid.equals(test.getContestid())) return true;
        return false;
    }
    public int hashCode(){
        return new HashCodeBuilder().append(problemid)
                .append(contestid).toHashCode();

    }
}

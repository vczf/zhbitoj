package com.zhbit.acm.domain;

import java.util.Date;

/**
 * Created by Cyril on 16/6/22.
 */
public class UserProblemScore {
    private Integer acTime;
    private int wrongCount;

    public UserProblemScore() {
        acTime = null;
        wrongCount = 0;
    }

    public Integer getAcTime() {
        return acTime;
    }

    public void setAcTime(Integer acTime) {
        this.acTime = acTime;
    }

    public int getWrongCount() {
        return wrongCount;
    }

    public void setWrongCount(int wrongCount) {
        this.wrongCount = wrongCount;
    }

    @Override
    public String toString() {
        StringBuffer string = new StringBuffer("");
        if (acTime!=null){
            string.append(intToTime(acTime));
            string.append("(-"+ String .valueOf(wrongCount) +")");
        }
        else if (wrongCount>0){
            string.append("(-"+ String .valueOf(wrongCount) +")");
        }
        return  string.toString();
    }

    static public String intToTime(int num){
        Integer cnt = num;
        String ans = "";
        ans = String.valueOf(cnt/3600);
        cnt%=3600;
        ans = ans + ":" + String.valueOf(cnt/60)+":"+String.valueOf(cnt%60);
        return ans;
    }
}

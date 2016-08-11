package com.zhbit.acm.service;

import com.zhbit.acm.domain.Contest;
import com.zhbit.acm.domain.Score;

import java.util.List;

/**
 * Created by Cyril on 16/6/19.
 */
public interface ContestService {

    public Contest getContestById(int id);

    List<Score> getRanking(int contestId);

    public List ShowContestsByPage(int page);

    public int getPageCount();

}

package com.zhbit.acm.dao;

import com.zhbit.acm.domain.ContestProblem;
import com.zhbit.acm.domain.Problem;

import java.util.List;

/**
 * Created by Cyril on 16/6/6.
 */
public interface ContestProblemDao {

    public List<ContestProblem> showContestProblem(int contestId);

    public ContestProblem getContestProblemById(int problemId,int contestId);
}

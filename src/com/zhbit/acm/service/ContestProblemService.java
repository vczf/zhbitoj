package com.zhbit.acm.service;

import com.zhbit.acm.domain.Contest;
import com.zhbit.acm.domain.ContestProblem;
import com.zhbit.acm.domain.Problem;

import java.util.List;

/**
 * Created by Cyril on 16/6/19.
 */
public interface ContestProblemService {

    public Problem showProblem(int problemId,int contestId);

    public List<ContestProblem> showProblemsByContsetId(int contestId);

}

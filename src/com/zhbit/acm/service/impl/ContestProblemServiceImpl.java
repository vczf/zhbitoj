package com.zhbit.acm.service.impl;

import com.zhbit.acm.dao.ContestProblemDao;
import com.zhbit.acm.dao.ProblemDao;
import com.zhbit.acm.domain.ContestProblem;
import com.zhbit.acm.domain.Problem;
import com.zhbit.acm.service.ContestProblemService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Cyril on 16/6/18.
 */

@Component(value = "contestProblemService")
@Scope("prototype")
public class ContestProblemServiceImpl implements ContestProblemService {

    private ContestProblemDao contestProblemDao;
    private ProblemDao problemDao;

    @Override
    public Problem showProblem(int problemId, int contestId) {
        Problem problem = problemDao.getProblemById(problemId);
        ContestProblem contestProblem = contestProblemDao.getContestProblemById(problemId,contestId);
        if (problem!=null && contestProblem!=null)
            problem.setTitle(contestProblem.getTitle());
        return problem;
    }

    @Override
    public List<ContestProblem> showProblemsByContsetId(int contestId) {
        return contestProblemDao.showContestProblem(contestId);
    }

    @Resource(name = "contestProblemDao")
    public void setContestProblemDao(ContestProblemDao contestProblemDao) {
        this.contestProblemDao = contestProblemDao;
    }

    @Resource(name = "problemDao")
    public void setProblemDao(ProblemDao problemDao) {
        this.problemDao = problemDao;
    }
}

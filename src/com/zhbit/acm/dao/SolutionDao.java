package com.zhbit.acm.dao;


import com.zhbit.acm.domain.Solution;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Cyril on 16/6/6.
 */
public interface SolutionDao {

    public List<Solution> searchSolution();

    public List<Solution> getSolutionsByContextId(int contextID, int pageId);

    public int getSolutionCount(int contestId);

    void add(Solution solution, String source);

    @Transactional(readOnly = true,rollbackForClassName = "Exception")
    List searchContest(Integer problemId, String userName, int language, int result);

    public Solution getSolutionById(int id);
}

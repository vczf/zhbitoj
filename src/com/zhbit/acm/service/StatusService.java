package com.zhbit.acm.service;


import com.zhbit.acm.domain.Solution;

import java.util.List;

/**
 * Created by Cyril on 16/6/6.
 */

public interface StatusService {

    public int getPageCount(int contestId);

    public List<Solution> showStatusByContextId(int contextID, int pageId);


    public void submit(Solution solution,String source);

    List searchSolutions(Integer problemId, String userName, int language, int result);

    Solution getSolutionById(int id);
}

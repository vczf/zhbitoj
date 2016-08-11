package com.zhbit.acm.service.impl;

import com.zhbit.acm.dao.SolutionDao;
import com.zhbit.acm.domain.Solution;
import com.zhbit.acm.service.StatusService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Cyril on 16/6/6.
 */

@Component(value = "statusService")
@Scope(value = "prototype")
public class StatusServiceImpl implements StatusService {

    private SolutionDao solutionDao;



    public SolutionDao getSolutionDao() {
        return solutionDao;
    }

    @Resource(name = "solutionDao")
    public void setSolutionDao(SolutionDao solutionDao) {
        this.solutionDao = solutionDao;
    }

    @Override
    public int getPageCount(int contestId){
        return (solutionDao.getSolutionCount(contestId)+19)/20;
    }

    @Override
    public List<Solution> showStatusByContextId(int contextID,int pageId){
        return solutionDao.getSolutionsByContextId(contextID,pageId);
    }

    @Override
    public void submit(Solution solution, String source) {
        solution.setCodeLength(source.length());
        solution.setResult(0);
        solution.setInDate(new Date());
        solutionDao.add(solution,source);
    }

    @Override
    public List searchSolutions(Integer problemId,String userName,int language,int result){
        if (userName.equals(""))
            userName = null;
        return solutionDao.searchContest(problemId,userName,language,result);
    }

    @Override
    public Solution getSolutionById(int id){
        return solutionDao.getSolutionById(id);
    }
}

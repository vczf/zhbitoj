package com.zhbit.acm.service.impl;

import com.zhbit.acm.dao.ProblemDao;
import com.zhbit.acm.domain.Problem;
import com.zhbit.acm.service.ProblemService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Cyril on 16/6/6.
 */
@Component(value = "problemService")
@Scope(value = "prototype")
public class ProblemServicesImpl implements ProblemService {
    private ProblemDao problemDao;

    public ProblemDao getUserDao() {
        return problemDao;
    }

    @Resource(name = "problemDao")
    public void setUserDao(ProblemDao problemDao) {
        this.problemDao = problemDao;
    }

    @Override
    public List<Problem> showAllProblems(){
        return problemDao.getAllProBlems();
    }


    @Override
    public List showProblemByPage(int page){
        return problemDao.getAllProBlemsByPage(page);
    }

    @Override
    public List showProblemByPageFromAdmin(int page){
        return problemDao.getAllProBlemsByPageFromAdmin(page);
    }




    @Override
    public int getPageCount(){
        return (problemDao.getProblemCount()+19)/20;
    }

    @Override
    public int getPageCountFromAdmin(){
        return (problemDao.getProblemCountFromAdmin()+19)/20;
    }



    @Override
    public Problem showProblemById(int id){
        Problem problem = problemDao.getProblemById(id);
        if (problem==null || problem.isDelete())
            return null;
        return problem;
    }

    @Override
    public Problem showContestProblemById(){
        return null;
    }

    @Override
    public List search(String type,String text){
        if ("source".equals(type)||"title".equals(type))
            return problemDao.searchProBlems(type,text);
        return null;
    }
}

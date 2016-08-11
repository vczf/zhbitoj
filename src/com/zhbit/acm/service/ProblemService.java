package com.zhbit.acm.service;

import com.zhbit.acm.dao.ProblemDao;
import com.zhbit.acm.domain.Problem;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;



public interface ProblemService {


    public List<Problem> showAllProblems();


    List showProblemByPage(int page);
    List showProblemByPageFromAdmin(int page);

    int getPageCount();
    int getPageCountFromAdmin();
    public Problem showProblemById(int id);

    Problem showContestProblemById();

    public List search(String type, String text);
}

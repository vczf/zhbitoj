package com.zhbit.acm.dao;

import com.zhbit.acm.domain.Problem;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Cyril on 16/6/6.
 */
public interface ProblemDao {


    public List<Problem> getAllProBlems();
    int getProblemCount();
    int getProblemCountFromAdmin();
    @Transactional(readOnly = true,rollbackForClassName = "Exception")
    List<Problem> getAllProBlemsByPage(int page);
    @Transactional(readOnly = true,rollbackForClassName = "Exception")
    List<Problem> getAllProBlemsByPageFromAdmin(int page);

    public List<Problem> searchProBlems(String type, String text);

    public Problem getProblemById(int id);

    public void add(Problem problem);


}

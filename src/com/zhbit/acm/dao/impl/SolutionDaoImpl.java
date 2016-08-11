package com.zhbit.acm.dao.impl;

import com.opensymphony.xwork2.ActionContext;
import com.zhbit.acm.dao.SolutionDao;
import com.zhbit.acm.domain.Solution;
import com.zhbit.acm.domain.SourceCode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Cyril on 16/6/17.
 */
@Transactional
@Component(value = "solutionDao")
@Scope(value = "prototype")
public class SolutionDaoImpl implements SolutionDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Solution> getSolutionsByContextId(int id,int pageId) {
        final String HQL = "FROM Solution s WHERE s.contextId=:contextId ORDER BY s.solutionId DESC";
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery(HQL);
        query.setInteger("contextId",id);


        query.setFirstResult((pageId-1)*20);
        query.setMaxResults(20);
        return query.list();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Solution> searchSolution() {
        return null;
    }


    @Transactional(readOnly = true)
    @Override
    public int getSolutionCount(int contestId) {

        final String HQL = "SELECT COUNT(*) FROM Solution s WHERE s.contextId=:contextId ORDER BY s.solutionId DESC";
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery(HQL);
        query.setInteger("contextId",contestId);
        Long ans = (Long) query.list().get(0);
        return ans.intValue();
    }

    @Override
    @Transactional(rollbackForClassName = "Exception")
    public void add(Solution solution, String source){

        Session session = sessionFactory.getCurrentSession();
        session.save(solution);

        int solutionId  = solution.getSolutionId();

        SourceCode sourceCode = new SourceCode();

        sourceCode.setSolutionId(solutionId);
        sourceCode.setSource(source);
        sourceCode.setIsDelete(false);
        session.save(sourceCode);

    }

    @Override
    @Transactional(readOnly = true,rollbackForClassName = "Exception")
    public List searchContest(Integer problemId, String userName, int language, int result){
        List<Solution> list = null;
        String HQL = "From Solution s WHERE s.contextId = 0";
        Session session = sessionFactory.getCurrentSession();
        if (problemId!=null)
            HQL = HQL + " AND s.problemId = ? ";
        if (userName!=null&&!userName.equals(""))
            HQL = HQL + " AND s.userName = ? ";
        if (language!=-1)
            HQL = HQL + " AND s.language = ? ";
        if (result!=-1)
            HQL = HQL + " AND s.result = ? ";

        int cnt = 0;
        Query query = session.createQuery(HQL+" ORDER BY s.inDate DESC  ");


        if (problemId!=null)
            query.setParameter(cnt++,problemId);
        if (userName!=null)
            query.setParameter(cnt++,userName);
        if (language!=-1)
            query.setParameter(cnt++,language);
        if (result!=-1)
            query.setParameter(cnt++,result);

        list = query.list();


        return list;
    }


    @Override
    @Transactional(readOnly = true,rollbackForClassName = "Exception")
    public Solution getSolutionById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Solution solution = (Solution) session.get(Solution.class,id);
        if (solution==null || solution.isDelete())
            return null;
        return solution;
    }
}

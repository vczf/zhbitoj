package com.zhbit.acm.dao.impl;

import com.zhbit.acm.dao.ContestProblemDao;
import com.zhbit.acm.domain.ContestProblem;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.query.spi.HQLQueryPlan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Cyril on 16/6/6.
 */
@Component(value = "contestProblemDao")
@Scope(value = "prototype")
@Transactional
public class ContestProblemDaoImpl implements ContestProblemDao {

    private SessionFactory sessionFactory;

    @Override

    public List<ContestProblem> showContestProblem(int contestId) {
        final String HQL = "FROM ContestProblem cs WHERE cs.contestid=:contestId ORDER BY cs.time";

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(HQL);
        query.setInteger("contestId",contestId);


        return query.list();
    }

    @Override
    public ContestProblem getContestProblemById(int problemId,int contestId) {
        final String HQL = "FROM ContestProblem cp WHERE cp.contestid = ? AND cp.problemid = ?";

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(HQL);
        query.setParameter(0,contestId);
        query.setParameter(1,problemId);
        List<ContestProblem> list = query.list();
        if (list!=null&&list.size()>0)
            return list.get(0);
        else
            return null;
    }


    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}

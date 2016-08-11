package com.zhbit.acm.dao.impl;


import com.zhbit.acm.dao.ContestDao;
import com.zhbit.acm.domain.Contest;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Cyril on 16/6/6.
 */
@Component(value = "contestDao")
@Scope(value = "prototype")
public class ContestDaoImpl implements ContestDao {


    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(readOnly = true,rollbackForClassName = "Exception")
    public int getContestCount() {
        Session session = sessionFactory.getCurrentSession();

        final String  HQL = "SELECT COUNT(*) FROM Contest";

        Query query = session.createQuery(HQL);
        Long ans = (Long) query.list().get(0);

        return ans.intValue();
    }

    @Override
    @Transactional(readOnly = true,rollbackForClassName = "Exception")
    public List<Contest> showContestsByPage(int page) {
        Session session = sessionFactory.getCurrentSession();
        String HQL = "SELECT new Contest(c.contest_id, c.title, c.start_time, c.end_time) FROM Contest c ORDER BY c.contest_id DESC";
        Query query = session.createQuery(HQL);
        query.setFirstResult((page-1)*20);
        query.setMaxResults(20);
        return query.list();
    }

    @Override
    @Transactional(readOnly = true,rollbackForClassName = "Exception")
    public Contest getContestById(int id) {
        Session session = sessionFactory.getCurrentSession();

        return (Contest) session.get(Contest.class,id);
    }
}

package com.zhbit.acm.dao.impl;

import com.zhbit.acm.dao.ContestPlayerDao;
import com.zhbit.acm.domain.ContestPlayer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Cyril on 16/6/21.
 */

@Component(value = "contestPlayerDao")
@Scope(value = "prototype")
@Transactional
public class ContestPlayerDaoImpl implements ContestPlayerDao{

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(rollbackForClassName = "Exception")
    public ContestPlayer getContsetId(String userName, int contestId) {
        final String HQL = "FROM ContestPlayer cp WHERE cp.userName = :userName AND cp.contestId = :contestId";

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(HQL);
        query.setString("userName",userName);
        query.setInteger("contestId",contestId);
        List<ContestPlayer> list = query.list();

        if (list==null||list.isEmpty())
            return null;
        else
            return list.get(0);
    }

    @Override
    @Transactional(rollbackForClassName = "Exception")
    public boolean save(ContestPlayer cp) {

        if (getContsetId(cp.getUserName(),cp.getContestId())==null){
            Session session = sessionFactory.getCurrentSession();
            session.save(cp);
            return true;
        }
        else
            return false;
    }
}

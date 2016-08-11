package com.zhbit.acm.dao.impl;

import com.zhbit.acm.dao.UserDao;
import com.zhbit.acm.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.query.spi.HQLQueryPlan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;

import javax.annotation.Resource;

/**
 * Created by Cyril on 16/6/16.
 */

@Transactional
@Component(value = "userDao")
@Scope(value = "prototype")
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource()
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(rollbackForClassName = "Exception")
    public void add(User user) {
        Session session = sessionFactory.getCurrentSession();

        session.save(user);

    }

    @Override
    @Transactional(rollbackForClassName = "Exception")
    public void edit(String userName, String nick, String note, String newpassword, String school, String email){
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class,userName);
        user.setNick(nick);
        user.setNote(note);
        user.setStudentId(school);
        user.setEmail(email);

        if (!newpassword.equals(""))
            user.setPassword(newpassword);
        session.save(user);
    }

    @Override
    @Transactional(rollbackForClassName = "Exception")
    public User modify(String name) throws Exception{
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class,name);

//      To be continue;
        return user;
    }

    @Transactional
    @Override
    public int getStatusCount(String userName, int status){
        int num = 0;
        String  HQL = "SELECT COUNT(*) FROM Solution s WHERE s.result=? AND s.userName=? AND s.contextId=0";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(HQL);
        query.setParameter(0,status);
        query.setParameter(1,userName);
        Long ans = (Long) query.list().get(0);
        return ans.intValue();

    }

    @Transactional(rollbackForClassName = "Exception",readOnly = true)
    @Override
    public User getUser(String name) {
        Session session = sessionFactory.getCurrentSession();

        return (User) session.get(User.class,name);
    }

    @Override
    public void Delete() {

    }

    @Override
    public int getSubmitCount(String userName) {
        int num = 0;
        String  HQL = "SELECT COUNT(*) FROM Solution s WHERE  s.userName=? AND s.contextId=0";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(HQL);
        query.setParameter(0,userName);
        Long ans = (Long) query.list().get(0);
        return ans.intValue();
    }
}

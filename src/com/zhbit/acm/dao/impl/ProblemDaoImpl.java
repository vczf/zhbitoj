package com.zhbit.acm.dao.impl;

import com.opensymphony.xwork2.ActionContext;
import com.zhbit.acm.dao.ProblemDao;
import com.zhbit.acm.domain.Problem;
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
 * Created by Cyril on 16/6/15.
 */
@Transactional
@Component(value = "problemDao")
@Scope(value = "prototype")
public class ProblemDaoImpl implements ProblemDao{


    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(readOnly = true,rollbackForClassName = "Exception")
    public List<Problem> getAllProBlems() {
        Session session = sessionFactory.getCurrentSession();
        String HQL = "SELECT new Problem(p.problemId,p.title,p.ac,p.submit) FROM Problem p WHERE p.delete=FALSE";
        Query query = session.createQuery(HQL);
        return query.list();
    }


    @Override
    public int getProblemCount(){
        Session session = sessionFactory.getCurrentSession();
        String HQL="SELECT COUNT(*) FROM Problem p WHERE p.delete=FALSE AND p.hide = FALSE";

        Query query = session.createQuery(HQL);
        Long count = (Long)query.list().get(0);
        return count.intValue();
    }

    @Override
    public int getProblemCountFromAdmin(){
        Session session = sessionFactory.getCurrentSession();
        String HQL="SELECT COUNT(*) FROM Problem p WHERE p.delete=FALSE";
        Query query = session.createQuery(HQL);
        Long count = (Long)query.list().get(0);
        return count.intValue();
    }


    @Override
    @Transactional(readOnly = true,rollbackForClassName = "Exception")
    public List<Problem> getAllProBlemsByPage(int page) {
        Session session = sessionFactory.getCurrentSession();
        String HQL="SELECT new Problem(p.problemId,p.title,p.ac,p.submit) FROM Problem p WHERE p.delete=FALSE AND p.hide = FALSE";
        Query query = session.createQuery(HQL);
        query.setFirstResult((page-1)*20);
        query.setMaxResults(20);
        return query.list();
    }


    @Override
    @Transactional(readOnly = true,rollbackForClassName = "Exception")
    public List<Problem> getAllProBlemsByPageFromAdmin(int page) {
        Session session = sessionFactory.getCurrentSession();
        String HQL="SELECT new Problem(p.problemId,p.title,p.ac,p.submit,p.hide) FROM Problem p WHERE p.delete=FALSE";
        Query query = session.createQuery(HQL);
        query.setFirstResult((page-1)*20);
        query.setMaxResults(20);
        return query.list();
    }


    @Override
    @Transactional(readOnly=true)
    public List<Problem> searchProBlems(String type, String text) {
        String HQL = "SELECT new Problem(p.problemId,p.title,p.ac,p.submit) FROM Problem p WHERE p.delete=FALSE AND p.hide = FALSE AND "+ type +" LIKE ?";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(HQL);
        query.setParameter(0,"%"+ text +"%");

        return query.list();
    }

    @Override
    public Problem getProblemById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Problem problem = (Problem) session.get(Problem.class,id);
        if(problem==null || problem.isDelete())
            return null;
        return problem;
    }


    @Override
    public void add(Problem problem) {}
}

package com.zhbit.acm.dao.impl;


import com.zhbit.acm.dao.SourceCodeDao;
import com.zhbit.acm.domain.SourceCode;
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
@Component(value = "sourceCodeDao")
@Scope(value = "prototype")
@Transactional
public class SourceCodeDaoImpl implements SourceCodeDao{


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
    public void add(SourceCode sourceCode) throws Exception{
        Session session = sessionFactory.getCurrentSession();
        session.save(sourceCode);
    }

    @Override
    @Transactional(readOnly = true)
    public SourceCode getSourceCodeById(int id) {

        Session session = sessionFactory.getCurrentSession();

        SourceCode sourceCode = (SourceCode) session.get(SourceCode.class,id);

        if (sourceCode==null||sourceCode.getIsDelete())
            return null;
        return sourceCode;
    }
}

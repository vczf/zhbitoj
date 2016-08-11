package com.zhbit.acm.dao.impl;

import com.zhbit.acm.dao.CompileDao;
import com.zhbit.acm.domain.Compile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Cyril on 16/6/22.
 */

@Component(value = "compileDao")
@Scope(value = "prototype")
@Transactional
public class CompileDaoImpl implements CompileDao {

    private SessionFactory sessionFactory;

    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Transactional(readOnly = true)
    @Override
    public Compile getCompileBySolutionId(int solutionId) {
        Session session = sessionFactory.getCurrentSession();

        Compile compile = (Compile) session.get(Compile.class,solutionId);

        if (compile==null && compile.isDelete())
            return null;

        return compile;
    }
}

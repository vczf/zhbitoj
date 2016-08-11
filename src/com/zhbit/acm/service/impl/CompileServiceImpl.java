package com.zhbit.acm.service.impl;

import com.zhbit.acm.dao.CompileDao;
import com.zhbit.acm.domain.Compile;
import com.zhbit.acm.service.CompileService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Cyril on 16/6/22.
 */
@Component(value = "compileService")
@Scope(value = "prototype")
public class CompileServiceImpl implements CompileService {

    private CompileDao dao;


    public Compile getCompileBySolutionId(int solutionId){
        return dao.getCompileBySolutionId(solutionId);
    }

    @Resource(name = "compileDao")
    public void setDao(CompileDao dao) {
        this.dao = dao;
    }
}

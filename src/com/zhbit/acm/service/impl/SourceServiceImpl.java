package com.zhbit.acm.service.impl;

import com.zhbit.acm.dao.SourceCodeDao;
import com.zhbit.acm.domain.SourceCode;
import com.zhbit.acm.service.SourceService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Cyril on 16/6/18.
 */

@Component(value = "sourceService")
@Scope("prototype")
public class SourceServiceImpl implements SourceService {

    private SourceCodeDao sourceCodeDao;


    public SourceCodeDao getSourceCodeDao() {
        return sourceCodeDao;
    }
    @Resource(name = "sourceCodeDao")
    public void setSourceCodeDao(SourceCodeDao sourceCodeDao) {
        this.sourceCodeDao = sourceCodeDao;
    }

    @Override
    public SourceCode getSourceById(int id) {
        return sourceCodeDao.getSourceCodeById(id);
    }
}

package com.zhbit.acm.dao;

import com.zhbit.acm.domain.Compile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Cyril on 16/6/6.
 */
public interface CompileDao {

    public Compile getCompileBySolutionId(int solutionId);

}

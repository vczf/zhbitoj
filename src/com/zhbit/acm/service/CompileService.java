package com.zhbit.acm.service;

import com.zhbit.acm.domain.Compile;

/**
 * Created by Cyril on 16/6/22.
 */
public interface CompileService {

    public Compile getCompileBySolutionId(int solutionId);
}

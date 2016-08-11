package com.zhbit.acm.dao;


import com.zhbit.acm.domain.SourceCode;

import java.util.List;

/**
 * Created by Cyril on 16/6/6.
 */
public interface SourceCodeDao {


    public void add(SourceCode sourceCode) throws Exception;

    public SourceCode getSourceCodeById(int Id);
}

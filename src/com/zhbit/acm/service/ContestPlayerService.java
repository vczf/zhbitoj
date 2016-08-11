package com.zhbit.acm.service;

/**
 * Created by Cyril on 16/6/21.
 */
public interface ContestPlayerService {

    public boolean exist(String userName,int contestId);

    public boolean join(String userName,int contestId);
}

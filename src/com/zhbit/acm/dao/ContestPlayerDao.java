package com.zhbit.acm.dao;


import com.zhbit.acm.domain.ContestPlayer;

/**
 * Created by Cyril on 16/6/21.
 */
public interface ContestPlayerDao {

    public ContestPlayer getContsetId(String userName, int contestId);

    public boolean save(ContestPlayer cp);
}

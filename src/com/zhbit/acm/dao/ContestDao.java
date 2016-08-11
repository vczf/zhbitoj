package com.zhbit.acm.dao;


import com.zhbit.acm.domain.Contest;

import java.util.List;

/**
 * Created by Cyril on 16/6/6.
 */
public interface ContestDao {

    public int getContestCount();

    public List<Contest> showContestsByPage(int page);

    public Contest getContestById(int id);


}

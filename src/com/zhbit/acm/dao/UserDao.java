package com.zhbit.acm.dao;


import com.zhbit.acm.domain.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Cyril on 16/6/6.
 */
public interface UserDao {

    public void add(User user);

    @Transactional(rollbackForClassName = "Exception")
    void edit(String userName, String nick, String note, String newpassword, String school, String email);

    User modify(String name) throws Exception;

    @Transactional
    int getStatusCount(String userName, int status);

    public User getUser(String name);
    public void Delete();

    int getSubmitCount(String userName);
}

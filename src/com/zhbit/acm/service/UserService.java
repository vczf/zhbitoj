package com.zhbit.acm.service;

import com.zhbit.acm.domain.User;

/**
 * Created by Cyril on 16/6/14.
 */
public interface UserService {

    public User getUserByName(String name);

    public User modify();

    public boolean add(User user);

    int getStatusCount(String userName, int status);

    boolean exist(String name);

    void edit(String userName, String nick, String note, String newpassword, String school, String email);

    int getSubmitCount(String userName);
}

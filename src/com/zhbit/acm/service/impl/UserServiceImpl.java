package com.zhbit.acm.service.impl;

import com.zhbit.acm.dao.UserDao;
import com.zhbit.acm.domain.User;
import com.zhbit.acm.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by Cyril on 16/6/16.
 */

@Component(value = "userService")
@Scope(value = "prototype")
public class UserServiceImpl implements UserService {


    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    @Resource(name = "userDao")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUserByName(String name) {
        return userDao.getUser(name);
    }

    @Override
    public User modify() {
        return null;
    }

    @Override
    public boolean add(User user) {
        User u = userDao.getUser(user.getUserName());
        if (u == null) {
            user.setRegTime(new Date());
            user.setRole(0);
            userDao.add(user);
            return true;
        } else
            return false;
    }

    @Override
    public int getStatusCount(String userName, int status){
        return userDao.getStatusCount(userName,status);
    }

    @Override
    public boolean exist(String name) {
        return userDao.getUser(name) != null;
    }

    @Override
    public void edit(String userName, String nick, String note, String newpassword, String school, String email) {
        userDao.edit(userName,nick,note,newpassword,school,email);
    }

    @Override
    public int getSubmitCount(String userName) {
        return userDao.getSubmitCount(userName);
    }
}
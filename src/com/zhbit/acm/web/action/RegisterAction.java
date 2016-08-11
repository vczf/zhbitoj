package com.zhbit.acm.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.acm.domain.User;
import com.zhbit.acm.service.UserService;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Cyril on 16/6/16.
 */

@Component(value = "registerAction")
@Scope(value = "prototype")
public class RegisterAction extends ActionSupport {

    private String confirm;

//  表单处理的user信息
    private User user;

//  确认密码
    private UserService service;

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    @JSON(serialize = false)
    public UserService getService() {
        return service;
    }

    @Resource(name = "userService")
    public void setService(UserService service) {
        this.service = service;
    }

    @JSON(serialize = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String execute() throws Exception {
        return "register_page";
    }

    public String post(){
        service.add(user);
        return SUCCESS;
    }

    public String check(){
        return ERROR;
    }




}

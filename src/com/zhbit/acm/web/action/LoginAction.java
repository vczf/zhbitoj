package com.zhbit.acm.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.acm.domain.User;
import com.zhbit.acm.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Cyril on 16/6/16.
 */

@Component(value = "loginAction")
@Scope(value = "prototype")
public class LoginAction extends ActionSupport{

    private String userName;

    private String password;

    private UserService service;

    private String refererUrl;

    public String getRefererUrl() {
        return refererUrl;
    }

    public void setRefererUrl(String refererUrl) {
        this.refererUrl = refererUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserService getService() {
        return service;
    }

    @Resource(name = "userService")
    public void setService(UserService service) {
        this.service = service;
    }

    @Override
    public String execute() throws Exception {
        return "login_page";
    }

    public String post() {

        User user = service.getUserByName(userName);

//        找到了user,而且user的用户名密码相同
        if (user != null && user.getPassword().equals(password) ){


//          把用户名,昵称,权限添加到session中.
            ActionContext context = ActionContext.getContext();
            Map session = context.getSession();
            session.put("USER_NAME",user.getUserName());
            session.put("NICK_NAME",user.getNick());
            session.put("USER_ROLE",user.getRole());

//            refererUrl = (String) session.get("referer");
//            if(refererUrl!=null)
//                return "referer";

            return SUCCESS;
        }else{
            this.addFieldError("loginError","用户名或密码不正确");
            return "login_page";
        }
    }
}

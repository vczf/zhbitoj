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
@Component(value = "userAction")
@Scope(value = "prototype")
public class UserAction extends ActionSupport {

    private String nick;

    private String note;

    private String newpassword;

    private String confirm;

    private String school;

    private String email;

    private UserService service;

    public String edit(){
        if (!newpassword.equals("")&&!newpassword.equals(confirm)){
            addFieldError("comfirm","两次输入密码不相同");
            return "input";
        }
        Map session = ActionContext.getContext().getSession();
        String userName = (String) session.get("USER_NAME");

        service.edit(userName,nick,note,newpassword,school,email);
        return SUCCESS;
    }

    private String userName;

    public String info(){

        User user = service.getUserByName(userName);

        if (user==null)
            return "input";
        int ac = service.getStatusCount(userName,4);
        int submit = service.getSubmitCount(userName);
        int wa = submit-ac;
        ActionContext context = ActionContext.getContext();
        Map req = (Map) context.get("request");
        req.put("user",user);
        context.put("ac",ac);
        context.put("wa",wa);
        context.put("submit",submit);
        return SUCCESS;
    }

    public String showEdit(){
        Map session = ActionContext.getContext().getSession();
        Map req = (Map) ActionContext.getContext().get("request");

        String userName = (String) session.get("USER_NAME");

        User user = service.getUserByName(userName);

        user.setPassword("");

        req.put("user",user);

        return SUCCESS;

    }

    public String logout(){
        Map session = ActionContext.getContext().getSession();
        session.remove("USER_NAME");
        session.remove("NICK_NAME");
        session.remove("USER_ROLE");
        session.remove("CONTEST_ID");
        return "index_page";
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    @Resource(name = "userService")
    public void setService(UserService service) {
        this.service = service;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

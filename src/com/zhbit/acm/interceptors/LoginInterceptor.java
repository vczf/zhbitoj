package com.zhbit.acm.interceptors;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Cyril on 16/6/17.
 */
public class LoginInterceptor extends MethodFilterInterceptor{

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        
        Map session = actionInvocation.getInvocationContext().getSession();
        String userName = (String) session.get("USER_NAME");

        if (userName==null||userName.equals("")) {
//            String url = ServletActionContext.getRequest().getHeader("Referer");
//            session.put("referer",url);
            return "login_page";
        }
        else
            return actionInvocation.invoke();
    }
}

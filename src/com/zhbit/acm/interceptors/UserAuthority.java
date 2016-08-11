package com.zhbit.acm.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.zhbit.acm.service.ContestPlayerService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Cyril on 16/6/17.
 */
@Component
@Scope(value = "prototype")
public class UserAuthority extends MethodFilterInterceptor{

    private ContestPlayerService playerService;

    @Resource(name = "contestPlayerService")
    public void setPlayerService(ContestPlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        Map sn = actionInvocation.getInvocationContext().getSession();
        Map par = actionInvocation.getInvocationContext().getParameters();

        Integer contestId = null;

        String []nums = (String[]) par.get("contestId");

        contestId = new Integer(nums[0]);

        Integer contestId_confirm = (Integer) sn.get("CONTEST_ID");
        String userName = (String) sn.get("USER_NAME");
        Integer role= (Integer) sn.get("USER_ROLE");
        if (contestId_confirm==null || !contestId.equals(contestId_confirm)){
            if(role.equals(new Integer(1)))
                return actionInvocation.invoke();
            if (playerService.exist(userName,contestId)){
                sn.put("CONTEST_ID",contestId);
                return actionInvocation.invoke();
            }
            return "contest_index";
        }
        return actionInvocation.invoke();
    }
}

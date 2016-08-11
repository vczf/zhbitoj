package com.zhbit.acm.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.zhbit.acm.domain.Contest;
import com.zhbit.acm.service.ContestService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Cyril on 16/6/17.
 */
@Component
@Scope(value = "prototype")   // 待定吧
public class ContestStatusInterceptor_Prepare extends MethodFilterInterceptor{

    private ContestService contestService;

    String status;

    @Resource(name = "contestService")
    public void setContestService(ContestService contestService) {
        this.contestService = contestService;
    }

    //  如果比赛值取不到,或者比赛不是进行状态,则不能进入比赛
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {


        Map session = actionInvocation.getInvocationContext().getSession();
        String userName = (String) session.get("USER_NAME");

        Map param = actionInvocation.getInvocationContext().getParameters();
        Integer contestId = null;


        try{
            String[] numStrings = (String[]) param.get("contestId");
            contestId = new Integer(numStrings[0]);
        }catch (NumberFormatException e){
            System.err.println(contestId);;
        }
        if (contestId==null)
            return "contest_list";

        Contest contest = contestService.getContestById(contestId);




//       强行, 暂时找不到读取interceptor的解决方案.
        status = "wait";
        int statusCode = 0;
        if (status.equals("wait"))
            statusCode = -1;
        else if (status.equals("running") )
            statusCode = 0;
        else if (status.equals("end"))
            statusCode = 1;
        else
            statusCode = 2;

        if (contest.status()==statusCode)
            return actionInvocation.invoke();
        else
            return "contest_index";
    }
}

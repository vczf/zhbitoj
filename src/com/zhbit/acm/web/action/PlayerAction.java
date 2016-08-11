package com.zhbit.acm.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.acm.service.ContestPlayerService;
import com.zhbit.acm.validators.ProblemLegalValidation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Cyril on 16/6/21.
 */
@Component(value = "contestPlayerAction")
@Scope(value = "prototype")
public class PlayerAction extends ActionSupport {


    private int contestId;

    private ContestPlayerService service;

    @Resource(name = "contestPlayerService")
    public void setService(ContestPlayerService service) {
        this.service = service;
    }

    public void setContestId(int contestId) {
        this.contestId = contestId;
    }

    public String registerContest(){

        String userName = (String) ActionContext.getContext().getSession().get("USER_NAME");

        service.join(userName,contestId);

        return SUCCESS;
    }

}

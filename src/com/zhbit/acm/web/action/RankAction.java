package com.zhbit.acm.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.acm.domain.Contest;
import com.zhbit.acm.domain.ContestProblem;
import com.zhbit.acm.domain.User;
import com.zhbit.acm.service.ContestProblemService;
import com.zhbit.acm.service.ContestService;
import com.zhbit.acm.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Cyril on 16/6/16.
 */

@Component(value = "rankAction")
@Scope(value = "prototype")
public class RankAction extends ActionSupport{

    private ContestService contestService;

    private ContestProblemService contestProblemService;

    private int contestId;

    public int getContestId() {
        return contestId;
    }

    public void setContestId(int contestId) {
        this.contestId = contestId;
    }

    @Resource(name = "contestService")
    public void setContestService(ContestService contestService) {
        this.contestService = contestService;
    }

    @Resource(name = "contestProblemService")
    public void setContestProblemService(ContestProblemService contestProblemService) {
        this.contestProblemService = contestProblemService;
    }

    @Override
    public String execute() throws Exception {

        List problems = contestProblemService.showProblemsByContsetId(contestId);
        List ranking = contestService.getRanking(contestId);

        Map req = (Map) ActionContext.getContext().get("request");

        req.put("problems",problems);
        req.put("ranking",ranking);

        return SUCCESS;
    }
}

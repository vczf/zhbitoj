package com.zhbit.acm.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.acm.domain.Contest;
import com.zhbit.acm.domain.ContestProblem;
import com.zhbit.acm.domain.Problem;
import com.zhbit.acm.service.ContestProblemService;
import com.zhbit.acm.service.ContestService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Cyril on 16/6/21.
 */

@Component(value = "contestProblemAction")
@Scope(value = "prototype")
public class ContestProblemAction extends ActionSupport {

    private int contestId;
    private int problemId;

    private ContestProblemService contestProblemService;
    private ContestService contestService;
    //  比赛题目列表
    public String listContestProblem(){
        List<ContestProblem> list = contestProblemService.showProblemsByContsetId(contestId);

        Map req = (Map) ActionContext.getContext().get("request");



        req.put("problemList",list);

        return SUCCESS;
    }

    public String showContestProblem(){
        Problem problem = contestProblemService.showProblem(problemId,contestId);
        if (problem==null)
            return "input";
        Map req = (Map) ActionContext.getContext().get("request");
        req.put("problem",problem);
        return SUCCESS;
    }

    @Resource(name = "contestProblemService")
    public void setContestProblemService(ContestProblemService contestProblemService) {
        this.contestProblemService = contestProblemService;
    }

    public int getContestId() {
        return contestId;
    }

    public void setContestId(int contestId) {
        this.contestId = contestId;
    }

    public int getProblemId() {
        return problemId;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }

    @Resource(name = "contestService")
    public void setContestService(ContestService contestService) {
        this.contestService = contestService;
    }
}

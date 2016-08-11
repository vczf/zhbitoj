package com.zhbit.acm.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.acm.domain.ContestProblem;
import com.zhbit.acm.domain.Problem;
import com.zhbit.acm.domain.Solution;
import com.zhbit.acm.service.ContestProblemService;
import com.zhbit.acm.service.ProblemService;
import com.zhbit.acm.service.StatusService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Cyril on 16/6/17.
 */
@Component(value = "submitAction")
@Scope(value = "prototype")
public class SubmitAction extends ActionSupport{

//  Service
    private StatusService statusService;
    private ProblemService problemService;
    private ContestProblemService contestProblemService;
    //  编号
    private int problemId;
    private int contestId;
    private int language;
    private String source;

    @Resource(name = "contestProblemService")
    public void setContestProblemService(ContestProblemService contestProblemService) {
        this.contestProblemService = contestProblemService;
    }
    @Resource(name = "statusService")
    public void setStatusService(StatusService statusService) {
        this.statusService = statusService;
    }

    @Resource(name = "problemService")
    public void setProblemService(ProblemService problemService) {
        this.problemService = problemService;
    }

    public int getProblemId() {
        return problemId;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getContestId() {
        return contestId;
    }

    public void setContestId(int contestId) {
        this.contestId = contestId;
    }

    @Override
    public String execute() throws Exception {
        return "submit_page";
    }

    public String post(){
        Solution solution = new Solution();
        solution.setProblemId(problemId);
        solution.setLanguage(language);
        String userNmae = (String) ActionContext.getContext().getSession().get("USER_NAME");
        solution.setUserName(userNmae);
        statusService.submit(solution,source);
        return SUCCESS;
    }

//   比赛相关的提交用例.
    public String submitInContest(){
        if(find(problemId,contestProblemService.showProblemsByContsetId(contestId))){
            Problem problem = problemService.showProblemById(problemId);
            if (problem!=null && (!problem.isDelete()||contestId!=0)){
                Solution solution = new Solution();
                solution.setProblemId(problemId);
                solution.setLanguage(language);
                String userNmae = (String) ActionContext.getContext().getSession().get("USER_NAME");
                solution.setUserName(userNmae);
                solution.setContextId(contestId);
                statusService.submit(solution,source);
                return SUCCESS;
            }
        }
        return "input";
    }

    public boolean find(int problemId, List problems){
        for (Object item:problems){
            ContestProblem problem = (ContestProblem) item;
            if (problem.getProblemid()==problemId)
                return true;
        }
        return false;
    }
}

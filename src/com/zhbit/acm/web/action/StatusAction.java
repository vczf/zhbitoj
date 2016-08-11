package com.zhbit.acm.web.action;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.acm.service.StatusService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Cyril on 16/6/6.
 */

@Component(value = "statusAction")
@Scope(value = "prototype")
public class StatusAction extends ActionSupport{

    private int page;

    private StatusService service;

    public StatusService getService() {
        return service;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Resource(name = "statusService")
    public void setService(StatusService service) {
        this.service = service;
    }

    @Override
    public String execute() throws Exception {

        if (page<=0)
            page = 1;

        List list = service.showStatusByContextId(0,page);

        Map req = (Map) ActionContext.getContext().get("request");

        req.put("status",list);

        req.put("maxPage",service.getPageCount(0));

        return "status_page";
    }

    private int contestId;

    public String statusInContest(){

        if (page<=0)
            page = 1;

        List list = service.showStatusByContextId(contestId,page);

        Map req = (Map) ActionContext.getContext().get("request");

        req.put("status",list);

        req.put("maxPage",service.getPageCount(contestId));

        return SUCCESS;
    }

    private String problemId;
    private String userName;
    private int language;
    private int result;

    public String search(){
        Integer pid = null;
        if (problemId.equals(""))
            pid = null;
        else{
            try {
                pid = new Integer(problemId);
            }catch (NumberFormatException e){
                return "input";
            }
        }
        List list = service.searchSolutions(pid,userName,language,result);
        Map req = (Map) ActionContext.getContext().get("request");

        req.put("status",list);
        return SUCCESS;
    }

    public void setProblemId(String problemId) {
        this.problemId = problemId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getContestId() {
        return contestId;
    }

    public void setContestId(int contestId) {
        this.contestId = contestId;
    }


}

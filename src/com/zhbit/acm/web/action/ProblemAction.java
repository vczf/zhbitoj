package com.zhbit.acm.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.acm.domain.ContestProblem;
import com.zhbit.acm.domain.Problem;
import com.zhbit.acm.service.ContestProblemService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.zhbit.acm.service.ProblemService;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Cyril on 16/6/6.
 */

@Component(value = "problemAction")
@Scope(value = "prototype")
public class ProblemAction extends ActionSupport{


    private String type;
    private String text;
    private int pid;
    private int page;
    private int pageNumber;

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Resource(name = "problemService")
    private ProblemService services;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public ProblemService getServices() {
        return services;
    }

    private boolean isAdmin(){
        Map session = (Map) ActionContext.getContext().get("session");
        Integer t = (Integer) session.get("USER_ROLE");
        if(t==null) return false;
        if(t==1) return true;
        return false;
    }


    @Resource(name = "problemService")
    public void setServices(ProblemService services) {
        this.services = services;
    }

    public String  execute(){
        if (page==0)
            page = 1;
        List problemList=null;
        if(isAdmin()){
            pageNumber = services.getPageCountFromAdmin();
            problemList = services.showProblemByPageFromAdmin(page);
        }
        else {
            pageNumber = services.getPageCount();
            problemList = services.showProblemByPage(page);
        }
        Map req = (Map) ActionContext.getContext().get("request");
        req.put("problems",problemList);
        return "list_page";
    }

    public String search(){
        List problemList = services.search(type,text);
        Map req = (Map) ActionContext.getContext().get("request");
        req.put("problems",problemList);
        return "list_page";
    }

    public String detail(){                        // 对不可显示的题目进行过滤.

        Problem problem = services.showProblemById(pid);
        if (problem==null)
            return "problem_not_found";
        if(!isAdmin()&&problem.isHide())
            return "problem_not_found";
        Map req = (Map) ActionContext.getContext().get("request");
        req.put("problem",problem);
        return "problem_info";
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}

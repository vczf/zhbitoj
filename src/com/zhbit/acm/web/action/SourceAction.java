package com.zhbit.acm.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.acm.domain.Solution;
import com.zhbit.acm.domain.SourceCode;
import com.zhbit.acm.service.SourceService;
import com.zhbit.acm.service.StatusService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Cyril on 16/6/17.
 */

@Component(value = "sourceAction")
@Scope (value = "prototype")
public class SourceAction extends ActionSupport{

    private int id;

    private SourceService sourceService;

    private StatusService statusServiceo;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SourceService getSourceService() {
        return sourceService;
    }


    @Resource(name = "sourceService")
    public void setSourceService(SourceService sourceService) {
        this.sourceService = sourceService;
    }

    public StatusService getStatusServiceo() {
        return statusServiceo;
    }

    @Resource(name = "statusService")
    public void setStatusServiceo(StatusService statusServiceo) {
        this.statusServiceo = statusServiceo;
    }

    @Override
    public String execute() throws Exception {

        SourceCode sourceCode = sourceService.getSourceById(id);

        if (sourceCode==null){
            return "input";
        }
        Map session = ActionContext.getContext().getSession();
        String userName = (String) session.get("USER_NAME");
        int role = (int) session.get("USER_ROLE");
        if (userName == null)
            return "input";
        Solution solution = statusServiceo.getSolutionById(id);
        if (solution==null)
            return "input";
        if (role==0 && !solution.getUserName().equals(userName))
            return "input";

        Map req = (Map) ActionContext.getContext().get("request");

        req.put("source",sourceCode);
        req.put("solution",solution);
        return "source_page";
    }
}

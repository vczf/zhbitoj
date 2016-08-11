package com.zhbit.acm.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.acm.domain.Compile;
import com.zhbit.acm.domain.Solution;
import com.zhbit.acm.domain.SourceCode;
import com.zhbit.acm.service.CompileService;
import com.zhbit.acm.service.SourceService;
import com.zhbit.acm.service.StatusService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Cyril on 16/6/22.
 */
@Component(value = "ceAction")
@Scope(value = "prototype")
public class CeAction extends ActionSupport{

    private CompileService compileService;
    private StatusService statusService;
    private int solutionId;

    @Override
    public String execute() throws Exception {
        Compile compile;
        compile = compileService.getCompileBySolutionId(solutionId);
        if (compile==null)
            return "input";

        Map req = (Map) ActionContext.getContext().get("request");

        SourceCode sourceCode = new SourceCode();
        sourceCode.setSource(compile.getErrorMessage());
        sourceCode.setSolutionId(solutionId);

        Solution solution = statusService.getSolutionById(solutionId);

        req.put("source",sourceCode);
        req.put("solution",solution);
        return "source_page";
    }
    @Resource(name = "compileService")
    public void setCompileService(CompileService compileService) {
        this.compileService = compileService;
    }
    @Resource(name = "statusService")
    public void setStatusService(StatusService statusService) {
        this.statusService = statusService;
    }

    public CompileService getCompileService() {
        return compileService;
    }

    public int getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(int solutionId) {
        this.solutionId = solutionId;
    }
}

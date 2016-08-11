package com.zhbit.acm.validators;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;
import com.zhbit.acm.domain.Problem;
import com.zhbit.acm.service.ProblemService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Cyril on 16/6/16.
 */
@Component
public class ProblemLegalValidation extends FieldValidatorSupport {

    private String myParam;

    private ProblemService service;

    @Override
    public void validate(Object o) throws ValidationException {
        String fieldName = super.getFieldName();
        String value = super.getFieldValue(fieldName,o).toString();

        Problem problem = service.showProblemById(Integer.parseInt(value));
        if(problem==null || problem.isDelete()){
            super.addFieldError(fieldName, o);
        }
        if ( problem.isHide() ) {
            Map session = (Map)ActionContext.getContext().get("session");
            Integer role = (Integer)session.get("USER_ROLE");
            if(role!=1)
                super.addFieldError(fieldName, o);
        }
    }
    public String getMyParam() {
        return myParam;
    }

    public void setMyParam(String myParam) {
        this.myParam = myParam;
    }

    public ProblemService getService() {
        return service;
    }

    @Resource(name = "problemService")
    public void setService(ProblemService service) {
        this.service = service;
    }
}

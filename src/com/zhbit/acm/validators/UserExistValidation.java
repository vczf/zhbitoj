package com.zhbit.acm.validators;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;
import com.zhbit.acm.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Cyril on 16/6/16.
 */
@Component
public class UserExistValidation extends FieldValidatorSupport {

    private String myParam;

    private UserService service;

    @Override
    public void validate(Object o) throws ValidationException {
        String fieldName = super.getFieldName();
        String value = super.getFieldValue(fieldName,o).toString();

        if (service.exist(value)){
            super.addFieldError(fieldName,o);
        }
    }

    public String getMyParam() {
        return myParam;
    }

    public void setMyParam(String myParam) {
        this.myParam = myParam;
    }

    public UserService getService() {
        return service;
    }


    @Resource(name = "userService")
    public void setService(UserService service) {
        this.service = service;
    }
}

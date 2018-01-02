package com.xingyi.logistic.business.util;

import com.xingyi.logistic.common.bean.ErrCode;
import com.xingyi.logistic.common.bean.JsonRet;
import org.apache.bval.jsr.ApacheValidationProvider;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Created by Jadic on 2017/12/31.
 */
public class ParamValidator {


    private static final Validator VALIDATOR = Validation.byProvider(ApacheValidationProvider.class).configure().buildValidatorFactory().getValidator();
    private static final Object VAL_TEST = new Object();

    static {
        VALIDATOR.validate(VAL_TEST);
    }

    public static <T> boolean isParamValid(JsonRet<?> ret, T t) {
        if (t == null) {
            ret.setErrTip(ErrCode.PARAM_MISS);
            return false;
        }

        Set<ConstraintViolation<T>> validate = VALIDATOR.validate(t);
        if (!validate.isEmpty()) {
            for (ConstraintViolation<T> violation : validate) {
                ret.setErrTip(ErrCode.PARAM_INVALID.getCode(), "[" + violation.getPropertyPath() + "]" + violation.getMessage());
                return false;//return only one invalid tip
            }
        }
        return true;
    }
}

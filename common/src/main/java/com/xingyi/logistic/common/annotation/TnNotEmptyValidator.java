/**
 * Copyright (C) 2006-2017 Tuniu All rights reserved
 */
package com.xingyi.logistic.common.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 不为空校验器
 * Date: 2017-04-06
 *
 * @author weifuping
 */
public class TnNotEmptyValidator implements ConstraintValidator<NotNullEmpty, Object> {

    @Override
    public void initialize(NotNullEmpty constraintAnnotation) {
        //do nothing
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        if (value.getClass().isArray()) {
            return Array.getLength(value) > 0;
        }
        try {
            final Method isEmptyMethod = value.getClass().getMethod("isEmpty");
            if (isEmptyMethod != null) {
                return !((Boolean) isEmptyMethod.invoke(value)).booleanValue();
            }
        } catch (IllegalAccessException iae) {
            // do nothing
        } catch (NoSuchMethodException nsme) {
            // do nothing
        } catch (InvocationTargetException ite) {
            // do nothing
        }
        return !value.toString().isEmpty();
    }
}

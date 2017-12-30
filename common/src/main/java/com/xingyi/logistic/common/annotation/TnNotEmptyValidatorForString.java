/**
 * Copyright (C) 2006-2017 Tuniu All rights reserved
 */
package com.xingyi.logistic.common.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 不为空针对String的校验器
 * Date: 2017-04-06
 *
 * @author weifuping
 */
public class TnNotEmptyValidatorForString implements ConstraintValidator<NotNullEmpty, String> {
    @Override
    public void initialize(NotNullEmpty constraintAnnotation) {
        //do nothing
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && !value.isEmpty();
    }
}

/**
 * Copyright (C) 2006-2017 Tuniu All rights reserved
 */
package com.xingyi.logistic.common.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import java.util.Map;

/**
 * 不为空针对Map的校验器
 * Date: 2017-04-06
 *
 * @author weifuping
 */
public class TnNotEmptyValidatorForMap implements ConstraintValidator<NotNullEmpty, Map<?, ?>> {

    @Override
    public void initialize(NotNullEmpty constraintAnnotation) {
        //do nothing
    }

    @Override
    public boolean isValid(Map<?, ?> value, ConstraintValidatorContext context) {
        return value != null && !value.isEmpty();
    }
}

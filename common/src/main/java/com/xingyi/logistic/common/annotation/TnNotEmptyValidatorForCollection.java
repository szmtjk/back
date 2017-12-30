/**
 * Copyright (C) 2006-2017 Tuniu All rights reserved
 */
package com.xingyi.logistic.common.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import java.util.Collection;

/**
 * 不为空针对集合的校验器
 * Date: 2017-04-06
 *
 * @author weifuping
 */
public class TnNotEmptyValidatorForCollection implements ConstraintValidator<NotNullEmpty, Collection<?>> {

    @Override
    public void initialize(NotNullEmpty constraintAnnotation) {
        //do nothing
    }

    @Override
    public boolean isValid(Collection<?> value, ConstraintValidatorContext context) {
        return value != null && !value.isEmpty();
    }
}

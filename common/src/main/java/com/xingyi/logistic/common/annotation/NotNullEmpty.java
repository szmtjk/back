/**
 * Copyright (C) 2006-2017 Tuniu All rights reserved
 */
package com.xingyi.logistic.common.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;

/**
 * 不能为null或空的
 * Date: 2017-04-06
 *
 * @author weifuping
 */
@Constraint(validatedBy = { TnNotEmptyValidatorForCollection.class, TnNotEmptyValidatorForMap.class,
        TnNotEmptyValidatorForString.class, TnNotEmptyValidator.class })
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNullEmpty {

    String message() default "not null or empty message";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

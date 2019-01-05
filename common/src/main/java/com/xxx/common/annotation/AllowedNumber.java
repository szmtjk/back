package com.xxx.common.annotation;

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
@Constraint(validatedBy = { AllowedNumberValidator.class })
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface AllowedNumber {

    String message() default "not in the allowed values";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    long[] values() default {};

}

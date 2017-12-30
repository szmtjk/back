/**
 * Copyright (C) 2006-2017 Tuniu All rights reserved
 */
package com.xingyi.logistic.common.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 允许指定值校验
 * Date: 2017-04-19
 *
 * @author weifuping
 */
public class AllowedNumberValidator implements ConstraintValidator<AllowedNumber, Number> {

    private long[] allowedValues;

    @Override
    public void initialize(AllowedNumber constraintAnnotation) {
        this.allowedValues = constraintAnnotation.values();
    }

    @Override
    public boolean isValid(Number value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        if (allowedValues != null && allowedValues.length > 0) {
            if (value instanceof BigDecimal) {
                return isBigDecimalInAllowedValues((BigDecimal)value);
            }

            if (value instanceof BigInteger) {
                return isBigIntegerInAllowedValues((BigInteger)value);
            }

            return isLongInAllowedValues(value.longValue());
        }
        return true;
    }

    private boolean isBigDecimalInAllowedValues(BigDecimal value) {
        for (long allowedValue : allowedValues) {
            if (value.compareTo(BigDecimal.valueOf(allowedValue)) == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean isBigIntegerInAllowedValues(BigInteger value) {
        for (long allowedValue : allowedValues) {
            if (value.compareTo(BigInteger.valueOf(allowedValue)) == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean isLongInAllowedValues(long value) {
        for (long allowedValue : allowedValues) {
            if (value == allowedValue) {
                return true;
            }
        }
        return false;
    }
}

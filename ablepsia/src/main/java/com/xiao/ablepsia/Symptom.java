package com.xiao.ablepsia;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 症状
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RUNTIME)
public @interface Symptom {
    String value();
}

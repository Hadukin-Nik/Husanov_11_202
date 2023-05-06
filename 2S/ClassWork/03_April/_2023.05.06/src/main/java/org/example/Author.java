package org.example;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Author {
    String name() default ("Author-ANonimus");
    int year() default (2012);
}
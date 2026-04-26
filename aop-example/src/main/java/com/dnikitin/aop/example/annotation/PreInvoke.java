package com.dnikitin.aop.example.annotation;

import com.dnikitin.aop.example.model.RoleType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface PreInvoke {
    RoleType[] roles();
}

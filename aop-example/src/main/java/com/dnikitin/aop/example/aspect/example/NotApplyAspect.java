package com.dnikitin.aop.example.aspect.example;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class NotApplyAspect {
    private static final Logger LOG = LoggerFactory.getLogger(NotApplyAspect.class);

    @Before("execution(* not ExisterdMethod())")
    public void before(){
        LOG.info("Nothing here ");
    }


}

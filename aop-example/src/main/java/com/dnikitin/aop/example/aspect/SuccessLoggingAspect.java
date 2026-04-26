package com.dnikitin.aop.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class SuccessLoggingAspect {

    private static final Logger LOG = LoggerFactory.getLogger(SuccessLoggingAspect.class);

    @AfterReturning("within(com.dnikitin.aop.example.service.*) &&" +
            "@within(com.dnikitin.aop.example.annotation.SuccessLogging)")
    public void logAfterReturning(JoinPoint joinPoint) {
        LOG.info("method completed: {}", joinPoint.getSignature().getName());
        LOG.info("-----------------------------------------------------");

    }
}

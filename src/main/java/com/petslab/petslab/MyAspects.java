package com.petslab.petslab;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class MyAspects {
    @AfterReturning(value = "execution(* findAll(..))", returning = "x")
    public void afterReturningFromFindAll(JoinPoint joinPoint, Object x) {
        log.info("Returning from {} with {}", joinPoint.getSignature().getName(),
                x);
    }

    @AfterReturning(value = "execution(* loadUserByUsername(String))", returning = "x")
    public void afterReturningFromLoadUserByUsername(JoinPoint joinPoint, Object x) {
        log.info("Loaded from {} user {}", joinPoint.getSignature().getName(), x);
    }
}


package org.kunal.JobAppREST.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    //return type, class-name(entire path).method-name(args)

    @Before("execution(* org.kunal.JobAppREST.service.JobService.*(..))")
    public void logMethodCall(JoinPoint joinPoint) {
        LOGGER.info("Method Called {}", joinPoint.getSignature().getName());
    }

    @After("execution(* org.kunal.JobAppREST.service.JobService.*(..))")
    public void logMethodExecuted(JoinPoint joinPoint) {
        LOGGER.info("Method executed {}", joinPoint.getSignature().getName());
    }

    @AfterThrowing("execution(* org.kunal.JobAppREST.service.JobService.*(..))")
    public void logMethodCrashed(JoinPoint joinPoint) {
        LOGGER.info("Exception Occurred! {}", joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* org.kunal.JobAppREST.service.JobService.*(..))")
    public void logMethodSuccess(JoinPoint joinPoint) {
        LOGGER.info("Success! {}", joinPoint.getSignature().getName());
    }

}

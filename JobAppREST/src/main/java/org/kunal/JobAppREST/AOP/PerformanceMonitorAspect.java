package org.kunal.JobAppREST.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    @Around("execution(* org.kunal.JobAppREST.service.JobService.*(..))")
    public Object monitorTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object obj = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();
        LOGGER.info("Time taken by {}: {} ms",proceedingJoinPoint.getSignature().getName(), end-start);
        return obj;
    }

}

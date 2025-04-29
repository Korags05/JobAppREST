package org.kunal.JobAppREST.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* org.kunal.JobAppREST.service.JobService.getJob(..)) && args(postId)")
    public Object validateAndUpdate(ProceedingJoinPoint proceedingJoinPoint, int postId) throws Throwable {

        if (postId < 0) {
            LOGGER.info("PostId invalid {}", postId);
            postId = -postId;
            LOGGER.info("New value: {}", postId);
        }

        return proceedingJoinPoint.proceed(new Object[]{postId});
    }

}

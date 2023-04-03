package org.zaroyan.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.zaroyan.annotation.ToLog;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Order(2)
public class LoggingAspect {
    Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("@annotation(org.zaroyan.annotation.ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object [] arguments = joinPoint.getArgs();
        logger.info("Logging Aspect: Метод " + methodName +
                " с параметрами " + Arrays.asList(arguments) +
                " до выполнения");
        Object returnedByMethod = joinPoint.proceed();
        logger.info("Logging Aspect: Метод выполнен и возвращен " + returnedByMethod);
        return returnedByMethod;
    }
}

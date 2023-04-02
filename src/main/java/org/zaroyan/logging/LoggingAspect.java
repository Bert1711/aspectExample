package org.zaroyan.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* org.zaroyan.services.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object [] arguments = joinPoint.getArgs();
        logger.info("Метод " + methodName +
                " с параметрами " + Arrays.asList(arguments) +
                " до выполнения");
        Object returnedByMethod = joinPoint.proceed();
        logger.info("Метод выполнен и возвращен " + returnedByMethod);
        return returnedByMethod;
    }
}

package org.zaroyan.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* org.zaroyan.services.*.*(..))")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("До выполнения метода");
        joinPoint.proceed();
        logger.info("После выполнения метода");

    }
}

package ru.geekbrains.summer.market.utils;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AopLog {

    @Around("execution(public * ru.geekbrains.summer.market.services.*.*(..))")
    public Object calculatingExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        if(!proceedingJoinPoint.getTarget().getClass().getName().contains("CategoryService")) {
            long begin = System.currentTimeMillis();
            Object out = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            long duration = end - begin;
            String message = proceedingJoinPoint.getTarget().getClass().getName() + " - " + duration + "ms";
            System.out.println(message);
            log.debug(message);
            return out;
        }
        Object out = proceedingJoinPoint.proceed();
        return out;
    }
}


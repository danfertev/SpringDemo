package ru.anfdenis.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Denis Anfertev
 * 23.12.12 22:38
 */
public class LoggingAspect {
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) {
        Object returnValue = null;
        try {
            System.out.println("Before advice");
            returnValue = joinPoint.proceed();
            System.out.println("After returning");
        } catch (Throwable throwable) {
            System.out.println("After throwing");
        }
        System.out.println("After finally");
        return returnValue;
    }

    public void loggingAdvice() {
        System.out.println("Logging from the advice");
    }
}

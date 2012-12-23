package ru.anfdenis.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Denis Anfertev
 * 23.12.12 22:38
 */
@Aspect
public class LoggingAspect {
    @Before("execution(public String getName())")
    public void loggingAdvice(){
        System.out.println("Advice run. Get method called.");
    }
}

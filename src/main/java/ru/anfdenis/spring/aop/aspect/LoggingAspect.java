package ru.anfdenis.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Denis Anfertev
 * 23.12.12 22:38
 */
@Aspect
public class LoggingAspect {
    @Before("allCircleMethods()")
    public void loggingAdvice(JoinPoint joinPoint) {
        System.out.println(joinPoint.getTarget());
    }

    @Before("args(name)")
    public void stingArgumentMethods(String name) {
        System.out.println("A method that takes String argument has been called. The value is " + name);
    }

    @Pointcut("within(ru.anfdenis.spring.aop.model.Circle)")
    public void allCircleMethods() {
    }
}

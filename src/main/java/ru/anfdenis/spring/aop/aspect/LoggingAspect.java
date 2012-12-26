package ru.anfdenis.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Denis Anfertev
 * 23.12.12 22:38
 */
@Aspect
public class LoggingAspect {
    @Before("allCircleMethods()")
    public void loggingAdvice(JoinPoint joinPoint) {
//        System.out.println(joinPoint.getTarget());
    }

    @AfterReturning(pointcut = "args(name)", returning = "returnString", argNames = "name, returnString")
    public void stingArgumentMethods(String name, String returnString) {
        System.out.println("A method that takes String argument has been called. The value is " + name
                + ". The output value is " + returnString);
    }

    @AfterThrowing(pointcut = "args(name)", throwing = "ex")
    public void exceptionAdvice(String name, RuntimeException ex) {
        System.out.println("An exception has been thrown" + ": " + ex);
    }

    @Around("@annotation(ru.anfdenis.spring.aop.aspect.Loggable)")
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

    @Pointcut("execution(* get*())")
    public void allGetters() {
    }

    @Pointcut("within(ru.anfdenis.spring.aop.model.Circle)")
    public void allCircleMethods() {
    }
}

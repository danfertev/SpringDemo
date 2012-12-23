package ru.anfdenis.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.anfdenis.spring.aop.service.ShapeService;

/**
 * Denis Anfertev
 * 23.12.12 21:59
 */
public class AopMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");
        ShapeService shapeService = context.getBean("shapeService", ShapeService.class);
        System.out.println(shapeService.getCircle().getName());
    }
}

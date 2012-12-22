package ru.anfdenis.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Denis Anfertev
 * 10.12.12 22:22
 */
public class DrawingApp {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        context.registerShutdownHook();
        Shape shape = (Shape) context.getBean("circle");
        shape.draw();
    }
}

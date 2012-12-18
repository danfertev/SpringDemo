package ru.anfdenis.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Denis Anfertev
 * 10.12.12 22:22
 */
public class DrawingApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Triangle triangle = (Triangle) context.getBean("triangle");
        triangle.draw();
    }
}

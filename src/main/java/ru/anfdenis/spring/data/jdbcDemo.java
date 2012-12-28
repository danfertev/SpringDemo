package ru.anfdenis.spring.data;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.anfdenis.spring.data.dao.JdbcDaoImpl;
import ru.anfdenis.spring.data.model.Circle;

/**
 * Denis Anfertev
 * 26.12.12 20:55
 */
public class JdbcDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-data.xml");
        JdbcDaoImpl  dao = context.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
//        Circle circle = dao.getCircle(0);
//        System.out.println(circle.getName());
        System.out.println(dao.getCircleNumber());
    }
}

package ru.anfdenis.spring.aop.service;

import ru.anfdenis.spring.aop.model.Circle;
import ru.anfdenis.spring.aop.model.Triangle;

/**
 * Denis Anfertev
 * 26.12.12 16:06
 */
public class FactoryService {
    public Object getBean(String beanType) {
        if ("shapeService".equals(beanType)) {
            return new ShapeServiceProxy();
        }
        if ("circle".equals(beanType)) {
            return new Circle();
        }
        if ("triangle".equals(beanType)) {
            return new Triangle();
        }
        return null;
    }
}

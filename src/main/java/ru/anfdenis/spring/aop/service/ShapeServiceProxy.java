package ru.anfdenis.spring.aop.service;

import ru.anfdenis.spring.aop.aspect.LoggingAspect;
import ru.anfdenis.spring.aop.model.Circle;

/**
 * Denis Anfertev
 * 26.12.12 16:16
 */
public class ShapeServiceProxy extends ShapeService {
    @Override
    public Circle getCircle() {
        new LoggingAspect().loggingAdvice();
        return super.getCircle();
    }
}

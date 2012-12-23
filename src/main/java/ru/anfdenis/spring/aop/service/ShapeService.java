package ru.anfdenis.spring.aop.service;

import ru.anfdenis.spring.aop.model.Circle;
import ru.anfdenis.spring.aop.model.Triangle;

/**
 * Denis Anfertev
 * 23.12.12 22:10
 */
public class ShapeService {
    private Triangle triangle;
    private Circle circle;

    public Triangle getTriangle() {
        return triangle;
    }

    public void setTriangle(Triangle triangle) {
        this.triangle = triangle;
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }
}

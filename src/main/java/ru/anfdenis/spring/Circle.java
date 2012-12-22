package ru.anfdenis.spring;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * Denis Anfertev
 * 23.12.12 2:43
 */
@Component
public class Circle implements Shape {
    private Point center;

    public Point getCenter() {
        return center;
    }

    @Resource(name = "pointC")
    public void setCenter(Point center) {
        this.center = center;
    }

    @Override
    public void draw() {
        System.out.println("Circle:");
        System.out.println("Center = (" + center.getX() + "," + center.getY() + ")");
    }

    @PostConstruct
    public void initialize() {
        System.out.println("Init of Circle");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy of Circle");
    }
}

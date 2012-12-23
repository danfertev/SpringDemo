package ru.anfdenis.spring.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * Denis Anfertev
 * 23.12.12 2:43
 */
@Component
public class Circle implements Shape, ApplicationEventPublisherAware {
    private Point center;
    private MessageSource messageSource;
    private ApplicationEventPublisher publisher;

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Resource(name = "pointC")
    public void setCenter(Point center) {
        this.center = center;
    }

    @Override
    public void draw() {
        System.out.println(this.messageSource.getMessage("predrawing", null, "Default predrawing", null));
        System.out.println(this.messageSource.getMessage("drawing.circle", null, "Shape:", null));
        System.out.println(this.messageSource.getMessage("drawing.center", new Object[]{center.getX(), center.getY()}, "Shape:", null));
        publisher.publishEvent(new DrawEvent(this));
    }

    @PostConstruct
    public void initialize() {
        System.out.println("Init of Circle");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy of Circle");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}

package ru.anfdenis.spring.basic;

import org.springframework.context.ApplicationEvent;

/**
 * Denis Anfertev
 * 23.12.12 21:09
 */
public class DrawEvent extends ApplicationEvent {
    public DrawEvent(Object source) {
        super(source);
    }
}

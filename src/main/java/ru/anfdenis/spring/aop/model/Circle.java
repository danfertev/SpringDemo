package ru.anfdenis.spring.aop.model;

/**
 * Denis Anfertev
 * 23.12.12 22:10
 */
public class Circle extends Shape {
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public String setNameAndReturn(String name) {
        super.setName(name);
        System.out.println("Circle's setter called");
        return name;
    }
}

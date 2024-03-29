package ru.anfdenis.spring.data.model;

/**
 * Denis Anfertev
 * 26.12.12 20:53
 */
public class Circle {
    private int id;
    private String name;

    public Circle(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

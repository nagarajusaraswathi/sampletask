package com.example.example.Task2.model;


public class Parent {
    private String id;
    private String parentId;
    private String name;
    private String color;

    public Parent() {
    }

    public Parent(String id, String parentId, String name, String color) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

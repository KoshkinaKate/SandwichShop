package com.FreshFit.components;

public class Bread {
    private String type;

    public Bread(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Bread{" +
                "type='" + type + '\'' +
                '}';
    }
}
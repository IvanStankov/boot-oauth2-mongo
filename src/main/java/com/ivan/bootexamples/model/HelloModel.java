package com.ivan.bootexamples.model;

public class HelloModel {

    private final String name;
    private final String text;

    public HelloModel(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }
}

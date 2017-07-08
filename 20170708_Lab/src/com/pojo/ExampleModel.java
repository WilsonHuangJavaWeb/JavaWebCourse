package com.pojo;

/**
 * Created by Nobody on 2017/7/8.
 */
public class ExampleModel {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getNameLength() {
        System.out.println("getNameLength()...");
        return name.length();
    }
}

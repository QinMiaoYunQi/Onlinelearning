package com.javen.model;

public class Work {
    private String name;
    private String className;
    private String data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Work{" +
                "name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
